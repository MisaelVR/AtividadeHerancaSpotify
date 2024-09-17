import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String email;
    protected List<Musica> historico;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.historico = new ArrayList<>();
    }

    public void reproduzirMusica(Musica musica) {
        historico.add(musica);
        System.out.println("Reproduzindo: " + musica.getTitulo());
    }

    public void verHistorico() {
        System.out.println("Histórico de músicas:");
        for (Musica musica : historico) {
            musica.exibirInfo();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
