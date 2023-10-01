package lessons.streams.dental.service;


import lessons.streams.dental.domain.HistoricalRecord;
import lessons.streams.dental.domain.Patient;
import lessons.streams.dental.domain.Specialisation;
import lessons.streams.dental.domain.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DentalService {
    private Map<Patient, List<HistoricalRecord>> map;

    public DentalService() {
        map = new HashMap<>();
    }

    public void addPatient(Patient patient, HistoricalRecord record) {
        if (map.containsKey(patient)) {
            List<HistoricalRecord> records = map.get(patient);

            records.add(record);

            if (records.size() > 3) {
                patient.setStatus(Status.LOYAL_CUSTOMER);
            }
        } else {
            List<HistoricalRecord> list = new ArrayList<>(List.of(record));
            map.put(patient, list);
        }

    }

    public void showPatientOfStaff(String name) {
        map.forEach((key, value) -> {
             value
                    .stream()
                    .flatMap(hr -> hr.getStaffRecords().stream())
                    .filter(entry -> entry.getName().equals(name))
                    .forEach(System.out::println);

        });

    }

    public void showListOfProcedure(Specialisation specialisation, LocalDate from, LocalDate to) {
        map.forEach((key, value) -> {

            value
                    .stream()
                    .filter(hr -> {
                        LocalDate date = hr.getVisit().getDate();
                        return date.isAfter(from) && date.isBefore(to);
                    })
                    .flatMap(hr -> hr.getStaffRecords().stream())
                    .filter(staff -> staff.getSpecialisation() == specialisation)
                    .forEach(System.out::println);
        });

    }

}
