package grafos;

import java.util.*;

class Grafo {
    private Map<Integer, List<Integer>> vizihos;

    // Construtor para inicializar o grafo
    public Grafo() {
    	vizihos = new HashMap<>();
    }

    // Método para adicionar arestas ao grafo
    public void AdcionarArestas(int node, int neighbor) {
    	vizihos.putIfAbsent(node, new ArrayList<>());
    	vizihos.get(node).add(neighbor);
    }

    // Método DFS recursivo com visualização
    public void BuscaEmProfundidade(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("Iniciando DFS a partir do vértice: " + start);
        BuscaEmProfundidadeHelper(start, visited);
        System.out.println("DFS concluída!");
    }

    // Função auxiliar recursiva que explora o grafo com visualização
    private void BuscaEmProfundidadeHelper(int node, Set<Integer> visited) {
        // Marca o nó como visitado
        visited.add(node);
        System.out.println("Visitando nó: " + node);
        
        // Mostra os vizinhos que serão explorados
        List<Integer> neighbors = vizihos.getOrDefault(node, new ArrayList<>());
        System.out.println("Vizinhos de " + node + ": " + neighbors);

        // Explora os vizinhos não visitados
        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                System.out.println("Explorando vizinho " + neighbor + " de " + node);
                BuscaEmProfundidadeHelper(neighbor, visited);
            } else {
                System.out.println("Vizinho " + neighbor + " já foi visitado.");
            }
        }

        // Após explorar todos os vizinhos, indica o fim da recursão para o nó atual
        System.out.println("Retornando do nó: " + node);
    }

    public static void main(String[] args) {
    	Grafo graph = new Grafo();

        // Adicionando as arestas do grafo
        graph.AdcionarArestas(0, 1);
        graph.AdcionarArestas(0, 2);
        graph.AdcionarArestas(1, 2);
        graph.AdcionarArestas(2, 0);
        graph.AdcionarArestas(2, 3);
        graph.AdcionarArestas(3, 3);

        // Iniciando a busca em profundidade a partir do nó 2
        System.out.println("DFS começando no nó 2:");
        graph.BuscaEmProfundidade(2);
    }
}
