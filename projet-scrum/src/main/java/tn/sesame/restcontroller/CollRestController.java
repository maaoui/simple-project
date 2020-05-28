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
import tn.sesame.repository.ICollaborateur;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping(path="/collaborateur")
public class CollRestController {
	
	@Autowired
	private ICollaborateur repocoll;
	
	public CollRestController(ICollaborateur repocoll) {
		super();
		this.repocoll = repocoll;
	}
	//affiche la listeclient
	
	@GetMapping(path="/affichecollaborateur")
	 public List<Collaborateur> touslescollaborateurs()  {
		return  repocoll.findAll();
	 }
	
	 
	 
	 //affiche par id
	
	@RequestMapping(value = "/{idcollaborateur}", method = RequestMethod.GET)
		public  ResponseEntity<Collaborateur> findById(@PathVariable("idcollaborateur") Integer id) {
			Optional<Collaborateur> resultat =  repocoll.findById(id);
			if (resultat.isPresent())
				return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	

	
	//ajoutoffre
	
		
		@PostMapping(path="/ajoutadmin")
		
	
		public  ResponseEntity<Collaborateur> create( @RequestBody Collaborateur c){
			
		
			repocoll.save(c);
				return new ResponseEntity<Collaborateur>(c, HttpStatus.CREATED);
		
			
		
		}
		
		@PutMapping
		public  ResponseEntity<Collaborateur> update(@RequestBody Collaborateur c){
			 
			 try {
				 repocoll.save(c);
					return new ResponseEntity<Collaborateur>(c, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Collaborateur>(HttpStatus.NOT_ACCEPTABLE);
				}
			
		}
		@DeleteMapping(path= "/{id}" )
		public  ResponseEntity<Collaborateur> deleteById(@PathVariable("id") Integer id) {
			Optional<Collaborateur> resultat =  repocoll.findById(id);
			if (resultat.isPresent()) {
				repocoll.delete(resultat.get());
				 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
				
			else
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
