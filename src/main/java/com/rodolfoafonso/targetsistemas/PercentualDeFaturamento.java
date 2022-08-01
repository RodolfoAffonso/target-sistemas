package com.rodolfoafonso.targetsistemas;

import java.util.HashMap;

public class PercentualDeFaturamento {
    public static void main(String[] args) {

        HashMap<String,Double> map = new HashMap<>();

        map.put("SP", 67836.43);
        map.put("RJ",36678.66);
        map.put("MG",29229.88);
        map.put("ES",27165.48);
        map.put("Outros",19849.53);

        Double soma = map.values().stream().mapToDouble(Double::doubleValue).sum();
        map.forEach((estado,valor)->{
            double prc = (valor * 100)/soma;

            System.out.println(String.format("O percentual do %s e : %.2f",estado , prc));

        });




    }

}
