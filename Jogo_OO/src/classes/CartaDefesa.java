package classes;

public class CartaDefesa extends Carta {
    public CartaDefesa(String nome, int poder) {
        super(nome, poder);
    }

    @Override
    public void jogar(Jogavel jogadorDaVez, Jogavel jogadorAtacado) {
        jogadorDaVez.defender(this.getPoder());
        cartasJogadas++;
    }
}
