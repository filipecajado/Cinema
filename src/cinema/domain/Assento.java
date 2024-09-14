package cinema.domain;

public class Assento {
	private boolean[][] disponivel = new boolean[5][4];

	public Assento() {
		for (int i = 0; i < disponivel.length; i++) {
			for (int j = 0; j < disponivel[i].length; j++) {
				disponivel[i][j] = true;
			}
		}
	}

	public boolean isDisponivel(int fila, int assento) {
		return disponivel[fila][assento];
	}

	public String mostraLugares() {
		StringBuilder lugares = new StringBuilder();
		
	    lugares.append("    "); 
	    for (int j = 0; j < disponivel[0].length; j++) {
	        lugares.append((j + 1) + "   "); 
	    }
	    
	    lugares.append("\n");
		for (int i = 0; i < disponivel.length; i++) {
			lugares.append((i + 1) + " |");
			for (int j = 0; j < disponivel[i].length; j++) {
				if (disponivel[i][j]) {
					lugares.append("   |");
				} else {
					lugares.append(" X |");
				}
			}
			lugares.append("\n");
		}
		return lugares.toString();
	}
	
    public void ocuparAssento(int fila, int lugar) {
        disponivel[fila][lugar] = false;
    }

}
