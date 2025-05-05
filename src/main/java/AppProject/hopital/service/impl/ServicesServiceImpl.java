package AppProject.hopital.service.impl;

import AppProject.hopital.dto.ServicesDto;
import AppProject.hopital.mapper.ServicesMapper;
import AppProject.hopital.repository.ServicesRepository;
import AppProject.hopital.service.ServicesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import AppProject.hopital.entity.Services;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServicesService {

    private final ServicesRepository servicesRepository;
    private final ServicesMapper servicesMapper;

    @Override
    public ServicesDto createServices(ServicesDto dto) {
        Services services = servicesMapper.dtoToEntity(dto);
        services = servicesRepository.save(services);
        return servicesMapper.entityToDto(services);
    }

    @Override
    public ServicesDto getServiceById(Long idService) {
        Services services = servicesRepository.findById(idService)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        return servicesMapper.entityToDto(services);
    }

    @Override
    public List<ServicesDto> getAllServices() {
        return servicesRepository.findAll().stream()
                .map(servicesMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServicesDto updateService(ServicesDto dto) {
        if (dto.getIdService() !=null){
            servicesMapper.entityToDto(servicesRepository.save(servicesMapper.dtoToEntity(dto)));
            return dto;
        }
        else{
            throw new EntityNotFoundException("Service not found");
        }
    }


    @Override
    public void deleteService(Long idService) {
        servicesRepository.deleteById(idService);
    }
}
