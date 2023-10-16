package com.springboot.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotepadController {

    @Autowired
    private NotepadService notepadService;

    @GetMapping("/notepad/open")
    public void openNotepad() {
        try {
            notepadService.openNotepad();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
