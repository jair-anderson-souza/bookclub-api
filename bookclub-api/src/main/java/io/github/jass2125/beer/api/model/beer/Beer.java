package io.github.jass2125.beer.api.model.beer;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;

public class Beer implements Serializable {

    private Long id;
    private String name;
    private String tagline;
    @JsonProperty("first_brewed")
    private String firstBrewed;
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    private Double abv;
    private Double ibu;
    @JsonProperty("target_fg")
    private Long targetFg;
    private Long ebc;
    private Long srm;
    private Double ph;

    public Beer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Double getIbu() {
        return ibu;
    }

    public void setIbu(Double ibu) {
        this.ibu = ibu;
    }

    public Long getTargetFg() {
        return targetFg;
    }

    public void setTargetFg(Long targetFg) {
        this.targetFg = targetFg;
    }

    public Long getEbc() {
        return ebc;
    }

    public void setEbc(Long ebc) {
        this.ebc = ebc;
    }

    public Long getSrm() {
        return srm;
    }

    public void setSrm(Long srm) {
        this.srm = srm;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Beer other = (Beer) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Beer{" + "id=" + id + ", name=" + name + ", tagline=" + tagline + ", first_brewed=" + firstBrewed + ", description=" + description + ", image_url=" + imageUrl + ", abv=" + abv + ", ibu=" + ibu + ", targetFg=" + targetFg + ", ebc=" + ebc + ", srm=" + srm + ", ph=" + ph + '}';
    }

}

//{
//    "id": 1,
//    "name": "Buzz",
//    "tagline": "A Real Bitter Experience.",
//    "firstBrewed": "09/2007",
//    "description": "A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.",
//    "imageUrl": "https://images.punkapi.com/v2/keg.png",
//    "abv": 4.5,
//    "ibu": 60,
//    "target_fg": 1010,
//    "target_og": 1044,
//    "ebc": 20,
//    "srm": 10,
//    "ph": 4.4,
//    "attenuation_level": 75,
//    "volume": {
//      "value": 20,
//      "unit": "litres"
//    },
//    "boil_volume": {
//      "value": 25,
//      "unit": "litres"
//    },
//    "method": {
//      "mash_temp": [
//        {
//          "temp": {
//            "value": 64,
//            "unit": "celsius"
//          },
//          "duration": 75
//        }
//      ],
//      "fermentation": {
//        "temp": {
//          "value": 19,
//          "unit": "celsius"
//        }
//      },
//      "twist": null
//    },
//    "ingredients": {
//      "malt": [
//        {
//          "name": "Maris Otter Extra Pale",
//          "amount": {
//            "value": 3.3,
//            "unit": "kilograms"
//          }
//        },
//        {
//          "name": "Caramalt",
//          "amount": {
//            "value": 0.2,
//            "unit": "kilograms"
//          }
//        },
//        {
//          "name": "Munich",
//          "amount": {
//            "value": 0.4,
//            "unit": "kilograms"
//          }
//        }
//      ],
//      "hops": [
//        {
//          "name": "Fuggles",
//          "amount": {
//            "value": 25,
//            "unit": "grams"
//          },
//          "add": "start",
//          "attribute": "bitter"
//        },
//        {
//          "name": "First Gold",
//          "amount": {
//            "value": 25,
//            "unit": "grams"
//          },
//          "add": "start",
//          "attribute": "bitter"
//        },
//        {
//          "name": "Fuggles",
//          "amount": {
//            "value": 37.5,
//            "unit": "grams"
//          },
//          "add": "middle",
//          "attribute": "flavour"
//        },
//        {
//          "name": "First Gold",
//          "amount": {
//            "value": 37.5,
//            "unit": "grams"
//          },
//          "add": "middle",
//          "attribute": "flavour"
//        },
//        {
//          "name": "Cascade",
//          "amount": {
//            "value": 37.5,
//            "unit": "grams"
//          },
//          "add": "end",
//          "attribute": "flavour"
//        }
//      ],
//      "yeast": "Wyeast 1056 - American Ale™"
//    },
//    "food_pairing": [
//      "Spicy chicken tikka masala",
//      "Grilled chicken quesadilla",
//      "Caramel toffee cake"
//    ],
//    "brewers_tips": "The earthy and floral aromas from the hops can be overpowering. Drop a little Cascade in at the end of the boil to lift the profile with a bit of citrus.",
//    "contributed_by": "Sam Mason <samjbmason>"
//  },
