package AppProject.hopital.service;

import AppProject.hopital.dto.ServicesDto;

import java.util.List;

public interface ServicesService {
    ServicesDto createServices(ServicesDto dto);

    ServicesDto getServiceById(Long idService);

    List<ServicesDto> getAllServices();

    ServicesDto updateService(ServicesDto dto);

    void deleteService(Long idService);
}
