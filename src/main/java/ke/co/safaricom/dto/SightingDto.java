package ke.co.safaricom.dto;

import ke.co.safaricom.model.Locations;
import ke.co.safaricom.model.Rangers;
import ke.co.safaricom.model.Sightings;

public class SightingDto {
    private Sightings sighting;
    private Locations location;
    private Rangers ranger;


    public SightingDto(Sightings sighting, Locations location, Rangers ranger) {
        this.sighting = sighting;
        this.location = location;
        this.ranger = ranger;
    }

    public SightingDto() {
    }

    public Sightings getSighting() {
        return sighting;
    }

    public void setSighting(Sightings sighting) {
        this.sighting = sighting;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public Rangers getRanger() {
        return ranger;
    }

    public void setRanger(Rangers ranger) {
        this.ranger = ranger;
    }

    @Override
    public String toString() {
        return "SightingDto{" +
                "sighting=" + sighting +
                ", location=" + location +
                ", ranger=" + ranger +
                '}';
    }
}