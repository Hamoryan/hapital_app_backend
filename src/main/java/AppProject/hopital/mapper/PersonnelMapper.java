package AppProject.hopital.mapper;

import AppProject.hopital.dto.PersonnelDto;
import AppProject.hopital.entity.Personnel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonnelMapper {
//        @Mapping(source = "role", target = "role")
        PersonnelDto entityToDto(Personnel entity);
//        @Mapping(source = "role" ,target = "role" )
        Personnel dtoToEntity(PersonnelDto dto);

}
