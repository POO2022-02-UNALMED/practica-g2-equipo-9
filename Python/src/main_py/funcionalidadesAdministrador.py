from Python.src.gestorAplicacion_py.gestion import Pedido
from Python.src.gestorAplicacion_py.gestion import Producto
from Python.src.gestorAplicacion_py.gestion import Servicio
from Python.src.gestorAplicacion_py.usuarios import Empleado
from Python.src.gestorAplicacion_py.usuarios import Trabajador


class FuncionalidadesAdministrador:
    @staticmethod
    def opcionesAdministrador():
        entrada = input()
        print("=====================BIENVENIDO AL MENU DE OPCIONES DE ADMINISTRADOR====================")
        opcion = None
        salir = False
        while salir == False:
            print("1. Opciones de empleado")
            print("2. Opciones de producto")
            print("3. Volver")
            opcion = entrada.nextInt()
            while opcion != 1 and opcion != 2 and opcion != 3:
                print()
                print("Opcion invalida, vuelve a ingresar una opcion")
                print()
                print("1. Opciones de empleado")
                print("2. Mostrar Inventario de productos")
                print("3. Volver")
                print()
                print("Ingrese una opcion:")
                opcion = entrada.nextInt()
            if opcion == 1:
                opcionesEmpleado()
            elif opcion == 2:
                print("===============================INVENTARIO DE PRODUCTOS DISPONIBLES==========================================")
                print()
                productosNoVendidos = Producto.productosDisponibles(Producto.getProductos()) #Productos con estado "No vendido" y fecha null
                print(Producto.mostrarProductosDisponibles(productosNoVendidos))
                print()
                print("=============================================================================================================")
            elif opcion == 3:
                salir = True


    @staticmethod
    def opcionesEmpleado():
        entrada = input()
        opcion = None
        salir = False
        while salir == False:
            print("=====================OPCIONES DE EMPLEADO===================")

            print("1. Ver seguro de un trabajador")
            print("2. Empleado del mes")
            print("3. Volver")
            print("Ingrese una opcion:")
            opcion = entrada.nextInt()
            while opcion != 1 and opcion != 2 and opcion != 3 and opcion != 4:
                print("=====================OPCIONES DE EMPLEADO===================")
                print("1. Ver seguro de un trabajador")
                print("2. Empleado del mes")
                print("3. Volver")
                print("Ingrese una opcion:")
                opcion = entrada.nextInt()

        if opcion == 1:
            print(Trabajador.mostrarTrabajadores())
            print()
            print("Ingresa codigo de un trabajador")
            opcion= entrada.nextInt()
            trabajador =Trabajador.seleccionarTrabajador(opcion)
            while trabajador is None:
                print()
                print("Codigo de trabajador no existe, ingresa un codigo correcto")
                opcion= entrada.nextInt()
                trabajador=Trabajador.seleccionarTrabajador(opcion)
                empleado =trabajador
                print("Trabajador seleccionado:")
                print()
                print(trabajador)
                print()
                print("Seguro del trabajador:")
                print(empleado.asegurar()) # Ligadura dinamica

        elif opcion == 2:
            empleadoDelMes()
        elif opcion == 3:
            salir = True



    @staticmethod
    def empleadoDelMes():
        entrada = input()
        print("=====================BIENVENIDO AL MENU DE NOMINA====================")
        opcion = None
        salir = False
        while salir == False:
            fechas = TreeSet()
            #guardamos las fechas de productos de los que se tengan conocimiento de venta

            for producto in Producto.getProductos():
                if producto.getFechaVenta() is not None:
                    fechas.add(producto.getFechaVenta().getMonthValue())

            #guardamos las fechas de servicios de los que se tengan conocimiento de venta
            for e in Pedido.getPedidos():
                if e.getFechaPedido() is not None:
                    fechas.add(e.getFechaPedido().getMonthValue())
            meses = {}
            meses[1] = "Enero"
            meses[2] = "Febrero"
            meses[3] = "Marzo"
            meses[4] = "Abril"
            meses[5] = "Mayo"
            meses[6] = "Junio"
            meses[7] = "Julio"
            meses[8] = "Agosto"
            meses[9] = "Septiembre"
            meses[10] = "Octubre"
            meses[11] = "Noviembre"
            meses[12] = "Diciembre"

            opcionMeses = {}

            print("Fechas Disponibles:")
            i = 1
            for numeroMes in fechas:
            #aqui se muestran las fechas de las que se tiene conocimiento de ventas realizadas
                print("[" + str(i) + "]" + " " + meses[numeroMes] + " de " + str(2022))
                opcionMeses[i] = numeroMes
                i += 1
            print("[0] Volver atras")
            #Obtengo la fecha escogida
            print("Por favor ingresa una opcion:")
            opcion = entrada.nextInt()
            while opcion < 0 or opcion > len(opcionMeses):
                print("Opcion no valida, ingresa de nuevo un numero")
                opcion = entrada.nextInt()
            if opcion >= 1 and opcion <= len(opcionMeses):
                mesSeleccionado = opcionMeses[opcion]
                print("Mes escogido: " + meses[mesSeleccionado])

                #Busco trabajador del mes
                cuenta = {}
                for trabajador in Trabajador.getTrabajadores():
                    totalVentas = 0
                    for producto in Producto.getProductos():
                        if producto.getFechaVenta() is not None:
                            if producto.getTrabajador() is trabajador and producto.getEstado() is "Vendido" and producto.getFechaVenta().getMonthValue() == mesSeleccionado:
                                totalVentas += producto.getPrecioVenta()
                    for pedido in Pedido.getPedidos():
                        if pedido.getFechaPedido() is not None:
                            if pedido.getFechaPedido().getMonthValue() == mesSeleccionado and pedido.getTrabajador() is trabajador and pedido.getEstadoPedido() is "Pagado":
                                for servicio in pedido.getServicios():
                                    totalVentas += servicio.getPrecio()
                    if trabajador in cuenta.values() == False:
                        cuenta[totalVentas] = trabajador
                print("El trabajador que mas ha vendido es: ")
                print()
                mejor = cuenta.values().toArray()[len(cuenta) - 1]
                print(mejor)
                print("Con seguro: ")
                print(mejor.asegurar())
                print()
                print("===============NOMINA DE EMPLEADO DEL MES===================", end = '')
                print()
                print(FuncionalidadesNomina.nominaEmpleado(mesSeleccionado,mejor))
                print()
                print("===========================================================")
                print()
                print("Desea aumentar su sueldo?")
                print()
                print("1. Aumentar sueldo")
                print("2. No aumentar sueldo/volver")
                opcion=entrada.nextInt()
                if opcion==1:
                    mejor.aumentarSueldo(0.1)
                print("El nuevo sueldo actual del trabajador es:")
                print(mejor.getSueldo())

            elif opcion==0:
                salir=True
    @staticmethod
    def calculoDeNomina():
        entrada = input()
        print("=====================BIENVENIDO AL MENU DE NOMINA====================")
        opcion = None
        salir = False
        while salir == False:
            fechas = TreeSet()
            #guardamos las fechas de productos de los que se tengan conocimiento de venta

            for producto in Producto.getProductos():
                if producto.getFechaVenta() is not None:
                    fechas.add(producto.getFechaVenta().getMonthValue())
                     #guardamos las fechas de servicios de los que se tengan conocimiento de venta
            for e in Pedido.getPedidos():
                if e.getFechaPedido() is not None:
                    fechas.add(e.getFechaPedido().getMonthValue())
            meses = {}
            meses[1] = "Enero"
            meses[2] = "Febrero"
            meses[3] = "Marzo"
            meses[4] = "Abril"
            meses[5] = "Mayo"
            meses[6] = "Junio"
            meses[7] = "Julio"
            meses[8] = "Agosto"
            meses[9] = "Septiembre"
            meses[10] = "Octubre"
            meses[11] = "Noviembre"
            meses[12] = "Diciembre"

            opcionMeses = {}

            print("Fechas Disponibles:")
            i = 1
            for numeroMes in fechas:
                #aqui se muestran las fechas de las que se tiene conocimiento de ventas realizadas
                print("[" + str(i) + "]" + " " + meses[numeroMes] + " de " + str(2022))
                opcionMeses[i] = numeroMes
                i += 1
            print("[0] Volver atras")
            #Obtengo la fecha escogida
            print("Por favor ingresa una opcion:")
            opcion = entrada.nextInt()
            while opcion < 0 or opcion > len(opcionMeses):
                print("Opcion no valida, ingresa de nuevo un numero")
                opcion = entrada.nextInt()
            if opcion >= 1 and opcion <= len(opcionMeses):
                mesSeleccionado = opcionMeses[opcion]
                print("Mes escogido: " + meses[mesSeleccionado])

                #Seleccionar trabajador
                print("Selecciona trabajador a liquidar:")

                print(Trabajador.mostrarTrabajadores())
                print("Ingresa codigo del trabajador: ")

            codigo = entrada.nextInt() #codigo de empleado
            #buscamos el codigo del trabajador
            trabajadorSeleccionado = Trabajador.seleccionarTrabajador(codigo)
            while trabajadorSeleccionado is None:
                print("Codigo de trabajador no existe, ingrese uno valido")
                codigo = entrada.nextInt()
                trabajadorSeleccionado = Trabajador.seleccionarTrabajador(codigo)

            print(FuncionalidadesNomina.nominaEmpleado(mesSeleccionado, trabajadorSeleccionado))
            print()
            print("Presiona 0 para volver atras y ver la contabilidad de otros meses")
            opcion = entrada.nextInt()
            while opcion != 0:
                print("Opcion incorrecta, presione 0 para volver")
                opcion = entrada.nextInt()
            if opcion == 0:
                salir = True




