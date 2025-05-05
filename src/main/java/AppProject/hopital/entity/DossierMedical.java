package AppProject.hopital.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "dossier_medical")
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDossierMed;
    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
