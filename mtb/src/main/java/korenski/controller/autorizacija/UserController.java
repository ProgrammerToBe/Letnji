package korenski.controller.autorizacija;

import java.util.Collection;

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

import korenski.model.autorizacija.User;
import korenski.repository.autorizacija.UserRepository;

@Controller
public class UserController {


	@Autowired
	UserRepository repository;
	
	@RequestMapping(
			value = "/newUser",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> newUser(@RequestBody User user , @Context HttpServletRequest request) throws Exception {

		
		User rle;
		try {
			rle = repository.save(user);
		} catch (Exception e) {
			rle = new User(new Long(-1), null, null, null);
		}
	
		return new ResponseEntity<User>(rle, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/deleteUser/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE) //String id_string
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id , @Context HttpServletRequest request) throws Exception {

		User User = repository.findOne(id);
		
		try {
			repository.delete(User);
		} catch (Exception e) {
			return new ResponseEntity<User>(new User(new Long(-1), null, null, null), HttpStatus.OK);
		}
	
		return new ResponseEntity<User>(new User(), HttpStatus.OK);
	}

	
	
	@RequestMapping(
			value = "/updateUser",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user , @Context HttpServletRequest request) throws Exception {
		
		
		User userToModify = null;
		
		try {
			userToModify = repository.findOne(user.getId());
		} catch (Exception e) {
			return new ResponseEntity<User>(new User(new Long(-1), null, null, null), HttpStatus.OK);
		}
		
		userToModify.setUsername(user.getUsername());
		userToModify.setPassword(user.getPassword());
		userToModify.setRole(user.getRole());
		
		try {
			userToModify = repository.save(userToModify);
		} catch (Exception e) {
			return new ResponseEntity<User>(new User(new Long(-1), null, null, null), HttpStatus.OK);
		}

		return new ResponseEntity<User>(userToModify, HttpStatus.OK);
	}
	
	
	@RequestMapping(
			value = "/allUsers",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<User>> allUsers() throws Exception {

		
		return new ResponseEntity<Collection<User>>( repository.findAll(), HttpStatus.OK);
	}
	
}
