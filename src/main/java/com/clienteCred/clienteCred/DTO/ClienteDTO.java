package com.clienteCred.clienteCred.DTO;
// classe para tranferir dados para outra classe!

import com.clienteCred.clienteCred.model.ClienteModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public class ClienteDTO {

    @NotBlank
    private String nome;

    @CPF
    private String cpf;

    @NotNull
    private String telefone;

    @NotNull
    private EnderecoDTO endereco;

    @NotNull
    @JsonProperty(value = "rendimento_mensal")
    private BigDecimal rendimentoMensal;

    public ClienteDTO(String nome, String cpf, String telefone, EnderecoDTO endereco, BigDecimal rendimentoMensal) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.rendimentoMensal = rendimentoMensal;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }
    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getRendimentoMensal() {
        return rendimentoMensal;
    }
    public void setRendimentoMensal(BigDecimal rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }

    public ClienteModel toModel(){
        return new ClienteModel(
                nome,
                cpf,
                telefone,
                rendimentoMensal,
                endereco.toModel()
        );
    }

}
