<?php 

header('Content-Type: Application/json; charset=utf-8');

 /*
 * Created by Belal Khan
 * website: www.simplifiedcoding.net 
 * Retrieve Data From MySQL Database in Android
 */
 
 //database constants
 define('DB_HOST', 'sistemacz.mysql.uhserver.com');
 define('DB_USER', 'sistemacz');
 define('DB_PASS', '030182.dtb');
 define('DB_NAME', 'sistemacz');
 
 //connecting to database and getting the connection object
 $mysqli = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
mysqli_set_charset($mysqli,"utf8");
 //Checking if any error occured while connecting
 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: ".mysqli_connect_error();
 die();
 }
 
 //$pesquisa = $_POST['pesquisa'];
 
 //creating a query
 $stmt = $mysqli->prepare("SELECT nomeAtividade 
 FROM atividades 
 WHERE atividades = 'Tratamento Focal' ORDER BY nomeAtividade;");
 
 //executing the query 
 $stmt->execute();
 
 //binding results to the query 
 $stmt->bind_result($nomeAtividade["nomeAtividade"]);
 
 $ciclo = array(); 
 
 
 //traversing through all the result 
 while($stmt->fetch()){
 $temp = array();
 $temp["nomeAtividade"] = $nomeAtividade['nomeAtividade']; 

 array_push($ciclo, $temp);
 }
 
 //displaying the result in json format 
 echo json_encode($ciclo);
 
 ?>