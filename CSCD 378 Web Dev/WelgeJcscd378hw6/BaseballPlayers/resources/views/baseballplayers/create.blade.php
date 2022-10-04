@extends('layout')

@section('header')
Create Player
@endsection

@section('content')
<div class="column col-3">
    <h3>Add Player</h3>
    @if($errors->any())
    <div class="toast toast-error">
        @foreach($errors->all() as $error)
        <span>{{$error}}</span><br />
        @endforeach
    </div>
    @endif
    <form method="POST" action="{{route('baseballplayers.store')}}">
        @csrf
        <div class="form-group">
            <label class="form-label" for="first">First Name</label>
            <input class="form-label" type="text" name="first" id="first" value="{{old('first')}}"></input>

            <label class="form-label" for="last">Last Name</label>
            <input class="form-label" type="text" name="last" id="last" value="{{old('last')}}"></input>

            <label class="form-label" for="team">Team</label>
            <input class="form-label" type="text" name="team" id="team" value="{{old('team')}}"></input>

            <label class="form-label" for="jersey_number">Jersey Number</label>
            <input class="form-label" type="text" maxlength="2" name="jersey_number" id="jersey_number" value="{{old('jersey_number')}}"></input>

            <label class="form-label" for="position">Position</label>
            <select class="form-select" name="position">
                <option value="P">Pitcher</option>
                <option value="C">Catcher</option>
                <option value="1B">First Base</option>
                <option value="2B">Second Base</option>
                <option value="3B">Third Base</option>
                <option value="SS">Short Stop</option>
                <option value="LF">Left Field</option>
                <option value="CF">Center Field</option>
                <option value="RF">Right Field</option>
            </select>

            <label class="form-label" for="age">Age</label>
            <input class="form-label" type="integer" maxlength="3" name="age" id="age" value="{{old('age')}}"></input>

        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary">Store Player</button>
            <a href="{{route('baseballplayers.index')}}">Cancel</a>
        </div>

    </form>
</div>
@endsection