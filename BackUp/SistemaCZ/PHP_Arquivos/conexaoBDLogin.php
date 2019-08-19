<?php
$ambiente = false;

if ($ambiente) { // Ambiente de Produção

 $HostName = "";
    $HostUser = "";
    $HostPass = "";
    $DatabaseName = "";   

} else { // Ambiente de Desenvolvimento

    $HostName = "sistemacz.mysql.uhserver.com";
    $HostUser = "sistemacz";
    $HostPass = "030182.dtb";
    $DatabaseName = "sistemacz";  
    
}
?>