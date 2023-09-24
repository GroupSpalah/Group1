package homeworks.dmytro_k.hw_2023.hw_10_09_23;

/**
 * Все автобусы работают на газе и имеют индикатор загрязнения. Автобус находится «в эксплуатации»,
 * если последний срок обслуживания был 0-6 месяцев назад и его показатель загрязнения выше 5;
 * «требует ремонта», если дата обслуживания была 0-12 месяцев назад и показатель загрязнения между 3 и 5,
 * и «в утиль» в противном случае.
 */

import java.time.LocalDate;

public class Bus extends Vehicle {

    private int contaminationIndicator;

    public Bus(int identifier, String numberplate, int numberOfPassengers,
               LocalDate serviceDate, int contaminationIndicator) {
        super(identifier, numberplate, numberOfPassengers, serviceDate);
        super.setFuelType(Fuel.GAS);
        this.contaminationIndicator = contaminationIndicator;
        setStatus(serviceDate, contaminationIndicator);
    }

    public void setStatus(LocalDate serviceDate, int contaminationIndicator) {

        LocalDate sixMonthsAfterService = serviceDate.plusMonths(6);
        LocalDate twelveMonthsAfterService = serviceDate.plusMonths(12);

        int m6 = sixMonthsAfterService.compareTo(LocalDate.now());
        int m12 = twelveMonthsAfterService.compareTo(LocalDate.now());

        if (m6 >= 0 && contaminationIndicator > 5) {
            this.status = Status.IN_OPERATION;
        } else if (m12 >= 0 && contaminationIndicator >= 3 &&
                contaminationIndicator <= 5) {
            this.status = Status.NEEDS_REPAIR;
        } else {
            this.status = Status.SCRAPPED;
        }
    }
}
