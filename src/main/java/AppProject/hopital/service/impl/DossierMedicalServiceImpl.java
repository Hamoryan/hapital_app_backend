package AppProject.hopital.service.impl;

import AppProject.hopital.dto.DossierMedicalDto;
import AppProject.hopital.entity.DossierMedical;
import AppProject.hopital.mapper.DossierMedicalMapper;
import AppProject.hopital.repository.DossierMedicalRepository;
import AppProject.hopital.repository.PatientRepository;
import AppProject.hopital.service.DossierMedicalService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DossierMedicalServiceImpl implements DossierMedicalService {

    private final DossierMedicalRepository dossierMedicalRepository;
    private final PatientRepository patientRepository;
    private final DossierMedicalMapper dossierMedicalMapper;

    @Override
    public DossierMedicalDto saveDossier(DossierMedicalDto dto) {
        DossierMedical dossierMedical =dossierMedicalMapper.dtoToEntity(dto);
        dossierMedical.setPatient(patientRepository.findById(dto.getPatientId())
                .orElseThrow(() ->new RuntimeException("Patient introuvable")));
        return dossierMedicalMapper.entityToDto(dossierMedicalRepository.save(dossierMedical));
    }

    @Override
    public DossierMedicalDto updateDossier(DossierMedicalDto dto) {
        if (dto.getIdDossierMed() !=null){
            if (dto.getPatientId() !=null){
             dossierMedicalMapper.entityToDto(dossierMedicalRepository.save(dossierMedicalMapper.dtoToEntity(dto)));
             return dto;
            }else {
                throw new EntityNotFoundException("Patient introuvable");
            }
        }
        else {
            throw new EntityNotFoundException("Dossier introuvable");
        }
    }

    @Override
    public DossierMedicalDto getDossierById(Long id) {
        return dossierMedicalRepository.findById(id)
                .map(dossierMedicalMapper::entityToDto)
                .orElseThrow(() -> new RuntimeException("Dossier introuvable"));
    }

    @Override
    public List<DossierMedicalDto> getAllDossier() {
        return dossierMedicalRepository.findAll()
                .stream()
                .map(dossierMedicalMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDossier(Long id) {
        dossierMedicalRepository.deleteById(id);
    }
}
