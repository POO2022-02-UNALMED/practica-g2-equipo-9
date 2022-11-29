

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

    def __init__(self, trabajador, cliente, estadoPedido="", productos=0, servicios=[], fechaPedido="", codigo=0):
        self._cliente = cliente
        self._trabajador = trabajador
        self._estadoPedido = estadoPedido #CONSTRUCTOR PARA LA FUNCIONALIDAD realizarReserva
        self._producto= productos
        self._productos = [] #array con productos
        self._servicios = servicios  #array con servicios
        self._fechaPedido = fechaPedido #fecha del pedido
        self._codigo = Pedido._totalPedidos        #codigo del pedido
        Pedido._pedidos.append(self)
        Pedido._totalPedidos+=1




    #GETTERS Y SETTERS


    def getTrabajador(self):
        return self._trabajador

    def setTrabajador(self, trabajador):
        self._trabajador = trabajador

    def getCliente(self):
        return self._cliente

    def setCliente(self, cliente):
        self._cliente = cliente

    
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

    def setCodigo(self, codigo):
        self.codigo = codigo

    @classmethod
    def getNumeroPedido(cls):
        return cls._numeroPedido

    @classmethod
    def setNumeroPedido(cls, numeroPedido):
        cls._numeroPedido = numeroPedido



#OTROS METODOS






    def sumaProductos(self):
        sumaTotal =0
        for producto in self.getProductos():
            sumaTotal+=producto.getPrecioVenta()
        return sumaTotal

    def sumaServicios(self):
        sumaTotal =0
        for servicio in self.getServicios():
            sumaTotal+=servicio.getPrecio()
        return sumaTotal
    @staticmethod
    def mostraPedidos():
        s =""
        i =1
        for pedido in Pedido.getPedidos():
            if pedido.getEstadoPedido() is "No pagado":
                productos =pedido.sumaProductos()
                servicios =pedido.sumaServicios()
                s+="\n"+"Codigo de pedido: "+pedido.getCodigo()+", Cliente: "+ pedido.getCliente().getNombre()+", Valor total: "+str(productos+servicios)
                i += 1
        return s

    @staticmethod
    def seleccionarPedido(codigo):
        pedido1 =None
        for pedido in Pedido.getPedidos():
            if pedido.getCodigo()==codigo:
                pedido1=pedido
                break
        return pedido1



    


    