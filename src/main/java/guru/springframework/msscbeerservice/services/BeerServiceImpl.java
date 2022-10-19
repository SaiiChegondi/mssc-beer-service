package guru.springframework.msscbeerservice.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import guru.springframework.msscbeerservice.controller.NotFoundException;
import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.domain.repostories.BeerRepository;
import guru.springframework.msscbeerservice.web.mappers.BeerMapper;
import guru.springframework.msscbeerservice.web.model.BeerDto;

public class BeerServiceImpl implements BeerService {

	@Autowired
	 private BeerRepository repo;
	
	@Autowired
	private BeerMapper beerMapper;
	
	@Override
	public BeerDto getById(UUID beerId) {
		// TODO Auto-generated method stub
		return beerMapper.BeertoBeerDto(repo.findById(beerId).orElseThrow(NotFoundException::new));
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		// TODO Auto-generated method stub
		return beerMapper.BeertoBeerDto(repo.save(beerMapper.BeerdtoToBeer(beerDto)));
	}

	@Override
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		// TODO Auto-generated method stub
		Beer beer=repo.findById(beerId).orElseThrow(NotFoundException::new);
		beer.setBeerName(beerDto.getBeerName());
		beer.setBeerStyle(beerDto.getBeerStyle().name());
		beer.setPrice(beerDto.getPrice());
		beer.setUpc(beerDto.getUpc());
		
		return beerMapper.BeertoBeerDto(repo.save(beer));
	}

}
