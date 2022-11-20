from gestorAplicacion_py.usuarios.Empleado import Empleado

class Gerente(Empleado):

    _numeroGerente=0
    _Gerentes = []

    def __init__(self, codigo, nombre, cargo, sueldo, fechaIngreso, _seguro):
        super().__init__(codigo, nombre, cargo, sueldo, fechaIngreso)

        self._seguro = _seguro

    #preguntar por lo del genetrador de codigo

    def generarCodigo(cls):
        m=cls._numeroGerente+1
        print (m)

    generarCodigo