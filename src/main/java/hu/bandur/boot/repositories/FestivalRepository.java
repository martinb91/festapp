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
 List<Festival> findByEndDateAfterOrderByBeginDate(Date begin);
 List<Festival> findByEndDateAfterAndBeginDateBeforeOrderByBeginDate(Date begin, Date end);

 @Query("select f from Festival f inner join f.styles stl where lower(stl.style) like lower(:myStyle) and f.endDate >= :begin order by f.beginDate")
 List<Festival> findByEndDateAfterAndStyleOrderByBeginDate(@Param("myStyle")String style, @Param("begin")Date begin);

 @Query("select f from Festival f inner join f.styles stl where lower(stl.style) like lower(:myStyle) and f.endDate >= :begin and f.beginDate <= :end order by f.beginDate")
 List<Festival> findByBeginDateBeforeAndEndDateAfterAndStyleOrderByBeginDate(@Param("myStyle")String style, @Param("begin")Date begin, @Param("end")Date end);

 @Query("select f from Festival f inner join f.styles stl where lower(stl.style) like lower(:myStyle) and f.beginDate <= :end order by f.beginDate")
 List<Festival> findByBeginDateBeforeAndStyle(@Param("myStyle")String style, @Param("end")Date end);

 List<Festival> findByBeginDateBefore(Date end);
 }
