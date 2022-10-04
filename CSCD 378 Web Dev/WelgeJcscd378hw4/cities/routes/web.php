<?php


use App\Domain\CityAnalyzer;
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

Route::get('/', function () {
    return view('welcome');
});

Route::get('/cities', function () {
    $analyzer = new CityAnalyzer();
    $cities = $analyzer->fetchedCities;
    return view('cities/index', ['places' => $cities]);
});
