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

    // M�todo privado para encontrar o componente raiz de um ponto com compress�o de caminho
    private int root(int i) {
        // Percorre os componentes at� encontrar a raiz
        while (i != id[i]) {
            id[i] = id[id[i]]; // Compress�o de caminho
            i = id[i];
        }
        // Retorna o �ndice da raiz
        return i;
    }

    // Verifica se os pontos p e q est�o conectados
    public boolean connected(int p, int q) {
        // Retorna verdadeiro se os pontos p e q possuem a mesma raiz
        return root(p) == root(q);
    }

    // Conecta os pontos p e q, unindo seus componentes com pondera��o de �rvore
    public void union(int p, int q) {
        // Encontra as ra�zes dos componentes que cont�m os pontos p e q
        int i = root(p);
        int j = root(q);
        // Verifica se os pontos j� est�o no mesmo componente
        if (i == j) return;
        // Une os componentes, dando prefer�ncia ao componente com menor tamanho
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
