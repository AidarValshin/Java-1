package main.ru.mephi.java.part7.task8;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GetLineNumbers {
    public static Map<String, Set<Integer>> read(String path) throws IOException {
        Map<String, Set<Integer>> result = new HashMap<>();
        File f1 = new File(path);
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;
        int count = 1;
        while ((s = br.readLine()) != null)   //Reading Content from the file
        {
            for (String word : s.split("\\s+")) {
                if (result.containsKey(word)) {
                    result.get(word).add(count);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(count);
                    result.put(word, set);
                }
            }
            count++;
        }
        fr.close();
        return result;
    }

    public static void main(String[] args) throws IOException {
        Map<String, Set<Integer>> result=read("src/main/ru/mephi/resources/part7.ex7");
      for(String s:result.keySet()){
          Set<Integer> set=result.get(s);
          System.out.print(s+"->");
          set.forEach(p->System.out.print(p+"  "));
          System.out.println();
      }
    }
}
