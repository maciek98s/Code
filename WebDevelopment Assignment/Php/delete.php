<?php
	session_start();
?>

 
 <?php

 	$db = mysqli_connect("localhost","root","","dt211");
 	$id =  $_POST['delete'];
 	$username = $_SESSION['username'];

 	$sql = "DELETE FROM $username WHERE ID=$id ";

 	if ($db->query($sql) === TRUE) {
    header("Location: schedule.php");
} else {
    echo "Error deleting record: " . $db->error;
}

 	



 ?>
