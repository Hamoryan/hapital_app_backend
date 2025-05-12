package AppProject.hopital.controller;

import AppProject.hopital.controller.api.FacturreApi;
import AppProject.hopital.dto.FactureDto;
import AppProject.hopital.service.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class FactureController implements FacturreApi {

    private final FactureService factureService;

    @Override
    public FactureDto genererFacture(FactureDto dto) {

        return factureService.genererFacture(dto);
    }

    @Override
    public FactureDto effectuerPaiment(Long idFacture) {
        return factureService.effectuerPaiment(idFacture);
    }

    @Override
    public List<FactureDto> getAllFactures() {
        return factureService.getAllFactures();
    }
}
