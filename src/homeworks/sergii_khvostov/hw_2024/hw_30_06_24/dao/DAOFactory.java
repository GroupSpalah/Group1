package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao;

public class DAOFactory {

    public static OrderDAO getOrderDAO() {
        return new OrderDAO();
    }

    public static ProductDAO getProductDAO() {
        return new ProductDAO();
    }
}

