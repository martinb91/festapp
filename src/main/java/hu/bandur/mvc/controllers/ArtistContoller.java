package hu.bandur.mvc.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hu.bandur.mvc.data.entities.Artist;
import hu.bandur.mvc.services.ArtistService;

@Controller
@RequestMapping("/artists")
public class ArtistContoller {

	@Autowired
	private ArtistService artistService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("artists", artistService.getAllArtists());
		return "artists";
	}

	// @RequestMapping("artist/{id}")
	// public @ResponseBody String returnById(Model model, @PathVariable("id")
	// String id) {
	// System.out.println(id);
	// // model.addAttribute("artists", artistService.getArtistById(id));
	// return artistService.getArtistById(id).getName() + "\n" +
	// artistService.getArtistById(id).getDescription();
	// // artistService.getArtistById(id);
	// // return "artists";
	// }

	// @RequestMapping("/all")
	// public String allArtists(Model model) {
	// model.addAttribute("artists", artistService.getAllArtists());
	// return "artists";
	// }

	@RequestMapping("/all")
	public ModelAndView allArtists() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("artists", artistService.getAllArtists());

		modelAndView.setViewName("artists");

		return modelAndView;
	}

	@RequestMapping("/{category}")
	public String getArtistByCategory(Model model, @PathVariable("category") String artistCategory) {
		model.addAttribute("artists", artistService.getArtistsByCategory(artistCategory));
		return "artists";
	}

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,
			Model model) {
		model.addAttribute("artists", artistService.getArtistsByFilter(filterParams));
		return "artists";
	}

	@RequestMapping("/artist")
	public String getArtistById(@RequestParam("id") String artistId, Model model) {
		model.addAttribute("artist", artistService.getArtistById(artistId));
		return "artist";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewArtistForm(Model model) {
		Artist newArtist = new Artist();
		model.addAttribute("newArtist", newArtist);
		return "addArtist";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewArtistForm(@ModelAttribute("newArtist") Artist newArtist) {
		artistService.addArtist(newArtist);
		return "redirect:/artists";
	}

}
