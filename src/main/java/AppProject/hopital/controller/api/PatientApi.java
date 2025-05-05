package AppProject.hopital.controller.api;

import AppProject.hopital.dto.PatientDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/Patient")
public interface PatientApi {

    @GetMapping("/getPatientById/{id}")
    PatientDto getPatientById(@PathVariable Long id);

    @GetMapping("/getAllPatient")
    List<PatientDto> getAllPatients();

    @PostMapping("/createdPatient")
    PatientDto createdPatient(@RequestBody PatientDto dto);

    @PutMapping ("/UpdatePatient")
    PatientDto UpdatePatient( @RequestBody PatientDto dto);

    @DeleteMapping("/changeStatutPatient/{id}")
    void changeStatutPatient(@PathVariable Long id);
}
