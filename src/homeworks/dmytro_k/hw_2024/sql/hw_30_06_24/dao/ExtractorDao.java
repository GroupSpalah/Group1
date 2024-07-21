package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao;

import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain.Order;

import java.util.List;

public interface ExtractorDao {//rename
    Order getOrderDetails(int orderId);

    List<Integer> getOrdersBySumAndProductCount(float sum, int productCount);

    List<Integer> getOrdersContainingProduct(int productId);

    List<Integer> getOrdersNotContainingProductToday(int productId);
}
