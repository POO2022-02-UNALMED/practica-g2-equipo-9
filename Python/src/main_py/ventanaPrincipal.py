import tkinter as tk
from tkinter import ttk
import os
import pathlib
from Python.src.main_py.funcionalidadesBalanceContable import conseguir_mes
from Python.src.gestorAplicacion_py.gestion.Producto import Producto
from Python.src.main_py.manejoErrores import Validador
from Python.src.gestorAplicacion_py.usuarios.Trabajador import Trabajador

path = os.path.join(pathlib.Path(__file__).parent.absolute())
class VentanaPrincipal(tk.Tk):
    def __init__(self): # self es el root=tk.TK()
        super().__init__()
        self.title("UNbar")
        self.geometry("500x450")
        self.option_add("*tearOff", False)


        #creacion de la barra de menus
        self.menuBar = tk.Menu(self)
        self.config(menu=self.menuBar)

        #Primer menu:
        #Archivo: aplicacion, guardar y salir
        menu1 = tk.Menu(self.menuBar)
        self.menuBar.add_cascade(label="Archivo", menu=menu1)
        menu1.add_command(label="Aplicacion")

        #Segundo menu:
        #Funcionalidades del sistema
        menu2 = tk.Menu(self.menuBar)
        self.menuBar.add_cascade(label="Procesos y Consultas",menu=menu2)
        menu2.add_command(label="Balance contable", command=self.balance)
        menu2.add_command(label="Calculo de nomina", command=self.nomina)

        #Tercer Menu
        #Ayuda:Acerca de
        menu3 = tk.Menu(self.menuBar)
        self.menuBar.add_cascade(label="Ayuda", menu=menu3)

        # Frame por default
        self.contenedor = tk.Frame(self)
        self.contenedor.pack(fill="both", expand=True)
        with open(path + "/textos/interfaz_inicio.txt", "r") as f:
            texto = f.read()
        texto_inicial = tk.Text(self.contenedor)
        texto_inicial.insert("1.0", texto)
        texto_inicial.pack()

        self.mainloop()

    def balance(self):
        self.limpiarFrame(self.contenedor)
        MESES = {"Enero": 1, "Febrero": 2, "Marzo":3, "Abril":4,"Mayo":5,"Junio":6,"Julio":7,"Agosto":8,"Septiembre":9,
                 "Octubre":10,"Noviembre":11,"Diciembre":12}

        cmbMesesVar = tk.StringVar()

        def limpiar():
            cmbMeses.set("")
            lblResultado.config(text="")
        def submit():
            mesesDisponibles = conseguir_mes()
            mesElegido = cmbMesesVar.get()
            mesIndex = MESES[mesElegido] if mesElegido != "" else ""
            # Creamos objeto validador
            validador = Validador()
            # VALIDACIONES:
            validador.validarMesDisponible(mesIndex, mesesDisponibles)

            #pasarle la funcion de precio
            if validador.getValidacion():
                lblResultado.config(text = mesElegido + ": TIENE GANANCIAS CHEVERES")

        framePrincipal = tk.Frame(self.contenedor)
        frameInput = ttk.Frame(framePrincipal)
        frameInputbtn = ttk.Frame(framePrincipal)
        lblTitulo = ttk.Label(framePrincipal, text="Balance Contable", font=("Segoe UI", 20))
        lblDescripcion = ttk.Label(framePrincipal, text="Descripcion...")
        lblMeses = ttk.Label(frameInput, text="Meses disponibles")
        cmbMeses = ttk.Combobox(frameInput, values=list(MESES.keys()), textvariable=cmbMesesVar)
        btnSubmit = ttk.Button(frameInputbtn, text="Submit", command=submit)
        btnLimpiar = ttk.Button(frameInputbtn, text="Limpiar", command=limpiar)
        lblResultado = ttk.Label(framePrincipal, text="")

        framePrincipal.pack()
        lblTitulo.pack(pady=(10, 30))
        lblDescripcion.pack(pady=(0, 20))

        frameInput.pack()
        lblMeses.pack(pady=(0, 10), padx=(0, 40), side="left")
        cmbMeses.pack(pady=(0, 10), side="right")

        frameInputbtn.pack()
        btnSubmit.pack(pady=(0, 10), padx=(0, 30), side="left")
        btnLimpiar.pack(pady=(0, 10), side="right")

        lblResultado.pack()

    def nomina(self):
        self.limpiarFrame(self.contenedor)
        MESES = {"Enero": 1, "Febrero": 2, "Marzo":3, "Abril":4,"Mayo":5,"Junio":6,"Julio":7,"Agosto":8,"Septiembre":9,
                 "Octubre":10,"Noviembre":11,"Diciembre":12}

        cmbMesesVar = tk.StringVar()
        def limpiar():
            cmbMeses.set("")
            lblResultado.config(text="")
        def submit():
            mesesDisponibles = conseguir_mes()
            mesElegido = cmbMesesVar.get()
            mesIndex = MESES[mesElegido] if mesElegido != "" else ""
            # Creamos objeto validador
            validador = Validador()
            # VALIDACIONES:
            validador.validarMesDisponible(mesIndex, mesesDisponibles)

            #pasarle la funcion de precio
            if validador.getValidacion():
                lblResultado.config(text = mesElegido + ": TIENE GANANCIAS CHEVERES")

        framePrincipal = ttk.Frame(self.contenedor)
        frameInputMes = ttk.Frame(framePrincipal)
        frameInputTrabajador = ttk.Frame(framePrincipal)
        frameInputbtn = ttk.Frame(framePrincipal)
        lblTitulo = ttk.Label(framePrincipal, text="Calculo de nomina", font=("Segoe UI", 20))
        lblDescripcion = ttk.Label(framePrincipal, text="Descripcion...")
        lblMeses = ttk.Label(frameInputMes, text="Meses disponibles")
        cmbMeses = ttk.Combobox(frameInputMes, values=list(MESES.keys()), textvariable=cmbMesesVar)
        lblTrabajadores = ttk.Label(frameInputTrabajador, text="Trabajadores")
        cmbTrabajadores = ttk.Combobox(frameInputTrabajador, values=[])
        btnSubmit = ttk.Button(frameInputbtn, text="Submit", command=submit)
        btnLimpiar = ttk.Button(frameInputbtn, text="Limpiar", command=limpiar)
        lblResultado = ttk.Label(framePrincipal, text="")

        framePrincipal.pack()
        lblTitulo.pack(pady=(10, 30))
        lblDescripcion.pack(pady=(0, 20))

        frameInputMes.pack(fill="x")
        lblMeses.pack(pady=(0, 10), padx=(0, 10), side="left")
        cmbMeses.pack(pady=(0, 10), side="right")

        frameInputTrabajador.pack(fill="x")
        lblTrabajadores.pack(pady=(0, 10), padx=(0, 10), side="left")
        cmbTrabajadores.pack(pady=(0, 10), side="right")

        frameInputbtn.pack()
        btnSubmit.pack(pady=(0, 10), padx=(0, 30), side="left")
        btnLimpiar.pack(pady=(0, 10), side="right")

        lblResultado.pack()
    def limpiarFrame(self, frame):
        for widget in frame.winfo_children():
            widget.destroy()

    def volver(self):
        self.destroy()
            #volver a ventana de inicio







if __name__=='__main__':
    producto1 = Producto("coca","Vendido",400,2,None,None,0)
    producto2 = Producto("coca1", "Vendido", 500, 2, None, None, 0)
    producto3 = Producto("coca1", "Vendido", 500,None, None, None, 0)
    producto3 = Producto("coca1", "Vendido", 500, 3, None, None, 0)
    VentanaPrincipal()
