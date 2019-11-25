package com.esprit.contratservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dateDebut;

    private String typeContrat;

    private Double salaire;

    public Contrat() {
    }

    public Contrat(String dateDebut, String typeContrat, Double salaire) {
        this.dateDebut = dateDebut;
        this.typeContrat = typeContrat;
        this.salaire = salaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrat contrat = (Contrat) o;
        return Objects.equals(id, contrat.id) &&
                Objects.equals(dateDebut, contrat.dateDebut) &&
                Objects.equals(typeContrat, contrat.typeContrat) &&
                Objects.equals(salaire, contrat.salaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateDebut, typeContrat, salaire);
    }

    @Override
    public String toString() {
        return "Contrat{" +
                "dateDebut='" + dateDebut + '\'' +
                ", typeContrat='" + typeContrat + '\'' +
                ", salaire=" + salaire +
                '}';
    }
}
