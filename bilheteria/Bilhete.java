package bilheteria;
import java.util.Arrays;
import java.util.Random;

public class Bilhete {
    private int[] numerosEscolhidos;
    private int[] numerosSorteados;

    public Bilhete(int[] numerosEscolhidos) {
        // Usamos copyOf para garantir o encapsulamento que aprendemos!
        this.numerosEscolhidos = Arrays.copyOf(numerosEscolhidos, numerosEscolhidos.length);
    }

    public void realizarSorteio() {
        Random random = new Random();
        int[] resultado = new int[6];
        for (int i = 0; i < 6; i++) {
            resultado[i] = random.nextInt(60) + 1;
        }
        Arrays.sort(resultado);
        this.numerosSorteados = resultado;
    }

    public int contarAcertos() {
        int acertos = 0;
        if (numerosSorteados == null) return 0;
        
        for (int escolhido : numerosEscolhidos) {
            for (int sorteado : numerosSorteados) {
                if (escolhido == sorteado) {
                    acertos++;
                    break;
                }
            }
        }
        return acertos;
    }

    public void exibirResultado() {
        System.out.println("Seus números: " + Arrays.toString(numerosEscolhidos));
        System.out.println("Sorteados:    " + Arrays.toString(numerosSorteados));
        System.out.println("Acertos: " + contarAcertos());
    }
}