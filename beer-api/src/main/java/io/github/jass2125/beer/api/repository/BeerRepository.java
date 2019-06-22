/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.beer.api.repository;

import io.github.jass2125.beer.api.beer.filters.BeerFilter;
import io.github.jass2125.beer.api.model.beer.Beer;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class BeerRepository {

    private RestTemplate restTemplate;
    private HttpHeaders headers;
    private HttpEntity<String> requestEntity;
    private String url;
    private ResponseEntity<Beer[]> response;

    public BeerRepository() {
        this.restTemplate = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        this.requestEntity = new HttpEntity<>("", headers);
        this.url = "https://api.punkapi.com/v2/beers";
    }

    public List<Beer> searchPagination(int page, int size, BeerFilter beerFilter) {
        this.restTemplate = new RestTemplate();
        StringBuilder parameters = new StringBuilder();
        parameters.append("?");
        if (beerFilter.getName() != null) {
            parameters
                    .append("beer_name=")
                    .append(beerFilter.getName())
                    .append("&");
        }
        if (beerFilter.getFood() != null) {
            parameters
                    .append("food=")
                    .append(beerFilter.getFood())
                    .append("&");

        }
        if (beerFilter.getAbvGt() != null) {
            parameters
                    .append("abv_gt=")
                    .append(beerFilter.getAbvGt())
                    .append("&");

        }
        if (beerFilter.getAbvLt() != null) {
            parameters
                    .append("abv_lt=")
                    .append(beerFilter.getAbvLt())
                    .append("&");

        }
        if (beerFilter.getIbuGt() != null) {
            parameters
                    .append("ibu_gt=")
                    .append(beerFilter.getIbuGt())
                    .append("&");

        }
        if (beerFilter.getIbuLt() != null) {
            parameters
                    .append("ibu_lt=")
                    .append(beerFilter.getIbuLt())
                    .append("&");

        }
        if (beerFilter.getEbcGt() != null) {
            parameters
                    .append("ebc_gt=")
                    .append(beerFilter.getEbcGt())
                    .append("&");

        }
        if (beerFilter.getEbcLt() != null) {
            parameters
                    .append("ebc_lt=")
                    .append(beerFilter.getEbcLt())
                    .append("&");

        }
        if (beerFilter.getYeast() != null) {
            parameters
                    .append("yeast")
                    .append(beerFilter.getYeast())
                    .append("&");

        }
        if (beerFilter.getBrewedBefore() != null) {
            parameters
                    .append("brewed_before=")
                    .append(beerFilter.getBrewedBefore())
                    .append("&");

        }
        if (beerFilter.getBrewedAfter() != null) {
            parameters
                    .append("brewed_after=")
                    .append(beerFilter.getBrewedAfter())
                    .append("&");

        }
        if (beerFilter.getHops() != null) {
            parameters
                    .append("hops=")
                    .append(beerFilter.getHops())
                    .append("&");

        }
        if (beerFilter.getMalt() != null) {
            parameters
                    .append("malt=")
                    .append(beerFilter.getMalt())
                    .append("&");

        }
        if (beerFilter.getIds() != null) {
            parameters
                    .append("ids=")
                    .append(beerFilter.getIds())
                    .append("&");

        }
        final String urlFinal = this.url + parameters.toString() + "page=" + page + "&per_page=" + size;
        response = restTemplate.exchange(urlFinal, HttpMethod.GET, requestEntity, Beer[].class, headers);

        Beer[] body = response.getBody();

        return Arrays.asList(body);
    }

//    Login - Validação - Segurança
//Listagem - Filtro, paginação
//
}
