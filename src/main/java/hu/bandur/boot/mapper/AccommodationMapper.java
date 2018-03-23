package hu.bandur.boot.mapper;

import hu.bandur.boot.dto.AccommodationDTO;
import hu.bandur.boot.entities.Accommodation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccommodationMapper {

    public AccommodationDTO toDTO(Accommodation accommodation);

    public Accommodation toEntity(AccommodationDTO accommodationDTO);

    public void mapToEntity(AccommodationDTO accommodationDTO, @MappingTarget Accommodation accommodation);

}
