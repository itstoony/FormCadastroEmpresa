package br.com.caelum.gerenciador.modelo;

import br.com.caelum.gerenciador.acao.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Banco {

    private static List<Empresa> listaEmpresa = new ArrayList<>();
    private static List<Usuario> listaUsuario = new ArrayList<>();

    private static final HashMap<String, String> hashUsuario = new HashMap<>();
    private static Integer contador = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setNome("Alura");
        empresa.setId(contador++);
        Empresa empresa2 = new Empresa();
        empresa2.setNome("Caelum");
        empresa2.setId(contador++);
        Banco.add(empresa);
        Banco.add(empresa2);

        Usuario u1 = new Usuario();
        u1.setLogin("tony");
        u1.setSenha("12345");
        Usuario u2 = new Usuario();
        u2.setLogin("isabella");
        u2.setSenha("54321");

        hashUsuario.put(u1.getLogin(), u1.getSenha());
        hashUsuario.put(u2.getLogin(), u2.getSenha());

        listaUsuario.add(u1);
        listaUsuario.add(u2);
    }



    public static List<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public static void setListaEmpresa(List<Empresa> listaEmpresa) {
        Banco.listaEmpresa = listaEmpresa;
    }


    public static void add(Empresa empresa){
        listaEmpresa.add(empresa);
    }

    public static void removeEmpresa(int id){

        Iterator<Empresa> iterator = listaEmpresa.iterator();
        while(iterator.hasNext()){
            Empresa empresa = iterator.next();
            if (empresa.getId() == id){
                iterator.remove();
            }
           }
       }

       public static Usuario achaUsuario(String login, String senha){
           for (Usuario usuario : listaUsuario){
               if (usuario.getLogin().equals(login)){
                   if (usuario.ehIgual(login, senha)){
                       return usuario;
                   }
               }
           }
           return null;
       }



}
