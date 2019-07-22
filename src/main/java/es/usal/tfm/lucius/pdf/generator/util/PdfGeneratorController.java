package es.usal.tfm.lucius.pdf.generator.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfGeneratorController {

	@Autowired
	PdfGeneratorUtil pdfGeneratorUtil;

	@RequestMapping(value = "/testPdfCreator", method = RequestMethod.GET)
	public ResponseEntity<Resource> testPdfCreator() {
		String pdfGenerado = "";
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "James");
		try {
			pdfGenerado = pdfGeneratorUtil.createPdf("pdf/pdfTemplateInformeGeneral", data, "pdfGenerado");
		} catch (Exception e) {
			e.printStackTrace();
		}

		File file2Upload = new File("C:\\Users\\sergio\\AppData\\Local\\Temp\\" + pdfGenerado);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file2Upload.getName());
		InputStreamResource  i = null;
		try {
			i = new InputStreamResource (new FileInputStream(file2Upload));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("The length of the file " + file2Upload.getName() + " is : " + file2Upload.length());

		return ResponseEntity.ok().headers(headers).contentLength(file2Upload.length())
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(i);
	}

}
