package AppProject.hopital.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "Date_naissance")
    private LocalDate dateDeNaissance;
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "Téléphone")
    private String telephone;
    @Column(name = "Numero_securite_sociale")
    private String numeroSecuriteSociale;
    @Column(name = "Statut")
    private Boolean statut;
}
