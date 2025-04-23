import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Coupons_Projects {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/GeckoDriver/geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("Opening Michaels homepage...");
        driver.get("https://www.michaels.com/");
        Thread.sleep(3000);
    }

    // Coupon/Projects Module


    // Change Store Location
    @Test(priority = 1)
    public void testSelectStoreByZipCode() throws InterruptedException {
        System.out.println("Navigating to Coupons and selecting store by ZIP code...");

        try {
            WebElement couponsButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href, '/coupons')]")
            ));
            couponsButton.click();
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 300);");

            WebElement changeStoreButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Change Store')]")
            ));
            changeStoreButton.click();
            System.out.println("Clicked Change Store.");
            Thread.sleep(2000);

            WebElement zipInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='Enter city, state, zip']")
            ));
            zipInput.clear();
            zipInput.sendKeys("33928");
            zipInput.sendKeys(Keys.ENTER);
            System.out.println("Entered ZIP 33928.");
            Thread.sleep(4000); // Let store options load

            WebElement radioInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("(//input[@type='radio'])[1]")
            ));
            js.executeScript("arguments[0].click();", radioInput);
            System.out.println("Clicked first store radio input using JS.");
            Thread.sleep(2000);

            WebElement selectedLabel = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("(//label[contains(@class, 'chakra-radio') and @data-checked='true'])[1]")
            ));
            System.out.println("Confirmed store is selected.");

            WebElement changeMyStoreButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[.//div[text()='CHANGE MY STORE']]")
            ));

            wait.until(ExpectedConditions.elementToBeClickable(changeMyStoreButton));
            System.out.println("CHANGE MY STORE button is ready.");

            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", changeMyStoreButton);
            Thread.sleep(800);

            Actions actions = new Actions(driver);
            actions.moveToElement(changeMyStoreButton).pause(Duration.ofMillis(500)).click().perform();
            System.out.println(" Clicked 'CHANGE MY STORE' using Actions class.");

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to complete store selection flow.");
        }
    }

    // Printing a Coupon
    @Test(priority = 2)
    public void testClickPrintCouponInPopupTab() throws InterruptedException {
        System.out.println("Navigating to Coupons and launching print popup...");

        try {
            WebElement couponsButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href, '/coupons')]")
            ));
            couponsButton.click();
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 300);");
            WebElement printIcon = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[contains(text(),'Print Coupons')]/parent::button")
            ));
            js.executeScript("arguments[0].click();", printIcon);
            System.out.println(" Print Coupons icon clicked — waiting for new tab...");
            Thread.sleep(2000);

            String originalTab = driver.getWindowHandle();
            Set<String> tabs = driver.getWindowHandles();
            for (String handle : tabs) {
                if (!handle.equals(originalTab)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            System.out.println(" Switched to print tab.");
            Thread.sleep(3000);

            WebElement printButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[.//div[text()='Print Coupon']]")
            ));
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", printButton);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", printButton);
            System.out.println(" Successfully clicked 'Print Coupon'.");

            Thread.sleep(2000);
            driver.close();
            driver.switchTo().window(originalTab);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Could not click the 'Print Coupon' button.");
        }
    }

    // Selecting a Project + Downloading instructions
    @Test(priority = 2)
    public void testClickRainbowSprinkleCake() throws InterruptedException {
        System.out.println(" Navigating to Projects and selecting Rainbow Sprinkle Cake...");

        try {
            WebElement projectsButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href, '/projects')]")
            ));
            projectsButton.click();
            System.out.println(" Clicked on 'Projects'");

            Thread.sleep(4000);

            WebElement rainbowCake = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(@href, '/project/rainbow-sprinkle-cake')]")
            ));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", rainbowCake);
            Thread.sleep(1000);

            rainbowCake.click();
            System.out.println(" Clicked on 'Rainbow Sprinkle Cake' project");

            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Failed to navigate to or select Rainbow Sprinkle Cake project.");
        }
    }

    @Test(priority = 3)
    public void testDownloadRainbowCakeInstructions() throws InterruptedException {
        System.out.println(" Attempting to download Rainbow Sprinkle Cake instructions...");

        try {
            WebElement downloadBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[text()='Download Instructions']/ancestor::button")
            ));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", downloadBtn);
            Thread.sleep(1000);

            downloadBtn.click();
            System.out.println(" 'Download Instructions' button clicked.");

            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Failed to click 'Download Instructions' on project page.");
        }
    }

    // Increasing quantity of each item needed
    @Test(priority = 2)
    public void testClickRainbowSprinkleCakeProject() throws InterruptedException {
        System.out.println(" Navigating to Projects and selecting Rainbow Sprinkle Cake...");

        try {
            WebElement projectsButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href, '/projects')]")
            ));
            projectsButton.click();
            System.out.println(" Clicked on 'Projects'");

            Thread.sleep(4000);

            WebElement rainbowCake = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(@href, '/project/rainbow-sprinkle-cake')]")
            ));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", rainbowCake);
            Thread.sleep(1000); // Smooth scroll buffer

            rainbowCake.click();
            System.out.println(" Clicked on 'Rainbow Sprinkle Cake' project");

            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Failed to navigate to or select Rainbow Sprinkle Cake project.");
        }
    }

    @Test(priority = 4)
    public void testIncreaseMaterialQuantitiesToTwo() throws InterruptedException {
        System.out.println(" Increasing quantities of all materials to 2...");

        try {
            Thread.sleep(4000); // Let the section load visibly

            List<WebElement> plusButtons = driver.findElements(By.xpath("//div[@role='button' and contains(@class, 'css-1jmf8qi')]"));

            if (plusButtons.isEmpty()) {
                Assert.fail(" No plus buttons found in the materials section.");
            }

            for (WebElement plusBtn : plusButtons) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", plusBtn);
                Thread.sleep(500);
                plusBtn.click();
                Thread.sleep(500);
            }

            System.out.println(" All material quantities increased to 2.");
            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Failed to increase material quantities to 2.");
        }
    }

    // Share a post to facebook
    @Test(priority = 2)
    public void testClickWhimsicalFairyCloche() throws InterruptedException {
        System.out.println(" Navigating to Projects and selecting Whimsical Fairy Cloche");

        try {
            WebElement projectsButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href, '/projects')]")
            ));
            projectsButton.click();
            System.out.println(" Clicked on 'Projects'");

            Thread.sleep(4000);

            WebElement fairyCloche = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(@href, '/project/whimsical-fairy-cloche')]")
            ));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", fairyCloche);
            Thread.sleep(1000);

            fairyCloche.click();
            System.out.println(" Clicked on Whimsical Fairy Cloche ");

            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Failed to navigate to or select Rainbow Sprinkle Cake project.");
        }
    }

    @Test(priority = 5)
    public void testHoverAndShareViaFacebook() throws InterruptedException {
        System.out.println(" Hovering Share icon and selecting Facebook...");

        try {
            WebElement shareIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'css-uj507p')]")
            ));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", shareIcon);
            Thread.sleep(500);

            Actions actions = new Actions(driver);
            actions.moveToElement(shareIcon).perform();
            Thread.sleep(1500);

            WebElement facebookButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@aria-label='facebook']")
            ));
            facebookButton.click();

            System.out.println(" Clicked Facebook share button.");
            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Failed to hover share icon and click Facebook share.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}