package AppProject.hopital.repository;

import AppProject.hopital.Enumtype.TypeRole;
import AppProject.hopital.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role ,Long> {
    Optional<Role> findByTypeRole(TypeRole typeRole);
}
