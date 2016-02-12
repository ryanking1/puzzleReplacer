import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class PuzzleReplacer {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/main.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");
      String userString = request.queryParams("userInput");
      if(userString.length() == 0) { //check that user input is not empty
        userString = "0";
      }
      String results = PuzzleReplacer.vowelReplacer(userString);
      model.put("results", results);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String vowelReplacer(String userString) {
    if (userString.equals("0")) {
      return "Please enter a word or phrase";
    }
    String replacedString = userString.replaceAll("[aeiouy]", "-");
    return replacedString;
    }
  }

  // public static String userGuessCheck(String userGuess, String userString) {
  //
  //   if (userGuess.equals(userString)) {
  //     return "Congratualations, you guess right!";
  //   } else {
  //     return "Sorry, you guesses incorrectly...";
  //   }
  // }
//}
