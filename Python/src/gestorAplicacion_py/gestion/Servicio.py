from enum import Enum

class servicio(Enum):
    BARMAN=200
    COCKTAILCHALLENGE=300
    MESEROEXCLUSIVO=400
    STRIPPER=500

    def _init_(self, precio):
        self._precio = 0

        self._precio=precio

    def getPrecio(self):
        return self._precio


    @staticmethod
    def motrarNombreCantidadPrecio(serviciosPedidos):
        s ="Pedido de servicios:" + "\nNombre, Cantidad, Precio"
        nombresNoRepetidos = TreeSet()
        valorTotal =0
        for servicio in serviciosPedidos:
            nombresNoRepetidos.add(servicio)
            valorTotal+=servicio.getPrecio()
        i =1
        for servicio in nombresNoRepetidos:
            s+="\n"+str(i)+". Nombre: "+servicio+", cantidad: "+Collections.frequency(serviciosPedidos,servicio)+", Precio: "+Collections.frequency(serviciosPedidos,servicio)*servicio.getPrecio()
            i += 1
        s+="\nValor total de servicios: "+str(valorTotal)
        return s
    @staticmethod
    def serviciosOfrecidos():
        s = "Numero de servicio, Nombre de servicio, Precio:"
        i = 1
        for servicio in Servicio.values():
            s += "\nNumero de servicio: " + str(i) + " , Nombre: " + servicio + ", Precio: " + str(servicio.getPrecio())
            i += 1
        return s

    @staticmethod
    def hashmapServicios():
        servicios = {}
        i =1
        for servicio in Servicio.values():
            servicios[i] = servicio
            i += 1
        return servicios

    @staticmethod
    def agregarServicios(numeroServicio, cantidadEscogida, servicios):
        a = []
        for i in range(0, cantidadEscogida):
            a.append(servicios[numeroServicio])
        return a

    @staticmethod
    def verificarServicio(servicio, serviciosPedidos):
        existe =False
        if servicio in serviciosPedidos:
            existe=True
        return existe
    @staticmethod
    def verificarServicio(servicio, cantidadEscogida, serviciosPedidos):
        existe =False
        if cantidadEscogida>=0 and cantidadEscogida<=Collections.frequency(serviciosPedidos,servicio):
            existe=True
        return existe


