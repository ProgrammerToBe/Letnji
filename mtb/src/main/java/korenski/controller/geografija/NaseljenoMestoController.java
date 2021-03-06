package korenski.controller.geografija;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import korenski.model.geografija.NaseljenoMesto;
import korenski.repository.geografija.NaseljenoMestoRepository;

@Controller
public class NaseljenoMestoController {

	@Autowired
	NaseljenoMestoRepository repository;
	
	@RequestMapping(
			value = "/novaNaseljenoMesto",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NaseljenoMesto> novaNaseljenoMesto(@RequestBody NaseljenoMesto naseljenoMesto , @Context HttpServletRequest request) throws Exception {

	
		return new ResponseEntity<NaseljenoMesto>(repository.save(naseljenoMesto), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/obrisiNaseljenoMesto/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE) //String id_string
	public ResponseEntity<NaseljenoMesto> obrisiNaseljenoMesto(@PathVariable("id") Long id , @Context HttpServletRequest request) throws Exception {

		NaseljenoMesto naseljenoMesto = repository.findOne(id);
		repository.delete(naseljenoMesto);
		return new ResponseEntity<NaseljenoMesto>(naseljenoMesto, HttpStatus.OK);
	}

	
	
	@RequestMapping(
			value = "/azurirajNaseljenoMesto",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NaseljenoMesto> azurirajNaseljenoMesto(@RequestBody NaseljenoMesto naseljenoMesto , @Context HttpServletRequest request) throws Exception {
		
		
		NaseljenoMesto naseljenoMestoToModify = repository.findOne(naseljenoMesto.getId());
		
		naseljenoMestoToModify.setOznaka(naseljenoMesto.getOznaka());
		naseljenoMestoToModify.setNaziv(naseljenoMesto.getNaziv());
		naseljenoMestoToModify.setPostanskiBroj(naseljenoMesto.getPostanskiBroj());
		

		return new ResponseEntity<NaseljenoMesto>(repository.save(naseljenoMestoToModify), HttpStatus.OK);
	}
	
	
	@RequestMapping(
			value = "/svaNaseljenaMesta",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<NaseljenoMesto>> svaNaseljenaMesta() throws Exception {

		
		return new ResponseEntity<ArrayList<NaseljenoMesto>>((ArrayList<NaseljenoMesto>) repository.findAll(), HttpStatus.OK);
	}
	

}
