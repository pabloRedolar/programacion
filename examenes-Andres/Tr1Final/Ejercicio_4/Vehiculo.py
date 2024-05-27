class Vehiculo:
    nombre: str
    dorsal: int
    velocidad_actual: int
    velocidad_maxima: int
    tipo_combustible: str
    numero_ruedas: int    # A pesar de indicar que la añada en coche y moto,
    # si la tienen en comun no tiene logica repetirlos, por lo tanto decidi añadirlo aqui

    def __init__(self, nombre, dorsal, velocidad_maxima, tipo_combustible, numero_ruedas):
        self.nombre = nombre
        self.dorsal = dorsal
        self.velocidad_actual = 0
        self.velocidad_maxima = velocidad_maxima
        self.tipo_combustible = tipo_combustible.lower()
        self.numero_ruedas = numero_ruedas

    def sonido_motor(self):
        if self.tipo_combustible == "electrico":
            print("Silencio")
        if self.tipo_combustible == "gasolina":
            print("brum brum")
        if self.tipo_combustible == "gasoil":
            print("sueno a cafetera")

    def acelerar(self, kmh):
        self.velocidad_actual += kmh
        if self.velocidad_actual > self.velocidad_maxima:
            self.velocidad_actual = self.velocidad_maxima

    def mostrar_info(self):
        return (f"Piloto: {self.nombre}, Dorsal: {self.dorsal}, "
                f"velocidad actual/maxima: {self.velocidad_actual}/{self.velocidad_maxima}, "
                f"tipo de combustible: {self.tipo_combustible}, num.ruedas: {self.numero_ruedas}")
