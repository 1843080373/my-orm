package com.orm.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 下划线命名与驼峰命名转换
 * @author 紫马
 *
 */
public class AliasConvertor {
	
	public static String db2Java(String dbFeield) {
		String[] words = dbFeield.split("_");
        String result = toUppercase4FirstLetter(words);
		return result;
	}
	
	public  static String javaToDb(String javaFeiled) {
		StringBuffer buffer = new StringBuffer();
        char[] array = javaFeiled.toCharArray();
        List<Integer> insertIndexes = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            Character c = array[i];
            if(i != 0 && Character.isUpperCase(c)){
                insertIndexes.add(i);
            }
        }
        if(insertIndexes.size() > 0){
            int flag = 0;
            for(int j=0;j<insertIndexes.size();j++){
                String word = toLowercase4FirstLetter(javaFeiled.substring(flag, insertIndexes.get(j)));
                buffer.append(word).append("_");
                flag = insertIndexes.get(j);
            }
            String last = toLowercase4FirstLetter(javaFeiled.substring(flag));
            buffer.append(last);
            return buffer.toString();
        } else {
            return javaFeiled;
        }
	}
	private static String toLowercase4FirstLetter(String word){
        if(word != null && word.length() > 0){
            String firstLetter = word.substring(0,1);
            String others = word.substring(1);
            return firstLetter.toLowerCase() + others;
        }else{
            return "";
        }
    }
	private static String toUppercase4FirstLetter(String... words){
        StringBuffer buffer = new StringBuffer();
        if(words != null && words.length > 0){
            for(int i=0;i<words.length;i++){
                String word = words[i];
                String firstLetter = word.substring(0, 1);
                String others = word.substring(1);
                String upperLetter = null;
                if(i != 0){
                    upperLetter = firstLetter.toUpperCase();
                } else {
                    upperLetter = firstLetter;
                }
                buffer.append(upperLetter).append(others);
            }
            return buffer.toString();
        }
        return "";
    }
	
	
}
