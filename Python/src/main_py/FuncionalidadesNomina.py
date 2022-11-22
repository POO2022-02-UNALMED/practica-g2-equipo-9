
from gestorAplicacion.gestion import Pedido
from gestorAplicacion.gestion import Producto
from gestorAplicacion.gestion import Servicio
from gestorAplicacion.usuarios import Cliente
from gestorAplicacion.usuarios import Gerente
from gestorAplicacion.usuarios import Sueldo
from gestorAplicacion.usuarios import Trabajador

from sortedcontainers import SortedSet
from sortedcontainers import TreeSet

import datetime

from tkinter import *
from tkinter import ttk
from tkinter import font



from treeset import TreeSet



class FuncionalidadesNomina(Pedido, Producto, Servicio, Cliente, Gerente, Sueldo, Trabajador):
    def __init__(self, entrada, opcion, salir, mesSeleccionado):
        self.entrada=entrada
        self.opcion=opcion
        self.salir=salir
        self.mesSeleccionado= mesSeleccionado

    def calculoDeNomina():
        entrada = int(input())
        print("=====================BIENVENIDO AL MENU DE NOMINA====================")
        opcion= opcion
        salir=False

        while(salir==False):
            ts = TreeSet()
            sorted_set = SortedSet(fechas)
            ##guardamos las fechas de productos de los que se tengan conocimiento de venta

            for producto in Producto.getProductos():
                if producto.getFechaVenta()!=None:
                    fechas.append(producto.getFechaVenta().getMonthValue())
            
            ##guardamos las fechas de servicios de los que se tengan conocimiento de venta
            for e in Pedido.getPedidos():
                if e.getFechaPedido()!=None:
                    fechas.append(e.getFechaPedido().getMonthValue())
    
            meses={1:"Enero", 2:"Febrero", 3:"Marzo", 4:"Abril", 5:"Mayo", 6:"Junio", 7:"Julio", 8:"Agosto", 9:"Septiembre", 10:"Octubre", 11:"Noviembre", 12:"Diciembre"}

            opcionMeses={}

            print("Fechas Disponibles:")
            i= 1
            for numeroMes in fechas:
                ##aqui se muestran las fechas de las que se tiene conocimiento de ventas realizadas
                print("["+i+"]"+" "+meses.get(numeroMes)+" de "+2022)
                opcionMeses={i,numeroMes}
                i+=1
            
            print("[0] Volver atras")
            ##Obtengo la fecha escogida
            print("Por favor ingresa una opcion:")
            opcion=entrada
            while(opcion<0):
                opcion>len(opcionMeses)
                print("Opcion no valida, ingresa de nuevo un numero")
                opcion= entrada
            
            if(opcion>=1 and opcion<=len(opcionMeses)):
                mesSeleccionado=opcionMeses.get(opcion)
                print("Mes escogido: "+meses.get(mesSeleccionado))

                ##Seleccionar trabajador
                print("Selecciona trabajador a liquidar:")

                print(Trabajador.mostrarTrabajadores())
                print("Ingresa codigo del trabajador: ")

                codigo = entrada ##codigo de empleado
                ##buscamos el codigo del trabajador
                trabajadorSeleccionado=Trabajador.seleccionarTrabajador(codigo)
                while(trabajadorSeleccionado==None):
                    print("Codigo de trabajador no existe, ingrese uno valido")
                    codigo= entrada
                    trabajadorSeleccionado=Trabajador.seleccionarTrabajador(codigo)
                
                print(nominaEmpleado(mesSeleccionado,trabajadorSeleccionado))
                print()
                print("Presiona 0 para volver atras y ver la contabilidad de otros meses")
                opcion= entrada
                while(opcion!=0):
                    print()
                    print("Opcion incorrecta, presione 0 para volver")
                    opcion= entrada
                
            
            elif(opcion==0):
                salir=True
            
        



    
    def nominaEmpleado():
        ##PRODUCTOS QUE VENDIO EL EMPLEADO

        Ts= SortedSet(nombresProductosNoRepetidos)
        nombresProductosRepetidos= []
        comisionProductosTrabajador=0
        totalProductos=0
        for producto in Producto.getProductos():
            if producto.getFechaVenta()!=None:
                if producto.getFechaVenta().getMonthValue()== mesSeleccionado and producto.getTrabajador()==trabajadorSeleccionado and producto.getEstado().equals("Vendido"):
                    comisionProductosTrabajador+=producto.getPrecioVenta()* Sueldo.porcentajeComisionProductos
                    nombresProductosRepetidos.append(producto.getNombre())
                    nombresProductosNoRepetidos.append(producto.getNombre())
                    totalProductos+=producto.getPrecioVenta()
                
            

        

        nombreYcantidadProductos="Nombre del producto..............Cantidad"
        for nombre in nombresProductosNoRepetidos:
            nombreYcantidadProductos+="\n"+nombre+"....................."+Collections.frequency(nombresProductosRepetidos,nombre)
        

        ##SERVICIOS QUE VENDIO EL EMPLEADO
        comisionServiciosTrabajador=0
        totalServicio=0
        ts= SortedSet(nombresServiciosNoRepetidos)
        nombresServiciosRepetidos= []
        for e in Pedido.getPedidos():
            if e.getFechaPedido()!=None:
                if e.getFechaPedido().getMonthValue()==mesSeleccionado and e.getTrabajador()==trabajadorSeleccionado and e.getEstadoPedido().equals("Pagado"):
                    for servicio in e.getServicios():
                        comisionServiciosTrabajador+=servicio.getPrecio()*Sueldo.porcentajeComisionServicios
                        nombresServiciosRepetidos.append(servicio)
                        nombresServiciosNoRepetidos.append(servicio)
                        totalServicio+=servicio.getPrecio()
                    
                
            

        
        nombreYcantidadServicios="Nombre del servicio..............Cantidad"
        for nombre in nombresServiciosNoRepetidos:
            nombreYcantidadServicios+="\n"+nombre+"....................."+Collections.frequency(nombresServiciosRepetidos,nombre)
        
        meses={1:"Enero", 2:"Febrero", 3:"Marzo", 4:"Abril", 5:"Mayo", 6:"Junio", 7:"Julio", 8:"Agosto", 9:"Septiembre", 10:"Octubre", 11:"Noviembre", 12:"Diciembre"}


        total=trabajadorSeleccionado.getSueldo()+comisionProductosTrabajador+comisionServiciosTrabajador
        s=""
        s+="\n "+"\n "+"\n ================================================================== "+"\n                     Pago al trabajador con " + trabajadorSeleccionado+"\n ================================================================== "+"\n  "+"\n lista de productos y cantidades vendidas por el empleado :\n"+ nombreYcantidadProductos+"\n  Total de productos vendidos por el empledo: "+totalProductos+"\n La comision por producto vendido es del "+Sueldo.porcentajeComisionProductos*100+"%"+"\n Por lo que obtiene en comisiones de productos un total de: "+comisionProductosTrabajador+"\n lista de servicios y cantidades vendidas por el empleado :\n"+ nombreYcantidadServicios+"\n  Total de servicios vendidos por el empledo: "+totalServicio+"\n La comision por producto vendido es del "+Sueldo.porcentajeComisionServicios*100+"%"+"\n Por lo que obtiene en comisiones de servicios un total de: "+comisionServiciosTrabajador+"\n El trabajador tiene un sueldo base de: "+trabajadorSeleccionado.getSueldo()


        if meses.get(mesSeleccionado)=="Junio":
            meses.get(mesSeleccionado)=="Diciembre"
            primaTrabajador=trabajadorSeleccionado.calculoDePrima()
            total+=primaTrabajador
            s+="\nPago de Prima a Empleados: "+primaTrabajador

        
        s+="\n-------------------------------"+"\n\nEl sueldo total a pagar del mes de "+meses.get(mesSeleccionado)+" es de: "+total
        return s
    
##Interfaz gráfica
def VentanaEntrada():
    ventanaEntrada = Tk()
    ventanaEntrada.title("Nómina")
    ventanaEntrada.geometry("700x500")
    frame=Frame(ventanaEntrada, width=700, height=500)
    frame.pack(expand=True)
    label1= Label(frame, text="Empleado:")
    label1.configure(font=("Courier", 15, "bold","italic"))
    entrada1= Entry(frame, textvariable= StringVar)
    label1.place(x=100, y=200, width=200, height=50)
    entrada1.place(x=350, y=200, width=200, height=50)
    button2= Button(ventanaEntrada, text="Salir", command=VentanaInicio)
    button2.configure(font=("Arial", 12, "bold"), bg= "grey")
    button2.place(x=550, y=400, width=100, height=50)
    button1= Button(ventanaEntrada, text="Buscar", command=VentanaFechas)
    button1.configure(font=("Arial", 12, "bold"), bg= "grey")
    button1.place(x=400, y=400, width=100, height=50)

def VentanaInicio():
    ventanaInicio = Tk()
    ventanaInicio.title("Nómina")
    ventanaInicio.geometry("700x500")
    button1= Button(ventanaInicio, text="Buscar", command=VentanaEntrada)
    button1.configure(font=("Arial", 12, "bold"), bg= "grey")
    label= Label(ventanaInicio, text="BIENVENIDO AL MENÚ DE NÓMINA")
    label.configure(font=("Courier", 20, "bold","italic"))
    label.place(x=100, y=150, width=500, height= 100)
    button1.place(x=550, y=400, width=100, height=50)

def VentanaFechas():
    ventanaFechas = Tk()
    ventanaFechas.title("Nómina")
    ventanaFechas.geometry("700x500")
    label= Label(ventanaFechas, text="Fechas disponibles:")
    label.configure(font=("Courier", 15, "bold","italic"))
    label.place(x=100, y=100, width=230, height=100)
    def changed(event):
        entrada.delete(0,"end")
        entrada.insert(0, combo.get())
    valorDefecto= StringVar(value="Fechas disponibles:")
    combo= ttk.Combobox(ventanaFechas, values=["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"], textvariable= valorDefecto)
    combo.bind("a", changed)
    combo.place(x= 100, y=250, width=100, height=50)

    entrada = Entry(ventanaFechas)
    entrada.place(x=250, y=250, width= 200, height=100)


    


ventanaInicio = Tk()
ventanaInicio.title("Nómina")
ventanaInicio.geometry("700x500")
button1= Button(ventanaInicio, text="Iniciar", command=VentanaEntrada)
button1.configure(font=("Arial", 12, "bold"), bg= "grey")
label= Label(ventanaInicio, text="BIENVENIDO AL MENÚ DE NÓMINA")
label.configure(font=("Courier", 20, "bold","italic"))
label.place(x=100, y=150, width=500, height= 100)
button1.place(x=550, y=400, width=100, height=50)
ventanaInicio.mainloop()






ventanaInicio.mainloop()