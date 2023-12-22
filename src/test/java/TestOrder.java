import SamokatPages.MainPage;
import SamokatPages.OrderPage;
import SamokatPages.OrderSecondPage;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class TestOrder {

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void OrderTest() {//тест на заказ при нажатии верхней кнопки "Заказать"
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickCookieButton();
        objMainPage.upOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.login("Семен", "Ананасов", "Улица Пушкина", "Сокол", "89263884461");
        OrderSecondPage objOrderSecondPage = new OrderSecondPage(driver);
        objOrderSecondPage.secondLogin("25", "двое суток");
        assertTrue(objOrderSecondPage.checkFinalWindow());
        driver.quit();
    }

    @Test
    public void DownOrderTest() {//тест на заказ при нажатии нижней кнопки "Заказать"
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickCookieButton();
        objMainPage.downOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.login("Семен", "Ананасов", "Улица Пушкина", "Сокольники", "89263884461");
        OrderSecondPage objOrderSecondPage = new OrderSecondPage(driver);
        objOrderSecondPage.secondLogin("25", "двое суток");
        assertTrue(objOrderSecondPage.checkFinalWindow());
        driver.quit();
    }
}
