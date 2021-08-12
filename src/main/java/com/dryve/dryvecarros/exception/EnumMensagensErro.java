package com.dryve.dryvecarros.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
public enum EnumMensagensErro {
    ERRO_APLICACAO("000","Erro ao executar"),
    NENHUM_DADO_ENCONTRADO("001", "Nenhum Carro encontrado na Base!"),
    CARRO_NAO_EXISTE("002","Erro"),
    ERRO_AO_CONSULTAR_API_FIPE("003", "Erro ao tentar se comunicar com http://fipeapi.appspot.com/"),
    VEICULO_CADASTRADO_NA_BASE("004","Veiculo já está cadastra na base");
    private String  codigo;
    private String  mensagem;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
