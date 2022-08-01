package com.rodolfoafonso.targetsistemas;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira o número. ");
        int num = scan.nextInt();

        int num2 = 1;
        int num3 = 1;
        while (num > num3){
            int tmp = num2+num3;
            num2=num3;
            num3=tmp;
        }
        if (num == num3){
            System.out.println("Faz parte da sequencia");
        }else {
            System.out.println("Não faz parte da sequencia");
        }
    }
}
