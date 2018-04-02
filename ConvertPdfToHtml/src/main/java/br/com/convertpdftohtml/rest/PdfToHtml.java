package br.com.convertpdftohtml.rest;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.convertpdftohtml.utils.ConvertPdfToHtml;


@Path("/pdftohtml")
public class PdfToHtml {
	
	@PostConstruct
	private void init() {
		
	}
	
	@POST
	@Path("/convert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response convert(String fileName) throws Exception {
		return Response.status(200).entity(ConvertPdfToHtml.convert(new File(fileName))).build();
	}
}
