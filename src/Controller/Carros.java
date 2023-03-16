package Controller;

import java.util.concurrent.Semaphore;

public class Carros extends Thread
{
	private int idcarro;
	Semaphore semaforo;
	public Carros(int idcarro, Semaphore semaforo)
	{
		this.idcarro = idcarro;
		this.semaforo = semaforo;
	}
	public void run ()
	{
		CarroAndando();
		//---->Inicio da Sessão Critica<----
		try {
			semaforo.acquire();
			CarroCruzamento();
		} catch (InterruptedException e) 
		   {
			e.printStackTrace();
		   }finally
		     {
			   semaforo.release();
		     }
		//---->Fim da Sesssão Critica<----
		CarroSaiu();
	}
	private void CarroAndando() 
	{
		int DistanciaPercorrida = 0;
		int DistanciaTotal= (int) ((Math.random()*500)+101);
		int Tempo = 1000; //1000 milisegundos 
		int Deslocamento = 100; // 100 metros
		while(DistanciaPercorrida < DistanciaTotal)
		{
			DistanciaPercorrida += Deslocamento;
			try {
				sleep(Tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O Carro "+ idcarro + " Ja andou "+ DistanciaPercorrida + "m");
		}
	}
	private void CarroCruzamento() 
	{
		System.out.println("#O Carro " +idcarro+" Chegou no Cruzamento");
		int Tempo = (int)(Math.random()*1001);
		try {
			sleep(Tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
	}
	private void CarroSaiu() 
	{
		if(idcarro == 1) 
		{
			System.out.println("O carro " + idcarro + " foi de Norte a Sul");
		}
		if(idcarro == 2) 
		{
			System.out.println("O carro " + idcarro + " foi de Sul a Norte");
		}
		if(idcarro == 3) 
		{
			System.out.println("O carro " + idcarro + " foi de Leste a Oeste");
		}
		if(idcarro == 4) 
		{
			System.out.println("O carro " + idcarro + " foi de Oeste a Leste");
		} 
	}
}
