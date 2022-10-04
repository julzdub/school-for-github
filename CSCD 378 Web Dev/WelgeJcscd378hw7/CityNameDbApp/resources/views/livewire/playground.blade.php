@section('header')
<h1>My Cities App</h1>
@endsection
@section('title')
Cities
@endsection

<div>
    <input wire:model="citySearch" type="text" placeholder="Search Cities"/>
    <table class="table table-striped table-hover">
        <tr>
            <th><a href="#" wire:click = "doSort('name', 'asc')">&#8679;</a> City Name <a href="#" wire:click = "doSort('name', 'desc')">&#8681;</a></th>
            <th><a href="#" wire:click = "doSort('state', 'asc')">&#8679;</a> State <a href="#" wire:click = "doSort('state', 'desc')">&#8681;</a></th>
            <th><a href="#" wire:click = "doSort('population_2010', 'asc')">&#8679;</a> 2010 Population <a href="#" wire:click = "doSort('population_2010', 'desc')">&#8681;</a></th>
            <th><a href="#" wire:click = "doSort('population_rank', 'asc')">&#8679;</a> Population Rank <a href="#" wire:click = "doSort('population_rank', 'desc')">&#8681;</a></th>
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
</div>