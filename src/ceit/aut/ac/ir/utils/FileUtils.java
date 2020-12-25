package ceit.aut.ac.ir.utils;

import ceit.aut.ac.ir.model.Note;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * this class is for managing files and working with them
 */
public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor

    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }

    /**
     * this method reads a file with bufferReader
     * @param file a file to be read
     * @return content of file as a string
     */
    public static String fileReader(File file) {
        //TODO: Phase1: read content from file
        BufferedReader Br = null;
        String content = "";
        try {
            Br = new BufferedReader(new FileReader(file));
            while (Br.ready()){
                content += Br.readLine()+"\n";
            }
            Br.close();
            return content;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * this method is for writing on files with bufferWriter
     * @param content a string to be written on the file
     */
    public static void fileWriter(String content) {
        //TODO: write content on file
        String fileName = NOTES_PATH+getProperFileName(content)+".txt";
        System.out.println(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method is for reading a file with fileInputStream
     * @param file a file to be read
     * @return content of file as a string
     */
    public static String fileInputStream(File file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            String content = "";
            while (fileInputStream.available()>0){
                content+=(char)fileInputStream.read();
            }
            fileInputStream.close();
            return content;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    //TODO: Phase1: define method here for writing file with OutputStream

    /**
     * this method is for writing on a new file with fileOutputStream
     * @param content string to be written on the file
     */
    public static void fileOutputStream(String content){
        String fileName = NOTES_PATH+getProperFileName(content)+".txt";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            char[] c = content.toCharArray();
            byte[] bytes = new byte[c.length];
            for (int i = 0; i < bytes.length; i++) {
                bytes[i]=(byte)c[i];
            }
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //TODO: Phase2: proper methods for handling serialization

    /**
     * this method is for serializing(writing on) a new note file using ObjectOutputStream
     * @param content string to be written on the file
     */
    public static void serializing(String content){
        String fileName = NOTES_PATH+getProperFileName(content);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            Note note = new Note(getProperFileName(content),content,dateFormat.format(date));
            out.writeObject(note);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method is for reading a serialized file using ObjectInputStream
     * @param file file to be deserialized
     * @return content of file as a string
     */
    public static String deserializing(File file){
            String str="";
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));){
            Note note = (Note)in.readObject();
            return note.getContent();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * this method gets a file and return its note(which is an object from Note class)
     * @param file a file to be read
     * @return Note object of that file
     */
    public static Note getNote(File file){

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (Note)ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * this method make a proper fileName for a content which is it's first name
     * @param content content of a file
     * @return file's name which is made in this method
     */
    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
