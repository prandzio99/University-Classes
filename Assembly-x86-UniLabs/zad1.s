.intel_syntax noprefix
.text
.globl main

main:
    mov eax, offset messg
    push eax
    call znajdz
    add esp, 4

    push eax
    mov eax, offset printf_arg1
    push eax
    call printf
    add esp, 8

exit:
    mov eax, 0
    ret

znajdz:
    mov eax, [esp+4]
    push ebx
    push ecx
    xor ebx, ebx
    xor ecx, ecx
    jmp znajdzHelper

znajdzHelper:
    mov bl, [eax]
    inc eax
    cmp bl, 0
    je endZnajdzNotFound
    inc ecx
    cmp bl, '*' 
    je endZnajdzFound
    jmp znajdzHelper

endZnajdzNotFound:
    mov eax, -1
    pop ecx
    pop ebx
    ret

endZnajdzFound:
    sub ecx, 1
    mov eax, ecx
    pop ecx
    pop ebx
    ret

.data
messg: .asciz "asd*asd*asd"
printf_arg1: .asciz "%i\n"

