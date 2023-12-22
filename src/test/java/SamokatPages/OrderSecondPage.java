package SamokatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSecondPage {//вторая страница заказа
    private WebDriver driver;
    private By DataField = By.xpath(".//*[@placeholder = '* Когда привезти самокат']");
    private By PeriodField = By.className("Dropdown-placeholder");
    private By OrderButton = By.cssSelector("[class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private By FinishOrderButton = By.xpath(".//*[text() = 'Да']");
    private final By FinalWindow = By.xpath(".//*[text() = 'Посмотреть статус']");
    public OrderSecondPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectData(String data) {
        driver.findElement(DataField).click();
        driver.findElement(By.xpath(".//*[text() = '"+data+"']")).click();
    }

    public void selectPeriod(String period) {
        driver.findElement(PeriodField).click();
        driver.findElement(By.xpath(".//*[text() = '"+period+"']")).click();
}

public void clickOrderButton(){//нажатие на кнопку заказать
    driver.findElement(OrderButton).click();
    }

    public void clickFinishOrderButton(){//нажатие на кнопку "да" в окне подтверждения заказа
        driver.findElement(FinishOrderButton).click();
    }
    public void secondLogin(String data, String period){//для заполнения обязательных данных
        selectData(data);
        selectPeriod(period);
        clickOrderButton();
        clickFinishOrderButton();
    }

    public boolean checkFinalWindow() {
        return driver.findElements(FinalWindow).size() > 0;
    }

}