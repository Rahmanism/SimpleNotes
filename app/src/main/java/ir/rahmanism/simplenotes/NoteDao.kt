package ir.rahmanism.simplenotes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Query("select * from note")
    fun getAll(): MutableList<Note>

    @Query("select * from note where id In (:noteIds)")
    fun loadAllByIds(noteIds: List<Int>): MutableList<Note>

    @Query("select * from note where title like :title limit 5")
    fun findByTitle(title: String): MutableList<Note>

    @Query("select * from note where id = :id")
    fun findById(id: Int): Note

    @Insert
    fun insertAll(notes: List<Note>)

    @Delete
    fun delete(note: Note)

    @Delete
    fun deleteNotes(notes: List<Note>)

    @Update
    fun updateNote(note: Note)
}