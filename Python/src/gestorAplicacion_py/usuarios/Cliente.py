from Usuario import Usuario

from gestorAplicacion_py.gestion.Pedido import *
class Cliente(Usuario.Usuario):

    _clientes = []
    _historialpedidos = []
    _numeroCliente = 0

# preguntar que hago con ese constructor
    def __init__(self, codigo, nombre, numeroReserva, estadoReserva,reserva):
        super().__init__(codigo, nombre)
        self._numeroReserva = numeroReserva
        self._estadoReserva = estadoReserva
        self._reserva = reserva

        Cliente._clientes.append(self)

    def generarCodigo(cls):
       return cls._numeroCliente+1

    @classmethod
    def getClientes(cls):
        return cls._clientes

    @classmethod
    def setClientes(cls,Clientes):
        cls._clientes = Clientes

    @classmethod
    def getHistorialPedidos(cls):
        return cls._historialpedidos

    @classmethod
    def setHistorialPedidos(cls,historial):
        cls._historialpedidos = historial

    @classmethod
    def getNumeroClientes(cls):
        return cls._numeroCliente

    @classmethod
    def setNumeroClientes(cls, Numer):
        cls._numeroCliente = Numer

    def getNumeroReserva(self):
        return self._numeroReserva
        
    def setNumeroReserva(self,numeroReserva):
        self._numeroReserva = numeroReserva

    def getEstadoReserva(self):
        return self._estadoReserva
        
    def setEstadoReserva(self,estadoReserva):
        self._estadoReserva = estadoReserva

    def getReserva(self):
        return self._reserva

    def setReserva(self,reserva):
        self._reserva = reserva


    def agregarPedidoHistorial(Pedido):
        Cliente._historialpedidos.append(Pedido)

    def informacion(cls,self):
        return print("El cliente {self._nombre} con número de reserva, {self._numeroReserva}, y estado de la reserva, {self._estadoReserva}, Ha hecho, {cls._historialpedidos} pedidos en el sistema.")


    def mostrarClientesRegistrados(cls, self):
        k = 0
        while k < len(cls._clientes):
            return print(cls._clientes[k].self.nombre)
            k+1

