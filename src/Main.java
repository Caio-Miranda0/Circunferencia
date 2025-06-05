import java.util.HashMap;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o valor inicial: ");
		int primeiroValor = sc.nextInt();
		
		System.out.print("Digite o valor final: ");
		int ultimoValor = sc.nextInt();
		
		HashMap<Integer, Integer> numerosCalculados = new HashMap<>();
		
		externo : for(int i = primeiroValor; i <= ultimoValor; i++) {
			
			if(i == 1) {
				numerosCalculados.put(i, 1);
				continue;
			}
			
			int totalDivisores = 2;
			
			interno : for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					totalDivisores++;
				} // fim if
			} // fim loop interno
			
			numerosCalculados.put(i, totalDivisores);
		} // fim loop externo
		
		int numeroComMaisDivisores = 0;
		int quantidadeDivisores = 0;
		for(Integer valor : numerosCalculados.keySet()) {
			System.out.println("Número: " + valor + " Quantidade de divisores: " + numerosCalculados.get(valor));
			if(numerosCalculados.get(valor) > quantidadeDivisores) {
				numeroComMaisDivisores = valor;
				quantidadeDivisores = numerosCalculados.get(valor);
			}
		}
		
		System.out.println("De " + primeiroValor + " até " + ultimoValor + ", o primeiro número encontrado com mais divisores que os anteriores foi:");
		System.out.println(numeroComMaisDivisores + " (" +numerosCalculados.get(numeroComMaisDivisores)+" divisores).");
		sc.close();
	}

}
