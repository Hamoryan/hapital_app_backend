package AppProject.hopital.service;

import AppProject.hopital.dto.DossierMedicalDto;

import java.util.List;

public interface DossierMedicalService {
    DossierMedicalDto saveDossier(DossierMedicalDto dto);

    DossierMedicalDto updateDossier(DossierMedicalDto dto);

    DossierMedicalDto getDossierById(Long id);

    List<DossierMedicalDto> getAllDossier();

    void deleteDossier(Long id);


}
