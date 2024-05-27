from Ficha import Ficha
class DVD(Ficha):
    director: str
    year: int
    tipo: str

    def __init__(self, titulo, director, year, tipo):
        super().__init__(titulo)
        self.director = director
        self.year = year
        self.tipo = tipo

    def mostrar_info(self):
        return super().mostrar_info()+(f", director: {self.director}, año de grabacion: {self.year}, tipo: {self.tipo}")
