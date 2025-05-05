package AppProject.hopital.repository;

import AppProject.hopital.entity.MedicamentPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentPatientRepository extends JpaRepository<MedicamentPatient , Long> {
}
