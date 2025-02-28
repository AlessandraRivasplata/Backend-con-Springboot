package datatransfer;

import java.util.List;

import entity.Patient;

public class Wrapper<T> {
    private List<T> data;

    public Wrapper(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

