package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTestData.csv")
public class InformacoesUsuarioTest {
 
	private WebDriver navegador;

	@Before
	public void setUp() {
		navegador = Web.createChrome();		
	}
	
	@Rule
	public TestName test = new TestName();

	@Test
	@Ignore
	public void removerContato() {

		// Clicar no link que possui o texto "Sign in"
		WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
		linkSignIn.click();

		// Identificando o formulario de id "signinbox"
		WebElement formSignInBox = navegador.findElement(By.id("signinbox"));

		// Digitar no campo "lgin" dentro do form de id "signinbox" julio0001
		formSignInBox.findElement(By.name("login")).sendKeys("julio0001");

		// Digitar no campo "password" dentro do form de id "signinbox" 123456
		formSignInBox.findElement(By.name("password")).sendKeys("123456");

		// Clicar no link com o texto "SIGN IN"
		WebElement linkSGNIN = navegador.findElement(By.linkText("SIGN IN"));
		linkSGNIN.click();

		// Clicar em um link que possui a class "me"
		navegador.findElement(By.className("me")).click();

		// Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

		// Clicar no elemento pelo seu xpath
		// //span[text()="felipe@felipe.com.br"]/following-sibling::a
		navegador.findElement(By.xpath("//span[text()=\"+5511912341234\"]/following-sibling::a")).click();
		
		// Confirmar a janela JavaScript
		navegador.switchTo().alert().accept();

		// Validar a mensagem apresentada foi apresntada
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();

		assertEquals("Rest in peace, dear phone!", mensagem);

		Screenshot.tirar(navegador, "C:\\CTS\\evi\\" + Generator.dataHoraParaArquivo() +test.getMethodName() + ".png");
		
		// Aguardar até 10 segundos que a janela apareca
		WebDriverWait aguardar = new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

		// Click no logout
		navegador.findElement(By.linkText("Logout")).click();

	}

	@Test	
	public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo,  @Param(name="contato")String contato) {

		// Clicar no link que possui o texto "Sign in"
		WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
		linkSignIn.click();

		// Identificando o formulario de id "signinbox"
		WebElement formSignInBox = navegador.findElement(By.id("signinbox"));

		// Digitar no campo "lgin" dentro do form de id "signinbox" julio0001
		formSignInBox.findElement(By.name("login")).sendKeys("julio0001");

		// Digitar no campo "password" dentro do form de id "signinbox" 123456
		formSignInBox.findElement(By.name("password")).sendKeys("123456");

		// Clicar no link com o texto "SIGN IN"
		WebElement linkSGNIN = navegador.findElement(By.linkText("SIGN IN"));
		linkSGNIN.click();
		
		

		// Validar que dentro do element com class "me" está o texto "Hi,
		// Julio"
		String textoTela = navegador.findElement(By.className("me")).getText();
		assertEquals("Hi, Julio", textoTela);

		// Clicar em um link que possui a class "me"
		navegador.findElement(By.className("me")).click();

		// Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

		// Clicar no botõa atraves do seu xpath
		// //button[@data-target="addmoredata"]
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

		WebElement popUpAddMoreData = navegador.findElement(By.id("addmoredata"));

		WebElement campoType = popUpAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(tipo);

	
		popUpAddMoreData.findElement(By.name("contact")).sendKeys(contato);

		// Clicar no link de text SAVE
		popUpAddMoreData.findElement(By.linkText("SAVE")).click();

		// Validar que na mensagem de id "toast-container" contém o texto "Your
		// contact has been added!"

		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();

		assertEquals("Your contact has been added!", mensagem);
	}

	@Ignore
	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario2() {

		// Clicar no link que possui o texto "Sign in"
		WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
		linkSignIn.click();

		// Identificando o formulario de id "signinbox"
		WebElement formSignInBox = navegador.findElement(By.id("signinbox"));

		// Digitar no campo "login" dentro do form de id "signinbox" julio0001
		formSignInBox.findElement(By.name("login")).sendKeys("julio0001");

		// Digitar no campo "password" dentro do form de id "signinbox" 123456
		formSignInBox.findElement(By.name("password")).sendKeys("123456");

		// Clicar no link com o texto "SIGN IN"
		WebElement linkSGNIN = navegador.findElement(By.linkText("SIGN IN"));
		linkSGNIN.click();

	}

	@After
	public void tearDown() {
		navegador.close();
	}

}
