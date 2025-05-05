package AppProject.hopital.service.impl;

import AppProject.hopital.dto.RoleDto;
import AppProject.hopital.entity.Role;
import AppProject.hopital.mapper.RoleMapper;
import AppProject.hopital.repository.RoleRepository;
import AppProject.hopital.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    @Override
    public RoleDto createRole(RoleDto dto) {
        Role roleMap = roleMapper.dtoToEntity(dto);
        Role roleCreated = roleRepository.save(roleMap);
        return roleMapper.entityToDto(roleCreated);
    }
}
