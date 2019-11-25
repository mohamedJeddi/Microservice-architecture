package com.esprit.formation.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class TrainingPlan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String label;

    @OneToMany(mappedBy = "trainingPlan", fetch = FetchType.LAZY)
    private List<TrainingSession> sessions;

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

    public List<TrainingSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<TrainingSession> sessions) {
        this.sessions = sessions;
    }

    public TrainingPlan addTrainingSession (TrainingSession trainingSession){
        this.sessions.add(trainingSession);
        trainingSession.setTrainingPlan(this);
        return this;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public TrainingPlan() {
    }

    public TrainingPlan(String code, String label) {
        this.code = code;
        this.label=label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingPlan that = (TrainingPlan) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "TrainingPlan{" +
                "code='" + code + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
