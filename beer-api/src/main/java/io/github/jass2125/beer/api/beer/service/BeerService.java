package io.github.jass2125.beer.api.beer.service;

import io.github.jass2125.beer.api.beer.filters.BeerFilter;
import io.github.jass2125.beer.api.beer.repository.BeerRepository;
import io.github.jass2125.beer.api.cerveja.Beer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public List<Beer> searchAll(Integer page, Integer size, BeerFilter beerFilter) {
        List<Beer> searchAll = this.beerRepository.searchPagination(page, size, beerFilter);
        return searchAll;
    }

}
