package br.com.convertpdftohtml.utils;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;



public class ConvertPdfToHtml {
	
	public static void convertAndCreate(InputStream is, String localWriteFile) throws Exception {
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
		PDDocument pdf = PDDocument.load(is);
		File outputFile = new File(localWriteFile);
		Writer output = new PrintWriter(outputFile, "utf-8");
		System.out.println("Done! Look at file " + outputFile.getAbsolutePath());
	    new PDFDomTree().writeText(pdf, output);
	}
	
	public static void convertAndCreate(File is, String localWriteFile) throws Exception {
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
		PDDocument pdf = PDDocument.load(is);
		File outputFile = new File(localWriteFile);
		Writer output = new PrintWriter(outputFile, "utf-8");
		System.out.println("Done! Look at file " + outputFile.getAbsolutePath());
		new PDFDomTree().writeText(pdf, output);
	}
	
	public static String convert(InputStream is) throws Exception {
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
		PDDocument pdf = PDDocument.load(is);
		Writer output = new StringWriter();
		new PDFDomTree().writeText(pdf, output);
		pdf.close();
		return output.toString();
	}
	
	public static String convert(File is) throws Exception {
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
		PDDocument pdf = PDDocument.load(is);
		Writer output = new StringWriter();
		new PDFDomTree().writeText(pdf, output);
		pdf.close();
		return output.toString();
	}
	
	public static String convertTeste(File is) throws Exception {
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
		PDDocument pdf = PDDocument.load(is);
		Writer output = new StringWriter();
		new PDFDomTree().writeText(pdf, output);
		pdf.close();
		
		String bankSlipHtml = output.toString();
		
		String title = "<title>PDF Document</title>";
		String header = 
		"<meta http-equiv='X-UA-Compatible' content='IE=10'>                                                                                     " +
		"<meta http-equiv='X-UA-Compatible' content='IE=edge'>                                                                                   " +
		"<title>Carne</title>                                                                                                                    " +
		"<script type='text/javascript' src='https://code.jquery.com/jquery-2.1.1.min.js'></script>                                              " +
		"<script type='text/javascript' src='http://localhost:8383/billet/js/jquery-barcode.js'></script>                                        " +
		"<script type='text/javascript'>                                                                                                         " +
		"$(function() {	$('#bcTarget1').barcode({code: '23798750900000000003373260000348962700417770', crc:false}, 'int25',{barWidth:1, barHeight:50, showHRI:false, output:'bmp'}); 		$('#bcTarget2').barcode({code: '23791753900000000003373260000348962800417770', crc:false}, 'int25',{barWidth:1, barHeight:50, showHRI:false, output:'bmp'}); 		$('#bcTarget3').barcode({code: '23797757000000000003373260000348962900417770', crc:false}, 'int25',{barWidth:1, barHeight:50, showHRI:false, output:'bmp'}); 		$('#bcTarget4').barcode({code: '23792760000000000003373260000348963000417770', crc:false}, 'int25',{barWidth:1, barHeight:50, showHRI:false, output:'bmp'}); 		$('#bcTarget5').barcode({code: '23791763100000000003373260000348963100417770', crc:false}, 'int25',{barWidth:1, barHeight:50, showHRI:false, output:'bmp'}); 		$('#bcTarget6').barcode({code: '23797766200000000003373260000348963200417770', crc:false}, 'int25',{barWidth:1, barHeight:50, showHRI:false, output:'bmp'}); 	}); " +																												
		"</script>                                                                                                                               " ;
		
		bankSlipHtml = StringUtils.replace(bankSlipHtml, title, header);
		
		bankSlipHtml = createBarCode(1,bankSlipHtml, "467.5", "483.6", "p654", "508.0");
		bankSlipHtml = createBarCode(2,bankSlipHtml, "747.5", "763.6", "p1079", "788.0");
		bankSlipHtml = createBarCode(3,bankSlipHtml, "194.5", "210.6", "p1504", "235.0");
		bankSlipHtml = createBarCode(4,bankSlipHtml, "474.5", "490.6", "p1864", "515.0");
		bankSlipHtml = createBarCode(5,bankSlipHtml, "754.5", "770.6", "p2289", "795.0");
		bankSlipHtml = createBarCode(6,bankSlipHtml, "194.5", "210.6", "p2714", "235.0");
		
		return bankSlipHtml;
	}
	
	private static String createBarCode(Integer positionBarCode, String bankSlipHtml, String topDivInitial, String topImg, String idDiv, String topDiv) {
		if(positionBarCode != 6) {
			String divInitial = "<div class=\"r\" style=\"left:22.0pt;top:"+topDivInitial+"pt;width:90.0pt;height:0.0pt;border-bottom:1.0pt solid #000000;\">&nbsp;</div>";
			String divRemove =  "<div class=\"r\" style=\"left:22.0pt;top:"+topDivInitial+"pt;width:90.0pt;height:0.0pt;border-bottom:1.0pt solid #000000;\">&nbsp;</div> <div style='display: none !important;'>";
			bankSlipHtml = StringUtils.replace(bankSlipHtml, divInitial, divRemove);
		}
		String img  = "<div class=\"p\" id=\""+idDiv+"\" style=\"top:"+topImg+"pt;left:358.97498pt;line-height:4.625pt;font-family:Helvetica;font-size:5.0pt;font-weight:bold;width:14.725006pt;\">POÇO</div>";
		String img1 = "</div> ***barcode"+positionBarCode+"***  <div class=\"p\" id=\""+idDiv+"\" style=\"top:"+topImg+"pt;left:358.97498pt;line-height:4.625pt;font-family:Helvetica;font-size:5.0pt;font-weight:bold;width:14.725006pt;\">POÇO</div>";
		bankSlipHtml = StringUtils.replace(bankSlipHtml, img, img1);
		String div = "<div id='bcTarget"+positionBarCode+"' style='position:absolute;left:140.0pt;top:"+topDiv+"pt;width:306.0pt;height:50.0pt;'></div>";
		bankSlipHtml = StringUtils.replace(bankSlipHtml, "***barcode"+positionBarCode+"***", div);
		return bankSlipHtml;
	}
}
