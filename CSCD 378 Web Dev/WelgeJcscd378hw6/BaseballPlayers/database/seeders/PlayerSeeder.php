<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;

class PlayerSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        //delete all players, (want to delete and repopulate)
        \App\Models\Player::query()->delete();
        //iterate N times to create N players
            //create a "random" player
        
        $faker=\Faker\Factory::create();
        foreach(range(1,200) as $number) {
            \App\Models\Player::create([
                'first'=>$faker->name,
                'last'=>$faker->name,
                'team'=>$faker->name,
                'position'=>'SS', //$faker->text($maxNChars=2)
                'jersey_number'=>$faker->numberBetween(0,99),
                'age'=>$faker->numberBetween(0,99)
            ]);
        }
    }
}
