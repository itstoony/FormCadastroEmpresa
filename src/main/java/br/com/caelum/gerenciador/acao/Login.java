package br.com.caelum.gerenciador.acao;

import br.com.caelum.gerenciador.modelo.Banco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Acao {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        System.out.println("Logando... " + login);
        Usuario usuario = Banco.achaUsuario(login, senha);
        if (usuario != null){
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuarioLogado", usuario);
            return "redirect:entrada?acao=ListaEmpresa";
        } else {
            return "redirect:entrada?acao=LoginForm";
        }





    }
}
