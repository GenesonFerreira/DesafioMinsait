package com.clienteCred.clienteCred.DTO;

import com.clienteCred.clienteCred.model.ClienteModel;
import com.clienteCred.clienteCred.model.EnderecoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoDTO {

    @NotBlank
    private String rua;

    @NotNull
    private int numero;

    @NotBlank
    private String cep;


    public EnderecoDTO(String rua, int numero, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public EnderecoModel toModel(){
         return new EnderecoModel(
                 rua,
                 numero,
                 cep
         );
    }

}
