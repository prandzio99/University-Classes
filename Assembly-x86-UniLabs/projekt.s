
.intel_syntax noprefix
.text
    .global _start
    _start:
    
    # [abq][ˆabc] + c
    # edx - iterator po wyrazie i koniec wyrazenia po znalezieniu konca
    # ecx - poczatek znalezionego wyrażenia regularnego
    # al  - litera znajdująca się pod adresem wskazywanym przez ecx
    
    
    mov eax, [esp];         # sprawdzenie poprawności ilości argumentów
    cmp eax, 2;
    jl bad_call;

    mov edx, [esp + 8];     # wyraz do edx
    mov al, [edx];          # pierwsza litera do al

    look_for_first:
        cmp al, 'a';            # szukanie pierwszej pasującej litery a/b/q
        je got_first;
        cmp al, 'b';
        je got_first;
        cmp al, 'q';
        je got_first;           # jeśli znajdzie to przechodzi dalej
        inc edx;                # jeśli nie to przesuwa iterator
        mov al, [edx];          # litera do al
        cmp al, 0;              # jeśli pusto to koniec szukania - brak dopasowania
        je finish_not_found
        jmp look_for_first;     # jeśli nie to powtarza czynność

    got_first:
        mov ecx, edx;           # przechowuje pierwszą litere w ecx
        inc edx;                # przesuwa iterator
        mov al, [edx];          # litera do al
        cmp al, 0;              # jeśli pusto to koniec szukania - brak dopasowania
        je finish_not_found;    
        cmp al, 'a';            # jeśli znajdzie litere a/b/c to wraca do szukania pierwszej pasującej
        je look_for_first;
        cmp al, 'b';
        je look_for_first;
        cmp al, 'c';
        je look_for_first;
        jmp got_another;        # jeśli nie znajdzie a/b/c to przechodzi dalej
    
    got_another:
        inc edx;                    # przesuwa iterator
        mov al, [edx];              # litera na al
        cmp al, 0;                  # jeśli pusto to koniec szukania - brak dopasowania
        je finish_not_found;
        cmp al, 'a';                # jeśli znajdzie a/b to wraca do szukania pierwszej pasującej
        je look_for_first;
        cmp al, 'b';
        je look_for_first;
        cmp al, 'c';
        je second_arg_conversion;   # jeśli znajdzie c to przechodzi do konwersji drugiego argumentu na liczbe
        jmp got_another;            # jeśli nie znajdzie a/b/c to powtarza czynność
    
    second_arg_conversion:
        mov eax, [esp + 12];    # liczba do eax       
        mov edi, [esp];
        push ecx;               # wrzucenie na stos adresu początku i długości wyrażenia
        sub edx, ecx;           # od adresu końca odejmujemy adres początku = długość - 1
        inc edx;
        push edx;               # żeby móc używac ecx i edx
        cmp edi, 3;
        jl no_third_arg;

        mov edi, 0;             # edi - ile razy wypisać
        mov esi, 1;             # esi - rząd wielkości liczby zależny od pozycji do mnożenia (1, 10, 100...)
        push 0;                 # na wierzchu stosu obecna suma
        mov ebx, 0;             # ebx - licznik, iterator po liczbie
        jmp look_for_number_length;

    look_for_number_length:
        mov dl, [eax + ebx];    # oblicza długość liczby
        cmp dl, 0;
        je got_number_length;
        inc ebx;
        jmp look_for_number_length;

    got_number_length:
        mov edi, 0;
        dec ebx;                # ebx - indeks cyfry (liczymy od tyłu), najpierw odjęcie, bo dla długosci = 3 np '987', ostatni indeks('7') to 2
        cmp ebx, 0;
        jl print_prep;          # jeśli ebx < 0 (0 to indeks pierwszej cyfry)
        mov dl, [eax + ebx];
        sub dl, '0';
        and edx, 0xFF;
        jmp how_much_is_it;

    how_much_is_it:
        cmp edx, 0;
        je size_inc_prep;       # mnożenie edx * esi (wartość pozycji * rządk wielkości) - wynik w edi
        add edi, esi;
        dec edx;
        jmp how_much_is_it;

    size_inc_prep:
        pop edx;                # suma wszystkich poprzednich rzędów wielkości
        add edi, edx;           # dodajemy do sumy z tej iteracji   np dla 28 -> 20 + 8
        push edi;               # wrzucenie łącznej sumy na stos
        
        mov edi, esi;           # kopiujemy obecny rząd wielkości
        mov edx, 9;             # rzędy wielkości różnią się 10*, jeden raz już jest w esi
        jmp size_inc;
    
    size_inc:
        cmp edx, 0;             # esi = esi + 9 * esi = 10 * esi;
        je got_number_length;   # jak zwiększyliśmy (np. z 10 zrobilismy 100) to idziemy do kolejnej litery
        dec edx;
        add esi, edi;
        jmp size_inc;


    no_third_arg:
        push 1;
        jmp print_prep;

    print_prep:
        pop edi;                # ile razy wypisać
        pop esi;                # w esi długość wypisywanego wyrażenia
        pop ebp;                # w ebp adres początku wyrażenia
        jmp finish_found;

    finish_found:               # wypisanie dopasowania okresloną ilość razy
        cmp edi, 0;
        je end;
        dec edi;
        mov ecx, ebp;
        mov edx, esi;
		mov ebx, 1;
        mov eax, 4;
        int 0x80
        mov ecx, offset NEW_LINE; 
        mov edx, offset LENGTH_NEW_LINE;
        mov ebx, 1;
        mov eax, 4;
        int 0x80
        jmp finish_found;

    finish_not_found:                       # poinformowanie o braku dopasowań
        mov ecx, offset NO_MATCH;
        mov edx, offset LENGTH_NO_MATCH;
        mov ebx, 1;
        mov eax, 4;
		int 0x80;
        jmp end;

    bad_call:                    # poinformowanie o niewłaściwym wywołaniu
        mov ecx, offset BAD_CALL;
        mov edx, offset LENGTH_BAD_CALL;
        mov ebx, 1;
        mov eax, 4;
		int 0x80;
        jmp end

    end:                # zakończenie działania programu
		mov eax,1;
        mov ebx,0;
		int 0x80;

.data
    NEW_LINE: .ascii "\n";
        .equ LENGTH_NEW_LINE, $-NEW_LINE
    
    NO_MATCH: .ascii "NO MATCH\n"
        .equ LENGTH_NO_MATCH, $-NO_MATCH

    BAD_CALL: .ascii "BAD CALL\n"
        .equ LENGTH_BAD_CALL, $-BAD_CALL

.att_syntax prefix
