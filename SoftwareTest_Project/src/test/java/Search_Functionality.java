import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.time.Duration;

// Login Page Unit Tests
public class Search_Functionality {

    // Testing valid search results
    @Test public void paintSearch() throws InterruptedException {

        // setup chrome driver and navigate to the webpage
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.michaels.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        // initialize WebElement for search bar
        WebElement search = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/input"));
        search.sendKeys("oil paint"); // input search query

        Thread.sleep(3000);

        // enter search
        WebElement enter = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/button"));
        enter.click();
        Thread.sleep(8000);

        // exit chromedriver
        driver.quit();

    }

    // Testing no search results query
    @Test public void noResults() throws InterruptedException {

        // initialize chrome driver and navigate to the webpage
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement search = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/input"));
        search.sendKeys("2010 Honda Accord");

        Thread.sleep(3000);

        // enter search
        WebElement enter = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/button"));
        enter.click();
        Thread.sleep(8000);

        // exit chromedriver
        driver.quit();

    }


    // Testing search preview side products
    @Test public void searchPreview() throws InterruptedException {

        // initialize chromedriver and navigate to webpage
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement search = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/input"));
        search.click();

        Thread.sleep(3000);

        WebElement product = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/ul/div/div/div/div/div[1]/div/a"));
        product.click();
        Thread.sleep(6000);

        // exit chromedriver
        driver.quit();

    }


    // Testing clear search input
    @Test public void clearSearch() throws InterruptedException {

        // initialize chromedriver and navigate to website
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        // initialize WebElement for search bar input
        WebElement search = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/input"));
        search.sendKeys("2010 Honda Accord");
        Thread.sleep(5000);

        // clear input WebElement
        WebElement clear = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/div/button"));
        clear.click();
        Thread.sleep(6000);

        // exit chromedriver
        driver.quit();
    }


    // Testing clear search history
    @Test public void searchHistory() throws InterruptedException {

        // initialize chromedriver and navigate to website
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.michaels.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Thread.sleep(5000);

        // initialize WebElement for search bar input
        WebElement search = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/input"));
        WebElement enter = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/button"));

        // complete a search
        search.sendKeys("2010 Honda Accord"); // complete a search
        enter.click();
        Thread.sleep(5000);

        // navigate to previous page
        driver.navigate().back();
        Thread.sleep(6000);

        // complete another search

        WebElement search2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/input")));
        WebElement enter2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/button"));
        search2.sendKeys("canvas");
        enter2.click();
        Thread.sleep(8000);

        // navigate to previous page
        driver.navigate().back();
        Thread.sleep(6000);

        // WebElement for clear search history
        WebElement search3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div[1]/input")));
        search3.click();
        Thread.sleep(6000);
        WebElement history = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/ul/li[4]/button"));
        history.click();
        Thread.sleep(6000);

        // exit chromedriver
        driver.quit();

    }
}
