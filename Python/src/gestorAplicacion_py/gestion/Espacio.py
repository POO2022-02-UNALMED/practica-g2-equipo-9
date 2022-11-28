class Espacio:

    
    #ATRIBUTOS DE INSTANCIA

    # ATRIBUTOS DE CLASE
    _listado = []


    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    @staticmethod
    def getListado():
        return Espacio._listado

    @staticmethod
    def setListado(listado):
        Espacio._listado = listado

    def getFechas(self):
        return self._fechas

    def setFechas(self, fechas):
        self._fechas = fechas

    #CONSTRUCTORES


    def _init_(self, nombre):
        
        self._nombre = None
        self._fechas = []

        self._nombre = nombre
        self.generarFechasDisponibles()
        Espacio._listado.append(self)


    def seleccionarFecha(self, opcion):

        fechaTomada = self.getFechas()[opcion]
        self.getFechas().pop(opcion) # se quita la disponibilidad de la fecha seleccionada
        return fechaTomada #retorna la fecha tomada por el usuario
    def reordenarFechas(self, reserva):
        i = 0
        while i < len(self._fechas):
            if self._fechas[i].isBefore(reserva.getFechaReserva()) and self._fechas[i+1].isAfter(reserva.getFechaReserva()):
                self._fechas.insert(i+1, reserva.getFechaReserva())
                break
            elif self._fechas[i].isBefore(reserva.getFechaReserva()) and i==len(self._fechas) - 1:
                self._fechas.append(reserva.getFechaReserva())
                break
            elif self._fechas[i].isAfter(reserva.getFechaReserva()) and i==0:
                self._fechas.insert(0, reserva.getFechaReserva())
                break


            i += 1


    def actualizarFechas(self):
        for fecha in self._fechas:
            if fecha.isBefore(LocalDate.now()):
                self._fechas.remove(fecha)

    def generarFechasDisponibles(self):
        self._fechas.append(LocalDate.now())
        for i in range(1, 30):
            self._fechas.append(LocalDate.now().plusDays(i))

