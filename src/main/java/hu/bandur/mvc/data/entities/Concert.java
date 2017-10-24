package hu.bandur.mvc.data.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Concert {
	
	private int artistID;
	private int festID;
	private int id;
	private Date begin;

}
