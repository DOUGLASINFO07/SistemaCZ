<?php

header('Content-Type: Application/JSON charset=utf-8');

$HostName = "mysql:host=sistemacz.mysql.uhserver.com;dbname=sistemacz;charset=utf8";
$HostUser = "sistemacz";
$HostPass = "030182.dtb";

$numeroDenuncia = $_POST["numeroDenuncia"];
$denunciante = $_POST["denunciante"];
$denunciado = $_POST["denunciado"];
$logradouro = $_POST["logradouro"];
$numeroEndereco = $_POST["numeroEndereco"];
$bairro = $_POST["bairro"];
$tipoImovel = $_POST["tipoImovel"];
$tipoDenuncia = $_POST["tipoDenuncia"];
$detalhesDenuncia = $_POST["detalhesDenuncia"];

$response["erro"];

try {
    
    $PDO = new PDO($HostName, $HostUser, $HostPass);
    
   $PDO->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $sql_UpDate = "UPDATE denuncia "
            . "SET denunciante = '$denunciante' "
            . ", denunciado = '$denunciado' "
            . ", logradouro = '$logradouro' "
            . ", numeroEndereco = '$numeroEndereco' "
            . ", bairro = '$bairro' "
            . ", tipoImovel = '$tipoImovel' "
            . ", tipoDenuncia = '$tipoDenuncia' "
            . ", detalhesDenuncia = '$detalhesDenuncia' "
            . "WHERE numeroDenuncia = '$numeroDenuncia' ";

    $stmt = $PDO->prepare($sql_UpDate);

    if ($stmt->execute()) {
        $response["UPDATE"] = "OK";
    } else {
        $response["UPDATE"] = "ERRO";   
    }
    
} catch (PDOException $erro) {
    echo $erro->getMessage(); 
     $response["UPDATE"] = "ERRO"; 
}

echo json_encode($response);
?>