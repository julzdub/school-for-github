<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/
//highlight and click alt-shit-a at the same time to comment chunks out

/* Route::get('/', function () {
    return view('welcome');
}); */

/* // Julian Welge -- this project currently pulls from the sqlite database1 of washington cities and displays them in a table that is capable of being searched in all fields and sorted either ascending or descending (Mar. 17 2021) */

Route::get('/cities', function() {
    $cities = App\Models\City::all();
    return view('city_list', ['places' =>$cities]);
});

Route::get('/', App\Http\Livewire\Playground::class);
