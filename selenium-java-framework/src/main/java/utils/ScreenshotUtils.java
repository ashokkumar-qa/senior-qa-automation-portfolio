package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, String testName) {

        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File screenshotFolder = new File("screenshots");
            screenshotFolder.mkdir();

            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

            File destination = new File("screenshots/" + testName + "_" + timeStamp + ".png");
            Files.copy(source.toPath(), destination.toPath());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
