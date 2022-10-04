.data
ch: .byte 'a'

.kdata

.ktext 0x80000180	# ISR starting address
lui $t0, 0xFFFF 	# t0 = t0 0xFFFF0000 // control register address
lw $k1, 4($t0)

la $k0, ch
sw $k1, 0($k0)

mtc0 $0, $13		# clear cause register
mfc0 $k0, $12		# load status register
ori $k0, 0x1
mtc0 $k0, $12		# write to status register
eret

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
li $v0, 11
lw $a0, ch

print: 
lui $t2, 0xFFFF
lw $t3, 8($t2)
andi $t3, $t3, 1
beq $t3, $0, print

la $t4, ch
lw $t4, 0($t4)
sw $t4, 12($t2) 

j main


