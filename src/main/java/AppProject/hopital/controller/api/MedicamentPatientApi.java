package AppProject.hopital.controller.api;

import AppProject.hopital.dto.MedicamentPatientDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/medicamentpatient")
public interface MedicamentPatientApi {

    @PostMapping("/save")
    MedicamentPatientDto save(@RequestBody MedicamentPatientDto dto);

@PutMapping("/update")
    MedicamentPatientDto update( @RequestBody MedicamentPatientDto dto);

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id);

    @GetMapping("/getById/{id}")
    MedicamentPatientDto getById(@PathVariable Long id);

    @GetMapping("/getAll")
    List<MedicamentPatientDto> getAll();
}
