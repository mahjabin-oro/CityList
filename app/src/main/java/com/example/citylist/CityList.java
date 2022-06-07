package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This method provides a sorted list of cities,
     * if the parameter value is 1, cities are sorted according to their nam
     * else the province name they belong to
     * @param param
     * @return
     * sorted list of cities in the list
     */
    public List<City> getCities(int param) {
        List<City> cityList = cities;
        if(param==1)
        {
            Collections.sort(cityList);
        }
        else
        {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }
        return cityList;
    }

    /**
     * first check if city exists, if so delete it or
     * throw an exception
     * @param city
     */

    public void deleteCIty(City city)
    {
        if(cities.contains(city))
        {
            cities.remove(city);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }


    /**
     * counts the number of cities in the list
     * @return total number of cities
     */
    public int count()
    {
        return cities.size();
    }
}
