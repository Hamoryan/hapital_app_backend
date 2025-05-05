package AppProject.hopital.controller.api;

import AppProject.hopital.dto.ServicesDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/services")
public interface ServicesApi {
    @PostMapping("/createServices")
    ServicesDto createServices(@RequestBody ServicesDto dto);

    @GetMapping("/getById/{id}")
    ServicesDto getById(@PathVariable Long id);

    @GetMapping("/getAllServices")
    List<ServicesDto> getAllServices();

    @DeleteMapping("/deleteServices/{id}")
    void deleteServices(@PathVariable Long id);

}
