<?php

header('Content-Type: Application/JSON charset=utf-8');
$host = 'sistemacz.mysql.uhserver.com';
$user = 'sistemacz';
$pass = '030182.dtb';
$bd = 'sistemacz';

$response1;
$numeroDenuncia;
$response2;
$response3;
$response4;
$response5;
$response6;
$response7;
$response8;
$response9;
$response10;
$response11;

try {
    $connect = mysqli_connect($host, $user, $pass, $bd);
    $connect->set_charset("utf8");
    if ($connect->connect_error) {
        echo "Erro de Conexao!!";
    } else {

        $numeroDenuncia = $_POST["numeroDenuncia"];

        $sql = "SELECT * FROM denuncia "
                . "WHERE numeroDenuncia = '$numeroDenuncia' ";

        $row = mysqli_fetch_array($result, MYSQLI_ASSOC);
        $result = mysqli_query($connect, $sql);
        $row = mysqli_fetch_assoc($result);
        
       $response1 = $row["numeroDenuncia"];
        $response11 = $row["dataDenuncia"];
        $response2 = $row["recebidaPor"];
        $response3 = $row["denunciante"];
        $response4 = $row["denunciado"];
        $response5 = $row["logradouro"];
        $response6 = $row["numeroEndereco"];
        $response7 = $row["bairro"];
        $response8 = $row["tipoImovel"];
        $response9 = $row["tipoDenuncia"];
        $response10 = $row["detalhesDenuncia"];
        
    }
} catch (PDOException $erro) {
    echo $erro->getMessage();
}

$response["numeroDenuncia"] = $response1;
$response["dataDenuncia"] = $response11;
$response["recebidaPor"] = $response2;
$response["denunciante"] = $response3;
$response["denunciado"] = $response4;
$response["logradouro"] = $response5;
$response["numeroEndereco"] = $response6;
$response["bairro"] = $response7;
$response["tipoImovel"] = $response8;
$response["tipoDenuncia"] = $response9;
$response["detalhesDenuncia"] = $response10;

echo json_encode($response);
?>