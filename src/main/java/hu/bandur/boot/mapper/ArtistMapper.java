package hu.bandur.boot.mapper;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.entities.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArtistMapper {

    public ArtistDTO toDTO(Artist artist);

    public Artist toEntity(ArtistDTO artistDTO);

    public void mapToEntity(ArtistDTO artistDTO, @MappingTarget Artist artist);

}
