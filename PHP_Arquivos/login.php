<?php

header('Content-Type: Application/JSON; charset=utf-8');

$response = array();
$response["erro"] = true;

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $HostName = "sistemacz.mysql.uhserver.com";
    $HostUser = "sistemacz";
    $HostPass = "030182.dtb";
    $DatabaseName = "sistemacz";

    $conn = new mysqli($HostName, $HostUser, $HostPass, $DatabaseName);
    mysqli_set_charset($conn, "utf8");

    if ($conn->connect_error) { // Será que é uma boa?
        die("Ops, falhou....: " . $conn->connect_error);
    }

    $login = $_POST['login']; //login do android studio
    $senha = $_POST['senha']; // senha do android studio
    $sql = "SELECT * FROM usuario WHERE login = '$login' AND senha = '$senha' "; //WHERE login LIKE $login AND senha LIKE $senha";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $registro = mysqli_fetch_array($result);
        $response["registros"] = $result->num_rows;
        $response["erro"] = false;
        $response["login"] = $registro['login'];
        $response["senha"] = $registro['senha'];
        $response["perfil"] = $registro['fk_id_perfil'];
        $response["datainc"] = $registro['datainc'];
    } else {
        $response["mensagem"] = "Usuario não Existe";
    }

    $conn->close();
}
echo json_encode($response);
?>