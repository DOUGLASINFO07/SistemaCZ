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
 //$pesquisa = $_POST[];
 //creating a query
 $stmt = $mysqli->prepare("SELECT numeroQuarteirao, "
         . "bairro, "
         . "logradouro, "
         . "numeroImovel, "
         . "sequencia, "
         . "complemento, "
         . "tipoVisita,"
         . "ciclo FROM boletimDiario ORDER BY idBoletimDiario DESC;");
 //executing the query 
 $stmt->execute();
 
 //binding results to the query 
 $stmt->bind_result($numeroQuarteirao["numeroQuarteirao"], 
         $bairro["bairro"], 
         $logradouro["logradouro"], 
         $numeroImovel["numeroImovel"], 
         $sequencia["sequencia"],
         $complemento["complemento"],
         $tipoVisita["tipoVisita"],
         $ciclo["ciclo"]);
 
 $boletimDiario = array(); 
 while($stmt->fetch()){
 $temp = array();
 $temp["numeroQuarteirao"] = $numeroQuarteirao['numeroQuarteirao']; 
 $temp["bairro"] = $bairro['bairro']; 
 $temp["logradouro"] = $logradouro['logradouro']; 
 $temp["numeroImovel"] = $numeroImovel['numeroImovel']; 
 $temp["sequencia"] = $sequencia['sequencia']; 
 $temp["complemento"] = $complemento['complemento']; 
 $temp["tipoVisita"] = $tipoVisita['tipoVisita']; 
 $temp["ciclo"] = $ciclo['ciclo']; 
 array_push($boletimDiario, $temp);
 }
 echo json_encode($boletimDiario);
 
 ?>