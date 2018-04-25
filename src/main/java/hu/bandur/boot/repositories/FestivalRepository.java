package hu.bandur.boot.repositories;

import hu.bandur.boot.entities.Festival;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;


public interface FestivalRepository extends CrudRepository<Festival, Integer>{

 List<Festival> findAll();
 List<Festival> findByBeginDateBefore(Date end);
 List<Festival> findByEndDateAfter(Date begin);
 List<Festival> findByEndDateAfterAndBeginDateBefore(Date begin, Date end);

 @Query("select f from Festival f inner join f.styles stl where lower(stl.style) like lower(:myStyle) and f.beginDate <= :end")
 List<Festival> findByBeginDateBeforeAndStyle(@Param("myStyle")String style, @Param("end")Date end);

 @Query("select f from Festival f inner join f.styles stl where lower(stl.style) like lower(:myStyle) and f.endDate >= :begin")
 List<Festival> findByEndDateAfterAndStyle(@Param("myStyle")String style, @Param("begin")Date begin);

 @Query("select f from Festival f inner join f.styles stl where lower(stl.style) like lower(:myStyle) and f.endDate >= :begin and f.beginDate <= :end")
 List<Festival> findByBeginDateBeforeAndEndDateAfterAndStyle(@Param("myStyle")String style, @Param("begin")Date begin, @Param("end")Date end);

 }
