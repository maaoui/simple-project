package tn.sesame.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.sesame.domain.Collaborateur;
import tn.sesame.domain.Reclamations;
import tn.sesame.repository.IReclamations;


@CrossOrigin(origins = "*" )
@RestController
@RequestMapping(path="/reclamation")
public class ReclamationRestController {
	@Autowired
	private IReclamations reporec;
	

	public ReclamationRestController(IReclamations reporec) {
		super();
		this.reporec = reporec;
	}
	//affiche la listeadmin
	
	@GetMapping(path="/affichereclamation")
	 public List<Reclamations> touslesreclamations()  {
		return  reporec.findAll();
	 }
	
	 
	 
	 //affiche par id
	
	@RequestMapping(value = "/{idrec}", method = RequestMethod.GET)
		public  ResponseEntity<Reclamations> findById(@PathVariable("idrec") Integer id) {
			Optional<Reclamations> resultat =  reporec.findById(id);
			if (resultat.isPresent())
				return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	

	
	//ajoutoffre
	
		
		@PostMapping(path="/ajoutrec")
		
	
		public  ResponseEntity<Reclamations> create( @RequestBody Reclamations c){
			
		
			reporec.save(c);
				return new ResponseEntity<Reclamations>(c, HttpStatus.CREATED);
		
			
		
		}
		@PostMapping(path="/affecter")
		public  ResponseEntity<Reclamations> affecter(@RequestBody Reclamations c){
			 
			 try { 
				Collaborateur col= new Collaborateur(5,"3","3","3","3","3");
				c.setColl(col);
				 reporec.save(c);
					return new ResponseEntity<Reclamations>(c, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Reclamations>(HttpStatus.NOT_ACCEPTABLE);
				}
			
		}
		@PutMapping
		public  ResponseEntity<Reclamations> update(@RequestBody Reclamations c){
			 
			 try {
				 reporec.save(c);
					return new ResponseEntity<Reclamations>(c, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Reclamations>(HttpStatus.NOT_ACCEPTABLE);
				}
			
		}
		@DeleteMapping(path= "/{id}" )
		public  ResponseEntity<Reclamations> deleteById(@PathVariable("id") Integer id) {
			Optional<Reclamations> resultat =  reporec.findById(id);
			if (resultat.isPresent()) {
				reporec.delete(resultat.get());
				 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
				
			else
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	
}
