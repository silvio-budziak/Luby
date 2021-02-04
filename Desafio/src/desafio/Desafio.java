
package desafio;
import java.util.Scanner;

public class Desafio {

public static void main(String[] args) {
    int op=0;
    Scanner input = new Scanner(System.in);
		
//Cria a maquina de venda
    MaquinaDeVenda maq = new MaquinaDeVenda();
		
//Cria um estoque basico
    maq.addProduto(new Produto(5.0,"coca-cola",10));
    maq.addProduto(new Produto(4.8,"Pepsi",6));
    maq.addProduto(new Produto(4.6,"fanta",5));
    maq.addProduto(new Produto(4.4,"guarana",9));
		
    while(op!=4) {
        System.out.println();
        System.out.println("-----------MENU-----------");
	System.out.println();
	System.out.println("1.Comprar produto");
	System.out.println("2.Visualizar estoque");
	System.out.println("3.Valor total das vendas");
	System.out.println("4.Sair");
	System.out.printf("Selecione a opcao desejada = ");
	op = input.nextInt();
			
	switch(op) {
			
	case 1:
            maq.comprarProduto(input);
	break;	
				
	case 2:
            maq.visualizarEstoque();
	break;
				
	case 3:
            maq.printValorTotal();
	break;
				
	case 4:
            System.out.println("Programa finalizado");
	break;	
			
	default:
            System.out.println("Opcao nao existe");
	break;	
	}		
    }
	input.close();
}
}
  
