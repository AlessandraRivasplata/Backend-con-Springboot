package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "idDiagnosis")
    private Integer id;

    @JsonProperty("autonomy")
    @Column(name = "autonomy", length = 255)
    private String autonomy;

    @JsonProperty("oxygen_carrier")
    @Column(name = "oxygenCarrier")
    private Boolean oxygenCarrier;

    @JsonProperty("oxygen_type")
    @Column(name = "oxygenType", length = 255)
    private String oxygenType;

    @JsonProperty("diaper_carrier")
    @Column(name = "diaperCarrier")
    private Boolean diaperCarrier;

    @JsonProperty("diaper_changes")
    @Column(name = "diaperChanges")
    private Integer diaperChanges;

    @JsonProperty("skin_condition")
    @Column(name = "skin_condition", length = 255)
    private String skinCondition;

    @JsonProperty("sv_type")
    @Column(name = "SVtype", length = 255)
    private String svType;

    @JsonProperty("sv_debit")
    @Column(name = "SVdebit", length = 255)
    private String svDebit;

    @JsonProperty("sv_description")
    @Column(name = "SVdescription", length = 255)
    private String svDescription;

    @JsonProperty("sr_debit")
    @Column(name = "SRdebit", length = 255)
    private String srDebit;

    @JsonProperty("sng_type")
    @Column(name = "SNGtype", length = 255)
    private String sngType;

    @JsonProperty("sng_description")
    @Column(name = "SNGdescription", length = 255)
    private String sngDescription;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutonomy() {
        return autonomy;
    }

    public void setAutonomy(String autonomy) {
        this.autonomy = autonomy;
    }

    public Boolean getOxygenCarrier() {
        return oxygenCarrier;
    }

    public void setOxygenCarrier(Boolean oxygenCarrier) {
        this.oxygenCarrier = oxygenCarrier;
    }

    public String getOxygenType() {
        return oxygenType;
    }

    public void setOxygenType(String oxygenType) {
        this.oxygenType = oxygenType;
    }

    public Boolean getDiaperCarrier() {
        return diaperCarrier;
    }

    public void setDiaperCarrier(Boolean diaperCarrier) {
        this.diaperCarrier = diaperCarrier;
    }

    public Integer getDiaperChanges() {
        return diaperChanges;
    }

    public void setDiaperChanges(Integer diaperChanges) {
        this.diaperChanges = diaperChanges;
    }

    public String getSkinCondition() {
        return skinCondition;
    }

    public void setSkinCondition(String skinCondition) {
        this.skinCondition = skinCondition;
    }

    public String getSvType() {
        return svType;
    }

    public void setSvType(String svType) {
        this.svType = svType;
    }

    public String getSvDebit() {
        return svDebit;
    }

    public void setSvDebit(String svDebit) {
        this.svDebit = svDebit;
    }

    public String getSvDescription() {
        return svDescription;
    }

    public void setSvDescription(String svDescription) {
        this.svDescription = svDescription;
    }

    public String getSrDebit() {
        return srDebit;
    }

    public void setSrDebit(String srDebit) {
        this.srDebit = srDebit;
    }

    public String getSngType() {
        return sngType;
    }

    public void setSngType(String sngType) {
        this.sngType = sngType;
    }

    public String getSngDescription() {
        return sngDescription;
    }

    public void setSngDescription(String sngDescription) {
        this.sngDescription = sngDescription;
    }
}

