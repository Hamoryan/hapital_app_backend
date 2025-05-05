package AppProject.hopital.service;

import AppProject.hopital.dto.MedicamentsDto;

import java.util.List;

public interface MedicamentsService {

    MedicamentsDto createMedicament (MedicamentsDto dto);
    MedicamentsDto updateMedicament(MedicamentsDto dto);
    MedicamentsDto getMedicamentById(Long id);
    List<MedicamentsDto> getAllMedicaments();
    void deleteMedicament(Long id);
    MedicamentsDto augmenterStock(Long id, int quantite);
    MedicamentsDto diminuerStock(Long id , int quantite);
}
