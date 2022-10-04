#
# ADD these two ascii strings to the .data section.
#

.data
str0:   .asciiz "123"
str1:   .asciiz "456"
allocatedSpaceTask1: .space 128
allocatedSpaceTaks2: .space 128
flag: .space 4

#----------------------------------------------------
# here are my task0 and task1
# You can test them separately first.
# this prog includes multiply example.
# do not insert jal ts between mult and mflo.
#----------------------------------------------------
.text
main:

  # Here you initialize the TCBs and 
  # tid (task # currently running)

	 j task0



task0:
        addi $t7, $0, 100
task0body:		
        add  $t0, $0, $0
	jal ts     
        addi $t1, $0, 10     
        la   $s0, str0       
	jal ts
beg0:
        lb   $t2, ($s0)     
        beq  $t2, $0, quit0 
        sub  $t2, $t2, '0'  
        mult $t0, $t1       
        mflo $t0
        add  $t0, $t0, $t2  
	jal ts
        add  $s0, $s0, 1    
        b    beg0
quit0:
	jal ts
	add  $v1, $0, $t0
	add  $s0, $0, $v1
	add  $a1, $0, $s0 
	jal ts
	add  $t5, $0, $a1
	add  $t6, $0, $t5
	addi $s0, $0, 1
	add  $v0, $0, $s0
	add  $a0, $0, $t6
	jal ts
	syscall
    addi $t7, $t7, -1
	beq $t7, $0, donedone
        
    j task0body


task1:
		
        addi $t7, $0, 100
task1body:		
        add  $t0, $0, $0    
        addi $t1, $0, 10    
        la   $s0, str1      
beg1:
        lb   $t2, ($s0)      
        beq  $t2, $0, quit1 
	jal ts
        sub  $t2, $t2, '0'  
        mult $t0, $t1       
        mflo $t0
        add  $t0, $t0, $t2   
        add  $s0, $s0, 1     
        b    beg1
quit1:
	add  $v1, $0, $t0
	add  $s0, $0, $v1
	jal ts
	add  $a1, $0, $s0 
	add  $t5, $0, $a1
	jal ts
	add  $t6, $0, $t5
	jal ts
	addi $s0, $0, 1
	add  $v0, $0, $s0
	jal ts
	add  $a0, $0, $t6
	jal ts
	syscall
	addi $t7, $t7, -1
	beq $t7, $0, donedone
        j task1body

		
donedone: addi $v0, $0, 10
		syscall


#---------------------------------------------------
#   Write your Task Switch Routine here
#---------------------------------------------------

ts:
 
 
   jr $ra