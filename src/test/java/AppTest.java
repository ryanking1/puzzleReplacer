import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Title");
  }

  @Test
  public void isReplacingVowelInWord() {
    goTo("http://localhost:4567");
    fill("#userInput").with("test");
    submit(".btn");
    assertThat(pageSource()).contains("t-st");
  }

  @Test
  public void isReplacingAllVowelsInPhrase() {
    goTo("http://localhost:4567");
    fill("#userInput").with("test aeiouy they");
    submit(".btn");
    assertThat(pageSource()).contains("t-st ------ th--");
  }

  @Test
  public void isCatchingNoInput() {
    goTo("http://localhost:4567");
    fill("#userInput").with("");
    submit(".btn");
    assertThat(pageSource()).contains("Please enter a word or phrase");
  }
}
