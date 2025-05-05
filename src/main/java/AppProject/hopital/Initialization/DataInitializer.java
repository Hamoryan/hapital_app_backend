package AppProject.hopital.Initialization;

import AppProject.hopital.Enumtype.TypeRole;
import AppProject.hopital.entity.Personnel;
import AppProject.hopital.entity.Role;
import AppProject.hopital.repository.PersonnelRepository;
import AppProject.hopital.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final PersonnelRepository personnelRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        if (personnelRepository.findByEmail("hamoryan3@gmail.com").isEmpty()) {
            Personnel personnel = new Personnel();
            personnel.setPersonnelname("Hamo Ryan");
            personnel.setPasseword(passwordEncoder.encode("Kengne08"));
            personnel.setRole(TypeRole.ADMINISTRATEUR);
            personnel.setEmail("hamoryan3@gmail.com");
            personnel.setTelephone("690404961");
            personnel.setStatut(true);
            personnelRepository.save(personnel);
            System.out.println(">>>>> Données insérées.");
        }
        for (TypeRole typeRole : TypeRole.values()){
            roleRepository.findByTypeRole(typeRole).orElseGet(() -> {
                Role role = new Role();
                role.setTypeRole(typeRole);
                return roleRepository.save(role);
            });
            System.out.println(">>>>>> Roles initialisées");
        }
    }
}
