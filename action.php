<?php
require('vendor/autoload.php');
$con = mysqli_connect('localhost', 'root', '', 'fwmsdb');
$res=mysqli_query($con, "select * from tblfood");

if (mysqli_num_rows($res) > 0){
    $html='<style> </style><table class="table">';
        $html.='<tr>
                  <td> ID </td> 
                  <td> FoodItems </td>
                  <td> StateName </td>
                  <td> CityName  </td>
                  <td> Description </td>
                  <td> PickupDate </td>
                  <td> PickupAddress </td>
                  <td> ContactPerson </td>
                  <td> CPMobNumber </td>
                  <td> CreationDate </td>
                </tr>';
                while($row=mysqli_fetch_assoc($res)){
                  $html.='<tr>
                  <td> '.$row['ID'].' </td> 
                  <td> '.$row['FoodItems'].' </td>
                  <td> '.$row['StateName'].' </td>
                  <td> '.$row['CityName'].'  </td>
                  <td> '.$row['Description'].' </td>
                  <td> '.$row['PickupDate'].' </td>
                  <td> '.$row['PickupAddress'].' </td>
                  <td> '.$row['ContactPerson'].' </td>
                  <td> '.$row['CPMobNumber'].' </td>
                  <td> '.$row['CreationDate'].' </td>
                </tr>';
                }
    $html.='</table>';
   
}else{
    $html="Data not found";
}

$mpdf=new \Mpdf\Mpdf();
$mpdf->WriteHTML($html);
$file=time().'.pdf';
$mpdf->output($file, 'D');

?>