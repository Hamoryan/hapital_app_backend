package AppProject.hopital.service.impl;

import AppProject.hopital.dto.ChangePasswordDto;
import AppProject.hopital.dto.PersonnelDto;
import AppProject.hopital.entity.Personnel;
import AppProject.hopital.mapper.PersonnelMapper;
import AppProject.hopital.repository.PersonnelRepository;
import AppProject.hopital.service.PersonnelService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonnelServiceImpl implements PersonnelService {
    private final PersonnelRepository personnelRepository;
    private final PersonnelMapper personnelMapper;
    private final PasswordEncoder passwordEncoder;

//    @Override
//    public PersonnelDto seConnecter(String email) {
//        return null;
//    }
//
//    @Override
//    public void seDeconnecter(Long id) {
//
//    }

    @Override
     public List<PersonnelDto> getAllPersonnels() {
        List<Personnel> personnelList = personnelRepository.findAll();
        return personnelList.stream().map(personnelMapper::entityToDto).toList();
    }

    @Override
    public PersonnelDto createdPersonnel(Personnel personnel) {

        if(personnelRepository.existsByPersonnelname(personnel.getPersonnelname())){
            throw new IllegalArgumentException("Le nom du personnel est deja utilisé.");
        }
        personnel.setPasseword(passwordEncoder.encode(personnel.getPasseword()));
        Personnel personnelCreated = personnelRepository.save(personnel);
        return personnelMapper.entityToDto(personnelCreated);
    }

    @Override
    public PersonnelDto getPersonnelById(Long id) {
        Optional<Personnel> optionalPersonnel = personnelRepository.findById(id);
        PersonnelDto personnelDto;
        if (optionalPersonnel.isPresent()){
            personnelDto =  personnelMapper.entityToDto(optionalPersonnel.get());
            return personnelDto;
        } else {
            throw new  EntityNotFoundException("Personnel Non trouvé");
        }
    }
    @Override
    public PersonnelDto UpdatePersonnel(PersonnelDto dto){
        if(dto.getId() == null){
            throw new EntityNotFoundException("Cet Utilisateur n'existe pas");
        }

        Optional<Personnel> personnel = personnelRepository.findById(dto.getId());

        if (personnel.isEmpty()) {
            throw new EntityNotFoundException("Cet Utilisateur n'existe pas");
        }


        Personnel personnelToSave = personnel.get();
        personnelToSave.setPersonnelname(dto.getPersonnelname());
        personnelToSave.setEmail(dto.getEmail());
        personnelToSave.setTelephone(dto.getTelephone());
        personnelToSave.setRole(dto.getRole());
        personnelToSave.setStatut(dto.getStatut());
        PersonnelDto savedPersonel = personnelMapper.entityToDto(personnelRepository.save(personnelToSave));

        return savedPersonel;
    }
    @Override
     public void changeStatutPersonnel(Long id){
        Personnel personnel = personnelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cet Utilisateur n'existe pas")
        );

        if (personnel.getStatut().equals(true)) {
            personnel.setStatut(false);
        } else {
            personnel.setStatut(true);
        }
        personnelRepository.save(personnel);

    }

    @Override
    public void changePassword(ChangePasswordDto dto) {
        Personnel personnel =personnelRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!passwordEncoder.matches(dto.getOldPassword(), personnel.getPasseword())){
            throw new IllegalArgumentException("Ancien mot de passe incorrect");
        }

        if (passwordEncoder.matches(dto.getNewPassword(), personnel.getPasseword())){
            throw new IllegalArgumentException("Le nouveau mot de passe ne dois pas etre identique á l'ancien");
        }
        personnel.setPasseword(passwordEncoder.encode(dto.getNewPassword()));
        personnelRepository.save(personnel);
    }


}
