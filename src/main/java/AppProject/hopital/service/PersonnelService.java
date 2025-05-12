package AppProject.hopital.service;

import AppProject.hopital.dto.ChangePasswordDto;
import AppProject.hopital.dto.PersonnelDto;
import AppProject.hopital.entity.Personnel;

import java.util.List;

public interface PersonnelService {

//    PersonnelDto seConnecter(String email);
//    void seDeconnecter(Long id);

    List<PersonnelDto> getAllPersonnels();

    PersonnelDto createdPersonnel(Personnel personnel);

    PersonnelDto getPersonnelById(Long id);

    PersonnelDto UpdatePersonnel(PersonnelDto dto);

    void changeStatutPersonnel(Long id);

    void changePassword(ChangePasswordDto dto);

}
