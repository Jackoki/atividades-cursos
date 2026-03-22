package br.com.alura.domain;

public class Pet {
    private long id;
    private String tipo;
    private String nome;
    private String raca;
    private int idade;
    private String cor;
    private Float peso;

    public Pet(String tipo, String nome, String raca, int idade, String cor, Float peso){
        this.tipo = tipo;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.cor = cor;
        this.peso = peso;
    }

    public Pet(){

    }

    public long getId(){
        return this.id;
    }
    public String getTipo(){
        return this.tipo;
    }    
    
    public String getNome(){
        return this.nome;
    }    
    
    public String getRaca(){
        return this.raca;
    }    
    
    public int getIdade(){
        return this.idade;
    }   
    
    public String getCor(){
        return this.cor;
    }

    public Float getPeso(){
        return this.peso;
    }
}
