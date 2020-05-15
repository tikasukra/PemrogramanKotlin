<?php 

include("config.php");

$judul_slideshow = $_POST['judul_slideshow'];
$url_slideshow = $_POST['url_slideshow'];

$sql = "UPDATE slideshow SET judul_slideshow='$judul_slideshow', url_slideshow='$url_slideshow' WHERE id_slidehow='1'";
$query = mysqli_query($db, $sql);

// cek apakah query update berhasil
if ($query) {
	# code...
} else {
	// kondisi jika gagal ditampilkan pesan
	die("Gagal menyimpan perubahan...");
}

?>