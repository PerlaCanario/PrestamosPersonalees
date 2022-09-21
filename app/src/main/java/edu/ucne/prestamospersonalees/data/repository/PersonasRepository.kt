package edu.ucne.prestamospersonalees.data.repository

import edu.ucne.prestamospersonalees.data.PersonasDao
import edu.ucne.prestamospersonalees.model.Persona
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonasRepository @Inject constructor(
    val personasDao: PersonasDao
) {
    suspend fun Insertar(personas: Persona)= personasDao.Insertar(personas)

    fun Buscar(personas: Int): Flow<Persona> =  personasDao.Buscar(personas)

    suspend fun Eliminar(personas: Persona)= personasDao.Eliminar(personas)

    fun GetLista(): Flow<List<Persona>> = personasDao.GetLista()

    suspend fun GetMontoFromPrestamos(personaId: Int?): Double = personasDao.GetMontoFromPrestamos(personaId)

}