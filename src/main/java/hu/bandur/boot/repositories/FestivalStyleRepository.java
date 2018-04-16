package hu.bandur.boot.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.entities.FestivalStyle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FestivalStyleRepository extends CrudRepository<FestivalStyle, Integer>{

    List<FestivalStyle> findFestivalStyleByFestival(Festival festival);
    List<FestivalStyle> findFestivalStyleByStyleLike(String style);


}
