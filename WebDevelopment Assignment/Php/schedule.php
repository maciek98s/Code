<?php
	session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="../CSS Style sheets/schedule.css">
	<style>
	</style>
</head>
<style type="text/css">
	

	table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
 font-size: 14px;

}
</style>
<body>
<body>
	<div style="  float: left; ">
		<input type="image" src="../images/logo.jpg" height="200" width="200">
	</div>
	<div style="float:right;">
		<p class="text"> Author: Maciej Skrzypczynski <br> Studnet nr: C17339163 </p>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<ul>
  <li><a class="NavbarText" href="../HomePage.html">Home</a></li>
  <li><a class="NavbarText" href="../Login.html">Login</a></li>
  <li><a class="NavbarText" href="../contact.html">Contacts</a></li>
  <li><a class="NavbarText" href="../about.html">About Us</a></li>
</ul>
<br><br>
 <table  style="width:80%;">
 	<tr><td>
		ID
		</td>
		<td>	 	
		Date
		</td>
		<td>
		Instructor
		</td>
		<td>
		Car
		</td>
			<td>
		Time
		</td>
					<td colspan="2">
		Other Options
		</td>
 <?php

 	$db = mysqli_connect("localhost","root","","dt211");
 	$username = $_SESSION['username'];


if (mysqli_connect_errno())
{
}
else
{
}

	$result = mysqli_query($db, "SELECT Date,Instructor,Car,Time,ID FROM $username");
	while ( $row = mysqli_fetch_row($result) ) {

		echo "<tr><td>";
		echo (htmlentities($row[4]));
		echo "</td><td>";
		echo (htmlentities($row[0]));
		echo "</td><td>";
		echo (htmlentities($row[1]));
		echo "</td><td>";
		echo (htmlentities($row[2]));
		echo "</td><td>";
		echo (htmlentities($row[3]));
		echo "</td><td>";
		echo '<form action="delete.php" method="post">';
		echo '<input type="hidden" name="delete" value="'.htmlentities($row[4]).'">';
		echo '<button type="submit" class="delete">Delete</button>';
		echo '</form>';
		echo "</td><td>";
 ?>
  <div style=" ">
	<button onclick="document.getElementById('id02').style.display='block'"  style="display: flex; justify-content: center;">Edit</button>
</div>
 <?php
		echo "</td></tr>\n";
	}

 ?>
  </table>

 <div style="width: 10%; ">
	<button onclick="document.getElementById('id01').style.display='block'" class="add" style="display: flex; justify-content: center;">Add To Schedule</button>
</div>

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="add.php" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>

    <div class="container">
      <label for="uname"><b>ID</b></label>
      <input type="text" placeholder="Enter ID" name="id" required>

      <label for="psw"><b>Date</b></label>
      <input type="text" placeholder="Enter Date" name="date" required>

       <label for="psw"><b>Instructor</b></label>
      <input type="text" placeholder="Enter Instructors full name" name="ins" required>

      <label for="psw"><b>Car</b></label>
      <input type="text" placeholder="Enter the Car name" name="car" required>

       <label for="psw"><b>Time</b></label>
      <input type="text" placeholder="Enter the time of appointment " name="time" required>
        
      <button type="submit">Submit</button>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

<div id="id02" class="modal">
  
  <form class="modal-content2 animate" action="edit.php" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>

    <div class="container">
      <label for="uname"><b>ID</b></label>
      <input type="text" placeholder="Enter THe ID of the Entry You want to EDIT " name="id" required>

      <label for="psw"><b>Date</b></label>
      <input type="text" placeholder="Enter new Date" name="date" required>

       <label for="psw"><b>Instructor</b></label>
      <input type="text" placeholder="Enter new Instructors full name" name="ins" required>

      <label for="psw"><b>Car</b></label>
      <input type="text" placeholder="Enter new the Car name" name="car" required>

       <label for="psw"><b>Time</b></label>
      <input type="text" placeholder="Enter new the time of appointment " name="time" required>
        
      <button type="submit">Update</button>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');
var modal = document.getElementById('id02');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
</body>
</html>
