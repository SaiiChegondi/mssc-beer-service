package guru.springframework.msscbeerservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.domain.repostories.BeerRepository;


@Component
public class BeerLoader implements CommandLineRunner {
	
	
	private BeerRepository beerRepo;
	
	public BeerLoader(BeerRepository repo)
	{
		this.beerRepo=repo;
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		loadBeerObjects();
	}

	private void loadBeerObjects() {
		// TODO Auto-generated method stub
		if(beerRepo.count()==0)
		{
			beerRepo.save(Beer.builder()
					.beerName("Mango Bobs")
					.beerStyle("IPA")
					.quantityToBrew(200)
					.upc(33701000000L)
					.price(new BigDecimal("12.95"))
					.build());
			
			beerRepo.save(Beer.builder()
					.beerName("Galaxy Cat")
					.beerStyle("PALE ALE")
					.quantityToBrew(200)
					.upc(33701000002L)
					.price(new BigDecimal("121.95"))
					.build());
		}
		
		System.out.println("count is"+beerRepo.count());
		
	}

}
