import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);

    // MENU
    private static void exibirMenu(){
        System.out.println("\n====== Menu ======");
        System.out.print("Escolha uma opção:\n");
        System.out.println("1 - Adicionar Livro");
        System.out.println("2 - Remover Livro");
        System.out.println("3 - Listar Livros");
        System.out.println("4 - Buscar Livro pelo Título");
        System.out.println("0 - Sair\n");
    }


    // ADD LIVRO
    private static void adicionarLivro(){
        System.out.println("\n=== Adicionar Livro ===");
        System.out.println("Digite o título:");
        String titulo = scanner.nextLine();

        System.out.println("Digite o autor:");
        String autor = scanner.nextLine();

        System.out.println("Digite o ano de publicacão:");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o número de páginas:");
        int paginas = scanner.nextInt();
        scanner.nextLine();
        
        Livro novoLivro = new Livro(titulo, autor, ano, paginas);
        // verificacão
        if (novoLivro != null){
            try{
                biblioteca.adicionarLivro(novoLivro);
                System.out.println("Livro adiciona com sucesso!");
            } catch (Exception e){
                System.out.println();
                System.out.println("Erro ao adicionar livro: " + e.getMessage());
            }
        }
    }


    // REMOVER LIVRO
    private static void removerLivro(){
        System.out.println("\n=== Remover Livro ===");
        System.out.println("Digite o título do livro que deseja remover:");
        String titulo = scanner.nextLine();

        // verificacão
        try {
            Livro livroEncontrado = biblioteca.buscarLivro(titulo);
            if (livroEncontrado != null){
                biblioteca.removerLivro(livroEncontrado);
                System.out.println("Livro removido com sucesso");
            } else {
                System.out.println();
                throw new Exception("Livro com título '" + titulo + "' não encontrado no acervo.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover livro: " + e.getMessage());
        }
    }

    
    // BUSCAR LIVRO
    private static void buscarLivro(){
        System.out.println("\n=== Buscar Livro ===");
        System.out.println("Digite o título a ser buscado:");
        String titulo = scanner.nextLine();
        System.out.println(); 

        // verificacao
        try {
            Livro livroEncontrado = biblioteca.buscarLivro(titulo);
            if (livroEncontrado != null){
                System.out.println("Livro encontrado: \n" + livroEncontrado);
            } else{
                throw new Exception("Livro com título '" + titulo + "' não encontrado no acervo.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar livro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        while(true){
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    removerLivro();
                    break;
                case 3:
                    biblioteca.listarLivros();
                    break;
                case 4:
                    buscarLivro();
                    break;
                case 0:
                    System.out.println("Encerrando.");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
