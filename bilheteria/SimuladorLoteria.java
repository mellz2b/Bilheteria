package bilheteria;
import java.util.Scanner;
import java.util.ArrayList; // Precisamos para guardar vários bilhetes

public class SimuladorLoteria {
    public static void main(String[] args) { // Mudado de int para void
        Scanner scanner = new Scanner(System.in);
        ArrayList<Bilhete> listaDeBilhetes = new ArrayList<>(); // Lista real

        while (true) {
            System.out.println("\n--- Nova Compra ---");
            System.out.println("Digite 6 números para o seu bilhete (ou 0 em qualquer momento para parar):");

            int[] numerosEscolhidos = new int[6];
            boolean parar = false;

            for (int i = 0; i < 6; i++) {
                System.out.print("Número " + (i + 1) + ": ");
                int num = scanner.nextInt();
                
                if (num == 0) {
                    parar = true;
                    break;
                }
                numerosEscolhidos[i] = num;
            }

            if (parar) break;

            // Cria o bilhete e guarda na lista
            Bilhete novoBilhete = new Bilhete(numerosEscolhidos);
            listaDeBilhetes.add(novoBilhete);
            System.out.println("Bilhete comprado com sucesso!");
        }

        System.out.println("\n--- Realizando Sorteio de todos os bilhetes ---");
        for (Bilhete b : listaDeBilhetes) {
            b.realizarSorteio();
            b.exibirResultado();
            System.out.println("---------------------------");
        }

        scanner.close();
    }
}