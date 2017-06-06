package br.com.concrete.consumo.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by assis on 20/03/17.
 */
@RestController
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @RequestMapping(value = "lista/{ano}/{mes}/", method = RequestMethod.GET)
    public List<Transacao> lista(@PathVariable("ano") Integer ano, @PathVariable("mes") Integer mes)
    {
        final ZonedDateTime faixaDeData = LocalDate.of(ano, mes, 1).atStartOfDay(ZoneId.systemDefault());

        final Date dataFim = Date.from(faixaDeData.plusMonths(1).minusDays(1).toInstant());

        return transacaoRepository.find(dataFim);
    }
}
