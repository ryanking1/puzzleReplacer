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
      //Integer userNumber = Integer.parseInt(userStringNumber);
      //ArrayList<Object> results = new ArrayList<Object>();
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
    // String[] words = userString.split("(\\s)+");
    // for (int i = 0; i < words.length; i++) {
    //   if (words[i].length() == searchWord.length()) {
    //     words[i] = words[i].replace(searchWord, replaceWord);
    //   }
    // }
    return replacedString;
  }
}
