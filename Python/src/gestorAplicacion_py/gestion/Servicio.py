from enum import Enum

class servicip(Enum):
    BARMAN=200
    COCKTAILCHALLENGE=300
    MESEROEXCLUSIVO=400
    STRIPPER=500

    def _init_(self, precio):
        self._precio = 0

        self._precio=precio

    def getPrecio(self):
        return self._precio


