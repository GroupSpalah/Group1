package lessons.streams.dental;


import lessons.streams.dental.domain.*;
import lessons.streams.dental.service.DentalService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        Patient patient1 = new Patient("Bob", 1);
        Patient patient2 = new Patient("Joe", 2);
        Patient patient3 = new Patient("Ann", 3);
        Patient patient4 = new Patient("Kate", 4);
        Patient patient5 = new Patient("Sagamore", 5);
        Patient patient6 = new Patient("Dan", 6);

        StaffRecord staff1 = new StaffRecord("Damian", Specialisation.DENTIST);
        StaffRecord staff2 = new StaffRecord("Michal", Specialisation.X_RAY_TECHNICIAN);
        StaffRecord staff3 = new StaffRecord("Natalia", Specialisation.DENTAL_HYGIENIST);

        Visit visit1 = new Visit(LocalDate.of(2022, 9, 10));
        Visit visit2 = new Visit(LocalDate.of(2022, 10, 15));
        Visit visit3 = new Visit(LocalDate.of(2022, 11, 10));
        Visit visit4 = new Visit(LocalDate.of(2022, 12, 6));
        Visit visit5 = new Visit(LocalDate.of(2022, 11, 20));
        Visit visit6 = new Visit(LocalDate.of(2022, 12, 12));



        HistoricalRecord hist1 = new HistoricalRecord(TypeOfProcedure.BBB, "gvhadniinj cns bna", 6);
        HistoricalRecord hist2 = new HistoricalRecord(TypeOfProcedure.AAA, "gvhadniinj cns bna", 2);
        hist1.addStaffRecord(staff1);
        hist1.addStaffRecord(staff1);
        hist1.setVisit(visit1);
        hist2.addStaffRecord(staff2);
        hist2.setVisit(visit3);


        DentalService service = new DentalService();
        service.addPatient(patient1, hist1);
        service.addPatient(patient2, hist2);
        service.addPatient(patient3, hist2);

//        service.showPatientOfStaff("Damian");

        LocalDate from = LocalDate.of(2022, 8, 1);
        LocalDate to = LocalDate.of(2022, 11, 1);

        service.showListOfProcedure(Specialisation.DENTIST, from, to);

    }
}
