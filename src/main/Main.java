package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc;
		Grafo grafo;
		Integer nodoInicial;
		try
		{
			sc = new Scanner(new File("in4.txt"));
			nodoInicial = sc.nextInt();
			grafo = new Grafo(sc.nextInt(), sc.nextInt());
			grafo.cargarGrafoNodirigido(sc);
			
			try
			{
				sc.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
			
			BFS bfs = new BFS(grafo, nodoInicial);
			bfs.resolver();
			System.out.println("Hola");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}
