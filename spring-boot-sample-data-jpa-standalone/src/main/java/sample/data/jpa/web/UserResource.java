package sample.data.jpa.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sample.data.jpa.dao.UserDao;
import sample.data.jpa.domain.User;

@RestController
public class UserResource {
	
	@Autowired
    private UserDao userDao;

	@RequestMapping(value ="/user/{id}", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
	public User getUserById(@PathVariable("id") Long userId)  {
		// return user
	    return userDao.findById(userId).isPresent() ? userDao.findById(userId).get() : null;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseBody
	public ResponseEntity<String> addUser(
			@RequestBody() User user) {
	    // add user
	    
	    if(user.getName() == null) {
	    	return new ResponseEntity<>("nothing added user must have a name", HttpStatus.NO_CONTENT);
		}
		else {
			userDao.save(user);
			return new ResponseEntity<>(""+user.getName()+ " added", HttpStatus.OK);
		}
		
	}
			

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
	public ResponseEntity<String> deleteUserById(@PathVariable("userId") Long userId)  {
		
		User user = userDao.findById(userId).isPresent() ? userDao.findById(userId).get() : null;
		if(user == null) {
			return new ResponseEntity<>("no content", HttpStatus.NO_CONTENT);
		}
		else {
			userDao.deleteById(userId);;
			return new ResponseEntity<>(""+user.getName()+ " deleted", HttpStatus.OK);
		}
	    
	}
}
