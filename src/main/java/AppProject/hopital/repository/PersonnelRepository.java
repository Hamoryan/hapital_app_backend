package AppProject.hopital.repository;

import AppProject.hopital.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

    Optional<Personnel> findByPersonnelname(String personnelname);
    Optional<Personnel> findByEmail(String email);
    boolean existsByPersonnelname(String personnelname);
}
