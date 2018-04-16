package hu.bandur.boot.controller;

import hu.bandur.boot.dto.AccommodationDTO;
import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Accommodation;
import hu.bandur.boot.services.AccommodationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {

    private AccommodationService accommodationService;
    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setAccommodationService(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @RequestMapping(path = "/new.json", method = RequestMethod.POST)
    public void add(@RequestBody AccommodationDTO newA){
        accommodationService.addAccommodation(newA);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<AccommodationDTO> FindAll() {
        List<AccommodationDTO> accommodationDTOS = new ArrayList<>();
        for (Accommodation a : accommodationService.findAccommodations()) {
            accommodationDTOS.add(modelMapper.map(a, AccommodationDTO.class));
        }
        return accommodationDTOS;
    }

    @RequestMapping(path = "/nearTheFest/{id}", method = RequestMethod.GET)
    public List<AccommodationDTO> FindAllWhatNearTheFest(@PathVariable int id){
        return accommodationService.FindAllWhatNearTheFest(id);
    }

    //---- Ezeket még aktualizálni
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


    //ModifyAcc
    //ByName or ByCity

}
