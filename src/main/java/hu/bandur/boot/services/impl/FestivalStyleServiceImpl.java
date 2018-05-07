package hu.bandur.boot.services.impl;

import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.entities.FestivalStyle;
import hu.bandur.boot.repositories.FestivalStyleRepository;
import hu.bandur.boot.services.FestivalStyleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("festivalStyleService")
public class FestivalStyleServiceImpl implements FestivalStyleService {

    private FestivalStyleRepository festivalStyleRepository;
/*    private FestivalRepository festivalRepository;

    @Autowired
    public void setFestivalRepository(FestivalRepository festivalRepository) {
        this.festivalRepository = festivalRepository;
    }
*/
    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setFestivalStyleRepository(FestivalStyleRepository festivalStyleRepository) {
        this.festivalStyleRepository = festivalStyleRepository;
    }

    @Override
    public List<FestivalDTO> findAllFestivalByStyleName(String s) {
        List<FestivalStyle> list =findFestivalStylesByStyleName(s);
        List<FestivalDTO> festivals = new ArrayList<>();
        for (FestivalStyle fs : list){
            System.out.println(fs.getFestival().getEndDate().getTime() + "  " + new Date().getTime());
            if( fs.getFestival().getEndDate().getTime() > new Date().getTime() && !festivals.contains(fs.getFestival()))
                festivals.add(modelMapper.map(fs.getFestival(), FestivalDTO.class));
        }
        return festivals;
    }

    @Override
    public List<FestivalStyle> findFestivalStylesByStyleName(String s) {
        String string = "%" + s +"%";
        return festivalStyleRepository.findFestivalStyleByStyleLike(string);
    }
}
