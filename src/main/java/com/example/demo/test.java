package com.example.demo;

import java.util.HashMap;

/**
	 * @author zhengbinMac
	 */
	public class test {
	    private static boolean ready;
	    private static int number;
	    private static class ReaderThread extends Thread {
	        @Override
	        public void run() {
	            while(!ready) {
	                Thread.yield();
	            }
	            System.out.println(number);
	        }
	    }
	    public static void main(String[] args) {
//	        new ReaderThread().start();
//	        number = 42;
//	        ready = true;
	    	
	    	
	    	 ///*Integer*/map.put("1", 1);//向map中添加值(返回这个key以前的值,如果没有返回null)
	         HashMap<String, Integer> map=new HashMap<>();
	         System.out.println(map.put("1", 1));//null
	         System.out.println(map.put("2", 2));//1
	         System.out.println(map.put("1", 3));
	         System.out.println(map.put("1", 4));
	         System.out.println(map.toString());
	         HashMap<String, Integer> map1=new HashMap<>();
	         map1.put("DEMO", 1);
	         /*Value的类型*///得到map中key相对应的value的值
	         System.out.println(map1.get("1"));//null
	         System.out.println(map1.get("DEMO"));//1
	         
	         HashMap<String, Integer> map2=new HashMap<>();
	         /*boolean*///判断map是否为空
	         System.out.println(map2.isEmpty());//true
	         map2.put("DEMO", 1);
	         System.out.println(map2.isEmpty());//false
	         
	         
	    }
	}


