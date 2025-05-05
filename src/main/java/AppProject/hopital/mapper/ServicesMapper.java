package AppProject.hopital.mapper;

import AppProject.hopital.dto.ServicesDto;
import AppProject.hopital.entity.Services;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServicesMapper {
    @Mapping(source = "patient.idPatient", target = "idPatient")
    ServicesDto entityToDto(Services entity);
    @Mapping(source = "idPatient", target = "patient.idPatient")
    Services dtoToEntity(ServicesDto dto);
}
