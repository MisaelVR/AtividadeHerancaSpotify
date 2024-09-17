public class Musica {
    private String titulo;
    private String artista;
    private int minutos;  // Duração em minutos
    private int segundos; // Duração em segundos

    public Musica(String titulo, String artista, int minutos, int segundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void exibirInfo() {
        System.out.printf("Título: %s, Artista: %s, Duração: %d:%02d minutos\n", titulo, artista, minutos, segundos);
    }
}
