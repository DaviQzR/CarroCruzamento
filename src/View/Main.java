package View;

import java.util.concurrent.Semaphore;

import Controller.Carros;

public class Main 
{

	public static void main(String[] args) 
	{
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for ( int idcarro = 1 ; idcarro <= 4; idcarro ++)
		{
			Carros Roda = new  Carros (idcarro, semaforo); 
			Roda.start();
		}
	}

}
