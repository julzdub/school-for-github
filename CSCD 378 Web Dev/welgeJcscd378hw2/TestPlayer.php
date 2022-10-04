<?php

## Julian Welge cscd 378
# this code works by reading from the static method get_stats() inside the BaseballPlayer.php file.
# run this file for output.

require "BaseballPlayer.php";

$x = Player::get_stats();
echo ($x ["name"]."\n");
echo ("\nGames played:".count($x["games"])."\n");

$atbats=0;
for ($i = 0; $i < count($x["games"]); $i++)
{
   $atbats=$atbats+$x["games"][$i]["AB"];
}
echo ("At bats:".$atbats."\n");

$runs=0;
for ($i = 0; $i < count($x["games"]); $i++)
{
   $runs=$runs+$x["games"][$i]["R"];
}
echo ("Runs:".$runs."\n");

$hits=0;
for ($i = 0; $i < count($x["games"]); $i++)
{
   $hits=$hits+$x["games"][$i]["H"];
}
echo ("Hits:".$hits."\n");

$walks=0;
for ($i = 0; $i < count($x["games"]); $i++)
{
   $walks=$walks+$x["games"][$i]["BB"];
}
echo ("Walks:".$walks."\n");

$rbi=0;
for ($i = 0; $i < count($x["games"]); $i++)
{
   $rbi=$rbi+$x["games"][$i]["RBI"];
}
echo ("RBI:".$rbi."\n");

echo ("Batting Avg:".($runs/count($x["games"])));

?>