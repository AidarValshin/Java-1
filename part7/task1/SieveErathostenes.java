package main.ru.mephi.java.part7.task1;

import java.util.BitSet;
import java.util.HashSet;

public class SieveErathostenes {
    public static HashSet<Integer> getHashSet(int n){
        HashSet<Integer> result=new HashSet<>();
       for(int i=2;i<=n;i++){
           result.add(i);
       }
       for (int i=2;(i*i)<=n;i++){
           for(int j=i*i;j<n;j+=i){
               result.remove(j);
           }
       }
       return result;
    }

    public static BitSet getBitSet(int n){
        BitSet result=new BitSet(n);
        result.set(2,n+1);
        result.clear(0,2);
        for (int i=2;(i*i)<=n;i++){
            for(int j=i*i;j<n;j+=i){
                result.clear(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        getHashSet(100).forEach(p->System.out.print(p+" "));
        System.out.println();
        getBitSet(100).stream().forEach(p->System.out.print(p+" "));
    }
}

