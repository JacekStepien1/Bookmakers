package buk.Services;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoresReader_kopia {

    Document doc;
    Elements elem1;
    WebDriver driver;
    List<WebElement> allMatches;


    public void matchesReader(WebDriver driver, String url) throws Exception {
        this.driver=driver;
            matchesReaderStart(url);
        }


    public void matchesReaderStart(String url) {
        try {
            driver.get(url);
//            waitUntill();
//            List<WebElement> allMatches = driver.findElements(By.xpath("//div[@class='title-container']"));

//            List<WebElement> allMatches = driver.findElements(By.xpath("//div[@class='game']"));

            List<WebElement> allMatches = driver.findElements(By.xpath("//div[@class='game']"));

        } catch (Exception e) {
        }

//        System.out.println(allMatches.size());
        System.out.println(driver.findElements(By.xpath("//div[@class='title-container']")).size());




    }


//    public void scoresReadresStart(String url) {
//        try {
//            doc = Jsoup.parse(url, "UTF-8");
//            Connection connection = Jsoup.connect(url);
//            connection.userAgent("Mozilla");
//            connection.timeout(5000);
//            Document doc = connection.get();
//            elem1 = doc.select(".description");
//
//        } catch (Exception e) {
//            System.err.println("read error: " + url);
//        }
//
//        System.out.println(doc.text());
//        System.out.println(elem1.text());
//
//
//    }




}
