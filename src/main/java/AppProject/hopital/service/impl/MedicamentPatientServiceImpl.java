package AppProject.hopital.service.impl;

import AppProject.hopital.dto.MedicamentPatientDto;
import AppProject.hopital.entity.MedicamentPatient;
import AppProject.hopital.mapper.MedicamentPatientMapper;
import AppProject.hopital.repository.MedicamentPatientRepository;
import AppProject.hopital.repository.PersonnelRepository;
import AppProject.hopital.service.MedicamentPatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicamentPatientServiceImpl implements MedicamentPatientService {

    private final MedicamentPatientRepository medicamentPatientRepository;
    private final MedicamentPatientMapper medicamentPatientMapper;
    private final PersonnelRepository personnelRepository;

    @Override
    public MedicamentPatientDto save(MedicamentPatientDto dto) {
        personnelRepository.findById(dto.getIdPersonnel()).orElseThrow(()
                -> new RuntimeException("personnel introuvable"));
        MedicamentPatient entity = medicamentPatientMapper.dtoToEntity(dto);
        return medicamentPatientMapper.entityToDto(medicamentPatientRepository.save(entity));
    }

    @Override
    public MedicamentPatientDto update(MedicamentPatientDto dto) {
        if (dto.getIdMedPatient() != null){
            medicamentPatientMapper.entityToDto(medicamentPatientRepository.save(medicamentPatientMapper.dtoToEntity(dto)));
            return dto;
        }
        else {
            throw new EntityNotFoundException("MedicamentPatient introuvable");
        }
    }

    @Override
    public void delete(Long id) {
        medicamentPatientRepository.deleteById(id);

    }

    @Override
    public MedicamentPatientDto getById(Long id) {
        return medicamentPatientRepository.findById(id)
                .map(medicamentPatientMapper:: entityToDto)
                .orElseThrow(() -> new RuntimeException("MedicamenPatient introuvable"));
    }

    @Override
    public List<MedicamentPatientDto> getAll() {
        return medicamentPatientRepository.findAll()
                .stream()
                .map(medicamentPatientMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
