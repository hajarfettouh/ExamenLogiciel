package ExamenLogiciel.demoexam.repositories;

import ExamenLogiciel.demoexam.entities.Catégorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatégorieRepository extends JpaRepository<Catégorie,Long> {
}
