/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.beer.api.cerveja;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jairanderson
 */
public class Lista implements Serializable {

    private List<Beer> cervejas;

    public Lista() {
    }

    public List<Beer> getCervejas() {
        return cervejas;
    }

    public void setCervejas(List<Beer> cervejas) {
        this.cervejas = cervejas;
    }

}
