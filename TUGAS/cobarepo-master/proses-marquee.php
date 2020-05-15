<?php 

include("config.php");

$isi_marquee = $_POST['isi_marquee'];

$sql = "UPDATE isi_marquee SET isi_marquee='$isi_marquee' WHERE id_marquee='1'";
$query = mysqli_query($db, $sql);

// cek apakah query update berhasil
if ($query) {
	# code...
} else {
	// kondisi jika gagal ditampilkan pesan
	die("Gagal menyimpan perubahan...");
}

?>