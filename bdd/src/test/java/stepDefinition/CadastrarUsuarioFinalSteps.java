package stepDefinition;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import config.Config;
import config.SeleniumTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by assisjrs on 04/04/17.
 */
@ContextConfiguration(classes = Config.class)
@RunWith(SpringRunner.class)
@DatabaseSetup("CadastrarUsuario.xml")
@SeleniumTestCase(webDriver = ChromeDriver.class,
                  url = "http://localhost:9090/index.xhtml",
                  pageObject = CadastroPage.class)
public class CadastrarUsuarioFinalSteps {
    @Autowired
    private CadastroPage cadastroPage;

    @Dado("^que eu tenha o nome do usuário como \"([^\"]*)\" e o email como \"([^\"]*)\"$")
    public void queEuTenhaONomeDoUsuárioComoEOEmail(String nome, String email) throws Throwable {
        cadastroPage.setNome(nome);
        cadastroPage.setEmail(email);
    }

    @Quando("^eu incluir o usuário no sistema$")
    public void euIncluirOUsuárioNoSistema() throws Throwable {
        cadastroPage.novoUsuario();
    }

    @Então("^Deve exibir (\\d+) na lista$")
    public void deveExibirNaLista(int usuariosCadastrados) throws Throwable {
        cadastroPage.assertThat()
                    .quantidaDeUsuarios(usuariosCadastrados);
    }

    @Test
    public void test(){}

    @Quando("^eu incluir o usuário no sistema(\\d+)$")
    public void euIncluirOUsuárioNoSistema(int arg0) throws Throwable {

    }

    @Dado("^que eu tenha o nome do usuário como \"([^\"]*)\" e o email como \"([^\"]*)\"(\\d+)$")
    public void queEuTenhaONomeDoUsuárioComoEOEmailComo(String arg0, String arg1, int arg2) throws Throwable {

    }

    @Então("^Deve exibir (\\d+) na lista(\\d+)$")
    public void deveExibirNaLista(int arg0, int arg1) throws Throwable {

    }
}
