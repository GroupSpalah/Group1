package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetail {
    int productId;
    int quantity;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
