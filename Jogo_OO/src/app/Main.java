package app;

import classes.Carta;
import classes.CartaAtaque;
import classes.CartaDefesa;
import classes.Jogador;

import java.util.ArrayList;

public class Main {
    private Jogador jogador1;
    private Jogador jogador2;
    private ArrayList<Carta> baralho;

    public static void main(String[] args) {
    }

    public void cadastro() {
        jogador1 = new Jogador("Rafael");
        jogador2 = new Jogador("Thanos");

        ArrayList<Carta> baralho = new ArrayList<>();

        baralho.add(new CartaAtaque("Tapa", 10));
        baralho.add(new CartaDefesa("Armadura de pano", 10));
        baralho.add(new CartaAtaque("Joelhada", 40));
        baralho.add(new CartaAtaque("Soco", 20));
        baralho.add(new CartaDefesa("Armadura de Ferro", 15));
        baralho.add(new CartaAtaque("Chute", 30));
        baralho.add(new CartaDefesa("Armadura de diamante", 20));
    }

    public Jogador determinarVencedor() {
        if (jogador1.getVida() > jogador2.getVida()) {
            return jogador1;
        }
        if (jogador2.getVida() > jogador1.getVida()) {
            return jogador2;
        }
        if (jogador1.getDefesa() > jogador2.getDefesa()) {
            return jogador1;
        }
        if (jogador2.getDefesa() > jogador1.getDefesa()) {
            return jogador2;
        }
        return null;
    }

    public boolean ambosVivos() {
        return jogador1.estaVivo() && jogador2.estaVivo();
    }
}