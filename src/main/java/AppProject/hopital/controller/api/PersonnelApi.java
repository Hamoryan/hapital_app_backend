package AppProject.hopital.controller.api;

import AppProject.hopital.dto.PersonnelDto;
import AppProject.hopital.entity.Personnel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/Personnels")
public interface PersonnelApi {

    @GetMapping(value = "/getAllPersonnels")
    List<PersonnelDto> getAllPersonnels();

    @PostMapping(value = "/createPersonnel")
    PersonnelDto createdPersonnel(@RequestBody Personnel personnel);

    @GetMapping("/getPersonnelById/{id}")
    PersonnelDto getPersonnelById(@PathVariable Long id);

    @PutMapping("/UpdatePersonnel")
    PersonnelDto UpdatePersonnel(@RequestBody PersonnelDto dto);

    @DeleteMapping("/changeStatut/{id}")
    void changeStatutPersonnel(@PathVariable Long id);


}
