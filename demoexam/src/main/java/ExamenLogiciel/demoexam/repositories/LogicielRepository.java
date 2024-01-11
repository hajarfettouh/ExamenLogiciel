package ExamenLogiciel.demoexam.repositories;

import ExamenLogiciel.demoexam.entities.Logiciel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogicielRepository extends JpaRepository<Logiciel,Long> {
}
