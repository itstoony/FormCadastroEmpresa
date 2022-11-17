package br.com.caelum.gerenciador.acao;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaEmpresa implements Acao {

     public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Empresa> lista = Banco.getListaEmpresa();
        req.setAttribute("listaDeEmpresas", lista);

        return "forward:empresasListadas.jsp";
    }
}
