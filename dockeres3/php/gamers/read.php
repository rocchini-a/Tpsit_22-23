<?php

// required headers
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

// include database and object files
include_once '../config/db.php';
include_once '../object/gamers.php';

// instantiate database and department object
$database = new Db();
$db = $database->getConnection();

// initialize object
$gamer = new Gamer($db);

// query department
$stmt = $gamer->read();
$num = $stmt->rowCount();

// check if more than 0 record found
if ($num > 0) {
    // department array
    $gamer_arr = array();
    $gamer_arr["records"] = array();

    // retrieve table contents
    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
        // extract row
        extract($row);
        $gamer_item = array(
            "id" => $row['dept_id'],
            "name" => $row['dept_name']
        );
        array_push($gamer_arr["records"], $gamer_item);
    }
    echo json_encode($gamer_arr);
} else {
    echo json_encode(
            array("message" => "No products found.")
    );
}
