package com.dryve.dryvecarros.adapter;

import com.dryve.dryvecarros.exception.ErroNegocialException;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class FipeIntegracaoRest {
    private static final String URL_FIPE = "http://fipeapi.appspot.com/api/1/carros/veiculo/";
    private static final String FORMATO_JSON = ".json";

        public BigDecimal consultaPrecoFipe(String idMarca, String idModelo, String ano) throws ErroNegocialException {

           try {
               RestTemplate restTemplate = new RestTemplate();
               Object o = restTemplate.getForObject(URL_FIPE+idMarca+"/"+idModelo+"/"+ano + FORMATO_JSON, Object.class);
            return convertStringJsonToBigDecimal(o);
           } catch (Exception ex){
                throw new ErroNegocialException("EnumMensagensErro.ERRO_AO_CONSULTAR_API_FIPE");
           }
        }

        private BigDecimal convertStringJsonToBigDecimal(Object result) throws ErroNegocialException{

           try{
               Gson json = new Gson();
               // falta converter, porém api está fora!
               return BigDecimal.ZERO;
           }catch (Exception ex) {
               throw new ErroNegocialException("Erro ao tentar converter o preço da FIPE");
           }

        }
}
