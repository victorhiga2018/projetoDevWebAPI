package br.com.projeto.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.projeto.domain.VagaTI;
import br.com.projeto.repository.VagaTIRepository;

@RestController
@CrossOrigin
public class CRUDVagaTIResources {
	// CRUD TRAS TODAS AS VAGAS

	@Autowired
	VagaTIRepository vagaTIRepository;

	@ResponseBody
	@RequestMapping(value = "/vagasTI", method = RequestMethod.GET)
	public ResponseEntity<?> obterTodasVagasTI() {
		List<VagaTI> vagaTI;
		vagaTI = vagaTIRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(vagaTI);
	}
	// CRUD TRAZ DETERMINADA VAGA

	@ResponseBody
	@RequestMapping(value = "/vagasTI/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterVagasTIPorId(@PathVariable("id") Integer id) {
		Optional<VagaTI> optVagaTI;
		VagaTI vagaTI;

		optVagaTI = vagaTIRepository.findById(id);
		if (!optVagaTI.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");

		vagaTI = optVagaTI.get();

		return ResponseEntity.status(HttpStatus.OK).body(vagaTI);
	}
	// TRAZ DETERMINADO CARGO

	@ResponseBody
	@RequestMapping(value = "vagasTI/busca", method = RequestMethod.GET)
	public ResponseEntity<List<VagaTI>> obterVagasTIPorCargo(@RequestParam("cargo") String cargo) {
		List<VagaTI> vagaTI = vagaTIRepository.findByCargoIgnoreCaseLike("%" + cargo + "%");

		if (vagaTI.size() == 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(vagaTI);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(vagaTI);
		}

	}

	// TRAZ DETERMINADO REQUISITOS

	@ResponseBody
	@RequestMapping(value = "vagasTI/busca-requisitos", method = RequestMethod.GET)
	public ResponseEntity<List<VagaTI>> obterVagasTIPorRequisitos(@RequestParam("requisitos") String requisitos) {
		List<VagaTI> vagaTI = vagaTIRepository.findByRequisitosIgnoreCaseLike("%" + requisitos + "%");

		if (vagaTI.size() == 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(vagaTI);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(vagaTI);
		}

	}

	// TRAZ DETERMINADO SALARIO

	@ResponseBody
	@RequestMapping(value = "vagasTI/busca-salario", method = RequestMethod.GET)
	public ResponseEntity<List<VagaTI>> obterVagasTIPorSalario(@RequestParam("salario") String salario) {
		List<VagaTI> vagaTI = vagaTIRepository.findBySalarioIgnoreCaseLike("%" + salario + "%");
		if (vagaTI.size() == 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(vagaTI);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(vagaTI);
		}
	}

	// TRAZ DETERMINADO SALARIO

	@ResponseBody
	@RequestMapping(value = "vagasTI/busca-dupla", method = RequestMethod.GET)
	public ResponseEntity<List<VagaTI>> obterVagasTIPorDupla(@RequestParam String arg) {

		List<VagaTI> vagaTI = vagaTIRepository
				.findByCargoIgnoreCaseLikeOrRequisitosIgnoreCaseLikeOrderByCargo("%" + arg + "%", "%" + arg + "%");
		if (vagaTI.size() == 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(vagaTI);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(vagaTI);
		}
	}

	// CRUD NOVO REGISTRO

	@ResponseBody
	@RequestMapping(value = "/vagasTI", method = RequestMethod.POST)
	public ResponseEntity<?> novaVagasTI(@RequestBody VagaTI vagaTI) {
		Optional<VagaTI> optVagaTI;

		optVagaTI = vagaTIRepository.findById(vagaTI.getId());
		if (optVagaTI.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");

		vagaTIRepository.save(vagaTI);
		return ResponseEntity.status(HttpStatus.CREATED).body(vagaTI);
	}

	// CRUD ATUALIZA

	@ResponseBody
	@RequestMapping(value = "/vagasTI/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> alteraVagasTI(@PathVariable("id") Integer id, @RequestBody VagaTI vagaTI) {
		Optional<VagaTI> optVagaTI;

		optVagaTI = vagaTIRepository.findById(vagaTI.getId());
		if (!optVagaTI.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");

		vagaTI.setId(id);
		vagaTIRepository.save(vagaTI);
		return ResponseEntity.status(HttpStatus.OK).body(vagaTI);
	}

	// CRUD DELETE

	@ResponseBody
	@RequestMapping(value = "/vagasTI/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarVagasTI(@PathVariable("id") Integer id) {
		Optional<VagaTI> optVagaTI;

		optVagaTI = vagaTIRepository.findById(id);
		if (!optVagaTI.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");

		vagaTIRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(optVagaTI.get());
	}

}
