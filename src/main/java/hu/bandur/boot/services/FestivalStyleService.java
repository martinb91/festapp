package hu.bandur.boot.services;

import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.entities.FestivalStyle;

import java.util.List;

public interface FestivalStyleService {
    List<Festival> findAllFestivalByStyleName(String s);
    List<FestivalStyle> findFestivalStylesByStyleName(String s);
}
