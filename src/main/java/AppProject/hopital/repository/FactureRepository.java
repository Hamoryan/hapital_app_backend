package AppProject.hopital.repository;

import AppProject.hopital.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
