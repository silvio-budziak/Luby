package desafio;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MaquinaDeVenda {
    ArrayList<Produto> estoque; 
    double valorTotal;
		
public MaquinaDeVenda() {
    estoque = new ArrayList<Produto>();
    this.valorTotal = 0;
}
	
public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
}

public ArrayList<Produto> getEstoque() {
    return estoque;
}
	
public void addProduto(Produto prod) {
    this.estoque.add(prod);
}
	
//Formata o valor para que seja em padrao brasileiro de moeda e imprime o valor total das vendas
public void printValorTotal() {
    NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
    DecimalFormat df = (DecimalFormat)nf;
		
    System.out.println();
    System.out.println("Valor total = R$ " + df.format(this.valorTotal));
}
	
//Mostra todo o estoque disponivel de todos os produtos junto com suas quantidades
public void visualizarEstoque() {
    System.out.println();
    System.out.println("-----Estoque atual------");
    System.out.println();
		
    for(int i=0;i<this.estoque.size();i++) {
    System.out.printf("Produto: %s / Quantidade: %d  ", this.estoque.get(i).getNome(), this.estoque.get(i).getQuantidade());
    System.out.println();
    }
}
	
//Pega o produto que sera vendido e faz as verificacoes necessarias para que ele exista e haja quantidade suficiente para venda.
public void comprarProduto(Scanner input) {
    System.out.println();
    System.out.println("Qual produto deseja comprar?");
    System.out.println();
    String prodString;
		
    for(int i=0;i<this.estoque.size();i++) {
        if(this.estoque.get(i).quantidade>0) {
            System.out.println(this.estoque.get(i).getNome());
        }
    }
		
    System.out.println();
		
    input.nextLine();
    System.out.printf("Digite o nome do produto desejado: ");
    prodString = input.nextLine();
		
    for(int i=0;i<this.estoque.size();i++){
        if(prodString.equals(this.estoque.get(i).getNome())) {
            Produto produto = this.estoque.get(i);
        if(produto.getQuantidade() == 0) {
            System.out.println("Sem estoque para o produto");
        break;
        }
				
    System.out.println();
    System.out.println("A lata custa " + produto.toString());
    double valor=0;
				
    NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
    DecimalFormat df = (DecimalFormat)nf;
				
//Valor faltante
    while(valor<produto.getValor()) {
        System.out.println("Insira a quantidade de dinheiro que falta.");
        System.out.printf("Pagar: ");
					
//Recebe o dinheiro e o transforma em double, fazendo as devidas formatacoes
    valor = valor + Double.valueOf(input.next().replace(",", ".")).doubleValue();
    }
				
//Troco, se existir
    if(valor>this.estoque.get(i).getValor()) {
        System.out.println("Retornando R$" + df.format((valor - produto.getValor())) + " de troco");
        valor = produto.getValor();
    }
				
//Altera a quantidade do produto comprado e o valor total de vendas
    produto.setQuantidade(produto.quantidade - 1);
    this.setValorTotal(this.valorTotal + valor);
        }			
    }		
}
}
