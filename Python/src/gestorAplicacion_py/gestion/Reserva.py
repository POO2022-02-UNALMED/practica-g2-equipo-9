class Reserva:

    _reserva = []
    numReservas = 0

def __init__(self, estado="", cliente = "", servicios ="", fechaReserva = None, pedido=None):
    self._estado = estado
    self._cliente = cliente
    self._servicios = servicios
    self._fechaReserva = fechaReserva
    self._pedido = pedido
    self._idReseva = numReservas

@classmethod
def getReserva(cls):
    return cls._reserva

@classmethod
def setReserva(cls, reserva):
    cls._reserva = reserva

def getIdReserva(self):
    return self._idReserva

def setIdReserva(self, idReserva):
    self._idReserva = idReserva

def getEstado(self):
    return self._estado

def setEstado(self, estado):
    self._estado = estado

def getCliente(self):
    return self._cliente

def setCliente(self, cliente):
    self._cliente = cliente




