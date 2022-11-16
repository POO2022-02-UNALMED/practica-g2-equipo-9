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

    


    def getCliente(self):
        return self._cliente

    def setCliente(self, nuevoCliente):
        self._cliente = nuevoCliente

    def getFechaPedido(self):
        return self._fechaPedido

    def setFechaPedido(self, fechaPedido):
        self._fechaPedido = fechaPedido
