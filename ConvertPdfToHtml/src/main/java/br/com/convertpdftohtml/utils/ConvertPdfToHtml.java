package br.com.convertpdftohtml.utils;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;



public class ConvertPdfToHtml {
	
	public static void convertAndCreate(InputStream is, String localWriteFile) throws Exception {
		PDDocument pdf = PDDocument.load(is);
		File outputFile = new File(localWriteFile);
		Writer output = new PrintWriter(outputFile, "utf-8");
		System.out.println("Done! Look at file " + outputFile.getAbsolutePath());
	    new PDFDomTree().writeText(pdf, output);
	}
	
	public static void convertAndCreate(File is, String localWriteFile) throws Exception {
		PDDocument pdf = PDDocument.load(is);
		File outputFile = new File(localWriteFile);
		Writer output = new PrintWriter(outputFile, "utf-8");
		System.out.println("Done! Look at file " + outputFile.getAbsolutePath());
		new PDFDomTree().writeText(pdf, output);
	}
	
	public static String convert(InputStream is) throws Exception {
		PDDocument pdf = PDDocument.load(is);
		Writer output = new StringWriter();
		new PDFDomTree().writeText(pdf, output);
		pdf.close();
		return output.toString();
	}
	
	public static String convert(File is) throws Exception {
		PDDocument pdf = PDDocument.load(is);
		Writer output = new StringWriter();
		new PDFDomTree().writeText(pdf, output);
		pdf.close();
		return output.toString();
	}

}
