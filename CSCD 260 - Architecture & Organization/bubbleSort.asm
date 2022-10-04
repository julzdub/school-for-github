.data
.align 2	#align n --> next allocation starts at 2^n boundary
array: .word -9, -2, 3, 8, 5, 0, 0, 0, 1, 1, 90, 99, 99, 99, -1, -1, -1, 87, 78, 12
n_element: .word 20

.text
# main()
main:
addi $s0, $0, 1 # Flag for sorted

la $a2, n_element
lw $a2, 0($a2) # a2 <= n_element
add $t9, $0, $0 # t9 : counter
la $a1, array # a1 = &array[0]
addi $a2, $a2, -1 # because we do [i+1]

top:
lw $t7,0($a1) # t7 = array[i]
lw $t8,4($a1) # t8 = array[i+1]
bgtu $t7, $t8, swap # doing comparison of t7 and t8 (swap)
midTop:


addi $a1, $a1, 4 # next array offset
addi $t9, $t9, 1 # counter++

beq $t9, $a2, check
j top

swap:
sw $t8, 0($a1) # puts the bigger value in the smaller value spot
sw $t7, 4($a1)	# puts the smaller value in the bigger value spot (further down list)
addi $s0, $0, 0
j midTop

check:
beq $s0, 1, print
add $t9, $0, $0 # t9 : counter
la $a1, array # a1 = &array[0]
addi $s0, $0, 1
j top

print:
add $t9, $0, $0 # t9 : counter
la $a1, array # a1 = &array[0]
addi $a2, $a2, 1

printLoop:
lw $t7,0($a1) # t7 = array[i]
add $a0, $t7, 0
addi $v0, $0, 1
syscall
addi $a0, $0, 0x0D # ascii 0x0D = CR
addi $v0, $0, 11
syscall
addi $a1, $a1, 4 # next array offset
addi $t9, $t9, 1 # counter++
beq $t9, $a2, quit
j printLoop


quit:
addi $v0, $0, 10
syscall

