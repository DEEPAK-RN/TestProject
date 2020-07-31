// Generic method to read the data form excel file

package Generic;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData
{
	public static String getData(String pathname,String sheetname,int rn,int cn)
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File(pathname));
			String data = WorkbookFactory.create(file).getSheet(sheetname).getRow(rn).getCell(cn).toString();
			return data;
		} 
		catch (Exception e)
		{
			return "";
		}
	}
}

