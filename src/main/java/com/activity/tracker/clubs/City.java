package com.activity.tracker.clubs;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue
    private int cityId;
    private int cityName;
    @OneToMany(cascade = ALL, orphanRemoval = true, mappedBy = "city")
    private List<Club> clubs = new ArrayList<> ();

    public City(){}
    public City(int cityId, int cityName, List<Club> clubs) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.clubs = clubs;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCityName() {
        return cityName;
    }

    public void setCityName(int cityName) {
        this.cityName = cityName;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }


    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName=" + cityName +
                ", clubs=" + clubs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        City city = (City) o;
        return cityId == city.cityId &&
                cityName == city.cityName &&
                Objects.equals (clubs, city.clubs);
    }

    @Override
    public int hashCode() {
        return Objects.hash (cityId, cityName, clubs);
    }
}
