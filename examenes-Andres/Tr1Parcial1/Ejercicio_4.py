frase = input("Dime una frase")
frase = frase.lower()
ALPHABETO = "abcdefghijklmnñopqrstuvwxyz"

#Creo un ejecutable de codigo que itervendra cuando mi alphabeto se quede sin letras que iterar.
#Podria haber añadido a ALPHABETO "abc" pero me agrada el uso de una variable ejecutable
fin_de_alphabeto = "if contador==1: result='a'\nelif contador==2: result='b'\nelse: result='c'"

for letra in frase:
    contador, located, result = -1, False, 0
    for x in ALPHABETO:
        if x==letra:
            contador, located = 3, True
        elif located: contador-=1
        if contador==0:
            result = x
        elif x == "z": exec(fin_de_alphabeto)
        if result!=0:
            print(result,end="")
            break