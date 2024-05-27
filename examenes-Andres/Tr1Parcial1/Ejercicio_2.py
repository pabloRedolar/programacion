frase, vocales = input("Dime una frase: "), "aeiouáéíóú"

for letra in frase:
    if letra.lower() in vocales: pass
    else: print(letra, end="")