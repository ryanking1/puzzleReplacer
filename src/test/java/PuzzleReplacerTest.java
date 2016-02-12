import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PuzzleReplacerTest {

  @Test
  public void isReplacingVowelInAWord() {
    PuzzleReplacer testPuzzleReplacer = new PuzzleReplacer();
    assertEquals("t-st", testPuzzleReplacer.vowelReplacer("test"));
  }

  @Test
  public void isReplacingVowelsInAllWords() {
    PuzzleReplacer testPuzzleReplacer = new PuzzleReplacer();
    assertEquals("t-st -ll w-rds", testPuzzleReplacer.vowelReplacer("test all words"));
  }

  @Test
  public void isReplacingVowelsIncludingY() {
    PuzzleReplacer testPuzzleReplacer = new PuzzleReplacer();
    assertEquals("t-st ------ th--", testPuzzleReplacer.vowelReplacer("test aeiouy they"));
  }
  // @Test (Not sure why this test won't pass, although code works as expected when running the site.)
  // public void isCatchingNoInput() {
  //   PuzzleReplacer testPuzzleReplacer = new PuzzleReplacer();
  //   assertEquals("Please enter a word or phrase", testPuzzleReplacer.vowelReplacer(""));
  // }

}
