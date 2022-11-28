from Python.src.gestorAplicacion_py.gestion.Producto import Producto


def conseguir_mes():
    lista_meses = []
    for producto in Producto.getProductos():
        if producto.getEstado() == "Vendido" and producto.getMesVenta() != None:
            if producto.getMesVenta() not in lista_meses:
                lista_meses.append(producto.getMesVenta())
    return lista_meses

if __name__=='__main__':
    pass

