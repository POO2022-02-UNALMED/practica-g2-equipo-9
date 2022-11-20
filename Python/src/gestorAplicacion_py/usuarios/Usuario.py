class Usuario():

    _usuarios = []

    def __init__(self,codigo,nombre):

        #Atributos de instancia
        self._codigo = codigo
        self._nombre = nombre
         
    
        
@classmethod
def getlista_usuarios(cls):
    return cls._usuarios

@classmethod
def setlista_usuarios(cls, usuarios):
    cls._usuarios = usuarios


def getCodigo(self):
    return self._codigo

def setCodigo(self, Codigo):
    self._codigo = Codigo

def getNombre(self):
    return self.nombre

def setNombre(self, Nombre):
    self.nombre = Nombre


# no se para que pusieron el toString o si es necesrio 
#porfa si es necesario ponerlo aqui _________
    