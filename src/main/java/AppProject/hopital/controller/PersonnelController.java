package AppProject.hopital.controller;

import AppProject.hopital.controller.api.PersonnelApi;
import AppProject.hopital.dto.PatientDto;
import AppProject.hopital.dto.PersonnelDto;
import AppProject.hopital.entity.Patient;
import AppProject.hopital.entity.Personnel;
import AppProject.hopital.service.PersonnelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonnelController implements PersonnelApi {
    private final PersonnelService personnelService;


    @Override
    public List<PersonnelDto> getAllPersonnels() {
        return personnelService.getAllPersonnels();
    }

    @Override
    public PersonnelDto createdPersonnel(Personnel personnel){
        return personnelService.createdPersonnel(personnel);
    }

    @Override
    public PersonnelDto getPersonnelById(Long id){
        return personnelService.getPersonnelById(id);
    }

    @Override
    public PersonnelDto UpdatePersonnel(PersonnelDto dto){

        return personnelService.UpdatePersonnel(dto);
    }

    @Override
    public void changeStatutPersonnel(Long id){
        personnelService.changeStatutPersonnel(id);
    }


}


