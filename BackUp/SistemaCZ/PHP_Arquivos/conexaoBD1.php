<?php

    define('hostname', 'sistemacz.mysql.uhserver.com');
    define('user',  'sistemacz');
    define('password',  '030182.dtb');
	define('dataBaseName', 'sistemacz');

	$connect = new mysqli_connect(hostname, user, password, databaseName);

?>