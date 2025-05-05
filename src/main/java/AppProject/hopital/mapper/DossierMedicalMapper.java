package AppProject.hopital.mapper;

import AppProject.hopital.dto.DossierMedicalDto;
import AppProject.hopital.entity.DossierMedical;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DossierMedicalMapper {

    @Mapping(source = "patient.idPatient", target = "patientId")
    DossierMedicalDto entityToDto(DossierMedical entity);

    @Mapping(source = "patientId", target = "patient.idPatient")
    DossierMedical dtoToEntity(DossierMedicalDto dto);
}
