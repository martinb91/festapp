package hu.bandur.mvc.data.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONCERTS")
public class Concert {
	
	@OneToOne
	private Artist fk_artist;
	@OneToOne
	private Festival fk_festival;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date begin;

}
