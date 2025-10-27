package classes;

public abstract class Carta {
    private String nome;
    private int poder;
    protected static int cartasJogadas = 0;

    public Carta(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
    }

    public String getNome() {
        return nome;
    }

    public int getPoder() {
        return poder;
    }

    public static int getCartasJogadas() {
        return cartasJogadas;
    }

    public abstract void jogar(Jogavel jogadorDaVez, Jogavel jogadorAtacado);

    @Override
    public String toString() {
        return "nome: " + nome +
                "  |  poder: " + poder +
                "  |  cartasJogadas: " + cartasJogadas;
    }
}
