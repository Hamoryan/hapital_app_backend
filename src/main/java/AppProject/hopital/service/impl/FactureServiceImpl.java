package AppProject.hopital.service.impl;

import AppProject.hopital.Enumtype.StatutFacture;
import AppProject.hopital.dto.FactureDto;
import AppProject.hopital.entity.Facture;
import AppProject.hopital.mapper.FactureMapper;
import AppProject.hopital.repository.FactureRepository;
import AppProject.hopital.repository.PatientRepository;
import AppProject.hopital.repository.PersonnelRepository;
import AppProject.hopital.service.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {

    private final FactureRepository factureRepository;
    private final FactureMapper factureMapper;
    private final PatientRepository patientRepository;
    private final PersonnelRepository personnelRepository;

    @Override
    public FactureDto genererFacture(FactureDto dto) {
        Facture facture = factureMapper.DtoToEntity(dto);
        facture.setStatutFacture(StatutFacture.NON_PAYEE);
        facture.setPatient(patientRepository.findById(dto.getPatientId()).orElseThrow( ()
                -> new RuntimeException("Patient introuvable")));
        facture.setPersonnel(personnelRepository.findById(dto.getPersonnelId()).orElseThrow(()
                -> new RuntimeException("Personnel introuvable")));
        return factureMapper.entityToDto(factureRepository.save(facture));
    }

    @Override
    public FactureDto effectuerPaiment(Long idFacture) {
        Facture facture = factureRepository.findById(idFacture).orElseThrow(()
                ->new RuntimeException("facture introuvable"));
        if (facture.getStatutFacture() == StatutFacture.PAYEE){
            throw new RuntimeException("la facture a déja été payée");
        }
        facture.setStatutFacture(StatutFacture.PAYEE);
        return factureMapper.entityToDto(factureRepository.save(facture));
    }

    @Override
    public List<FactureDto> getAllFactures() {
        return factureRepository.findAll()
                .stream()
                .map(factureMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
