package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

public class ConstructionService {
    public long getWorkersNumber(ConstructionSite constructionSite) {
        return constructionSite.getStaff().size();
    }
//    public float calculateStaffSalary(ConstructionSite constructionSite, int workTime) {
//        return constructionSite.getStaff()
//                .stream()
//                .reduce(0, (accumulator, element) -> accumulator + element.calculateSalary(workTime));
//
//    }
}
