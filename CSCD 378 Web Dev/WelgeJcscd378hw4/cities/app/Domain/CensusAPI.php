<?php

namespace App\Domain;

/*
Julian Welge - cscd 378 - Dr. Breshears
2/10/2021

Assignment Description:
"has a static function called fetchCitites. The function when called, 
returns parsed JSON data that's usable in your PHP code."
*/

// use GuzzleHttp\Exception\GuzzleException;
use GuzzleHttp\Client;

class CensusAPI
{

    public static function fetchCities()
    {
        $client = new Client();
        $res = $client->request('GET', 'http://data.wa.gov/resource/ktqk-i4iw.json');
        return json_decode($res->getBody()->getContents(), true);
    }
}
