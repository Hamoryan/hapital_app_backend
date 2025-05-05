package AppProject.hopital.mapper;

import AppProject.hopital.dto.MedicamentsDto;
import AppProject.hopital.entity.Medicaments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicamentsMapper {

    MedicamentsDto entityToDto(Medicaments entity);
    Medicaments dtoToEntity(MedicamentsDto dto);
}
