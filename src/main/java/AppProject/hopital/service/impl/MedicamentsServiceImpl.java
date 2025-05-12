package AppProject.hopital.service.impl;

import AppProject.hopital.dto.MedicamentsDto;
import AppProject.hopital.entity.Medicaments;
import AppProject.hopital.mapper.MedicamentsMapper;
import AppProject.hopital.repository.MedicamentsRepository;
import AppProject.hopital.service.MedicamentsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicamentsServiceImpl implements MedicamentsService {

    private final MedicamentsRepository medicamentsRepository;
    private final MedicamentsMapper medicamentsMapper;

    @Override
    public MedicamentsDto createMedicament(MedicamentsDto dto) {
        Medicaments createdMedicament = medicamentsMapper.dtoToEntity(dto);
        return medicamentsMapper.entityToDto(medicamentsRepository.save(createdMedicament));
    }

    @Override
    public MedicamentsDto updateMedicament(MedicamentsDto dto) {
        if (dto.getIdMedicaments() != null){
            medicamentsMapper.entityToDto(medicamentsRepository.save(medicamentsMapper.dtoToEntity(dto)));
            return dto;
        }
        else {
            throw new EntityNotFoundException("Medicament introuvable");
        }
    }

    @Override
    public MedicamentsDto getMedicamentById(Long id) {
        return medicamentsRepository.findById(id)
                .map(medicamentsMapper::entityToDto)
                .orElseThrow(() -> new RuntimeException("Medicament introuvable"));
    }

    @Override
    public List<MedicamentsDto> getAllMedicaments() {
        return medicamentsRepository.findAll()
                .stream()
                .map(medicamentsMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMedicament(Long id) {
        medicamentsRepository.deleteById(id);

    }

    @Override
    public MedicamentsDto augmenterStock(Long id, int quantite) {
        Medicaments medicaments = medicamentsRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Medicament introuvable"));
        medicaments.setQuantiteStock(medicaments.getQuantiteStock() + quantite);
        return medicamentsMapper.entityToDto(medicamentsRepository.save(medicaments));
    }

    @Override
    public MedicamentsDto diminuerStock(Long id, int quantite) {
        Medicaments medicaments = medicamentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicament introuvable"));
        int nouveauStock = medicaments.getQuantiteStock() - quantite;
        if (nouveauStock <1){
            throw new RuntimeException("Stock insuffisant pour diminuer");
        }
        medicaments.setQuantiteStock(nouveauStock);
        return medicamentsMapper.entityToDto(medicamentsRepository.save(medicaments));
    }
}
