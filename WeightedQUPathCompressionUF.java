// WeightedQUPathCompressionUF.java
public class WeightedQUPathCompressionUF {
    // Arrays para armazenar os identificadores dos componentes conectados e os tamanhos dos componentes
    private int[] id;
    private int[] sz;

    // Construtor que inicializa o objeto WeightedQUPathCompressionUF com N pontos
    public WeightedQUPathCompressionUF(int N) {
        id = new int[N];
        sz = new int[N];
        // Inicializa os arrays id e sz com valores sequenciais de 0 a N-1 e define o tamanho inicial de cada componente como 1
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    // Método privado para encontrar o componente raiz de um ponto com compressão de caminho
    private int root(int i) {
        // Percorre os componentes até encontrar a raiz
        while (i != id[i]) {
            id[i] = id[id[i]]; // Compressão de caminho
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

    // Conecta os pontos p e q, unindo seus componentes com ponderação de árvore
    public void union(int p, int q) {
        // Encontra as raízes dos componentes que contêm os pontos p e q
        int i = root(p);
        int j = root(q);
        // Verifica se os pontos já estão no mesmo componente
        if (i == j) return;
        // Une os componentes, dando preferência ao componente com menor tamanho
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
