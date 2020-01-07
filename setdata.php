<?php
	require_once 'connection.php';
	if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
    }
    $f = $_GET['flag'];
    $s = $_GET['str'];
    $sql = "UPDATE `iotrku` SET `flag`= ('$f') , `str`= ('$s') ";  
	if(mysqli_query($conn,$sql))
	{
        echo $f;
        echo $s;
	}
	else
	{
		echo "not";
    }
    
?>