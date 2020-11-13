package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.data.jpa.dao.CardDao;
import sample.data.jpa.domain.Card;
import sample.data.jpa.domain.User;

@RestController
@RequestMapping(path = "/card")
public class CardResource {

	@Autowired
    private CardDao cardDao;
	
	@GetMapping(path="/{id}", produces = "application/json")
	public Card getCardById(@PathVariable("id") Long userId)  {
		// return card
		return cardDao.findById(userId).isPresent() ? cardDao.findById(userId).get() : null;
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addCard(@RequestBody Card card) {
	    // add card
		if(card.getLabel() == null) {
	    	return new ResponseEntity<>("nothing added must have a label !", HttpStatus.NO_CONTENT);
		}
		else {
			cardDao.save(card);
			return new ResponseEntity<>(""+card.getLabel()+ " added", HttpStatus.OK);
		}

	}
			

	@DeleteMapping(path="/{id}", produces = "application/json")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") Long cardId)  {
		
		Card card = cardDao.findById(cardId).isPresent() ? cardDao.findById(cardId).get() : null;
		if(card == null) {
			return new ResponseEntity<>("no content", HttpStatus.NO_CONTENT);
		}
		else {
			cardDao.deleteById(cardId);;
			return new ResponseEntity<>(""+card.getLabel()+ " deleted", HttpStatus.OK);
		}
	    
	}
}
