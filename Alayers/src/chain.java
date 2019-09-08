

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
import java.io.FileReader;
import java.util.*;
class chain {
    private String kata;
    private Random rand_huruf;
    private String[] besrkecil;
    private Map<String, String> maps;
    
    public chain(String kata) {
        this.kata = kata.toLowerCase();
        this.maps = new HashMap<String, String>();
        this.maps.put("a", "4");
        this.maps.put("b", "b");
        this.maps.put("c", "c");
        this.maps.put("d", "d");
        this.maps.put("e", "3");
        this.maps.put("f", "f");
        this.maps.put("g", "6");
        this.maps.put("h", "h");
        this.maps.put("i", "1");
        this.maps.put("j", "7");
        this.maps.put("k", "k");
        this.maps.put("l", "l");
        this.maps.put("m", "m");
        this.maps.put("n", "n");
        this.maps.put("o", "0");
        this.maps.put("p", "p");
        this.maps.put("q", "q");
        this.maps.put("r", "r");
        this.maps.put("s", "5");
        this.maps.put("t", "7");
        this.maps.put("u", "u");
        this.maps.put("v", "v");
        this.maps.put("w", "w");
        this.maps.put("x", "x");
        this.maps.put("y", "y");
        this.maps.put("z", "z");

    }
    private String random_huruf(String huruf){
        this.besrkecil = new String[]{huruf.toLowerCase(), huruf.toUpperCase()};
        this.rand_huruf = new Random();
        int angka = this.rand_huruf.nextInt(this.besrkecil.length);
        return this.besrkecil[angka];
    }
    public chain generator(){
        char[] kata_edit = kata.toCharArray();
        for(char satu : kata_edit){
            String konvert = String.valueOf(satu);
            if(this.maps.containsKey(konvert)){                                
              this.kata = kata.replace(konvert, this.maps.get(konvert).replace(konvert, random_huruf(konvert)));
            }
        }
        return this;
    }
    public chain replacer(String key, String value){
        if(this.maps.containsKey(key)){
            this.maps.replace(key, value);
        }
        return this;
    }
    String getKata(){
        return this.kata;
    }
}