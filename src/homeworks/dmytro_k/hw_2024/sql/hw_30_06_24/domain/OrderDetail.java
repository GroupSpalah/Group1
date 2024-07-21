package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetail {
    //int productId;
    Product product;
    int quantity;
    //int orderId;//? manyToOne отношение к ордеру и убрать лист деталей


    @Override
    public String toString() {
        return "\n{ " +
                product +
                ", quantity=" + quantity +
                " }";
    }
}
