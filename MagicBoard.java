package practico5;

public class MagicBoard {
	
	//ATTRIBUTES
	private int[][] board;				//tablero
	private int size;					//tamaño (lado) del tablero
	private int K;						//cantidad ee números que puedo usar
	private int S;						//suma que debe dar
	private int[] sumRows;				//aux que almacena las sumas de las filas
	private int[] sumCols;				//aux que almacena las sumas de las columnas
	private boolean[] numbers;			//indica si el núm se usó ó no

	//CONSTRUCTOR
	public MagicBoard(int size) {
		this.size = size;
		board = new int[this.size][this.size];
		this.sumRows = new int[this.size];
		this.sumCols = new int[this.size];
	}
	
	//METHODS
	
	/**
	 * si el int es válido setea la cantidad de núm a utilizar y crea el array de boolean con valores false
	 * informa si el valor no cumple con la restricción
	 * @param k int cantidad de núm
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
	 * arranca el backtracking con el id 0, si encuentra solución la imprime
	 */
	public void fillBoard(){
		if (this.backtracking(0)){		
			this.printBoard();
		}
		else {
			System.out.println("No existe la solución");
		}
	}
	
	/**
	 * entra con un id de casillero y calcula fila y columna, si es el último casillero corta si ya es solución
	 * prueba con cada núm disponible, lo coloca en el casillero y hace las sumas correspondientes,
	 * si es válido vuelve a entrar con el casillero siguiente, si no vuelve el casillero a 0 y descuenta el valor de las sumas
	 * @param id núm de identificación del casillero, dividido por el tamaño indica la fila y el el resto de la división la columna
	 * @return boolean si encontro solución 
	 */
	private boolean backtracking(int id){
		int r = id/this.size;
		int c = id%this.size;
		//checkea si es último casillero y si es, si ya es solución, si no sigue probando con el loop de núm disponibles
		if (id == ((this.size*this.size)-1)){
			if (isSolution()){
				return true;
			}
		}
		//loop de prueba de los números disponibles
		for (int aux = 0; aux < this.K; aux++){
			if (!this.used(aux)){										//se fija si el número está disponible
				this.numbers[aux] = true;								//lo marca como usado
				this.board[r][c] = aux+1;								//lo coloca en el casillero				
				this.sumRows[r] += aux+1;								//lo suma al total de la fila
				this.sumCols[c] += aux+1;								//lo suma al total de la columna
				if ((isValid(id, r, c)) && (this.backtracking(id+1))){	//checkea validez del número y llama al back con el
					return true;										//casillero siguiente. Corta cuando encontró solución
				}
				else {
					this.resetNumber(aux);								//si no era válido (ó esta volviendo) deja el número disponible
					this.board[r][c] = 0;								//vuelve el casillero a 0
					this.sumRows[r] -= aux+1;							//elimina el valor de las sumas
					this.sumCols[c] -= aux+1;	
				}
			}
		}
		return false;
	}
	
	
	/**
	 * primero comprueba que los valores de las sumas no se pasen del límite
	 * después mira si es última columna y/ó última fila y si es, comprueba que den la suma 
	 * @param id del casillero
	 * @param r fila
	 * @param c columna
	 * @return boolean si es válido
	 */
	private boolean isValid(int id, int r, int c){
		//siempre checkea que no se pase del límite
		if ((this.sumCols[c] > this.S) || (this.sumRows[r] > this.S)){
			return false;
		}
		//si es última fila, comprueba la suma de la columna. si no es el valor objetivo marca el número como no válido
		if (id/this.size == this.size-1){
			if (!this.checkCol(c)){
				return false;
			}
		}
		//si es última columna, comprueba la suma de la fila
		if (id%this.size == this.size-1){
			if (!this.checkRow(r)){
				return false;
			}
		}
		//si no encontró ninguna de esas situaciones, el número es válido
		return true;
	}
	
	/**
	 * se fija si el número esta disponible
	 * @param n número a analizar
	 * @return boolean usaso ó no
	 */
	private boolean used(int n){
		return this.numbers[n];
	}
	
	
	/**
	 * vuelve a dejar disponible el número
	 * @param n número del que se debe cambiar el estado
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
