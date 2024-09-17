import java.util.ArrayList;
import java.util.List;

public class ContaPremium extends Usuario {
    private float custoMensal;
    private List<Musica> musicasBaixadas;

    public ContaPremium(String nome, String email, float custoMensal) {
        super(nome, email);
        this.custoMensal = custoMensal;
        this.musicasBaixadas = new ArrayList<>();
    }

    public void baixarMusica(Musica musica) {
        musicasBaixadas.add(musica);
        System.out.println("Baixando música: " + musica.getTitulo());
    }

    public void verMusicasBaixadas() {
        System.out.println("Músicas baixadas:");
        for (Musica musica : musicasBaixadas) {
            musica.exibirInfo();
        }
    }

    public float getCustoMensal() {
        return custoMensal;
    }
}
