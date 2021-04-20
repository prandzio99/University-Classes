.intel_syntax noprefix
.text
.globl main

main:
    mov eax, offset messg
    push eax
    call policz
    add esp, 4

    push eax
    mov eax, offset printf_arg1
    push eax
    call printf
    add esp, 8

exit:
    mov eax, 0
    ret

policz:
    mov eax, [esp+4]
    push ebx
    push ecx
    push edx
    xor ebx, ebx
    xor ecx, ecx
    xor edx, edx
    jmp policzHelper

policzHelper:
    mov bl, [eax]
    cmp bl, 0
    je end
    mov bh, [eax+1]
    cmp bl, bh
    je countingPhase
    inc eax
    jmp policzHelper

countingPhase:
    mov bl, [eax]
    cmp bl, 0
    je end
    mov bh, [eax+1]
    inc eax
    inc ecx
    cmp bl, bh
    je countingPhase
    jmp coutningPhaseEnd

coutningPhaseEnd:
    cmp ecx, edx
    jg swap
    xor ecx, ecx
    jmp policzHelper

swap:
    mov edx, ecx
    xor ecx, ecx
    jmp policzHelper

end:
    mov eax, edx
    pop edx
    pop ecx
    pop ebx
    ret


.data
messg: .asciz "aaaabc"
printf_arg1: .asciz "%i\n"

