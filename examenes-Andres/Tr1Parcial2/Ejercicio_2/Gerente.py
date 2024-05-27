from Empleado import Empleado

class Gerente(Empleado):
    departamento: str

    def __init__(self, nombre, edad, salario, departamento):
        super().__init__(nombre, edad, salario)
        self.departamento = departamento

    def calcular_bono(self):
        return self.salario * 0.20

    def mostrar_informacion(self):
        return super().mostrar_informacion()+(f" departamento que supervisa: {self.departamento}")