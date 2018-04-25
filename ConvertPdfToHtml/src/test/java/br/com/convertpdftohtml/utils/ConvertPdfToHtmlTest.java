package br.com.convertpdftohtml.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class ConvertPdfToHtmlTest {
	File file = new File("src\\test\\resources\\1522071837873.pdf");

	@Test
	public void testaSeConvertePDFtoHTML() throws Exception {
		String convert = ConvertPdfToHtml.convert(file);
		assertNotNull(convert);
	}
	
	@Test
	public void testaSeConvertePDFtoHTMLAndCreate() throws Exception {
		ConvertPdfToHtml.convertAndCreate(file, "src\\test\\resources\\pdf.html");
		assertTrue(new File("src\\test\\resources\\pdf.html").exists());
	}
}
