<!DOCTYPE html>
@extends('layouts.master')

@section('header')
City List from DB!
@endsection

@section('content')
<table class="table table-striped table-hover">
    <tr>
        <th>City Name</th>
        <th>State</th>
        <th>2010 Population</th>
        <th>Population Rank</th>
    </tr>
    @foreach($places as $city)
    <tr>
        <td>{{$city->name}}</td>
        <td>{{$city->state}}</td>
        <td>{{$city->population_2010}}</td>
        <td>{{$city->population_rank}}</td>
    </tr>
    @endforeach
</table>
@endsection

</html>