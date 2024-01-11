package ExamenLogiciel.demoexam.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Catégorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "principalCategory")
    private List<Logiciel> logiciel;

    @ManyToMany(mappedBy = "categories")
    private List<Logiciel> logiciels;

    public Catégorie( String nom) {
        this.nom = nom;

    }

    public Catégorie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Logiciel> getLogiciel() {
        return logiciel;
    }

    public void setLogiciel(List<Logiciel> logiciel) {
        this.logiciel = logiciel;
    }

    public List<Logiciel> getLogiciels() {
        return logiciels;
    }

    public void setLogiciels(List<Logiciel> logiciels) {
        this.logiciels = logiciels;
    }
}
