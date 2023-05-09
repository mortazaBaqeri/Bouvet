package com.example.bouvet;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteRepository repository;

    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Note> index(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Note show(@PathVariable("id") Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    @PostMapping("/store")
    public void store(@RequestBody NewNoteRequest request){
        Note note = new Note();
        note.setTitle(request.title);
        note.setText(request.text);

        repository.save(note);
    }

    @PutMapping("{id}")
    public Note update(@RequestBody NewNoteRequest request, @PathVariable("id") Integer id){
        return repository.findById(id)
                .map(note -> {
                    note.setTitle(request.title);
                    note.setText(request.text);
                    return repository.save(note);
                })
                .orElseGet(() -> {
                    Note new_note = new Note(id, request.title, request.text);
                    return repository.save(new_note);
                });
    }

    @DeleteMapping("{id}")
    public void destroy(@PathVariable("id") Integer id) throws Exception{
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new NoteNotFoundException(id);
        }
    }


    record NewNoteRequest(String title, String text){}
}
