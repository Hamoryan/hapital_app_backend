package AppProject.hopital.controller.api;

import AppProject.hopital.dto.FactureDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/facture")
public interface FacturreApi  {
    @PostMapping("/genererFacture")
    FactureDto genererFacture(@RequestBody FactureDto dto);
    @PostMapping("/effectuerPaiment/{idFacture}")
    FactureDto effectuerPaiment(@PathVariable Long idFacture);
    @GetMapping("/getAllFactures")
    List<FactureDto> getAllFactures();
}
