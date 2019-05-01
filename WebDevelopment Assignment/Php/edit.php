<?php
	session_start();
?> 
 <?php

 	$db = mysqli_connect("localhost","root","","dt211");
 	$username = $_SESSION['username'];

 	$sql = "UPDATE $username SET Date='$_POST[id]',Instructor='$_POST[ins]',Car='$_POST[car]',Time='$_POST[time]' WHERE id=$_POST[id]";

if ($db->query($sql) === TRUE) {
    header("Location: schedule.php");
} else {
    echo "Error updating record: " . $db->error;
}

 ?>

