package AppProject.hopital.dto;

import lombok.Data;

@Data
public class MedicamentPatientDto {
    private Long idMedPatient;

    private String posologie;

    private String nomCommercial;

    private String nomGenetique;

    private Double prix;

    private Long idPersonnel;

    private Long idMedicament;

    private Long idDossierMedical;
}
