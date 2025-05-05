package AppProject.hopital.controller.api;

import AppProject.hopital.dto.MedicamentsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/medicaments")
public interface MedicamentsApi {

    @PostMapping("/createMedicaments")
    MedicamentsDto createMedicaments(@RequestBody MedicamentsDto dto);

    @PutMapping("/updateMedicaments")
    MedicamentsDto updateMedicaments(@RequestBody MedicamentsDto dto);

    @GetMapping("/getMedicamentById/{id}")
    MedicamentsDto getMedicamentById(@PathVariable Long id);

    @GetMapping("/getAllMedicaments")
    List<MedicamentsDto> getAllMedicaments();

    @DeleteMapping("/deleteMedicament/{id}")
    void deleteMedicament(@PathVariable Long id);

    @PatchMapping("/{id}/augmenterStock")
    MedicamentsDto augmenterStock(@PathVariable Long id , @RequestParam int quantite);

    @PatchMapping("/{id}/diminuerStock")
    MedicamentsDto diminuerStock(@PathVariable Long id , @RequestParam int quantite);
}
