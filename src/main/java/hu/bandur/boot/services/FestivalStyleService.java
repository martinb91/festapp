package hu.bandur.boot.services;

import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.entities.FestivalStyle;

import java.util.List;

public interface FestivalStyleService {
    List<FestivalDTO> findAllFestivalByStyleName(String s);
    List<FestivalStyle> findFestivalStylesByStyleName(String s);
}
