import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Party_and_baloons_Page {
    @Test
    public static void Party_and_Balloons_Page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C://Users//isaia//drivers//chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();
        driver2.manage().window().maximize();

        driver2.get("https://www.michaels.com/shop/party");
        //Scroll
        JavascriptExecutor scroll = (JavascriptExecutor) driver2;
        //Hover
        Actions HOVER = new Actions(driver2);
        //Sales slider
        WebElement pause = driver2.findElement(By.xpath("//*[@id=\"componentsBox\"]/div[1]/div/div/div[2]/button"));
        pause.click();
        Thread.sleep(2000);
        pause.click();
        Thread.sleep(2000);
        //Bday
        WebElement Bday = driver2.findElement(By.partialLinkText("Birthday Party"));
        HOVER.moveToElement(Bday).build().perform();
        Bday.click();
        Thread.sleep(3000);
        //1.--//Sorting items by best sellers
        WebElement drop_down2 = driver2.findElement(By.xpath("//*[@id=\"productListBox\"]/div[1]/div[2]/div[1]/div[2]/div/button/p[3]"));
        drop_down2.click();
        Thread.sleep(3000);
        WebElement best_sellers = driver2.findElement(By.xpath("//*[@id=\"productListBox\"]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/p"));
        best_sellers.click();
        Thread.sleep(3000);
        scroll.executeScript("window.scrollBy(0,1500)", "");
        Thread.sleep(3000);
        //2 and 3-----Picking Ballons & adding things in carts-------
        WebElement View_Options = driver2.findElement(By.xpath("//*[@id=\"cardBox\"]/div/div[2]/div[2]/button"));
        View_Options.click();
        Thread.sleep(5000);

        //Type of ballon/box select
        WebElement Uninflated = driver2.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div/div[5]/div[2]/div[2]/button"));
        Uninflated.click();
        Thread.sleep(3000);
        WebElement He_filled = driver2.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div/div[5]/div[2]/div[1]/button"));
        He_filled.click();
        Thread.sleep(3000);
        WebElement Add_cart = driver2.findElement(By.xpath("//*[@id=\"add-to-cart\"]"));
        Add_cart.click();
        Thread.sleep(5000);

        //Close
        WebElement close_items = driver2.findElement(By.xpath("//*[@id=\"chakra-modal--header-:rc1:\"]/button"));
        close_items.click();
        Thread.sleep(3000);
        driver2.navigate().back();
        Thread.sleep(3000);
        scroll.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(3000);

        //4.Selecting character
        WebElement char_box = driver2.findElement(By.partialLinkText("Zombies"));
        char_box.click();
        Thread.sleep(3000);




        //5.Enable Accessibility
        WebElement accessibility = driver2.findElement(By.xpath("//*[@id=\"usntA40Link\"]"));
        HOVER.moveToElement(accessibility).build().perform();
        accessibility.click();
        Thread.sleep(3000);


    }
}
