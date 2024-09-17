import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Usuario usuario;
    private static List<Musica> musicas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Adicionando algumas músicas disponíveis com duração em minutos e segundos
        musicas.add(new Musica("Blinding Lights", "The Weeknd", 3, 20));
        musicas.add(new Musica("Viva La Vida", "ColdPlay", 4, 1));
        musicas.add(new Musica("Sorry", "Justin Bieber", 8, 21));
        musicas.add(new Musica("Mirrors", "Justin Bieber", 3, 26));


        boolean running = true;
        while (running) {
            System.out.println("\n1. Criar conta");
            System.out.println("2. Tornar conta Premium");
            System.out.println("3. Reproduzir música");
            System.out.println("4. Baixar música (Premium)");
            System.out.println("5. Ver músicas baixadas (Premium)");
            System.out.println("6. Ver histórico");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o e-mail: ");
                    String email = scanner.nextLine();
                    usuario = new Usuario(nome, email);
                    System.out.println("Conta criada com sucesso!");
                    break;
                case 2:
                    if (usuario != null) {
                        if (!(usuario instanceof ContaPremium)) {
                            System.out.println("Para se tornar Premium, o custo mensal é R$21,90.");
                            System.out.print("Deseja aceitar? (S/N): ");
                            String resposta = scanner.nextLine();
                            if (resposta.equalsIgnoreCase("S")) {
                                usuario = new ContaPremium(usuario.getNome(), usuario.getEmail(), 21.90f);
                                System.out.println("Conta atualizada para Premium!");
                            } else {
                                System.out.println("Promoção cancelada. Voltando ao menu.");
                            }
                        } else {
                            System.out.println("A conta já é Premium.");
                        }
                    } else {
                        System.out.println("Nenhuma conta criada ainda.");
                    }
                    break;
                case 3:
                    if (usuario != null) {
                        System.out.println("Escolha a música para reproduzir:");
                        for (int i = 0; i < musicas.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            musicas.get(i).exibirInfo();
                        }
                        System.out.print("Número da música: ");
                        int escolha = scanner.nextInt();
                        Musica musicaEscolhida = musicas.get(escolha - 1);
                        usuario.reproduzirMusica(musicaEscolhida);
                    } else {
                        System.out.println("Nenhuma conta criada ainda.");
                    }
                    break;
                case 4:
                    if (usuario instanceof ContaPremium) {
                        System.out.println("Escolha a música para baixar:");
                        for (int i = 0; i < musicas.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            musicas.get(i).exibirInfo();
                        }
                        System.out.print("Número da música: ");
                        int escolhaBaixar = scanner.nextInt();
                        Musica musicaBaixar = musicas.get(escolhaBaixar - 1);
                        ((ContaPremium) usuario).baixarMusica(musicaBaixar);
                    } else {
                        System.out.println("Essa funcionalidade está disponível apenas para contas Premium.");
                    }
                    break;
                case 5:
                    if (usuario instanceof ContaPremium) {
                        ((ContaPremium) usuario).verMusicasBaixadas();
                    } else {
                        System.out.println("Essa funcionalidade está disponível apenas para contas Premium.");
                    }
                    break;
                case 6:
                    if (usuario != null) {
                        usuario.verHistorico();
                    } else {
                        System.out.println("Nenhuma conta criada ainda.");
                    }
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
