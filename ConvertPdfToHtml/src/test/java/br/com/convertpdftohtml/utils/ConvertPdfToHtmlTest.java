package br.com.convertpdftohtml.utils;

import java.io.File;

public class ConvertPdfToHtmlTest {
	public static void main(String[] args) {
		File file = new File("\\\\10.21.8.2\\app_data\\email\\attatchment\\1522160848031.pdf");
		
		try {
			String convert = ConvertPdfToHtml.convert(file);
			System.out.println(convert);
			ConvertPdfToHtml.convertAndCreate(file, "pdf.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
