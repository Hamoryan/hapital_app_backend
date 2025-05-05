package AppProject.hopital.controller;

import AppProject.hopital.controller.api.MedicamentsApi;
import AppProject.hopital.dto.MedicamentsDto;
import AppProject.hopital.service.MedicamentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MedicamentController implements MedicamentsApi {

    private final MedicamentsService medicamentsService;

    @Override
    public MedicamentsDto createMedicaments(MedicamentsDto dto) {
        return medicamentsService.createMedicament(dto);
    }

    @Override
    public MedicamentsDto updateMedicaments(MedicamentsDto dto) {
        return medicamentsService.updateMedicament(dto);
    }

    @Override
    public MedicamentsDto getMedicamentById(Long id) {
        return medicamentsService.getMedicamentById(id);
    }

    @Override
    public List<MedicamentsDto> getAllMedicaments() {
        return medicamentsService.getAllMedicaments();
    }

    @Override
    public void deleteMedicament(Long id) {
        medicamentsService.deleteMedicament(id);
    }

    @Override
    public MedicamentsDto augmenterStock(Long id, int quantite) {
        return medicamentsService.augmenterStock(id, quantite);
    }

    @Override
    public MedicamentsDto diminuerStock(Long id, int quantite) {
        return medicamentsService.diminuerStock(id, quantite);
    }
}
