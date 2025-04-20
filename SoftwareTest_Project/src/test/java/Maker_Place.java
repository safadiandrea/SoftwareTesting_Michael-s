import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;


public class Maker_Place {

    // automated test of michael's video player on makerplace
    @Test public void videoPlayer() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(4000);

        // initialize WebElement and click on makerplace page
        WebElement makerplace = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"__next\"]/header/div[1]/div/div[1]/a[2]")));
        makerplace.click();
        Thread.sleep(4000);

        // scroll to video position
        js.executeScript("window.scrollBy(0,800)");

        // click on video to open window
        WebElement video = driver.findElement(By.xpath("//*[@id=\"w-root\"]/div/div[1]/div/div[2]/div/div[1]/div[1]/div"));
        video.click();
        Thread.sleep(2000);

        // pauses video
        WebElement pause = driver.findElement(By.xpath("//*[@id=\"vw-modal-root\"]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/div"));
        pause.click();
        Thread.sleep(2000);

        // click on share button
        WebElement share = driver.findElement(By.xpath("//*[@id=\"vw-modal-root\"]/div[1]/div/div[2]/div[9]/button[2]"));
        share.click();
        Thread.sleep(5000);

        // exit share
        WebElement exit1 = driver.findElement(By.xpath("//*[@id=\"vw-modal-root\"]/div[1]/div/div[1]/div/div[1]/button"));
        exit1.click();
        Thread.sleep(2000);

        // unmute video
        WebElement mute = driver.findElement(By.xpath("//*[@id=\"vw-modal-root\"]/div[1]/div/div[2]/div[9]/button[1]"));
        mute.click();
        Thread.sleep(2000);

        // unpause video
        WebElement pause2 = driver.findElement(By.xpath("//*[@id=\"vw-modal-root\"]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/span"));
        pause2.click();
        Thread.sleep(5000); // allows video to play unmuted

        // exit the video
        WebElement exit2 = driver.findElement(By.xpath("//*[@id=\"vw-modal-root\"]/button"));
        exit2.click();
        Thread.sleep(2000);

        driver.quit(); // exits chromedriver

    }

    // testing add to cart functionality
    @Test public void addCart() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/makerplace");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,2500)");
        Thread.sleep(3000);

        WebElement itemLook = driver.findElement(By.xpath("//*[@id=\"bigImage\"]"));
        itemLook.click();
        Thread.sleep(3000);

        WebElement text = driver.findElement(By.xpath("//*[@id=\"Personalization Textfield\"]"));
        text.sendKeys("Test");
        Thread.sleep(3000);

        WebElement addCart = driver.findElement(By.xpath("//*[@id=\"pdpCenterWrap\"]/div[2]/div[2]/div/div/div[10]/div/div[2]/button[1]"));
        addCart.click();

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,0)");
        Thread.sleep(3000);

        WebElement cart = driver.findElement(By.xpath("//*[@id=\"chakra-modal-:rv:\"]/div[4]/div/button[1]"));
        cart.click();
        Thread.sleep(5000);

        driver.quit();
    }

    // add an item to wishlist (need to be signed in)
    @Test public void addWishlist() throws InterruptedException {

        // initialize chromedriver, WebDriverWait, and JavascriptExecutor
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/makerplace");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);

        // scroll to designated position on the page x=0, y=3300 downward
        js.executeScript("window.scrollBy(0,3300)");
        Thread.sleep(5000);

        // click on add to wishlist icon
        WebElement wish = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"popover-trigger-:r26:\"]")));
        wish.click();
        Thread.sleep(3000);

        // exit pop-up prompt
        WebElement exitWish = driver.findElement(By.xpath("//*[@id=\"chakra-toast-manager-top\"]/div/div/div/button"));
        exitWish.click();
        Thread.sleep(5000);

        // exit chromedriver
        driver.quit();

    }

    // testing link functionalities
    @Test public void businessLinks() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/makerplace");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // scroll to designated site on the page
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,4500)");
        Thread.sleep(3000);

        // click on first small business link
        WebElement chicMama = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"1742305053743lr8k37st\"]/div[2]/div/div/div/div[1]/div/a")));
        chicMama.click();
        Thread.sleep(3000);

        // scroll a bit
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        // goes back to previous page
        driver.navigate().back();

        // scrolls back to small businesses
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,4500)");

        // click on second business link
        WebElement mindBiz = driver.findElement(By.xpath("//*[@id=\"1742305053743lr8k37st\"]/div[2]/div/div/div/div[2]/div/a"));
        mindBiz.click();
        Thread.sleep(3000);

        // scroll a bit
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        // go back to previous page
        driver.navigate().back();
        Thread.sleep(3000);

        // scroll back to small businesses
        js.executeScript("window.scrollBy(0,4500)");
        Thread.sleep(3000);

        // test third business link
        WebElement rockArt = driver.findElement(By.xpath("//*[@id=\"1742305053743lr8k37st\"]/div[2]/div/div/div/div[3]/div/a"));
        rockArt.click();
        Thread.sleep(3000);

        // scroll a bit
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        // navigate to previous page
        driver.navigate().back();
        Thread.sleep(3000);

        // exit chromedriver
        driver.quit();

    }

    // testing item search filter functionality
    @Test public void shopFilter() throws InterruptedException {

        // initialize chromedriver, WebDriverWait, and Javascript Executor
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/makerplace/home-and-living");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // clicks on Shop all button
        WebElement shopAll = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div/div/div/div[1]/div/div/a[1]/button")));
        shopAll.click();
        Thread.sleep(3000);

        // scroll
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        // filters by furniture only
        WebElement furniture = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[3]/div[1]/div[1]/div/div/div[2]/div[1]/div/div/div[5]/a"));
        furniture.click();
        Thread.sleep(3000);

        // scroll
        js.executeScript("window.scrollBy(0,800)");
        Thread.sleep(3000);

        // filters by free shipping
        WebElement checkShipping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[3]/div[1]/div[2]/div/div[1]/div[1]/div/div/div[2]/div/label[1]/span[1]")));
        checkShipping.click();
        Thread.sleep(2000);

        // scrolls
        js.executeScript("window.scrollBy(0,800)");

        // filters by price
        WebElement priceButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[3]/div[1]/div[2]/div/div[2]/div/div[1]/div/div"));
        priceButton.click();
        Thread.sleep(2000);

        // filters price by under 10$
        WebElement priceCheck = driver.findElement(By.xpath("//*[@id=\"accordion-panel-:rqr:\"]/div/div/label[1]/span[2]/div/a"));
        priceCheck.click();
        Thread.sleep(2000);

        // scroll
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(5000);

        // clears all filters
        WebElement clearAll = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div[2]/div/button"));
        clearAll.click();
        Thread.sleep(2000);

        // scrolls
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(5000);

        // exits chromedriver
        driver.quit();

    }
}
