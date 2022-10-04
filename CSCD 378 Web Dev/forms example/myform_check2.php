<?php
function check_input($data, $problem='')
{
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    if ($problem && strlen($data) == 0)
    {
        die($problem);
    }
    return $data;
}

$yourname = check_input($_POST['yourname'], "You must enter your name!");
$email    = check_input($_POST['email'], "Please enter your email address");
$likeit   = check_input($_POST['likeit']);
$comments = check_input($_POST['comments']);
?>
<html>
<head>
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-exp.min.css">
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css"> 
</head>
<body>
Your name is: <?php echo $yourname; ?><br />
Your e-mail: <?php echo $email; ?><br />
<br />
Do you like this website? <?php echo $likeit; ?><br />
<br />
Comments:<br />
<?php echo $comments; ?>
</body>
</html>