package com.kts.snw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;


/**
 * Hello world!
 */
public class App{
    public static void main(String[] args){
        int arr[] = {1,2,3,4};
        Permutation p = new Permutation(arr);
        ArrayList<ArrayList<Integer>> permutations = p.getResult();
        permutations.forEach(System.out::println);
    }
}
class Permutation{
    int arr[];
    int marked[];
    Stack<Integer> stack;
    static int READED = 1;
    static int UN_READED = 0;
    ArrayList<ArrayList<Integer>> result;

    public Permutation(int arr[]){
        this.arr = arr.clone();
        this.marked = new int[arr.length];
        this.stack = new Stack<>();
        this.result = new ArrayList<>();
    }
    public ArrayList<ArrayList<Integer>> getResult(){
        if(this.result.size() == 0){
            permute();
            return this.result;
        }
        return this.result;
    }

    private void permute(){
        permute(0);
    }

    private void permute(int index){
        if(index == arr.length){
            result.add(new ArrayList<>(stack));
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(marked[i] == UN_READED){
                stack.push(arr[i]);
                marked[i] = READED;
                permute(index + 1);
                stack.pop();
                marked[i] = UN_READED;
            }
        }
    }

}