@extends('layout')

@section('header')
My Baseball Players App
<h3>Players List</h3>
@endsection

@section('content')
<a class="btn btn-primary" href="{{route('baseballplayers.create')}}">Add Player</a>
<table class="table table-striped table-hover">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Team</th>
        <th>Position</th>
        <th>Jersey Number</th>
        <th>Age</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    @foreach($ballplayers as $player)
    <tr>
        <td>{{$player->first}}</td>
        <td>{{$player->last}}</td>
        <td>{{$player->team}}</td>
        <td>{{$player->position}}</td>
        <td>{{$player->jersey_number}}</td>
        <td>{{$player->age}}</td>
        <td><a href="{{route('baseballplayers.show', $player->id)}}">Show Detail</a></td>
        <td><a href="{{route('baseballplayers.edit', $player->id)}}">Edit</a></td>
        <td>
            <form action="{{route('baseballplayers.destroy', $player->id)}}" method="POST" onsubmit="return confirm('Are you sure you want to delete {{$player->first}}?')">
                @csrf
                @method('DELETE')
                <button class="btn btn-error" type="submit">Delete</button>
            </form>
        </td>
    </tr>
    @endforeach
</table>
{{$ballplayers->links()}}
@endsection