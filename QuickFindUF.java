public class QuickFindUF {
    public static void main(String[] args) {
        // Método principal, utilizado para testar a classe QuickFindUF
    }
    
    // Classe QuickFindUF implementa o algoritmo de Quick Find
    
    // Array para armazenar os identificadores dos componentes conectados
    private int[] id;

    // Construtor que inicializa o objeto QuickFindUF com N pontos
    public QuickFindUF(int N) {
        id = new int[N];
        // Inicializa o array id com valores sequenciais de 0 a N-1
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // Verifica se os pontos p e q estão conectados
    public boolean connected(int p, int q) {
        // Retorna verdadeiro se os pontos p e q possuem o mesmo identificador
        return id[p] == id[q];
    }

    // Conecta os pontos p e q, unindo seus componentes
    public void union(int p, int q) {
        // Obtém os identificadores dos componentes que contêm os pontos p e q
        int pid = id[p];
        int qid = id[q];
        // Percorre o array id e atualiza os identificadores dos componentes de p para q
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}
