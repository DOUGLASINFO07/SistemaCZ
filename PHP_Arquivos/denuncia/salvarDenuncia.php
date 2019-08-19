<?php

header('Content-Type: Application/JSON charset=utf-8');

$host = 'sistemacz.mysql.uhserver.com';
$user = 'sistemacz';
$pass = '030182.dtb';
$bd = 'sistemacz';

    $connect = mysqli_connect($host, $user, $pass, $bd);
    $connect->set_charset("utf8");

    if (!$connect) {
        die("Connection failed: " . mysqli_connect_error());
    } 
    else {
        $numeroDenuncia = $_POST['numeroDenuncia'];
        $data = $_POST['data'];
        $recebidaPor = $_POST['recebidaPor'];
        $denunciante = $_POST['denunciante'];
        $denunciado = $_POST['denunciado'];
        $logradouro = $_POST['logradouro'];
        $numeroEndereco = $_POST['numeroEndereco'];
        $bairro = $_POST['bairro'];
        $tipoImovel = $_POST['tipoImovel'];
        $tipoDenuncia = $_POST['tipoDenuncia'];
        $detalhesDenuncia = $_POST['detalhesDenuncia'];

//        $sql = "SELECT * FROM denuncia WHERE numeroDenuncia = '$numeroDenuncia' ";
//        $result = mysqli_query($connect, $sql);

        $TESTE = 0;
        while ($boletimdiario = mysqli_fetch_object($result)) {
            $TESTE++;
        }

        $response4 = 2;
        if ($TESTE > 0) {
            $response4 = 1;
        } else {

        $query_teste = "INSERT INTO denuncia(
        numeroDenuncia,
        dataDenuncia,
        recebidaPor,
        denunciante,
	denunciado,
	logradouro,
	numeroEndereco,
	bairro,
	tipoImovel,
	tipoDenuncia,
	detalhesDenuncia,
        ace1, 
        ace2,
        situacaoVisita, 
        dataVisita, 
        detalhesVisita) VALUES (
        '" . $numeroDenuncia . "',
	'" . $data . "',
	'" . $recebidaPor . "',
	'" . $denunciante . "',
	'" . $denunciado . "',
	'" . $logradouro . "',
	'" . $numeroEndereco . "',
	'" . $bairro . "',
	'" . $tipoImovel . "',
	'" . $tipoDenuncia . "',
	'" . $detalhesDenuncia . "',
	'',
	'',
	'',
	'000-00-00',
	'')";
          
            if (mysqli_query($connect, $query_teste)) {
                $response["Cadastrou? "] = "Sucesso!!";
            } else {
                $response["Cadastrou? "] = "Falha!!";
            }
            
            mysqli_close($connect);
        }
    }
    echo $response4;
    $response["teste"] = $response4;

    echo json_encode($response);

    

?>