package cinema.main;

import cinema.domain.Secao;
import cinema.inout.InOut;

public class Cinema {
	private Secao[] secoes = new Secao[5];

	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		cinema.menu();

	}
	
	public void menu() {

		int opcao;
		do {
			opcao = InOut.leInt(
					"Escolha uma Opção:\n" + 
					"1. Cadastrar\n" + 
					"2. Vender \n" +
					"3. Sair\n\n" +
					"Filipe Cajado\n");

			switch (opcao) {
			case 1:	
				cadastrarSecoes();
				break;
			case 2:
			    venderAssento();
				break;
			case 3:
				InOut.msgDeAviso("", "Saindo!");
				break;
			default:
				InOut.msgDeErro("ERRO", "Opção Invalida");
			}
		} while (opcao != 3);
	}
	
    private void cadastrarSecoes() {
        for (int i = 0; i < 2; i++) {
            String nomeFilme = InOut.leString("Digite o nome do filme da seção " + (i + 1) + ":");
            String horario = InOut.leString("Digite o horário da seção " + (i + 1) + ":");
            secoes[i] = new Secao(nomeFilme, horario);
        }
    }
    
    private void venderAssento() {
        if (secoes[0] == null) {
        	InOut.msgDeAviso("Ops", "Nenhuma seção cadastrada!"); 
            return;
        }

        var secoesconcat = "";
        for (int i = 0; i < secoes.length; i++) {
            if (secoes[i] != null) { 
                secoesconcat += (i + 1) + " - " + secoes[i].getNomeFilme() + " (" + secoes[i].getHorario() + ")\n";
            }
        }

        int secaoEscolhida = InOut.leInt(secoesconcat +
				"\nEscolha uma seção:") - 1;

        if (secaoEscolhida < 0 || secaoEscolhida >= secoes.length) {
        	InOut.msgDeAviso("Ops", "Seção inválida!"); 
            return;
        }

        Secao secao = secoes[secaoEscolhida];

        int fila = InOut.leInt("Assentos disponíveis:\n" + secao.mostraAssentos() +
				"\nEscolha a fila (1-5) (linha):") - 1 ;
        int lugar = InOut.leInt("Assentos disponíveis:\n" + secao.mostraAssentos() +
				"\nEscolha o lugar (1-4) (coluna):") - 1;

        if (secao.venda(fila, lugar)) {
        	InOut.msgDeInformacao("SUCESSO!", "Assento vendido com sucesso!");
        } else {
            InOut.msgDeAviso("AVISO", "Assento já ocupado!");
        }
    }

}
