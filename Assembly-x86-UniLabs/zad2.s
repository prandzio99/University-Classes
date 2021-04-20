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
    xor ebx, ebx
    xor ecx, ecx
    jmp leadingSpaces

leadingSpaces:
    mov bl, [eax]
    cmp bl, 0
    je end
    cmp bl, ' '
    jne wordCounting
    inc eax
    jmp leadingSpaces

wordCounting:
    mov bl, [eax]
    cmp bl, 0
    je incWordCounter
    cmp bl, ' '
    je incWordCounter
    inc eax
    jmp wordCounting

incWordCounter:
    inc ecx
    cmp bl, 0
    je end
    jmp spaceChecker

spaceChecker:
    inc eax
    mov bl, [eax]
    cmp bl, 0
    je end
    cmp bl, ' '
    je spaceChecker
    jmp wordCounting

end:
    mov eax, ecx
    pop ecx
    pop ebx
    ret

.data
messg: .asciz ""
printf_arg1: .asciz "%i\n"

