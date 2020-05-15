<?php 

include("config.php");

$ashar = $_POST['ashar'];

$sql = "UPDATE jadwal_sholat SET ashar='$ashar' WHERE id_jadwal='1'";
$query = mysqli_query($db, $sql);


// cek apakah query update berhasil
if ($query) {
	# code...
} else {
	// kondisi jika gagal ditampilkan pesan
	die("Gagal menyimpan perubahan...");
}

?>