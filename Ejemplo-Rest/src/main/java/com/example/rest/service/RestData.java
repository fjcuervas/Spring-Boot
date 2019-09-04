package com.example.rest.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.model.ModelData;

@RestController
@RequestMapping(path="/rest")
public class RestData {
	
	@GetMapping(path="/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ModelData getJson(@RequestParam(name="msg") String message) {
		ModelData modelData = new ModelData();
		modelData.setCode(200);
		modelData.setStatus(true);
		modelData.setMensaje("Mensaje recibido: " + message);
		return modelData;
	}

	@GetMapping(path="/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody ModelData getXml(@RequestParam(name="msg") String message) {
		ModelData modelData = new ModelData();
		modelData.setCode(200);
		modelData.setStatus(true);
		modelData.setMensaje("Mensaje recibido: " + message);
		return modelData;		
	}
	/* No llega a generar bien el pdf y salta un error
	@GetMapping(path="/pdf")
	public @ResponseBody ResponseEntity<String> getPdf(@RequestParam(name="msg") String message) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(message);
	}	*/
}
