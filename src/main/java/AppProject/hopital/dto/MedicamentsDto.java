package AppProject.hopital.dto;

import lombok.Data;

@Data
public class MedicamentsDto {
    private Long idMedicaments;
    private String nomCommercial;
    private String nomGenetique;
    private Double prix;
    private String description;
    private Integer quantiteStock;
}
