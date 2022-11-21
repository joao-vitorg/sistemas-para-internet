<?php
    $user = $_POST['user'];
    $pwd = $_POST['pwd'];
    $record = array('user' => $user, 'pwd' => $pwd);

    $filename = '../json/users.json';
    $registros = json_decode(file_get_contents($filename), true);
    array_push($registros, $record);
    file_put_contents($filename, json_encode($registros));
    header('Location: ../sucess.html');
?>
