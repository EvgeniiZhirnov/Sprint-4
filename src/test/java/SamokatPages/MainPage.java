package SamokatPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {//главная страница
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void question(int indexQA){//кликнуть на вопрос
driver.findElement(By.id(String.format("accordion__heading-%d", indexQA))).click();
    }
    public String answer(int indexQA){//получить текст ответа
        return driver.findElement(By.id(String.format("accordion__panel-%d", indexQA))).getText();
    }

    public void clickCookieButton() {//принять куки
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    }

    public void upOrderButton() {//нажать на верхнюю кнопку заказа
        driver.findElement(By.className("Button_Button__ra12g")).click();
    }

    public void downOrderButton(){//нажать на нижнюю кнопку заказа
        driver.findElement(By.cssSelector("[class = 'Button_Button__ra12g Button_Middle__1CSJM']")).click();
    }
}

