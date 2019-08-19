<?php 
header('Content-Type: Application/JSON charset=utf-8');
 //database constants
 define('DB_HOST', 'sistemacz.mysql.uhserver.com');
 define('DB_USER', 'sistemacz');
 define('DB_PASS', '030182.dtb');
 define('DB_NAME', 'sistemacz');
 //connecting to database and getting the connection object
 $mysqli = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
mysqli_set_charset($mysqli,"utf8");

 $data = $_POST["data"];
 
 //Checking if any error occured while connecting
 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: ".mysqli_connect_error();
 die();
 }

 $stmt = $mysqli->prepare("SELECT numeroDenuncia, "
         . "bairro, "
         . "logradouro, "
         . "numeroEndereco, "
         . "tipoImovel, "
         . "tipoDenuncia FROM denuncia ORDER BY numeroDenuncia DESC;");

 $stmt->execute();
 
 //binding results to the query 
 $stmt->bind_result($numeroDenuncia["numeroDenuncia"], 
         $bairro["bairro"], 
         $logradouro["logradouro"], 
         $numeroEndereco["numeroEndereco"], 
         $tipoImovel["tipoImovel"],
         $tipoDenuncia["tipoDenuncia"]);
 
 $denuncia = array(); 
 while($stmt->fetch()){
 $temp = array();
 $temp["numeroDenuncia"] = $numeroDenuncia['numeroDenuncia']; 
 $temp["bairro"] = $bairro['bairro']; 
 $temp["logradouro"] = $logradouro['logradouro']; 
 $temp["numeroEndereco"] = $numeroEndereco['numeroEndereco']; 
 $temp["tipoImovel"] = $tipoImovel['tipoImovel']; 
 $temp["tipoDenuncia"] = $tipoDenuncia['tipoDenuncia']; 
 array_push($denuncia, $temp);
 }
 echo json_encode($denuncia);
 
 ?>