package com.rodolfoafonso.targetsistemas;

import java.util.Scanner;

public class InverteString {

        public static void main(String[] args) {
           Scanner scan = new Scanner(System.in);
           System.out.println("insira a String");
           String str = scan.nextLine(); ;
            System.out.println(str);
            char[] ch = str.toCharArray();
            int comeco = 0;
            int fim = ch.length-1;
            char tmp;
            while(fim>comeco){
                tmp = ch[comeco];
                ch[comeco] = ch[fim];
                ch[fim] = tmp;
                fim--;
                comeco++;
            }
            str = new String(ch);
            System.out.println(str);
        }
    }

