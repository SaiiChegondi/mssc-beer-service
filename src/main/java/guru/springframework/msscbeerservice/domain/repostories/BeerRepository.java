package guru.springframework.msscbeerservice.domain.repostories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import guru.springframework.msscbeerservice.domain.Beer;


public interface BeerRepository extends PagingAndSortingRepository<Beer,UUID>{

}
