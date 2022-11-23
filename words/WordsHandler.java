import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class WordsHandler {

    public void handleWordsFromFile(Path path, IWordsHandlerOperation handler) {
        if (handler == null) {
            throw new IllegalArgumentException("handler can't be null");
        }

        try {
            handler.handle(Files.lines(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    interface IWordsHandlerOperation {
        void handle(Stream<String> words);
    }
}
