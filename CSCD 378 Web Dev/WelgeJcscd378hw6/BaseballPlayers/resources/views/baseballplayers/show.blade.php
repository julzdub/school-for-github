@extends('layout')

@section('header')
Player
@endsection

@section('content')
<div class="tile">
    <div class="tile-content">
        <p class="tile-title">Name: {{$ballplayers->first}} {{$ballplayers->last}}</p>
        <p class="tile-subtitle">Team: {{$ballplayers->team}}</p>
        <p>Jersey Number: {{$ballplayers->jersey_number}}</p>
        <p>Position: {{$ballplayers->position}}</p>
        <p>Age: {{$ballplayers->age}}</p>
    </div>
</div>

<p>
    <a href="{{route('baseballplayers.index')}}">Go Back to Baseball Players</a>
</p>
@endsection