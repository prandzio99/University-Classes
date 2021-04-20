.intel_syntax noprefix
.text
.globl main

main:
    mov eax, offset wynik
    push eax
    mov eax, offset argument
    push eax
    call rozszerz

    push eax
    mov eax, offset printf_arg1
    push eax
    call printf
    add esp, 8

exit:
    mov eax, 0
    ret

rozszerz:
    push ebx
    push ecx
    push edx
    mov eax, [esp+16]
    mov ebx, [esp+20]
    xor ecx, ecx
    xor edx, edx
    jmp rozszerzHelper

rozszerzHelper:
    mov cl, [eax]
    mov ch, ' '
    cmp cl, 0
    je end
    mov [ebx], cl
    mov [ebx+1], ch
    inc ebx
    inc ebx 
    inc eax
    inc edx
    jmp rozszerzHelper

end:
    mov [ebx-1], dword ptr 0
    mov eax, offset wynik
    pop edx
    pop ecx
    pop ebx
    ret 8

.data
argument: .asciz "policja nam dokucza"
wynik: .asciz "                                                    "
printf_arg1: .asciz ">>%s<<\n"

