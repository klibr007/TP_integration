package sample.data.jpa.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.data.jpa.domain.Pet;

@RestController
@RequestMapping(path = "/pet")
public class PetResource {

	@GetMapping(path="/{petId}", produces = "application/json")
  public Pet getPetById(@PathVariable("petId") Long petId)  {
      // return pet
      return new Pet();
  }

}