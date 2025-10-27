package classes;

public class CartaAtaque extends Carta {
    public CartaAtaque(String nome, int poder) {
        super(nome, poder);
    }

    @Override
    public void jogar(Jogavel jogadorDaVez, Jogavel jogadorAtacado) {
        jogadorAtacado.atacar(this.getPoder());
        cartasJogadas++;
    }
}