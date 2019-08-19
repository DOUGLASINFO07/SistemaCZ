<?php

    $HostName = "mysql:host=sistemacz.mysql.uhserver.com;dbname=sistemacz;charset=utf8";
    $HostUser = "sistemacz";
    $HostPass = "030182.dtb";

	try{
		$PDO = new PDO($HostName,$HostUser,$HostPass);
		
	}
	catch(PDOException $erro){
		echo $erro->getMessage();
	}
    

?>