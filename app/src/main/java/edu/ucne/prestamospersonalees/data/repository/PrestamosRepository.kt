package edu.ucne.prestamospersonalees.data.repository

import edu.ucne.prestamospersonalees.data.PrestamosDao
import edu.ucne.prestamospersonalees.model.Prestamo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrestamosRepository @Inject constructor(
    val prestamosDao: PrestamosDao
) {
    suspend fun Insertar(prestamos: Prestamo)= prestamosDao.Insertar(prestamos)

    fun Buscar(prestamos: Int): Flow<Prestamo> =  prestamosDao.Buscar(prestamos)

    suspend fun Eliminar(prestamos: Prestamo)= prestamosDao.Eliminar(prestamos)

    fun GetLista(): Flow<List<Prestamo>> = prestamosDao.GetLista()

    suspend fun aumentoPrestamosTotales(personaId: Int?) = prestamosDao.aumentoPrestamosTotales(personaId)
}