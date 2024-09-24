import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Classe responsável por ler arquivos de texto e processar seu conteúdo.
 * 
 * A classe ReaderFile fornece métodos para ler arquivos, processar palavras
 * e construir uma árvore binária com as palavras encontradas. Também suporta a leitura
 * de múltiplos arquivos a partir de um diretório.
 * 
 */
public class ReaderFile {

    /**
     * Lê um arquivo de texto do caminho especificado, processa o conteúdo e insere as palavras
     * em uma árvore binária ou lista de palavras adiadas, dependendo do critério definido.
     * 
     * As palavras são normalizadas e removidos caracteres especiais antes de serem inseridas na árvore.
     * 
     *
     * @param path O caminho do arquivo a ser lido.
     */
    public static void readFie(String path) {
        try {
            FileReader archive = new FileReader(path);
            BufferedReader reader = new BufferedReader(archive);
            String line = reader.readLine();

            int countLine = 1;

            BinaryTree tree = new BinaryTree();

            while (line != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = Normalizer.normalize(word, Normalizer.Form.NFD)
                                    .replace("\"", "")
                                    .replace("-", "")
                                    .replace(",", "")
                                    .replace("/", "")
                                    .replace("?", "")
                                    .replace("!", "")
                                    .replace(".", "")
                                    .replace(":", "")
                                    .replace("\\s+", "")
                                    .replace("[\\p{M}]", "")
                                    .toLowerCase();

                    if (word.length() > 2) {
                        if (countLine == 1) {                          
                            if (word.compareTo("a") > 0 && word.compareTo("f") > 0) {
                                tree.insert(new Node(word, new Line(countLine)));
                            } else {
                                tree.insert(new Node(word, new Line(countLine)));
                            }
                        } else {
                            tree.insert(new Node(word, new Line(countLine)));
                        }
                    }
                }

                countLine++;
                line = reader.readLine();
            }

            tree.onOrder();
            reader.close();

        } catch (IOException e) {
            System.err.printf("Error opening file: %s\n", e.getMessage());
        }
    }

    /**
     * Abre o diretório especificado e lê todos os arquivos regulares encontrados.
     * Para cada arquivo, chama o método Reader para processar seu conteúdo.
     * 
     * O diretório a ser lido é fixo e definido como "src/docs".
     * 
     */
    public static void openDir() {
        Path dir = Paths.get("src/docs");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                if (Files.isRegularFile(file)) {
                    Path fileName = file.getFileName();
                    String fileNameStr = file.getFileName().toString();

                    System.out.printf("Open file: %s\n", fileNameStr);

                    readFie("src/docs/" + fileName);
                }
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.err.printf("Error opening directory: %s\n", e);
        }
    }
}
