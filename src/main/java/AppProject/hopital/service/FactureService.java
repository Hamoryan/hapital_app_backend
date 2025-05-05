package AppProject.hopital.service;

import AppProject.hopital.dto.FactureDto;

import java.util.List;

public interface FactureService {
    FactureDto genererFacture(FactureDto dto);
    FactureDto effectuerPaiment(Long idFacture);
    List<FactureDto> getAllFactures();
}
