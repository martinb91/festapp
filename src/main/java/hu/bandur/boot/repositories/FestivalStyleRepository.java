package hu.bandur.boot.repositories;

import hu.bandur.boot.entities.FestivalStyle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FestivalStyleRepository extends CrudRepository<FestivalStyle, Integer>{

    List<FestivalStyle> findFestivalStyleByStyleLike(String style);

}
