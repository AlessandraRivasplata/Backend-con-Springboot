package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Care {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_care")
    @Column(name = "idCare")
    private Integer idCare;

    @ManyToOne
    @JoinColumn(name = "idPatient", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "idNurse", nullable = false)
    private Nurse nurse;

    @JsonProperty("systolic_bp")
    @Column(name = "systolic_bp", nullable = false)
    private Integer systolicBp;

    @JsonProperty("diastolic_bp")
    @Column(name = "diastolic_bp", nullable = false)
    private Integer diastolicBp;

    @JsonProperty("respiratory_rate")
    @Column(name = "respiratory_rate", nullable = false)
    private Integer respiratoryRate;

    @JsonProperty("pulse")
    @Column(name = "pulse", nullable = false)
    private Integer pulse;

    @JsonProperty("body_temperature")
    @Column(name = "body_temperature", precision = 5, scale = 2, nullable = false)
    private BigDecimal bodyTemperature;

    @JsonProperty("oxygen_saturation")
    @Column(name = "oxygen_saturation", precision = 5, scale = 2, nullable = false)
    private BigDecimal oxygenSaturation;
    
    @JsonProperty("drainage_type")
    @Column(name = "drainageType", length = 255)
    private String drainageType;

    @JsonProperty("drainage_debit")
    @Column(name = "drainageDebit")
    private Integer drainageDebit;
    
    @JsonProperty("hygine_type")
    @Column(name = "hygieneType", length = 255)
    private String hygieneType;

    @JsonProperty("sedation")
    @Column(name = "sedation", length = 255)
    private String sedation;
    
    @JsonProperty("ambulation")
    @Column(name = "ambulation", length = 255)
    private String ambulation;
    
    @JsonProperty("postural_changes")
    @Column(name = "posturalChanges", length = 255)
    private String posturalChanges;
    
    @JsonProperty("recorded_at")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "recorded_at", nullable = false)
    private Date recordedAt;
    
    @JsonProperty("note")
    @Column(name = "note", length = 500)
    private String note;

    // Getters y Setters
    public Integer getIdCare() {
        return idCare;
    }

    public void setIdCare(Integer idCare) {
        this.idCare = idCare;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;

    }
    
    public Integer getSystolicBp() {
        return systolicBp;
    }

    public void setSystolicBp(Integer systolicBp) {
        this.systolicBp = systolicBp;
    }

    public Integer getDiastolicBp() {
        return diastolicBp;
    }

    public void setDiastolicBp(Integer diastolicBp) {
        this.diastolicBp = diastolicBp;
    }

    public Integer getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(Integer respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public BigDecimal getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(BigDecimal bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public BigDecimal getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(BigDecimal oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public Date getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(Date recordedAt) {
        this.recordedAt = recordedAt;
    }
}

