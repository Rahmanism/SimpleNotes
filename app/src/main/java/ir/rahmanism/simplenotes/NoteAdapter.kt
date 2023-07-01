package ir.rahmanism.simplenotes

import androidx.recyclerview.widget.RecyclerView
import ir.rahmanism.simplenotes.databinding.NoteItemBinding

class NoteAdapter(
    private val db: AppDatabase
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    val noteDao = db.noteDao()
    val notes: MutableList<Note> = noteDao.getAll()

    class NoteViewHolder(val itemBinding: NoteItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(noteItem: Note) {
            itemBinding.apply {
                noteTitleTv.text = noteItem.title
                noteBodyTv.text = noteItem.body
            }
        }
    }

}