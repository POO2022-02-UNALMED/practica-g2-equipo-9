
from Producto import Producto
# *Clase creada para representar los productos fisicos
# *para cada unidad de cada producto se crea un objeto de tipo Producto
# * Un pedido puede contener muchos productos
# *
#





def conseguir_mes():
    lista_meses = []
    for producto in Producto.getProductos():
        if producto.getEstado() == "vendido" and producto.getFechaVenta() != None:
            if producto.getFechaVenta() not in lista_meses:
                lista_meses.append(producto.getFechaVenta())
    return lista_meses

def balance_ventas(mes):
    total=0
    for producto in Producto.getProductos():
        if producto.getFechaVenta()!=None:
            if producto.getEstado() == "vendido" and producto.getFechaVenta() == mes:
                total+=producto.getPrecioVenta()

    return total



if __name__=='__main__':
    producto1 = Producto("coca", "vendido", 400, 2, None, None, 0)
    producto2 = Producto("coca1", "vendido", 500, 2, None, None, 0)
    producto3 = Producto("coca1", "vendido", 500, None, None, None, 0)
    producto3 = Producto("coca1", "vendido", 500, 3, None, None, 0)

    print(balance_ventas(2))

