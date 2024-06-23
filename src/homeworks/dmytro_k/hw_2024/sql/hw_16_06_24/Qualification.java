package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Qualification {
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    private final String shortName;
}
