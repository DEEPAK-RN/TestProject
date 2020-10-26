package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySqlDemo {

	@Test
	public void testA() throws SQLException, InterruptedException
	{
		String url = "jdbc:mysql://localhost:3306/Demo_Schema";
		String usn = "j2ee";
		String pwd = "1234";
		
		Connection con = DriverManager.getConnection(url, usn, pwd);
		
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery("Select * from TC01");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/");
		
		while(result.next())
		{
			String un = result.getString("un");
			String pw = result.getString("pw");
			String LgTitle = result.getString("LgTitle");
			String hpTitle = result.getString("hpTitle");
			System.out.println("Name: "+un);
			System.out.println("Password: "+pw);
			System.out.println("Login Title: "+LgTitle);
			System.out.println("HomePage Title: "+hpTitle);
			driver.findElement(By.id("username")).sendKeys(un);
			driver.findElement(By.name("pwd")).sendKeys(pw);
			driver.findElement(By.xpath("//div[.='Login ']")).click();
		}
		con.close();
		Thread.sleep(1000);
		driver.quit();
	}
}
