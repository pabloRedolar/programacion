from Ficha import Ficha
class Libro(Ficha):
    autor: str
    editorial: str

    def __init__(self, titulo, autor, editorial):
        super().__init__(titulo)
        self.autor = autor
        self.editorial = editorial

    def mostrar_info(self):
        return super().mostrar_info()+(f", Autor del libro: {self.autor} y Editorial: {self.editorial}")


