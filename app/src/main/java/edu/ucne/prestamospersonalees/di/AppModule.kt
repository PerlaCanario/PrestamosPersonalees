package edu.ucne.prestamospersonalees.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.prestamospersonalees.data.PersonasDao
import edu.ucne.prestamospersonalees.data.PrestamosDao
import edu.ucne.prestamospersonalees.data.PrestamosPDb
import edu.ucne.prestamospersonalees.data.repository.PersonasRepository
import edu.ucne.prestamospersonalees.data.repository.PrestamosRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  AppModule {


    @Singleton
    @Provides
    fun ProvideTicketDb(@ApplicationContext context: Context): PrestamosPDb {
        val DATABASE_NAME = "PrestamoDb"
        return Room.databaseBuilder(
            context,
            PrestamosPDb::class.java,
            DATABASE_NAME       ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    }


    @Provides
    fun ProvidePrestamoDAO(prestamosDb: PrestamosPDb): PrestamosDao {
        return prestamosDb.prestamosDao
    }

    @Provides
    fun ProvidePrestamoRepository(prestamosDao: PrestamosDao): PrestamosRepository {
        return PrestamosRepository(prestamosDao)
    }

    @Provides
    fun ProvidePersonaDAO(personasDb: PrestamosPDb): PersonasDao {
        return personasDb.personaDao
    }

    @Provides
    fun ProvidePersonaRepository(personasDao: PersonasDao): PersonasRepository {
        return PersonasRepository(personasDao)
    }


}