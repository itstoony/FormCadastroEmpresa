package br.com.caelum.gerenciador.acao;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NovaEmpresa implements Acao{
    //Controller
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastrando empresa...");

        String nome = req.getParameter("nome");
        String data = req.getParameter("data");

        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
        } catch (Exception e){
            throw new ServletException(e);
        }

        Empresa nomeEmpresa = new Empresa();
        nomeEmpresa.setNome(nome);
        nomeEmpresa.setDataDeAbertura(date);
        Banco.add(nomeEmpresa);

        return "redirect:entrada?acao=ListaEmpresa";


    }
}
