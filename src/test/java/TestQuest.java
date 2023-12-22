import SamokatPages.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

@RunWith(Parameterized.class)

public class TestQuest {

 private final String textAnswer;
 private final int indexQA;


public TestQuest(int indexQA, String textAnswer){
    this.indexQA = indexQA;
    this.textAnswer = textAnswer;
}
@Parameterized.Parameters
    public static Object[][] getText() {
    return new Object[][] {
            {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
            {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
    };
}

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void questionTest() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement element = driver.findElement(By.id("accordion__heading-1"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    MainPage objMainPage = new MainPage(driver);
        objMainPage.question(indexQA);
    assertEquals(textAnswer, objMainPage.answer(indexQA));
        driver.quit();
}
}
