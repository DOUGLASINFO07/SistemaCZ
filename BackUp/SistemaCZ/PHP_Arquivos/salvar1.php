<?php

header('Content-Type: Application/JSON charset=utf-8');
$host = 'sistemacz.mysql.uhserver.com';
$user = 'sistemacz';
$pass = '030182.dtb';
$bd = 'sistemacz';
try {
    $connect = mysqli_connect($host, $user, $pass, $bd);
    $connect->set_charset("utf8");
    if ($connect->connect_error) {
        echo "Erro de Conexao!!";
    } else {
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
        $terminoQuarteirao = $_POST["terminoQuarteriao"];
        $sql = "SELECT * FROM boletimDiario WHERE ciclo = '$ciclo' "
                . "AND bairro = '$bairro' "
                . "AND logradouro = '$logradouro' "
                . "AND numeroImovel = '$numeroImovel' "
                . "AND sequencia = '$sequencia' "
                . "AND complemento = '$complemento' ";
        $result = mysqli_query($connect, $sql);
        $TESTE = 0;
        while ($boletimdiario = mysqli_fetch_assoc($result)) {
            $TESTE++;
        }
        $response4 = 0;
        if ($TESTE > 0) {
            $response4 = 1;
        } else {
            $query = "INSERT INTO boletimDiario(
	ace,
	data,
	hora,
	ciclo,
	semana,
	bairro,
	numeroQuarteirao,
	ladoQuarteirao,
	logradouro,
	numeroImovel,
	sequencia,
	complemento,
	tipoImovel,
	tipoVisita,
	depositoEliminado,
        tipoLarvicida,
	quantidadeLarvicida,
	depositoTratado,
	observacao,
	terminoQuarteirao
	) VALUES (
	'" . $ace . "',
	'" . $data . "',
	'" . $hora . "',
	'" . $ciclo . "',
	'" . $semana . "',
	'" . $bairro . "',
	'" . $numeroQuarteirao . "',
	'" . $ladoQuarteirao . "',
	'" . $logradouro . "',
	'" . $numeroImovel . "',
	'" . $sequencia . "',
	'" . $complemento . "',
	'" . $tipoImovel . "',
	'" . $tipoVisita . "',
	'" . $depositoEliminado . "',
            '" . $tipoLarvicida . "',
	'" . $quantidadeLarvicida . "',
	'" . $depositoTratado . "',
	'" . $observacao . "',
	'" . $terminoQuarteirao . "'
	)";
            if (mysqli_query($connect, $query)) {
                // echo "Sucesso!!";
            } else {
                // echo "Falha!!";
            }
            mysqli_close($connect);
        }
    }
} catch (PDOException $erro) {
    echo $erro->getMessage();
}
$response["erro"] = $response4;
echo json_encode($response);
?>