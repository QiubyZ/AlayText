/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author silucot
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean ulang = true;
        while (ulang) {
            Clear();
            System.out.println(create("==== [TEXT ALAY] ===="));
            System.out.println("1. Buat kata\n2. Baca File");
            Scanner input = new Scanner(System.in);
            System.out.println("Masukkan Pilihan: ");
            try{
            switch (input.nextInt()) {
                case 1:
                    System.out.println(create(tanyakan("Masukkan kata: ")));
                    break;
                case 2:
                    System.out.println("Masukkan path yang mau dibaca: ");
                    String filetarget = input.next();
                    System.out.println("Save File: ");
                    String topath = input.next();
                    OpenFiles(filetarget, topath);
                    break;
                default:
                    System.out.println("Masukkan Nomor yang ada didalam pilihan");
                    continue;
                }
            }catch(Exception e ){
                System.err.println("Anda Salah tekan keknya ");
                continue;
            }
            String tanya = tanyakan("Balik kemenu? (y/[enter])").toLowerCase();
            if(tanya.equalsIgnoreCase("y")){ulang = true;}
            else{ulang = false;}
        }
    }
    public static String tanyakan(String pesan){
        System.out.println(pesan);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static String create(String text){
        return new chain(text).generator().getKata();
    }
    public static void OpenFiles(String path, String savedto) {
        String text;
        try {
            FileReader file = new FileReader(path);
            BufferedReader br = new BufferedReader(file);
            while ((text = br.readLine()) != null) {
                String konvert = new chain(text)
                        .generator()                        
                        .getKata();
                savedFiles(savedto,konvert);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    public static void savedFiles(String path, String text) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(            
            new FileWriter(path, true)
            ));
            out.print(text);
            out.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        System.out.println("Saved to File: "+ path);
    }
    public static void Clear() {
        try {
            String os = System.getProperty("os.name");
            System.out.println(os);
            if (os.startsWith("Windows")) {
                Runtime.getRuntime().exec("clear");
            } else {
                Runtime.getRuntime().exec("cls");
            }
        } catch (Exception exception) {}
    }
}