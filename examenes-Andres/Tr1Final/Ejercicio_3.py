import random

lista_recopilada = []

for _ in range(30):  # Genero numeros aleatorios
    lista_recopilada.append(random.randint(0, 49))

print(f"{lista_recopilada}\n")
recuerdo, lista_ordenada = [], lista_recopilada
lista_ordenada.sort()

for element in lista_ordenada:
    if element not in recuerdo:
        recuerdo.append(element)
        veces = lista_ordenada.count(element)

        if veces == 1:
            print(f"{element} - {veces} vez")
        else:
            print(f"{element} - {veces} veces")
