package homeworks.dmytro_k.hw_2023.hw_05_11_23;

import java.io.Serial;
import java.io.Serializable;

public record PlaceInfo(Os os, Browser browser) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}


