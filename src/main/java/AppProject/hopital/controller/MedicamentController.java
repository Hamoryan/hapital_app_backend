package AppProject.hopital.controller;

import AppProject.hopital.controller.api.MedicamentsApi;
import AppProject.hopital.dto.MedicamentsDto;
import AppProject.hopital.service.MedicamentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class MedicamentController implements MedicamentsApi {

    private final MedicamentsService medicamentsService;

    @Override
    @PreAuthorize("hasRole('PHARMACIEN')")
    public MedicamentsDto createMedicaments(MedicamentsDto dto) {
        return medicamentsService.createMedicament(dto);
    }

    @Override
    @PreAuthorize("hasRole('PHARMACIEN')")
    public MedicamentsDto updateMedicaments(MedicamentsDto dto) {
        return medicamentsService.updateMedicament(dto);
    }

    @Override
    @PreAuthorize("hasAnyRole('PHARMACIEN','ADMINISTRATEUR')")
    public MedicamentsDto getMedicamentById(Long id) {
        return medicamentsService.getMedicamentById(id);
    }

    @Override
    @PreAuthorize("hasAnyRole('PHARMACIEN','ADMINISTRATEUR')")
    public List<MedicamentsDto> getAllMedicaments() {
        return medicamentsService.getAllMedicaments();
    }

    @Override
    @PreAuthorize("hasRole('PHARMACIEN')")
    public void deleteMedicament(Long id) {
        medicamentsService.deleteMedicament(id);
    }

    @Override
    @PreAuthorize("hasRole('PHARMACIEN')")
    public MedicamentsDto augmenterStock(Long id, int quantite) {
        return medicamentsService.augmenterStock(id, quantite);
    }

    @Override
    @PreAuthorize("hasRole('PHARMACIEN')")
    public MedicamentsDto diminuerStock(Long id, int quantite) {
        return medicamentsService.diminuerStock(id, quantite);
    }
}
