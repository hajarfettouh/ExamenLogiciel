package ExamenLogiciel.demoexam.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Version {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long Id;
    private int Majeure;
    private int Mineure;

    public Version( int majeure, int mineure) {
        Majeure = majeure;
        Mineure = mineure;
    }

    public Version() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getMajeure() {
        return Majeure;
    }

    public void setMajeure(int majeure) {
        Majeure = majeure;
    }

    public int getMineure() {
        return Mineure;
    }

    public void setMineure(int mineure) {
        Mineure = mineure;
    }
}
