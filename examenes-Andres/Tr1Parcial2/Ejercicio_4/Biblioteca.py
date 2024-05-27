from Ficha import Ficha
from Libro import Libro
from Revista import Revista
from DVD import DVD
class Biblioteca:
    lista_items: []
    def __init__(self):
        self.lista_items = []

    def add_item(self, elemento):
        self.lista_items.append(elemento)

    def buscar(self, elemento):
        if type(elemento) == str: #Busqueda por titulo
            for item in self.lista_items:
                if elemento == item.titulo:
                    print(f"El ID de tu busqueda es: {item.identificador}")
                    return item
        if type(elemento) == int: #Busqueda por ID
            for item in self.lista_items:
                if elemento == item.identificador:
                    print(f"El titulo de tu busqueda es: {item.titulo}")
                    return item
    def eliminar(self, elemento):
        self.lista_items.remove(elemento)

    def listado(self):
        for item in self.lista_items:
            print(item.mostrar_info())