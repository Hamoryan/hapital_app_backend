package AppProject.hopital.dto;

import lombok.Data;

@Data
public class PersonnelDto {

    private Long id;
    private String personnelname;
    private String role;
    private Boolean statut;
    private String telephone;
    private String email;


}
