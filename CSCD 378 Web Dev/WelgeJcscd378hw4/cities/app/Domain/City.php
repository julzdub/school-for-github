<?php
namespace App\Domain;
/*
Julian Welge - cscd 378 - Dr. Breshears
2/10/2021

Assignment Description:
Class named: City that has 2 properties for city name and population. 
Also, implement a toString method that formats a string in the format: 
    <city name> (<population>).
*/

class City {

    public $cityName, $population;

    public function __construct($c, $p) // where $c is the city name and $p is the population of the city. 
    {
        $this->cityName = $c;
        $this->population = $p;
    }

    public function __toString() {
        return "$this->cityName ($this->population)";
    }
}
