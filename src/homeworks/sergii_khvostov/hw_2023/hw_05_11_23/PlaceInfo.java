package homeworks.sergii_khvostov.hw_2023.hw_05_11_23;

import java.io.Serializable;

public class PlaceInfo implements Serializable {
    private Os os;
    private Browser browser;

    public PlaceInfo(Os os, Browser browser) {
        this.os = os;
        this.browser = browser;
    }

    public Os getOs() {
        return os;
    }

    public Browser getBrowser() {
        return browser;
    }

    @Override
    public String toString() {
        return "OS: " + os + ", Browser: " + browser;
    }
}
