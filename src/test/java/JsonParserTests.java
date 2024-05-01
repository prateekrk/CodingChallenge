import coding.challenge4.jsonValidator.JsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsonParserTests {
    @Test
    public void test1TestSimpleValidJson() {
         JsonParser jsonParser = new JsonParser();
         Assert.assertEquals(jsonParser.isValidJson("/Users/kovallip/Downloads/tests/step1/valid.json"),0);
    }

    @Test
    public void test2TestSimpleInValidJson() {
        JsonParser jsonParser = new JsonParser();
        Assert.assertEquals(jsonParser.isValidJson("/Users/kovallip/Downloads/tests/step1/invalid.json"),1);
    }

    @Test
    public void test3Step2InValidJson() {
        JsonParser jsonParser = new JsonParser();
        Assert.assertEquals(jsonParser.isValidJson("/Users/kovallip/Downloads/tests/step2/invalid.json"),1);
    }

    @Test
    public void test3Step2ValidJson() {
        JsonParser jsonParser = new JsonParser();
        Assert.assertEquals(jsonParser.isValidJson("/Users/kovallip/Downloads/tests/step2/valid.json"),1);
    }
}
