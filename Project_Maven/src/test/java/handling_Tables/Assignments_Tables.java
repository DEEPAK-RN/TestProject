/* Q)WAS for the following sceneries without using xpath?

1)count no of tables
2)count no of rows in a table
3)count no of columns in a table
4)print content of a table
5) count no of cell in table
*/
package handling_Tables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignments_Tables {
	@Test
	public void testA() 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Adarsh%20R%20N/Desktop/Tables_SampleWebPage.html");
//1)count no of tables		
		List<WebElement> Table = driver.findElements(By.tagName("table"));
		int tables = Table.size();
		System.out.println("Tables "+tables);
//2)count no of rows in a table		
		List<WebElement> Row = driver.findElements(By.tagName("tr"));
		int rows = Row.size();
		System.out.println("Rows "+rows);
//3)count no of columns in a table		
		WebElement tb = driver.findElement(By.tagName("table"));
		WebElement rw = tb.findElement(By.tagName("tr"));
		List<WebElement> Column = rw.findElements(By.tagName("td"));
		int columns = Column.size();
		System.out.println("Columns "+columns);
//4)print content of a table
		List<WebElement> allTexts = driver.findElements(By.tagName("td"));
		int count = allTexts.size();
		
		int c = 0;
		for(int i =0; i<count; i++)
		{
			WebElement cell = allTexts.get(i);
			String text = cell.getText();
			try
			{
				int n = Integer.parseInt(text);
			}
			catch (Exception e) 
			{
				System.out.println(text);
				c++;
			}
		}
		System.out.println("\nTotal No.of texts displayed: "+c);
//5) count no of cell in table		
		List<WebElement> Cell = driver.findElements(By.tagName("td"));
		int cells = Cell.size();
		System.out.println("Cells "+cells);
		driver.close();
	}
}
