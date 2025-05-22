package entity;

import java.math.BigDecimal;
import java.util.Date;

public class VitalSignsDTO {
    private Date recordedAt;
    private Integer systolicBp;
    private Integer diastolicBp;
    private BigDecimal bodyTemperature;
    private Integer pulse;
    private Integer respiratoryRate;

    public VitalSignsDTO(Date recordedAt, Integer systolicBp, Integer diastolicBp,
    		BigDecimal bodyTemperature, Integer pulse, Integer respiratoryRate) {
        this.recordedAt = recordedAt;
        this.systolicBp = systolicBp;
        this.diastolicBp = diastolicBp;
        this.bodyTemperature = bodyTemperature;
        this.pulse = pulse;
        this.respiratoryRate = respiratoryRate;
	}

	public VitalSignsDTO() {

	}

	public Date getRecordedAt() {
		return recordedAt;
	}

	public void setRecordedAt(Date recordedAt) {
		this.recordedAt = recordedAt;
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

	public BigDecimal getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(BigDecimal bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public Integer getPulse() {
		return pulse;
	}

	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}

	public Integer getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(Integer respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}


}

