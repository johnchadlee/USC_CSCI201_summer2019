package parsing;

public class Coord {

    private Double lon;
    private Double lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Coord withLon(Double lon) {
        this.lon = lon;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Coord withLat(Double lat) {
        this.lat = lat;
        return this;
    }

}
