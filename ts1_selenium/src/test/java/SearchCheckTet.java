import LinkSpringer.Main;
import LinkSpringer.MainPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchCheckTet extends TestCase {

    @ParameterizedTest
    @CsvSource({"Suggesting model transformation repairs for rule-based languages using a contract-based testing approach, 26 May 2021, doi:10.1007/s10270-021-00891-0",
    "TOAST: Automated Testing of Object Transformers in Dynamic Software Updates, 31 January 2022, doi:10.1007/s11390-021-1693-1",
    "Data flow testing of feature-oriented programs, 26 January 2022, doi:10.1007/s13198-022-01636-y",
    "Robust text line detection in historical documents: learning and evaluation methods, 23 March 2022, doi:10.1007/s10032-022-00395-7"})
    public void test(String articleName, String date, String doi) {
        List<List<String>> info = new ArrayList<>();
        new MainPage(getDriver())
                .clickLogin()
                .fillUserName("stranste@fel.cvut.cz")
                .fillPassword("testovani69")
                .clickLogin()
                .searchString(articleName)
                .clickFirstArticle()
                .getInfo(info);

        assertEquals(date, info.get(0).get(1));
        assertEquals(doi, info.get(0).get(2));
    }
}
