<?php

header('Content-Type: Application/JSON charset=utf-8');
//$response["erro"] = 0;

$HostName = "mysql:host=sistemacz.mysql.uhserver.com;dbname=sistemacz;charset=utf8";
$HostUser = "sistemacz";
$HostPass = "030182.dtb";

$PDO = new PDO($HostName, $HostUser, $HostPass);

$PDO->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

$ace = $_POST['ace'];
$data = $_POST["data"];
$hora = $_POST["hora"];
$ciclo = $_POST["ciclo"];
$semana = $_POST["semana"];
$bairro = $_POST["bairro"];
$numeroQuarteirao = $_POST["numeroQuarteirao"];
$ladoQuarteirao = $_POST["ladoQuarteirao"];
$logradouro = $_POST["logradouro"];
$numeroImovel = $_POST["numeroImovel"];
$sequencia = $_POST["sequencia"];
$complemento = $_POST["complemento"];
$tipoImovel = $_POST["tipoImovel"];
$tipoVisita = $_POST["tipoVisita"];
$depositoEliminado = $_POST["depositoEliminado"];
$tipoLarvicida = $_POST["tipoLarvicida"];
$quantidadeLarvicida = $_POST["quantidadeLarvicida"];
$depositoTratado = $_POST["depositoTratado"];
$observacao = $_POST["observacao"];
$terminoQuarteirao = $_POST["terminoQuarteirao"];

$sql = "SELECT * FROM boletimDiario "
        . "WHERE ace = '$ace' "
        . "AND data = '$data' "
        . "AND hora = '$hora' "
        . "AND ciclo = '$ciclo' "
        . "AND semana = '$semana' "
        . "AND bairro = '$bairro' "
        . "AND numeroQuarteirao = '$numeroQuarteirao' "
        . "AND ladoQuarteirao = '$ladoQuarteirao' "
        . "AND logradouro = '$logradouro' "
        . "AND numeroImovel = '$numeroImovel' "
        . "AND sequencia = '$sequencia' "
        . "AND complemento = '$complemento' "
        . "AND tipoImovel = '$tipoImovel' "
        . "AND tipoVisita = '$tipoVisita' "
        . "AND depositoEliminado = '$depositoEliminado' "
        . "AND tipolarvicida = '$tipoLarvicida' "
        . "AND quantidadeLarvicida = '$quantidadeLarvicida' "
        . "AND depositoTratado = '$depositoTratado' "
        . "AND observacao = '$observacao' "
        . "AND terminoQuarteirao = '$terminoQuarteirao' ";
$stmt = $PDO->query($sql);
$TESTE = 0;

while ($boletimDiario = $stmt->fetch(PDO::FETCH_OBJ)) {
    $TESTE++;
}
$response1 = 0;
if ($TESTE > 0) {
    $response = 1;
} else {
    $sql_UpDate = "UPDATE boletimDiario "
            . "SET  tipoVisita = '$tipoVisita' "
            . ", ladoQuarteirao = '$ladoQuarteirao' "
            . ", depositoEliminado = '$depositoEliminado' "
            . ", tipoLarvicida = '$tipoLarvicida' "
            . ", quantidadeLarvicida = '$quantidadeLarvicida' "
            . ", depositoTratado = '$depositoTratado' "
            . ", observacao = '$observacao' "
            . ", terminoQuarteirao = '$terminoQuarteirao' "
            . "WHERE bairro = '$bairro' "
            . "AND ciclo = '$ciclo' "
            . "AND numeroQuarteirao = '$numeroQuarteirao' "
            . "AND logradouro = '$logradouro' "
            . "AND numeroImovel = '$numeroImovel' "
            . "AND sequencia = '$sequencia' "
            . "AND complemento = '$complemento' "
            . "AND tipoImovel = '$tipoImovel' ";

    $stmt = $PDO->prepare($sql_UpDate);
    if ($stmt->execute()) {
        $response = array("UPDATE" => "OK");
    } else {
        $response = array("UPDATE" => "ERRO");
    }
}
$response["erro"] = $response1;
echo json_encode($response);
?>