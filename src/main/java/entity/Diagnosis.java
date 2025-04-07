package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_diagnosis")
    @Column(name = "idDiagnosis")
    private Integer idDiagnosis;

    @OneToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "idPatient", nullable = false)
    private Patient patient;

    @JsonProperty("degree_of_dependence")
    @Column(name = "degree_of_dependence", length = 255, nullable = false)
    private String degreeOfDependence; // Autonom AVD, Dependent parcial, Dependent total

    @JsonProperty("oxygen_carrier")
    @Column(name = "oxygen_carrier")
    private Boolean oxygenCarrier; // TRUE/FALSE

    @JsonProperty("oxygen_carrier_observations")
    @Column(name = "oxygen_carrier_observations", length = 255)
    private String oxygenCarrierObservations;

    @JsonProperty("diaper_carrier")
    @Column(name = "diaper_carrier")
    private Boolean diaperCarrier; // TRUE/FALSE

    @JsonProperty("diaper_carrier_observations")
    @Column(name = "diaper_carrier_observations", length = 255)
    private String diaperCarrierObservations;

    @JsonProperty("urinary_catheter")
    @Column(name = "urinary_catheter")
    private Boolean urinaryCatheter; // TRUE/FALSE

    @JsonProperty("urinary_catheter_observations")
    @Column(name = "urinary_catheter_observations", length = 255)
    private String urinaryCatheterObservations;

    @JsonProperty("rectal_catheter")
    @Column(name = "rectal_catheter")
    private Boolean rectalCatheter; // TRUE/FALSE

    @JsonProperty("rectal_catheter_observations")
    @Column(name = "rectal_catheter_observations", length = 255)
    private String rectalCatheterObservations;

    @JsonProperty("nasogastric_catheter")
    @Column(name = "nasogastric_catheter")
    private Boolean nasogastricCatheter; // TRUE/FALSE

    @JsonProperty("nasogastric_catheter_observations")
    @Column(name = "nasogastric_catheter_observations", length = 255)
    private String nasogastricCatheterObservations;

    @JsonProperty("diagnosis_date")
    @Temporal(TemporalType.DATE)
    @Column(name = "diagnosis_date")
    private Date diagnosisDate;

    // Getters and Setters
    public Integer getIdDiagnosis() {
        return idDiagnosis;
    }

    public void setIdDiagnosis(Integer idDiagnosis) {
        this.idDiagnosis = idDiagnosis;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDegreeOfDependence() {
        return degreeOfDependence;
    }

    public void setDegreeOfDependence(String degreeOfDependence) {
        this.degreeOfDependence = degreeOfDependence;
    }

    public Boolean getOxygenCarrier() {
        return oxygenCarrier;
    }

    public void setOxygenCarrier(Boolean oxygenCarrier) {
        this.oxygenCarrier = oxygenCarrier;
    }

    public String getOxygenCarrierObservations() {
        return oxygenCarrierObservations;
    }

    public void setOxygenCarrierObservations(String oxygenCarrierObservations) {
        this.oxygenCarrierObservations = oxygenCarrierObservations;
    }

    public Boolean getDiaperCarrier() {
        return diaperCarrier;
    }

    public void setDiaperCarrier(Boolean diaperCarrier) {
        this.diaperCarrier = diaperCarrier;
    }

    public String getDiaperCarrierObservations() {
        return diaperCarrierObservations;
    }

    public void setDiaperCarrierObservations(String diaperCarrierObservations) {
        this.diaperCarrierObservations = diaperCarrierObservations;
    }

    public Boolean getUrinaryCatheter() {
        return urinaryCatheter;
    }

    public void setUrinaryCatheter(Boolean urinaryCatheter) {
        this.urinaryCatheter = urinaryCatheter;
    }

    public String getUrinaryCatheterObservations() {
        return urinaryCatheterObservations;
    }

    public void setUrinaryCatheterObservations(String urinaryCatheterObservations) {
        this.urinaryCatheterObservations = urinaryCatheterObservations;
    }

    public Boolean getRectalCatheter() {
        return rectalCatheter;
    }

    public void setRectalCatheter(Boolean rectalCatheter) {
        this.rectalCatheter = rectalCatheter;
    }

    public String getRectalCatheterObservations() {
        return rectalCatheterObservations;
    }

    public void setRectalCatheterObservations(String rectalCatheterObservations) {
        this.rectalCatheterObservations = rectalCatheterObservations;
    }

    public Boolean getNasogastricCatheter() {
        return nasogastricCatheter;
    }

    public void setNasogastricCatheter(Boolean nasogastricCatheter) {
        this.nasogastricCatheter = nasogastricCatheter;
    }

    public String getNasogastricCatheterObservations() {
        return nasogastricCatheterObservations;
    }

    public void setNasogastricCatheterObservations(String nasogastricCatheterObservations) {
        this.nasogastricCatheterObservations = nasogastricCatheterObservations;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }
}

