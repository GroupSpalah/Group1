package homeworks.dmytro_k.hw_2023.hw_05_11_23;

import java.io.Serializable;

public class PlaceInfo implements Comparable<PlaceInfo>, Serializable {
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

    public void setOs(Os os) {
        this.os = os;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    @Override
    public int compareTo(PlaceInfo o) {
        return 0;
    }
}
