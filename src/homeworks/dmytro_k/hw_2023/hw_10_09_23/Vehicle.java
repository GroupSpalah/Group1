package homeworks.dmytro_k.hw_2023.hw_10_09_23;

import java.time.LocalDate;

/**
 * Все транспортные средства имеют внутренний уникальный идентификатор, номерной знак, максимальное количество
 * пассажиров, статус (требует ремонта / в эксплуатации / в утиль), тип топлива (электрический, газовый или гибридный)
 * и дату последнего обслуживания. В целом статус дается по времени последнего обслуживания
 * (0-6 месяцев «в эксплуатации», 7-36 «требует ремонта», 37+ «лом»).
 * Каждый тип транспортного средства имеет некоторые дополнительные характеристики:
 * <p>
 * Все автобусы работают на газе и имеют индикатор загрязнения. Автобус находится «в эксплуатации»,
 * если последний срок обслуживания был 0-6 месяцев назад и его показатель загрязнения выше 5;
 * «требует ремонта», если дата обслуживания была 0-12 месяцев назад и показатель загрязнения между
 * 3 и 5, и «в утиль» в противном случае.
 * Троллейбусы имеют как электрический, так и газовый двигатель (гибрид).
 * Все трамваи электрические и хранят количество лет эксплуатации.
 */

public class Vehicle {
    private int identifier;
    private String numberplate;
    private int numberOfPassengers;
    protected Status status;
    private Fuel fuelType; //задавать по умолчанию в потомках
    private LocalDate serviceDate;

    public Vehicle(int identifier, String numberplate, int numberOfPassengers, Fuel fuelType, LocalDate serviceDate) {
        this.identifier = identifier;
        this.numberplate = numberplate;
        this.numberOfPassengers = numberOfPassengers;
        this.fuelType = fuelType;
        this.serviceDate = serviceDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(LocalDate serviceDate) {

        int monthsAfterService = LocalDate.now().getMonth().getValue() - serviceDate.getMonth().getValue();

        if (monthsAfterService >= 0 && monthsAfterService <= 6) {
            this.status = Status.INOPERATION;
        } else if (monthsAfterService >= 7 && monthsAfterService <= 36) {
            this.status = Status.NEEDSREPAIR;
        } else if (monthsAfterService >= 37) {
            this.status = Status.SCRAPPED;
        }
    }
}
