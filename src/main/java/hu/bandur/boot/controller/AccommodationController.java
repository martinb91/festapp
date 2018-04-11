package hu.bandur.boot.controller;

import hu.bandur.boot.dto.AccommodationDTO;
import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Accommodation;
import hu.bandur.boot.services.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {

    AccommodationService accommodationService;

    @Autowired
    public void setAccommodationService(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @RequestMapping(path = "/new.json", method = RequestMethod.POST)
    public void add(@RequestBody AccommodationDTO newA){
        accommodationService.addAccommodation(newA);
    }

    @RequestMapping(path = "/nearTheFest", method = RequestMethod.POST)
    public List<Accommodation> FindAllWhatNearTheFest(@RequestBody FestivalDTO festival){
        return accommodationService.FindAllWhatNearTheFest(festival);
    }

    //ModifyAcc
    //ByName or ByCity

    @RequestMapping(path = "/modify", method = RequestMethod.PUT)
    public void modifyAccommodation(@RequestBody AccommodationDTO accommodationDTO){
        accommodationService.modifyAccommodation(accommodationDTO);
    }

    @RequestMapping(path = "/byName", method = RequestMethod.POST)
    public List<Accommodation> FindByName(@RequestBody AccommodationDTO accommodationDTO){
       return accommodationService.findByName(accommodationDTO);
    }

    @RequestMapping(path = "/byCity", method = RequestMethod.POST)
    public List<Accommodation> FindByAddress(@RequestBody AccommodationDTO accommodationDTO){
        return accommodationService.findByAddress(accommodationDTO);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Accommodation> FindAll(){
        return accommodationService.findAccommodations();
    }
}
