package com.exemplo.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@RequestScoped
public class ProdutoBean implements Serializable {
    private String descricao;
    private Date dataValidade;
    private Date dataCadastro;
    private Double preco;
    private boolean ativo;

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    // Método para limpar os campos
    public String limpar() {
        this.descricao = null;
        this.dataValidade = null;
        this.dataCadastro = null;
        this.preco = null;
        this.ativo = false;
        return null;
    }

    // Método para gravar os dados (simulação)
    public String gravar() {
        FacesContext context = FacesContext.getCurrentInstance();

        // Validação manual (opcional, já que o required="true" faz isso)
        if (descricao == null || descricao.isEmpty() || preco == null) {
            context.addMessage(null, new FacesMessage("Descrição e Preço são obrigatórios!"));
            return null;
        }

        // Simulação de gravação
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de Validade: " + dataValidade);
        System.out.println("Data de Cadastro: " + dataCadastro);
        System.out.println("Preço: " + preco);
        System.out.println("Ativo: " + ativo);

        // Mensagem de sucesso
        context.addMessage(null, new FacesMessage("Dados gravados com sucesso!"));

        // Limpa os campos após gravar
        limpar();

        return null;
    }
}