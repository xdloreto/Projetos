/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gustavo Loreto
 */
public class Produto {
    
   private int id;
   private String nome;
   private String unidade_medida;
   private Float preco;
   private Float estoque;
   
   public Produto(String nome){
       this.nome = nome;
   }
   
      public Produto(String nome, String unidade_medida, Float preco, Float estoque) {
        this.nome = nome;
        this.unidade_medida = unidade_medida;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(int id, String nome, String unidade_medida, Float preco, Float estoque) {
        this.id = id;
        this.nome = nome;
        this.unidade_medida = unidade_medida;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getEstoque() {
        return estoque;
    }

    public void setEstoque(Float estoque) {
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}