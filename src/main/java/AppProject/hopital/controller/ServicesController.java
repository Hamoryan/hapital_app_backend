package AppProject.hopital.controller;

import AppProject.hopital.controller.api.ServicesApi;
import AppProject.hopital.dto.ServicesDto;
import AppProject.hopital.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ServicesController implements ServicesApi {

    private final ServicesService servicesService;

    @Override
    public ServicesDto createServices(ServicesDto dto) {
        return servicesService.createServices(dto);
    }

    @Override
    public ServicesDto getById(Long id) {
        return servicesService.getServiceById(id);
    }

    @Override
    public List<ServicesDto> getAllServices() {
        return servicesService.getAllServices();
    }

    @Override
    public void deleteServices(Long id) {
        servicesService.deleteService(id);
    }
}
