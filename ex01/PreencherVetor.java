package ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PreencherVetor {

    public static void main(String[] args) {
        int[] vetor = new int[5];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            try {
                System.out.print("Informe o valor para a posição " + i + ": ");
                int valor = scanner.nextInt();
                verificarNumeroPositivo(valor);
                vetor[i] = valor;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Posição inexistente no vetor!");
                i--; // Volta para a iteração anterior
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Informe apenas números inteiros.");
                scanner.nextLine(); 
                i--; // Volta para a iteração anterior
            } catch (NegativeNumberException e) {
                System.err.println("Valor inválido! Informe apenas números positivos.");
                i--; // Volta para a iteração anterior
            }
        }

        System.out.println("Vetor preenchido:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Posição " + i + ": " + vetor[i]);
        }

        scanner.close();
    }

    private static void verificarNumeroPositivo(int valor) throws NegativeNumberException {
        if (valor <= 0) {
            throw new NegativeNumberException();
        }
    }

    private static class NegativeNumberException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    }
}
