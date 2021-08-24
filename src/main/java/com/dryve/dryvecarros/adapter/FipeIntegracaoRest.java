package com.dryve.dryvecarros.adapter;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dryve.dryvecarros.dto.VeiculoFipeDTO;
import com.dryve.dryvecarros.exception.EnumMensagensErro;
import com.dryve.dryvecarros.exception.ErroNegocialException;

@Service
public class FipeIntegracaoRest {
    private static final String URL_FIPE = "http://parallelum.com.br/fipe/api/v1/carros/marcas/";
  
        public BigDecimal consultaPrecoFipe(String idMarca, String idModelo, String ano) throws ErroNegocialException {

           try {
               RestTemplate restTemplate = new RestTemplate();
               System.out.println(URL_FIPE+idMarca+"/modelos/"+idModelo+"/anos/"+ano);
               VeiculoFipeDTO valorFipe = restTemplate.getForObject(URL_FIPE+idMarca+"/modelos/"+idModelo+"/anos/"+ano, VeiculoFipeDTO.class);
            return convertStringJsonToBigDecimal(valorFipe.getValor());
           } catch (Exception ex){
                throw new ErroNegocialException(EnumMensagensErro.ERRO_AO_CONSULTAR_API_FIPE);
           }
        }

        private BigDecimal convertStringJsonToBigDecimal(String valor) throws ErroNegocialException{

           try{

               String srt = valor.replaceAll("[^-?0-9]+", "");              
                 return BigDecimal.valueOf(Long.parseLong(srt)); // falta ajustar a precisao
           }catch (Exception ex) {
               throw new ErroNegocialException(EnumMensagensErro.ERRO_CONVERSAO_FIPE);
           }

        }
}
