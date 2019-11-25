package com.esprit.formation.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class TrainingSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String label;

    private String trainingOfferCode;

    private Double cost;

    private String currency;

    @OneToMany(mappedBy = "trainingSession", fetch = FetchType.LAZY)
    private List<Participator> participators;

    @ManyToOne
    @JsonBackReference
    private TrainingPlan trainingPlan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTrainingOfferCode() {
        return trainingOfferCode;
    }

    public void setTrainingOfferCode(String trainingOfferCode) {
        this.trainingOfferCode = trainingOfferCode;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Participator> getParticipators() {
        return participators;
    }

    public void setParticipators(List<Participator> participators) {
        this.participators = participators;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public TrainingSession addTrainingPlan(TrainingPlan trainingPlan){
        this.trainingPlan=trainingPlan;
        return this;
    }

    public TrainingSession addParticipator(Participator participator){
        this.participators.add(participator);
        participator.setTrainingSession(this);
        return this;
    }

    public TrainingSession() {
    }

    public TrainingSession(String code, String label, String trainingOfferCode, Double cost, String currency, List<Participator> participators) {
        this.code = code;
        this.label = label;
        this.trainingOfferCode = trainingOfferCode;
        this.cost = cost;
        this.currency = currency;
        this.participators = participators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingSession that = (TrainingSession) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "TrainingSession{" +
            "code='" + code + '\'' +
            ", label='" + label + '\'' +
            '}';
    }
}
