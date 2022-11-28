from tkinter import messagebox

class ExceptionPopUp():
    def __init__(self, mensaje):
        self._mensaje = mensaje
        messagebox.showinfo(title = "Error en la aplicación", message = mensaje)


class CampoVacioException(Exception):
    def __init__(self, message="Error: Debes de llenar todos los datos del formulario"):
        self.message = message
        super().__init__(self.message)


class MesNoEncontradoException(Exception):
    def __init__(self, message="Error: has seleccionado un mes no valido"):
        self.message = message
        super().__init__(self.message)

class Validador():
    def __init__(self):
        self._esValido = False

    def getValidacion(self):
        return self._esValido

    def validarMesDisponible(self, mes, mesesDisponibles):
        try:
            if mes not in mesesDisponibles:
                self._esValido = False
                raise MesNoEncontradoException
            self._esValido = True
        except MesNoEncontradoException as e:
            ExceptionPopUp(e)