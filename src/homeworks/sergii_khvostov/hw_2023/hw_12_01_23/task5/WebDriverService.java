package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task5;

public class WebDriverService {
    public static void main(String[] args) {

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.close();
        chromeDriver.open();
        chromeDriver.getTitle();
        chromeDriver.navigate();

        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.close();
        firefoxDriver.open();
        firefoxDriver.getTitle();
        firefoxDriver.navigate();

        SafariDriver safariDriver = new SafariDriver();
        safariDriver.close();
        safariDriver.open();
        safariDriver.getTitle();
        safariDriver.navigate();
    }
}
