package AppProject.hopital.repository;

import AppProject.hopital.entity.Medicaments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentsRepository extends JpaRepository<Medicaments ,Long> {
}
