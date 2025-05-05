package AppProject.hopital.controller.api;

import AppProject.hopital.dto.RoleDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/Role")
public interface RoleApi {

    @PostMapping("/createRole")
    RoleDto createRole(@RequestBody RoleDto dto);
}
