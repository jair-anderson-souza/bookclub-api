package io.github.jass2125.beer.api.beer.resource;

import io.github.jass2125.beer.api.beer.filters.BeerFilter;
import io.github.jass2125.beer.api.beer.service.BeerService;
import io.github.jass2125.beer.api.cerveja.Beer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beer")
public class BeerResource {

    @Autowired
    private BeerService beerService;

    @GetMapping
    public List<Beer> search(@RequestParam(name = "page", required = false) final Integer page, @RequestParam(name = "size", required = false) final Integer size, BeerFilter beerFilter) {

        Integer pag = page == null ? 1 : page;
        Integer siz = size == null ? 5 : size;
        List<Beer> beers = this.beerService.searchAll(pag, siz, beerFilter);
        return beers;
    }

//Filtro por nome
//https://api.punkapi.com/v2/beers?beer_name=Buzz
}
