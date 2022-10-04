.data
prompt: .asciiz "Enter int to run program"
.text
main:
la $a0, prompt	
addi $v0, $0, 4		# prints the prompt
syscall
addi $v0, $0, 5		# reads an integer
syscall
add $t0, $v0, $0		# stores the int value in t0
addi $sp, $sp, -4
sw $t0, 0($sp)		# stores the int value on the stack as well
jal rec				# jumps to rec, stores return address in ra
addi $sp, $sp, 4	# moves stack pointer back up
addi $v0, $0, 10
syscall				# quit

rec:
la $s0, 0($sp)		# loads value of integer from stack into s0
lw $s0, 0($s0)
bne $s0, 0, helper	# if the value loaded is not 0, then goes to helper
jr $ra 				# returns back to main


helper:
la $a0, 0($sp)
lw $a0, 0($a0)
addi $v0, $0, 1
syscall				# loads int from stack and prints
lw $s2, 0($sp)		# load value to operate on
addi $s2, $s2, -1	# subtracts 1 from the integer in $s2
sw $s2, 0($sp)		# stores the int value back onto the stack
j rec				


