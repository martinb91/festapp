package hu.bandur.boot.mapper;

import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Festival;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FestivalMapper {

    public FestivalDTO toDTO(Festival festival);

    public Festival toEntity(FestivalDTO festivalDTO);

    public void mapToEntity(FestivalDTO festivalDTO, @MappingTarget Festival festival);

}
