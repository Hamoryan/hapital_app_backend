package AppProject.hopital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "medicaments")
@Data
public class Medicaments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicaments;

    private String nomCommercial;
    private String nomGenetique;
    private Double prix;
    private String description;
    private Integer quantiteStock;
}
