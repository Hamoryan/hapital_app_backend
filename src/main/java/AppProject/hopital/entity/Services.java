package AppProject.hopital.entity;

import AppProject.hopital.Enumtype.TypeService;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "services")
@Data
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;

    private Long idPersonnel;

    private LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Enumerated(EnumType.STRING)
    private TypeService typeService;
}
