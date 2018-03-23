package hu.bandur.boot.mapper;

import hu.bandur.boot.dto.MusicStyleDTO;
import hu.bandur.boot.entities.MusicStyle;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MusicStyleMapper {

    public MusicStyleDTO toDTO(MusicStyle musicStyle);

    public MusicStyle toEntity(MusicStyleDTO musicStyleDTO);

    public void mapToEntity(MusicStyleDTO musicStyleDTO, @MappingTarget MusicStyle musicStyle);

}
