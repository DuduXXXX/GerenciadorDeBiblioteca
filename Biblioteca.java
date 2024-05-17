import java.util.ArrayList;
import java.util.List;


public class Biblioteca {
    private List<Livro> acervo;

    public Biblioteca(){
        acervo = new ArrayList<>(); 
    }

    // ter acesso total do acervo
    public List<Livro> getAcervo(){
        return acervo;
    }

    // ter o acervo filtrado pelo titulo
    public List<Livro> getAcervo(String TituloContem){
        List<Livro> LivrosEncontrados = new ArrayList<>();
        
        for (Livro livro : acervo){
            if (livro.getTitulo().contains(TituloContem))
                LivrosEncontrados.add(livro);
        }
        return LivrosEncontrados;
    }

    
    // Adicionar Livro
    public void adicionarLivro(Livro livro) throws Exception{
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()){
            throw new Exception("O titulo do livro é obrigatório.");
        }
        if (livro.getAutor() == null || livro.getAutor().isEmpty()){
            throw new Exception("O autor do livro é obrigatório.");
        }
        if (livro.getAnoPublicacao() < 0){
            throw new Exception("O ano deve ser maior que zero.");
        }
        if (livro.getNumeroPaginas() < 0){
            throw new Exception("O número de páginas deve ser maior que zero.");
        }

        for (Livro L : acervo){
            if (L.getTitulo().equalsIgnoreCase(livro.getTitulo())){
                throw new Exception("Já existe um livro com esse título cadastrado no acervo.");
            }
        }
        acervo.add(livro);
    }


    // Remover Livro
    public void removerLivro(Livro livro){
        acervo.remove(livro);
    }
    

    // Listar Livro
    public void listarLivros(){
        if (acervo.isEmpty()) {
            System.out.println("Não há livros no acervo para serem listados.");
            return;
        }
        System.out.println("=== Livros no acervo ===");
        for (Livro livro : acervo){
            System.out.println(livro);
        }
    }
    

    // buscar
    public Livro buscarLivro(String titulo){
        for (Livro livro : acervo){
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                return livro;
            }
        }
        return null;
    }

}
