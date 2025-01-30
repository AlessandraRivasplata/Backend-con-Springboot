package datatransfer;

import java.util.List;

import entity.Nurse;

public class NursesWrapper {
    private List<Nurse> nurses;

    // Constructor, getters y setters
    public NursesWrapper(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }
}