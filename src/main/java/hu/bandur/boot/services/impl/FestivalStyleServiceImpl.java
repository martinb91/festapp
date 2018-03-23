package hu.bandur.boot.services.impl;

import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.entities.FestivalStyle;
import hu.bandur.boot.repositories.FestivalStyleRepository;
import hu.bandur.boot.services.FestivalStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    @Autowired
    public void setFestivalStyleRepository(FestivalStyleRepository festivalStyleRepository) {
        this.festivalStyleRepository = festivalStyleRepository;
    }

    @Override
    public List<Festival> findAllFestivalByStyleName(String s) {
        List<FestivalStyle> list =findFestivalStylesByStyleName(s);
        List<Festival> festivals = new ArrayList<Festival>();
        for (FestivalStyle fs : list){
            if(!festivals.contains(fs.getFestival()))
                festivals.add(fs.getFestival());
        }
        return festivals;
    }

    @Override
    public List<FestivalStyle> findFestivalStylesByStyleName(String s) {
        String string = "%" + s +"%";
        return festivalStyleRepository.findFestivalStyleByStyleLike(string);
    }
}
