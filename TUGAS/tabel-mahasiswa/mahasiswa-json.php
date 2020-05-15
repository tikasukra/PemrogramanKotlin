<?php

	include("config_mhs.php");

	$sql = "SELECT * FROM tbl_mahasiswa";
	$result = array();
	$query = mysqli_query($db, $sql);

	while ($row = mysqli_fetch_array($query)) {
		# code...
		array_push($result, array('nim_mhs' => $row['nim_mhs'], 
			'nama_mhs'=>$row['nama_mhs'],
			'prodi'=>$row['prodi']
		));
	}

	echo json_encode(array("result"=>$result));
?>