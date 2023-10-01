package lessons.streams.dental.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HistoricalRecord {
    private TypeOfProcedure type;
    private String description;
    private int toothNumber;
    private List<StaffRecord> staffRecords;
    private Visit visit;

    public HistoricalRecord(TypeOfProcedure type, String description, int toothNumber) {
        this.type = type;
        this.description = description;
        this.toothNumber = toothNumber;
        staffRecords = new ArrayList<>();
    }

    public Visit getVisit() {
        return visit;
    }

    public TypeOfProcedure getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getToothNumber() {
        return toothNumber;
    }

    public List<StaffRecord> getStaffRecords() {
        return staffRecords;
    }

    public void addStaffRecord(StaffRecord staffRecord) {
        staffRecords.add(staffRecord);
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricalRecord that = (HistoricalRecord) o;
        return toothNumber == that.toothNumber && type == that.type &&
                Objects.equals(description, that.description)
                && Objects.equals(staffRecords, that.staffRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, description, toothNumber, staffRecords);
    }

    @Override
    public String toString() {
        return "HistoricalRecord: " +
                "type=" + type +
                ", description='" + description + '\'' +
                ", toothNumber=" + toothNumber +
                ", personnel=" + staffRecords;
    }
}
