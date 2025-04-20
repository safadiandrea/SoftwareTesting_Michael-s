import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Kids_Section {
    @Test
    public static void Kids_section() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C://Users//isaia//drivers//chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();
        driver2.manage().window().maximize();

        driver2.get("https://www.michaels.com/shop/kids");
        //Scroll
        JavascriptExecutor scroll = (JavascriptExecutor) driver2;
        //1.Shop kids deal
        scroll.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(3000);
        //2.Forward arrow
        WebElement SKD_arrow_forward = driver2.findElement(By.xpath("//*[@id=\"1743017073890u0hykj8z\"]/div[2]/div/div[3]"));
        SKD_arrow_forward.click();
        Thread.sleep(1000);


        //Backwards arrow
        WebElement backward_arrow = driver2.findElement(By.xpath("//*[@id=\"1743017073890u0hykj8z\"]/div[2]/div/div[1]"));
        backward_arrow.click();
        Thread.sleep(1000);
        WebElement Safari_Toobs = driver2.findElement(By.partialLinkText("Safari "));
        Safari_Toobs.click();
        Thread.sleep(3000);
        //Return kids section
        WebElement kids3 = driver2.findElement(By.partialLinkText("Kids"));
        kids3.click();
        Thread.sleep(1000);
        scroll.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(3000);



        //3.Select kids age
        WebElement age = driver2.findElement(By.xpath("//*[@id=\"1727379023616zxlimoq8\"]/div[3]/a[1]/div/img"));
        age.click();
        Thread.sleep(5000);


        //Return to kids page
        WebElement kids4 = driver2.findElement(By.partialLinkText("Kids"));
        kids4.click();
        Thread.sleep(1000);


        //4.Shop now function
        WebElement Shop_Now_button = driver2.findElement(By.partialLinkText("Shop Now"));
        Shop_Now_button.click();
        Thread.sleep(1000);
        //5.Filter by checking checkbox
        scroll.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(3000);
        WebElement checkbox_In_store = driver2.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div/label/span[1]"));
        checkbox_In_store.click();
        Thread.sleep(5000);

    }
}
