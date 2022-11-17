package br.com.caelum.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout implements Acao {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession sessao = req.getSession();
//        sessao.removeAttribute("usuarioLogado");
        sessao.invalidate();
        return "redirect:entrada?acao=LoginForm";
    }
}
