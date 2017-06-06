package pageObjects;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by assis on 17/03/17.
 */

public class FinalPageAssert extends AbstractAssert<FinalPageAssert, FinalPage> {
    public FinalPageAssert(FinalPage finalPage) {
        super(finalPage, FinalPageAssert.class);
    }

    public void usuarioEValorOk(final String nome, final Double valor){
        boolean achou = false;
        int posicao = -1;

        for (WebElement usuario: actual.listaDeNomes) {
            final String text = usuario.getText();

            posicao++;

            if(text.contains(nome))
            {
                achou = true;
                break;
            }
        }

        assertThat(achou).isTrue();

        final String text = actual.listaDeValores.get(posicao).getText();
        final Double valorEncontrado = Double.parseDouble(text);

        assertThat(valorEncontrado).isEqualTo(valor);
    }
}
