class Pedido:

    pedidos = []
    _totalPedidos = 0
    _numeroPedido = 0

def __init__(self, cliente = None,  estadoPedido = "", productos = 0, servicio ="", fechaPedido="", codigo=0  ):
    self._cliente = cliente
    self._estadoPedido = estadoPedido
    self._producto = productos
    self._servicio = servicio
    self._fechaPedido = fechaPedido
    self._codigo = Pedido._totalPedidos
    self._productos = []
    Pedido._pedidos.append(self)
    Pedido._totalPedidos += 1

    def getTrabajador(self):
        return self._trabajador

    def setTrabajador(self, trabajador):
        self._trabajador = trabajador


    def getCliente(self):
        return self._cliente

    def setCliente(self, nuevoCliente):
        self._cliente = nuevoCliente

    def getFechaPedido(self):
        return self._fechaPedido

    def setFechaPedido(self, fechaPedido):
        self._fechaPedido = fechaPedido

    def getEstadoPedido(self):
        return self._estadoPedido

    def setEstadoPedido(self, estadoPedido):
        self._estadoPedido = estadoPedido

    def getProductos(self):
        return self._productos

    def setProductos(self, productos):
        self._productos = productos

    def getServicio(self):
        return self._servicio

    def setServicio(self, servicio):
        self._servicio = servicio

    @classmethod
    def getPedidos(cls):
        return cls._pedidos

    @classmethod
    def setPedidos(cls, pedidos):
        cls._pedidos = pedidos

    @classmethod
    def getTotalPedidos(cls):
        return cls._totalPedidos

    @classmethod
    def setTotalPedidos(cls, totalPedidos):
        cls._totalPedidos = totalPedidos

    @classmethod
    def getNumeroPedido(cls):
        return cls._numeroPedido

    @classmethod
    def setNumeroPedido(cls, numeroPedido):
        cls._numeroPedido = numeroPedido

    
