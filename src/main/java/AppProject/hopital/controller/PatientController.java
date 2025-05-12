package AppProject.hopital.controller;

import AppProject.hopital.controller.api.PatientApi;
import AppProject.hopital.dto.PatientDto;
import AppProject.hopital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class PatientController implements PatientApi {
    private final PatientService patientService;

    @Override
    public PatientDto getPatientById(Long id) {
        return patientService.getPatientById(id);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        return patientService.getAllPatients();
    }

    @Override
    public PatientDto createdPatient(PatientDto dto) {
        return patientService.createdPatient(dto);
    }

    @Override
    public PatientDto UpdatePatient(PatientDto dto) {
        return patientService.UpdatePatient(dto);
    }

    @Override
    public void changeStatutPatient(Long id) {
        patientService.changeStatutPatient(id);
    }
}
