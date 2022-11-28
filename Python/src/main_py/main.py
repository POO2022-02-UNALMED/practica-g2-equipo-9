from tkinter import *
from tkinter.font import Font

root = Tk()
root.resizable(0, 0)  # Manterner la ventana con tamaño fijo

frameP1 = Frame(root, background='black')
frameP2 = Frame(root, background='black')

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
    for widget in frameP1.winfo_children():
        widget.destroy()
    for widget in frameP2.winfo_children():
        widget.destroy()

def dibujar_ventana_inicio():
    limpiarVentana()
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
    frameP6.columnconfigure(2);
    frameP6.rowconfigure(2);

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
user_img = PhotoImage(file='user_img.png')
def dibujar_ventana_usuario():
    limpiarVentana()
    frameP1.columnconfigure(2);
    frameP1.rowconfigure(4);
    imgLabel = Label(frameP2, width=400, height=550);
    imgLabel.config(image=user_img);
    imgLabel.pack();
    regresarBoton = Button(frameP1, text='Regresar al\n menu principal', bg='#0B5345', fg='#A2D9CE',
                        borderwidth=5, relief='groove')

    regresarBoton.grid(row=3, column=0);
    regresarBoton.config(command=dibujar_ventana_inicio)

    reservaBoton = Button(frameP1, text='Realizar / Modificar\n Reserva',bg='#0B5345', fg='#A2D9CE',borderwidth=5, relief='groove'  )
    reservaBoton.config(pady=10)
    reservaBoton.grid(row=1, column=0)




if __name__ == '__main__':
    dibujar_ventana_inicio()
    root.mainloop()
