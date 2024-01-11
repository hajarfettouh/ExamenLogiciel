package ExamenLogiciel.demoexam.repositories;

import ExamenLogiciel.demoexam.entities.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version, Long> {
}
