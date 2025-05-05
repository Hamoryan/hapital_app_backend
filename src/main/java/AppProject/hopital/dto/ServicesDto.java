package AppProject.hopital.dto;

import AppProject.hopital.Enumtype.TypeService;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ServicesDto {

    private Long idService;
    private LocalDate dateCreation;
    private Long idPatient;
    private Long idPersonnel;
    private TypeService typeService;
}
