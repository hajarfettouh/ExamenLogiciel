package ExamenLogiciel.demoexam.repositories;

import ExamenLogiciel.demoexam.entities.Licence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenceRepository extends JpaRepository<Licence,Long> {
}
