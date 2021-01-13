package parsing;

public class weather {

    private  Integer id;
    private String name;
    private String country;
    private Coord coord;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public weather withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public weather withName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public weather withCountry(String country) {
        this.country = country;
        return this;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public weather withCoord(Coord coord) {
        this.coord = coord;
        return this;
    }

}

