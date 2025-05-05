package AppProject.hopital.entity;

import AppProject.hopital.Enumtype.StatutFacture;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "factures")
@Data
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    @Column(name = "date_emission")
    private LocalDate dateEmission;
    @Column(name = "montant")
    private Double montant;
    @Enumerated(EnumType.STRING)
    private StatutFacture statutFacture;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "personnel_id")
    private Personnel personnel;




}
