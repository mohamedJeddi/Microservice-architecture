package com.esprit.departementservice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Participator implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String RegistrationNumber;

    private String email;

    @ManyToOne
    @JsonBackReference
    private Deaprtement deaprtement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Participator() {
    }

    public Participator(String registrationNumber, String email) {
        RegistrationNumber = registrationNumber;
        this.email = email;
    }

    public Deaprtement getDeaprtement() {
        return deaprtement;
    }

    public void setDeaprtement(Deaprtement deaprtement) {
        this.deaprtement = deaprtement;
    }

    public Participator addDepartement(Deaprtement deaprtement){
        this.deaprtement=deaprtement;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participator that = (Participator) o;
        return Objects.equals(RegistrationNumber, that.RegistrationNumber) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RegistrationNumber, email);
    }

    @Override
    public String toString() {
        return "Participator{" +
                "RegistrationNumber='" + RegistrationNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
