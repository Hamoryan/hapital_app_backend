package AppProject.hopital.controller;

import AppProject.hopital.controller.api.MedicamentPatientApi;
import AppProject.hopital.dto.MedicamentPatientDto;
import AppProject.hopital.service.MedicamentPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class MedicamentPatientController implements MedicamentPatientApi {

    private final MedicamentPatientService medicamentPatientService;

    @Override
    public MedicamentPatientDto save(MedicamentPatientDto dto) {
        return medicamentPatientService.save(dto);
    }

    @Override
    public MedicamentPatientDto update(MedicamentPatientDto dto) {
        return medicamentPatientService.update(dto);
    }

    @Override
    public void delete(Long id) {
        medicamentPatientService.delete(id);
    }

    @Override
    public MedicamentPatientDto getById(Long id) {
        return medicamentPatientService.getById(id);
    }

    @Override
    public List<MedicamentPatientDto> getAll() {
        return medicamentPatientService.getAll();
    }
}
