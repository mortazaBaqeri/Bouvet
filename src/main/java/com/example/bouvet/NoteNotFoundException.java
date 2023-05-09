package com.example.bouvet;

public class NoteNotFoundException extends RuntimeException{
    NoteNotFoundException(Integer id){
        super("Note " + id + " does not exist.");
    }
}
