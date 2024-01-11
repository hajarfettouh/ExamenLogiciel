package ExamenLogiciel.demoexam.repositories;

import ExamenLogiciel.demoexam.entities.Composant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposantRepository extends JpaRepository<Composant,Long> {
}
