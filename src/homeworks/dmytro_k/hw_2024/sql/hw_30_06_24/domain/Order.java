package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    int id;
    LocalDate orderDate;
    List<OrderDetail> orderDetails;

    public void addOrderDetail(OrderDetail orderDetail) {
        this.orderDetails.add(orderDetail);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
