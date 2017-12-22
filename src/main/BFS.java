package main;

import java.util.ArrayList;

public class BFS {
	
	private Grafo grafo;
	private Integer nodoInicial;
	private ArrayList<Integer> recorridos;
	private Integer[] distancia;
	private Integer[] padre;
	
	public BFS(Grafo grafo, Integer nodoInicial)
	{
		this.grafo = grafo;
		this.nodoInicial = nodoInicial-1;
		recorridos = new ArrayList<Integer>();
		//El nodo inicial ya está visitado
		distancia = new Integer[this.grafo.obtenerCantNodos()];
		//Lista donde guardo la cantidad de nodos que hay que atravesar para llegar a otro nodo
		padre = new Integer[grafo.obtenerCantNodos()];
		// Lista que me dice que nodo es el padre de otro nodo
	}
	
	public void resolver() // No devuelve nada ya que este metodo obtiene varios datos y dependiendo de cual necesite, invoco al metodo que me devuelve ese dato especifico.
	{
		boolean[] visitiadoAnchura = new boolean[grafo.obtenerCantNodos()];
		 //Lista donde guardo los nodos recorridos
		
		distancia[nodoInicial] = 0; //La cantidad de nodos a atravesar para llegar al nodoInicial es siempre 0
		padre[nodoInicial] = null; //El padre del nodoInicial siempre es nulo
		
		visitiadoAnchura[nodoInicial] = true;
		//Cola de visitas de los nodos adyacentes
		ArrayList<Integer> cola = new ArrayList<Integer>();
		//Se lista el nodo como ya recorrido
		recorridos.add(nodoInicial);
		//Se agrega el nodo a la cola de visitas
		cola.add(nodoInicial);
		//Hasta que visite todos los nodos
		while (!cola.isEmpty()) {
		  int j = cola.remove(0); //Se saca el primero nodo de la cola
		//Se busca en la matriz que representa el grafo los nodos adyacentes
		    for (int i = 0; i < grafo.obtenerCantNodos(); i++) {
		      //Si es un nodo adyacente y no está visitado entonces
              if (grafo.obtenerValor(j, i) == 1 && !visitiadoAnchura[i]) {
                cola.add(i);//Se agrega a la cola de visitas
                recorridos.add(i);//Se marca como recorrido
                visitiadoAnchura[i] = true;//Se marca como visitado
                
                distancia[i] = distancia[j]+1;
                padre[i] = j;
              }
          }
      }
	}

	public ArrayList<Integer> getRecorridos() {
		return recorridos;
	}

	public Integer[] getDistancia() {
		return distancia;
	}

	public Integer[] getPadre() {
		return padre;
	}	
}
