package app;

import classes.Carta;
import classes.CartaAtaque;
import classes.CartaDefesa;
import classes.Jogador;

import java.util.ArrayList;

public class Main {
    private static Jogador jogador1;
    private static Jogador jogador2;
    private static ArrayList<Carta> baralho;

    public static void main(String[] args) {
        cadastro();
        jogar();
    }

    public static void cadastro() {
        jogador1 = new Jogador("Rafael");
        jogador2 = new Jogador("Thanos");

        baralho = new ArrayList<>();

        baralho.add(new CartaAtaque("Soco", 20));
        baralho.add(new CartaAtaque("Tapa", 10));
        baralho.add(new CartaDefesa("Armadura de pano", 10));
        baralho.add(new CartaAtaque("Joelhada", 40));
        baralho.add(new CartaDefesa("Armadura de Ferro", 15));
        baralho.add(new CartaDefesa("Armadura de diamante", 20));
        baralho.add(new CartaAtaque("Chute", 30));
    }

    public static void jogar() {
        System.out.println("--- STATUS INICIAL ---");
        System.out.println(jogador1);
        System.out.println(jogador2);

        while (ambosVivos() && Carta.getCartasJogadas() < 30) {

            if (jogador1.estaVivo()) {
                rodarTurno(jogador1, jogador2);
            }

            if (!ambosVivos() || Carta.getCartasJogadas() >= 30) {
                break;
            }

            if (jogador2.estaVivo()) {
                rodarTurno(jogador2, jogador1);
            }
        }

        exibirResultadoFinal();
    }

    public static void rodarTurno(Jogador jogador, Jogador inimigo) {
        Carta cartaAtual = proxCarta();

        cartaAtual.jogar(jogador, inimigo);

        exibirResultadoRodada(cartaAtual, jogador, inimigo);
    }

    public static Carta proxCarta() {
        int cartasJogadas = Carta.getCartasJogadas();

        int totalCartas = baralho.size();

        int i = cartasJogadas;

        while (i >= totalCartas) {
            i -= totalCartas;
        }

        return baralho.get(i);
    }

    public static void exibirResultadoRodada(Carta carta, Jogador jogador, Jogador inimigo) {
        System.out.println("---------------------------------");
        System.out.print(jogador.getNome() + " jogou (" + carta.getNome() + ") que vale " + carta.getPoder());

        if (carta instanceof CartaAtaque) {
            System.out.println(" em " + inimigo.getNome());
        } else {
            System.out.println();
        }

        System.out.println("STATUS DOS JOGADORES");
        System.out.println(jogador1);
        System.out.println(jogador2);
        System.out.println();
    }

    public static void exibirResultadoFinal() {
        System.out.println("===== FIM DO JOGO =====");
        System.out.println("\nSTATUS DOS JOGADORES");
        System.out.println(jogador1);
        System.out.println(jogador2);

        Jogador vencedor = determinarVencedor();

        if (vencedor != null) {
            System.out.println("VENCEDOR: " + vencedor.getNome());
        } else {
            System.out.println("VENCEDOR: Empate");
        }

        System.out.println("Cartas jogadas: " + Carta.getCartasJogadas());
    }

    public static Jogador determinarVencedor() {
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

    public static boolean ambosVivos() {
        return jogador1.estaVivo() && jogador2.estaVivo();
    }
}