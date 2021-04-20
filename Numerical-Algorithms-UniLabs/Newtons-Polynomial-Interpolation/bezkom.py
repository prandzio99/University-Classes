from sys import exit


def check_sorted(tab, op="l"):
    i = 0
    if op == "le":
        while i < len(tab) - 1:
            if tab[i] > tab[i + 1]:
                return False
            i += 1
    else:
        while i < len(tab) - 1:
            if tab[i] >= tab[i + 1]:
                return False
            i += 1
    return True


def create_table(n):
    if n < 0:
        print("Nieprawidłowa wartość n.\n"
              "Uruchom program ponownie i spróbuj jeszcze raz.")
        exit()
    res = [[], [], []]
    print("\nUWAGA! Podawaj wartości x w kolejności rosnącej!")
    for i in range(n + 1):
        prompt = "Podaj x" + str(i) + ": "
        res[0].append(float(input(prompt)))
        prompt = "Podaj y" + str(i) + ": "
        res[1].append(float(input(prompt)))
        prompt = "Podaj z" + str(i) + ": "
        res[2].append(float(input(prompt)))
    if not check_sorted(res[0]):
        print("Dane wejściowe wadliwe - podane w niewłaściwym porządku.\n"
              "Uruchom program ponownie i spróbuj jeszcze raz.")
        exit()
    else:
        print("Dane wejściowe prawidłowe.")
    return res


def generate_ts(tab):
    res = []
    count = 0
    i = 0
    while i < len(tab[0]):
        if count < 2:
            res.append(tab[0][i])
            count += 1
        else:
            count = 0
            i += 1
    return res


def diff_quot(t, tab):
    if len(t) == 1:
        return tab[1][tab[0].index(round(t[0]))]
    elif t[0] == t[-1]:
        return tab[2][tab[0].index(round(t[0]))]
    else:
        return (diff_quot(t[1:], tab) - diff_quot(t[:-1], tab)) / (t[-1] - t[0])


def generate_bs(tab, t):
    res = []
    for i in range(1, len(t) + 1):
        res.append(diff_quot(t[:i], tab))
    return res


def show_polynomial(t, b):
    res = "H(x) = "
    factor = ""
    for i in range(len(b)):
        if b[i] != 0:
            if i != 0:
                res += " + "
            res += str(b[i]) + factor
        if t[i] >= 0:
            factor += "(x - " + str(t[i]) + ")"
        else:
            factor += "(x + " + str(abs(t[i])) + ")"
    print(res)


def interpolate(tab):
    t = generate_ts(tab)
    if not check_sorted(t, "le"):
        print("Błąd w liście t!\n"
              "Coś poszło nie tak. \n"
              "Uruchom program ponownie i spróbuj jeszcze raz.")
        exit()
    b = generate_bs(tab, t)
    show_polynomial(t, b)
    return t, b


def h(x, t, b):
    factor = 1
    res = 0
    for i in range(len(b)):
        res += b[i] * factor
        factor *= (x - t[i])
    return round(res, 4)


def is_number(s):
    try:
        float(s)
        return True
    except ValueError:
        return False


def calculate(t, b):
    print("Aby zakończyć działanie programu, zamiast podawać argument - po prostu wciśnij Enter")
    while True:
        x = input("Podaj t: ")
        if x == "":
            break
        if not is_number(x):
            print("Podaj liczbę wymierną!!!\n")
            continue
        print("H(", x, ") = ", h(float(x), t, b), sep="", end="\n\n")


print("Program interpoluje wielomian metodą Newtona dla węzłów dwukrotnych.\n")
data = create_table(int(input("Podpowiedź: x0, x1, ..., xn; y0, y1, ..., yn; z0, z1, ..., zn;\n"
                              "UWAGA! n musi być większe lub równe 0\n"
                              "Podaj n: ")))
t_list, b_list = interpolate(data)
print("t =", t_list)
print("b =", b_list)
calculate(t_list, b_list)
print("Program pomyślnie zakończył działanie.")
