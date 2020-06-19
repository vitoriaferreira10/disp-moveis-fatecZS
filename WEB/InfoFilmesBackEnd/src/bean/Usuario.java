package bean;

import java.io.Serializable;

/**
 *
 * @author vfsilva
 *
 * CREATE TABLE db2020.usuarios ( id BIGINT NOT NULL AUTO_INCREMENT, nome
 * VARCHAR(255), login VARCHAR(255), senha VARCHAR(255), status VARCHAR(255),
 * tipo VARCHAR(255), PRIMARY KEY (id));
 *
 */
public class Usuario implements Serializable {

    private int id;
    private String nome;
    private String login;
    private String senha;
    private String status;
    private String tipo;

    public Usuario(int id, String nome, String login, String senha, String status, String tipo) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
