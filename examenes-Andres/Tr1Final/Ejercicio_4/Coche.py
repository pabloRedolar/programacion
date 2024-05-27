from Vehiculo import Vehiculo


class Coche(Vehiculo):
    ventanilla: str

    def __init__(self, nombre, dorsal, velocidad_maxima, tipo_combustible, numero_ruedas):
        super().__init__(nombre, dorsal, velocidad_maxima, tipo_combustible, numero_ruedas)
        self.ventanilla = "subida"

    def bajar_ventanilla(self):
        self.ventanilla = "bajada"
        print(f"La ventanilla del coche con dorsal {self.dorsal} esta bajada")

    def mostrar_info(self):
        if self.ventanilla == "bajada":
            return "El coche con " + super().mostrar_info() + f", tiene la ventanilla {self.ventanilla}"
        return "El coche con " + super().mostrar_info()
    



