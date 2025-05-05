package AppProject.hopital.controller.api;

import AppProject.hopital.dto.DossierMedicalDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/dossierMedical")
public interface DossierMedicalApi {

    @PostMapping("/saveDossier")
    DossierMedicalDto saveDossier(@RequestBody DossierMedicalDto dto);

    @PutMapping("/updateDossier")
    DossierMedicalDto updateDossier(@RequestBody DossierMedicalDto dto);

    @GetMapping("/getDossierById/{id}")
    DossierMedicalDto getDossierById(@PathVariable Long id);

    @GetMapping("/getAllDossier")
    List<DossierMedicalDto> getAllDossier();

    @DeleteMapping("/deleteDossier/{id}")
    void deleteDossier(@PathVariable Long id);

}
