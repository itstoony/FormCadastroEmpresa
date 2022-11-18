package br.com.caelum.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/entrada")
public class
MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Chamando monitoramento");
        long before = System.currentTimeMillis();
        String acao = servletRequest.getParameter("acao");
        filterChain.doFilter(servletRequest, servletResponse);
        long after = System.currentTimeMillis();
        System.out.println("Tempo de execução de " + acao + " -> " + (after - before));
    }
}
