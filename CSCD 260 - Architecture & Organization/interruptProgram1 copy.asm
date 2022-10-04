mfc0 $a0, $12		
lui $t0, 0xFFFF
ori $t0, $t0, 0xFFFE
and $t0, $a0, $t0
mtc0 $t0, $12		# stauts register bit-0 set 0 without disturbing other bits

lui $t0, 0xFFFF		# t0 = 0xFFFF0000 // control register address
addi $t1, $0, 2		# t1 = 0000 ... ... 0010
sw $t1, 0($t0)		# Receiver (keyboard) control = 0000...0010
					# now interrupt enable bit is enabled (can raise interrupt request)

mfc0 $a0, $13
addi $t0, $0, 0x7C
and $t0, $a0, $t0
and $t0, $a0, $t0

# should be able to read the exception code at this point


srl $t0, $t0, 2		# t0 = t0 => 2
					# t0 = 0000 0000 0000 0000 0000 0000 000x xxxx

mfc0 $a0, $13		# a0 = xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx
addi $t0, $a0, 0x0800 # t0 = 0000 0000 0000 00000 1000 0000 0000
and $t0, $a0, $t0 	# t0 = 0000 0000 0000 0000 0000 x000 0000 0000

mtc0 $0, $13
mfc0 $k0, $12		# read status register
andi $k0, 0xfffd 	# 1111 1111 1111 1101 //bit1 reset
ori $k0, 0x1 		# enable interrupt
mtc0 $k0, $12
eret

.kdata

.ktext 0x80000180	# ISR starting address

die: j die 			# dying

.text
.globl __start
.globl main

__start:
lui $t0, 0xFFFF 	# t0 = t0 0xFFFF0000 // control register address
addi $t1, $0, 2		# t1 = 0000 ... ... 0010
sw $t1, 0($t0) 		# Reciever (keyboard) control = 0000 ... 0010

mfc0 $t0, $12		# read 0x3000ff10
ori $t0, $t0, 0x0001 	# turn ON interrupt enable bit
mtc0 $t0, $12		# write it to the status register
j main				# start main


main: 
# user code
done: 
nop
nop 
j done


