package edu.ucne.prestamospersonalees.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.prestamospersonalees.model.Persona
import edu.ucne.prestamospersonalees.model.Prestamo

@Database(
    entities = [Prestamo::class, Persona::class],
    version = 5
)
abstract class PrestamosPDb: RoomDatabase() {
    abstract  val prestamosDao: PrestamosDao
    abstract  val personaDao: PersonasDao
}