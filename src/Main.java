import model.Autor;
import model.Comic;
import model.Protagonista;
import service.ServicioAutor;
import service.ServicioComic;
import service.ServicioProtagonista;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final ServicioComic servicioComic = new ServicioComic();
    private static final ServicioAutor servicioAutor = new ServicioAutor();
    private static final ServicioProtagonista servicioProtagonista = new ServicioProtagonista();

    public static void main(String[] args) {
        Autor stanLee = new Autor("Stan", "Lee", "estadounidense");
        Autor alanMoore = new Autor("Alan", "Moore", "británica");
        Autor frankMiller = new Autor("Frank", "Miller", "estadounidense");
        Autor hergeRemi = new Autor("Hergé", "Remi", "belga");

        Protagonista spiderMan = new Protagonista("Spider-Man", "superforza e axilidade");
        Protagonista batman = new Protagonista("Batman", "diñeiro");
        Protagonista superman = new Protagonista("Superman", "superforza e batSubvención");
        Protagonista wonderWoman = new Protagonista("Wonder Woman", "superforza e batSubvención");
        Protagonista tintin = new Protagonista("Tintín", "intelixencia e capacidade de investigación");
        Protagonista daredevil = new Protagonista("Daredevil", "case tódo-los sentidos sobrehumanos");

        List<Comic> comicsAInserir = Arrays.asList(
                new Comic("The Amazing Spider-Man", 1963, stanLee, spiderMan),
                new Comic("Batman: The Killing Joke", 1988, alanMoore, batman),
                new Comic("Superman: The Man of Steel", 1986, frankMiller, superman),
                new Comic("Wonder Woman: Gods and Mortals", 1987, alanMoore, wonderWoman),
                new Comic("The Adventures of Tintin", 1929, hergeRemi, tintin),
                new Comic("Daredevil: Born Again", 1986, stanLee, daredevil),
                new Comic("Batman: Year One", 1987, frankMiller, batman),
                new Comic("Spider-Man: Blue", 2002, stanLee, spiderMan)
        );

        //Lista os contidos das táboas seguindo o formato
        System.out.println("LISTAXE INICIAL:");
        listarFormatoRequerido();

        //Actualiza o autor para cambiar o nome
        Autor autor = buscarAutor("Stan", "Lee");
        if (autor != null) {
            autor.setNome("Satan");
            autor.setApelidos("Leee");

            servicioAutor.update(autor);
        }

        //Actualiza o autor para cambiar o nome
        Protagonista protagonista = buscarProtagonista("Spider-Man");
        if (protagonista != null) {
            protagonista.setNome("Spooder-Mon");

            servicioProtagonista.update(protagonista);
        }

        //Lista os contidos das taboas actualizadas co mesmo formato de antes
        System.out.println("\nLISTA ACTUALIZADA:");
        listarFormatoRequerido();

        //Borra o contido das táboas
        servicioComic.borrarTodosOsComics();
        servicioAutor.borrarTodosOsAutores();
        servicioProtagonista.borrarTodosOsProtagonistas();

        //Lista o contido das táboas
        System.out.println("\nLISTA DESPOIS DO BORRADO:");
        listarFormatoRequerido();
    }

    //Imprime seguindo o formato do enunciado
    private static void listarFormatoRequerido() {
        List<Comic> comics = servicioComic.listarComics();

        for (List<Comic> listaAutor : comicsPorAutor.values()) {
            Autor autor = listaAutor.get(0).getAutor();
            System.out.println("Autor:");
            System.out.println(autor.getNome() + " " + autor.getApelidos());
            System.out.println("Comics:");
            for (Comic c : listaAutor) {
                System.out.println(c.getTitulo() + " (" + c.getAno() + ")");
                System.out.println();
                System.out.println("Protagonista: " + c.getProtagonista().getNome() + " poder: " + c.getProtagonista().getPoder());
            }
        }
    }
}