package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account_page {
    WebDriver driver;
    public Account_page(WebDriver driver) {
        this.driver=driver;
    }
    private By showing_word = By.xpath("//p[text()='Welcome to OpenCart!']");
    public String getsuccsesmassege(){
       String massege=driver.findElement(showing_word).getText();
       return massege;
    }
}
