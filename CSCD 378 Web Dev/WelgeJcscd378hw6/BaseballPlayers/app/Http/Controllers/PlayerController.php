<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class PlayerController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $players = \App\Models\Player::paginate(25); //could call ::all() but this splits into pages
        return view('baseballplayers.index', ['ballplayers' => $players]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
        return view('baseballplayers.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
        //dd($request);
        $validatedData = $request->validate(['first'=>'required', 'last'=>'required', 'team'=>'required','jersey_number'=>'required', 'position'=>'required', 'age'=>'integer']);

        \App\Models\Player::create($validatedData);

        return redirect()->route('baseballplayers.index')->with('success', 'Player was added!');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
        $player = \App\Models\Player::findOrFail($id); //use findOrFail to get 404 codes
        return view('baseballplayers.show', ['ballplayers' => $player]);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
        $player = \App\Models\Player::findOrFail($id);
        return view('baseballplayers.edit', ['ballplayers' => $player]);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
        $player = \App\Models\Player::findOrFail($id); 

        $validatedData = $request->validate(['first'=>'required', 'last'=>'required', 'team'=>'required','jersey_number'=>'required', 'position'=>'required', 'age'=>'integer']);

        $player->update($validatedData);

        return redirect()->route('baseballplayers.index')->with('success', 'Player was updated!');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
        $player = \App\Models\Player::findOrFail($id);
        $name = $player->first;
        $player->delete();
        return redirect()->route('baseballplayers.index')->with('success', "$name was deleted!");
    }
}
