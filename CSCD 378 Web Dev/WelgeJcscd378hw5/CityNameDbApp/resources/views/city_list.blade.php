<html>

<head>
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-exp.min.css">
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
    <div class="hero bg-primary">
        <div class="hero-body">
            <h1> Cities List from DB :)</h1>
        </div>
    </div>
</head>

<ul>
    @foreach($places as $city)
    <li>{{$city->name}}</li>
    <li>{{$city->state}}</li>
    @endforeach
</ul>

</html>