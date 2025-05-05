package AppProject.hopital.controller;

import AppProject.hopital.controller.api.RoleApi;
import AppProject.hopital.dto.RoleDto;
import AppProject.hopital.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoleController implements RoleApi {

    private final RoleService roleService;

    @Override
    public RoleDto createRole(RoleDto dto) {
        return roleService.createRole(dto);
    }
}
