package practico5;

public class MagicBoard {
	
	//ATTRIBUTES
	private int[][] board;				//tablero
	private int size;					//tama�o (lado) del tablero
	private int K;						//cantidad ee n�meros que puedo usar
	private int S;						//suma que debe dar
	private int[] sumRows;				//aux que almacena las sumas de las filas
	private int[] sumCols;				//aux que almacena las sumas de las columnas
	private boolean[] numbers;			//indica si el n�m se us� � no

	//CONSTRUCTOR
	public MagicBoard(int size) {
		this.size = size;
		board = new int[this.size][this.size];
		this.sumRows = new int[this.size];
		this.sumCols = new int[this.size];
	}
	
	//METHODS
	
	/**
	 * si el int es v�lido setea la cantidad de n�m a utilizar y crea el array de boolean con valores false
	 * informa si el valor no cumple con la restricci�n
	 * @param k int cantidad de n�m
	 */
	public void setK (int k){
		if (k > size*size){
			this.K = k;
			this.numbers = new boolean[this.K];
			for (int i = 0; i < this.K; i++){
				this.numbers[i] = false;
			}
		}
		else {
			System.out.println("Ingrese un numero mayor");
		}
	}
	
	/**
	 * setea el valor de la suma objetivo
	 * @param s int valor
	 */
	public void setS (int s){
		this.S = s;
	}
	
	/**
	 * arranca el backtracking con el id 0, si encuentra soluci�n la imprime
	 */
	public void fillBoard(){
		if (this.backtracking(0)){		
			this.printBoard();
		}
		else {
			System.out.println("No existe la soluci�n");
		}
	}
	
	/**
	 * entra con un id de casillero y calcula fila y columna, si es el �ltimo casillero corta si ya es soluci�n
	 * prueba con cada n�m disponible, lo coloca en el casillero y hace las sumas correspondientes,
	 * si es v�lido vuelve a entrar con el casillero siguiente, si no vuelve el casillero a 0 y descuenta el valor de las sumas
	 * @param id n�m de identificaci�n del casillero, dividido por el tama�o indica la fila y el el resto de la divisi�n la columna
	 * @return boolean si encontro soluci�n 
	 */
	private boolean backtracking(int id){
		int r = id/this.size;
		int c = id%this.size;
		//checkea si es �ltimo casillero y si es, si ya es soluci�n, si no sigue probando con el loop de n�m disponibles
		if (id == ((this.size*this.size)-1)){
			if (isSolution()){
				return true;
			}
		}
		//loop de prueba de los n�meros disponibles
		for (int aux = 0; aux < this.K; aux++){
			if (!this.used(aux)){										//se fija si el n�mero est� disponible
				this.numbers[aux] = true;								//lo marca como usado
				this.board[r][c] = aux+1;								//lo coloca en el casillero				
				this.sumRows[r] += aux+1;								//lo suma al total de la fila
				this.sumCols[c] += aux+1;								//lo suma al total de la columna
				if ((isValid(id, r, c)) && (this.backtracking(id+1))){	//checkea validez del n�mero y llama al back con el
					return true;										//casillero siguiente. Corta cuando encontr� soluci�n
				}
				else {
					this.resetNumber(aux);								//si no era v�lido (� esta volviendo) deja el n�mero disponible
					this.board[r][c] = 0;								//vuelve el casillero a 0
					this.sumRows[r] -= aux+1;							//elimina el valor de las sumas
					this.sumCols[c] -= aux+1;	
				}
			}
		}
		return false;
	}
	
	
	/**
	 * primero comprueba que los valores de las sumas no se pasen del l�mite
	 * despu�s mira si es �ltima columna y/� �ltima fila y si es, comprueba que den la suma 
	 * @param id del casillero
	 * @param r fila
	 * @param c columna
	 * @return boolean si es v�lido
	 */
	private boolean isValid(int id, int r, int c){
		//siempre checkea que no se pase del l�mite
		if ((this.sumCols[c] > this.S) || (this.sumRows[r] > this.S)){
			return false;
		}
		//si es �ltima fila, comprueba la suma de la columna. si no es el valor objetivo marca el n�mero como no v�lido
		if (id/this.size == this.size-1){
			if (!this.checkCol(c)){
				return false;
			}
		}
		//si es �ltima columna, comprueba la suma de la fila
		if (id%this.size == this.size-1){
			if (!this.checkRow(r)){
				return false;
			}
		}
		//si no encontr� ninguna de esas situaciones, el n�mero es v�lido
		return true;
	}
	
	/**
	 * se fija si el n�mero esta disponible
	 * @param n n�mero a analizar
	 * @return boolean usaso � no
	 */
	private boolean used(int n){
		return this.numbers[n];
	}
	
	
	/**
	 * vuelve a dejar disponible el n�mero
	 * @param n n�mero del que se debe cambiar el estado
	 */
	private void resetNumber(int n){
		this.numbers[n] = false;
	}
	
	/**
	 * comprueba que todas las sumas sean correctas
	 * @return boolean 
	 */
	private boolean isSolution (){
		boolean result = true;
		for (int i = 0; i < this.size; i++){
			if (this.sumRows[i] != this.S){
				result = false;
			}
		}
		if (result){
			for (int j = 0; j < this.size; j++){
				if (this.sumCols[j] != this.S){
					result = false;
				}
			}
		}
		return result;
	}
	
	/**
	 * comprueba la suma de una fila
	 * @param r fila a comprobar
	 * @return boolean
	 */
	private boolean checkRow (int r){
		return (this.sumRows[r] == this.S);
	}
	
	
	/**
	 * comprueba la suma de una columna
	 * @param c columna a comprbar
	 * @return boolean
	 */
	private boolean checkCol (int c){
		return (this.sumCols[c] == this.S);
	}
	
	
	/**
	 * imprime el tablero
	 */
	private void printBoard(){
		for (int i = 0; i < this.size; i++){
			for (int j = 0; j < this.size; j++) {
				System.out.print(" " + this.board[i][j]);
			}
			System.out.println("");
		}
	}

}
