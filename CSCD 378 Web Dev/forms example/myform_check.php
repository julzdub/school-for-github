<?php
$yourname = htmlspecialchars($_POST['yourname']);
$email    = htmlspecialchars($_POST['email']);
$likeit   = htmlspecialchars($_POST['likeit']);
$comments = htmlspecialchars($_POST['comments']);
?>
<html>
<body>
Your name is: <?php echo $_POST['yourname']; ?><br />
Your e-mail: <?php echo $_POST['email']; ?><br />
<br />
Do you like this website? <?php echo $_POST['likeit']; ?><br />
<br />
Comments:<br />
<?php echo $_POST['comments']; ?>
</body>
</html>