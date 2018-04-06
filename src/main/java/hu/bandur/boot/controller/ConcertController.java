package hu.bandur.boot.controller;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.dto.ConcertDTO;
import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Concert;
import hu.bandur.boot.services.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/concert")
public class ConcertController {

	//addModifyDeleteConcerts OK
	//allConcert OK
	//concersBetwenTwoDates OK
	//concertsByArtistName OK
	//concertsByFestivalName OK
	//egy olyan felületet képzelek el a felvitelnél, és a módosításhoz, ahol buborékban vannak a fesztiválhoz már felvitt koncertek
	//új buborékokat lehet kérni a felvitelhez, egy piros X-szel törölni a már meglévőket, de itt még nem történne módosítás
	// és a mentéskor aktualizálódnának a rekordok
	// ha módosítás vagy törlés vagy új hozzáadása történt akkor törlök először mindenn rekordot(where festival_id='adott fesztivál' )
	// és újra lementjük
	//Itt érdemes lehet nem átnyomni az összes előadót mindennel együtt, elég lehet csak az id, és/vagy a név.
	// EZ NEM ÍGY TÖRTÉNT, DE VALSZEG KINULLÁZOM
	// JSON-BA A TÖBBI ÉRTÉKET

	private ConcertService concertService;

	@Autowired
	public void setConcertService(ConcertService concertService) {
		this.concertService = concertService;
	}

	@RequestMapping("/add")
	public void addConcerts(@RequestBody List<ConcertDTO> concertDTOS){
		concertService.addConcertsForFestival(concertDTOS);
	}

	@RequestMapping("/modify")
	public void modifyConcerts(@RequestBody List<ConcertDTO> concertDTOS){
		addConcerts(concertDTOS);
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Concert> allConcerts(){
		return concertService.findAllConcerts();
	}

	@RequestMapping("/betweenDates")
	public List<Concert> ConcertsbetweenDates(@RequestBody Date after, @RequestBody Date before) {
		return concertService.betweenDates(after, before);
	}

	@RequestMapping(path="/byArtist/{id}" )
	public List<Concert> ConcertsByArtistName(@PathVariable int id) {
		return concertService.ConcertsByArtistId(id);
	}

	@RequestMapping("/byFest")
	public List<Concert> ConcertsByFest(@RequestBody FestivalDTO festivalDTO) {
		return concertService.ConcertsByFestName(festivalDTO);
	}
}
