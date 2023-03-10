package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        list = MockCityList();
        City newCity = new City("Vancouver", "BC");
        // test for absence of city when it isn't present
        assertFalse(list.hasCity(newCity));
        list.addCity(newCity);
        // test for presence of city when it is present
        assertTrue(list.hasCity(newCity));
    }

    @Test
    void testDelete() {
        list = MockCityList();
        City newCity = new City("Vancouver", "BC");
        // city not present; expect error
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(newCity);
        });

        list.addCity(newCity);
        list.delete(newCity);
        // delete the city; shouldn't throw an error
        // check if city has indeed been removed
        assertFalse(list.hasCity(newCity));
    }
}
