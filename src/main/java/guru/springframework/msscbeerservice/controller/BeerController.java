package guru.springframework.msscbeerservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbeerservice.services.BeerService;
import guru.springframework.msscbeerservice.web.model.BeerDto;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

	@Autowired
	private BeerService beerService;
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId)
	{
		return new ResponseEntity<>(beerService.getById(beerId),HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity saveNewBeer(@Validated @RequestBody BeerDto beerDto)
	{
		return new ResponseEntity<>(beerService.saveNewBeer(beerDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity UpdateBeer(@PathVariable UUID beerId,@Validated @RequestBody BeerDto beerDto)
	{
		return new ResponseEntity<>(beerService.updateBeer(beerId,beerDto),HttpStatus.NO_CONTENT);
	}
	
	
}
