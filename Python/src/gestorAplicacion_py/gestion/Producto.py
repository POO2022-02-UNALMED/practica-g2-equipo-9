from gestorAplicacion.usuarios import *

#
#*Clase creada para representar los productos fisicos
#*para cada unidad de cada producto se crea un objeto de tipo Producto
#* Un pedido puede contener muchos productos
#*
#


class Producto:

    def _initialize_instance_fields(self):
        
        self._trabajador = None
        self._cliente = None
        self._estado = None
        self._nombre = None
        self._precioVenta = 0
        self._codigo = 0
        self._fechaVenta = None
        self._tipo = 0


    _SERIALVERSIONUID = 1


    #ATRIBUTOS INSTANCIA



    #ATRIBUTOS DE CLASE

    _productos = [] #ARRAYLIST DONDE SE GUARDAN TODOS LOS PRODUCTOS
    _numeroProducto = 0

    _bebidasAlcoholicas = [] # En esta lista va la primera instancia de un nuevo producto de tipo bebidasAlcoholicas, es decir no se puede repetir
    _bebidasNoAlcoholicas = [] # En esta lista va la primera instancia de un nuevo producto de tipo bebidasNoAlcoholicas, es decir no se puede repetir
    _comidas = [] # En esta lista va la primera instancia de un nuevo producto de tipo comidas, es decir no se puede repetir
    _snacks = [] # En esta lista va la primera instancia de un nuevo producto de tipo snacks, es decir no se puede repetir
    _cigarrillos = [] # En esta lista va la primera instancia de un nuevo producto de tipo cigarrillos, es decir no se puede repetir
    _energizantes = [] # En esta lista va la primera instancia de un nuevo producto de tipo energizantes, es decir no se puede repetir
    _otrosProductos = [] # En esta lista va la primera instancia de un nuevo producto de tipo otrosProductos, es decir no se puede repetir





    #CONSTRUCTOR


    def __init__(self):
        self._initialize_instance_fields()

        Producto._numeroProducto += 1
        self._codigo = Producto._numeroProducto
        gestorAplicacion.gestion.Producto._productos.append(self)

    def __init__(self, nombre, estado, precioVenta, tipo):
        self()
        self._nombre = nombre
        self._estado=estado
        self._precioVenta = precioVenta
        self._tipo = tipo
        gestorAplicacion.gestion.Producto.categorizarProducto(self)


    def __init__(self, trabajador, estado, nombre, precioVenta, fechaVenta):
        self._initialize_instance_fields()

        self._trabajador = trabajador
        self._estado = estado
        self._nombre = nombre
        self._precioVenta = precioVenta
        self._codigo = gestorAplicacion.gestion.Producto.generarCodigo()
        self._fechaVenta = fechaVenta
        gestorAplicacion.gestion.Producto._productos.append(self)


    def __init__(self, trabajador, cliente, estado, nombre, precioVenta, fechaVenta, tipo):
        self._initialize_instance_fields()

        Producto._numeroProducto += 1
        self._trabajador = trabajador
        self._cliente = cliente
        self._estado = estado
        self._nombre = nombre
        self._precioVenta = precioVenta
        self._codigo = Producto._numeroProducto
        self._fechaVenta = fechaVenta
        self._tipo = tipo
        gestorAplicacion.gestion.Producto._productos.append(self)
        gestorAplicacion.gestion.Producto.categorizarProducto(self)


    @staticmethod
    def generarCodigo():

        tempVar = gestorAplicacion.gestion.Producto._numeroProducto
        gestorAplicacion.gestion.Producto._numeroProducto += 1
        return tempVar


    def descripcionProducto(self):
        return "\nNombre: " + self.getNombre() + "\nCodigo: " + str(self.getCodigo()) + "\nPrecio venta: " + str(self.getPrecioVenta())

    #GETTERS Y SETTERS

    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getPrecioVenta(self):
        return self._precioVenta

    def setPrecioVenta(self, precioVenta):
        self._precioVenta = precioVenta

    def getCodigo(self):
        return self._codigo

    def setCodigo(self, codigo):
        self._codigo = codigo

    @staticmethod
    def getNumeroProducto():
        return gestorAplicacion.gestion.Producto._numeroProducto

    @staticmethod
    def setNumeroProducto(numeroProducto):
        Producto._numeroProducto = numeroProducto


    @staticmethod
    def getProductos():
        return gestorAplicacion.gestion.Producto._productos

    @staticmethod
    def setProductos(productos):
        Producto._productos = productos

    def getTrabajador(self):
        return self._trabajador

    def setTrabajador(self, trabajador):
        self._trabajador = trabajador


    def getEstado(self):
        return self._estado

    def setEstado(self, estado):
        self._estado = estado


    def getCliente(self):
        return self._cliente

    def setCliente(self, cliente):
        self._cliente = cliente

    def getTipo(self):
        return self._tipo


