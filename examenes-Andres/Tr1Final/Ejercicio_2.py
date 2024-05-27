def combinar_listas_ordenadas(lista1, lista2):
    for i in lista2:
        if i not in lista1:
            lista1.append(i)
    lista1.sort()
    return lista1


listaprueba1, listaprueba2 = [2, 3, 8, 9, 58, 200], [3, 8, 25, 120, 200, 300]
print(f"lista1 = {listaprueba1}\n"
      f"lista2 = {listaprueba2}\n"
      f"La lista sin duplicados es: {combinar_listas_ordenadas(listaprueba1, listaprueba2)}")


