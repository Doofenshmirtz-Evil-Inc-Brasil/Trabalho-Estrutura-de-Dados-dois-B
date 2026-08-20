import java.util.Random;


    // Bubble Sort
    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] tamanhos = {10, 100, 10000, 100000, 1000000};
        Random random = new Random();

        for (int tamanho : tamanhos) {

            int[] vetor = new int[tamanho];

            // Preenche o vetor com valores aleatórios
            for (int i = 0; i < tamanho; i++) {
                vetor[i] = random.nextInt(1000000);
            }

            long startTime = System.nanoTime();

            // Código a ser medido
            bubbleSort(vetor);

            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.printf("Tamanho: %,d -> Tempo: %.3f ms%n",
                    tamanho, duration / 1000000.0);
        }
    }
