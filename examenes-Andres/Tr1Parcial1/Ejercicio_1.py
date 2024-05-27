frase, cuenta = input("Dime una frase: "), 0

for letra in frase:
    if letra == "o":
        cuenta+=1
print(f"La letra 'o' aparecio {cuenta} veces")