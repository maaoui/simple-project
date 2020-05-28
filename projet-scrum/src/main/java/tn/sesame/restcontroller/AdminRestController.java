package tn.sesame.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import tn.sesame.domain.Admin;
import tn.sesame.repository.IAdmin;




@CrossOrigin(origins = "*" )
@RestController
@RequestMapping(path="/admin")
public class AdminRestController {
	
	@Autowired
	private IAdmin repoadmin;
	
	
	
	
	

	public AdminRestController(IAdmin repoadmin) {
		super();
		this.repoadmin = repoadmin;
	}
	//affiche la listeadmin
	
	@GetMapping(path="/afficheadmin")
	 public List<Admin> touslesadmins()  {
		return  repoadmin.findAll();
	 }
	
	 
	 
	 //affiche par id
	
	@RequestMapping(value = "/{idadmin}", method = RequestMethod.GET)
		public  ResponseEntity<Admin> findById(@PathVariable("idadmin") Integer id) {
			Optional<Admin> resultat =  repoadmin.findById(id);
			if (resultat.isPresent())
				return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	

	
	//ajoutoffre
	
		
		@PostMapping(path="/ajoutadmin")
		
	
		public  ResponseEntity<Admin> create( @RequestBody Admin c){
			
		
			repoadmin.save(c);
				return new ResponseEntity<Admin>(c, HttpStatus.CREATED);
		
			
		
		}
		
		@PutMapping
		public  ResponseEntity<Admin> update(@RequestBody Admin c){
			 
			 try {
				 repoadmin.save(c);
					return new ResponseEntity<Admin>(c, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Admin>(HttpStatus.NOT_ACCEPTABLE);
				}
			
		}
		@DeleteMapping(path= "/{id}" )
		public  ResponseEntity<Admin> deleteById(@PathVariable("id") Integer id) {
			Optional<Admin> resultat =  repoadmin.findById(id);
			if (resultat.isPresent()) {
				repoadmin.delete(resultat.get());
				 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
				
			else
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	
	

}
