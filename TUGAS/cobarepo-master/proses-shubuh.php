<?php 

include("config.php");

$shubuh = $_POST['shubuh'];

$sql = "UPDATE jadwal_sholat SET shubuh='$shubuh' WHERE id_jadwal='1'";
$query = mysqli_query($db, $sql);

// cek apakah query update berhasil
if ($query) {
	# code...
} else {
	// kondisi jika gagal ditampilkan pesan
	die("Gagal menyimpan perubahan...");	
}

?>