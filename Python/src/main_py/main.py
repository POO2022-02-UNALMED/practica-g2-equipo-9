from tkinter import *
from tkinter.font import Font
from Python.src.gestorAplicacion_py.usuarios.Trabajador import Trabajador


root = Tk()
root.resizable(0,0) # Manterner la ventana con tamaño fijo
frameP1 = Frame(root, background='#BDBDBD')
frameP1.config(width=400, height=400, padx=5, pady=5, borderwidth=2, relief='groove')
frameP1.pack(side='left')


frameP2 = Frame(root, background='#D8D8D8')
frameP2.config(width=400, height=400, padx=5, pady=5, borderwidth=2, relief='groove')
frameP2.pack(side='right')

frameP3 = Frame(frameP1, background='#BDBDBD')
frameP3.config(width=400, height=150, padx=5, pady=5, relief='groove', borderwidth=0, bg='#0B5345')
frameP3.pack_propagate(False) ##evitar cambiar el tamaño del frame
frameP3.pack()
frameP4 = Frame(frameP1, background='#D8D8D8')
frameP4.config(width=400, height=400, padx=5, pady=5, borderwidth=0, relief='groove')
frameP4.pack_propagate(False)
frameP4.pack()

frameP5 = Frame(frameP2)
frameP5.config(width=400, height=150, padx=5, pady=5, bg='#BDBDBD', borderwidth=2, relief='groove')
frameP5.pack()
frameP6 = Frame(frameP2)
frameP6.config(width=400, height=400, padx=5, pady=5, bg='#BDBDBD', borderwidth=2, relief='groove')
frameP6.pack()

##Fonts
saludoFont = Font(family='Arial TUR', size=18)

##Labels
saludoLabel = Label(frameP3,text='Bienvenido a UNBar', fg='#A2D9CE')
saludoLabel.config(font=saludoFont, bg='#0B5345')
saludoLabel.pack(anchor=CENTER, pady=45)

#Buttons

ventanaPrincipalButon = Button(frameP4, text='Ventana Principal', font=saludoLabel)
ventanaPrincipalButon.config(pady=5)
ventanaPrincipalButon.pack(fill='x', side='bottom')



if __name__ == '__main__':
    root.mainloop()

