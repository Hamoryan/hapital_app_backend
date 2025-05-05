package AppProject.hopital.service;

import AppProject.hopital.dto.MedicamentPatientDto;

import java.util.List;

public interface MedicamentPatientService {
    MedicamentPatientDto    save(MedicamentPatientDto dto);

    MedicamentPatientDto update(MedicamentPatientDto dto);

    void delete(Long id);

    MedicamentPatientDto getById(Long id);

    List<MedicamentPatientDto> getAll();
}
