package hu.bandur.boot.repositories;

import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.entities.FestivalStyle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FestivalStyleRepository extends CrudRepository<FestivalStyle, Integer>{

    List<FestivalStyle> findFestivalStyleByFestival(Festival festival);

    List<FestivalStyle> findFestivalStyleByStyleLike(String style);

    @Query("select fs from FestivalStyle fs where lower(fs.style) like lower(:myStyle)")
    List<FestivalStyle> findByStyleContainingIgnoreCase(@Param("myStyle") String myStyle);




}
