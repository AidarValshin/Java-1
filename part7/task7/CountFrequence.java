package main.ru.mephi.java.part7.task7;

import java.io.*;
import java.util.*;

public class CountFrequence {
    public static List<String> getWords(String path) throws IOException {
        File f1=new File(path);
        List<String> words= new ArrayList<>();
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;
        while((s=br.readLine())!=null)   //Reading Content from the file
        {
            words.addAll(Arrays.asList(s.split("\\s+")));  //Split the word using spaces
        }
        fr.close();
        return words;
    }

    public static Map<String, Integer> count(List<String> words) {
        Map<String, Integer> result = new TreeMap<>();
        for (var word : words) {
            result.put(word, result.getOrDefault(word, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
       count(getWords("src/main/ru/mephi/resources/part7.ex7"))
               .forEach((k,v)->System.out.println(k+"->"+v));
    }
}
