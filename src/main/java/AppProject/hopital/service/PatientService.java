package AppProject.hopital.service;

import AppProject.hopital.dto.PatientDto;
import AppProject.hopital.entity.Patient;

import java.util.List;

public interface PatientService {
    PatientDto createdPatient(PatientDto dto);
    PatientDto UpdatePatient(PatientDto dto);
    void changeStatutPatient(Long id);
    PatientDto getPatientById(Long id);

    List<PatientDto> getAllPatients();
}
