package hu.bandur.boot.services.impl;

import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.*;
import hu.bandur.boot.math.Haversine;
import hu.bandur.boot.pictureHandler.storage.StoreFileService;
import hu.bandur.boot.repositories.FestivalRepository;
import hu.bandur.boot.repositories.FestivalStyleRepository;
import hu.bandur.boot.repositories.PositionRepository;
import hu.bandur.boot.services.FestivalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component("festivalService")
@Transactional
public class FestivalServiceImpl implements FestivalService, StoreFileService {
    private FestivalRepository festivalRepository;
    private PositionRepository positionRepository;
    private FestivalStyleRepository festivalStyleRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setFestivalRepository(FestivalRepository festivalRepository) {
        this.festivalRepository = festivalRepository;
    }

    @Autowired
    public void setPositionRepository(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Autowired
    public void setFestivalStyleRepository(FestivalStyleRepository festivalStyleRepository) {
        this.festivalStyleRepository = festivalStyleRepository;
    }

    public List<Festival> findAllFestival() {
//        List<Festival> festivals = this.festivalRepository.findAll();
        List<Festival> festivals = festivalRepository.findByEndDateAfter(new Date(new Date().getTime() -1));
        return festivals;
    }

    @Override
    public Festival findById(int id) {
        return festivalRepository.findOne(id);
    }

    @Override
    public List<Festival> getFestivalsByStyleName(String styleName) {
        List<FestivalStyle> festivalStyles = festivalStyleRepository.findByStyleContainingIgnoreCase(styleName);
        List<Festival> festivals = new ArrayList<>();
        for (FestivalStyle festivalStyle : festivalStyles) {
            festivals.add(festivalStyle.getFestival());
        }
        return festivals;
    }

    @Override
    public void changeStyles(Festival festival) {
        List<FestivalStyle> fs = new ArrayList<>();
        for (FestivalStyle festivalStyle : festivalStyleRepository.findFestivalStyleByFestival(festival)) {
            boolean var = false;
            for (FestivalStyle m : festival.getStyles()) {
                if (m.getId() == festivalStyle.getId() && !m.getStyle().equals("")) {
                    var = true;
                    break;
                }
            }
            if (!var) {
                fs.add(festivalStyle);
            }
        }
        festivalStyleRepository.delete(fs);
        addStyles(festival);
    }

    @Override
    public void addStyles(Festival festival) {
        for (FestivalStyle fs : festival.getStyles()) {
            if (fs.getStyle() != null && !fs.getStyle().equals("")) {
                if (fs.getId() == 0 || ((Integer) fs.getId()) == null) {
                    festivalStyleRepository.save(new FestivalStyle(fs.getStyle(), festival));
                } else {
                    fs.setFestival(festival);
                    festivalStyleRepository.save(fs);
                }
            }
        }
    }

    @Override
    public Festival addFestival(Festival fest) {
        positionRepository.save(fest.getPosition());
        festivalRepository.save(fest);
        changeStyles(fest);
        return fest;
    }


    @Override
    public Festival updateFestival(Festival festival) {
        festival.setPicture(festivalRepository.findOne(festival.getId()).getPicture());
        return addFestival(festival);
    }

    @Override
    public List<FestivalDTO> festsByQuery(String style, boolean isFree, Date begin, Date end, Double posX, Double posY, Double maxFromPos) {
        List<Festival> festivals = new ArrayList<>();
        if (style == null) {
            if (!isFree) {
                festivals = datesWithoutStyle(begin, end, posX, posY, maxFromPos);
            } else {
                festivals = datesWithStyle("free", begin, end, posX, posY, maxFromPos);
            }
        } else {
            if (!isFree) {
                festivals = datesWithStyle(style, begin, end, posX, posY, maxFromPos);
            } else {
                for (Festival festival : datesWithStyle(style, begin, end, posX, posY, maxFromPos)){
                    System.out.println(festival.getName());
                    for (FestivalStyle festivalStyle : festival.getStyles()){
                        if(festivalStyle.getStyle().toLowerCase().equals("free")){
                            festivals.add(festival);
                        }
                    }
                }
            }
        }

        List<FestivalDTO> festivalDTOS = new ArrayList<>();
        for (Festival festival : festivals) {
            System.out.println(festival.getName());
            festivalDTOS.add(modelMapper.map(festival, FestivalDTO.class));
        }
        return festivalDTOS;
    }


    private boolean isShorterWithHaversine(Festival festival, Double posX, Double posY, Double maxFromPos) {
        System.out.println(Haversine.distance(festival.getPosition().getX(), festival.getPosition().getY(), posX, posY));
        return Haversine.distance(festival.getPosition().getX(), festival.getPosition().getY(), posX, posY) < maxFromPos;
    }

    private List<Festival> workWithPositions(List<Festival> allFestivals, Double posX, Double posY, Double maxFromPos) {
        List<Festival> festivals = new ArrayList<>();
        if (posX == null) {
            return allFestivals;
        } else {
            if (maxFromPos == null) {
                for (Festival festival : allFestivals) {
                    if (isShorterWithHaversine(festival, posX, posY, 5.0)) {
                        festivals.add(festival);
                    }
                }
            } else {
                for (Festival festival : allFestivals) {
                    if (isShorterWithHaversine(festival, posX, posY, maxFromPos)) {
                        festivals.add(festival);
                    }
                }
            }
        }
        return festivals;
    }

    private List<Festival> datesWithoutStyle(Date begin, Date end, Double posX, Double posY, Double maxFromPos) {
        List<Festival> festivals;
        if (begin == null) {
            if (end == null) {
//                festivals = workWithPositions(festivalRepository.findAll(), posX, posY, maxFromPos);
                festivals = festivalRepository.findByEndDateAfter(new Date(new Date().getTime() -1));
            } else {
//                festivals = festivalRepository.findByBeginDateBefore(new Date(end.getTime() + 1)); // lecseréltem, hogy az elmúlottakat már ne mutassa.
                festivals = festivalRepository.findByEndDateAfterAndBeginDateBefore(new Date(new Date().getTime() -1), new Date(end.getTime() + 1));
            }
        } else {
            if (end == null) {
                festivals = festivalRepository.findByEndDateAfter(new Date(begin.getTime() - 1));
            } else {
                festivals = festivalRepository.findByEndDateAfterAndBeginDateBefore(new Date(begin.getTime() - 1), new Date(end.getTime() + 1));
            }
        }
        return workWithPositions(festivals, posX, posY, maxFromPos);
    }

    private List<Festival> datesWithStyle(String style, Date begin, Date end, Double posX, Double posY, Double maxFromPos) {
        List<Festival> festivals;
        if (begin == null) {
            if (end == null) {
                /*List<FestivalStyle> festivalStyles = festivalStyleRepository.findByStyleContainingIgnoreCase(style);
                for (FestivalStyle festivalStyle : festivalStyles) {
                    festivals.add(festivalStyle.getFestival());
                }*/
                festivals = festivalRepository.findByEndDateAfterAndStyle(style, new Date());
            } else {
//                festivals = festivalRepository.findByBeginDateBeforeAndStyle(style, end);
                festivals = festivalRepository.findByBeginDateBeforeAndEndDateAfterAndStyle(style, new Date(), end);
            }
        } else {
            if (end == null) {
                festivals = festivalRepository.findByEndDateAfterAndStyle(style, begin);
            } else {
                festivals = festivalRepository.findByBeginDateBeforeAndEndDateAfterAndStyle(style, begin, end);

            }
        }
        festivals = workWithPositions(festivals, posX, posY, maxFromPos);
        return festivals;
    }

    @Override
    public void storeFile(MultipartFile file, int id) {
        String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        try {
            System.out.println("itt");
            String newName =  currentDate + file.getOriginalFilename();
            Files.copy(file.getInputStream(), this.rootLocation.resolve(newName));
            Festival festival = festivalRepository.findOne(id);
            festival.setPicture(newName);
            festivalRepository.save(festival);
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }
}
