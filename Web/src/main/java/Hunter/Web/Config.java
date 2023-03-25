package Hunter.Web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public ObjectTable get() {
		return new ObjectTable("question?","code:");
	}
}
