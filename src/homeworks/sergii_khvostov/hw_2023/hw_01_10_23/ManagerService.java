package homeworks.sergii_khvostov.hw_2023.hw_01_10_23;

import java.util.List;
import java.util.ArrayList;
public class ManagerService {
    public static void main(String[] args) {
        OilExtractorManager manager = new OilExtractorManager();

        List<SeaPlatform> seaPlatforms = new ArrayList<>();

        List<Worker> workers1 = new ArrayList<>();
        workers1.add(new Worker("John", WorkerRole.WORKER, 12));
        workers1.add(new Worker("Alice", WorkerRole.MANAGER, 13));
        SeaPlatform seaPlatform1 = new SeaPlatform("SP01", workers1, 150,
                120, false);
        seaPlatforms.add(seaPlatform1);

        List<Worker> workers2 = new ArrayList<>();
        workers2.add(new Worker("Bob", WorkerRole.WORKER, 10));
        workers2.add(new Worker("Eve", WorkerRole.MEDIC, 15));
        SeaPlatform seaPlatform2 = new SeaPlatform("SP02", workers2, 200,
                180, false);
        seaPlatforms.add(seaPlatform2);

        manager.checkSeaPlatformErrors(seaPlatforms);

        System.out.println("Sea platforms with bugs:");
        for (SeaPlatform platform : seaPlatforms) {
            if (platform.isHasError()) {
                System.out.println("Platform S/N: " + platform.getSerialNumber());
                System.out.println("Current performance: " + platform.getActualProductivity());
                System.out.println("Planned power: " + platform.getPlannedProductivity());
                System.out.println("List of mainOrganizer: " + platform.getWorkers());
            }
        }
    }
}