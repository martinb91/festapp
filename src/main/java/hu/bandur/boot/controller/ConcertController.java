package hu.bandur.boot.controller;

import hu.bandur.boot.dto.ConcertDTO;
import hu.bandur.boot.services.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/concert")
public class ConcertController {

	private ConcertService concertService;

	@Autowired
	public void setConcertService(ConcertService concertService) {
		this.concertService = concertService;
	}

	@RequestMapping(path="/byArtist/{id}" )
	public List<ConcertDTO> ConcertsByArtistId(@PathVariable int id) {
		return concertService.ConcertsByArtistId(id);
	}

	@RequestMapping(path="/byEvent/{id}" )
	public List<ConcertDTO> ConcertsByEventId(@PathVariable int id) {
		return concertService.ConcertsByEventId(id);
	}

	@RequestMapping(path="/new.json", method = RequestMethod.POST)
	public void addConcert(@RequestBody ConcertDTO concertDTO){
		concertService.addConcert(concertDTO);
	}

/*	@RequestMapping("/byFest")
	public List<Concert> ConcertsByFest(@RequestBody FestivalDTO festivalDTO) {
		return concertService.ConcertsByFestName(festivalDTO);
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
	}*/
}
