package com.springboot.app;

// No need to import java.awt since it is not being used
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.*;

public class Notepad extends JFrame implements ActionListener {

    private JTextArea area;
    private JScrollPane scpane;
    String text = "";

    public Notepad() {
        super("Notepad");
        area = new JTextArea();
        scpane = new JScrollPane(area);
        scpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scpane);
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newfile = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveas = new JMenuItem("Save As");
        JMenuItem exit = new JMenuItem("Exit");
        newfile.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        saveas.addActionListener(this);
        exit.addActionListener(this);
        file.add(newfile);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(exit);
        menubar.add(file);
        setJMenuBar(menubar);
        setSize(500, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New")) {
            area.setText("");
        } else if (e.getActionCommand().equals("Open")) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);
                    area.read(br, null);
                    br.close();
                    area.requestFocus();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error Occured While Opening File");
                }
            }
        } else if (e.getActionCommand().equals("Save")) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    FileWriter writer = new FileWriter(file);
                    area.write(writer);
                    writer.close();
                    area.requestFocus();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error Occured While Saving File");
                }
            }
        } else if (e.getActionCommand().equals("Save As")) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    FileWriter writer = new FileWriter(file);
                    area.write(writer);
                    writer.close();
                    area.requestFocus();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error Occured While Saving File");
                }
            }
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Notepad();
    }

    public void openNotepad() {
    }
}
