package AppProject.hopital.service.impl;

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
            throw new  EntityNotFoundException("Personnel Not found");
        }
    }
    @Override
    public PersonnelDto UpdatePersonnel(PersonnelDto dto){
        if(dto.getId() != null){
            personnelMapper.entityToDto(personnelRepository.save(personnelMapper.dtoToEntity(dto)));
            return dto;

        }
        else {
            throw new EntityNotFoundException("Personnel doesn't exist");
        }

    }
    @Override
     public void changeStatutPersonnel(Long id){
        Personnel personnel = personnelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Personnel doesn't exist")
        );

        if (personnel.getStatut().equals(true)) {
            personnel.setStatut(false);
        } else {
            personnel.setStatut(true);
        }
        personnelRepository.save(personnel);

    }


}
