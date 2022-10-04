<?php

use Illuminate\Support\Facades\Route;
use App\Models\player;
use App\Http\Controllers\PlayerController;

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

/*
Route::get('/baseballplayers', function () {
    $players = \App\Models\player::all(); //gets all of the players in the DB
    return view('baseballplayers', ['ballplayers' => $players]);
});
*/

Route::resource('baseballplayers', PlayerController::class);
