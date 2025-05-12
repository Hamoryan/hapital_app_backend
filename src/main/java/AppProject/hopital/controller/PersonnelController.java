package AppProject.hopital.controller;

import AppProject.hopital.controller.api.PersonnelApi;
import AppProject.hopital.dto.ChangePasswordDto;
import AppProject.hopital.dto.PersonnelDto;
import AppProject.hopital.entity.Personnel;
import AppProject.hopital.service.PersonnelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class PersonnelController implements PersonnelApi {

    private final PersonnelService personnelService;

    @Override
//    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public List<PersonnelDto> getAllPersonnels() {
        return personnelService.getAllPersonnels();
    }

    @Override
//    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public PersonnelDto createdPersonnel(Personnel personnel){
        return personnelService.createdPersonnel(personnel);
    }

    @Override
//    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public PersonnelDto getPersonnelById(Long id){
        return personnelService.getPersonnelById(id);
    }

    @Override
//    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public PersonnelDto UpdatePersonnel(PersonnelDto dto){

        return personnelService.UpdatePersonnel(dto);
    }

    @Override
//    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public void changeStatutPersonnel(Long id){
        personnelService.changeStatutPersonnel(id);
    }

    @Override
//    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public ResponseEntity<?> changePassword(ChangePasswordDto dto) {
        personnelService.changePassword(dto);
        return ResponseEntity.ok().build();
    }


}


