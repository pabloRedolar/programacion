from Ficha import Ficha
class Revista(Ficha):
    num_revista: int
    year_publicacion: int

    def __init__(self, titulo, num_revista, year_publicacion):
        super().__init__(titulo)
        self.num_revista = num_revista
        self.year_publicacion = year_publicacion

    def mostrar_info(self):
        return super().mostrar_info()+(f", numero de revista: {self.num_revista} y año de publicacion: {self.year_publicacion}")
