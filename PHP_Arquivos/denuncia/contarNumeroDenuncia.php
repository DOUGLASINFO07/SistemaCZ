<?php

header('Content-Type: Application/JSON charset=utf-8');

$host = 'sistemacz.mysql.uhserver.com';
$user = 'sistemacz';
$pass = '030182.dtb';
$bd = 'sistemacz';

 $response["numeroDenuncia"];

$connect = mysqli_connect($host, $user, $pass, $bd);

$connect->set_charset("utf8");

if ($connect->connect_error) {
    
    echo "Erro de Conexao!!";
    
} 

    $sql = "SELECT MAX(numeroDenuncia) AS contagem FROM denuncia; ";
    //$row = mysqli_fetch_array($result, MYSQLI_ASSOC);
    $result = mysqli_query($connect, $sql);
    
    $row = mysqli_fetch_array($result);
    
    $response1 = $row["contagem"];
    
    mysqli_close($conn);

    $response["contagem"] = $response1;
    
echo json_encode($response);

?>