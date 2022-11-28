from Python.src.gestorAplicacion_py.gestion.Producto import Producto
from Python.src.gestorAplicacion_py.usuarios.Trabajador import Trabajador




class Nomina:
    @staticmethod
    def busca_ventas_trabajadores():
        lista_trabajadores=[]
        for producto in Producto.getProductos():
            if producto.getEstado()=="vendido" and producto.getMesVenta()!=None:
                if producto.getTrabajador() not in lista_trabajadores:
                    lista_trabajadores.append(producto.getTrabajador())

        return lista_trabajadores

    @staticmethod
    def buscar_mes_trabajador(trabajador):
        lista_meses=[]
        for producto in Producto.getProductos():
            if producto.getTrabajador == trabajador and Producto.getMesVenta()!=None:
                if producto.getMesVenta() not in lista_meses:
                    lista_meses.apend(producto.getMesVenta())
        return lista_meses



if __name__ == '__main__':

    trabajador1=Trabajador(0,"juanse",None,None)
    trabajador2=Trabajador(0,"Sergio",None,None)
    trabajador3 = Trabajador(0, "Russbell", None, None)


    producto1 = Producto("coca","vendido",  400, 2, None, trabajador1, 1)
    producto2 = Producto("coca", "vendido", 400, 2, None, trabajador1, 1)
    producto3 = Producto("coca", "vendido", 400, 2, None, trabajador1, 2)
    producto4 = Producto("coca", "vendido", 400, 2, None, trabajador3, 0)
    producto5 = Producto("coca", "vendido", 400, 2, None, trabajador3, 1)
    producto6 = Producto("coca", "vendido", 400, 2, None, trabajador3, 2)



    print(Nomina.buscar_mes_trabajador(trabajador1))