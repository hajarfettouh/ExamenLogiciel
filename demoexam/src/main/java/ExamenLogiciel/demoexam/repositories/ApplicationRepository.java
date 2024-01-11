package ExamenLogiciel.demoexam.repositories;

import ExamenLogiciel.demoexam.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
}
