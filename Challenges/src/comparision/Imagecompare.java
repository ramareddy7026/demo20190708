package comparision;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Imagecompare 
{
 public static void main(String[] args) throws IOException
 {
	 
	 //vedio link (https://www.youtube.com/watch?v=1CBS1AQy6zo)
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://opensource-demo.orangehrmlive.com/");
	//to read existing image 
	BufferedImage expectedimage = ImageIO.read(new File("D://eclipse/20190918/Challenges/logos/orange1.png"));

	//to get the screenshot to compare
	WebElement logoimage = driver.findElement(By.xpath("//img[contains(@src,\\\"/webres_5df488ddad8b23.30204013/themes/default/images/login/logo.png\\\""));
	Screenshot logoscreenshot = new AShot().takeScreenshot(driver, logoimage);
	BufferedImage actualimage = logoscreenshot.getImage();
	
	//object we have to create
	ImageDiffer imgdiff=new ImageDiffer();
	ImageDiff diff = imgdiff.makeDiff(expectedimage, actualimage );
	
	if(diff.hasDiff()==true)
	{
		System.out.println("images are same");
	}
	else 
	{
		System.out.println("not same");
	}
	
	
 }
}
