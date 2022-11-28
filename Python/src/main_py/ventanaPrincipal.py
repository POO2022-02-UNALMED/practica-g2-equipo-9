import tkinter as tk
import os
import pathlib


path = os.path.join(pathlib.Path(__file__).parent.absolute())
class VentanaPrincipal(tk.Tk):

    def __init__(self):
        super().__init__()
        self.title("UNbar")
        self.geometry("800x600")
        self.option_add("*tearOff", False)

        #creacion de la barra de menus

        self.menuBar=tk.Menu(self)
        self.config(menu=self.menuBar)

        #Primer menu:
        #Archivo: aplicacion, guardar y salir
        menu1=tk.Menu(self.menuBar)
        self.menuBar.add_cascade(label="Archivo", menu=menu1)
        menu1.add_command(label="Aplicacion")

        #Segundo menu:
        #Funcionalidades del sistema
        menu2 = tk.Menu(self.menuBar)
        self.menuBar.add_cascade(label="Procesos y Consultas",menu=menu2)

        #Tercer Menu
        #Ayuda:Acerca de
        menu3 = tk.Menu(self.menuBar)
        self.menuBar.add_cascade(label="Ayuda", menu=menu3)

        # Frame por default
        self.frame1 = tk.Frame(self)
        self.frame1.pack()
        with open(path + "/textos/interfaz_inicio.txt", "r") as f:
            texto = f.read()
        texto_inicial = tk.Text(self.frame1)
        texto_inicial.insert("1.0", texto)
        texto_inicial.pack(expand=True, anchor="n", padx=20, pady=20)

        self.frame2 = tk.Frame(self)
        self.frame2.pack()


        self.mainloop()

        def volver(self):
            self.destroy()
            #volver a ventana de inicio







if __name__=='__main__':
    VentanaPrincipal()
