package AppProject.hopital.dto;

import AppProject.hopital.Enumtype.TypeRole;
import lombok.Data;

@Data
public class PersonnelDto {

    private Long id;
    private String personnelname;
    private TypeRole role;
    private Boolean statut;
    private String telephone;
    private String email;



}
