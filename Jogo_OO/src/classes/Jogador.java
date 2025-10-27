package classes;

public class Jogador implements Jogavel {
    private String nome;
    private int vida;
    private int defesa;

    public Jogador(String nome, int vida, int defesa) {
        this.nome = nome;
        this.vida = 2;
        this.defesa = 50;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getDefesa() {
        return defesa;
    }

    @Override
    public void atacar(int poder) {
        this.defesa -= poder;

        if (this.defesa < 0) {
            this.vida--;
            this.defesa += 100;
        }
    }

    @Override
    public void defender(int poder) {
        this.defesa += poder;
    }

    @Override
    public boolean estaVivo() {
        return this.vida > 0 || this.defesa > 0;
    }

    @Override
    public String toString() {
        return this.nome + " -> Vida: " + this.vida + " | Defesa: " + this.defesa;
    }

}
