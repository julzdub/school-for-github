<?php

namespace App\Http\Livewire;

use Livewire\Component;

class Playground extends Component
{
    public $citySearch = "";
    protected $queryString = ['citySearch' => ['except' => '']];
    public $sortBy = 'name';
    public $direction = 'asc';

    //takes in the field to sort and the direction of sorting
    public function doSort($field, $dir) {
        $this->sortBy = $field;
        $this->direction = $dir;
    }
    
    public function render()
    {
        $cities = \App\Models\City::where('name', 'like', "%$this->citySearch%")
        ->orWhere('state', 'like', "%$this->citySearch%")
        ->orWhere('population_2010', 'like', "%$this->citySearch%")
        ->orWhere('population_rank', 'like', "%$this->citySearch%")
        ->orderBy($this->sortBy, $this->direction);
        return view('livewire.playground', ['places' => $cities->get()]);
    }
}
