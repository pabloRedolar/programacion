def limpiador_de_lista(lista_a_limpiar):
    for elemento in lista_a_limpiar[::-1]:
        cuenta = lista_a_limpiar.count(elemento)
        if cuenta > 2:
            for _ in range(cuenta-2):
                lista_a_limpiar.remove(elemento)
    return lista_a_limpiar




lista1 = ["Antonio", "Juan", "Juan", "Pedro", "Lucas", "Ana", "Julian", "Ana", "Juan", "Ana", "Ana", "Lucia", "Pablo"]
lista1 = limpiador_de_lista(lista1)
print(lista1)