<?php
header('Content-Type: Application/html charset=utf-8');

$response = array();
$response["erro"];

$HostName = "mysql:host=sistemacz.mysql.uhserver.com;dbname=sistemacz;charset=utf8";
    $HostUser = "sistemacz";
    $HostPass = "030182.dtb";
     
	
	try{
		$PDO = new PDO($HostName,$HostUser,$HostPass);
		echo"<h1>Conectado com sucesso</h1>";
	}
	catch(PDOException $erro){
		echo $erro->getMessage();
	}

    //include "conexaoBD.php";
	
	$ace = $_POST['ace'];//login do android studio
	$data = $_POST['data'];// senha do android studio
	$hora = $_POST['hora'];//login do android studio
	$ciclo = $_POST['ciclo'];// senha do android studio
	$semana = $_POST['semana'];//login do android studio
	$bairro = $_POST['bairro'];
	$numeroQuarteirao = $_POST['numeroQuarteirao'];// senha do android studio
	$ladoQuarteirao = $_POST['ladoQuarteirao'];//login do android studio
	$logradouro = $_POST['logradouro'];// senha do android studio
	$numeroImovel = $_POST['numeroImovel'];//login do android studio
	$sequencia = $_POST['sequencia'];// senha do android studio
	$complemento = $_POST['complemento'];//login do android studio
	$tipoImovel = $_POST['tipoImovel'];// senha do android studio
	$tipoVisita = $_POST['tipoVisita'];//login do android studio
	$depositoEliminado = $_POST['depositoEliminado'];// senha do android studio
	$quantidadeLarvicida = $_POST['quantidadelarvicida'];// senha do android studio
	$depositoTratado = $_POST['depositoTratado'];//login do android studio
	$observacao = $_POST['observacao'];// senha do android studio
	$terminoQuarteirao = $_POST['terminoQuarteriao'];//login do android studio
	
	//$sql = "SELECT * FROM boletimdiario WHERE data = '$data' AND ace = '$ace' ";
   // $dados = $PDO->query($sql);
	
	//$TESTE = 0;
    //while ($boletimdiario == $dados->fetch(PDO::FETCH_OBJ)){		
	//$response4 = 1;
	//$TESTE++;
	//}
	
	//$resultado1 = 0;
	//if($TESTE > 0){
	//	$response1 = 1;
	//	$response4 = 1;
	//}else{
	
	$sql_insert = "INSERT INTO boletimdiario(null,
	ace,
	data,
	hora,
	ciclo,
	semana,
	bairro,
	numero_quarteirao,
	lado_quarteirao,
	logradouro,
	numero_imovel,
	sequencia,
	complemento,
	tipo_imovel,
	tipo_visita,
	deposito_eliminado,
		quantidade_larvicida,
	deposito_tratado,
	observacao,
	termino_quarteirao
	) VALUES (:NULL,
	:ACE,
	:DATA,
	:HORA, 
	:CICLO,
	:SEMANA, 
	:BAIRRO,
	:NUMEROQUARTEIRAO, 
	:LADOQUARTEIRAO, 
	:LOGRADOURO,
	:NUMEROIMOVEL, 
	:SEQUENCIA, 
	:COMPLEMENTO, 
	:TIPOIMOVEL,
	:TIPOVISITA, 
	:DEPOSITOELIMINADO, 
		:QUANTIDADELARVICIDA,
	:DEPOSITOTRATADO, 
	:OBSERVACAO, 
	:TERMINOQUARTEIRAO
	)";
	
	$stmt = $PDO->prepare($sql_insert);

	$stmt->bindParam(':ACE',$ace);
	$stmt->bindParam(':DATA',$data);
	$stmt->bindParam(':HORA',$hora);
	$stmt->bindParam(':CICLO',$ciclo);
	$stmt->bindParam(':SEMANA',$semana);
	$stmt->bindParam(':BAIRRO',$bairro);
	$stmt->bindParam(':NUMEROQUARTEIRAO',$numeroQuarteirao);
	$stmt->bindParam(':LADOQUARTEIRAO',$ladoQuarteirao) ;
	$stmt->bindParam(':LOGRADOURO',$logradouro);
	$stmt->bindParam(':NUMEROIMOVEL',$numeroImovel);
	$stmt->bindParam(':SEQUENCIA',$sequencia);
	$stmt->bindParam(':COMPLEMENTO',$complemento); 
	$stmt->bindParam(':TIPOIMOVEL',$tipoImovel);
	$stmt->bindParam(':TIPOVISITA',$tipoVisita);
	$stmt->bindParam(':DEPOSITOELIMINADO',$depositoEliminado);
		$stmt->bindParam(':QUANTIDADELARVICIDA',$quantidadeLarvicida);
	$stmt->bindParam(':DEPOSITOTRATADO',$depositoTratado);
	$stmt->bindParam(':OBSERVACAO',$observacao);
	$stmt->bindParam(':TERMINOQUARTEIRAO',$terminoQuarteirao);	

	 
		if($stmt->execute()){
			$response = array("CREATE"=>"OK");
		}else{
			$response = array("CREATE"=>"ERRO");
		}
	//}
	//$response["teste"] = $response1;
	//$response["erro"] = $response4;

echo json_encode($response);  
?>