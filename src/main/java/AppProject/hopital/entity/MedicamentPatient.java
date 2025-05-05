package AppProject.hopital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "MedicamentPatient")
public class MedicamentPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedPatient;

    private String posologie;

    private String nomCommercial;

    private String nomGenetique;

    private Double prix;
    @ManyToOne
    @JoinColumn(name = "personnel_id")
    private Personnel personnel;

    @ManyToOne
    @JoinColumn(name = "medicament_id")
    private Medicaments medicaments;

    @ManyToOne
    @JoinColumn(name = "dossier_medical_id")
    private DossierMedical dossierMedical;

}
