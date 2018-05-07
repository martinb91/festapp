package hu.bandur.boot.repositories;

import hu.bandur.boot.entities.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ArtistRepository extends CrudRepository<Artist, Integer>{

    List<Artist> findAll();
    List<Artist> findByNameLike(String name);
    int deleteById(int id);

/*    @Query("select a from Artist where a.styles.style = ?1 ")
    List<Artist> findAllByStyles(String style);*/

}
