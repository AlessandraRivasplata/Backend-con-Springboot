package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Drainage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_drainage")
    @Column(name = "idDrainage")
    private Integer idDrainage;

    @ManyToOne
    @JoinColumn(name = "idPatient", nullable = false)
    @JsonProperty("patient")
    private Patient patient;

    @JsonProperty("drainage_type")
    @Column(name = "drainageType", length = 255, nullable = false)
    private String drainageType;

    @JsonProperty("drainage_debit")
    @Column(name = "drainageDebit", nullable = false)
    private Integer drainageDebit;

    @JsonProperty("note")
    @Column(name = "note", length = 500)
    private String note;

    // Getters y Setters
    public Integer getIdDrainage() {
        return idDrainage;
    }

    public void setIdDrainage(Integer idDrainage) {
        this.idDrainage = idDrainage;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDrainageType() {
        return drainageType;
    }

    public void setDrainageType(String drainageType) {
        this.drainageType = drainageType;
    }

    public Integer getDrainageDebit() {
        return drainageDebit;
    }

    public void setDrainageDebit(Integer drainageDebit) {
        this.drainageDebit = drainageDebit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
