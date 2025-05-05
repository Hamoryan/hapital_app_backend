package AppProject.hopital.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class DossierMedicalDto {
    private Long idDossierMed;
    private LocalDate dateCreation;
    private Long patientId;
}
