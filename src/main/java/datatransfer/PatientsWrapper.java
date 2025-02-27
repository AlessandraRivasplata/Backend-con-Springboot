package datatransfer;

import java.util.List;

import entity.Patient;

public class PatientsWrapper {
    private List<Patient> patients;

    public PatientsWrapper(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}

