from Empleado import Empleado
from Desarrollador import Desarrollador
from Gerente import Gerente

empleado1 = Empleado("Juan", 24, 3200)
desarrolador1 = Desarrollador("Lucas", 23, 4800, "Python")
gerente1 = Gerente("Emily", 28, 8200, "Diseño Grafico")
desarrolador2 = Desarrollador("Manu", 78, 3200, "Python")
gerente2 = Gerente("Manolo", 94, 3200, "Web")




print(empleado1.mostrar_informacion())
print(desarrolador2.mostrar_informacion())
print(gerente2.mostrar_informacion())
print(desarrolador1.mostrar_informacion())
print(gerente1.mostrar_informacion())


