package Database;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;

public class PdfDemo {


	@Test
	public void testA() throws IOException
	{
		URL url = new URL("file:///C:/Users/Adarsh%20R%20N/Desktop/pdfDemo.pdf");
		InputStream is = url.openStream();
		
		BufferedInputStream file = new BufferedInputStream(is);
		
		PDDocument document = PDDocument.load(file);
		
		PDFTextStripper p = new PDFTextStripper();
		String text = p.getText(document);
		System.out.println(text);
	}

}