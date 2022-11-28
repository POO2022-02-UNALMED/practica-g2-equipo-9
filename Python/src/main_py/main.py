from tkinter import *
from tkinter import ttk
from tkinter.font import Font

from Python.src.gestorAplicacion_py.gestion.Producto import Producto
from Python.src.main_py.funcionalidadesBalanceContable import conseguir_mes
from Python.src.main_py.funcionalidadesBalanceContable import balance_ventas
from Python.src.main_py.manejoErrores import Validador

root = Tk()
root.geometry('800x550')
root.resizable(0, 0)  # Manterner la ventana con tamaño fijo



##funciones para eventos
lista_img=[PhotoImage(file='img1.png'), PhotoImage(file='img2.png'), PhotoImage(file='img3.gif'), PhotoImage(file='img4.gif'), PhotoImage(file='img5.png')]
contadorImg = 0
motion_counter = 0

#imagenRelacionadaButon.bind('<Motion>', cambiarImagenesFrameP4)
img = PhotoImage(file='img1.png', )


hojasDeVida = [PhotoImage(file='cv1.png'), PhotoImage(file='cv2.png'), PhotoImage(file='cv3.png'), PhotoImage(file='cv4.png'), PhotoImage(file='cv5.png')]
contadorVida=0

#listas con las 4 fotos de cada programador
fotosRussbell = [PhotoImage(file='fotoRussbell.png'), PhotoImage(file='fotoRussbell.png'), PhotoImage(file='fotoRussbell.png'), PhotoImage(file='fotoRussbell.png')]
fotosSergio=[PhotoImage(file='kevin.png'), PhotoImage(file='kevin.png'), PhotoImage(file='kevin.png'), PhotoImage(file='kevin.png')]
fotosValentina=[PhotoImage(file='fotoValentina.png'), PhotoImage(file='fotoValentina.png'), PhotoImage(file='fotoValentina.png'), PhotoImage(file='fotoValentina.png')]
fotosKevin=[PhotoImage(file='fotoRussbell.png'), PhotoImage(file='fotoRussbell.png'), PhotoImage(file='fotoRussbell.png'), PhotoImage(file='fotoRussbell.png')]
fotosYolian=[PhotoImage(file='kevin.png'), PhotoImage(file='kevin.png'), PhotoImage(file='kevin.png'), PhotoImage(file='kevin.png')]
fotosProgramadores = [fotosRussbell, fotosSergio, fotosValentina, fotosKevin, fotosYolian]
imgvid = PhotoImage(file='cv1.png')

#barra de menu
def evento():
    pass

def salir():
    root.destroy()

def limpiarVentana():
    for widget in root.winfo_children():
        widget.destroy()


def dibujar_ventana_inicio():
    limpiarVentana()
    frameP1 = Frame(root, background='black')
    frameP2 = Frame(root, background='black')




    frameP1.config(width=400, height=400, padx=5, pady=5, borderwidth=2, relief='groove')
    frameP1.pack(side='left')
    frameP2.config(padx=5, borderwidth=2, relief='groove')
    frameP2.pack(side='right')
    frameP3 = Frame(frameP1, background='#BDBDBD')
    frameP3.config(width=400, height=150, padx=5, pady=5, relief='groove', borderwidth=0, bg='#0B5345')
    frameP3.pack_propagate(False)  ##evitar cambiar el tamaño del frame
    frameP3.pack()
    frameP4 = Frame(frameP1, background='black')
    frameP4.config(width=400, height=400, padx=5, pady=5, borderwidth=0, relief='groove')
    frameP4.pack_propagate(False)
    frameP4.pack()

    frameP5 = Frame(frameP2)
    frameP5.pack_propagate(False)
    frameP5.config(width=400, height=275, padx=5, bg='black', borderwidth=2, relief='groove')
    frameP5.pack()
    frameP6 = Frame(frameP2)
    # frameP6.pack_propagate(False)
    frameP6.config(width=400, height=275, bg='#BDBDBD', borderwidth=2, relief='groove')
    frameP6.columnconfigure(0, weight=1)
    frameP6.columnconfigure(1, weight=1)
    frameP6.rowconfigure(0, weight=1)
    frameP6.rowconfigure(1, weight=1)

    frameP6.pack()

    ##Fonts
    saludoFont = Font(family='Arial TUR', size=18)

    ##Labels
    saludoLabel = Label(frameP3, text='Bienvenido a UNBar', fg='#A2D9CE')
    saludoLabel.config(font=saludoFont, bg='#0B5345')
    saludoLabel.pack(anchor=CENTER, pady=45)

    ventanaPrincipalButon = Button(frameP4, text='Ventana Principal', font=saludoLabel, bg='#0B5345', fg='#A2D9CE',
                                   borderwidth=5, relief='groove')
    ventanaPrincipalButon.config(pady=5)
    ventanaPrincipalButon.pack(fill='x', side='bottom')

    imagenRelacionadaButon = Button(frameP4, width=400, height=350, borderwidth=5, relief='groove')
    imagenRelacionadaButon.pack(side='top')

    def cambiarImagenesFrameP4(event):
        global contadorImg
        global lista_img
        global motion_counter
        if motion_counter < 50:
            motion_counter += 1

        else:
            img = lista_img[contadorImg]
            imagenRelacionadaButon.config(image=img)
            if contadorImg < 4:
                contadorImg += 1
            else:
                contadorImg = 0
            motion_counter = 0
    imagenRelacionadaButon.config(image=img)
    imagenRelacionadaButon.bind('<Motion>', cambiarImagenesFrameP4)

    label1FrameP6 = Label(frameP6, bg='black', width=200, height=137.5, image=fotosRussbell[0])
    label1FrameP6.grid(row=0, column=0)
    label2FrameP6 = Label(frameP6, bg='black', width=200, height=137.5, image=fotosRussbell[0])
    label2FrameP6.grid(row=0, column=1)
    label3FrameP6 = Label(frameP6, bg='black', width=200, height=137.5, image=fotosRussbell[0])
    label3FrameP6.grid(row=1, column=0)
    label4FrameP6 = Label(frameP6, bg='black', width=200, height=137.5, image=fotosRussbell[0])
    label4FrameP6.grid(row=1, column=1)
    botonP5 = Button(frameP5, width=400, height=275, borderwidth=1, relief='groove', bg='black')
    botonP5.pack(side='top')
    botonP5.config(image=imgvid)


    def cambiarHojasDeVida(event):  # funcion para cambiar hojas de vida y fotos de los programadores
        global contadorVida
        botonP5.config(image=hojasDeVida[contadorVida])
        label1FrameP6.config(image=fotosProgramadores[contadorVida][0])
        label2FrameP6.config(image=fotosProgramadores[contadorVida][1])
        label3FrameP6.config(image=fotosProgramadores[contadorVida][2])
        label4FrameP6.config(image=fotosProgramadores[contadorVida][3])
        if contadorVida < 4:
            contadorVida += 1
        else:
            contadorVida = 0

    botonP5.bind('<Button-1>', cambiarHojasDeVida)

    def quitDescription():
        root.update()
        for widget in frameP6.winfo_children():
            widget.destroy()
        dibujar_ventana_inicio()

    def mostrarDescripcion():
        for widget in frameP6.winfo_children():
            widget.destroy()

        labelDescripcion = Label(frameP6, bg='black', text='Sistema orientado a la administracion\n'
                                                           ' de una discoteca, en el que se\n podra realizar y '
                                                           'modificar reservas\n y consultar ventas '
                                 , fg='white')
        labelDescripcion.config(font=saludoFont)
        labelDescripcion.pack(fill='y', side='top')
        salirBoton = Button(frameP6, text='Salir de la descripcion', font=saludoLabel, bg='#0B5345', fg='#A2D9CE',
                            borderwidth=5, relief='groove')
        salirBoton.pack(fill='x', side='bottom')
        salirBoton.config(command=quitDescription)

    menuBar = Menu(root)
    root.config(menu=menuBar)

    Inicio = Menu(menuBar)
    menuBar.add_cascade(label="Inicio", menu=Inicio, command=evento)

    Inicio.add_command(label='Salir', command=salir)

    Inicio.add_command(label='Descripcion', command=mostrarDescripcion)
    ventanaPrincipalButon.config(command=dibujar_ventana_usuario)

def crearMenuUser():

    menuBar = Menu(root)
    root.config(menu=menuBar)

    Archivo = Menu(menuBar)
    menuBar.add_cascade(label="Inicio", menu=Archivo, command=evento)
    Archivo.add_command(label='Aplicacion')
    Archivo.add_command(label='Salir', command=dibujar_ventana_inicio)

    Procesos_Consultas = Menu(menuBar)
    menuBar.add_cascade(label='Procesos y consultas', menu=Procesos_Consultas, command=evento)
    Procesos_Consultas.add_command(label='Realizar reserva', command=realizarReserva)
    Procesos_Consultas.add_command(label='Modificar reserva')
    Procesos_Consultas.add_command(label='Gestionar nomina')
    Procesos_Consultas.add_command(label='Balance', command=balance)

    Ayuda = Menu(menuBar)
    menuBar.add_cascade(label='Ayuda', menu=Ayuda, command=evento)
    Ayuda.add_command(label='Acerca de')


def dibujar_ventana_usuario():
    limpiarVentana()
    root.title('UN Bar')
    crearMenuUser()

    def aplicacionDialog():
        pass


def realizarReserva():
    limpiarVentana()
    crearMenuUser()

    #fonts
    fontNombre = Font(size=15, family='Arial TUR' )


    ##cracion de 3 divisiones en ventana
    frameUser = Frame(root, bg='gray', width=800, height=550)
    frameUser.pack()
    frameU1 = Frame(frameUser, bg='#0B5345', width=800, height=50 ) #nombre
    frameU1.pack_propagate(False)
    frameU1.pack()
    frameU2 = Frame(frameUser, bg='black', width=800, height=100)# descripcion
    frameU2.pack()
    frameU3 = Frame(frameUser, bg='gray', width=800, height=400) #zona interaccion
    frameU3.pack()

    #widgets internos de cada division
    frameU11 = Frame(frameU1, width=400, height=30, padx=5, bg='#0B5345')
    frameU11.pack(side='bottom', pady=10)
    labelRealizarReserva = Label(frameU11, text='Realizar reserva', font=fontNombre, bg='#0B5345')
    labelRealizarReserva.config(fg='#A2D9CE')
    labelRealizarReserva.pack()



def balance():
    limpiarVentana()
    crearMenuUser()

    # fonts
    fontNombre = Font(size=15, family='Arial TUR')

    ##cracion de 3 divisiones en ventana
    frameUser = Frame(root, bg='gray', width=800, height=550)
    frameUser.pack()
    MESES = {"Enero": 1, "Febrero": 2, "Marzo": 3, "Abril": 4, "Mayo": 5, "Junio": 6, "Julio": 7, "Agosto": 8,
             "Septiembre": 9, "Octubre": 10, "Noviembre": 11, "Diciembre": 12}

    cmbMesesVar = StringVar()

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
        # pasarle la funcion de precio
        if validador.getValidacion():
            lblResultado.config(text=str(balance_ventas(mesIndex)))

    framePrincipal = ttk.Frame(frameUser)
    frameInput = ttk.Frame(framePrincipal)
    frameInputbtn = ttk.Frame(framePrincipal)
    lblTitulo = ttk.Label(framePrincipal, text="Balance Contable", font=("Segoe UI", 20))
    lblDescripcion = ttk.Label(framePrincipal,
                               text="Selecciona un mes del menu desplegable para saber cuanto se ha vendido")
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


# frameBalance.pack()



user_img = PhotoImage(file='user_img.png')



if __name__ == '__main__':
    producto1 = Producto("coca", "vendido", 400, 2, None, None, 0)
    producto2 = Producto("coca1", "vendido", 500, 2, None, None, 0)
    producto3 = Producto("coca1", "vendido", 500, None, None, None, 0)
    producto4 = Producto("coca1", "vendido", 500, 3, None, None, 0)
    dibujar_ventana_inicio()
    root.mainloop()
