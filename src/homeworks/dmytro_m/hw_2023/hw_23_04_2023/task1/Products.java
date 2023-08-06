package homeworks.dmytro_m.hw_2023.hw_23_04_2023.task1;

import java.time.Month;
import java.util.ArrayList;

public interface Products {
    Month[] month = Month.values();
    ArrayList<Integer> salary = null;


    default Month getMonth(int i) {
        return month[i];
    }

    default ArrayList<Integer> getSalaries() {
        return salary;
    }

    default int getSalary(int i) {
        return salary.get(i);
    }

    default Month[] getMonth() {
        return month;
    }
}
