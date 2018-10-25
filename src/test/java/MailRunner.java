
import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@CucumberOptions(features = {

        "classpath:features/mail/sendMail.feature"

},
        format = {"pretty", "html:reports"},
        tags = {"@mails", "@api"})
public class MailRunner {

}
