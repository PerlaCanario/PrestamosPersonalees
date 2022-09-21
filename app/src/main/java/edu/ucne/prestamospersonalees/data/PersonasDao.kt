package edu.ucne.prestamospersonalees.data

import androidx.room.*
import edu.ucne.prestamospersonalees.model.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonasDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(persona: Persona)

    @Delete
    suspend fun Eliminar(persona: Persona)


    @Query(
        """
        SELECT * 
        FROM Personas
        WHERE personaId=:personaId        
    """
    )
    fun Buscar(personaId: Int): Flow<Persona>

    @Query(
        """
        SELECT * 
        FROM Personas
        ORDER BY personaId    
    """
    )
    fun GetLista(): Flow<List<Persona>>

    @Query(
        """
        SELECT SUM(monto)
        FROM Prestamos
        WHERE personaId =:personaId
    """
    )
    suspend fun GetMontoFromPrestamos(personaId:Int?): Double


}