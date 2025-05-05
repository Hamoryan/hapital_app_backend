package AppProject.hopital.mapper;

import AppProject.hopital.dto.RoleDto;
import AppProject.hopital.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto entityToDto(Role entity);

    Role dtoToEntity(RoleDto dto);
}
