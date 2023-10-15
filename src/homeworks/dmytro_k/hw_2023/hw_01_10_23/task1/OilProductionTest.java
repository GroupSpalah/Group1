package homeworks.dmytro_k.hw_2023.hw_01_10_23.task1;

public class OilProductionTest {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Sam", Post.MANAGER, 15);
        Employee employee2 = new Employee("Dan", Post.MEDIC, 13);
        Employee employee3 = new Employee("Tom", Post.WORKER, 10);

        SeaPlatform seaPlatform1 = new SeaPlatform(20, 2);
        SeaPlatform seaPlatform2 = new SeaPlatform(20, 19.6);
        SeaPlatform seaPlatform3 = new SeaPlatform(20, 18);

        MobileExtractor mobileExtractor1 = new MobileExtractor(30.5, 3);
        MobileExtractor mobileExtractor2 = new MobileExtractor(30.5, 5);
        MobileExtractor mobileExtractor3 = new MobileExtractor(30.5, 29.5);

        seaPlatform1.addEmployee(employee1);
        seaPlatform2.addEmployee(employee2);
        seaPlatform1.addEmployee(employee3);

        seaPlatform1.seaPlatformError();
        seaPlatform2.seaPlatformError();
        seaPlatform3.seaPlatformError();

        seaPlatform1.seaPlatformError2();
        seaPlatform2.seaPlatformError2();
        seaPlatform3.seaPlatformError2();

        mobileExtractor1.mobileExtractorError();
        mobileExtractor2.mobileExtractorError();
        mobileExtractor3.mobileExtractorError();

        mobileExtractor1.mobileExtractorError2();
        mobileExtractor2.mobileExtractorError2();
        mobileExtractor3.mobileExtractorError2();

        OilProductionService oilProductionService = new OilProductionService();

        oilProductionService.addExtractor(seaPlatform1);
        oilProductionService.addExtractor(seaPlatform2);
        oilProductionService.addExtractor(seaPlatform3);

        oilProductionService.addExtractor(mobileExtractor1);
        oilProductionService.addExtractor(mobileExtractor2);
        oilProductionService.addExtractor(mobileExtractor3);

        oilProductionService.topExtractor();
        //oilProductionService.extractorError();
    }
}
