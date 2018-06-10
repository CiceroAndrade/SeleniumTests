package dataProvider;

import org.testng.annotations.DataProvider;

public class LoginGpjDataProvider {

	@DataProvider(name ="dadosAcesso")
	public Object[][] getData() {
		return new Object[][] {
			{"Lorem Ipsum", "12345"},
			{"Dollor Sit", "67890"}
		};
	}
}
