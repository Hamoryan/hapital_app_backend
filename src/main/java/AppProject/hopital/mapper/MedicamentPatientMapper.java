package AppProject.hopital.mapper;

import AppProject.hopital.dto.MedicamentPatientDto;
import AppProject.hopital.entity.MedicamentPatient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicamentPatientMapper {
    @Mapping(source = "personnel.id", target = " idPersonnel")
    @Mapping(source = "medicaments.idMedicaments", target = " idMedicament")
    @Mapping(source = "dossierMedical.idDossierMed", target = " idDossierMedical")
    MedicamentPatientDto entityToDto(MedicamentPatient entity);

    @Mapping(source = "idPersonnel", target = "personnel.id")
    @Mapping(source = "idMedicament", target = "medicaments.idMedicaments")
    @Mapping(source = "idDossierMedical", target = "dossierMedical.idDossierMed")
    MedicamentPatient dtoToEntity(MedicamentPatientDto dto);
}
