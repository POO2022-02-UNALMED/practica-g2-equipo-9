from Python.src.gestorAplicacion_py.usuarios import Cliente
from Python.src.gestorAplicacion_py.usuarios import Gerente
from Python.src.gestorAplicacion_py.usuarios import Trabajador

#
#* Clase creada para almacenar los prodcutos deseados por el cliente
#* Tambien puede contener servicios
#* El pedido esta asociado tanto a trabajador como al cliente
#* 


class Pedido:




    #ATRIBUTOS DE INSTANCIA



    _totalPedidos = 0

    #ATRIBUTOS DE CLASE

    _pedidos = []
    _numeroPedido =0

    #CONSTRUCTOR

    def __init__(self, trabajador, cliente, estadoPedido, productos, servicios, fechaPedido, codigo):
        self._cliente = cliente
        self._trabajador = trabajador
        self._estadoPedido = estadoPedido #CONSTRUCTOR PARA LA FUNCIONALIDAD realizarReserva
        self._productos = productos  #array con productos
        self._servicios = servicios  #array con servicios
        self._fechaPedido = fechaPedido #fecha del pedido
        self._codigo = codigo           #codigo del pedido
        self._pedidos.append(self)
        Pedido._numeroPedido+=1


    #GETTERS Y SETTERS


    def getTrabajador(self):
        return self._trabajador

    def setTrabajador(self, trabajador):
        self._trabajador = trabajador

    def getCliente(self):
        return self._cliente

    def setCliente(self, cliente):
        self._cliente = cliente

    @staticmethod
    def getPedidos(self):
        return self._pedidos

    @staticmethod
    def setPedidos(self,pedidos):
        self._pedidos=pedidos

    def getEstadoPedido(self):
        return self._estadoPedido

    @staticmethod
    def getTotalPedidos():
        return Pedido._numeroPedido

    @staticmethod
    def setTotalPedidos(numeroPedido):
        Pedido._numeroPedido=numeroPedido

    def setEstadoPedido(self, estadoPedido):
        self._estadoPedido = estadoPedido

    def getProductos(self):
        return self._productos

    def setProductos(self, productos):
        self._productos = productos

    def getFechaPedido(self):
        return self._fechaPedido

    def setFechaPedido(self, fechaPedido):
        self._fechaPedido = fechaPedido

    def getCodigo(self):
        return self._codigo

    def setCodigo(self, codigo):
        self._codigo = codigo


    def getServicios(self):
        return self._servicios

    def setServicios(self, servicios):
        self._servicios = servicios




