package hu.bandur.boot.mapper;

import hu.bandur.boot.dto.PositionDTO;
import hu.bandur.boot.entities.Position;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PositionMapper {

    public PositionDTO toDTO(Position position);

    public Position toEntity(PositionDTO positionDTO);

    public void mapToEntity(PositionDTO positionDTO, @MappingTarget Position position);

}
