<?php
	session_start();
?>
<?php
$db = mysqli_connect("localhost","root","","dt211");
$username = $_SESSION['username'];
if (mysqli_connect_errno())
{
}
else
{
}

$sql = "INSERT INTO $username (ID,Date,Instructor,Car,Time)
VALUES ('$_POST[id]', '$_POST[date]', '$_POST[ins]', '$_POST[car]', '$_POST[time]')";


if ($db->query($sql) == TRUE )
{
}
header("Location: schedule.php");
/*
$sql = "INSERT INTO usertable (Username, Password, First Name,Surname,Age)
VALUES ('$_POST["username"]','$_POST["password"]','$_POST["firstname"]','$_POST["surname"],'$_POST["age"]')";
*/	


?>
