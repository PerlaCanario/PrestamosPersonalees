package edu.ucne.prestamospersonalees.data

import androidx.room.*
import edu.ucne.prestamospersonalees.model.Prestamo
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(prestamo: Prestamo)

    @Delete
    suspend fun Eliminar(prestamo: Prestamo)


    @Query(
        """
        SELECT * 
        FROM Prestamos
        WHERE prestamoId=:prestamoId        
    """
    )
    fun Buscar(prestamoId: Int): Flow<Prestamo>

    @Query(
        """
        SELECT * 
        FROM Prestamos
        ORDER BY prestamoId    
    """
    )
    fun GetLista(): Flow<List<Prestamo>>

    @Query(
        """
        UPDATE Personas
        SET balancePrestamo = balancePrestamo + 1
        WHERE personaId =:personaId  
    """
    )
    suspend fun aumentoPrestamosTotales(personaId: Int?)

}