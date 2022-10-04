<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use PlayersTable;

class Player extends Model
{
    use HasFactory;

    protected $fillable = ['first', 'last', 'team', 'position', 'jersey_number', 'age'];
    protected $table = "players";
}
