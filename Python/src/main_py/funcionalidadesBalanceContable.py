from Python.src.gestorAplicacion_py.gestion.Producto import Producto


def conseguir_mes():
    lista_meses = []
    for producto in Producto.getProductos():
        if producto.getEstado() == "vendido" and producto.getMesVenta() != None:
            if producto.getMesVenta() not in lista_meses:
                lista_meses.append(producto.getMesVenta())
    return lista_meses

def balance_ventas(mes):
    total=0
    for producto in Producto.getProductos():
        if producto.getMesVenta()!=None:
            if producto.getEstado() == "vendido" and producto.getMesVenta() == mes:
                total+=producto.getPrecioVenta()

    return total



if __name__=='__main__':
    producto1 = Producto("coca", "vendido", 400, 2, None, None, 0)
    producto2 = Producto("coca1", "vendido", 500, 2, None, None, 0)
    producto3 = Producto("coca1", "vendido", 500, None, None, None, 0)
    producto3 = Producto("coca1", "vendido", 500, 3, None, None, 0)

    print(balance_ventas(2))

