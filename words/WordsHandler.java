import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class WordsHandler {

    public void handleWordsFromFile(Path path, IWordsHandlerOperation handler) {
        if (handler == null) {
            throw new IllegalArgumentException("handler can't be null");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            handler.handle(reader.lines());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    interface IWordsHandlerOperation {
        void handle(Stream<String> words);
    }
}
