package com.company;
import java.util.*;
public class example {
    public static void main(String[] args) {
        StringToWords input = new StringToWords("    This is 6.005.  ");
        while (input.hasNext()) {
            System.out.println("<" + input.next() + ">");
        }
    }
}
    class StringToWords {
        ArrayList<String> words = new ArrayList<String>();
        int j=-1;
        public StringToWords(String s) {
            String trimStr = s.trim();
            String result = "";
            for (int i = 0; i < trimStr.length(); i++) {
                if (trimStr.charAt(i) == ' ') {
                    words.add(result);
                    result = "";
                } else {
                    result += trimStr.charAt(i);
                }
            }
            words.add(result);
            cleaner(words);
        }
        public void cleaner(ArrayList <String> words){
            for (int i=0;i<words.size();i++){
                if(words.get(i)==""){
                    words.remove(i);
                }
            }
        }
        int i=0;
        public boolean hasNext() {
            if (i < words.size()) {
                i++;
                return true;
            }
            return false;
        }
        public String next() {
            j++;
            return words.get(j);

        }
    }
