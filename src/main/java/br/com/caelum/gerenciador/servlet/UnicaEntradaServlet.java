package br.com.caelum.gerenciador.servlet;

import br.com.caelum.gerenciador.acao.Acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    //Central controller -- Controla o fluxo

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramAcao = req.getParameter("acao");
//        HttpSession sessao = req.getSession();
//        boolean usuarioDeslogado = (sessao.getAttribute("usuarioLogado") == null);
//        boolean nãoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//        if ( nãoProtegida && usuarioDeslogado){
//            resp.sendRedirect("entrada?acao=LoginForm");
//            return;
//        }




        String nomeDaClasse = "br.com.caelum.gerenciador.acao." + paramAcao;
        String nome;

        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(req, resp);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }


        String [] tipoEEndereco = nome.split(":");
        if (tipoEEndereco[0].equals("forward")){
            RequestDispatcher rq = req.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rq.forward(req, resp);
        } else {
            resp.sendRedirect( tipoEEndereco[1]);
        }

    }
}
