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

import tn.sesame.domain.Service;
import tn.sesame.repository.IAdmin;
import tn.sesame.repository.IService;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping(path="/service")
public class ServiceRestController {
	
	@Autowired
	private IService reposervice;
	
	
	
	
	

	public ServiceRestController(IService reposervice) {
		super();
		this.reposervice = reposervice;
	}
	//affiche la listeadmin
	
	@GetMapping(path="/afficheadmin")
	 public List<Service> touslesadmins()  {
		return  reposervice.findAll();
	 }
	
	 
	 
	 //affiche par id
	
	@RequestMapping(value = "/{idservice}", method = RequestMethod.GET)
		public  ResponseEntity<Service> findById(@PathVariable("idservice") Integer id) {
			Optional<Service> resultat =  reposervice.findById(id);
			if (resultat.isPresent())
				return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	

	
	//ajoutoffre
	
		
		@PostMapping(path="/ajoutadmin")
		
	
		public  ResponseEntity<Service> create( @RequestBody Service c){
			
		
			reposervice.save(c);
				return new ResponseEntity<Service>(c, HttpStatus.CREATED);
		
			
		
		}
		
		@PutMapping
		public  ResponseEntity<Service> update(@RequestBody Service c){
			 
			 try {
				 reposervice.save(c);
					return new ResponseEntity<Service>(c, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Service>(HttpStatus.NOT_ACCEPTABLE);
				}
			
		}
		@DeleteMapping(path= "/{id}" )
		public  ResponseEntity<Service> deleteById(@PathVariable("id") Integer id) {
			Optional<Service> resultat =  reposervice.findById(id);
			if (resultat.isPresent()) {
				reposervice.delete(resultat.get());
				 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
				
			else
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	
	

}
