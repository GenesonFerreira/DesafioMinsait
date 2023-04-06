package com.clienteCred.clienteCred.model;

import com.clienteCred.clienteCred.DTO.ClienteDTO;
import com.clienteCred.clienteCred.DTO.EnderecoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@Entity
public class ClienteModel {

    @NotBlank
    private String nome;

    @Id
    @CPF
    @Column(unique = true)
    private String cpf;

    @NotNull
    private String telefone;

    @NotNull
    private BigDecimal rendimentoMensal;

    @OneToOne
    @JoinColumn(name = "id_do_endereco_model")
    @Cascade(CascadeType.ALL)
    private EnderecoModel enderecoModel;

    public ClienteModel(){

    }

    public ClienteModel(String nome, String cpf, String telefone, BigDecimal rendimentoMensal, EnderecoModel enderecoModel) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rendimentoMensal = rendimentoMensal;
        this.enderecoModel = enderecoModel;
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

    public BigDecimal getRendimentoMensal() {
        return rendimentoMensal;
    }
    public void setRendimentoMensal(BigDecimal rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }

    public EnderecoModel getEnderecoModel() {
        return enderecoModel;
    }
    public void setEnderecoModel(EnderecoModel enderecoModel) {
        this.enderecoModel = enderecoModel;
    }

    public ClienteDTO toDto() {
        return new ClienteDTO(nome,cpf,telefone,enderecoModel.toDto(), rendimentoMensal);
    }
}
