package AppProject.hopital.entity;

import AppProject.hopital.Enumtype.TypeRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Personnels")
@Data
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "Personnelname")
    private String personnelname;
    @Column(name = "passeword")
    private String passeword;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @Column(name = "statut")
    private Boolean statut;
    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;
     @Enumerated(EnumType.STRING)
     @Column(name = "role")
    private TypeRole role;

}
