// QuickUnionUF.java
public class QuickUnionUF {
    // Array para armazenar os identificadores dos componentes conectados
    private int[] id;

    // Construtor que inicializa o objeto QuickUnionUF com N pontos
    public QuickUnionUF(int N) {
        id = new int[N];
        // Inicializa o array id com valores sequenciais de 0 a N-1
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // Método privado para encontrar o componente raiz de um ponto
    private int root(int i) {
        // Percorre os componentes até encontrar a raiz
        while (i != id[i]) {
            i = id[i];
        }
        // Retorna o índice da raiz
        return i;
    }

    // Verifica se os pontos p e q estão conectados
    public boolean connected(int p, int q) {
        // Retorna verdadeiro se os pontos p e q possuem a mesma raiz
        return root(p) == root(q);
    }

    // Conecta os pontos p e q, unindo seus componentes
    public void union(int p, int q) {
        // Encontra as raízes dos componentes que contêm os pontos p e q
        int i = root(p);
        int j = root(q);
        // Define a raiz de p como a raiz de q, unindo os componentes
        id[i] = j;
    }
}
