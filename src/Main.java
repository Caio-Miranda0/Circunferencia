import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o valor inicial: ");
		int primeiroValor = sc.nextInt();

		System.out.print("Digite o valor final: ");
		int ultimoValor = sc.nextInt();

		HashMap<Integer, Integer> numerosCalculados = new HashMap<>();

		int numeroComMaisDivisores = 0;
		int quantidadeDivisores = 0;

		for (int i = primeiroValor; i <= ultimoValor; i++) {

			if (i == 1) {
				numerosCalculados.put(i, 1);
				continue;
			}

			int totalDivisores = 2;

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					totalDivisores++;
				} // fim if
			} // fim loop interno

			numerosCalculados.put(i, totalDivisores);

			if (totalDivisores > quantidadeDivisores) {
				numeroComMaisDivisores = i;
				quantidadeDivisores = totalDivisores;
			}
		} // fim loop externo
		
		System.out.println();
		System.out.print("Deseja saber a quantidade de divisores que cada número da sequência tem? y/n ");
		char opcao = sc.next().toLowerCase().charAt(0);
		
		switch (opcao) {
		case 'y':
			System.out.println();
			for (Integer valor : numerosCalculados.keySet()) {
				System.out.println("Número: " + valor + " Quantidade de divisores: " + numerosCalculados.get(valor));
			}
		default:
			System.out.println();
			System.out.println("De " + primeiroValor + " até " + ultimoValor + ", o primeiro número encontrado com mais divisores que os anteriores foi: ");
			System.out.println(numeroComMaisDivisores + " (" + quantidadeDivisores + " div.)");
		}

		sc.close();
	}

}
