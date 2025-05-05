package AppProject.hopital.service.impl;

import AppProject.hopital.dto.PatientDto;
import AppProject.hopital.entity.Patient;
import AppProject.hopital.mapper.PatientMapper;
import AppProject.hopital.repository.PatientRepository;
import AppProject.hopital.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

 @Override
    public PatientDto createdPatient(PatientDto dto) {
     Patient patientmap = patientMapper.dtoToEntity(dto);
        Patient patientCreated = patientRepository.save(patientmap);
        return  patientMapper.entitytoDto(patientCreated);
    }


    @Override
    public PatientDto UpdatePatient(PatientDto dto) {
     if (dto.getIdPatient() !=null){
         patientMapper.entitytoDto(patientRepository.save(patientMapper.dtoToEntity(dto)));
//        Optional<Patient> optionalPatient = patientRepository.findById(dto.getIdPatient());
//        if (optionalPatient.isPresent()){
//            Patient existingPatient = optionalPatient.get();
//            existingPatient.setNom(dto.getNom());
//            existingPatient.setPrenom(dto.getPrenom());
//            existingPatient.setTelephone(dto.getTelephone());
//            PatientDto patientDto =patientMapper.entitytoDto(existingPatient);
//            patientRepository.save(existingPatient);
            return dto;
        }
        else {
            throw new EntityNotFoundException("Patient not found");
        }
    }

    @Override
    public void changeStatutPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Patient doesn't exist")
        );
        if (patient.getStatut().equals(true)){
            patient.setStatut(false);
        }
        else {
            patient.setStatut(true);
        }
        patientRepository.save(patient);
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        PatientDto patientDto = new PatientDto();

        if (optionalPatient.isPresent()){
            patientDto = patientMapper.entitytoDto(optionalPatient.get());
            return patientDto;
        }
        else {
            throw new EntityNotFoundException("Patient not found");
        }
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream().map(patientMapper::entitytoDto).toList();
    }
}
