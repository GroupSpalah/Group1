package homeworks.vladyslav_lazin.hw_2023.hw_01_10_23;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OilExtraxtorsTest {
    public final static OilExtractorService oilExtractorService = new OilExtractorService();
    public static void main(String[] args) {
        OilExtractor oilExtractor1 = new StationaryGroundExtractor("45775864", 2000, 1950,
                Map.of(Placement.LATITUDE, 51.345, Placement.LONGTITUDE, 45.333));
        OilExtractor oilExtractor2 = new StationaryGroundExtractor("45770977", 2000, 1200,
                Map.of(Placement.LATITUDE, 50.066, Placement.LONGTITUDE, 42.560));
        OilExtractor oilExtractor3 = new MobileGroundExtractor("457F78977", 2000, 1200,
                Map.of(Placement.LATITUDE, 51.986, Placement.LONGTITUDE, 43.789));
        OilExtractor oilExtractor4 = new MobileGroundExtractor("4577M0977", 2000, 400,
                Map.of(Placement.LATITUDE, 51.986, Placement.LONGTITUDE, 43.789));
        OilExtractor oilExtractor5 = new SeaPlatform("65634347SP", 3000, 2950,
                List.of(new Worker("John Doe", Position.MANAGER, 12),
                        new Worker("Ben Smith", Position.WORKER, 10),
                        new Worker("Elisa Day", Position.MEDIC, 5),
                        new Worker("Keith Moon", Position.WORKER, 7),
                        new Worker("Eric Cartman", Position.MANAGER, 11)));
        OilExtractor oilExtractor6 = new SeaPlatform("65636967SP", 3000, 1500,
                List.of(new Worker("John Doe", Position.MANAGER, 12),
                        new Worker("Ben Smith", Position.WORKER, 10),
                        new Worker("Elisa Day", Position.MEDIC, 5),
                        new Worker("Keith Moon", Position.WORKER, 7),
                        new Worker("Eric Cartman", Position.MANAGER, 11)));
        OilExtractor oilExtractor7 = new SeaPlatform("6123677SP", 3000, 3000,
                List.of(new Worker("John Doe", Position.WORKER, 12),
                        new Worker("Ben Smith", Position.WORKER, 10),
                        new Worker("Elisa Day", Position.MANAGER, 5),
                        new Worker("Keith Moon", Position.WORKER, 7),
                        new Worker("Eric Cartman", Position.MANAGER, 11)));
        OilExtractor oilExtractor8 = new SeaPlatform("656097877SP", 3000, 1500,
                List.of(new Worker("John Doe", Position.MANAGER, 12),
                        new Worker("Ben Smith", Position.WORKER, 10),
                        new Worker("Elisa Day", Position.MEDIC, 19),
                        new Worker("Keith Moon", Position.WORKER, 7),
                        new Worker("Eric Cartman", Position.MANAGER, 11)));
        List<OilExtractor> oilExtractors = List.of(oilExtractor1, oilExtractor2, oilExtractor3, oilExtractor4,oilExtractor5, oilExtractor6, oilExtractor7, oilExtractor8);
        long numberOfErrors = oilExtractorService.inspectForErrors(oilExtractors);
        List<OilExtractor> bestOilextractors = oilExtractorService.findBestExtracors(oilExtractors);

        System.out.println("Number of errors: " + numberOfErrors);
        System.out.println("The best oil extractors");
        bestOilextractors.forEach(oilExtractor -> System.out.println(oilExtractor.getSerialNumber()));
    }
}
