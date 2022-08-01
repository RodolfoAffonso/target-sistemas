package com.rodolfoafonso.targetsistemas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rodolfoafonso.targetsistemas.dto.DadosFaturamentos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class FaturamentoDistrubuidora {

    public static void main(String[] args) throws IOException {
        new FaturamentoDistrubuidora().run();
    }
    public void run() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = getClass().getClassLoader().getResourceAsStream("dados.json");
        List<DadosFaturamentos> dados = mapper.readValue(is,new TypeReference<List<DadosFaturamentos>>() {});
          List<Double> dadosFiltrados = dados.stream()
                .filter(dadosFaturamentos -> dadosFaturamentos.getValor() > 0)
                .map(d->d.getValor())
                .toList();

        Double minimo = dadosFiltrados.stream().mapToDouble(Double::doubleValue).min().getAsDouble();
        Double maximo = dadosFiltrados.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
        Double media = dadosFiltrados.stream().mapToDouble(Double::doubleValue).average().getAsDouble();

        int diasAcimaMedia = dadosFiltrados.stream().filter(valor -> valor > media).toList().size();
        System.out.println(String.format("Valor maximo é : %.2f",maximo));
        System.out.println(String.format("Valor minimo é : %.2f",minimo));
        System.out.println(String.format("Valor media é : %.2f",media));
        System.out.println(String.format("A quantidade de dias acima da media é : %d",diasAcimaMedia));

    }

}
