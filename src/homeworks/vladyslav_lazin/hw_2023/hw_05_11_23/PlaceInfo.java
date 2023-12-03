package homeworks.vladyslav_lazin.hw_2023.hw_05_11_23;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class PlaceInfo implements Serializable {
    private Os os;
    private Browser browser;
    @Serial
    private static final long serialVersionUID = 1L;

    public PlaceInfo(Os os, Browser browser) {
        this.os = os;
        this.browser = browser;
    }

    @Override
    public String toString() {
        return "PlaceInfo{" +
                "os=" + os +
                ", browser=" + browser +
                '}';
    }

    public Os getOs() {
        return os;
    }

    public Browser getBrowser() {
        return browser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaceInfo placeInfo)) return false;
        return os == placeInfo.os && browser == placeInfo.browser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(os, browser);
    }
}
