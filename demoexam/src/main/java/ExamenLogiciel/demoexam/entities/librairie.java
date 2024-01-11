package ExamenLogiciel.demoexam.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class librairie extends Logiciel {
    @ManyToMany
    @JoinTable(
            name = "reflexeve_libraries",
            joinColumns = {@JoinColumn(name = "librairie1_version_id"),@JoinColumn(name = "nomLibrairie1")},
            inverseJoinColumns = {@JoinColumn(name = "librairie2_version_id"),@JoinColumn(name = "nomLibrairie2")})
    private List<librairie> librairies = new ArrayList<>();

    public List<librairie> getLibrairies() {
        return librairies;
    }

    public void setLibrairies(List<librairie> librairies) {
        this.librairies = librairies;
    }

}
