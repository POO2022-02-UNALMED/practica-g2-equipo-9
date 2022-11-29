
from datetime import date

#
#* Clase creada para poder crear reservas
#* Una vez un usuario utiliza la funcionalidad crear reserva un obejto de tipo reserva es creado
#* Este Objeto se le asocia atributos de pedido y fecha de acuerdo a lo ingresado por el cliente en la funcionalidad crear reserva o modificar reserva
#

class Reserva:

    def _initialize_instance_fields(self):
        #instance fields found by Java to Python Converter:
        self._idReserva = 0
        self._estado = None
        self._cliente = None
        self._servicios = None
        self._fechaReserva = None
        self._fechaCreacion = None
        self._pedido = None
        self._espacio = None
        self._pagoCancelacion =0




    #ATRIBUTOS DE CLASE
    _numReservas = 0 # contador del numero de reservas
    _reservas = []


    #CONSTRUCTORES

    #ATRIBUTOS DE INSTANCIA
    def __init__(self):
        self._initialize_instance_fields()

        self._fechaCreacion = date.today()
        self._idReserva = Reserva._numReservas
        Reserva._numReservas += 1
        Reserva._reservas.append(self)


    def __init__(self, cliente):
        self()
        self._cliente = cliente


    def __init__(self, estado, cliente, servicios, fechaReserva, pedido):
        self(cliente) # sobrecarga de metodos
        self._idReserva = Reserva._numReservas
        self._estado = estado
        self._servicios = servicios
        self._fechaReserva = fechaReserva
        self._pedido = pedido
        Reserva._numReservas += 1

    #GETTERS Y SETTERS


    @staticmethod
    def getReservas():
        return Reserva._reservas

    @staticmethod
    def setReservas(reservas):
        Reserva._reservas = reservas

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

    def getServicios(self):
        return self._servicios

    def setServicios(self, servicios):
        self._servicios = servicios

    def getFechaReserva(self):
        return self._fechaReserva

    def setFechaReserva(self, fechaReserva):
        self._fechaReserva = fechaReserva

    def getFechaCreacion(self):
        return self._fechaCreacion

    def setFechaCreacion(self, fechaCreacion):
        self._fechaCreacion = fechaCreacion

    def getPedido(self):
        return self._pedido

    def setPedido(self, pedido):
        self._pedido = pedido

    @staticmethod
    def getNumReservas():
        return Reserva._numReservas

    @staticmethod
    def setNumReservas(numReservas):
        Reserva._numReservas = numReservas


    def getPagoCancelacion(self):
        return self._pagoCancelacion

    def setPagoCancelacion(self, pagoCancelacion):
        self._pagoCancelacion = pagoCancelacion

    def getEspacio(self):
        return self._espacio

    def setEspacio(self, espacio):
        self._espacio = espacio

    def calcularPrecioReserva(self):
        acumulado = 0
        for servicio in self._servicios:
            acumulado+= servicio.getPrecio()

        for producto in self._pedido.getProductos():
            acumulado+= producto.getPrecioVenta()

        return acumulado # retorna el acumulado de todo lo sumado anteriormente

    def toString(self):
        if self.getEstado() == "Activa":
            return "Reserva realizada con exito!\n" + "El total de su reserva es de: " + str(self.calcularPrecioReserva()) + "\n" + "Su reserva es para el dia: " + self.getFechaReserva() + "\n" + "Y esta fue creada el dia: " + self.getFechaCreacion()
        if (self.getEstado() == "Activa") or (self.getEstado() == "Cancelada"):
            return "Su reserva ha sido cancelada con exito!\n" + "El valor a pagar por su cancelacion es de: " + str(self._pagoCancelacion)

        if (self.getEstado() == "Activa") or (self.getEstado() == "Cancelada") or (self.getEstado() == "Cumplida"):
            return "Esta reserva se ha culminado con exito el dia "+self.getFechaReserva()
        return super().toString()
