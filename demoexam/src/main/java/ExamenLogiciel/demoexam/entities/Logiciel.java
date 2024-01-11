package ExamenLogiciel.demoexam.entities;


import ExamenLogiciel.demoexam.entities.embedded.LogicielId;
import jakarta.persistence.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Logiciel {
    @EmbeddedId
    private LogicielId id;
    private String Description;
    private URL url;

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }


    @ManyToOne
    @JoinColumn(name = "principal_category_id")
    private Catégorie principalCategory;

    //Many To Many relation ship
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "logiciel_category",
            joinColumns = {@JoinColumn(name = "logiciel_version_id"),@JoinColumn(name = "nom")},
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Catégorie> categories = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "logiciel_application",
            joinColumns = {@JoinColumn(name = "logiciel_version_id"),@JoinColumn(name = "nom")},
            inverseJoinColumns = {@JoinColumn(name = "application_version_id"),@JoinColumn(name = "nomApplication")})
    private List<Application> applications = new ArrayList<>();

    @OneToMany(mappedBy = "logicielCp")
    private List<Composant> composants = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "logiciel_license",
            joinColumns = {@JoinColumn(name = "logiciel_version_id"),@JoinColumn(name = "nom")},
            inverseJoinColumns = {@JoinColumn(name = "license_nom"),@JoinColumn(name = "license_version_id"),@JoinColumn(name = "license_langue")})
    private List<Licence> licensesLog = new ArrayList<>();
    public Logiciel() {

    }

    public LogicielId getId() {
        return id;
    }

    public void setId(LogicielId id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }


    public List<Catégorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Catégorie> categories) {
        this.categories = categories;
    }





    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public Logiciel(LogicielId id, String description, URL url) {
        this.id = id;
        Description = description;
        this.url = url;
    }

    public Catégorie getPrincipalCategory() {
        return principalCategory;
    }

    public void setPrincipalCategory(Catégorie principalCategory) {
        this.principalCategory = principalCategory;
    }

    public List<Licence> getLicensesLog() {
        return licensesLog;
    }

    public void setLicensesLog(List<Licence> licensesLog) {
        this.licensesLog = licensesLog;
    }


}
