
<?php
$db = mysqli_connect("localhost","root","","dt211");


if (mysqli_connect_errno())
{
}
else
{
}

$sql = "CREATE TABLE $_POST[Username] (
    Date text(50),
    Instructor text(50),
    Car text(50),
    Time text(50),
    ID int(4)
)";

//$result = mysqli_query($db, $sql) or die ("Bad Create: $sql");

 	if ($db->query($sql) === TRUE) {
    
} else {
    
}

$sql = "CREATE TABLE user (
    firstname text(50),
    Surname text(50),
    Username text(50),
    Password text(50),
    Email text(50)
)";

 	if ($db->query($sql) === TRUE) {
    $sql = "INSERT INTO user (firstname,Surname,Username,Password,Email)
VALUES ('$_POST[Name]', '$_POST[Surname]', '$_POST[Username]', '$_POST[Password]', '$_POST[Email]')";
} else {
    $sql = "INSERT INTO user (firstname,Surname,Username,Password,Email)
VALUES ('$_POST[Name]', '$_POST[Surname]', '$_POST[Username]', '$_POST[Password]', '$_POST[Email]')";
}








if ($db->query($sql) == TRUE )
{
}

/*
$sql = "INSERT INTO usertable (Username, Password, First Name,Surname,Age)
VALUES ('$_POST["username"]','$_POST["password"]','$_POST["firstname"]','$_POST["surname"],'$_POST["age"]')";
*/	

header("Location: ../Login.html");
?>