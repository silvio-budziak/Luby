package desafio;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Produto {
    double valor;
    int quantidade;
    String nome;

public Produto(double valor, String nome, int qtd) {
    this.valor = valor;
    this.nome = nome;
    this.quantidade = qtd;
}
	
public int getQuantidade() {
    return quantidade;
}

public String getNome() {
    return nome;
}
	
public double getValor() {
    return valor; 
}

public void setValor(double valor) {
    this.valor = valor;
}
	
public void setQuantidade(int qtd) {
    this.quantidade = qtd;
}
	
public String toString() {
    NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
    DecimalFormat df = (DecimalFormat)nf;
    return "R$ " + df.format(valor);
}
}
