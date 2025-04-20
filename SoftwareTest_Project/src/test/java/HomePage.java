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


// sign-up page unit test and modules
public class HomePage {

    @Test public void scrolling() throws InterruptedException {

        // initialize Chrome webdriver and navigate to the webpage
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/");
        driver.manage().window().maximize();

        // initialize Java Executor and WebdriverWait
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(3000);

        // scrolls to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);

        // scrolls to the top of the page
        js.executeScript("window.scrollTo(0, 0)");
        Thread.sleep(3000);

        // scrolls to an element
        WebElement view = driver.findElement(By.xpath("//*[@id=\"1726263428476i2o7im3n\"]/div[4]/button"));
        js.executeScript("arguments[0].scrollIntoView(true)", view);
        Thread.sleep(3000);

        driver.quit();

    }


    @Test public void imageBar() throws InterruptedException {

        // initialize Chrome webdriver and navigate to the webpage
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        // initialize WebElements for play/pause button and dots under the image bar
        WebElement image1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[1]/div/div/div/div[2]/ul/li[1]"));
        WebElement image2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[1]/div/div/div/div[2]/ul/li[2]"));
        WebElement image3 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[1]/div/div/div/div[2]/ul/li[3]"));
        WebElement image4 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[1]/div/div/div/div[2]/ul/li[4]"));
        WebElement image5 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[1]/div/div/div/div[2]/ul/li[5]"));
        WebElement pause = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[1]/div/div/div/div[2]/button"));

        // click on the dots to navigate to designated promo image
        pause.click();
        Thread.sleep(3000);
        image2.click();
        Thread.sleep(3000);
        image3.click();
        Thread.sleep(3000);
        image4.click();
        Thread.sleep(3000);
        image5.click();
        Thread.sleep(3000);
        image1.click();
        Thread.sleep(3000);
        pause.click();
        Thread.sleep(8000);


        // exit chromedriver
        driver.quit();

    }

    @Test public void sideScroll() throws InterruptedException {

        // initialize chrome driver and navigate to the designated page
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/");
        driver.manage().window().maximize();

        // initialize javascript executor and WebDriverWait
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Thread.sleep(3000);

        // initialize elements for both arrow buttons and scroll into view
        WebElement arrowRight = driver.findElement(By.xpath("//*[@id=\"1743602186910tosmo8p9\"]/div[2]/div/div[3]"));
        WebElement arrowLeft = driver.findElement(By.xpath("//*[@id=\"1743602186910tosmo8p9\"]/div[2]/div/div[1]"));
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(3000);

        // close cookies pop-up
        WebElement popup = driver.findElement(By.xpath("/html/body/div[2]/div[2]/span"));
        popup.click();
        Thread.sleep(3000);

        // alternate between scrolling right and then left
        arrowRight.click();
        Thread.sleep(3000);
        arrowRight.click();
        Thread.sleep(3000);

        arrowLeft.click();
        Thread.sleep(3000);
        arrowLeft.click();
        Thread.sleep(3000);

        // exit chromedriver
        driver.quit();

    }


    @Test public void viewButtons() throws InterruptedException {

        // initialize chromedriver and navigate to webpage
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/");
        driver.manage().window().maximize();

        // initialize javascript executor and WebDriverWait
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(3000);

        // close popup
        WebElement popup = driver.findElement(By.xpath("/html/body/div[2]/div[2]/span"));
        popup.click();
        Thread.sleep(3000);

        // scroll to where the view more button is located
        js.executeScript("window.scrollBy(0,3000)");
        Thread.sleep(3000);

        // initialize Web Element for the view more button
        WebElement more = driver.findElement(By.xpath("//*[@id=\"1726263428476i2o7im3n\"]/div[4]/button"));

        // view more
        more.click();
        Thread.sleep(3000);

        // scroll to where view less is visible
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);

        // view less
        WebElement less = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"1726263428476i2o7im3n\"]/div[4]/button")));
        less.click();
        Thread.sleep(3000);

        // scroll back
        js.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(3000);

        // exit chromedriver
        driver.quit();

    }

    @Test public void navProducts() throws InterruptedException {

        // initialize chromedriver and navigate to the webpage
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/");
        driver.manage().window().maximize();

        // initialize javascript executor and WebDriverWait
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(3000);

        // close popup
        WebElement popup = driver.findElement(By.xpath("/html/body/div[2]/div[2]/span"));
        popup.click();
        Thread.sleep(3000);

        // scroll to the element
        js.executeScript("window.scrollBy(0,1400)");
        Thread.sleep(3000);

        // initialize web element and click to go to the item page
        WebElement baking_page = driver.findElement(By.xpath("//*[@id=\"1744240553408sia7qk26\"]/div[3]/div[2]/a"));
        baking_page.click();
        Thread.sleep(6000);

        // click on product
        WebElement candle = driver.findElement(By.xpath("//*[@id=\"productName\"]"));
        candle.click();
        Thread.sleep(6000);

        // go back to the home page
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(3000);

        // exit chromedriver
        driver.quit();

    }
}
