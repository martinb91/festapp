package hu.bandur.boot.mapper;

import hu.bandur.boot.dto.ConcertDTO;
import hu.bandur.boot.entities.Concert;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConcertMapper {

    public ConcertDTO toDTO(Concert concert);

    public Concert toEntity(ConcertDTO concertDTO);

    public void mapToEntity(ConcertDTO concertDTO, @MappingTarget Concert concert);

}
