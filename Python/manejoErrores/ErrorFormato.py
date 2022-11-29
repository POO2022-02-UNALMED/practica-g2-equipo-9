from Python.src.manejoErrores.ErrorAplicacion import ErrorAplicacion

class ErrorFormato(ErrorAplicacion):
    def __init__(self, mensaje):
        self.mensaje_error_fromato = " Error por formato " + mensaje
        super().__init__(self.mensaje_error_fromato)

class CampoVacioException(Exception):
    def __init__(self, message="Error: Debes de llenar todos los datos del formulario"):
        self.message = message
        super().__init__(self.message)


class MesNoEncontradoException(Exception):
    def __init__(self, message="Error: has seleccionado un mes del que no se tienen ventas"):
        self.message = message
        super().__init__(self.message)

class Mesfuerade1a12(Exception):
    def __init__(self, message="Error: has seleccionado un mes fuera de los 12 meses"):
        self.message = message
        super().__init__(self.message)

class Validador1():
    def __init__(self):
        self._esValido = False

    def getValidacion(self):
        return self._esValido

class Validador2():
    def validarMesDisponible(self, mes, mesesDisponibles):
        try:
            if mes not in mesesDisponibles:
                self._esValido = False
                raise MesNoEncontradoException

            self._esValido = True
        except MesNoEncontradoException as e:
            ExceptionPopUp(e)

    def validarMes1a12(self, mes, mesesDisponibles):
        try:
            if mes<1 or mes >12:
                self._esValido = False
                raise Mesfuerade1a12

            self._esValido = True
        except Mesfuerade1a12 as e:
            ExceptionPopUp(e)