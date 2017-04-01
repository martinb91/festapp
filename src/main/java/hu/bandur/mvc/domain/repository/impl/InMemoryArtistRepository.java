package hu.bandur.mvc.domain.repository.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.net.SyslogAppender;
import org.springframework.stereotype.Repository;

import hu.bandur.mvc.domain.repository.ArtistRepository;
import hu.bandur.mvc.data.entities.*;

@Repository
public class InMemoryArtistRepository implements ArtistRepository {

	private List<Artist> listOfArtist = new ArrayList<Artist>();

	public InMemoryArtistRepository() {
		
		MusicStyle rock= new MusicStyle();
		MusicStyle punk= new MusicStyle();
		MusicStyle speed= new MusicStyle();
		MusicStyle folk= new MusicStyle();
		MusicStyle amateaur= new MusicStyle();
		MusicStyle metal= new MusicStyle();
		
		rock.setStyle("rock");
		punk.setStyle("punk");
		speed.setStyle("speed");
		folk.setStyle("folk");
		amateaur.setStyle("amatõr");
		metal.setStyle("metal");
		
		List<MusicStyle> leanderStyles = new ArrayList<MusicStyle>();
		leanderStyles.add(rock);
		leanderStyles.add(metal);
		
		List<MusicStyle> bohemianStyles = new ArrayList<MusicStyle>();
		bohemianStyles.add(speed);
		bohemianStyles.add(folk);
		bohemianStyles.add(punk);
		
		List<MusicStyle> dlrmStyles = new ArrayList<MusicStyle>();
		dlrmStyles.add(rock);
		dlrmStyles.add(punk);
		dlrmStyles.add(amateaur);
		
		Artist leander = new Artist();
		leander.setId(2);
		leander.setName("Leander Rising");
		leander.setDescription("Népszerû magyar zenekar.");

		Artist bohemianB = new Artist();
		bohemianB.setId(1);
		bohemianB.setName("Bohemian Betyars");
		bohemianB.setDescription("Nemzetközileg is elismert magyar folk-punk zenekar");

		Artist dlrm = new Artist();
		dlrm.setName("Delirium");
		dlrm.setDescription("Amatõr folk-pop-rock zenekar");
		dlrm.setId(3);
		
		leander.setMusicStyleList(leanderStyles);
		dlrm.setMusicStyleList(dlrmStyles);
		bohemianB.setMusicStyleList(bohemianStyles);
		
		listOfArtist.add(leander);
		listOfArtist.add(bohemianB);
		listOfArtist.add(dlrm);
		System.out.println(listOfArtist.get(2).getName());

	}

	public List<Artist> getAllArtists() {
		return listOfArtist;
	}

	@Override
	public Artist getArtistByName(String name) {
		Artist artistByName =null;
		for (Artist a : listOfArtist){
			if(a!=null && a.getName()!=null && a.getName().equals(name)){
		        artistByName = a;
		        break;
		      }	
		}
			
		if(artistByName == null){
		      throw new IllegalArgumentException("No artists found with the name: "+ name);
		    }
		
		return artistByName;
	}
	
	@Override
	public Artist getArtistById(String sid) {
		int id=-1;
		try{
			id = Integer.parseInt(sid);
			
		}catch (Exception e) {
			 System.out.println("NaN exception");
		}
		
		Artist artistByID =null;
		for (Artist a : listOfArtist){
			if(a!=null && a.getId()>-1 && a.getId()==id){
		        artistByID = a;
		        break;
		      }	
		}
		if(artistByID == null){
		      throw new IllegalArgumentException("No artists found with the name: "+ id);
		    }
		
		return artistByID;
	}

	@Override
	public List<Artist> getArtistsByCategory(String category) {
	List<Artist> artistsByCategory = new ArrayList<Artist>();
	for(Artist a : listOfArtist){
		for ( MusicStyle ms: a.getMusicStyleList()){
			if(ms.getStyle().equals(category)){
				artistsByCategory.add(a);
				break;
			}
		}
	}
		return artistsByCategory;
	}
	
	public Set<Artist> getArtistsByFilter(Map<String, List<String>> filterParams) {
	    Set<Artist> artistsByName = new HashSet<Artist>();
	    Set<Artist> artistsByCategory = new HashSet<Artist>();
	    Set<String> criterias = filterParams.keySet();
	    //System.out.println(criterias.isEmpty());
	    if(criterias.contains("name")) {
	      for(String name: filterParams.get("name")) {	  	    
	        for(Artist artist: listOfArtist) {
	          if(name.equalsIgnoreCase(artist.getName())){
	        	  artistsByName.add(artist);
	          }
	        }
	      }
	    }
	    
	    if(criterias.contains("category")) {
	      for(String category: filterParams.get("category")) {
	    	  artistsByCategory.addAll(this.getArtistsByCategory(category));
	      }
	    }
	    
	    artistsByCategory.retainAll(artistsByName);
	    
	    return artistsByCategory;
	}
	
	public void addArtist(Artist a) {
		   listOfArtist.add(a);
		}
	
}
