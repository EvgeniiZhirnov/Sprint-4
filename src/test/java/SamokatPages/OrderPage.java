package SamokatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {// первая страница заказа
        private WebDriver driver;
        private By nameField = By.xpath(".//*[@placeholder = '* Имя']");//поле имя
        private By secondNameField = By.xpath(".//*[@placeholder = '* Фамилия']");//поле фамилия
        private By adressField = By.xpath(".//*[@placeholder = '* Адрес: куда привезти заказ']");//поле адреса
        private By metroField = By.className("select-search__input");//выбор станции
        private By nextButton = By.cssSelector("[class = 'Button_Button__ra12g Button_Middle__1CSJM']");//кнопка далее
        private By numberField = By.xpath(".//*[@placeholder = '* Телефон: на него позвонит курьер']");//поле номера
        public OrderPage(WebDriver driver){
            this.driver = driver;
        }

        public void setname(String name) {
            driver.findElement(nameField).sendKeys(name);
        }
        public void setSecondname(String secondname) {
            driver.findElement(secondNameField).sendKeys(secondname);
        }
        public void setAdress(String adress) {
            driver.findElement(adressField).sendKeys(adress);
        }
        public void selectStation(String station) {
            driver.findElement(metroField).click();
            driver.findElement(By.xpath(".//*[text() = '"+station+"']")).click();
        }
        public void setNumber(String number) {
            driver.findElement(numberField).sendKeys(number);
        }
        public void clickNextButton() {
            driver.findElement(nextButton).click();
        }
        public void login(String name, String secondname, String adress, String station, String number){//для заполнения всех данных
            setname(name);
            setSecondname(secondname);
            setAdress(adress);
            selectStation(station);
            setNumber(number);
            clickNextButton();
        }
    }

