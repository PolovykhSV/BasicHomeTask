import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by polovykh-sv on 05.10.2016.
 */
public class LoginEmailBox {
    WebDriver driver;
//    String adress;
//    String login;
//    String password;
//    String validate;

    @BeforeTest
    void openSource () throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/chr/chromedriver.exe");
        driver = new ChromeDriver();
//        adress = "https://mail.ru/";
//        login = "test_testing1";
//        password = "test123456";
//        validate = "https://e.mail.ru/messages/inbox/?back=1";
        }

       @Test
       @Parameters ({"adress", "login", "password", "validate"})
    public void loadEmail(String adress, String login, String password, final String validate) throws Exception{
        driver.get(adress);

           WebElement element = driver.findElement(By.name("Login"));
           element.sendKeys(login);
           WebElement element1 = driver.findElement(By.name("Password"));
           element1.sendKeys(password);
           element1.submit();
           System.out.println("Page CurrentURL is:"+driver.getCurrentUrl());
           (new WebDriverWait(driver, 6)).until(new ExpectedCondition<Boolean>() {
               public Boolean apply(WebDriver d) {
                   return d.getCurrentUrl().startsWith(validate);
               }
           });
           System.out.println("Congratulate! Test is successful");
       }
}
