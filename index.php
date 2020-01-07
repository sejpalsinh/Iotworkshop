<?php
	require_once 'connection.php';
	if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
    }
    $sql = "SELECT * FROM `iotrku`";

    $result = mysqli_query($conn, $sql);
    if (mysqli_num_rows($result) == true) 
    {		
        $row = mysqli_fetch_assoc($result);
        $f = $row['flag'];
        $s = $row['str'];
        echo($f);
        echo(" ");
        echo($s);
    } 
    else 
    {
        echo "not";
    }
        
?>