package AppProject.hopital.entity;

import AppProject.hopital.Enumtype.TypeRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeRole typeRole;
}
