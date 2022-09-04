package app;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entidades.Companhia;
import entidades.Contribuinte;
import entidades.Individual;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<>();
		
		System.out.print("Digite o número de contribuintes: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Contribuinte #" + i + " dados:");
			System.out.print("Individual ou empresa (i/e)? ");
			char type = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Renda anual: ");
			double renda = sc.nextDouble();
			if (type == 'i') {
				System.out.print("Gastos com saúde: ");
				double DespesasDaSaude = sc.nextDouble();
				list.add(new Individual(nome, renda, DespesasDaSaude));
			}
			else {
				System.out.print("Número de funcionários: ");
				int numeroDeEmpregados = sc.nextInt();
				list.add(new Companhia(nome, renda, numeroDeEmpregados));
			}
		}

		double sum = 0.0;
		System.out.println();
		System.out.println("IMPOSTOS PAGOS:");
		for (Contribuinte tp : list) {
			double imposto = tp.imposto();
			System.out.println(tp.getNome() + ": $ " + String.format("%.2f", imposto));
			sum += imposto;
		}
		
		System.out.println();
		System.out.println("IMPOSTOS TOTAIS: $ "  + String.format("%.2f", sum));
		
		sc.close();
	}
}