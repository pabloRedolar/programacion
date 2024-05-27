
class Ficha:
    identificador: int
    titulo: str

    def __init__(self, titulo):
        self.identificador = id(self)
        self.titulo = titulo

    def mostrar_info(self):
        return (f"ID: {self.identificador}, Titulo: {self.titulo}")