package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_patient")
    @Column(name = "idPatient")
    private Integer idPatient;

    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "id_diagnosis", nullable = false)
    private Diagnosis diagnosis;

    @JsonProperty("name")
    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @JsonProperty("surname")
    @Column(name = "surname", length = 255, nullable = false)
    private String surname;

    @JsonProperty("birth_date")
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @JsonProperty("address")
    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @JsonProperty("language")
    @Column(name = "language", length = 255, nullable = false)
    private String language;

    @JsonProperty("medical_history")
    @Column(name = "medical_history", length = 500)
    private String medicalHistory;

    @JsonProperty("hygiene")
    @Column(name = "hygiene", length = 255)
    private String hygiene;

    @JsonProperty("allergies")
    @Column(name = "allergies", length = 255)
    private String allergies;

    @JsonProperty("familiar_info")
    @Column(name = "familiar_info", length = 500)
    private String familiarInfo;

    // Getters y Setters
    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getHygiene() {
        return hygiene;
    }

    public void setHygiene(String hygiene) {
        this.hygiene = hygiene;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getFamiliarInfo() {
        return familiarInfo;
    }

    public void setFamiliarInfo(String familiarInfo) {
        this.familiarInfo = familiarInfo;
    }
}
