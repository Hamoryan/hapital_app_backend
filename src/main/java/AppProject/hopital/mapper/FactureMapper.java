package AppProject.hopital.mapper;

import AppProject.hopital.dto.FactureDto;
import AppProject.hopital.entity.Facture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FactureMapper {
    @Mapping(source = "patient.idPatient", target = "patientId")
    @Mapping(source = "personnel.id", target = "personnelId")
    FactureDto entityToDto(Facture entity);

    @Mapping(source = "patientId", target = "patient.idPatient")
    @Mapping(source = "personnelId", target = "personnel.id")
    Facture DtoToEntity(FactureDto dto);
}
