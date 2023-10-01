package lessons.streams.dental.domain;

public class Patient {
    private String name;
    private int id;
    private Status status;

    public Patient(String name, int id) {
        this.name = name;
        this.id = id;
        this.status = Status.CUSTOMER;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "PatientRecord: " + " name= " + name +
                ", id=" + id +
                ", status=" + status;
    }
}
