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

import tn.sesame.domain.Manager;
import tn.sesame.repository.IManager;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping(path="/manager")



public class ManagerRestController {
	
	@Autowired
	private IManager repomanager;
	
	
	
	
	

	public ManagerRestController(IManager repomanager) {
		super();
		this.repomanager = repomanager;
	}
	//affiche la listeadmin
	
	@GetMapping(path="/affichemanager")
	 public List<Manager> touslesmanagers()  {
		return  repomanager.findAll();
	 }
	
	 
	 
	 //affiche par id
	
	@RequestMapping(value = "/{idmanager}", method = RequestMethod.GET)
		public  ResponseEntity<Manager> findById(@PathVariable("idmanager") Integer id) {
			Optional<Manager> resultat =  repomanager.findById(id);
			if (resultat.isPresent())
				return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	

	
	//ajoutoffre
	
		
		@PostMapping(path="/ajoutmanager")
		
	
		public  ResponseEntity<Manager> create( @RequestBody Manager c){
			
		
			repomanager.save(c);
				return new ResponseEntity<Manager>(c, HttpStatus.CREATED);
		
			
		
		}
		
		@PutMapping
		public  ResponseEntity<Manager> update(@RequestBody Manager c){
			 
			 try {
				 repomanager.save(c);
					return new ResponseEntity<Manager>(c, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Manager>(HttpStatus.NOT_ACCEPTABLE);
				}
			
		}
		@DeleteMapping(path= "/{id}" )
		public  ResponseEntity<Manager> deleteById(@PathVariable("id") Integer id) {
			Optional<Manager> resultat =  repomanager.findById(id);
			if (resultat.isPresent()) {
				repomanager.delete(resultat.get());
				 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
				
			else
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	
	


}
