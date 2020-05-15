<?php 

include("config.php");

$dhuha = $_POST['dhuha'];

$sql = "UPDATE jadwal_sholat SET dhuha='$dhuha' WHERE id_jadwal='1'";
$query = mysqli_query($db, $sql);

// cek apakah query update berhasil
if ($query) {
	# code...
} else {
	// kondisi jika gagal ditampilkan pesan
	die("Gagal menyimpan perubahan...");
}

?>