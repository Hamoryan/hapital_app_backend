package AppProject.hopital.dto;

import AppProject.hopital.Enumtype.StatutFacture;
import lombok.Data;
import java.time.LocalDate;
@Data
public class FactureDto {

    private Long idFacture;
    private LocalDate dateEmission;
    private Double montant;
    private StatutFacture statutFacture;
    private Long patientId;
    private Long personnelId;
}
