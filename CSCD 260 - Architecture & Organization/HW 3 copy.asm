.data
.align 2
array: .word 3, 5, 21, 7, 3, 4, 5, 8
n_elem: .word 8 	# number of elements in array, limit in for-loop

.text 
main: 
 
la $t1, n_elem 		# loading address of n_elem => $t1 
lw $t1, 0($t1)  	# loading contents of n_elem, array length: (8) => t1 
 
addi $s0, $0, 0		# counter for for-loop => s0 
addi $t0, $0, 0 	# starting spot in for-loop => t0 
 
la $t2, array		# loads starting address of array => t2 
 
forLoop: 
lw $t3, 0($t2)		# loading element from the array => t3 
addi $sp, $sp, -4	# moving stack pointer -4 
sw $t3, 0($sp)		# stores the value of t3 (array element) onto the stack 
jal func		# jumps to func, links back to here in $ra 
addi $sp, $sp, 4	# moves stack pointer back to original spot 
addi $t2, $t2, 4	# moves pointer in array to next element 
addi $s0, $s0, 1	# increments for-loop counter by 1 
bne $s0, $t1, forLoop	# compares counter to array limit in t1 
 
addi $v0, $0, 10	# end main 
syscall 

func: 
lw $t5, 0($sp)		# integer from stack storing in => t5
addi $sp, $sp, -4	# moves the stack pointer -4 
sw $ra, 0($sp)		# stores address in $ra onto the stack 
andi $t4, $t5, 1	# anding integer with 1 and storing in => t4
bne $t4, $0, odd	# comparing t4 to 0, if odd will go to odd
lw $ra, 0($sp)		# moves return address in stack back to $ra
addi $sp, $sp, 4	# moves the stack pointer back up 4 
jr $ra

odd:
la $t6, 0($sp)
lw $t6, 0($t6)
addi $sp, $sp, -4 	# Sp-4
sw $ra, 0($sp)
addi $sp, $sp, -4 	# Sp-4
sw $t5, 0($sp)
jal print		# jumps to print, stores return in $ra
addi $sp, $sp, 4	# moves the stack pointer back up 4		 
lw $ra, 0($sp)		# moves return address in stack back to $ra
addi $sp, $sp, 4	# moves the stack pointer back up 4 
jr $ra			# returns back to last jal 
 
print: 
lw $a0, 0($sp)		# loads integer at stack pointer => a0  
addi $v0, $0, 1		# chooses the syscall 
syscall			# prints int 
addi $a0, $0, 0x0D 	# ascii 0x0D = carriage return
addi $v0, $0, 11		
syscall
jr $ra			# returns back to address in $ra 
 
 