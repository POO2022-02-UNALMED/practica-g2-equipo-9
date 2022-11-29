from tkinter import messagebox

class ExceptionPopUp():
    def __init__(self, mensaje):
        self._mensaje = mensaje
        messagebox.showerror(title = "Error en la aplicación", message = mensaje)


class CampoVacioException(Exception):
    def __init__(self, message="Error: Debes de llenar todos los datos del formulario"):
        self.message = message
        super().__init__(self.message)


class MesNoEncontradoException(Exception):
    def __init__(self, message="Error: mes ingresado no valido"):
        self.message = message
        super().__init__(self.message)

class stringException(Exception):
    def __init__(self, message="Error: has ingresado un String"):
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

    def validarMesDisponible(self, mes, mesesDisponibles):
        try:
            if mes not in mesesDisponibles:
                self._esValido = False
                raise MesNoEncontradoException

            self._esValido = True
        except MesNoEncontradoException as e:
            ExceptionPopUp(e)




    def validarEntradaString(self, mes):
        try:
            if type(mes)==str:
                self._esValido = False
                raise stringException

            self._esValido = True
        except stringException as e:
            ExceptionPopUp(e)

if __name__ == '__main__':
    validador = Validador()
    validador.validarEntradaString()
    print(validador)

    value = 'Yes String'
    if type(value) == str:
        print("True")
    else:
        print("False")