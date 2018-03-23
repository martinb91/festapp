package hu.bandur.boot.mapper;

import hu.bandur.boot.dto.FestivalStyleDTO;
import hu.bandur.boot.entities.FestivalStyle;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FestivalStyleMapper {

    public FestivalStyleDTO toDTO(FestivalStyle festivalStyle);

    public FestivalStyle toEntity(FestivalStyleDTO festivalStyleDTO);

    public void mapToEntity(FestivalStyleDTO festivalStyleDTO, @MappingTarget FestivalStyle festivalStyle);

}