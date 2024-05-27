from Vehiculo import Vehiculo


class Moto(Vehiculo):
    abrochado: str

    def __init__(self, nombre, dorsal, velocidad_maxima, tipo_combustible, numero_ruedas):
        super().__init__(nombre, dorsal, velocidad_maxima, tipo_combustible, numero_ruedas)
        self.abrochado = "desabrochado"

    def abrochar_casco(self):
        self.abrochado = "abrochado"
        print(f"El piloto con dorsal {self.dorsal} se ha abrochado el casco")

    def mostrar_info(self):
        if self.abrochado == "abrochado":
            return "La moto con " + super().mostrar_info() + f", tiene el casco {self.abrochado}"
        return "La moto con " + super().mostrar_info()
