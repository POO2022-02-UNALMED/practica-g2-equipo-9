class Producto:

    _productos = []
    _numeroProducto = 0

def __init__(self,trabajador = None, cliente = None, estado ="", fecchaVenta = None, tipo="" ):
    self._trabajador = trabajador
    self._cliente = cliente
    self._estado = estado 
    self._nombre = nombre 
    self._precioVenta = precioVenta
    self._codigo = codigo 
    self._fechaVenta = fechaVenta
    self._tipo = tipo

    Producto._productos.append(self)

    
def getTrabajador(self):
    return self._trabajador

def setTrabajador(self, trabajador):
    self._trabajador = trabajador

def getCliente(self):
    return self._cliente 

def setCliente(self, cliente):
    self._cliente = cliente 

def getEstado(self):
    return self._estado 

def setEstado(self, estado):
    self._estado = estado

def getNombre(self):
    return self._nombre

def setNombre(self, nombre):
    self._nombre = nombre 

def getPrecioVenta(self):
    return self._precioVenta

def setPrecioVenta(self, precioVenta):
    self._precioVenta = precioVenta 

def getCodigo(Self):
    return self._codigo

def setCodigo(self, codigo):
    self._codigo = codigo 

def getFechaVenta(self):
    return self._fechaVenta 

def setFechaVenta(self, fechaVenta):
    self._fechaVenta = fechaVenta 

def getTipo(self):
    return self._tipo

def setTipo(self, tipo):
    self._tipo = tipo

@classmethod
def getProductos(cls):
    return cls._productos

@classmethod
def setProductos(cls, productos):
    cls.productos = productos

@classmethod
    def getNumeroProductos(cls):
        return cls._numeroProducto

@classmethod
    def setNumeroPedido(cls, numeroProducto):
        cls._numeroProducto = numeroProducto



    
