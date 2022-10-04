<?php

// Julian Welge cscd 378 Assignment 3

//checks input
function check_input($data, $problem = '')
{
    if ($data < 0) {
        die($problem);
    }
    return $data;
}

//finds prime factors, returns array.
function primefactor($num)
{
    $sqrt = sqrt($num);
    for ($i = 2; $i <= $sqrt; $i++) {
        if ($num % $i == 0) {
            return array_merge(primefactor($num / $i), array($i));
        }
    }
    return array($num);
}

function findDivisors($n)
{
    $array = array();
    for ($i = 1; $i <= $n; $i++) {
        if ($n % $i == 0) {
            $array[] = $i;
        }
    }
    return $array;
}

function baseEquivalents($num)
{

    $binary = base_convert($num, 10, 2);
    $octal = base_convert($num, 10, 8);
    $hexa = base_convert($num, 10, 16);

    return array($binary, $octal, $hexa);
}

function roots($num)
{
    $squared = $num * $num;
    $cubed = $num * $num * $num;
    $sRoot = sqrt($num);
    $cRoot = pow($num, 1 / 3);

    return array($squared, $cubed, $sRoot, $cRoot);
}

function facts($num) {
    $digitLength = mb_strlen($num);
    $digitSum = dSum($num);
    $reverseNum = revTheNum($num);
    return array($digitLength, $digitSum, $reverseNum);
    
}

//helper method for digit sum
function dSum($num) {
    $sum=0; $rem=0;  
    for ($i =0; $i<=strlen($num);$i++)  
    {  
    $rem=$num%10;  
    $sum = $sum + $rem;  
    $num=$num/10;  
    }  
    return $sum;
}

//helper method reverse number
function revTheNum($num)
{
    $revnum = 0;  
    while ($num > 1)  
    {  
    $rem = $num % 10;  
    $revnum = ($revnum * 10) + $rem;  
    $num = ($num / 10);   
    } 
    return $revnum; 
}



//varaible assignment below

$theNumber = check_input($_POST['theNumber'], "Please enter a positive integer");

/*
$fmt = numfmt_create( 'en', NumberFormatter::SPELLOUT );
$word = numfmt_format($fmt, $theNumber);
*/

$word = "temporarily inactive :(";

$primeFactors = primefactor($theNumber);
$divisors = findDivisors($theNumber);
$bases = baseEquivalents($theNumber);
$squaresAndRoots = roots($theNumber);
$funFacts = facts($theNumber);
?>


<html>
    <head>
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-exp.min.css">
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
    <div class="hero bg-primary">
        <div class="hero-body">
          <h1>Here are your results!</h1>
          <p>(some results may need adjusting)</p>
        </div>
    </div>
    </head>

    <body>
        <?php echo "Your number is: ", $theNumber; ?><br /><?php
        
        if ($_POST['theName'] == 'checked') { 
            
            echo "Your number in english is: ", $word; ?><br /><?php
        }
        if ($_POST['primeFactors'] == 'checked') {
            
            echo "The Prime Factors are: ", json_encode($primeFactors); ?><br /><?php
        }

        if ($_POST['divisors'] == "checked") {
            
            echo "The Divisors of your number are: ", json_encode($divisors); ?><br /><?php
        }

        if ($_POST['baseEquivalents'] == "checked") {
            
            echo "The Base Equivalents (base 2, 8, and 16) of your number are: ", json_encode($bases); ?><br /><?php
        }

        if ($_POST['squareRoots'] == "checked") {
        
            echo "The Roots (squared, cubed, sqrt, cube root) of your number are: ", json_encode($squaresAndRoots); ?><br /><?php
        }

        if ($_POST['funFacts'] == "checked") {
        
            echo "The fun facts (num of digits, sum of digits, num in reverse) of your number are: ", json_encode($funFacts);
        }
        ?>
    </body>
</html>