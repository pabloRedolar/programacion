from Ficha import Ficha
from Libro import Libro
from Revista import Revista
from DVD import DVD
from Biblioteca import Biblioteca

book1 = Libro("Neruda", "Pablo", "Erasmus")
book2 = Libro("Poesias", "Aitor", "Brus")
dvd1 = DVD("Fast", "Manuel", 2002, "Accion")
dvd2 = DVD("El Examen", "Jorge", 1978, "Drama")
revista1 = Revista("Cotilleos", 2, 2004)
revista2 = Revista("El corazon", 7, 1790)

biblio = Biblioteca()
biblio.add_item(book1)
biblio.add_item(book2)
biblio.add_item(dvd1)
biblio.add_item(dvd2)
biblio.add_item(revista1)
biblio.add_item(revista2)

dvd2.identificador = 10

biblio.buscar("Neruda")
biblio.buscar(10)
print()

biblio.listado()
print()
biblio.eliminar(dvd1)
biblio.listado()