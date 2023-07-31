package com.example.AchatLocal.Endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AchatLocal.Model.DemandeArticle;
import com.example.AchatLocal.Service.DemandeArticleService;

import net.sf.jasperreports.engine.JRException;

@RequestMapping("/demandeArticle")
@CrossOrigin
@RestController
public class DemandeArticleEndpoint {
	
	@Autowired
	private DemandeArticleService serv;

	@GetMapping("")
	public List<DemandeArticle> findAllDemandeArticles() {
		return serv.findAll();
	}

	@GetMapping("/{id}")
	public DemandeArticle findDemandeArticleById(@PathVariable Integer id) {
		return serv.findById(id);
	}
	
	@GetMapping("/pdf/{id}")
	public ResponseEntity<byte[]> generatePdf(@PathVariable Integer id) {
        try {
            byte[] pdfData = serv.pdfReport(serv.findById(id)); 

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("Demande Article.pdf").build());

            return new ResponseEntity<>(pdfData, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@PostMapping("")
	public void saveDemandeArticle(@RequestBody DemandeArticle da) {
		serv.saveDemandeArticle(da);
	}
	
	@PutMapping("")
	public void updateDemandeArticle(@RequestBody DemandeArticle da) {
		serv.updateDemandeArticle(da);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDemandeArticle(@PathVariable Integer id) {
		serv.deleteDemandeArticle(id);
	}
	

}
