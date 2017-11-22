/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author J2EE-33
 */
public class Utils {

    public static void writeToFile(String fileName, List<Students> s) throws IOException {
        File destFile = new File(fileName + ".txt");
        try {
            if (destFile.exists() == false) {
                System.out.println("We have to make a new File");
                destFile.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(destFile, true));
            for (Students students : s) {
                out.append(students.getName() + "," + students.getEmail() + "," + students.getAge() + "," + students.getGender() + "," + students.getHobby() + "," + students.getRound() + "," + students.getNote() + "," + "\n");

            }
            out.close();
        } catch (IOException e) {
            System.out.println("COULD NOT LOG!!");

        }
    }

    public static void displayStudentsInformationFromFile(String fileName, DefaultTableModel model) {
        String line;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName + ".txt"));
            while ((line = reader.readLine()) != null) {
                model.addRow(line.split(","));
            }
            reader.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Buffered reader issued");
        }

    }

}
