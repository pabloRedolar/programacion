from Coche import Coche
from Moto import Moto


class Circuito:
    nombre: str
    lista_participantes: []

    def __init__(self, nombre):
        self.nombre = nombre
        self.lista_participantes = []

    def add_participante(self, participante):
        self.lista_participantes.append(participante)

    def mostrar_info(self):
        print(f"Nombre del circuito: {self.nombre}\n"
              f"Lista de Participantes:")

    def inicializa_carrera(self):
        for elemento in self.lista_participantes:
            print(elemento.mostrar_info())
