import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.xml.stream.XMLStreamException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoaderProcessorTest {
    private FileWritter fileWritter;
    private LoaderProcessor loaderProcessor;

    private static Stream<Arguments> loaderDataProvider() {
        return Stream.of(
                Arguments.of("00-basic-correct-example.xml", 3),
                Arguments.of("01-incorrect-mixed.xml", 1),
                Arguments.of("02-incorrect-notxml.xml", 0),
                Arguments.of("incorrect-mocks-filename", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("loaderDataProvider")
    void starter(String fixtureName, int expectedInvocationsNumber)
            throws XMLStreamException {
        //given
        fileWritter = new FileWritter();
        loaderProcessor = new LoaderProcessor(fileWritter);

        //when
        loaderProcessor.load(fixtureName);

        //then
        assertEquals(expectedInvocationsNumber, fileWritter.getCallsNumber());
    }
}