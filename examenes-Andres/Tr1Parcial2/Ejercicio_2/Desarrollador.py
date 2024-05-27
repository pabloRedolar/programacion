from Empleado import Empleado
class Desarrollador(Empleado):
    lenguaje: str

    def __init__(self, nombre, edad, salario, lenguaje):
        super().__init__(nombre, edad, salario)
        self.lenguaje = lenguaje

    def calcular_bono(self):
        return self.salario*0.15

    def mostrar_informacion(self):
        return  super().mostrar_informacion()+ (f", lenguaje de programacion: {self.lenguaje}")



