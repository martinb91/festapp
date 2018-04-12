package hu.bandur.boot.repositories;

import hu.bandur.boot.entities.Concert;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ConcertRepository extends CrudRepository<Concert, Integer>{

    List<Concert> findAll();
    void deleteByFestival_Id(int id);
    List<Concert> findConcertsByArtist_Name(String string);
    List<Concert> findConcertsByFestival_Name(String string);
    List<Concert> findByArtist_Id(int id);

    List<Concert> findByFestival_Id(int id);

}
