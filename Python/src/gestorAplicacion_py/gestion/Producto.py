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
        self._estado=estado #"vendido" "no vendido"
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
    
    @staticmethod
    def getBebidasAlcoholicas():
        return bebidasAlcoholicas

    @staticmethod
    def setBebidasAlcoholicas(bebidasAlcoholicas):
        Producto.bebidasAlcoholicas = bebidasAlcoholicas

    @staticmethod
    def getBebidasNoAlcoholicas():
        return bebidasNoAlcoholicas

    @staticmethod
    def setBebidasNoAlcoholicas(bebidasNoAlcoholicas):
        Producto.bebidasNoAlcoholicas = bebidasNoAlcoholicas

    @staticmethod
    def getComidas():
        return comidas

    @staticmethod
    def setComidas(comidas):
        Producto.comidas = comidas

    @staticmethod
    def getSnacks():
        return snacks

    @staticmethod
    def setSnacks(snacks):
        Producto.snacks = snacks

    @staticmethod
    def getCigarrillos():
        return cigarrillos

    @staticmethod
    def setCigarrillos(cigarrillos):
        Producto.cigarrillos = cigarrillos

    @staticmethod
    def getEnergizantes():
        return energizantes

    @staticmethod
    def setEnergizantes(energizantes):
        Producto.energizantes = energizantes

    @staticmethod
    def getOtrosProductos():
        return otrosProductos

    @staticmethod
    def setOtrosProductos(otrosProductos):
        Producto.otrosProductos = otrosProductos

    def getFechaVenta(self):
        return fechaVenta

    def setFechaVenta(self, fechaVenta):
        self.fechaVenta = fechaVenta

    @staticmethod
    def categorizarProducto(producto):
        if producto.tipo == 1:
            Producto.verificarExistenciaCategoria(Producto.bebidasAlcoholicas, producto)
        elif producto.tipo == 2:
            Producto.verificarExistenciaCategoria(Producto.bebidasNoAlcoholicas, producto)
        elif producto.tipo == 3:
            Producto.verificarExistenciaCategoria(Producto.comidas, producto)
        elif producto.tipo == 4:
            Producto.verificarExistenciaCategoria(Producto.snacks, producto)
        elif producto.tipo == 5:
            Producto.verificarExistenciaCategoria(Producto.cigarrillos, producto)
        elif producto.tipo == 6:
            Producto.verificarExistenciaCategoria(Producto.energizantes, producto)
        elif producto.tipo == 7:
            Producto.verificarExistenciaCategoria(Producto.otrosProductos, producto)

@staticmethod
def verificarExistenciaCategoria(lista, producto):
    try:
        for value in lista:
            if value.getNombre() is producto.getNombre():
                return
        lista.append(producto)

    except Exception as e:

        pass



@staticmethod
def mostrarProductosDisponibles(listaProducto):
    s = "Este es el inventario de productos disponibles para vender:" + "\nNombre, Cantidad, Precio:"
    productosDisponiblesNoRepetidos = TreeSet()
    productosDisponiblesRepetidos = []
    listaPrecios = {}
    for producto in listaProducto:
        productosDisponiblesNoRepetidos.add(producto.getNombre())
        productosDisponiblesRepetidos.append(producto.getNombre())
        if producto.getNombre() in listaPrecios.keys() == False:
            listaPrecios[producto.getNombre()] = producto.getPrecioVenta()
    i = 1
    for nombre in productosDisponiblesNoRepetidos:
        s += "\n" + str(i) + ". Nombre: " + nombre + ", Cantidad: " + Collections.frequency(productosDisponiblesRepetidos, nombre) + ", Precio: " + str(listaPrecios[nombre])
        i += 1
    return s

@staticmethod
def mostrarNombresCantidadPrecio(productosPedidos):
    s = "Pedido de Productos: " + "\nNombre, Cantidad, Precio:"
    nombresNoRepetidos = TreeSet()
    nombresRepetidos = []
    listaPrecios = {}
    valorTotal = 0
    for producto in productosPedidos:
        nombresNoRepetidos.add(producto.getNombre())
        nombresRepetidos.append(producto.getNombre())
        if producto.getNombre() in listaPrecios.keys() == False:
            listaPrecios[producto.getNombre()] = producto.getPrecioVenta()
        valorTotal += producto.getPrecioVenta()
    i = 1
    for nombre in nombresNoRepetidos:
        s += "\n" + str(i) + ". Nombre: " + nombre + ", Cantidad: " + Collections.frequency(nombresRepetidos, nombre) + ", Precio: " + Collections.frequency(nombresRepetidos, nombre) * listaPrecios[nombre]
        i += 1
    s += "\nValor total de productos= " + str(valorTotal)
    return s
@staticmethod
def productosDisponibles(Inventario):
    productosDisponibles = []
    for producto in Inventario:
        if producto.getEstado() is "No vendido" and producto.getFechaVenta() is None:
            productosDisponibles.append(producto)
    return productosDisponibles

@staticmethod
def verificarProducto(nombre, listaProductos):
    existe = False
    for producto in listaProductos:
        if producto.getNombre() is nombre:
            existe = True
            break
    return existe

@staticmethod
def verificarProducto(nombre, cantidad, listaProductos):
    existe = False
    nombresProducto = []
    for producto in listaProductos:
        nombresProducto.append(producto.getNombre())
    if cantidad >= 0 and cantidad <= Collections.frequency(nombresProducto, nombre):
        existe = True
    return existe

@staticmethod
def agregarProducto(nombre, cantidad, listaProductos):
    productosEscogidos = []
    contador = 0
    for producto in listaProductos:
        if contador < cantidad:
            if producto.getNombre() is nombre:
                productosEscogidos.append(producto)
                contador += 1
        else:
            break
    return productosEscogidos
