package aula2;// Classe que representa o Nó da Árvore Binária
class No {
    int valor;
    No esquerda;
    No direita;

    // Construtor do Nó
    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

public class Main {

    /**
     * Função de Rotação Simples à Direita.
     * Recebe o nó desbalanceado 'y' e promove o filho esquerdo 'x' a nova raiz.
     */
    public static No rotacionarDireita(No y) {
        No x = y.esquerda;
        No t2 = x.direita;

        // Executa a reestruturação de ponteiros
        x.direita = y;
        y.esquerda = t2;

        // Retorna o nó 'x' como a nova raiz da subárvore
        return x;
    }

    /**
     * Função de Rotação Simples à Esquerda.
     * Recebe o nó desbalanceado 'x' e promove o filho direito 'y' a nova raiz.
     */
    public static No rotacionarEsquerda(No x) {
        No y = x.direita;
        No t2 = y.esquerda;

        // Executa a reestruturação de ponteiros
        y.esquerda = x;
        x.direita = t2;

        // Retorna o nó 'y' como a nova raiz da subárvore
        return y;
    }

    // Método auxiliar para imprimir o percurso em-ordem (E-V-D)
    public static void emOrdem(No raiz) {
        if (raiz != null) {
            emOrdem(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            emOrdem(raiz.direita);
        }
    }

    // Método auxiliar para desenhar a árvore visualmente no console
    public static void exibirArvore(No raiz, String prefixo, boolean ehEsquerda) {
        if (raiz != null) {
            System.out.println(prefixo + (ehEsquerda ? "├── (E) " : "└── (D) ") + raiz.valor);
            exibirArvore(raiz.esquerda, prefixo + (ehEsquerda ? "│   " : "    "), true);
            exibirArvore(raiz.direita, prefixo + (ehEsquerda ? "│   " : "    "), false);
        }
    }

    public static void main(String[] args) {

        // ======================================================
        // PARTE 1: ROTAÇÃO À DIREITA (árvore desbalanceada à esquerda)
        // ======================================================

        /*
         * Montando manualmente a seguinte árvore desbalanceada à esquerda:
         *
         *          30 (y)
         *         /  \
         *       20(x) 35
         *      /  \
         *    10    25 (t2)
         */

        No y = new No(30);
        No x = new No(20);
        No t2 = new No(25);

        y.esquerda = x;
        y.direita = new No(35);

        x.esquerda = new No(10);
        x.direita = t2; // Este nó 't2' mudará de pai durante a rotação

        System.out.println("==============================================");
        System.out.println(" 1. ÁRVORE ORIGINAL (Antes da Rotação à Direita)");
        System.out.println("==============================================");
        exibirArvore(y, "", false);
        System.out.print("\nCaminhamento Em-Ordem: ");
        emOrdem(y);
        System.out.println("\n");

        // Executa a Rotação à Direita passando a raiz 'y'
        No novaRaiz1 = rotacionarDireita(y);

        /*
         * Estrutura esperada após a rotação:
         *
         *          20 (x)
         *         /  \
         *       10    30 (y)
         *            /  \
         *          25    35
         *         (t2)
         */

        System.out.println("==============================================");
        System.out.println(" 2. ÁRVORE APÓS ROTAÇÃO À DIREITA");
        System.out.println("==============================================");
        exibirArvore(novaRaiz1, "", false);
        System.out.print("\nCaminhamento Em-Ordem: ");
        emOrdem(novaRaiz1);
        System.out.println("\n==============================================\n");


        // ======================================================
        // PARTE 2: ROTAÇÃO À ESQUERDA (árvore desbalanceada à direita)
        // ======================================================

        /*
         * Montando manualmente a seguinte árvore desbalanceada à direita:
         *
         *   10 (a)
         *     \
         *      20 (b)
         *     /  \
         *   15    30
         *  (t2)
         */

        No a = new No(10);
        No b = new No(20);
        No t2b = new No(15);

        a.direita = b;
        b.esquerda = t2b; // Este nó mudará de pai durante a rotação
        b.direita = new No(30);

        System.out.println("==============================================");
        System.out.println(" 3. ÁRVORE ORIGINAL (Antes da Rotação à Esquerda)");
        System.out.println("==============================================");
        exibirArvore(a, "", false);
        System.out.print("\nCaminhamento Em-Ordem: ");
        emOrdem(a);
        System.out.println("\n");

        // Executa a Rotação à Esquerda passando a raiz 'a'
        No novaRaiz2 = rotacionarEsquerda(a);

        /*
         * Estrutura esperada após a rotação:
         *
         *        20 (b)
         *       /  \
         *     10    30
         *  (a)  \
         *        15
         *       (t2)
         */

        System.out.println("==============================================");
        System.out.println(" 4. ÁRVORE APÓS ROTAÇÃO À ESQUERDA");
        System.out.println("==============================================");
        exibirArvore(novaRaiz2, "", false);
        System.out.print("\nCaminhamento Em-Ordem: ");
        emOrdem(novaRaiz2);
        System.out.println("\n==============================================");
    }
}