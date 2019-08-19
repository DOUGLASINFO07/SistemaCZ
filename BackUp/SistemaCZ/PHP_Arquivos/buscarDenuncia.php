<?php

header('Content-Type: Application/JSON charset=utf-8');
$host = 'sistemacz.mysql.uhserver.com';
$user = 'sistemacz';
$pass = '030182.dtb';
$bd = 'sistemacz';

        $response1;
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
        $response12;
        $response13;
        $response14;
        $response15;
        $response16;
        $response17;
        $response18;
        $response19;
        $response20;
        $response21;

try {
    $connect = mysqli_connect($host, $user, $pass, $bd);
    $connect->set_charset("utf8");
    if ($connect->connect_error) {
        echo "Erro de Conexao!!";
    } else {

        $ciclo = $_POST["ciclo"];
        $bairro = $_POST["bairro"];
        $logradouro = $_POST["logradouro"];
        $numeroImovel = $_POST["numeroImovel"];
        $sequencia = $_POST["sequencia"];
        $complemento = $_POST["complemento"];
        
        $sql = "SELECT * FROM boletimDiario " 
                . "WHERE ciclo = '$ciclo' "
                . "AND bairro = '$bairro' "
                . "AND logradouro = '$logradouro' "
                . "AND numeroImovel = '$numeroImovel' "
                . "AND sequencia LIKE '$sequencia' "
                . "AND complemento LIKE '$complemento' ";

        //$row = mysqli_fetch_array($result, MYSQLI_ASSOC);
         $result = mysqli_query($connect, $sql);
$row = mysqli_fetch_assoc($result);
        $response1 = $row["ace"];
        $response2 = $row["data"];
        $response3 = $row["hora"];
        $response4 = $row["ciclo"];
        $response5 = $row["semana"];
        $response6 = $row["bairro"];
        $response7 = $row["numeroQuarteirao"];
        $response8 = $row["ladoQuarteirao"];
        $response9 = $row["logradouro"];
        $response10 = $row["numeroImovel"];
        $response11 = $row["sequencia"];
        $response12 = $row["complemento"];
        $response13 = $row["tipoImovel"];
        $response14 = $row["tipoVisita"];
        $response15 = $row["depositoEliminado"];
        $response17 = $row["tipoLarvicida"];
        $response18 = $row["quantidadeLarvicida"];
        $response19 = $row["depositoTratado"];
        $response20 = $row["observacao"];
        $response21 = $row["terminoQuarteirao"];

    }
} catch (PDOException $erro) {
    echo $erro->getMessage();
}
$response["ace"] = $response1;
$response["data"] = $response2;
$response["hora"] = $response3;
$response["ciclo"] = $response4;
$response["semana"] = $response5;
$response["bairro"] = $response6;
$response["numeroQuarteirao"] = $response7;
$response["ladoQuarteirao"] = $response8;
$response["logradouro"] = $response9;
$response["numeroImovel"] = $response10;
$response["sequencia"] = $response11;
$response["complemento"] = $response12;
$response["tipoImovel"] = $response13;
$response["tipoVisita"] = $response14;
$response["depositoEliminado"] = $response15;
$response["tipoLarvicida"] = $response17;
$response["quantidadeLarvicida"] = $response18;
$response["depositoTratado"] = $response19;
$response["observacao"] = $response20;
$response["terminoQuarteirao"] = $response21;

echo json_encode($response);
?>