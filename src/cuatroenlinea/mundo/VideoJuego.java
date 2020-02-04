package cuatroenlinea.mundo;

public class VideoJuego {

	
	public static final int MAX_FILAS = 6;
	public static final int MAX_COLUMNAS = 7;
	
	public static final int JUGADOR_NULO = 0;
	public static final int JUGADOR_UNO = 1;
	public static final int JUGADOR_DOS = 2;
	
	private int jugadorActual;
	
	private boolean juegoTerminado;
	
	public Ficha[][] tablero;
	
	public VideoJuego() {
		
		jugadorActual = (int) Math.floor(Math.random()*(2-1+1)+1); 
		juegoTerminado = false;
		tablero = new Ficha[MAX_FILAS][MAX_COLUMNAS];
		for(int i = 0; i < MAX_FILAS; i++)
		{
			for(int j = 0; j < MAX_COLUMNAS; j++)
			{
				tablero[i][j] = new Ficha(i, j, JUGADOR_NULO);
			}
		}
		
	}
	
	public void cambiarJugador()
	{
		if(jugadorActual == JUGADOR_UNO)
		{
			jugadorActual = JUGADOR_DOS;
		}else
		{
			jugadorActual = JUGADOR_UNO;
		}
	}
	
	public int darJugadorActual()
	{
		return jugadorActual;
	}
	
	public int agregarFicha(int pColumna, int pJugador)
	{
		int fila = 0;
		if(tablero[fila][pColumna].getJugador() != JUGADOR_NULO) return -1;
		if(tablero[MAX_FILAS-1][pColumna].getJugador() == JUGADOR_NULO)
		{
			tablero[MAX_FILAS-1][pColumna].setJugador(pJugador);
			return MAX_FILAS-1;
		}
		while(fila < MAX_FILAS)
		{
			if(tablero[fila][pColumna].getJugador() == JUGADOR_NULO)
			{
				fila++;
			}
			else
			{
				tablero[fila-1][pColumna].setJugador(pJugador);
				return fila-1;
			}
		}
		return -1;
	}
	
	
	
	public boolean verificarJugadaJugador(Ficha pFicha)
	{
		if(verificarFilaGanadora(pFicha.getJugador(), pFicha.getPosX())) return true;
		if(verificarColumnaGanadora(pFicha.getJugador(), pFicha.getPosY())) return true;
		
		
		return false;
	}
	
	
	public boolean verificarFilaGanadora(int pJugador, int pFila)
	{
		int columna = 0;
		int contador = 0;
		while(columna < MAX_COLUMNAS)
		{
			if(tablero[pFila][columna].getJugador() == pJugador)
			{
				contador++;
				if(contador == 4)
				{
					return true;
				}
			}else
			{
				contador = 0;
			}
			columna++;
		}
		
		return false;
	}
	
	public boolean verificarColumnaGanadora(int pJugador, int pColumna)
	{
		int fila = 0;
		int contador = 0;
		
		while(fila < MAX_FILAS)
		{
			if(tablero[fila][pColumna].getJugador() == pJugador)
			{
				contador++;
				if(contador == 4)
				{
					return true;
				}
			}else
			{
				contador = 0;
			}
			fila++;
		}
		return false;
	}
	
	public Ficha darPrimeraFichaLateralD(int pX, int pY)
	{
		Ficha ficha = new Ficha(0, 0, 0);
		if( pX > pY)
		{
			ficha.setPosX( pX - pY );
			ficha.setPosY(0);
		}
		else if(pY > pX)
		{
			ficha.setPosY( pY - pX);
			ficha.setPosX(0);
		}
		else
		{
			ficha.setPosX(0);
			ficha.setPosY(0);
		}
		return ficha;
	}
	
	
	public boolean verificarLateralDerecho(int pJugador, int pX, int pY)
	{
		
		return false;
	}
	
	public boolean verificarLateralIzquierdo(int pJugador)
	{
		return false;
	}

}
