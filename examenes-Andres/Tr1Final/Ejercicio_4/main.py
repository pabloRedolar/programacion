from Circuito import Circuito
from Moto import Moto
from Coche import Coche

circuito1 = Circuito("Gasol")

coche1 = Coche("Pablo", 10, 190, "gasolina", 4)
coche2 = Coche("Lucas", 11, 240, "gasoil", 4)
coche3 = Coche("Fran", 17, 320, "electrico", 5)

moto1 = Moto("Mike", 3, 290, "gasolina", 2)
moto2 = Moto("Mark", 1, 370, "gasoil", 2)
moto3 = Moto("Pepe", 5, 210, "electrico", 3)

circuito1.add_participante(coche1)
circuito1.add_participante(coche2)
circuito1.add_participante(coche3)
circuito1.add_participante(moto1)
circuito1.add_participante(moto2)
circuito1.add_participante(moto3)

circuito1.inicializa_carrera()
print()

coche1.acelerar(1000)
print(coche1.mostrar_info())


print("\nExtra\n")  # Extra para probar el resto de funciones

coche2.bajar_ventanilla()
moto2.abrochar_casco()
print(f"\n{coche2.mostrar_info()}\n"
      f"{moto2.mostrar_info()}\n")

# Extra motores
coche2.sonido_motor()
moto3.sonido_motor()
moto1.sonido_motor()
