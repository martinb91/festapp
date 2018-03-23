package hu.bandur.boot.repositories;

import hu.bandur.boot.entities.Accommodation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AccommodationRepository extends CrudRepository<Accommodation, Integer>{

    List<Accommodation> findAll();
    List<Accommodation> findByAddress_City(String string);
    List<Accommodation> findByName(String string);
}
