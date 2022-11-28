from Python.src.gestorAplicacion_py.usuarios import *

#
#*Clase creada para representar los productos fisicos
#*para cada unidad de cada producto se crea un objeto de tipo Producto
#* Un pedido puede contener muchos productos
#*
#


class Producto:



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

    def __init__(self, nombre, estado, precioVenta,mesVenta,tipo, trabajador,codigo):
        self._nombre = nombre
        self._estado=estado #"VENDIDO" "NO VENDIDO"
        self._precioVenta = precioVenta
        self._mesVenta=mesVenta
        self._tipo = tipo
        self._trabajador = trabajador
        self._codigo=codigo
        self._productos.append(self)
        Producto._numeroProducto+=1



    def descripcionProducto(self):
        return "\nNombre: " + self.getNombre() + "\nCodigo: " + str(self.getCodigo()) + "\nPrecio venta: " + str(self.getPrecioVenta())

    #GETTERS Y SETTERS

    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getEstado(self):
        return self._estado

    def setEstado(self, estado):
        self._estado=estado


    def getPrecioVenta(self):
        return self._precioVenta

    def setPrecioVenta(self, precioVenta):
        self._precioVenta = precioVenta


    def getMesVenta(self):
        return self._mesVenta
    def seMesVenta(self,mesventa):
        self._mesVenta=mesventa


    def getTipo(self):
        return self._tipo
    def setTipo(self,tipo):
        self._tipo=tipo

    def getTrabajador(self):
        return self._trabajador
    def setTrabajador(self,trabajador):
        self._trabajador=trabajador

    def getCodigo(self):
        return self._codigo
    def setCodigo(self,codigo):
        self._codigo=codigo

    @staticmethod
    def getNumeroProducto():
        return Producto._numeroProducto

    @staticmethod
    def setNumeroProducto(numeroProducto):
        Producto._numeroProducto = numeroProducto

    @staticmethod
    def getProductos():
        return Producto._productos

    @staticmethod
    def setProductos(productos):
        Producto._productos=productos



