
import java.util.*;
public class LubyTestEstagio {

    
public static void main(String[] args) {
	
//1.1
    System.out.println("Fatorial(5) = " + CalcularFatorial(5));
    System.out.println();    
//1.2
    double r1 = CalcularPremio(100,"vip", null);
    double r2 = CalcularPremio(100,"basic", new Double(3));	
	if(r1 != -1) {  System.out.println("Total = " + r1);    }	
	if(r2 != -1) {  System.out.println("Total = " + r2);    }
    System.out.println();        
//1.3
    System.out.println("Total de numeros primos = " + ContarNumerosPrimos(10));
    System.out.println();    
//1.4
    System.out.println("Numero de vogais = " + CalcularVogais("Luby Software"));
    System.out.println();    
//1.5
    System.out.println("Valor com desconto = " + CalcularValorComDescontoFormatado("R$ 6.800,00","30%"));
    System.out.println();   
//1.6
    System.out.println("Dias = " + CalcularDiferencaData("10122020", "25122020"));
    System.out.println();
//1.7
    int vetorE[] = new int[] { 1,2,3,4,5};
    int vetorFinalE[] = ObterElementosPares(vetorE);
    for(int i=0;i<vetorFinalE.length;i++) { 
        System.out.println( vetorFinalE[i]); }
    System.out.println();
//1.8
    String[] vetorP = new String[] {
        "John Doe",
        "Jane Doe",
        "Alice Jones",
        "Bobby Louis",
        "Lisa Romero"
    };		
    String[] vetorFinalP1 = BuscarPessoa(vetorP, "Doe");	    
        for(int i=0;i<vetorFinalP1.length;i++) { 
            System.out.println(vetorFinalP1[i]);     }
    String[] vetorFinalP2 = BuscarPessoa(vetorP, "Alice");	    
        for(int i=0;i<vetorFinalP2.length;i++) {
            System.out.println(vetorFinalP2[i]);    }
    String[] vetorFinalP3 = BuscarPessoa(vetorP, "Louis");	    
        for(int i=0;i<vetorFinalP3.length;i++) {
            System.out.println(vetorFinalP3[i]);    }
        System.out.println();
//1.9
    int[][] mat = TransformarEmMatriz("1,2,3,4,5,6");		
        for(int i=0;i<mat.length;i++) {
	for(int j=0;j<mat[i].length;j++){
            System.out.printf("%d ",mat[i][j]);   }
            System.out.println();   }
    System.out.println();
//1.10
    int[] vetor1 = new int[] { 1,2,3,4,5 };
    int[] vetor2 = new int[] { 1,2,5 };
    int[] vetorFinalF1 = ObterElementosFaltantes(vetor1,vetor2);
        for(int i=0;i<vetorFinalF1.length;i++) {
            System.out.printf("%d ", vetorFinalF1[i]);    }
        System.out.println();
    int[] vetor3 = new int[] { 1,4,5 };
    int[] vetor4 = new int[] { 1,2,3,4,5 };
    int[] vetorFinalF2 = ObterElementosFaltantes(vetor3,vetor4);
        for(int i=0;i<vetorFinalF2.length;i++) {
            System.out.printf("%d ", vetorFinalF2[i]);    }
        System.out.println();
    int[] vetor5 = new int[] { 1,2,3,4 };
    int[] vetor6 = new int[] { 2,3,4,5 };
    int[] vetorFinalF3 = ObterElementosFaltantes(vetor5,vetor6);
        for(int i=0;i<vetorFinalF3.length;i++) {
            System.out.printf("%d ", vetorFinalF3[i]);    }
        System.out.println();
    int[] vetor7 = new int[] { 1,3,4,5 };
    int[] vetor8 = new int[] { 1,3,4,5 };
    int[] vetorFinalF4 = ObterElementosFaltantes(vetor7,vetor8);
        for(int i=0;i<vetorFinalF4.length;i++) {
            System.out.printf("%d ", vetorFinalF4[i]);    }
        System.out.println();
}
    
	
//1.1
public static int CalcularFatorial(int n) {
    int resultado = 1; 
    for (int i = n; i > 1; i--)
        resultado *= i;
	return resultado; }
//1.2
public static double CalcularPremio(double valor, String tipo, Double mult){			
    double total=0;
        if(valor <1){
            System.out.println("Premio nao pode ser negativo ou igual a zero");
      	return -1;
        }else if(mult == null) {
			
    switch(tipo){
        case "basic": 
            total = valor * 1;      break;	
	case "vip": 
            total = valor * 1.2;    break;
        case "premium": 
            total = valor * 1.5;    break;
	case "deluxe": 
            total = valor * 1.8;    break;
	case "special": 
            total = valor * 2;     break;
	default:
            System.out.println("Tipo nao existe");      break;  }
    }else {
        if(mult.compareTo(new Double(0))<=0 || valor <= 0) {
            System.out.println("Premio nao pode ser negativo ou igual a zero");
            return -1;  }
        double m = mult.doubleValue();
            total = valor * m;	}
    return total;  }
//1.3
public static int ContarNumerosPrimos(int n) {
    int cont=0;		
    for(int i=2;i<=n;i++) {			
        int num_div=0;		
    for(int j=2;j<=i/2;j++){
        if(i%j == 0) {
	num_div++;  }   }
    if(num_div == 0) {
        cont++; }   }
    return cont;    }
//1.4
public static int CalcularVogais(String frase) {
    int vogal = 0;
    for(int i = 0; i < frase.length(); i++){
        char c = frase.charAt(i);
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            vogal++;    }   }
        return vogal;   }
//1.5
public static String CalcularValorComDescontoFormatado(String strValor, String strPorcent) {
    Double total = new Double(0);		
    strValor = strValor.replace("R", " ");
    strValor = strValor.replace("$", " ");
    strValor = strValor.replace(".", "");
    strValor = strValor.replace(",", ".");	
    strPorcent = strPorcent.replace("%", " ");		
    Double valor = new Double(0);
        valor = Double.parseDouble(strValor);		
    Double porc = new Double(0);
        porc = Double.parseDouble(strPorcent);
        total = valor - valor * (porc/100);
    String strTotal = total.toString();
    strTotal = String.format("R$ %.2f", total);
    String strFinal = strTotal.replace(".", ",");
        return strFinal;    }
//1.6
public static int CalcularDiferencaData(String strData1, String strData2){
    int dia, mes, ano, dif = 0;                
    Integer diaData1 = new Integer(strData1.substring(0, 2));
    Integer diaData2 = new Integer(strData2.substring(0, 2));		
    Integer mesData1 = new Integer(strData1.substring(2, 4));
    Integer mesData2 = new Integer(strData2.substring(2, 4));				
    Integer anoData1 = new Integer(strData1.substring(4));
    Integer anoData2 = new Integer(strData2.substring(4));				
        ano = anoData2.intValue() - anoData1.intValue();
        mes = mesData2.intValue() - mesData1.intValue();
        dia = diaData2.intValue() - diaData1.intValue();
        dif = ano * 365;
        dif = dif + mes * 30;
        dif = dif + dia;	
    if(dif < 0) { dif = dif * -1; }
    else{   }
        return dif; }
//1.7
public static int[] ObterElementosPares(int vetor[]){
    int vetorAux[] = new int[vetor.length];
    int j=0;
    for(int i=0;i<vetor.length;i++) {
    if(vetor[i]%2==0) {
        vetorAux[j] = vetor[i];
        j++;    }	}
    int vetorFinal[] = new int[j];
    for(int i=0;i<vetorFinal.length;i++) {
        vetorFinal[i] = vetorAux[i];  }
        return vetorFinal;     }
//1.8
public static String[] BuscarPessoa(String vetor[], String conteudo) {		
    String vetorAux[] = new String[vetor.length];
    int j=0;		
    for(int i=0;i<vetor.length;i++) {
    if(vetor[i].contains(conteudo)) {
        vetorAux[j] = vetor[i];
        j++;	}   }
    String vetorFinal[] = new String[j];
    for(int i=0;i<j;i++) {
        vetorFinal[i] = vetorAux[i];  }
    return vetorFinal;	}
//1.9
public static int[][] TransformarEmMatriz(String vetor){		
    char[] arrayChar = vetor.replaceAll(",", "").toCharArray();
    double numPares = (double) arrayChar.length/2;
    int qtdConj = (int) Math.ceil(numPares);
    int [][] array = new int[qtdConj][];
    int k=0;
    for(int i=0;i<qtdConj;i++) {	
        int [] arrayInt;
    if(numPares>0 && numPares<1) {
        arrayInt = new int [1];
    }else {
        arrayInt = new int [2];    }
    for(int j=0;j<arrayInt.length;j++) {
        arrayInt[j] = Integer.parseInt(String.valueOf(arrayChar[k])); 
        numPares = numPares - 0.5;
        k++;    }
        array[i] = arrayInt;   }
    return array;   }
//1.10
public static int[] ObterElementosFaltantes(int[] vetor1, int[] vetor2) {		
    List<Integer> vetor1_list = new ArrayList<> (vetor1.length);
    List<Integer> vetor2_list = new ArrayList<> (vetor2.length);
    List<Integer> elementos_faltantes = new ArrayList<>();
    for (int i : vetor1) {
        vetor1_list.add(Integer.valueOf(i));    }
    for (int i : vetor2) {
       vetor2_list.add(Integer.valueOf(i));    }
    for (Integer i : vetor1_list) {
        if (!vetor2_list.contains(i)) elementos_faltantes.add(i);   }
    for (Integer i : vetor2_list) {
	if (!vetor1_list.contains(i)) elementos_faltantes.add(i);   }
    Integer[] vetorFinal = elementos_faltantes.toArray(new Integer[elementos_faltantes.size()]);
    return Arrays.stream(vetorFinal).mapToInt(Integer::intValue).toArray();
    }
}

    



