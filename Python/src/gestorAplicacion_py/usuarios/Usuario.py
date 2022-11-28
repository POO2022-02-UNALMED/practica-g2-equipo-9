class Usuario():

    _usuarios = []

    def __init__(self,codigo,nombre):
        #Atributos de instancia
        self._codigo = codigo
        self._nombre = nombre
        Usuario._usuarios.append(self)


         
    
    @classmethod
    def getUsuarios(cls):
        return cls._usuarios

    @classmethod
    def setUsuarios(cls, usuarios):
        cls._usuarios = usuarios


    def getCodigo(self):
        return self._codigo

    def setCodigo(self, Codigo):
        self._codigo = Codigo
        

    
    def getNombre(self):
        return self._nombre
    def setNombre(self, nombre):
        self._nombre=nombre

    #otros metodos
    def generarCodigo(cls):
        return cls._numeroTrabajadores + 1




    