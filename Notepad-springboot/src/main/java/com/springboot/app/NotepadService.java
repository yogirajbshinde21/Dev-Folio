package com.springboot.app;



import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class NotepadService {

    public void openNotepad() throws IOException, InterruptedException {
        // Start the Notepad application
        Process process = Runtime.getRuntime().exec("notepad");

        // Wait for the Notepad application to exit
        process.waitFor();
    }
}
