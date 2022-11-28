

from Python.src.gestorAplicacion_py.usuarios.Usuario import Usuario
class Cliente(Usuario):

    _clientes = []
    _numeroCliente = 0

# preguntar que hago con ese constructor
    def __init__(self, codigo, nombre, numeroReserva, estadoReserva,reserva):
        super().__init__(codigo, nombre)
        self._numeroReserva = numeroReserva
        self._estadoReserva = estadoReserva
        self._reserva = reserva
        Cliente._clientes.append(self)
        Cliente._numeroCliente+=1

    @classmethod
    def getClientes(cls):
        return Cliente._clientes


    @classmethod
    def setClientes(Clientes):
        Cliente._clientes = Clientes


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

    def informacion(self):
        return "Cliente con nombre "+self.getNombre()+" y codigo "+self.getCodigo()




