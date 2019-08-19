<?php
    header('Content-Type: application/json charset=utf-8');
    $response = array();
    $response["erro"];
    include "conexaoBD.php";
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
    
   $sql = "SELECT * FROM boletimDiario WHERE ciclo = '$ciclo' "
            . "AND bairro = '$bairro' "
            . "AND logradouro = '$logradouro' "
            . "AND numeroImovel = '$numeroImovel' "
            . "AND sequencia = '%".$sequencia."%' "
            . "AND complemento = '%".$complemento."%' ";
   
    $stmt = $PDO->query($sql);
    $TESTE = 0;
    while ($cadastro1 = $stmt->fetch(PDO::FETCH_OBJ)){		
	$TESTE++;
    }
	$response1 = 0;
	if($TESTE > 0){
		$response1 = 1;
	}else{
            
	$sql_excluir = "DELETE FROM boletimDiario"
                . " WHERE ciclo = '$ciclo' "
            . "AND bairro = '$bairro' "
            . "AND logradouro = '$logradouro' "
            . "AND numeroImovel = '$numeroImovel' "
            . "AND sequencia = '$sequencia' "
            . "AND complemento = '$complemento' ";
        
	$stmt = $PDO->prepare($sql_excluir);
		if($stmt->execute()){
			$response = array("Excluido"=>"OK");
		}else{
			$response = array("Excluido"=>"ERRO");
		}
	}
	$response["erro"] = $response1;
echo json_encode($response);   
?>