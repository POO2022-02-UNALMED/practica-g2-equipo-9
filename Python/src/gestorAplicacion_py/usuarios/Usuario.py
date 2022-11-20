class Usuario():
    def __init__(self,codigo,nombre):

        #Atributos de instancia
        self._codigo = codigo
        self._nombre = nombre
        
        
lista_de_usuarios=[]
lista_de_usuarios.append(Usuario)



def usuarios():
     u=0
     while u < len(lista_de_usuarios):
        print(lista_de_usuarios[u].codigo," ",lista_de_usuarios[u].nombre)
        u+=1

def getCodigo(self):
    return self._codigo

def setCodigo(self, codigo):
    self._codigo = codigo

def getNombre(self):
    return self._nombre

def setNombre(self, nombre):
    self._Nombre = nombre

# falta metodo get y set para la lista

# no se para que pusieron el toString o si es necesrio 
#porfa si es necesario ponerlo aqui _________
    