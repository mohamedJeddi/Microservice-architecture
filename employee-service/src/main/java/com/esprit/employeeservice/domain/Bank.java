package com.esprit.employeeservice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String bankPaymentMode;

    private String bankName;

    private String bankCode;

    private String bankAgencyName;

    private String bankAgencyCode;

    private String bankRIB;

    private String bankBIC;

    private String bankIBAN;

    @OneToMany(mappedBy = "bank", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Employee> employees;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankPaymentMode() {
        return bankPaymentMode;
    }

    public void setBankPaymentMode(String bankPaymentMode) {
        this.bankPaymentMode = bankPaymentMode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankAgencyName() {
        return bankAgencyName;
    }

    public void setBankAgencyName(String bankAgencyName) {
        this.bankAgencyName = bankAgencyName;
    }

    public String getBankAgencyCode() {
        return bankAgencyCode;
    }

    public void setBankAgencyCode(String bankAgencyCode) {
        this.bankAgencyCode = bankAgencyCode;
    }

    public String getBankRIB() {
        return bankRIB;
    }

    public void setBankRIB(String bankRIB) {
        this.bankRIB = bankRIB;
    }

    public String getBankBIC() {
        return bankBIC;
    }

    public void setBankBIC(String bankBIC) {
        this.bankBIC = bankBIC;
    }

    public String getBankIBAN() {
        return bankIBAN;
    }

    public void setBankIBAN(String bankIBAN) {
        this.bankIBAN = bankIBAN;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Bank addEmployees(Employee employee){
        this.employees.add(employee);
        employee.setBank(this);
        return this;
    }

    public Bank() {
    }

    public Bank(String bankPaymentMode, String bankName, String bankCode, String bankAgencyName, String bankAgencyCode, String bankRIB, String bankBIC, String bankIBAN) {
        this.bankPaymentMode = bankPaymentMode;
        this.bankName = bankName;
        this.bankCode = bankCode;
        this.bankAgencyName = bankAgencyName;
        this.bankAgencyCode = bankAgencyCode;
        this.bankRIB = bankRIB;
        this.bankBIC = bankBIC;
        this.bankIBAN = bankIBAN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return id.equals(bank.id) &&
            bankRIB.equals(bank.bankRIB) &&
            bankBIC.equals(bank.bankBIC) &&
            bankIBAN.equals(bank.bankIBAN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankRIB, bankBIC, bankIBAN);
    }

    @Override
    public String toString() {
        return "Bank{" +
            "bankPaymentMode='" + bankPaymentMode + '\'' +
            ", bankName='" + bankName + '\'' +
            ", bankCode='" + bankCode + '\'' +
            ", bankAgencyName='" + bankAgencyName + '\'' +
            ", bankAgencyCode='" + bankAgencyCode + '\'' +
            ", bankRIB='" + bankRIB + '\'' +
            ", bankBIC='" + bankBIC + '\'' +
            ", bankIBAN='" + bankIBAN + '\'' +
            '}';
    }
}
