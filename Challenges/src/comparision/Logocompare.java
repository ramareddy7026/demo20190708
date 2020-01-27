package comparision;

import java.awt.Image;
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

public class Logocompare 
{
 public static void main(String[] args) throws IOException 
 {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://opensource-demo.orangehrmlive.com/");
	WebElement logo1= driver.findElement(By.xpath("//img[contains(@src,\"/webres_5df488ddad8b23.30204013/themes/default/images/login/logo.png\")]"));
	Screenshot orangehrm = new AShot().takeScreenshot(driver, logo1);
	ImageIO.write( orangehrm.getImage(),"png",new File("D://eclipse/20190918/Challenges/logos/orange1.png"));
	
	File file=new File("D://eclipse/20190918/Challenges/logos/orange1.png");
	if(file.exists())
	{
		System.out.println("image captured");
	}
	else 
	{
		System.out.println("image not found");
	}
}
}
