<?php
  $status = $_GET["status"];
  $output = exec('vcgencmd measure_temp');

  if ($status == "checktemp"){
     print "<h2>$output</h2>";
	}

  
  if ($status == "reboot"){
     exec("python /var/www/y.py");
     print '<h2>Rebooting</h2>';
	}

  if ($status == "restart"){
     exec("sudo shutdown -r now");
     print '<h2>Restarting...done!</h2>';
	}

  if ($status == "shutdown"){
     exec("sudo shutdown -h now");
     print '<h2>Shutting down...done!</h2>';
	}
  
  if ($status == "stopcam"){
     exec("sudo service motion stop");
     print '<h2>Camera Stopped, you can go back now.</h2>';
	}

  if ($status == "startcam"){
     exec("sudo service motion start");
     print '<h2>Camera Started, you can go back now.</h2>';
	}
	
	

?>