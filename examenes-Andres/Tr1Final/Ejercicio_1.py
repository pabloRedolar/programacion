def suma_recursiva(n):
    if n == 0:
        return 0
    return n + suma_recursiva(n-1)


valor = int(input("Un numero superior a 998 provocara error por limite de profundidad recursiva.\nIntroduce un numero: "))
print(f"La suma de los primeros {valor} numeros es: {suma_recursiva(valor)}")
