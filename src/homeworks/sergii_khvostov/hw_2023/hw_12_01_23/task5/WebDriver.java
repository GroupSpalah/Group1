package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task5;

/*Provide Implementation for the diagram below. Then
create a test class in which you need to create Objects of
ChromeDriver, FirefoxDrive and SafariDriver classes and
see which methods available to them.*/

public interface WebDriver {

    void open();

    void close();

    String getTitle();
}
