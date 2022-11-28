from abc import ABC, abstractclassmethod

class Sueldo(ABC):
    sueldoBase=100
    porcentajeComisionProductos=0.2
    porcentajeComisionServicios=0.1
    
    def getSueldo(self):
        return self.sueldoBase
    def setSueldo(self,sueldo):
        self.sueldoBase = sueldo

    @abstractclassmethod
    def aumentarSueldo(self):
        pass
    @abstractclassmethod
    def calcularPrima(self):
        pass

# miren si lo siguiente es necesario.
class aumento(Sueldo):
    def __init__(self):
        self.sueldoBase = Sueldo.sueldoBase

    def aumentarSueldo(self):
        aumento = self.sueldoBase * 0.2 + self.sueldoBase *0.1
        return self.sueldoBase + aumento