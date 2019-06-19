/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.beer.api.infraestrutura.query;

import io.github.jass2125.beer.api.cerveja.Beer;
import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author jairanderson
 */
public class NewClass {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);

//        ResponseEntity<Beer> forEntity = restTemplate.getForEntity("https://api.punkapi.com/v2/beers", Beer.class, headers);
//        System.out.println(forEntity.getBody());
        ResponseEntity<Beer[]> response = restTemplate.exchange("https://api.punkapi.com/v2/beers", HttpMethod.GET, requestEntity, Beer[].class, headers);
        Beer[] body = response.getBody();
        System.out.println(Arrays.toString(body));

    }
}
