from gestorAplicacion.usuarios import Cliente
from gestorAplicacion.usuarios import Gerente
from gestorAplicacion.usuarios import Trabajador

#
#* Clase creada para almacenar los prodcutos deseados por el cliente
#* Tambien puede contener servicios
#* El pedido esta asociado tanto a trabajador como al cliente
#* 


class Pedido:

    def _initialize_instance_fields(self):
        #instance fields found by Java to Python Converter:
        self._trabajador = None
        self._cliente = None
        self._estadoPedido = None
        self._productos = []
        self._servicios = []
        self._fechaPedido = None
        self._codigo = 0

    _SERIALVERSIONUID = 1

    #ATRIBUTOS DE INSTANCIA



    _totalPedidos = 0

    #ATRIBUTOS DE CLASE

    _pedidos = []
    _numeroPedido =0

    #CONSTRUCTOR



    def __init__(self):
        self._initialize_instance_fields()



    def __init__(self, cliente, estadoPedido, productos, servicios, fechaPedido, codigo):
        self._initialize_instance_fields()

        self._cliente = cliente
        self._estadoPedido = estadoPedido #CONSTRUCTOR PARA LA FUNCIONALIDAD realizarReserva
        self._productos = productos
        self._servicios = servicios
        self._fechaPedido = fechaPedido
        self._codigo = codigo
        gestorAplicacion.gestion.Pedido._pedidos.append(self)


    def __init__(self, trabajador, cliente, estadoPedido, productos, servicios, fechaPedido):
        self._initialize_instance_fields()

        self._trabajador = trabajador
        self._cliente = cliente
        self._estadoPedido = estadoPedido
        self._productos = productos
        self._servicios = servicios
        self._fechaPedido = fechaPedido
        self._codigo = self.generarCodigo()
        gestorAplicacion.gestion.Pedido._pedidos.append(self)
        Pedido._totalPedidos += 1

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
    def getPedidos():
        return gestorAplicacion.gestion.Pedido._pedidos

    @staticmethod
    def setPedidos(pedidos):
        Pedido._pedidos = pedidos

    def getEstadoPedido(self):
        return self._estadoPedido

    @staticmethod
    def getTotalPedidos():
        return len(gestorAplicacion.gestion.Pedido._pedidos)

    @staticmethod
    def setTotalPedidos(totalPedidos):
        Pedido._totalPedidos = totalPedidos


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

    def setCodigo(self, id):
        self._codigo = self._codigo

    @staticmethod
    def getNumeroPedido():
        return gestorAplicacion.gestion.Pedido._numeroPedido

    @staticmethod
    def setNumeroPedido(numeroPedido):
        Pedido._numeroPedido = numeroPedido

    def getServicios(self):
        return self._servicios

    def setServicios(self, servicios):
        self._servicios = servicios

    def setCodigo(self, codigo):
        self._codigo = codigo

    #OTROS METODOS
    def generarCodigo(self):

        tempVar = gestorAplicacion.gestion.Pedido._numeroPedido
        gestorAplicacion.gestion.Pedido._numeroPedido += 1
        return tempVar



    def generarFactura(self):
        productos ="Productos: " + "\nNombre........Cantidad.......Precio"
        nombreYprecio = {}
        totalProductos = 0
        nombre = []
        for producto in self.getProductos():
            if producto.getNombre() in nombreYprecio.keys() == False:
                nombreYprecio[producto.getNombre()] = producto.getPrecioVenta()
            nombre.append(producto.getNombre())
            totalProductos += producto.getPrecioVenta()

