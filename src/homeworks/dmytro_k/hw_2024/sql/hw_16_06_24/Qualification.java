package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Qualification {
    LOW,
    MEDIUM,
    HIGH
}
