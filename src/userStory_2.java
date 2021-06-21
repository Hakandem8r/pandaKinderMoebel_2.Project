import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class userStory_2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\PandaKindermoebel_SeleniumProject\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://pandakindermoebel.ch/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement cookies = driver.findElement(By.cssSelector("button[aria-label='Akzeptiere alle']"));
        cookies.click();

        WebElement meinKonto = driver.findElement(By.xpath("(//ul[@role='menubar'])[6]"));
        meinKonto.click();

        WebElement benutzerName = driver.findElement(By.cssSelector("input#username"));
        benutzerName.sendKeys("hakandem8r");

        WebElement passwort = driver.findElement(By.cssSelector("input#password"));
        passwort.sendKeys("S123456789.9!^");

        WebElement anmelden = driver.findElement(By.cssSelector("button[value='Anmelden']"));
        anmelden.click();

        WebElement shopPageBtn = driver.findElement(By.xpath("(//span[text()='Shop'])[2]"));
        shopPageBtn.click();

        Thread.sleep(6000);
        List<WebElement> underShop = driver.findElements(By.xpath("//ul[@class='list_shop_categories list-centered']/li"));
        underShop.get(new Random().nextInt(underShop.size())).click();

        Thread.sleep(6000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        List<WebElement> productRandom = driver.findElements(By.xpath("//ul[@class='products columns-3 category-grid-layout-1 product-grid-layout-1 ']/li"));
        productRandom.get(new Random().nextInt(productRandom.size())).click();

        WebElement warenkorb = driver.findElement(By.cssSelector("div[class='btn-text']"));
        warenkorb.click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Warenkorb anzeigen']")));
        WebElement warenkorbAnzeigen = driver.findElement(By.xpath("//span[text()='Warenkorb anzeigen']"));
        warenkorbAnzeigen.click();

        //scrollToElement
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='checkout-button button alt wc-forward']")));
        js.executeScript("window.scrollBy(0,800)");

        WebElement weiterZurKasse = driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']"));
        weiterZurKasse.click();

        WebElement rechnungVorname = driver.findElement(By.id("billing_first_name"));
        rechnungVorname.sendKeys("Tutus Test");

        WebElement rechnungNachname = driver.findElement(By.id("billing_last_name"));
        rechnungNachname.sendKeys("User");

        WebElement rechnungStrasse = driver.findElement(By.cssSelector("input[autocomplete=address-line1]"));
        rechnungStrasse.sendKeys("Descartes Weg, no: 1");

        WebElement rechnungPLZ = driver.findElement(By.id("billing_postcode"));
        rechnungPLZ.sendKeys("12450");

        WebElement rechnungStadt = driver.findElement(By.id("billing_city"));
        rechnungStadt.sendKeys("Berlin");

        WebElement rechnungPhone = driver.findElement(By.id("billing_phone"));
        rechnungPhone.sendKeys("01234567897");

        WebElement rechnungEmail = driver.findElement(By.id("billing_email"));
        rechnungEmail.sendKeys("");


        driver.quit();
    }
}

