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
    self._fechaCreacion = fechaCreacion

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

def getPedido(self):
    return self._pedidos

def setPedido(self, pedido):
    self._pedidos = pedido

@classmethod
def getNumeroReservas(cls):
    return numReservas

@classmethod
def setNumeroReservas(cls, numReservas):
    cls.numReservas = numReservas

def getEspacio(self):
    return self._espacio

def setEspacio(self, espacio):
    self._espacio = espacio

def getPagoCancelacion(Self):
    return self._pagoCancelacion

def setPagoCancelacion(self, pagoCancelacion):
    self._pagoCancelacion = pagoCancelacion

def getServicios(self):
    return self._servicios

def setServicios(self, servicios):
    self._servivios =servicios

def getFechaReserva(self):
    return self._fechaReserva

def setFechaReserva(self, fechaReserva):
    self._fechaReserva = fechaReserva

def getFechaCreacion(self):
    return self._fechaCreacion

def setFechaReserva(self, fechaCreacion):
    self.__fechaCreacion = _fechaCreacion

