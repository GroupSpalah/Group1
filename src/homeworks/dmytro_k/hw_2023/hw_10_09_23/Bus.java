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

    public Bus(int identifier, String numberplate, int numberOfPassengers, Fuel fuelType,
               LocalDate serviceDate, int contaminationIndicator) {
        super(identifier, numberplate, numberOfPassengers, fuelType, serviceDate);
        this.contaminationIndicator = contaminationIndicator;
        setStatus(serviceDate, contaminationIndicator);
    }

    public void setStatus(LocalDate serviceDate, int contaminationIndicator) {

        int monthsAfterService = LocalDate.now().getMonth().getValue() - serviceDate.getMonth().getValue();

        if (monthsAfterService >= 0 && monthsAfterService <= 6 && contaminationIndicator > 5) {
            this.status = Status.INOPERATION;
        } else if (monthsAfterService >= 0 && monthsAfterService <= 12
                && contaminationIndicator >= 3 && contaminationIndicator <= 5) {
            this.status = Status.NEEDSREPAIR;
        } else {
            this.status = Status.SCRAPPED;
        }
    }

    public int getContaminationIndicator() {
        return contaminationIndicator;
    }
}
