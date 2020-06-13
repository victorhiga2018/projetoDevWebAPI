package br.com.projeto.resources;

import java.util.Date;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.model.Version;

@RestController 
public class exemploResources {
	

	
	@RequestMapping(value = {"/version", "/"}, method = RequestMethod.GET)
	public ResponseEntity<Version> getVersion() {
		
		Version version;
		version = new Version();
		version.setBuildVersionNumber(10);
		version.setBuildName("ProjetoAPI");
		version.setBuildDate(new Date());
		
		return new ResponseEntity<Version>(version, HttpStatus.OK);
		
		
		
	}

}
