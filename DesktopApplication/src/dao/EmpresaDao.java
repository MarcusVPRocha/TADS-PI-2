package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDao {

    Connection conectar;

    private void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/techeasy", "root", "");
    }

    public ResultSet login(String u, String s) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("SELECT * FROM usuarios WHERE usuario=? AND senha =?");
        st.setString(1, u);
        st.setString(2, s);
        ResultSet usuario = st.executeQuery();
        return usuario;
    }

    public void salvarUsuario(String u, String senha, String nick, String tel, String email, String afilia, String atrib) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("INSERT INTO usuarios (usuario,senha,apelido,email,tel,atribuicao,fk_empresa_id) "
                + "VALUES(?,?,?,?,?,?,(SELECT id from empresa where nomefantasia = ?));");
        st.setString(1, u);
        st.setString(2, senha);
        st.setString(3, nick);
        st.setString(4, email);
        st.setString(5, tel);
        st.setString(6, atrib);
        st.setString(7, afilia);
        st.executeUpdate();
    }

    public void alterarUsuario(String id, String u, String senha, String nick, String tel, String email, String afilia, String atrib) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement(
                "UPDATE usuarios INNER JOIN empresa on usuarios.fk_Empresa_Id = empresa.Id SET usuarios.usuario=?, usuarios.senha=?, usuarios.apelido=?, "
                + "usuarios.email=?, usuarios.tel=?, nomefantasia=?, atribuicao=? WHERE usuarios.id=?");
        st.setString(1, u);
        st.setString(2, senha);
        st.setString(3, nick);
        st.setString(4, email);
        st.setString(5, tel);
        st.setString(6, afilia);
        st.setString(7, atrib);
        st.setString(8, id);
        st.executeUpdate();
    }

    public ResultSet buscarUsuarios(String u) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("SELECT * FROM usuarios INNER JOIN empresa on usuarios.fk_Empresa_Id = empresa.Id"
                + " WHERE apelido or usuario LIKE ?");
        st.setString(1, u + "%");
        ResultSet usuarios = st.executeQuery();
        return usuarios;
    }

    public int excluirUsuario(String u) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("DELETE FROM usuarios WHERE id = ?");
        st.setString(1, u);
        int retorno = st.executeUpdate();
        return retorno;
    }

    public ResultSet idInfo(String id) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement(
                "SELECT * FROM usuarios INNER JOIN empresa on usuarios.fk_Empresa_Id = empresa.Id where usuarios.id = ?");
        st.setString(1, id);
        ResultSet idInfo = st.executeQuery();
        return idInfo;
    }

    public ResultSet idInfoEmpresa(String id) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement(
                "SELECT * FROM empresa where nomefantasia = ?");
        st.setString(1, id);
        ResultSet idInfo = st.executeQuery();
        return idInfo;
    }

    public void salvarEmpresa(String cnpj, String nomefantasia, String cep, String rua, String numero, String bairro, String estado,
            String email, String ramo, String tel) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("INSERT INTO empresa (cnpj, nomefantasia,cep,rua,numero,bairro,estado,email,ramo,tel) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?);");
        st.setString(1, cnpj);
        st.setString(2, nomefantasia);
        st.setString(3, cep);
        st.setString(4, rua);
        st.setString(5, numero);
        st.setString(6, bairro);
        st.setString(7, estado);
        st.setString(8, email);
        st.setString(9, ramo);
        st.setString(10, tel);
        st.executeUpdate();
    }

    public int excluirEmpresa(String u) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("DELETE FROM empresa WHERE id = ?");
        st.setString(1, u);
        int retorno = st.executeUpdate();
        return retorno;
    }

    public ResultSet buscarEmpresa(String u) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("SELECT * FROM empresa"
                + " WHERE nomefantasia LIKE ?");
        st.setString(1, u + "%");
        ResultSet usuarios = st.executeQuery();
        return usuarios;
    }

    public void alterarEmpresa(String cnpj, String nomefantasia, String cep, String rua, String numero, String bairro, String estado,
            String email, String ramo, String tel) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement(
                "UPDATE empresa SET cnpj=?, nomefantasia=?, cep=?, rua=?, numero=?, bairro=?, estado=?,email=?,ramo=?,tel =? WHERE nomefantasia=?");
        st.setString(1, cnpj);
        st.setString(2, nomefantasia);
        st.setString(3, cep);
        st.setString(4, rua);
        st.setString(5, numero);
        st.setString(6, bairro);
        st.setString(7, estado);
        st.setString(8, email);
        st.setString(9, ramo);
        st.setString(10, tel);
        st.setString(11, nomefantasia);
        st.executeUpdate();
    }

    public ResultSet buscarMaterial(String u) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("SELECT * FROM empresa"
                + " WHERE nomefantasia LIKE ?");
        st.setString(1, u + "%");
        ResultSet usuarios = st.executeQuery();
        return usuarios;
    }

    public void salvarProduto(String nome, String descricao, String quantidade, String marca, String tipificacao, String idEmpresa) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("INSERT INTO produtos (nome, descricao,quantidade,marca,tipificacao,fk_Empresa_id) "
                + "VALUES(?,?,?,?,?,?);");
        st.setString(1, nome);
        st.setString(2, descricao);
        st.setString(3, quantidade);
        st.setString(4, marca);
        st.setString(5, tipificacao);
        st.setString(6, idEmpresa);
        st.executeUpdate();
    }

    public void alterarProduto(String nome, String descricao, String quantidade, String marca, String tipificacao, String idEmpresa) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("update produtos set descricao=?,quantidade=?,marca=?,tipificacao=?"
                + "where nome=? and fk_Empresa_id=?");

        st.setString(1, descricao);
        st.setString(2, quantidade);
        st.setString(3, marca);
        st.setString(4, tipificacao);
        st.setString(5, nome);
        st.setString(6, idEmpresa);
        st.executeUpdate();
    }

    public ResultSet importarProduto(String nome, String idEmpresa) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("select * from produtos where nome=? and fk_Empresa_id=?");

        st.setString(1, nome);
        st.setString(2, idEmpresa);
        ResultSet produtoDados = st.executeQuery();
        return produtoDados;
    }

    public ResultSet buscarProduto(String nome, String idEmpresa) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("select * from produtos where nome like ? and fk_Empresa_id=?");

        st.setString(1, nome + "%");
        st.setString(2, idEmpresa);
        ResultSet produtoDados = st.executeQuery();
        return produtoDados;
    }

    public int excluirProduto(String nome, String idEmpresa) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectar.prepareStatement("delete from produtos where nome=? and fk_Empresa_id=?");

        st.setString(1, nome);
        st.setString(2, idEmpresa);
        int retorno = st.executeUpdate();
        return retorno;
    }

}
