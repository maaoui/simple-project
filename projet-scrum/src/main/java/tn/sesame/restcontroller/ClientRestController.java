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

import tn.sesame.domain.Client;
import tn.sesame.repository.IClient;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping(path="/client")
public class ClientRestController {
	
	@Autowired
	private IClient repoclient;
	
	
	
	
	

	public ClientRestController(IClient repoclient) {
		super();
		this.repoclient = repoclient;
	}
	//affiche la listeadmin
	
	@GetMapping(path="/afficheclient")
	 public List<Client> touslesclients()  {
		return  repoclient.findAll();
	 }
	
	 
	 
	 //affiche par id
	
	@RequestMapping(value = "/{idclient}", method = RequestMethod.GET)
		public  ResponseEntity<Client> findById(@PathVariable("idclient") Integer id) {
			Optional<Client> resultat =  repoclient.findById(id);
			if (resultat.isPresent())
				return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	

	
	//ajoutoffre
	
		
		@PostMapping(path="/ajoutclt")
		
	
		public  ResponseEntity<Client> create( @RequestBody Client c){
			
		
			repoclient.save(c);
				return new ResponseEntity<Client>(c, HttpStatus.CREATED);
		
			
		
		}
		
		@PutMapping
		public  ResponseEntity<Client> update(@RequestBody Client c){
			 
			 try {
				 repoclient.save(c);
					return new ResponseEntity<Client>(c, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Client>(HttpStatus.NOT_ACCEPTABLE);
				}
			
		}
		@DeleteMapping(path= "/{id}" )
		public  ResponseEntity<Client> deleteById(@PathVariable("id") Integer id) {
			Optional<Client> resultat =  repoclient.findById(id);
			if (resultat.isPresent()) {
				repoclient.delete(resultat.get());
				 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
				
			else
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	
	

	

}
