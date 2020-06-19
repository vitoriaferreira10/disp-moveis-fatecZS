
package controller;

import bean.Usuario;
import dao.DaoUsuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vfsilva
 */
public class ControllerUsuario {
    public Usuario validaUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.validaLogin(usu);
        return usu;
    }
    
    public Usuario inserirUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.inseri(usu);
        return usu;
    }

    public Usuario excluirUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.exclui(usu);
        return usu;
    }

    public Usuario buscarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.busca(usu);
        return usu;
    }

    public Usuario alterarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.altera(usu);
        return usu;
    }
    
    public List<Usuario> listarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        List<Usuario>  usus ;
        DaoUsuario usuDao = new DaoUsuario();
        usus = usuDao.lista(usu);
        return usus;
    }

    public List<Usuario> listarTodosUsuario() throws SQLException, ClassNotFoundException {
        List<Usuario>  usus ;
        DaoUsuario usuDao = new DaoUsuario();
        usus = usuDao.listaTodos();
        return usus;
    }

}
