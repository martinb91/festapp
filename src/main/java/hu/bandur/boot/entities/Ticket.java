package hu.bandur.boot.entities;

import java.util.Date;

public class Ticket {
	
	private String url;
	private int id;
	private double price;
	private String type;
	private Date beginDate;	// Általában minnél közelebb a fesztivál időpontja annál drágább a jegy.
	private Date endDate;
	
	// Rengeteg jegytípus létezik egy adott fesztiválhoz. Így maximum egy URL-t rendelek hozzá.
}
