package com.esprit.employeeservice.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String registrationNumber;

    private String firstName;

    private String lastName;

    private String birthDay;

    private String sexe;

    private String nationalite;

    private String identityCard;

    private String addresse;

    private String phone;

    private String email;

    @ManyToOne
    private Bank bank;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }


    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }


    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Employee addBank(Bank bank){
        this.bank=bank;
        return this;
    }

    public Employee() {
    }

    public Employee(String registrationNumber, String firstName, String lastName, String birthDay, String sexe, String nationalite, String identityCard, String addresse, String phone, String email) {
        this.registrationNumber = registrationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.identityCard = identityCard;
        this.addresse = addresse;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) &&
            registrationNumber.equals(employee.registrationNumber) &&
            email.equals(employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationNumber, email);
    }

    @Override
    public String toString() {
        return "employee{" +
            "registrationNumber='" + registrationNumber + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
