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
    def generarCodigo(self):

        tempVar = numeroPedido
        numeroPedido += 1
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
        i = 1
        for clave in nombreYprecio.keys():
            productos += "\n" + str(i) + ". Nombre: " + clave + ", Cantidad pedida: " + Collections.frequency(nombre, clave) + "......" + "Precio: "+str(nombreYprecio[clave] * Collections.frequency(nombre, clave))
            i += 1

        productos += "\nTotal de producto:" + str(totalProductos)

        servicios ="Servicios:" + "\nNombre...........Cantidad.........Precio"
        b =1
        totalServicios =0
        servicioNoRepetido = TreeSet()
        for servicio in self.getServicios():
            if servicioNoRepetido.contains(servicio) == False:
                servicios+="\n"+str(b)+". Servicio: "+servicio+", Cantidad: "+ Collections.frequency(self.getServicios(),servicio)+"....."+"Precio: "+Collections.frequency(self.getServicios(),servicio)* servicio.getPrecio()
                b += 1
            totalServicios+=servicio.getPrecio()
            servicioNoRepetido.add(servicio)

        servicios += "\nTotal de servicios:" + str(totalServicios)


        s =""
        s+= "\n=============FACTURA DEL PEDIDO============="+ "\nFactura # "+self.getCodigo()+ "\nFecha: "+self.getFechaPedido()+ "\nNombre cliente: "+self.getCliente().getNombre()+ "\nVendido por "+self.getTrabajador().getNombre()+" con codigo "+self.getTrabajador().getCodigo()+ "\n"+productos+ "\n"+servicios+ "\nTotal:"+ str(totalProductos+totalServicios)+ "\n==========================================="
        return s

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



    


    