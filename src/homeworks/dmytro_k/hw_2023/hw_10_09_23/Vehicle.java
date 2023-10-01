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

public abstract class Vehicle {
    private final int identifier;
    private final String numberplate;
    private final int numberOfPassengers;
    protected Status status;
    private Fuel fuelType;
    private final LocalDate serviceDate;

    public Vehicle(int identifier, String numberplate, int numberOfPassengers, LocalDate serviceDate) {
        this.identifier = identifier;
        this.numberplate = numberplate;
        this.numberOfPassengers = numberOfPassengers;
        this.serviceDate = serviceDate;
    }

    public Vehicle(int identifier, String numberplate,
                   int numberOfPassengers, Fuel fuelType, LocalDate serviceDate) {
        this(identifier, numberplate, numberOfPassengers, serviceDate);
        this.fuelType = fuelType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(LocalDate serviceDate) {

        LocalDate sixMonthsAfterService = serviceDate.plusMonths(6);
        LocalDate thirtySixMonthsAfterService = serviceDate.plusMonths(36);

        int m6 = sixMonthsAfterService.compareTo(LocalDate.now());
        int m36 = thirtySixMonthsAfterService.compareTo(LocalDate.now());

        if (m6 >= 0) {
            this.status = Status.IN_OPERATION;
        } else if (m36 >= 0) {
            this.status = Status.NEEDS_REPAIR;
        } else {
            this.status = Status.SCRAPPED;
        }
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public Fuel getFuelType() {
        return fuelType;
    }

    public void setFuelType(Fuel fuelType) {
        this.fuelType = fuelType;
    }


    @Override
    public String toString() {
        return  status +
                ", identifier = " + identifier +
                ", numberplate = '" + numberplate + '\'' +
                ", numberOfPassengers = " + numberOfPassengers +
                ", fuelType = " + fuelType +
                ", serviceDate = " + serviceDate;
    }
}
