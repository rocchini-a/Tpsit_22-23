<?php

// required headers
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: DELETE");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");


// include database and object files
include_once '../config/db.php';
include_once '../object/gamers.php';

$database = new Db();
$db = $database->getConnection();

// initialize object
$gamer = new Gamer($db);

// set ID property of department to be deleted
$gamer->id = filter_input(INPUT_GET, 'id');

// delete the gamer
if ($gamer->delete()) {
    echo '{';
    echo '"message": "Department was deleted."';
    echo '}';
}

// if unable to delete the gamer
else {
    echo '{';
    echo '"message": "Unable to delete department."';
    echo '}';
}
