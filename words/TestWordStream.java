import java.nio.file.Path;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestWordStream {

    private static final String PATH = "words";

    public static void main(String[] args){
        readWords(Path.of(PATH), new WordsHandler());
    }

    private static void readWords(Path filePath, WordsHandler wordsHandler){
        //1 count the number of English words in it
        wordsHandler.handleWordsFromFile(filePath, s -> System.out.println(s.count()));

        //2 Write a stream pipeline to print the first 100 words from the file
        wordsHandler.handleWordsFromFile(
                filePath,
                s -> s.limit(100)
                        .forEach(System.out::println)
        );

        //3 Write a stream pipeline to find and print all words that have at least 22 letters.
        //.forEach(System.out::println) looks better but is it explicit loop?
        //another way use joining with delimiter in collector
        wordsHandler.handleWordsFromFile(
                filePath,
                s -> s.filter(e -> e != null && e.length() >= 22 )
                        .forEach(System.out::println)
        );

        //4 Write a stream pipeline to find and print some word that has at least 22 letters.
        wordsHandler.handleWordsFromFile(
                filePath,
                s -> s.filter(e -> e != null && e.length() >= 22 )
                        .findAny()
                        .ifPresent(System.out::println)
        );


        //Write a stream pipeline to find all palindromes and print them.

        //primitive way to check performance - start
        long start = System.currentTimeMillis();

        wordsHandler.handleWordsFromFile(
                filePath,
                s -> s.filter(TestWordStream::isPalindrome)
                        .forEach(System.out::println)
        );

        //primitive way to check performance
        System.out.println(System.currentTimeMillis() - start);

        //6. Make a parallel version of the palindrome-printing stream pipeline. It is possible to observe whether it is faster or slower than the sequential one?

        //primitive way to check performance - start
        long startParallel = System.currentTimeMillis();

        wordsHandler.handleWordsFromFile(
                filePath,
                s -> s.parallel()
                        .filter(TestWordStream::isPalindrome)
                        .forEach(System.out::println)
        );

        //primitive way to check performance
        //looks like parallel stream faster x2 in this case
        System.out.println(System.currentTimeMillis() - startParallel);

        //7 Write a stream pipeline that turns the stream of words into a stream of their lengths, then finds and prints the minimal, maximal and average word lengths.
        wordsHandler.handleWordsFromFile(
                filePath, s -> {
                    IntSummaryStatistics stat = s.mapToInt(String::length)
                            .summaryStatistics();
                    System.out.println("max = " + stat.getMax());
                    System.out.println("min = " + stat.getMin());
                    System.out.println("avg = " + stat.getAverage());
                }
        );

        //8. Write a stream pipeline, using method collect and a groupingBy collector from
        //class Collectors, to group the words by length. That is, put all 1-letter words in one
        //group, all 2-letter words in another group, and so on, and print the groups
        wordsHandler.handleWordsFromFile(
                filePath, s -> s.collect(Collectors.groupingBy(String::length))
                        .forEach((k, v) -> System.out.println(k + " " + v))
        );

        //Optional challenge. Use another overload of groupingBy to
        //compute (and then print) the number of 1-letter words, the number of 2-letter
        //words, and so on.
        wordsHandler.handleWordsFromFile(
                filePath, s -> s.collect(Collectors.groupingBy(String::length, Collectors.summingInt(e -> 1)))
                        .forEach((k, v) -> System.out.println(k + " " + v))
        );



        //9.2 write a stream pipeline that transforms all the
        //English words into the corresponding tree map of letter counts, and print this for the
        //first 100 words.
        wordsHandler.handleWordsFromFile(
                filePath, s -> s.map(TestWordStream::letters).limit(100).forEach(System.out::println)
        );


        //10. Use the tree map stream and the reduce method to count the total number of
        //times the letter e is used in the English words. For the words file on the course
        //homepage the result should be 235,331.
        wordsHandler.handleWordsFromFile(
                filePath, s -> System.out.println(s.map(TestWordStream::letters)
                        .map(e -> e.getOrDefault('e', 0))
                        .reduce(0, Integer::sum))
        );

        //11. Words s1 and s2 that have the same tree map of letter counts (by
        //letters(s1).equals(letters(s2)) are anagrams: they use the same letters the same
        //number of times. For instance, “persistent” and “pretti ness” are anagrams; both
        //have letter counts {e=2, i=1, n=1, p=1, r=1, s=2, t=2}. Use the collect method on the
        //word stream, groupingBy collector and the letters method to find and print all sets of
        //anagrams in the file of English words. This may take 15–30 seconds to compute.

        //~12705 on my machine
        long start3 = System.currentTimeMillis();
        wordsHandler.handleWordsFromFile(
                filePath, s -> System.out.println(s.collect(Collectors.groupingBy(TestWordStream::letters)))
        );

        System.out.println(System.currentTimeMillis() - start3);


        //12. Try to make a parallel version of the anagram-printing stream pipeline. Is it faster
        //or slower than the sequential one?

        //~90971 Too slow
        long start4 = System.currentTimeMillis();
        wordsHandler.handleWordsFromFile(
                filePath, s -> System.out.println(s.parallel()
                        .collect(Collectors.groupingBy(TestWordStream::letters)))
        );
        System.out.println(System.currentTimeMillis() - start4);

    }

    //5. Write a method boolean isPalindrome(String s)
    private static boolean isPalindrome(String str){
        if (str == null) {
            throw new IllegalArgumentException("can't be null");
        }
        String reversed = new StringBuilder(str)
                .reverse()
                .toString();

        return str.equals(reversed);
    }

    //9.1 Write a method Map<Character,Integer> letters(String s) that returns a tree map
    //indicate ing how many times each letter is used in the word s.
    private static Map<Character, Integer> letters(String s){
        return s.toLowerCase().chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.summingInt(e -> 1)));
    }


}
