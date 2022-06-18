package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * this class contains all the unit test example methods
 */
public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }


    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    /**
     * checks if the add() method works properly
     */
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    /**
     * checks if the add() method works properly and throws exception on adding a
     * city more than once or not
     */

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * checks if the deleteCity() method works properly
     */
    @Test
    public void testdelete()
    {
        CityList cityList= new CityList();
        City a= new City("Rajshahi","Rajshahi");
        City b= new City("Natore","Rajshahi");
        cityList.add(a);
        cityList.add(b);
        cityList.deleteCIty(a);
        assertTrue(cityList.getCities(1).contains(b));

    }

    /**
     * checks if the deleteCity() method works properly and throws exception on deleting a
     *    city more than once or not
     */
    @Test
    public void testDeleteException()
    {
        CityList cityList= new CityList();
        City a= new City("Rajshahi","Rajshahi");
        City b= new City("Natore","Rajshahi");
        cityList.add(a);
        cityList.add(b);
        cityList.deleteCIty(a);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCIty(a);
        });


    }

    /**
     * checks if the count() method returns exact city count or not
     */
    @Test
    public void testcount()
    {
        CityList cityList= new CityList();
        City a= new City("Rajshahi","Rajshahi");
        City b= new City("Natore","Rajshahi");
        cityList.add(a);
        cityList.add(b);
        assertEquals(2,cityList.count());
        cityList.deleteCIty(a);
        assertEquals(1,cityList.count());
    }

    /**
     * checks the sorting of entries is properly done acccording to the city name or not
     */
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(-2, city.compareTo(cityList.getCities(1).get(1)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }
    /**
     * checks the sorting of entries is properly done acccording to the province name or not
     */
    @Test
    public void TestGetCitiesByProvince()
    {
        CityList cityList= new CityList();
        City a= new City("Dhaka","Dhaka");
        cityList.add(a);
        assertEquals(0, a.compareTo(cityList.getCities(2).get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(2).get(1)));
        assertEquals(0, a.compareTo(cityList.getCities(2).get(0)));

    }
}
