package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFormPage extends BasePage {
	

	public LoginFormPage(WebDriver navegador) {
		super(navegador);
	}

	public LoginFormPage digitarLogin(String login) {
		// Identificando o formulario de id "signinbox"
		WebElement formSignInBox = navegador.findElement(By.id("signinbox"));

		// Digitar no campo "lgin" dentro do form de id "signinbox" julio0001
		formSignInBox.findElement(By.name("login")).sendKeys(login);

		return this;
	}

	public LoginFormPage digitarSenha(String password) {
		// Identificando o formulario de id "signinbox"
		WebElement formSignInBox = navegador.findElement(By.id("signinbox"));

		// Digitar no campo "lgin" dentro do form de id "signinbox" julio0001
		formSignInBox.findElement(By.name("password")).sendKeys(password);

		return this;
	}

	public SecretaPage fazerLogin(String login, String senha) {
		digitarLogin(login);
		digitarSenha(senha);

		navegador.findElement(By.linkText("SIGN IN")).click();

		return new SecretaPage(navegador);
	}

}
