package DTO;

public class ProdutoDTO {
     private int idProduto;
     private int qtdEstoqueProduto;
     private String nomeProduto;
     private String categoriaProduto;
     private double preco;
     
     public ProdutoDTO(){}

    public ProdutoDTO(int idProduto, int qtdEstoqueProduto, String nomeProduto, String categoriaProduto, double preco) {
        this.idProduto = idProduto;
        this.qtdEstoqueProduto = qtdEstoqueProduto;
        this.nomeProduto = nomeProduto;
        this.categoriaProduto = categoriaProduto;
        this.preco = preco;
       
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtdEstoqueProduto() {
        return qtdEstoqueProduto;
    }

    public void setQtdEstoqueProduto(int qtdEstoqueProduto) {
        this.qtdEstoqueProduto = qtdEstoqueProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
     
}

