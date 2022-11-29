from tkinter import *
from tkinter import messagebox


# Constructor
# t_C: Titulo para la columna "Criterio"
# c_array: Array con los nombres de los criterios
# t_V: Titulo para la columna "Valor"
# values: Array con los valores iniciales. Si None, no hay valores iniciales
# H_Array: Array con los campos no-editables por el usuario. Si None, todos son editables


class FieldFrame(Frame):
    def __init__(self, wind, t_C="", c_array=None, t_V="", values=None, H_Array=None):
        super().__init__(wind)
        self._tituloValores = t_V
        self._tituloCriterios = t_C
        self._habilitado = H_Array
        self._criterios = c_array
        self._valores = values

        # array components
        self._elementos = []

        # Titulo valores
        labelTituloValores = Label(self, text=t_V, font=("Segoe UI", 14))
        labelTituloValores.grid(column=1, row=0, padx=(10, 10), pady=(10, 10))

        # Titulo criterios
        labelTituloCriterios = Label(self, text=t_C, font=("Segoe UI", 14))
        labelTituloCriterios.grid(column=0, row=0, padx=(10, 10), pady=(10, 10))

        # Crear cada uno de los criterios
        for j in range(len(c_array)):
            # Crear y colocar nombre de cada criterio
            labelCriterio = Label(self, text=c_array[j], font=("Segoe UI", 12))
            labelCriterio.grid(column=0, row=j + 1, padx=(10, 10), pady=(10, 10))

            # Crear y colocar entrada de cada criterio
            entryValor = Entry(self, font=("Segoe UI", 12))
            entryValor.grid(column=1, row=j + 1, padx=(10, 10), pady=(10, 10))

            # Poner valor inicial en caso de existir
            if values is not None:
                entryValor.insert(0, values[j])

            # Habilitar o desabilitar segun los datos ingresados
            if H_Array is not None and not H_Array[j]:
                entryValor.configure(state=DISABLED)

            # Anadir a la lista de elementos
            self._elementos.append(entryValor)

    def getDatos(self, entrada):
        indice = self._criterios.index(entrada)
        return self._elementos[indice].get()

    def createBut(self, txt, cmd, col, fil):
        boton = Button(self, text=txt, command=cmd)
        boton.grid(column=col, row=fil, padx=(10, 10), pady=(10, 10))

    def getElementos(self):
        return self._elementos

    def camposVacios(self):
        vacios = []
        for j, entrada in enumerate(self._elementos):
            if not entrada.get():
                vacios.append(self._criterios[j])

        if len(vacios) > 0:
            cuales = ", ".join(vacios[:-1])
            if len(vacios) > 1:
                cuales += " y " + vacios[-1]
                textoError = f"Los campos {cuales} estan vacios. Por favor completarlos y presionar el boton Aceptar"
            else:
                textoError = f"El campo {vacios[0]} esta vacio. Por favor completarlo y presionar el boton Aceptar"
            messagebox.showerror("Faltan datos por ingresar", textoError)
        else:
            self.validarEntradas()
"""
root = Tk()
root.title('ventana prueba')
frame1 = FieldFrame(root, None, ["Nombre", "Cédula", "ID Boleta"],"Información", None, [True, True, True])
frame1.pack()

def extraerDatos():
    nombre = frame1.getDatos("Nombre")
    id = frame1.getDatos("Cédula")
    print(nombre)
boton = Button(frame1, text='extraer', command=extraerDatos)
boton.grid()
if __name__=='__main__':
    root.mainloop()
"""