import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class Classes_Events {


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

    // Classes and Events Module

    // Navigate to classes and event section + select a class
    @Test(priority = 3)
    public void testNavigateToClassesEvents() throws InterruptedException {
        System.out.println(" Navigating to Classes and Events section...");

        try {
            WebElement classesLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[text()='Classes & Events']/ancestor::a")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", classesLink);
            Thread.sleep(500);
            classesLink.click();
            System.out.println(" Clicked on 'Classes & Events'");

            WebElement takeThisClassButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(), 'Take this class')]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", takeThisClassButton);
            Thread.sleep(500);
            takeThisClassButton.click();
            System.out.println(" Clicked 'Take this class'");
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Failed to navigate to and open a class.");
        }
    }

    // Copy link to class + paste
    @Test(priority = 4)
    public void testClickShareIcon() throws InterruptedException {
        System.out.println(" Attempting to click the Share icon...");

        try {
            WebElement shareButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[.//p[text()='Share']]")
            ));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shareButton);
            Thread.sleep(500);

            try {
                shareButton.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", shareButton);
            }

            System.out.println(" Share icon clicked.");
            Thread.sleep(2000); // Allow UI changes to take place

            WebElement copyLinkButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(@class, 'css-1dz5euj')]")
            ));
            copyLinkButton.click();
            System.out.println(" Copy link button clicked.");

            WebElement linkTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[contains(@class, 'chakra-text') and contains(text(),'https://www.michaels.com/class/')]")
            ));
            String copiedUrl = linkTextElement.getText();
            System.out.println(" Copied URL: " + copiedUrl);

            ((JavascriptExecutor) driver).executeScript("window.open('" + copiedUrl + "', '_blank');");
            System.out.println(" New tab opened with the copied link.");

            Thread.sleep(2000);
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabs.size() - 1));
            System.out.println(" Switched to the new tab.");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Failed to click the Share icon, copy link, or open in new tab.");
        }
    }

    // Search for specific class/event
    @Test(priority = 5)
    public void testSearchForOnlineClassYarnAndSelect() throws InterruptedException {
        System.out.println(" Scrolling to 'Search for an online class' and searching for 'yarn'...");

        try {
            WebElement classesLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[text()='Classes & Events']/ancestor::a")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", classesLink);
            Thread.sleep(500);
            classesLink.click();
            System.out.println(" Clicked on 'Classes & Events'");
            Thread.sleep(4000);

            WebElement searchHeading = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//h2[contains(text(),'Search for an online class')]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchHeading);
            Thread.sleep(1000);
            System.out.println(" Scrolled to 'Search for an online class' heading.");

            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@placeholder='Search']")
            ));
            searchInput.click();
            searchInput.clear();
            searchInput.sendKeys("yarn" + Keys.ENTER);
            System.out.println(" Entered 'yarn' into the search box.");
            Thread.sleep(4000);

            WebElement firstClass = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[contains(text(),'Learn to Crochet')]/ancestor::a")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstClass);
            Thread.sleep(500);
            firstClass.click();
            System.out.println(" Clicked on 'Learn to Crochet' class.");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Could not complete search and select 'Learn to Crochet'.");
        }
    }

    // Open calendar and filter by skill level
    @Test(priority = 6)
    public void testOpenCalendarAndSelectIntermediateSkill() throws InterruptedException {
        System.out.println(" Navigating to Calendar and selecting Skill Level...");

        try {
            WebElement classesLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[text()='Classes & Events']/ancestor::a")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", classesLink);
            Thread.sleep(500);
            classesLink.click();
            System.out.println(" Clicked on 'Classes & Events'");
            Thread.sleep(3000);

            WebElement calendarButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href, '/classes/calendar')]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calendarButton);
            Thread.sleep(500);
            calendarButton.click();
            System.out.println(" Calendar button clicked");
            Thread.sleep(3000);

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(1500);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -800);");
            Thread.sleep(1500);

            WebElement skillLevelDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@placeholder='Skill Level']")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", skillLevelDropdown);
            Thread.sleep(300);
            skillLevelDropdown.click();
            System.out.println(" Skill Level dropdown opened");

            WebElement intermediateOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[text()='Intermediate']/ancestor::label")
            ));
            intermediateOption.click();
            System.out.println(" Selected 'Intermediate' skill level");

            Thread.sleep(4000); //  Adjust duration as needed

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Failed during calendar or skill level filtering.");
        }
    }

    // Select from a category and clear filter
    @Test(priority = 7)
    public void testClickArtExperiencesAndClearFilters() throws InterruptedException {
        System.out.println(" Navigating to Art Experiences and clearing filters...");

        try {
            // Navigate to Classes & Events
            WebElement classesLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[text()='Classes & Events']/ancestor::a")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", classesLink);
            Thread.sleep(500);
            classesLink.click();
            System.out.println(" Clicked on 'Classes & Events'");
            Thread.sleep(3000); // Wait for page to load

            // Scroll to and click Art Experiences
            WebElement artExperiencesCard = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[contains(text(),'Art Experiences')]/ancestor::a")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", artExperiencesCard);
            Thread.sleep(1000);
            artExperiencesCard.click();
            System.out.println(" Clicked on 'Art Experiences'");
            Thread.sleep(3000);

            // Clear filters
            WebElement clearAllBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[contains(text(),'Clear All')]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clearAllBtn);
            clearAllBtn.click();
            System.out.println(" Cleared all filters.");

            //  Delay to keep the cleared screen visible
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Failed to click 'Art Experiences' or clear filters.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


