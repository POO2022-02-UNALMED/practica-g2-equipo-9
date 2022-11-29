from enum import Enum



class servicio(Enum):
    BARMAN=200
    COCKTAILCHALLENGE=300
    MESEROEXCLUSIVO=400
    STRIPPER=500
    
    def __init__(self, precio: int, codigo: int) -> None:
        self._precio: int = precio
        self._codigo: int = codigo
    
    def getPrecio(self) -> int:
        return self._precio

    def getCodigo(self) -> int:
        return self._codigo








    @staticmethod
    def agregarServicios(numeroServicio, cantidadEscogida, servicios):
        a = []
        for i in range(0, cantidadEscogida):
            a.append(servicios[numeroServicio])
        return a


    
    @staticmethod
    def codigo_2_servicio(codigo: int):
        servicios = {200: 'Barman',
                     300: 'Cocktail Challenge',
                     400: 'Mesero Exclusivo',
                     500: 'Stripper'}
        servicio_seleccionado = servicios[codigo]

        if servicio_seleccionado is None:
            return "Servicio No Registrado"
        return servicio_seleccionado


