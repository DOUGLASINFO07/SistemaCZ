<?php

header('Content-Type: application/json charset=utf-8');

$HostName = "mysql:host=sistemacz.mysql.uhserver.com;dbname=sistemacz;charset=utf8";
$HostUser = "sistemacz";
$HostPass = "030182.dtb";

try {
    $PDO = new PDO($HostName, $HostUser, $HostPass);
    $PDO->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $numeroDenuncia = $_POST['numeroDenuncia'];

    $sql_excluir = "DELETE FROM denuncia"
            . " WHERE numeroDenuncia = '$numeroDenuncia' ";

    $stmt = $PDO->prepare($sql_excluir);

    if ($stmt->execute()) {
        $response = array("Excluido" => "OK");
    } else {
        $response = array("Excluido" => "ERRO");
    }

} catch (PDOException $erro) {
    echo $erro->getMessage();
}

echo json_encode($response);
?>