package com.dryve.dryvecarros.exception;

public class ErroNegocialException  extends Exception{
    private String message;
    private String cause;
    private String classe;
    private String support;

    protected  ErroNegocialException() {}

    public ErroNegocialException(String message, String cause) {
        this.message = message;
        this.cause = cause;
        //this.classe = classe;
        //  this.nextActions = nextActions;
        // this.support = support;
    }

    public ErroNegocialException(EnumMensagensErro mensagensErro){
        super(mensagensErro.getMensagem());
    }

    public ErroNegocialException(String message) {
        super(message) ;
    }
}
