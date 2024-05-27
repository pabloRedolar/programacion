lista_primos = []

for i in range(1,1998):
    if i==1 or i==3 or i==2: lista_primos.append(i)
    elif i%2 == 0: pass
    else:
        for divisor in range(3,1998,2):
            if i%divisor == 0: break
            if divisor>(i//2)+1:
                lista_primos.append(i)
                break

print(lista_primos)

while True:
    num1 = int(input("Dime un numero: "))
    if num1>1998: print(f"Demasiado grande, el limite es 1998. Vuelva a intentarlo.")
    else: break

for x in lista_primos:
    if num1 in lista_primos:
        print(f"El numero {num1} es primo")
        break

    if num1<x:
        print(f"El numero primo posterior es el {x}")
        break




