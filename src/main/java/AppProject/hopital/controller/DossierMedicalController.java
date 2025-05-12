package AppProject.hopital.controller;

import AppProject.hopital.controller.api.DossierMedicalApi;
import AppProject.hopital.dto.DossierMedicalDto;
import AppProject.hopital.service.DossierMedicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class DossierMedicalController implements DossierMedicalApi {

    private final DossierMedicalService dossierMedicalService;

    @Override
    public DossierMedicalDto saveDossier(DossierMedicalDto dto) {
        return dossierMedicalService.saveDossier(dto);
    }

    @Override
    public DossierMedicalDto updateDossier(DossierMedicalDto dto) {
        return dossierMedicalService.updateDossier(dto);
    }

    @Override
    public DossierMedicalDto getDossierById(Long id) {
        return dossierMedicalService.getDossierById(id);
    }

    @Override
    public List<DossierMedicalDto> getAllDossier() {
        return dossierMedicalService.getAllDossier();
    }

    @Override
    public void deleteDossier(Long id) {
        dossierMedicalService.deleteDossier(id);
    }
}
