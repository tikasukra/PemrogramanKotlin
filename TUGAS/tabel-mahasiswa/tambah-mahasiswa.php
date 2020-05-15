<?php

include("config_mhs.php");

$nim = $_POST['nim_mhs'];
$nama = $_POST['nama_mhs'];
$prodi = $_POST['prodi'];

$sql = "INSERT INTO tbl_mahasiswa(nim_mhs, nama_mhs, prodi) VALUES('$nim', '$nama', '$prodi')";

$query = mysqli_query($db, $sql);

if ($query) {
	# code...
} else {
	die("Gagal menyimpan data...");
}

?>