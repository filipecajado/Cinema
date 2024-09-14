package cinema.domain;

public class Secao {
	private String nomeFilme;
	private String horario;
	private static final double PRECO = 50.00;
	private Assento assentos;

	public Secao(String nomeFilme, String horario) {
		this.nomeFilme = nomeFilme;
		this.horario = horario;
		this.assentos = new Assento();
	}

	public boolean venda(int fila, int lugar) {
		if (assentos.isDisponivel(fila, lugar)) {
			assentos.ocuparAssento(fila, lugar);
			return true;
		} else {
			return false;
		}
	}

	public String mostraAssentos() {
		return assentos.mostraLugares();
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public String getHorario() {
		return horario;
	}

	public double getPreco() {
		return PRECO;
	}
}
