package AppProject.hopital.mapper;

import AppProject.hopital.dto.PatientDto;
import AppProject.hopital.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientDto entitytoDto(Patient entity);

    Patient dtoToEntity(PatientDto dto);
}
