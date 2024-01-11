package ExamenLogiciel.demoexam.entities.embedded;


import ExamenLogiciel.demoexam.entities.Version;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LicenceId implements Serializable {
   private String nom;
   private String Langue ;
    @ManyToOne
    @JoinColumn(name = "license_version_id")
    private Version licenseVersion;


    public LicenceId() {
        super();

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLangue() {
        return Langue;
    }

    public void setLangue(String langue) {
        Langue = langue;
    }


    public LicenceId(String nom, String langue) {
        this.nom = nom;
        this.Langue = langue;

    }

    @Override
    public String toString() {
        return "LicenceId{" +
                "nom='" + nom + '\'' +
                ", Langue='" + Langue + '\'' +
                ", licenseVersion=" + licenseVersion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LicenceId licenceId)) return false;
        return Objects.equals(nom, licenceId.nom) && Objects.equals(Langue, licenceId.Langue) && Objects.equals(licenseVersion, licenceId.licenseVersion);
    }

    public Version getLicenseVersion() {
        return licenseVersion;
    }

    public void setLicenseVersion(Version licenseVersion) {
        this.licenseVersion = licenseVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, Langue);
    }


}
