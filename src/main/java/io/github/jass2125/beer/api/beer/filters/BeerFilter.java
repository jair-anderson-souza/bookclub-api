package io.github.jass2125.beer.api.beer.filters;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BeerFilter {

    private String name;
    private String food;
    private Double abvGt;
    private Double abvLt;
    private Double ibuGt;
    private Double ibuLt;
    private Double ebcGt;
    private Double ebcLt;
    private String yeast;
    @JsonFormat(pattern = "mm-yyyy")
    private String brewedBefore;
    @JsonFormat(pattern = "mm-yyyy")
    private String brewedAfter;
    private String hops;
    private String malt;
    private String ids;

    public BeerFilter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Double getAbvGt() {
        return abvGt;
    }

    public void setAbvGt(Double abvGt) {
        this.abvGt = abvGt;
    }

    public Double getAbvLt() {
        return abvLt;
    }

    public void setAbvLt(Double abvLt) {
        this.abvLt = abvLt;
    }

    public Double getIbuGt() {
        return ibuGt;
    }

    public void setIbuGt(Double ibuGt) {
        this.ibuGt = ibuGt;
    }

    public Double getIbuLt() {
        return ibuLt;
    }

    public void setIbuLt(Double ibuLt) {
        this.ibuLt = ibuLt;
    }

    public Double getEbcGt() {
        return ebcGt;
    }

    public void setEbcGt(Double ebcGt) {
        this.ebcGt = ebcGt;
    }

    public Double getEbcLt() {
        return ebcLt;
    }

    public void setEbcLt(Double ebcLt) {
        this.ebcLt = ebcLt;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }

    public String getBrewedBefore() {
        return brewedBefore;
    }

    public void setBrewedBefore(String brewedBefore) {
        this.brewedBefore = brewedBefore;
    }

    public String getBrewedAfter() {
        return brewedAfter;
    }

    public void setBrewedAfter(String brewedAfter) {
        this.brewedAfter = brewedAfter;
    }

    public String getHops() {
        return hops;
    }

    public void setHops(String hops) {
        this.hops = hops;
    }

    public String getMalt() {
        return malt;
    }

    public void setMalt(String malt) {
        this.malt = malt;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

}
