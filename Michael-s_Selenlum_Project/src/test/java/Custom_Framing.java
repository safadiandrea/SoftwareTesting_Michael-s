import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Custom_Framing {
    @Test
    public static void booking_appointment_typing_in_text_box_with_zip_code() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C://Users//isaia//drivers//chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();


        driver2.get("https://www.michaels.com/?cm_mmc=SearchBrand-_-google-_-MICH_Search_US_N_Brand_TrademarkCore_Branded_Exact-_-Trademark+-+Branded+Core+Term&kenshoo_ida=tm_brand&kpid=go_cmp-324266651_adg-24658685771_ad-348913281960_kwd-92295400_dev-c_ext-_prd-&gad_source=1&gbraid=0AAAAADkMxxeaUir8o5Xa3ucAVT8iwwmcI&gclid=Cj0KCQjwh_i_BhCzARIsANimeoG2ECLMLeKu1hj9PItBYaBWKVa9-KhX9uTAIzeY1w1JrFHgSLhXXG8aAq7HEALw_wcB");
        driver2.manage().window().maximize();
        Thread.sleep(1000);
        //Custom Framing
        WebElement Framing_Tab = driver2.findElement(By.partialLinkText("Custom Framing"));
        Framing_Tab.click();
        Thread.sleep(1000);

        WebElement hover_In_Store_Framing = driver2.findElement(By.xpath("//*[@id=\"navigation-menu-category\"]/ul/li[2]/a"));
        Actions HOVER = new Actions(driver2);
        HOVER.moveToElement(hover_In_Store_Framing).build().perform();
        Thread.sleep(3000);
        //Book appointment
        WebElement bookAppointment = driver2.findElement(By.id("appointments"));
        bookAppointment.click();
        Thread.sleep(1000);
        //Type in the zipcode

        WebElement zip_code = driver2.findElement(By.id("userZip"));
        zip_code.click();
        int i = 0;
        while (i < 5) {
            // Code to be executed 5 times
            zip_code.sendKeys(Keys.BACK_SPACE);

            i++;
        }
        zip_code.sendKeys("12345");
        Thread.sleep(3000);
        //Drop down arrow
        WebElement drop_down = driver2.findElement(By.xpath("//*[@id=\"js-book-appointment_msdd\"]/div[1]/span[2]"));
        drop_down.click();
        Thread.sleep(3000);
        //Miles selector
        WebElement miles_number_fifty = driver2.findElement(By.xpath("//*[@id=\"js-book-appointment_child\"]/ul/li[2]/span"));
        miles_number_fifty.click();
        Thread.sleep(2000);
        //Zipcode submit
        WebElement submit = driver2.findElement(By.id("set-zipcode"));
        submit.click();
        Thread.sleep(2000);
        //Select location
        WebElement sch_apt = driver2.findElement(By.xpath("//*[@id=\"main\"]/form/fieldset/div/div[2]/div[2]/div[2]/div[2]/div[1]/label/div/button"));
        sch_apt.click();
        Thread.sleep(2000);
        //Scroll
        JavascriptExecutor scroll = (JavascriptExecutor) driver2;
        scroll.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(2000);


        //Close
        WebElement close = driver2.findElement(By.xpath("/html/body/div[2]/div[2]/span"));
        close.click();
        Thread.sleep(2000);
        //Scroll

        scroll.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);
        //Selecting date

        WebElement select_30th = driver2.findElement(By.xpath("//*[@id=\"calendar\"]/div[2]/div/table/tbody/tr/td/div/div/div[5]/div[2]/table/thead/tr/td[4]/span"));
        select_30th.click();
        Thread.sleep(2000);

        //add contacts
        WebElement add_contacts = driver2.findElement(By.xpath("//*[@id=\"main\"]/form/fieldset/button[2]"));
        add_contacts.click();
        Thread.sleep(2000);


    }
    @Test
    public static void learnmore() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C://Users//isaia//drivers//chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();
        Thread.sleep(2000);
        driver2.get("https://www.michaelscustomframing.com/");
        driver2.manage().window().maximize();
        JavascriptExecutor scroll = (JavascriptExecutor) driver2;



        scroll.executeScript("window.scrollBy(0,700)", "");
        Thread.sleep(2000);
        //Learn more
        WebElement learn_more = driver2.findElement(By.partialLinkText("Learn More"));
        learn_more.click();
        Thread.sleep(2000);
    }
    @Test

    public static void making_jersy_and_add_cart() throws InterruptedException {//Two methods in one
        //Making a jersey
        System.setProperty("webdriver.chrome.driver",
                "C://Users//isaia//drivers//chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://www.michaelscustomframing.com/");
        JavascriptExecutor scroll = (JavascriptExecutor) driver2;

        //Making a jersey

        Thread.sleep(1000);
        scroll.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(1000);
        WebElement Jerseys = driver2.findElement(By.partialLinkText("Jerseys"));
        Jerseys.click();
        Thread.sleep(1000);


        //File placeholder
        //driver2.switchTo().frame(driver2.findElement(By.partialLinkText("Select_File")));
        WebElement placeholder = driver2.findElement(By.xpath("//*[@id=\"physical-art-sample-1\"]/img"));
        placeholder.click();

        Thread.sleep(1000);
        //Details
        WebElement placement_back = driver2.findElement(By.xpath("//*[@id=\"jersey-back-side\"]"));
        placement_back.click();
        Thread.sleep(1000);
        //Nextstep
        WebElement Nextstep = driver2.findElement(By.xpath("//*[@id=\"continue-canvasOpt\"]"));
        Nextstep.click();
        Thread.sleep(1000);

        //Width


        WebElement NextStep2 = driver2.findElement(By.xpath("//*[@id=\"cloudinary-size-submit\"]"));
        NextStep2.click();
        Thread.sleep(1000);
        //Select frame
        WebElement frame_nat = driver2.findElement(By.xpath("//*[@id=\"search-result-items_frames_for_jerseys \"]/li[4]/div/div[1]/a[2]"));
        frame_nat.click();
        Thread.sleep(1000);
        //Select color
        WebElement color = driver2.findElement(By.xpath("//*[@id=\"pdp-swatch-B8412-optMatOne-palette\"]"));
        color.click();
        Thread.sleep(1000);
        scroll.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(3000);
        //Add cart
        WebElement add_cart = driver2.findElement(By.id("add-to-cart"));
        add_cart.click();
        Thread.sleep(5000);
    }
    public static void photo_gifts() throws InterruptedException {

    }
}
