/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import dao.EmpresaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marvp
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        panelUsuario.setVisible(false);
        panelEmpresa.setVisible(false);
        panelFuncionarios.setVisible(false);
        panelProdutos.setVisible(false);
        panelEstoque.setVisible(false);
        panelMaquinario.setVisible(false);
        panelProcessos.setVisible(false);
        panelForum.setVisible(false);
    }

    public Menu(String u, String id, String atrib) {
        initComponents();

        txtUsuarioHidden.setText(id);
        txtProdutoCadastrarHidden.setText(id);
        /* Desabilitar paineis de modo geral pra atribuir permissões especificas posteriormente */
        panelUsuario.setVisible(false);
        panelEmpresa.setVisible(false);
        panelFuncionarios.setVisible(false);
        panelProdutos.setVisible(false);
        panelEstoque.setVisible(false);
        panelMaquinario.setVisible(false);
        panelProcessos.setVisible(false);
        panelForum.setVisible(false);

        txtUsuarioHidden.setVisible(false);
        lblUsuarioHidden.setVisible(false);
        /* Desabilitar botões e paineis que ainda não foram não finalizados  */
        btnMaquinario.setEnabled(false);
        btnEstoque.setEnabled(false);
        btnForum.setEnabled(false);
        btnFuncionarios.setEnabled(false);
        btnProcessos.setEnabled(false);

        tabPanEmpresa.remove(tabPanEmpresaInfo);
        tabPanProdutos.remove(tabPanProdutosCadastrar1);
        tabPanProdutos.remove(tabPanProdutosAlterar1);
        tabPanProdutos.remove(tabPanProdutosCadastrarTeste);

        /* Desabilitar campos exclusivos de referencia */
        txtUsuarioHidden.setVisible(false);
        lblUsuarioHidden.setVisible(false);
        txtEmpresaHidden.setVisible(false);
        lblEmpresaHidden.setVisible(false);
        txtProdutoCadastrarHidden.setVisible(false);
        lblProdutoCadastrarHidden.setVisible(false);
        txtProdutoAlterarHidden.setVisible(false);
        lblProdutoAlterarHidden.setVisible(false);
        txtProdutoBuscarHidden.setVisible(false);
        lblProdutoBuscarHidden.setVisible(false);
        txtProdutoExcluirHidden.setVisible(false);
        lblProdutoExcluirHidden.setVisible(false);

        btnEmpresaAtualizarImportarHidden.setVisible(false);

        String idinfoUsuario = txtUsuarioHidden.getText();
        try {
            ResultSet idInfo = new EmpresaDao().idInfo(idinfoUsuario);
            idInfo.next();
            txtUsuarioAlterar.setText(idInfo.getString("usuario"));
            txtSenhaAlterar.setText(idInfo.getString("senha"));
            txtNicknameAlterar.setText(idInfo.getString("apelido"));
            txtTelAlterar.setText(idInfo.getString("tel"));
            txtEmailAlterar.setText(idInfo.getString("email"));
            txtAfiliaAlterar.setText(idInfo.getString("nomefantasia"));
            txtEmpresaAtualizarNome.setText(idInfo.getString("nomefantasia"));
            txtProdutoAlterarHidden.setText(idInfo.getString("fk_Empresa_Id"));
            txtProdutoBuscarHidden.setText(idInfo.getString("fk_Empresa_Id"));
            txtProdutoExcluirHidden.setText(idInfo.getString("fk_Empresa_Id"));
            txtAtribAlterar.setText(idInfo.getString("atribuicao"));

            txtProdutoCadastrarHidden.setText(idInfo.getString("fk_Empresa_Id"));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        }
        btnEmpresaAtualizarImportarHidden.doClick();

        if (atrib.equalsIgnoreCase("Administrador")) {
            panelUsuario.setVisible(false);
            panelEmpresa.setVisible(false);
            panelFuncionarios.setVisible(false);
            panelProdutos.setVisible(false);
            panelEstoque.setVisible(false);
            panelMaquinario.setVisible(false);
            panelProcessos.setVisible(false);
            panelForum.setVisible(false);

            txtUsuarioHidden.setVisible(true);
            lblUsuarioHidden.setVisible(true);

            btnEmpresaAtualizarImportarHidden.setVisible(true);
            txtProdutoAlterarHidden.setVisible(true);
            lblProdutoAlterarHidden.setVisible(true);
            txtProdutoBuscarHidden.setVisible(true);
            lblProdutoBuscarHidden.setVisible(true);
            txtProdutoExcluirHidden.setVisible(true);
            lblProdutoExcluirHidden.setVisible(true);

        } else if (atrib.equalsIgnoreCase("Estagiario")) {

            tabPanUsuario.remove(tabPanUsuarioCadastrar);
            tabPanUsuario.remove(tabPanUsuarioBuscar);
            tabPanUsuario.remove(tabPanUsuarioExcluir);
            tabPanEmpresa.remove(tabPanEmpresaCadastrar);
            tabPanEmpresa.remove(tabPanEmpresaBuscar);
            tabPanEmpresa.remove(tabPanEmpresaAtualizar);
            tabPanEmpresa.remove(tabPanEmpresaExcluir);

            txtAtribAlterar.setEnabled(false);
            txtUsuarioAlterar.setEnabled(false);
            txtAfiliaAlterar.setEnabled(false);

            tabPanProdutos.remove(tabPanProdutosCadastrar);
            tabPanProdutos.remove(tabPanProdutosAlterar);
            tabPanProdutos.remove(tabPanProdutosExcluir);

        } else if (atrib.equalsIgnoreCase("Gerente")) {
            tabPanEmpresa.remove(tabPanEmpresaCadastrar);
            tabPanEmpresa.remove(tabPanEmpresaBuscar);
            tabPanEmpresa.remove(tabPanEmpresaExcluir);

            txtAtribAlterar.setEnabled(false);
            txtUsuarioAlterar.setEnabled(false);
            txtAfiliaAlterar.setEnabled(false);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        panelUsuario = new javax.swing.JPanel();
        tabPanUsuario = new javax.swing.JTabbedPane();
        tabPanUsuarioInfo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        tabPanUsuarioCadastrar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSenhaCadastrar = new javax.swing.JTextField();
        txtAfiliaCadastrar = new javax.swing.JTextField();
        txtTelCadastrar = new javax.swing.JTextField();
        txtEmailCadastrar = new javax.swing.JTextField();
        txtAtribCadastrar = new javax.swing.JTextField();
        btnCancelarCadastroUsuario = new javax.swing.JButton();
        btnSalvarUsuario = new javax.swing.JButton();
        txtNicknameCadastrar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtUsuarioCadastrar = new javax.swing.JTextField();
        tabPanUsuarioAlterar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTelAlterar = new javax.swing.JTextField();
        txtEmailAlterar = new javax.swing.JTextField();
        txtNicknameAlterar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtAtribAlterar = new javax.swing.JTextField();
        txtAfiliaAlterar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnCancelarAlterarUsuario = new javax.swing.JButton();
        lblUsuarioHidden = new javax.swing.JLabel();
        txtUsuarioHidden = new javax.swing.JTextField();
        btnAlterarUsuario = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtSenhaAlterar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtUsuarioAlterar = new javax.swing.JTextField();
        tabPanUsuarioBuscar = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuarioBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        tabPanUsuarioExcluir = new javax.swing.JPanel();
        lblUsuarioHidden1 = new javax.swing.JLabel();
        txtIDUsuarioExcluir = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        panelProdutos = new javax.swing.JPanel();
        tabPanProdutos = new javax.swing.JTabbedPane();
        tabPanProdutoGuia = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        tabPanProdutosCadastrarTeste = new javax.swing.JPanel();
        btnSalvarUsuario1 = new javax.swing.JButton();
        TabPanProdutosCadastrarSubTabPan1 = new javax.swing.JTabbedPane();
        SubTabPanProdutoCadastrarTeste = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtSenhaCadastrar3 = new javax.swing.JTextField();
        txtNicknameCadastrar1 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txtUsuarioCadastrar1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSenhaCadastrar1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        TabPanProdutosCadastrarSubTabPan = new javax.swing.JTabbedPane();
        SubTabPanProdutoCadastrarMaterial = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblMaterialCadastroProduto = new javax.swing.JTable();
        txtUsuarioCadastrar3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnSalvarUsuario3 = new javax.swing.JButton();
        btnSalvarUsuario5 = new javax.swing.JButton();
        SubTabPanProdutoCadastrarMaquinario = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtUsuarioCadastrar5 = new javax.swing.JTextField();
        btnSalvarUsuario6 = new javax.swing.JButton();
        btnSalvarUsuario7 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblMaquinarioCadastroProduto = new javax.swing.JTable();
        SubTabPanProdutoCadastrarProcesso = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblProcessoCadastroProduto = new javax.swing.JTable();
        txtUsuarioCadastrar4 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnSalvarUsuario4 = new javax.swing.JButton();
        btnSalvarUsuario8 = new javax.swing.JButton();
        SubTabPanProdutoCadastrarSubProduto = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblSubProdutoCadastroProduto = new javax.swing.JTable();
        txtUsuarioCadastrar6 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        btnSalvarUsuario9 = new javax.swing.JButton();
        btnSalvarUsuario10 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        tabPanProdutosCadastrar = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        txtProdutoCadastrarMarca = new javax.swing.JTextField();
        txtProdutoCadastrarDescricao = new javax.swing.JTextField();
        txtProdutoCadastrarQtd = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        btnProdutoCadastrarCancelar = new javax.swing.JButton();
        lblProdutoCadastrarHidden = new javax.swing.JLabel();
        txtProdutoCadastrarHidden = new javax.swing.JTextField();
        btnProdutoCadastrarSalvar = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        txtProdutoCadastrarTipo = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        txtProdutoCadastrarNome = new javax.swing.JTextField();
        tabPanProdutosAlterar = new javax.swing.JPanel();
        txtProdutoAlterarHidden = new javax.swing.JTextField();
        lblProdutoAlterarHidden = new javax.swing.JLabel();
        txtProdutoAlterarNome = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        txtProdutoAlterarTipo = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        txtProdutoAlterarMarca = new javax.swing.JTextField();
        txtProdutoAlterarQtd = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        txtProdutoAlterarDescricao = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        btnProdutoAlterarSalvar = new javax.swing.JButton();
        btnProdutoAlterarCancelar = new javax.swing.JButton();
        btnProdutoAlterarBuscar = new javax.swing.JButton();
        tabPanProdutosBuscar = new javax.swing.JPanel();
        lblUsuario1 = new javax.swing.JLabel();
        txtProdutoBuscar = new javax.swing.JTextField();
        btnProdutoBuscar = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblProdutosBuscar = new javax.swing.JTable();
        lblProdutoBuscarHidden = new javax.swing.JLabel();
        txtProdutoBuscarHidden = new javax.swing.JTextField();
        tabPanProdutosExcluir = new javax.swing.JPanel();
        lblUsuarioHidden4 = new javax.swing.JLabel();
        txtProdutoExcluir = new javax.swing.JTextField();
        btnExcluir1 = new javax.swing.JButton();
        txtProdutoExcluirHidden = new javax.swing.JTextField();
        lblProdutoExcluirHidden = new javax.swing.JLabel();
        tabPanProdutosCadastrar1 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtSenhaCadastrar2 = new javax.swing.JTextField();
        txtAfiliaCadastrar2 = new javax.swing.JTextField();
        txtTelCadastrar2 = new javax.swing.JTextField();
        txtEmailCadastrar2 = new javax.swing.JTextField();
        txtAtribCadastrar2 = new javax.swing.JTextField();
        btnCancelarCadastroUsuario2 = new javax.swing.JButton();
        btnSalvarUsuario2 = new javax.swing.JButton();
        txtNicknameCadastrar2 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtUsuarioCadastrar2 = new javax.swing.JTextField();
        tabPanProdutosAlterar1 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        txtTelAlterar3 = new javax.swing.JTextField();
        txtEmailAlterar3 = new javax.swing.JTextField();
        txtNicknameAlterar3 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtAtribAlterar3 = new javax.swing.JTextField();
        txtAfiliaAlterar3 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        btnCancelarAlterarUsuario3 = new javax.swing.JButton();
        lblUsuarioHidden5 = new javax.swing.JLabel();
        txtUsuarioHidden3 = new javax.swing.JTextField();
        btnAlterarUsuario3 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        txtSenhaAlterar3 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txtUsuarioAlterar3 = new javax.swing.JTextField();
        panelEmpresa = new javax.swing.JPanel();
        tabPanEmpresa = new javax.swing.JTabbedPane();
        tabPanEmpresaApresentacao = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        tabPanEmpresaMVV = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tabPanEmpresaInfo = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtTelAlterar1 = new javax.swing.JTextField();
        txtEmailAlterar1 = new javax.swing.JTextField();
        txtNicknameAlterar1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtAtribAlterar1 = new javax.swing.JTextField();
        txtAfiliaAlterar1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        btnCancelarAlterarUsuario1 = new javax.swing.JButton();
        lblUsuarioHidden2 = new javax.swing.JLabel();
        txtUsuarioHidden1 = new javax.swing.JTextField();
        btnAlterarUsuario1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        txtSenhaAlterar1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtUsuarioAlterar1 = new javax.swing.JTextField();
        tabPanEmpresaMO = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        tabPanEmpresaCadastrar = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtEmpresaCadastrarCEP = new javax.swing.JTextField();
        txtEmpresaCadastrarRua = new javax.swing.JTextField();
        txtEmpresaCadastrarCNPJ = new javax.swing.JTextField();
        txtEmpresaCadastrarEmail = new javax.swing.JTextField();
        txtEmpresaCadastrarEstado = new javax.swing.JTextField();
        btnEmpresaCadastrarCancelar = new javax.swing.JButton();
        btnEmpresaCadastrarSalvar = new javax.swing.JButton();
        txtEmpresaCadastrarBairro = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtEmpresaCadastrarNome = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtEmpresaCadastrarN = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtEmpresaCadastrarTel = new javax.swing.JTextField();
        txtEmpresaCadastrarRamo = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        tabPanEmpresaAtualizar = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtEmpresaAtualizarCEP = new javax.swing.JTextField();
        txtEmpresaAtualizarRua = new javax.swing.JTextField();
        txtEmpresaAtualizarCNPJ = new javax.swing.JTextField();
        txtEmpresaAtualizarEmail = new javax.swing.JTextField();
        txtEmpresaAtualizarEstado = new javax.swing.JTextField();
        btnEmpresaAtualizarCancelar = new javax.swing.JButton();
        btnEmpresaAtualizarSalvar = new javax.swing.JButton();
        txtEmpresaAtualizarBairro = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txtEmpresaAtualizarNome = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtEmpresaAtualizarN = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txtEmpresaAtualizarTel = new javax.swing.JTextField();
        txtEmpresaAtualizarRamo = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        lblEmpresaHidden = new javax.swing.JLabel();
        txtEmpresaHidden = new javax.swing.JTextField();
        btnEmpresaAtualizarImportarHidden = new javax.swing.JButton();
        tabPanEmpresaBuscar = new javax.swing.JPanel();
        lblUsuario2 = new javax.swing.JLabel();
        txtEmpresaBuscar = new javax.swing.JTextField();
        btnBuscarEmpresa = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblEmpresa = new javax.swing.JTable();
        tabPanEmpresaExcluir = new javax.swing.JPanel();
        lblUsuarioHidden6 = new javax.swing.JLabel();
        txtIDEmpresaExcluir = new javax.swing.JTextField();
        btnExcluirEmpresa = new javax.swing.JButton();
        panelFuncionarios = new javax.swing.JPanel();
        panelEstoque = new javax.swing.JPanel();
        panelMaquinario = new javax.swing.JPanel();
        panelProcessos = new javax.swing.JPanel();
        panelForum = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnForum = new javax.swing.JButton();
        btnEmpresa = new javax.swing.JButton();
        btnFuncionarios = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnProdutos = new javax.swing.JButton();
        btnEstoque = new javax.swing.JButton();
        btnMaquinario = new javax.swing.JButton();
        btnProcessos = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnDeslogar = new javax.swing.JButton();
        menu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        panelUsuario.setBackground(new java.awt.Color(107, 134, 166));
        panelUsuario.setLayout(null);

        tabPanUsuario.setBackground(new java.awt.Color(107, 134, 166));
        tabPanUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tabPanUsuario.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabPanUsuario.setOpaque(true);

        tabPanUsuarioInfo.setBackground(new java.awt.Color(205, 205, 227));
        tabPanUsuarioInfo.setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae metus id libero tincidunt lobortis. \nDuis id diam vel odio consequat sodales. Integer aliquam laoreet magna, tempus ornare augue sollicitudin \nvel. Suspendisse fermentum velit enim, quis vulputate leo convallis sit amet. Nunc quam sem, dignissim a \nfaucibus ut, aliquam vitae purus. Sed erat dolor, rutrum in lacinia in, semper sit amet sapien. Quisque et dui vel \ndolor pulvinar lacinia vitae in velit. Fusce sollicitudin eros sit amet massa vehicula, vitae tempus nisi convallis. \nDuis ultricies velit sed cursus egestas. Vestibulum facilisis ac felis non pretium.\n\nInteger convallis enim maximus nibh interdum, sed placerat mi interdum. In dapibus in magna eget mattis. \nPhasellus tempus fringilla risus non egestas. Nulla malesuada orci neque, eu convallis urna convallis ac. Sed ac \nnibh at metus tincidunt gravida. Cras ac vehicula massa. Suspendisse potenti. Praesent ut ante porttitor, elementum \nlorem vel, fermentum turpis. Praesent ut est nec nunc vestibulum iaculis. Aliquam fringilla congue purus ornare \nconsectetur. Nullam mi elit, bibendum sit amet purus vitae, ultricies cursus elit. Pellentesque semper nunc nec mattis \ndignissim. In nibh sapien, tristique in pretium sed, viverra quis tortor.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        tabPanUsuarioInfo.add(jScrollPane1);
        jScrollPane1.setBounds(140, 100, 680, 350);

        tabPanUsuario.addTab("Informações", tabPanUsuarioInfo);

        tabPanUsuarioCadastrar.setBackground(new java.awt.Color(205, 205, 227));
        tabPanUsuarioCadastrar.setLayout(null);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Senha :");
        tabPanUsuarioCadastrar.add(jLabel3);
        jLabel3.setBounds(-50, 120, 140, 60);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Afiliação :");
        tabPanUsuarioCadastrar.add(jLabel4);
        jLabel4.setBounds(-50, 320, 140, 60);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Telefone :");
        tabPanUsuarioCadastrar.add(jLabel5);
        jLabel5.setBounds(380, 120, 140, 60);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("E-mail :");
        tabPanUsuarioCadastrar.add(jLabel6);
        jLabel6.setBounds(380, 220, 140, 60);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Atribuição :");
        tabPanUsuarioCadastrar.add(jLabel7);
        jLabel7.setBounds(380, 320, 140, 60);

        txtSenhaCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaCadastrarActionPerformed(evt);
            }
        });
        tabPanUsuarioCadastrar.add(txtSenhaCadastrar);
        txtSenhaCadastrar.setBounds(100, 120, 320, 60);
        tabPanUsuarioCadastrar.add(txtAfiliaCadastrar);
        txtAfiliaCadastrar.setBounds(100, 320, 320, 60);

        txtTelCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelCadastrarActionPerformed(evt);
            }
        });
        tabPanUsuarioCadastrar.add(txtTelCadastrar);
        txtTelCadastrar.setBounds(530, 120, 320, 60);
        tabPanUsuarioCadastrar.add(txtEmailCadastrar);
        txtEmailCadastrar.setBounds(530, 220, 320, 60);

        txtAtribCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAtribCadastrarActionPerformed(evt);
            }
        });
        tabPanUsuarioCadastrar.add(txtAtribCadastrar);
        txtAtribCadastrar.setBounds(530, 320, 320, 60);

        btnCancelarCadastroUsuario.setBackground(new java.awt.Color(205, 205, 227));
        btnCancelarCadastroUsuario.setText("CANCELAR");
        btnCancelarCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroUsuarioActionPerformed(evt);
            }
        });
        tabPanUsuarioCadastrar.add(btnCancelarCadastroUsuario);
        btnCancelarCadastroUsuario.setBounds(510, 420, 150, 60);

        btnSalvarUsuario.setBackground(new java.awt.Color(205, 205, 227));
        btnSalvarUsuario.setText("SALVAR");
        btnSalvarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuarioActionPerformed(evt);
            }
        });
        tabPanUsuarioCadastrar.add(btnSalvarUsuario);
        btnSalvarUsuario.setBounds(280, 420, 150, 60);

        txtNicknameCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknameCadastrarActionPerformed(evt);
            }
        });
        tabPanUsuarioCadastrar.add(txtNicknameCadastrar);
        txtNicknameCadastrar.setBounds(100, 220, 320, 60);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Apelido :");
        tabPanUsuarioCadastrar.add(jLabel8);
        jLabel8.setBounds(-50, 220, 140, 60);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Usuário :");
        tabPanUsuarioCadastrar.add(jLabel16);
        jLabel16.setBounds(170, 30, 140, 60);

        txtUsuarioCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioCadastrarActionPerformed(evt);
            }
        });
        tabPanUsuarioCadastrar.add(txtUsuarioCadastrar);
        txtUsuarioCadastrar.setBounds(320, 30, 320, 60);

        tabPanUsuario.addTab("Cadastrar", tabPanUsuarioCadastrar);

        tabPanUsuarioAlterar.setBackground(new java.awt.Color(205, 205, 227));
        tabPanUsuarioAlterar.setLayout(null);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Telefone :");
        tabPanUsuarioAlterar.add(jLabel10);
        jLabel10.setBounds(380, 120, 140, 60);

        txtTelAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelAlterarActionPerformed(evt);
            }
        });
        tabPanUsuarioAlterar.add(txtTelAlterar);
        txtTelAlterar.setBounds(530, 120, 320, 60);
        tabPanUsuarioAlterar.add(txtEmailAlterar);
        txtEmailAlterar.setBounds(530, 220, 320, 60);

        txtNicknameAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknameAlterarActionPerformed(evt);
            }
        });
        tabPanUsuarioAlterar.add(txtNicknameAlterar);
        txtNicknameAlterar.setBounds(100, 220, 320, 60);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Apelido :");
        tabPanUsuarioAlterar.add(jLabel11);
        jLabel11.setBounds(-50, 220, 140, 60);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("E-mail :");
        tabPanUsuarioAlterar.add(jLabel12);
        jLabel12.setBounds(380, 220, 140, 60);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Atribuição :");
        tabPanUsuarioAlterar.add(jLabel13);
        jLabel13.setBounds(380, 320, 140, 60);

        txtAtribAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAtribAlterarActionPerformed(evt);
            }
        });
        tabPanUsuarioAlterar.add(txtAtribAlterar);
        txtAtribAlterar.setBounds(530, 320, 320, 60);
        tabPanUsuarioAlterar.add(txtAfiliaAlterar);
        txtAfiliaAlterar.setBounds(100, 320, 320, 60);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Afiliação :");
        tabPanUsuarioAlterar.add(jLabel14);
        jLabel14.setBounds(-50, 320, 140, 60);

        btnCancelarAlterarUsuario.setBackground(new java.awt.Color(205, 205, 227));
        btnCancelarAlterarUsuario.setText("CANCELAR");
        btnCancelarAlterarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlterarUsuarioActionPerformed(evt);
            }
        });
        tabPanUsuarioAlterar.add(btnCancelarAlterarUsuario);
        btnCancelarAlterarUsuario.setBounds(510, 420, 150, 60);

        lblUsuarioHidden.setText("ID Usuário:");
        tabPanUsuarioAlterar.add(lblUsuarioHidden);
        lblUsuarioHidden.setBounds(60, 30, 70, 60);

        txtUsuarioHidden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioHiddenActionPerformed(evt);
            }
        });
        txtUsuarioHidden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioHiddenKeyPressed(evt);
            }
        });
        tabPanUsuarioAlterar.add(txtUsuarioHidden);
        txtUsuarioHidden.setBounds(130, 40, 90, 40);

        btnAlterarUsuario.setBackground(new java.awt.Color(205, 205, 227));
        btnAlterarUsuario.setText("ALTERAR");
        btnAlterarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarUsuarioActionPerformed(evt);
            }
        });
        tabPanUsuarioAlterar.add(btnAlterarUsuario);
        btnAlterarUsuario.setBounds(280, 420, 150, 60);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Senha :");
        tabPanUsuarioAlterar.add(jLabel15);
        jLabel15.setBounds(-50, 120, 140, 60);

        txtSenhaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaAlterarActionPerformed(evt);
            }
        });
        tabPanUsuarioAlterar.add(txtSenhaAlterar);
        txtSenhaAlterar.setBounds(100, 120, 320, 60);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Usuário :");
        tabPanUsuarioAlterar.add(jLabel17);
        jLabel17.setBounds(240, 30, 70, 60);

        txtUsuarioAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioAlterarActionPerformed(evt);
            }
        });
        tabPanUsuarioAlterar.add(txtUsuarioAlterar);
        txtUsuarioAlterar.setBounds(320, 30, 320, 60);

        tabPanUsuario.addTab("Alterar", tabPanUsuarioAlterar);

        tabPanUsuarioBuscar.setBackground(new java.awt.Color(205, 205, 227));
        tabPanUsuarioBuscar.setLayout(null);

        lblUsuario.setText("Usuário:");
        tabPanUsuarioBuscar.add(lblUsuario);
        lblUsuario.setBounds(150, 20, 70, 60);

        txtUsuarioBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioBuscarKeyPressed(evt);
            }
        });
        tabPanUsuarioBuscar.add(txtUsuarioBuscar);
        txtUsuarioBuscar.setBounds(220, 30, 290, 40);

        btnBuscar.setBackground(new java.awt.Color(205, 205, 227));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        tabPanUsuarioBuscar.add(btnBuscar);
        btnBuscar.setBounds(600, 30, 190, 40);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Usuário", "Senha", "Apelido", "Atribuição", "Empresa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblUsuarios);

        tabPanUsuarioBuscar.add(jScrollPane2);
        jScrollPane2.setBounds(30, 80, 830, 420);

        tabPanUsuario.addTab("Buscar", tabPanUsuarioBuscar);

        tabPanUsuarioExcluir.setBackground(new java.awt.Color(205, 205, 227));
        tabPanUsuarioExcluir.setLayout(null);

        lblUsuarioHidden1.setText("ID Usuário:");
        tabPanUsuarioExcluir.add(lblUsuarioHidden1);
        lblUsuarioHidden1.setBounds(310, 150, 70, 60);

        txtIDUsuarioExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDUsuarioExcluirActionPerformed(evt);
            }
        });
        txtIDUsuarioExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDUsuarioExcluirKeyPressed(evt);
            }
        });
        tabPanUsuarioExcluir.add(txtIDUsuarioExcluir);
        txtIDUsuarioExcluir.setBounds(390, 160, 160, 40);

        btnExcluir.setBackground(new java.awt.Color(205, 205, 227));
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        tabPanUsuarioExcluir.add(btnExcluir);
        btnExcluir.setBounds(380, 260, 170, 40);

        tabPanUsuario.addTab("Excluir", tabPanUsuarioExcluir);

        panelUsuario.add(tabPanUsuario);
        tabPanUsuario.setBounds(0, 130, 980, 530);

        jDesktopPane1.add(panelUsuario);
        panelUsuario.setBounds(0, 0, 1000, 710);

        panelProdutos.setBackground(new java.awt.Color(107, 134, 166));
        panelProdutos.setLayout(null);

        tabPanProdutos.setBackground(new java.awt.Color(107, 134, 166));
        tabPanProdutos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tabPanProdutos.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabPanProdutos.setOpaque(true);

        tabPanProdutoGuia.setBackground(new java.awt.Color(205, 205, 227));
        tabPanProdutoGuia.setLayout(null);

        jTextArea6.setColumns(20);
        jTextArea6.setLineWrap(true);
        jTextArea6.setRows(5);
        jTextArea6.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae metus id libero tincidunt lobortis. \nDuis id diam vel odio consequat sodales. Integer aliquam laoreet magna, tempus ornare augue sollicitudin \nvel. Suspendisse fermentum velit enim, quis vulputate leo convallis sit amet. Nunc quam sem, dignissim a \nfaucibus ut, aliquam vitae purus. Sed erat dolor, rutrum in lacinia in, semper sit amet sapien. Quisque et dui vel \ndolor pulvinar lacinia vitae in velit. Fusce sollicitudin eros sit amet massa vehicula, vitae tempus nisi convallis. \nDuis ultricies velit sed cursus egestas. Vestibulum facilisis ac felis non pretium.\n\nInteger convallis enim maximus nibh interdum, sed placerat mi interdum. In dapibus in magna eget mattis. \nPhasellus tempus fringilla risus non egestas. Nulla malesuada orci neque, eu convallis urna convallis ac. Sed ac \nnibh at metus tincidunt gravida. Cras ac vehicula massa. Suspendisse potenti. Praesent ut ante porttitor, elementum \nlorem vel, fermentum turpis. Praesent ut est nec nunc vestibulum iaculis. Aliquam fringilla congue purus ornare \nconsectetur. Nullam mi elit, bibendum sit amet purus vitae, ultricies cursus elit. Pellentesque semper nunc nec mattis \ndignissim. In nibh sapien, tristique in pretium sed, viverra quis tortor.");
        jTextArea6.setWrapStyleWord(true);
        jScrollPane4.setViewportView(jTextArea6);

        tabPanProdutoGuia.add(jScrollPane4);
        jScrollPane4.setBounds(80, 100, 680, 350);

        tabPanProdutos.addTab("Guia do Usuario", tabPanProdutoGuia);

        tabPanProdutosCadastrarTeste.setBackground(new java.awt.Color(205, 205, 227));
        tabPanProdutosCadastrarTeste.setLayout(null);

        btnSalvarUsuario1.setBackground(new java.awt.Color(205, 205, 227));
        btnSalvarUsuario1.setText("SALVAR");
        btnSalvarUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuario1ActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrarTeste.add(btnSalvarUsuario1);
        btnSalvarUsuario1.setBounds(90, 410, 150, 60);

        TabPanProdutosCadastrarSubTabPan1.setBackground(new java.awt.Color(107, 134, 166));

        SubTabPanProdutoCadastrarTeste.setBackground(new java.awt.Color(205, 205, 227));
        SubTabPanProdutoCadastrarTeste.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SubTabPanProdutoCadastrarTeste.setLayout(null);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Descrição:");
        SubTabPanProdutoCadastrarTeste.add(jLabel22);
        jLabel22.setBounds(10, 150, 60, 40);
        SubTabPanProdutoCadastrarTeste.add(txtSenhaCadastrar3);
        txtSenhaCadastrar3.setBounds(290, 90, 80, 40);
        SubTabPanProdutoCadastrarTeste.add(txtNicknameCadastrar1);
        txtNicknameCadastrar1.setBounds(80, 150, 290, 80);

        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel75.setText("Nome do ");
        SubTabPanProdutoCadastrarTeste.add(jLabel75);
        jLabel75.setBounds(10, 20, 70, 40);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Produto:");
        SubTabPanProdutoCadastrarTeste.add(jLabel23);
        jLabel23.setBounds(10, 40, 70, 30);

        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel74.setText("Quantidade ");
        SubTabPanProdutoCadastrarTeste.add(jLabel74);
        jLabel74.setBounds(220, 80, 70, 40);

        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel73.setText("Fabricada:");
        SubTabPanProdutoCadastrarTeste.add(jLabel73);
        jLabel73.setBounds(220, 100, 70, 30);
        SubTabPanProdutoCadastrarTeste.add(txtUsuarioCadastrar1);
        txtUsuarioCadastrar1.setBounds(80, 30, 290, 40);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tipificação:");
        SubTabPanProdutoCadastrarTeste.add(jLabel9);
        jLabel9.setBounds(10, 90, 70, 40);
        SubTabPanProdutoCadastrarTeste.add(txtSenhaCadastrar1);
        txtSenhaCadastrar1.setBounds(80, 90, 130, 40);

        TabPanProdutosCadastrarSubTabPan1.addTab("Produto", SubTabPanProdutoCadastrarTeste);

        jPanel5.setBackground(new java.awt.Color(205, 205, 227));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(null);
        TabPanProdutosCadastrarSubTabPan1.addTab("Sub-Produto", jPanel5);

        tabPanProdutosCadastrarTeste.add(TabPanProdutosCadastrarSubTabPan1);
        TabPanProdutosCadastrarSubTabPan1.setBounds(0, 0, 400, 530);

        TabPanProdutosCadastrarSubTabPan.setBackground(new java.awt.Color(107, 134, 166));

        SubTabPanProdutoCadastrarMaterial.setBackground(new java.awt.Color(205, 205, 227));
        SubTabPanProdutoCadastrarMaterial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SubTabPanProdutoCadastrarMaterial.setLayout(null);

        tblMaterialCadastroProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(tblMaterialCadastroProduto);

        SubTabPanProdutoCadastrarMaterial.add(jScrollPane10);
        jScrollPane10.setBounds(0, 40, 430, 220);

        txtUsuarioCadastrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioCadastrar3ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarMaterial.add(txtUsuarioCadastrar3);
        txtUsuarioCadastrar3.setBounds(60, 10, 200, 30);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Nome:");
        SubTabPanProdutoCadastrarMaterial.add(jLabel19);
        jLabel19.setBounds(0, 10, 50, 30);

        btnSalvarUsuario3.setBackground(new java.awt.Color(205, 205, 227));
        btnSalvarUsuario3.setText("Buscar");
        btnSalvarUsuario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuario3ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarMaterial.add(btnSalvarUsuario3);
        btnSalvarUsuario3.setBounds(260, 10, 70, 30);

        btnSalvarUsuario5.setBackground(new java.awt.Color(205, 205, 227));
        btnSalvarUsuario5.setText("Adicionar");
        btnSalvarUsuario5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuario5ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarMaterial.add(btnSalvarUsuario5);
        btnSalvarUsuario5.setBounds(330, 10, 90, 30);

        TabPanProdutosCadastrarSubTabPan.addTab("Material", SubTabPanProdutoCadastrarMaterial);

        SubTabPanProdutoCadastrarMaquinario.setBackground(new java.awt.Color(205, 205, 227));
        SubTabPanProdutoCadastrarMaquinario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SubTabPanProdutoCadastrarMaquinario.setLayout(null);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Nome:");
        SubTabPanProdutoCadastrarMaquinario.add(jLabel21);
        jLabel21.setBounds(0, 10, 50, 30);

        txtUsuarioCadastrar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioCadastrar5ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarMaquinario.add(txtUsuarioCadastrar5);
        txtUsuarioCadastrar5.setBounds(60, 10, 200, 30);

        btnSalvarUsuario6.setBackground(new java.awt.Color(205, 205, 227));
        btnSalvarUsuario6.setText("Buscar");
        btnSalvarUsuario6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuario6ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarMaquinario.add(btnSalvarUsuario6);
        btnSalvarUsuario6.setBounds(260, 10, 70, 30);

        btnSalvarUsuario7.setBackground(new java.awt.Color(205, 205, 227));
        btnSalvarUsuario7.setText("Adicionar");
        btnSalvarUsuario7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuario7ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarMaquinario.add(btnSalvarUsuario7);
        btnSalvarUsuario7.setBounds(330, 10, 90, 30);

        tblMaquinarioCadastroProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(tblMaquinarioCadastroProduto);

        SubTabPanProdutoCadastrarMaquinario.add(jScrollPane12);
        jScrollPane12.setBounds(0, 40, 430, 220);

        TabPanProdutosCadastrarSubTabPan.addTab("Maquinário", SubTabPanProdutoCadastrarMaquinario);

        SubTabPanProdutoCadastrarProcesso.setBackground(new java.awt.Color(205, 205, 227));
        SubTabPanProdutoCadastrarProcesso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SubTabPanProdutoCadastrarProcesso.setLayout(null);

        tblProcessoCadastroProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(tblProcessoCadastroProduto);

        SubTabPanProdutoCadastrarProcesso.add(jScrollPane11);
        jScrollPane11.setBounds(0, 40, 430, 220);

        txtUsuarioCadastrar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioCadastrar4ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarProcesso.add(txtUsuarioCadastrar4);
        txtUsuarioCadastrar4.setBounds(60, 10, 200, 30);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Nome:");
        SubTabPanProdutoCadastrarProcesso.add(jLabel20);
        jLabel20.setBounds(0, 10, 50, 30);

        btnSalvarUsuario4.setBackground(new java.awt.Color(205, 205, 227));
        btnSalvarUsuario4.setText("Buscar");
        btnSalvarUsuario4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuario4ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarProcesso.add(btnSalvarUsuario4);
        btnSalvarUsuario4.setBounds(260, 10, 70, 30);

        btnSalvarUsuario8.setBackground(new java.awt.Color(205, 205, 227));
        btnSalvarUsuario8.setText("Adicionar");
        btnSalvarUsuario8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuario8ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarProcesso.add(btnSalvarUsuario8);
        btnSalvarUsuario8.setBounds(330, 10, 90, 30);

        TabPanProdutosCadastrarSubTabPan.addTab("Processo", SubTabPanProdutoCadastrarProcesso);

        SubTabPanProdutoCadastrarSubProduto.setBackground(new java.awt.Color(205, 205, 227));
        SubTabPanProdutoCadastrarSubProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SubTabPanProdutoCadastrarSubProduto.setLayout(null);

        tblSubProdutoCadastroProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(tblSubProdutoCadastroProduto);

        SubTabPanProdutoCadastrarSubProduto.add(jScrollPane13);
        jScrollPane13.setBounds(0, 40, 430, 220);

        txtUsuarioCadastrar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioCadastrar6ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarSubProduto.add(txtUsuarioCadastrar6);
        txtUsuarioCadastrar6.setBounds(60, 10, 200, 30);

        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel77.setText("Nome:");
        SubTabPanProdutoCadastrarSubProduto.add(jLabel77);
        jLabel77.setBounds(0, 10, 50, 30);

        btnSalvarUsuario9.setBackground(new java.awt.Color(205, 205, 227));
        btnSalvarUsuario9.setText("Buscar");
        btnSalvarUsuario9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuario9ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarSubProduto.add(btnSalvarUsuario9);
        btnSalvarUsuario9.setBounds(260, 10, 70, 30);

        btnSalvarUsuario10.setBackground(new java.awt.Color(205, 205, 227));
        btnSalvarUsuario10.setText("Adicionar");
        btnSalvarUsuario10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuario10ActionPerformed(evt);
            }
        });
        SubTabPanProdutoCadastrarSubProduto.add(btnSalvarUsuario10);
        btnSalvarUsuario10.setBounds(330, 10, 90, 30);

        TabPanProdutosCadastrarSubTabPan.addTab("Sub-Produto", SubTabPanProdutoCadastrarSubProduto);

        tabPanProdutosCadastrarTeste.add(TabPanProdutosCadastrarSubTabPan);
        TabPanProdutosCadastrarSubTabPan.setBounds(400, 0, 430, 530);

        jLabel18.setBackground(new java.awt.Color(107, 134, 166));
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel18.setOpaque(true);
        tabPanProdutosCadastrarTeste.add(jLabel18);
        jLabel18.setBounds(400, -10, 430, 540);

        jLabel76.setBackground(new java.awt.Color(107, 134, 166));
        jLabel76.setText("jLabel76");
        jLabel76.setOpaque(true);
        tabPanProdutosCadastrarTeste.add(jLabel76);
        jLabel76.setBounds(-7, -4, 410, 290);

        tabPanProdutos.addTab("Cadastrar Produto", tabPanProdutosCadastrarTeste);

        tabPanProdutosCadastrar.setBackground(new java.awt.Color(205, 205, 227));
        tabPanProdutosCadastrar.setLayout(null);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel78.setText("Marca:");
        tabPanProdutosCadastrar.add(jLabel78);
        jLabel78.setBounds(330, 120, 140, 60);

        txtProdutoCadastrarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoCadastrarMarcaActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar.add(txtProdutoCadastrarMarca);
        txtProdutoCadastrarMarca.setBounds(480, 120, 320, 60);
        tabPanProdutosCadastrar.add(txtProdutoCadastrarDescricao);
        txtProdutoCadastrarDescricao.setBounds(370, 210, 430, 200);

        txtProdutoCadastrarQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoCadastrarQtdActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar.add(txtProdutoCadastrarQtd);
        txtProdutoCadastrarQtd.setBounds(100, 210, 130, 60);

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel79.setText("Quantidade:");
        tabPanProdutosCadastrar.add(jLabel79);
        jLabel79.setBounds(-50, 210, 140, 60);

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel80.setText("Descrição :");
        tabPanProdutosCadastrar.add(jLabel80);
        jLabel80.setBounds(280, 210, 80, 60);

        btnProdutoCadastrarCancelar.setBackground(new java.awt.Color(205, 205, 227));
        btnProdutoCadastrarCancelar.setText("CANCELAR");
        btnProdutoCadastrarCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoCadastrarCancelarActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar.add(btnProdutoCadastrarCancelar);
        btnProdutoCadastrarCancelar.setBounds(200, 350, 150, 60);

        lblProdutoCadastrarHidden.setText("ID Empresa:");
        tabPanProdutosCadastrar.add(lblProdutoCadastrarHidden);
        lblProdutoCadastrarHidden.setBounds(20, 30, 70, 60);

        txtProdutoCadastrarHidden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoCadastrarHiddenActionPerformed(evt);
            }
        });
        txtProdutoCadastrarHidden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProdutoCadastrarHiddenKeyPressed(evt);
            }
        });
        tabPanProdutosCadastrar.add(txtProdutoCadastrarHidden);
        txtProdutoCadastrarHidden.setBounds(90, 40, 90, 40);

        btnProdutoCadastrarSalvar.setBackground(new java.awt.Color(205, 205, 227));
        btnProdutoCadastrarSalvar.setText("SALVAR");
        btnProdutoCadastrarSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoCadastrarSalvarActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar.add(btnProdutoCadastrarSalvar);
        btnProdutoCadastrarSalvar.setBounds(40, 350, 150, 60);

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel83.setText("Tipificação :");
        tabPanProdutosCadastrar.add(jLabel83);
        jLabel83.setBounds(-50, 120, 140, 60);

        txtProdutoCadastrarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoCadastrarTipoActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar.add(txtProdutoCadastrarTipo);
        txtProdutoCadastrarTipo.setBounds(100, 120, 320, 60);

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel84.setText("Nome do Produto:");
        tabPanProdutosCadastrar.add(jLabel84);
        jLabel84.setBounds(180, 30, 110, 60);

        txtProdutoCadastrarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoCadastrarNomeActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar.add(txtProdutoCadastrarNome);
        txtProdutoCadastrarNome.setBounds(300, 30, 310, 60);

        tabPanProdutos.addTab("Cadastrar Produto", tabPanProdutosCadastrar);

        tabPanProdutosAlterar.setBackground(new java.awt.Color(205, 205, 227));
        tabPanProdutosAlterar.setLayout(null);

        txtProdutoAlterarHidden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoAlterarHiddenActionPerformed(evt);
            }
        });
        txtProdutoAlterarHidden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProdutoAlterarHiddenKeyPressed(evt);
            }
        });
        tabPanProdutosAlterar.add(txtProdutoAlterarHidden);
        txtProdutoAlterarHidden.setBounds(90, 40, 90, 40);

        lblProdutoAlterarHidden.setText("ID Empresa:");
        tabPanProdutosAlterar.add(lblProdutoAlterarHidden);
        lblProdutoAlterarHidden.setBounds(20, 30, 70, 60);

        txtProdutoAlterarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoAlterarNomeActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar.add(txtProdutoAlterarNome);
        txtProdutoAlterarNome.setBounds(300, 30, 310, 60);

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel85.setText("Nome do Produto:");
        tabPanProdutosAlterar.add(jLabel85);
        jLabel85.setBounds(180, 30, 110, 60);

        txtProdutoAlterarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoAlterarTipoActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar.add(txtProdutoAlterarTipo);
        txtProdutoAlterarTipo.setBounds(100, 120, 320, 60);

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel86.setText("Tipificação :");
        tabPanProdutosAlterar.add(jLabel86);
        jLabel86.setBounds(-50, 120, 140, 60);

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel81.setText("Marca:");
        tabPanProdutosAlterar.add(jLabel81);
        jLabel81.setBounds(330, 120, 140, 60);

        txtProdutoAlterarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoAlterarMarcaActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar.add(txtProdutoAlterarMarca);
        txtProdutoAlterarMarca.setBounds(480, 120, 320, 60);

        txtProdutoAlterarQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoAlterarQtdActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar.add(txtProdutoAlterarQtd);
        txtProdutoAlterarQtd.setBounds(100, 210, 130, 60);

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel82.setText("Quantidade:");
        tabPanProdutosAlterar.add(jLabel82);
        jLabel82.setBounds(-50, 210, 140, 60);
        tabPanProdutosAlterar.add(txtProdutoAlterarDescricao);
        txtProdutoAlterarDescricao.setBounds(370, 210, 430, 200);

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel87.setText("Descrição :");
        tabPanProdutosAlterar.add(jLabel87);
        jLabel87.setBounds(280, 210, 80, 60);

        btnProdutoAlterarSalvar.setBackground(new java.awt.Color(205, 205, 227));
        btnProdutoAlterarSalvar.setText("SALVAR");
        btnProdutoAlterarSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoAlterarSalvarActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar.add(btnProdutoAlterarSalvar);
        btnProdutoAlterarSalvar.setBounds(40, 350, 150, 60);

        btnProdutoAlterarCancelar.setBackground(new java.awt.Color(205, 205, 227));
        btnProdutoAlterarCancelar.setText("CANCELAR");
        btnProdutoAlterarCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoAlterarCancelarActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar.add(btnProdutoAlterarCancelar);
        btnProdutoAlterarCancelar.setBounds(200, 350, 150, 60);

        btnProdutoAlterarBuscar.setBackground(new java.awt.Color(205, 205, 227));
        btnProdutoAlterarBuscar.setText("BUSCAR");
        btnProdutoAlterarBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoAlterarBuscarActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar.add(btnProdutoAlterarBuscar);
        btnProdutoAlterarBuscar.setBounds(620, 30, 150, 60);

        tabPanProdutos.addTab("Alterar Produto", tabPanProdutosAlterar);

        tabPanProdutosBuscar.setBackground(new java.awt.Color(205, 205, 227));
        tabPanProdutosBuscar.setLayout(null);

        lblUsuario1.setText("Usuário:");
        tabPanProdutosBuscar.add(lblUsuario1);
        lblUsuario1.setBounds(150, 20, 70, 60);

        txtProdutoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProdutoBuscarKeyPressed(evt);
            }
        });
        tabPanProdutosBuscar.add(txtProdutoBuscar);
        txtProdutoBuscar.setBounds(220, 30, 290, 40);

        btnProdutoBuscar.setBackground(new java.awt.Color(205, 205, 227));
        btnProdutoBuscar.setText("BUSCAR");
        btnProdutoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoBuscarActionPerformed(evt);
            }
        });
        tabPanProdutosBuscar.add(btnProdutoBuscar);
        btnProdutoBuscar.setBounds(600, 30, 190, 40);

        tblProdutosBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Marca", "Tipo", "Quantidade", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblProdutosBuscar);

        tabPanProdutosBuscar.add(jScrollPane8);
        jScrollPane8.setBounds(0, 80, 830, 420);

        lblProdutoBuscarHidden.setText("ID Empresa:");
        tabPanProdutosBuscar.add(lblProdutoBuscarHidden);
        lblProdutoBuscarHidden.setBounds(10, 20, 70, 60);

        txtProdutoBuscarHidden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoBuscarHiddenActionPerformed(evt);
            }
        });
        txtProdutoBuscarHidden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProdutoBuscarHiddenKeyPressed(evt);
            }
        });
        tabPanProdutosBuscar.add(txtProdutoBuscarHidden);
        txtProdutoBuscarHidden.setBounds(80, 30, 60, 40);

        tabPanProdutos.addTab("Buscar Produto", tabPanProdutosBuscar);

        tabPanProdutosExcluir.setBackground(new java.awt.Color(205, 205, 227));
        tabPanProdutosExcluir.setLayout(null);

        lblUsuarioHidden4.setText("Produto:");
        tabPanProdutosExcluir.add(lblUsuarioHidden4);
        lblUsuarioHidden4.setBounds(310, 150, 70, 60);

        txtProdutoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoExcluirActionPerformed(evt);
            }
        });
        txtProdutoExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProdutoExcluirKeyPressed(evt);
            }
        });
        tabPanProdutosExcluir.add(txtProdutoExcluir);
        txtProdutoExcluir.setBounds(390, 160, 160, 40);

        btnExcluir1.setBackground(new java.awt.Color(205, 205, 227));
        btnExcluir1.setText("EXCLUIR");
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir1ActionPerformed(evt);
            }
        });
        tabPanProdutosExcluir.add(btnExcluir1);
        btnExcluir1.setBounds(330, 260, 190, 40);

        txtProdutoExcluirHidden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoExcluirHiddenActionPerformed(evt);
            }
        });
        txtProdutoExcluirHidden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProdutoExcluirHiddenKeyPressed(evt);
            }
        });
        tabPanProdutosExcluir.add(txtProdutoExcluirHidden);
        txtProdutoExcluirHidden.setBounds(80, 30, 60, 40);

        lblProdutoExcluirHidden.setText("ID Empresa:");
        tabPanProdutosExcluir.add(lblProdutoExcluirHidden);
        lblProdutoExcluirHidden.setBounds(10, 20, 70, 60);

        tabPanProdutos.addTab("Excluir Produto", tabPanProdutosExcluir);

        tabPanProdutosCadastrar1.setBackground(new java.awt.Color(205, 205, 227));
        tabPanProdutosCadastrar1.setLayout(null);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Senha :");
        tabPanProdutosCadastrar1.add(jLabel46);
        jLabel46.setBounds(-70, 120, 140, 60);

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("Afiliação :");
        tabPanProdutosCadastrar1.add(jLabel47);
        jLabel47.setBounds(-70, 320, 140, 60);

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel48.setText("Telefone :");
        tabPanProdutosCadastrar1.add(jLabel48);
        jLabel48.setBounds(340, 120, 140, 60);

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("E-mail :");
        tabPanProdutosCadastrar1.add(jLabel49);
        jLabel49.setBounds(340, 220, 140, 60);

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel50.setText("Atribuição :");
        tabPanProdutosCadastrar1.add(jLabel50);
        jLabel50.setBounds(340, 320, 140, 60);

        txtSenhaCadastrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaCadastrar2ActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar1.add(txtSenhaCadastrar2);
        txtSenhaCadastrar2.setBounds(60, 120, 320, 60);
        tabPanProdutosCadastrar1.add(txtAfiliaCadastrar2);
        txtAfiliaCadastrar2.setBounds(60, 320, 320, 60);

        txtTelCadastrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelCadastrar2ActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar1.add(txtTelCadastrar2);
        txtTelCadastrar2.setBounds(490, 120, 320, 60);
        tabPanProdutosCadastrar1.add(txtEmailCadastrar2);
        txtEmailCadastrar2.setBounds(490, 220, 320, 60);

        txtAtribCadastrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAtribCadastrar2ActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar1.add(txtAtribCadastrar2);
        txtAtribCadastrar2.setBounds(490, 320, 320, 60);

        btnCancelarCadastroUsuario2.setBackground(new java.awt.Color(205, 205, 227));
        btnCancelarCadastroUsuario2.setText("CANCELAR");
        btnCancelarCadastroUsuario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroUsuario2ActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar1.add(btnCancelarCadastroUsuario2);
        btnCancelarCadastroUsuario2.setBounds(470, 420, 150, 60);

        btnSalvarUsuario2.setBackground(new java.awt.Color(205, 205, 227));
        btnSalvarUsuario2.setText("SALVAR");
        btnSalvarUsuario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuario2ActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar1.add(btnSalvarUsuario2);
        btnSalvarUsuario2.setBounds(240, 420, 150, 60);

        txtNicknameCadastrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknameCadastrar2ActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar1.add(txtNicknameCadastrar2);
        txtNicknameCadastrar2.setBounds(60, 220, 320, 60);

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel51.setText("Apelido :");
        tabPanProdutosCadastrar1.add(jLabel51);
        jLabel51.setBounds(-70, 220, 140, 60);

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel52.setText("Nome do Produto");
        tabPanProdutosCadastrar1.add(jLabel52);
        jLabel52.setBounds(140, 30, 140, 60);

        txtUsuarioCadastrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioCadastrar2ActionPerformed(evt);
            }
        });
        tabPanProdutosCadastrar1.add(txtUsuarioCadastrar2);
        txtUsuarioCadastrar2.setBounds(290, 30, 320, 60);

        tabPanProdutos.addTab("Cadastrar Sub-Produto", tabPanProdutosCadastrar1);

        tabPanProdutosAlterar1.setBackground(new java.awt.Color(205, 205, 227));
        tabPanProdutosAlterar1.setLayout(null);

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel66.setText("Telefone :");
        tabPanProdutosAlterar1.add(jLabel66);
        jLabel66.setBounds(350, 120, 140, 60);

        txtTelAlterar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelAlterar3ActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar1.add(txtTelAlterar3);
        txtTelAlterar3.setBounds(500, 120, 320, 60);
        tabPanProdutosAlterar1.add(txtEmailAlterar3);
        txtEmailAlterar3.setBounds(500, 220, 320, 60);

        txtNicknameAlterar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknameAlterar3ActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar1.add(txtNicknameAlterar3);
        txtNicknameAlterar3.setBounds(70, 220, 320, 60);

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel67.setText("Apelido :");
        tabPanProdutosAlterar1.add(jLabel67);
        jLabel67.setBounds(-70, 220, 140, 60);

        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel68.setText("E-mail :");
        tabPanProdutosAlterar1.add(jLabel68);
        jLabel68.setBounds(350, 220, 140, 60);

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel69.setText("Atribuição :");
        tabPanProdutosAlterar1.add(jLabel69);
        jLabel69.setBounds(350, 320, 140, 60);

        txtAtribAlterar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAtribAlterar3ActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar1.add(txtAtribAlterar3);
        txtAtribAlterar3.setBounds(500, 320, 320, 60);
        tabPanProdutosAlterar1.add(txtAfiliaAlterar3);
        txtAfiliaAlterar3.setBounds(70, 320, 320, 60);

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel70.setText("Afiliação :");
        tabPanProdutosAlterar1.add(jLabel70);
        jLabel70.setBounds(-70, 320, 140, 60);

        btnCancelarAlterarUsuario3.setBackground(new java.awt.Color(205, 205, 227));
        btnCancelarAlterarUsuario3.setText("CANCELAR");
        btnCancelarAlterarUsuario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlterarUsuario3ActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar1.add(btnCancelarAlterarUsuario3);
        btnCancelarAlterarUsuario3.setBounds(480, 420, 150, 60);

        lblUsuarioHidden5.setText("ID Usuário:");
        tabPanProdutosAlterar1.add(lblUsuarioHidden5);
        lblUsuarioHidden5.setBounds(30, 30, 70, 60);

        txtUsuarioHidden3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioHidden3ActionPerformed(evt);
            }
        });
        txtUsuarioHidden3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioHidden3KeyPressed(evt);
            }
        });
        tabPanProdutosAlterar1.add(txtUsuarioHidden3);
        txtUsuarioHidden3.setBounds(100, 40, 90, 40);

        btnAlterarUsuario3.setBackground(new java.awt.Color(205, 205, 227));
        btnAlterarUsuario3.setText("ALTERAR");
        btnAlterarUsuario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarUsuario3ActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar1.add(btnAlterarUsuario3);
        btnAlterarUsuario3.setBounds(250, 420, 150, 60);

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel71.setText("Senha :");
        tabPanProdutosAlterar1.add(jLabel71);
        jLabel71.setBounds(-70, 120, 140, 60);

        txtSenhaAlterar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaAlterar3ActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar1.add(txtSenhaAlterar3);
        txtSenhaAlterar3.setBounds(70, 120, 320, 60);

        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel72.setText("Usuário :");
        tabPanProdutosAlterar1.add(jLabel72);
        jLabel72.setBounds(210, 30, 70, 60);

        txtUsuarioAlterar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioAlterar3ActionPerformed(evt);
            }
        });
        tabPanProdutosAlterar1.add(txtUsuarioAlterar3);
        txtUsuarioAlterar3.setBounds(290, 30, 320, 60);

        tabPanProdutos.addTab("Alterar Sub-Produto", tabPanProdutosAlterar1);

        panelProdutos.add(tabPanProdutos);
        tabPanProdutos.setBounds(0, 130, 980, 530);

        jDesktopPane1.add(panelProdutos);
        panelProdutos.setBounds(0, 0, 1000, 710);

        panelEmpresa.setBackground(new java.awt.Color(107, 134, 166));
        panelEmpresa.setLayout(null);

        tabPanEmpresa.setBackground(new java.awt.Color(107, 134, 166));
        tabPanEmpresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tabPanEmpresa.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabPanEmpresa.setOpaque(true);

        tabPanEmpresaApresentacao.setBackground(new java.awt.Color(205, 205, 227));
        tabPanEmpresaApresentacao.setLayout(null);

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae metus id libero tincidunt lobortis. \nDuis id diam vel odio consequat sodales. Integer aliquam laoreet magna, tempus ornare augue sollicitudin \nvel. Suspendisse fermentum velit enim, quis vulputate leo convallis sit amet. Nunc quam sem, dignissim a \nfaucibus ut, aliquam vitae purus. Sed erat dolor, rutrum in lacinia in, semper sit amet sapien. Quisque et dui vel \ndolor pulvinar lacinia vitae in velit. Fusce sollicitudin eros sit amet massa vehicula, vitae tempus nisi convallis. \nDuis ultricies velit sed cursus egestas. Vestibulum facilisis ac felis non pretium.\n\nInteger convallis enim maximus nibh interdum, sed placerat mi interdum. In dapibus in magna eget mattis. \nPhasellus tempus fringilla risus non egestas. Nulla malesuada orci neque, eu convallis urna convallis ac. Sed ac \nnibh at metus tincidunt gravida. Cras ac vehicula massa. Suspendisse potenti. Praesent ut ante porttitor, elementum \nlorem vel, fermentum turpis. Praesent ut est nec nunc vestibulum iaculis. Aliquam fringilla congue purus ornare \nconsectetur. Nullam mi elit, bibendum sit amet purus vitae, ultricies cursus elit. Pellentesque semper nunc nec mattis \ndignissim. In nibh sapien, tristique in pretium sed, viverra quis tortor.");
        jTextArea2.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jTextArea2);

        tabPanEmpresaApresentacao.add(jScrollPane3);
        jScrollPane3.setBounds(90, 100, 680, 350);

        tabPanEmpresa.addTab("Apresentação", tabPanEmpresaApresentacao);

        tabPanEmpresaMVV.setBackground(new java.awt.Color(205, 205, 227));
        tabPanEmpresaMVV.setLayout(null);

        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae metus id libero tincidunt lobortis. \nDuis id diam vel odio consequat sodales. Integer aliquam laoreet magna, tempus ornare augue sollicitudin \nvel. Suspendisse fermentum velit enim, quis vulputate leo convallis sit amet. Nunc quam sem, dignissim a \nfaucibus ut, aliquam vitae purus. Sed erat dolor, rutrum in lacinia in, semper sit amet sapien. Quisque et dui vel \ndolor pulvinar lacinia vitae in velit. Fusce sollicitudin eros sit amet massa vehicula, vitae tempus nisi convallis. \nDuis ultricies velit sed cursus egestas. Vestibulum facilisis ac felis non pretium.\n\n");
        jTextArea3.setWrapStyleWord(true);
        jScrollPane5.setViewportView(jTextArea3);

        tabPanEmpresaMVV.add(jScrollPane5);
        jScrollPane5.setBounds(560, 120, 230, 350);

        jTextArea4.setColumns(20);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae metus id libero tincidunt lobortis. \nDuis id diam vel odio consequat sodales. Integer aliquam laoreet magna, tempus ornare augue sollicitudin \nvel. Suspendisse fermentum velit enim, quis vulputate leo convallis sit amet. Nunc quam sem, dignissim a \nfaucibus ut, aliquam vitae purus. Sed erat dolor, rutrum in lacinia in, semper sit amet sapien. Quisque et dui vel \ndolor pulvinar lacinia vitae in velit. Fusce sollicitudin eros sit amet massa vehicula, vitae tempus nisi convallis. \nDuis ultricies velit sed cursus egestas. Vestibulum facilisis ac felis non pretium.\n\n");
        jTextArea4.setWrapStyleWord(true);
        jScrollPane6.setViewportView(jTextArea4);

        tabPanEmpresaMVV.add(jScrollPane6);
        jScrollPane6.setBounds(30, 120, 230, 350);

        jTextArea5.setColumns(20);
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(5);
        jTextArea5.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae metus id libero tincidunt lobortis. \nDuis id diam vel odio consequat sodales. Integer aliquam laoreet magna, tempus ornare augue sollicitudin \nvel. Suspendisse fermentum velit enim, quis vulputate leo convallis sit amet. Nunc quam sem, dignissim a \nfaucibus ut, aliquam vitae purus. Sed erat dolor, rutrum in lacinia in, semper sit amet sapien. Quisque et dui vel \ndolor pulvinar lacinia vitae in velit. Fusce sollicitudin eros sit amet massa vehicula, vitae tempus nisi convallis. \nDuis ultricies velit sed cursus egestas. Vestibulum facilisis ac felis non pretium.\n\n");
        jTextArea5.setWrapStyleWord(true);
        jScrollPane7.setViewportView(jTextArea5);

        tabPanEmpresaMVV.add(jScrollPane7);
        jScrollPane7.setBounds(300, 120, 230, 350);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VALORES");
        tabPanEmpresaMVV.add(jLabel1);
        jLabel1.setBounds(600, 50, 140, 50);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MISSÃO");
        tabPanEmpresaMVV.add(jLabel2);
        jLabel2.setBounds(80, 50, 140, 50);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("VISÃO");
        tabPanEmpresaMVV.add(jLabel31);
        jLabel31.setBounds(340, 50, 140, 50);

        tabPanEmpresa.addTab("Missão, Visão e Valores", tabPanEmpresaMVV);

        tabPanEmpresaInfo.setBackground(new java.awt.Color(205, 205, 227));
        tabPanEmpresaInfo.setLayout(null);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Telefone :");
        tabPanEmpresaInfo.add(jLabel24);
        jLabel24.setBounds(350, 120, 130, 60);

        txtTelAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelAlterar1ActionPerformed(evt);
            }
        });
        tabPanEmpresaInfo.add(txtTelAlterar1);
        txtTelAlterar1.setBounds(500, 120, 310, 60);
        tabPanEmpresaInfo.add(txtEmailAlterar1);
        txtEmailAlterar1.setBounds(500, 220, 310, 60);

        txtNicknameAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknameAlterar1ActionPerformed(evt);
            }
        });
        tabPanEmpresaInfo.add(txtNicknameAlterar1);
        txtNicknameAlterar1.setBounds(70, 220, 310, 60);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Apelido :");
        tabPanEmpresaInfo.add(jLabel25);
        jLabel25.setBounds(-60, 220, 130, 60);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("E-mail :");
        tabPanEmpresaInfo.add(jLabel26);
        jLabel26.setBounds(350, 220, 130, 60);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Atribuição :");
        tabPanEmpresaInfo.add(jLabel27);
        jLabel27.setBounds(350, 320, 130, 60);

        txtAtribAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAtribAlterar1ActionPerformed(evt);
            }
        });
        tabPanEmpresaInfo.add(txtAtribAlterar1);
        txtAtribAlterar1.setBounds(500, 320, 310, 60);
        tabPanEmpresaInfo.add(txtAfiliaAlterar1);
        txtAfiliaAlterar1.setBounds(70, 320, 310, 60);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Afiliação :");
        tabPanEmpresaInfo.add(jLabel28);
        jLabel28.setBounds(-60, 320, 130, 60);

        btnCancelarAlterarUsuario1.setBackground(new java.awt.Color(205, 205, 227));
        btnCancelarAlterarUsuario1.setText("CANCELAR");
        btnCancelarAlterarUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlterarUsuario1ActionPerformed(evt);
            }
        });
        tabPanEmpresaInfo.add(btnCancelarAlterarUsuario1);
        btnCancelarAlterarUsuario1.setBounds(480, 420, 140, 60);

        lblUsuarioHidden2.setText("ID Usuário:");
        tabPanEmpresaInfo.add(lblUsuarioHidden2);
        lblUsuarioHidden2.setBounds(30, 30, 60, 60);

        txtUsuarioHidden1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioHidden1ActionPerformed(evt);
            }
        });
        txtUsuarioHidden1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioHidden1KeyPressed(evt);
            }
        });
        tabPanEmpresaInfo.add(txtUsuarioHidden1);
        txtUsuarioHidden1.setBounds(100, 40, 80, 40);

        btnAlterarUsuario1.setBackground(new java.awt.Color(205, 205, 227));
        btnAlterarUsuario1.setText("ALTERAR");
        btnAlterarUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarUsuario1ActionPerformed(evt);
            }
        });
        tabPanEmpresaInfo.add(btnAlterarUsuario1);
        btnAlterarUsuario1.setBounds(250, 420, 140, 60);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Senha :");
        tabPanEmpresaInfo.add(jLabel29);
        jLabel29.setBounds(-60, 120, 130, 60);

        txtSenhaAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaAlterar1ActionPerformed(evt);
            }
        });
        tabPanEmpresaInfo.add(txtSenhaAlterar1);
        txtSenhaAlterar1.setBounds(70, 120, 310, 60);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Usuário :");
        tabPanEmpresaInfo.add(jLabel30);
        jLabel30.setBounds(210, 30, 60, 60);

        txtUsuarioAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioAlterar1ActionPerformed(evt);
            }
        });
        tabPanEmpresaInfo.add(txtUsuarioAlterar1);
        txtUsuarioAlterar1.setBounds(290, 30, 310, 60);

        tabPanEmpresa.addTab("Informações", tabPanEmpresaInfo);

        tabPanEmpresaMO.setBackground(new java.awt.Color(205, 205, 227));
        tabPanEmpresaMO.setLayout(null);

        jTextArea7.setColumns(20);
        jTextArea7.setLineWrap(true);
        jTextArea7.setRows(5);
        jTextArea7.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae metus id libero tincidunt lobortis. \nDuis id diam vel odio consequat sodales. Integer aliquam laoreet magna, tempus ornare augue sollicitudin \nvel. Suspendisse fermentum velit enim, quis vulputate leo convallis sit amet. Nunc quam sem, dignissim a \nfaucibus ut, aliquam vitae purus. Sed erat dolor, rutrum in lacinia in, semper sit amet sapien. Quisque et dui vel \ndolor pulvinar lacinia vitae in velit. Fusce sollicitudin eros sit amet massa vehicula, vitae tempus nisi convallis. \nDuis ultricies velit sed cursus egestas. Vestibulum facilisis ac felis non pretium.\n\n");
        jTextArea7.setWrapStyleWord(true);
        jScrollPane14.setViewportView(jTextArea7);

        tabPanEmpresaMO.add(jScrollPane14);
        jScrollPane14.setBounds(30, 120, 320, 350);

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("METAS");
        tabPanEmpresaMO.add(jLabel32);
        jLabel32.setBounds(120, 50, 140, 50);

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("OBJETIVOS");
        tabPanEmpresaMO.add(jLabel33);
        jLabel33.setBounds(480, 50, 140, 50);

        jTextArea8.setColumns(20);
        jTextArea8.setLineWrap(true);
        jTextArea8.setRows(5);
        jTextArea8.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae metus id libero tincidunt lobortis. \nDuis id diam vel odio consequat sodales. Integer aliquam laoreet magna, tempus ornare augue sollicitudin \nvel. Suspendisse fermentum velit enim, quis vulputate leo convallis sit amet. Nunc quam sem, dignissim a \nfaucibus ut, aliquam vitae purus. Sed erat dolor, rutrum in lacinia in, semper sit amet sapien. Quisque et dui vel \ndolor pulvinar lacinia vitae in velit. Fusce sollicitudin eros sit amet massa vehicula, vitae tempus nisi convallis. \nDuis ultricies velit sed cursus egestas. Vestibulum facilisis ac felis non pretium.\n\n");
        jTextArea8.setWrapStyleWord(true);
        jScrollPane15.setViewportView(jTextArea8);

        tabPanEmpresaMO.add(jScrollPane15);
        jScrollPane15.setBounds(390, 120, 340, 350);

        tabPanEmpresa.addTab("Metas e Objetivos", tabPanEmpresaMO);

        tabPanEmpresaCadastrar.setBackground(new java.awt.Color(205, 205, 227));
        tabPanEmpresaCadastrar.setLayout(null);

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("CEP:");
        tabPanEmpresaCadastrar.add(jLabel39);
        jLabel39.setBounds(-80, 120, 140, 60);

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Rua:");
        tabPanEmpresaCadastrar.add(jLabel40);
        jLabel40.setBounds(-80, 320, 140, 60);

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setText("CNPJ:");
        tabPanEmpresaCadastrar.add(jLabel41);
        jLabel41.setBounds(400, 120, 60, 60);

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("E-mail:");
        tabPanEmpresaCadastrar.add(jLabel42);
        jLabel42.setBounds(400, 320, 60, 60);

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Estado:");
        tabPanEmpresaCadastrar.add(jLabel43);
        jLabel43.setBounds(180, 120, 70, 60);

        txtEmpresaCadastrarCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaCadastrarCEPActionPerformed(evt);
            }
        });
        tabPanEmpresaCadastrar.add(txtEmpresaCadastrarCEP);
        txtEmpresaCadastrarCEP.setBounds(70, 120, 130, 60);
        tabPanEmpresaCadastrar.add(txtEmpresaCadastrarRua);
        txtEmpresaCadastrarRua.setBounds(70, 320, 330, 60);

        txtEmpresaCadastrarCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaCadastrarCNPJActionPerformed(evt);
            }
        });
        tabPanEmpresaCadastrar.add(txtEmpresaCadastrarCNPJ);
        txtEmpresaCadastrarCNPJ.setBounds(470, 120, 330, 60);
        tabPanEmpresaCadastrar.add(txtEmpresaCadastrarEmail);
        txtEmpresaCadastrarEmail.setBounds(470, 320, 330, 60);

        txtEmpresaCadastrarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaCadastrarEstadoActionPerformed(evt);
            }
        });
        tabPanEmpresaCadastrar.add(txtEmpresaCadastrarEstado);
        txtEmpresaCadastrarEstado.setBounds(260, 120, 140, 60);

        btnEmpresaCadastrarCancelar.setBackground(new java.awt.Color(205, 205, 227));
        btnEmpresaCadastrarCancelar.setText("CANCELAR");
        btnEmpresaCadastrarCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaCadastrarCancelarActionPerformed(evt);
            }
        });
        tabPanEmpresaCadastrar.add(btnEmpresaCadastrarCancelar);
        btnEmpresaCadastrarCancelar.setBounds(470, 430, 150, 60);

        btnEmpresaCadastrarSalvar.setBackground(new java.awt.Color(205, 205, 227));
        btnEmpresaCadastrarSalvar.setText("SALVAR");
        btnEmpresaCadastrarSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaCadastrarSalvarActionPerformed(evt);
            }
        });
        tabPanEmpresaCadastrar.add(btnEmpresaCadastrarSalvar);
        btnEmpresaCadastrarSalvar.setBounds(240, 430, 150, 60);

        txtEmpresaCadastrarBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaCadastrarBairroActionPerformed(evt);
            }
        });
        tabPanEmpresaCadastrar.add(txtEmpresaCadastrarBairro);
        txtEmpresaCadastrarBairro.setBounds(70, 220, 200, 60);

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Bairro:");
        tabPanEmpresaCadastrar.add(jLabel44);
        jLabel44.setBounds(-80, 220, 140, 60);

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Nome Fantasia");
        tabPanEmpresaCadastrar.add(jLabel45);
        jLabel45.setBounds(130, 30, 140, 60);

        txtEmpresaCadastrarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaCadastrarNomeActionPerformed(evt);
            }
        });
        tabPanEmpresaCadastrar.add(txtEmpresaCadastrarNome);
        txtEmpresaCadastrarNome.setBounds(280, 30, 320, 60);

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel54.setText("N°:");
        tabPanEmpresaCadastrar.add(jLabel54);
        jLabel54.setBounds(230, 220, 70, 60);

        txtEmpresaCadastrarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaCadastrarNActionPerformed(evt);
            }
        });
        tabPanEmpresaCadastrar.add(txtEmpresaCadastrarN);
        txtEmpresaCadastrarN.setBounds(310, 220, 90, 60);

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel55.setText("Tel:");
        tabPanEmpresaCadastrar.add(jLabel55);
        jLabel55.setBounds(580, 220, 70, 60);

        txtEmpresaCadastrarTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaCadastrarTelActionPerformed(evt);
            }
        });
        tabPanEmpresaCadastrar.add(txtEmpresaCadastrarTel);
        txtEmpresaCadastrarTel.setBounds(660, 220, 140, 60);

        txtEmpresaCadastrarRamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaCadastrarRamoActionPerformed(evt);
            }
        });
        tabPanEmpresaCadastrar.add(txtEmpresaCadastrarRamo);
        txtEmpresaCadastrarRamo.setBounds(470, 220, 150, 60);

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel56.setText("Ramo:");
        tabPanEmpresaCadastrar.add(jLabel56);
        jLabel56.setBounds(390, 220, 70, 60);

        tabPanEmpresa.addTab("Cadastrar", tabPanEmpresaCadastrar);

        tabPanEmpresaAtualizar.setBackground(new java.awt.Color(205, 205, 227));
        tabPanEmpresaAtualizar.setLayout(null);

        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel53.setText("CEP:");
        tabPanEmpresaAtualizar.add(jLabel53);
        jLabel53.setBounds(-80, 120, 140, 60);

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel57.setText("Rua:");
        tabPanEmpresaAtualizar.add(jLabel57);
        jLabel57.setBounds(-80, 320, 140, 60);

        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel58.setText("CNPJ:");
        tabPanEmpresaAtualizar.add(jLabel58);
        jLabel58.setBounds(400, 120, 60, 60);

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel59.setText("E-mail:");
        tabPanEmpresaAtualizar.add(jLabel59);
        jLabel59.setBounds(400, 320, 60, 60);

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel60.setText("Estado:");
        tabPanEmpresaAtualizar.add(jLabel60);
        jLabel60.setBounds(180, 120, 70, 60);

        txtEmpresaAtualizarCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaAtualizarCEPActionPerformed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(txtEmpresaAtualizarCEP);
        txtEmpresaAtualizarCEP.setBounds(70, 120, 130, 60);
        tabPanEmpresaAtualizar.add(txtEmpresaAtualizarRua);
        txtEmpresaAtualizarRua.setBounds(70, 320, 330, 60);

        txtEmpresaAtualizarCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaAtualizarCNPJActionPerformed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(txtEmpresaAtualizarCNPJ);
        txtEmpresaAtualizarCNPJ.setBounds(470, 120, 330, 60);
        tabPanEmpresaAtualizar.add(txtEmpresaAtualizarEmail);
        txtEmpresaAtualizarEmail.setBounds(470, 320, 330, 60);

        txtEmpresaAtualizarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaAtualizarEstadoActionPerformed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(txtEmpresaAtualizarEstado);
        txtEmpresaAtualizarEstado.setBounds(260, 120, 140, 60);

        btnEmpresaAtualizarCancelar.setBackground(new java.awt.Color(205, 205, 227));
        btnEmpresaAtualizarCancelar.setText("CANCELAR");
        btnEmpresaAtualizarCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaAtualizarCancelarActionPerformed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(btnEmpresaAtualizarCancelar);
        btnEmpresaAtualizarCancelar.setBounds(470, 430, 150, 60);

        btnEmpresaAtualizarSalvar.setBackground(new java.awt.Color(205, 205, 227));
        btnEmpresaAtualizarSalvar.setText("SALVAR");
        btnEmpresaAtualizarSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaAtualizarSalvarActionPerformed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(btnEmpresaAtualizarSalvar);
        btnEmpresaAtualizarSalvar.setBounds(240, 430, 150, 60);

        txtEmpresaAtualizarBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaAtualizarBairroActionPerformed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(txtEmpresaAtualizarBairro);
        txtEmpresaAtualizarBairro.setBounds(70, 220, 200, 60);

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel61.setText("Bairro:");
        tabPanEmpresaAtualizar.add(jLabel61);
        jLabel61.setBounds(-80, 220, 140, 60);

        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel62.setText("Nome Fantasia");
        tabPanEmpresaAtualizar.add(jLabel62);
        jLabel62.setBounds(180, 30, 90, 60);

        txtEmpresaAtualizarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaAtualizarNomeActionPerformed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(txtEmpresaAtualizarNome);
        txtEmpresaAtualizarNome.setBounds(280, 30, 320, 60);

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel63.setText("N°:");
        tabPanEmpresaAtualizar.add(jLabel63);
        jLabel63.setBounds(230, 220, 70, 60);

        txtEmpresaAtualizarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaAtualizarNActionPerformed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(txtEmpresaAtualizarN);
        txtEmpresaAtualizarN.setBounds(310, 220, 90, 60);

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel64.setText("Tel:");
        tabPanEmpresaAtualizar.add(jLabel64);
        jLabel64.setBounds(580, 220, 70, 60);

        txtEmpresaAtualizarTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaAtualizarTelActionPerformed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(txtEmpresaAtualizarTel);
        txtEmpresaAtualizarTel.setBounds(660, 220, 140, 60);

        txtEmpresaAtualizarRamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaAtualizarRamoActionPerformed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(txtEmpresaAtualizarRamo);
        txtEmpresaAtualizarRamo.setBounds(470, 220, 150, 60);

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel65.setText("Ramo:");
        tabPanEmpresaAtualizar.add(jLabel65);
        jLabel65.setBounds(390, 220, 70, 60);

        lblEmpresaHidden.setText("ID Usuário:");
        tabPanEmpresaAtualizar.add(lblEmpresaHidden);
        lblEmpresaHidden.setBounds(20, 30, 70, 60);

        txtEmpresaHidden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaHiddenActionPerformed(evt);
            }
        });
        txtEmpresaHidden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmpresaHiddenKeyPressed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(txtEmpresaHidden);
        txtEmpresaHidden.setBounds(90, 40, 90, 40);

        btnEmpresaAtualizarImportarHidden.setBackground(new java.awt.Color(205, 205, 227));
        btnEmpresaAtualizarImportarHidden.setText("IMPORTAR DADOS");
        btnEmpresaAtualizarImportarHidden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaAtualizarImportarHiddenActionPerformed(evt);
            }
        });
        tabPanEmpresaAtualizar.add(btnEmpresaAtualizarImportarHidden);
        btnEmpresaAtualizarImportarHidden.setBounds(610, 30, 150, 60);

        tabPanEmpresa.addTab("Atualizar", tabPanEmpresaAtualizar);

        tabPanEmpresaBuscar.setBackground(new java.awt.Color(205, 205, 227));
        tabPanEmpresaBuscar.setLayout(null);

        lblUsuario2.setText("Empresa:");
        tabPanEmpresaBuscar.add(lblUsuario2);
        lblUsuario2.setBounds(150, 20, 70, 60);

        txtEmpresaBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmpresaBuscarKeyPressed(evt);
            }
        });
        tabPanEmpresaBuscar.add(txtEmpresaBuscar);
        txtEmpresaBuscar.setBounds(220, 30, 290, 40);

        btnBuscarEmpresa.setBackground(new java.awt.Color(205, 205, 227));
        btnBuscarEmpresa.setText("BUSCAR");
        btnBuscarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpresaActionPerformed(evt);
            }
        });
        tabPanEmpresaBuscar.add(btnBuscarEmpresa);
        btnBuscarEmpresa.setBounds(600, 30, 190, 40);

        tblEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "CNPJ", "Ramo", "Estado", "Email", "Tel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblEmpresa);

        tabPanEmpresaBuscar.add(jScrollPane9);
        jScrollPane9.setBounds(0, 90, 830, 440);

        tabPanEmpresa.addTab("Buscar", tabPanEmpresaBuscar);

        tabPanEmpresaExcluir.setBackground(new java.awt.Color(205, 205, 227));
        tabPanEmpresaExcluir.setLayout(null);

        lblUsuarioHidden6.setText("ID Empresa:");
        tabPanEmpresaExcluir.add(lblUsuarioHidden6);
        lblUsuarioHidden6.setBounds(310, 150, 70, 60);

        txtIDEmpresaExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDEmpresaExcluirActionPerformed(evt);
            }
        });
        txtIDEmpresaExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDEmpresaExcluirKeyPressed(evt);
            }
        });
        tabPanEmpresaExcluir.add(txtIDEmpresaExcluir);
        txtIDEmpresaExcluir.setBounds(390, 160, 160, 40);

        btnExcluirEmpresa.setBackground(new java.awt.Color(205, 205, 227));
        btnExcluirEmpresa.setText("EXCLUIR");
        btnExcluirEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirEmpresaActionPerformed(evt);
            }
        });
        tabPanEmpresaExcluir.add(btnExcluirEmpresa);
        btnExcluirEmpresa.setBounds(330, 260, 190, 40);

        tabPanEmpresa.addTab("Excluir", tabPanEmpresaExcluir);

        panelEmpresa.add(tabPanEmpresa);
        tabPanEmpresa.setBounds(0, 130, 980, 530);

        jDesktopPane1.add(panelEmpresa);
        panelEmpresa.setBounds(0, 0, 1000, 710);

        panelFuncionarios.setBackground(new java.awt.Color(205, 205, 227));
        panelFuncionarios.setLayout(null);
        jDesktopPane1.add(panelFuncionarios);
        panelFuncionarios.setBounds(0, 0, 1000, 710);

        panelEstoque.setBackground(new java.awt.Color(205, 205, 227));
        panelEstoque.setLayout(null);
        jDesktopPane1.add(panelEstoque);
        panelEstoque.setBounds(0, 0, 1000, 710);

        panelMaquinario.setBackground(new java.awt.Color(205, 205, 227));
        panelMaquinario.setLayout(null);
        jDesktopPane1.add(panelMaquinario);
        panelMaquinario.setBounds(0, 0, 1000, 710);

        panelProcessos.setBackground(new java.awt.Color(205, 205, 227));
        panelProcessos.setLayout(null);
        jDesktopPane1.add(panelProcessos);
        panelProcessos.setBounds(0, 0, 1000, 710);

        panelForum.setBackground(new java.awt.Color(205, 205, 227));
        panelForum.setLayout(null);
        jDesktopPane1.add(panelForum);
        panelForum.setBounds(0, 0, 1000, 710);

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(290, 0, 1000, 710);

        jPanel1.setBackground(new java.awt.Color(85, 112, 144));

        btnForum.setText("Fórum");
        btnForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForumActionPerformed(evt);
            }
        });

        btnEmpresa.setText("Empresa");
        btnEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaActionPerformed(evt);
            }
        });

        btnFuncionarios.setText("Funcionários");
        btnFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionariosActionPerformed(evt);
            }
        });

        btnUsuario.setText("Usuário");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        btnProdutos.setText("Produtos");
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        btnEstoque.setText("Estoque");
        btnEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstoqueActionPerformed(evt);
            }
        });

        btnMaquinario.setText("Maquinário");
        btnMaquinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaquinarioActionPerformed(evt);
            }
        });

        btnProcessos.setText("Processos");
        btnProcessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMaquinario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnForum, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(btnEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(btnFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(btnEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(btnMaquinario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(btnProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(btnForum, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGap(25, 25, 25)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 260, 260, 290);

        btnSair.setBackground(new java.awt.Color(107, 134, 166));
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(140, 580, 110, 40);

        btnDeslogar.setBackground(new java.awt.Color(107, 134, 166));
        btnDeslogar.setText("DESLOGAR");
        btnDeslogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeslogarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeslogar);
        btnDeslogar.setBounds(20, 580, 110, 40);

        menu.setBackground(new java.awt.Color(85, 112, 144));
        menu.setOpaque(true);
        getContentPane().add(menu);
        menu.setBounds(0, 0, 290, 710);

        setSize(new java.awt.Dimension(1300, 716));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        panelUsuario.setVisible(true);
        panelEmpresa.setVisible(false);
        panelFuncionarios.setVisible(false);
        panelProdutos.setVisible(false);
        panelEstoque.setVisible(false);
        panelMaquinario.setVisible(false);
        panelProcessos.setVisible(false);
        panelForum.setVisible(false);

    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForumActionPerformed
        panelForum.setVisible(true);
        panelUsuario.setVisible(false);
        panelEmpresa.setVisible(false);
        panelFuncionarios.setVisible(false);
        panelProdutos.setVisible(false);
        panelEstoque.setVisible(false);
        panelMaquinario.setVisible(false);
        panelProcessos.setVisible(false);
    }//GEN-LAST:event_btnForumActionPerformed

    private void btnMaquinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaquinarioActionPerformed
        panelMaquinario.setVisible(true);
        panelUsuario.setVisible(false);
        panelEmpresa.setVisible(false);
        panelFuncionarios.setVisible(false);
        panelProdutos.setVisible(false);
        panelEstoque.setVisible(false);
        panelProcessos.setVisible(false);
        panelForum.setVisible(false);
    }//GEN-LAST:event_btnMaquinarioActionPerformed

    private void btnEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaActionPerformed
        panelEmpresa.setVisible(true);
        panelUsuario.setVisible(false);
        panelFuncionarios.setVisible(false);
        panelProdutos.setVisible(false);
        panelEstoque.setVisible(false);
        panelMaquinario.setVisible(false);
        panelProcessos.setVisible(false);
        panelForum.setVisible(false);
    }//GEN-LAST:event_btnEmpresaActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        panelProdutos.setVisible(true);
        panelUsuario.setVisible(false);
        panelEmpresa.setVisible(false);
        panelFuncionarios.setVisible(false);
        panelEstoque.setVisible(false);
        panelMaquinario.setVisible(false);
        panelProcessos.setVisible(false);
        panelForum.setVisible(false);
    }//GEN-LAST:event_btnProdutosActionPerformed

    private void btnProcessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessosActionPerformed
        panelProcessos.setVisible(true);
        panelUsuario.setVisible(false);
        panelEmpresa.setVisible(false);
        panelFuncionarios.setVisible(false);
        panelProdutos.setVisible(false);
        panelEstoque.setVisible(false);
        panelMaquinario.setVisible(false);
        panelForum.setVisible(false);
    }//GEN-LAST:event_btnProcessosActionPerformed

    private void btnEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstoqueActionPerformed
        panelEstoque.setVisible(true);
        panelUsuario.setVisible(false);
        panelEmpresa.setVisible(false);
        panelFuncionarios.setVisible(false);
        panelProdutos.setVisible(false);
        panelMaquinario.setVisible(false);
        panelProcessos.setVisible(false);
        panelForum.setVisible(false);
    }//GEN-LAST:event_btnEstoqueActionPerformed

    private void btnFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionariosActionPerformed
        panelUsuario.setVisible(false);
        panelEmpresa.setVisible(false);
        panelFuncionarios.setVisible(true);
        panelProdutos.setVisible(false);
        panelEstoque.setVisible(false);
        panelMaquinario.setVisible(false);
        panelProcessos.setVisible(false);
        panelForum.setVisible(false);
    }//GEN-LAST:event_btnFuncionariosActionPerformed

    private void btnCancelarCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroUsuarioActionPerformed

        txtUsuarioCadastrar.setText("");
        txtSenhaCadastrar.setText("");
        txtNicknameCadastrar.setText("");
        txtTelCadastrar.setText("");
        txtEmailCadastrar.setText("");
        txtAfiliaCadastrar.setText("");
        txtAtribCadastrar.setText("");
        
    }//GEN-LAST:event_btnCancelarCadastroUsuarioActionPerformed

    private void btnSalvarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuarioActionPerformed
        String u, senha, nick, tel, email, afilia, atrib;
        u = txtUsuarioCadastrar.getText();
        senha = txtSenhaCadastrar.getText();
        nick = txtNicknameCadastrar.getText();
        tel = txtTelCadastrar.getText();
        email = txtEmailCadastrar.getText();
        afilia = txtAfiliaCadastrar.getText();
        atrib = txtAtribCadastrar.getText();
        try {
            new EmpresaDao().salvarUsuario(u, senha, nick, tel, email, afilia, atrib);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
            btnCancelarCadastroUsuario.doClick();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            String erro = ex.getMessage();
            if (erro.contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Usuário já cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contatio com o suporte e informe o erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSalvarUsuarioActionPerformed

    private void txtSenhaCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaCadastrarActionPerformed

    private void txtTelCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelCadastrarActionPerformed

    private void txtAtribCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAtribCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAtribCadastrarActionPerformed

    private void txtNicknameCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknameCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknameCadastrarActionPerformed

    private void txtTelAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelAlterarActionPerformed

    private void txtNicknameAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknameAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknameAlterarActionPerformed

    private void txtAtribAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAtribAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAtribAlterarActionPerformed

    private void txtUsuarioHiddenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioHiddenKeyPressed

    }//GEN-LAST:event_txtUsuarioHiddenKeyPressed

    private void btnAlterarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarUsuarioActionPerformed
        String idinfo, u, senha, nick, tel, email, afilia, atrib;
        u = txtUsuarioAlterar.getText();
        senha = txtSenhaAlterar.getText();
        nick = txtNicknameAlterar.getText();
        tel = txtTelAlterar.getText();
        email = txtEmailAlterar.getText();
        afilia = txtAfiliaAlterar.getText();
        atrib = txtAtribAlterar.getText();
        idinfo = txtUsuarioHidden.getText();
        try {
            new EmpresaDao().alterarUsuario(idinfo, u, senha, nick, tel, email, afilia, atrib);
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAlterarUsuarioActionPerformed

    private void txtUsuarioBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioBuscarKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_txtUsuarioBuscarKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String u;
        u = txtUsuarioBuscar.getText();
        /* if (u.equals("")){
            listarUsuarios();
            return;
        }*/
        try {
            ResultSet usuarios = new EmpresaDao().buscarUsuarios(u);
            DefaultTableModel tblModelo = (DefaultTableModel) tblUsuarios.getModel();
            tblModelo.setRowCount(0);
            while (usuarios.next()) {
                String linha[] = {
                    usuarios.getString("usuario"),
                    usuarios.getString("senha"),
                    usuarios.getString("apelido"),
                    usuarios.getString("atribuicao"),
                    usuarios.getString("nomefantasia")
                };
                tblModelo.addRow(linha);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtUsuarioHiddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioHiddenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioHiddenActionPerformed

    private void txtSenhaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaAlterarActionPerformed

    private void txtUsuarioCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioCadastrarActionPerformed

    private void txtUsuarioAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioAlterarActionPerformed

    private void txtIDUsuarioExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDUsuarioExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDUsuarioExcluirActionPerformed

    private void txtIDUsuarioExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDUsuarioExcluirKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDUsuarioExcluirKeyPressed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String u;
        u = txtIDUsuarioExcluir.getText();
        try {
            int retorno = new EmpresaDao().excluirUsuario(u);
            if (retorno == 1) {

                JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarAlterarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlterarUsuarioActionPerformed
        String idinfoUsuario = txtUsuarioHidden.getText();
        try {
            ResultSet idInfo = new EmpresaDao().idInfo(idinfoUsuario);
            idInfo.next();
            txtUsuarioAlterar.setText(idInfo.getString("usuario"));
            txtSenhaAlterar.setText(idInfo.getString("senha"));
            txtNicknameAlterar.setText(idInfo.getString("apelido"));
            txtTelAlterar.setText(idInfo.getString("tel"));
            txtEmailAlterar.setText(idInfo.getString("email"));
            txtAfiliaAlterar.setText(idInfo.getString("nomefantasia"));
            txtAtribAlterar.setText(idInfo.getString("atribuicao"));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        }
    }//GEN-LAST:event_btnCancelarAlterarUsuarioActionPerformed

    private void btnSalvarUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarUsuario1ActionPerformed

    private void txtProdutoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdutoBuscarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoBuscarKeyPressed

    private void btnProdutoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoBuscarActionPerformed
        String id = txtProdutoBuscarHidden.getText();
        String nome = txtProdutoBuscar.getText();

        try {
            ResultSet produtoDados = new EmpresaDao().buscarProduto(nome, id);
            DefaultTableModel tblModelo = (DefaultTableModel) tblProdutosBuscar.getModel();
            tblModelo.setRowCount(0);
            while (produtoDados.next()) {
                String linha[] = {
                    produtoDados.getString("nome"),
                    produtoDados.getString("marca"),
                    produtoDados.getString("tipificacao"),
                    produtoDados.getString("quantidade"),
                    produtoDados.getString("descricao")
                };
                tblModelo.addRow(linha);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            String erro = ex.getMessage();
            if (erro.contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Produto já cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contatio com o suporte e informe o erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnProdutoBuscarActionPerformed

    private void txtProdutoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoExcluirActionPerformed

    private void txtProdutoExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdutoExcluirKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoExcluirKeyPressed

    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir1ActionPerformed
        String p, id;
        p = txtProdutoExcluir.getText();
        id = txtProdutoExcluirHidden.getText();
        try {
            int retorno = new EmpresaDao().excluirProduto(p, id);
            if (retorno == 1) {

                JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnExcluir1ActionPerformed

    private void txtEmpresaAtualizarRamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaAtualizarRamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaAtualizarRamoActionPerformed

    private void txtEmpresaAtualizarTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaAtualizarTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaAtualizarTelActionPerformed

    private void txtEmpresaAtualizarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaAtualizarNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaAtualizarNActionPerformed

    private void txtEmpresaAtualizarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaAtualizarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaAtualizarNomeActionPerformed

    private void txtEmpresaAtualizarBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaAtualizarBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaAtualizarBairroActionPerformed

    private void btnEmpresaAtualizarSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaAtualizarSalvarActionPerformed
        String cnpj, nomefantasia, cep, rua, numero, bairro, estado, email, ramo, tel;
        cnpj = txtEmpresaAtualizarCNPJ.getText();
        nomefantasia = txtEmpresaAtualizarNome.getText();
        cep = txtEmpresaAtualizarCEP.getText();
        rua = txtEmpresaAtualizarRua.getText();
        numero = txtEmpresaAtualizarN.getText();
        bairro = txtEmpresaAtualizarBairro.getText();
        estado = txtEmpresaAtualizarEstado.getText();
        email = txtEmpresaAtualizarEmail.getText();
        ramo = txtEmpresaAtualizarRamo.getText();
        tel = txtEmpresaAtualizarTel.getText();

        try {
            new EmpresaDao().alterarEmpresa(cnpj, nomefantasia, cep, rua, numero, bairro, estado, email, ramo, tel);
            JOptionPane.showMessageDialog(null, "Cadastro da empresa realizado com sucesso");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            String erro = ex.getMessage();
            if (erro.contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Empresa já cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnEmpresaAtualizarSalvarActionPerformed

    private void btnEmpresaAtualizarCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaAtualizarCancelarActionPerformed
        String idinfoEmpresa = txtEmpresaAtualizarNome.getText();
        try {
            ResultSet idInfo = new EmpresaDao().idInfoEmpresa(idinfoEmpresa);
            idInfo.next();
            txtEmpresaAtualizarCNPJ.setText(idInfo.getString("cnpj"));
            txtEmpresaAtualizarNome.setText(idInfo.getString("nomefantasia"));
            txtEmpresaAtualizarCEP.setText(idInfo.getString("cep"));
            txtEmpresaAtualizarRua.setText(idInfo.getString("rua"));
            txtEmpresaAtualizarN.setText(idInfo.getString("numero"));
            txtEmpresaAtualizarBairro.setText(idInfo.getString("bairro"));
            txtEmpresaAtualizarEstado.setText(idInfo.getString("estado"));
            txtEmpresaAtualizarEmail.setText(idInfo.getString("email"));
            txtEmpresaAtualizarRamo.setText(idInfo.getString("ramo"));
            txtEmpresaAtualizarTel.setText(idInfo.getString("tel"));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEmpresaAtualizarCancelarActionPerformed

    private void txtEmpresaAtualizarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaAtualizarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaAtualizarEstadoActionPerformed

    private void txtEmpresaAtualizarCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaAtualizarCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaAtualizarCNPJActionPerformed

    private void txtEmpresaAtualizarCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaAtualizarCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaAtualizarCEPActionPerformed

    private void btnExcluirEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirEmpresaActionPerformed
        String e;
        e = txtIDEmpresaExcluir.getText();
        try {
            int retorno = new EmpresaDao().excluirEmpresa(e);
            if (retorno == 1) {

                JOptionPane.showMessageDialog(null, "Cadastro da Empresa excluido com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Empresa não encontrado");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnExcluirEmpresaActionPerformed

    private void txtIDEmpresaExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDEmpresaExcluirKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDEmpresaExcluirKeyPressed

    private void txtIDEmpresaExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDEmpresaExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDEmpresaExcluirActionPerformed

    private void txtEmpresaCadastrarRamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaCadastrarRamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaCadastrarRamoActionPerformed

    private void txtEmpresaCadastrarTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaCadastrarTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaCadastrarTelActionPerformed

    private void txtEmpresaCadastrarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaCadastrarNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaCadastrarNActionPerformed

    private void txtEmpresaCadastrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaCadastrarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaCadastrarNomeActionPerformed

    private void txtEmpresaCadastrarBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaCadastrarBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaCadastrarBairroActionPerformed

    private void btnEmpresaCadastrarSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaCadastrarSalvarActionPerformed
        String cnpj, nomefantasia, cep, rua, numero, bairro, estado, email, ramo, tel;
        cnpj = txtEmpresaCadastrarCNPJ.getText();
        nomefantasia = txtEmpresaCadastrarNome.getText();
        cep = txtEmpresaCadastrarCEP.getText();
        rua = txtEmpresaCadastrarRua.getText();
        numero = txtEmpresaCadastrarN.getText();
        bairro = txtEmpresaCadastrarBairro.getText();
        estado = txtEmpresaCadastrarEstado.getText();
        email = txtEmpresaCadastrarEmail.getText();
        ramo = txtEmpresaCadastrarRamo.getText();
        tel = txtEmpresaCadastrarTel.getText();
        try {
            new EmpresaDao().salvarEmpresa(cnpj, nomefantasia, cep, rua, numero, bairro, estado, email, ramo, tel);
            JOptionPane.showMessageDialog(null, "Empresa cadastrado com sucesso");
            btnEmpresaCadastrarCancelar.doClick();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            String erro = ex.getMessage();
            if (erro.contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Empresa já cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contatio com o suporte e informe o erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnEmpresaCadastrarSalvarActionPerformed

    private void btnEmpresaCadastrarCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaCadastrarCancelarActionPerformed
        txtEmpresaCadastrarCNPJ.setText("");
        txtEmpresaCadastrarNome.setText("");
        txtEmpresaCadastrarCEP.setText("");
        txtEmpresaCadastrarRua.setText("");
        txtEmpresaCadastrarN.setText("");
        txtEmpresaCadastrarBairro.setText("");
        txtEmpresaCadastrarEstado.setText("");
        txtEmpresaCadastrarEmail.setText("");
        txtEmpresaCadastrarRamo.setText("");
        txtEmpresaCadastrarTel.setText("");
    }//GEN-LAST:event_btnEmpresaCadastrarCancelarActionPerformed

    private void txtEmpresaCadastrarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaCadastrarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaCadastrarEstadoActionPerformed

    private void txtEmpresaCadastrarCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaCadastrarCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaCadastrarCNPJActionPerformed

    private void txtEmpresaCadastrarCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaCadastrarCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaCadastrarCEPActionPerformed

    private void txtUsuarioAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioAlterar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioAlterar1ActionPerformed

    private void txtSenhaAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaAlterar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaAlterar1ActionPerformed

    private void btnAlterarUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarUsuario1ActionPerformed

    private void txtUsuarioHidden1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioHidden1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioHidden1KeyPressed

    private void txtUsuarioHidden1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioHidden1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioHidden1ActionPerformed

    private void btnCancelarAlterarUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlterarUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarAlterarUsuario1ActionPerformed

    private void txtAtribAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAtribAlterar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAtribAlterar1ActionPerformed

    private void txtNicknameAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknameAlterar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknameAlterar1ActionPerformed

    private void txtTelAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelAlterar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelAlterar1ActionPerformed

    private void txtEmpresaBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaBuscarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaBuscarKeyPressed

    private void btnBuscarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpresaActionPerformed
        String e;
        e = txtEmpresaBuscar.getText();
        /* if (u.equals("")){
            listarUsuarios();
            return;
        }*/
        try {
            ResultSet usuarios = new EmpresaDao().buscarEmpresa(e);
            DefaultTableModel tblModelo = (DefaultTableModel) tblEmpresa.getModel();
            tblModelo.setRowCount(0);
            while (usuarios.next()) {
                String linha[] = {
                    usuarios.getString("nomefantasia"),
                    usuarios.getString("cnpj"),
                    usuarios.getString("ramo"),
                    usuarios.getString("estado"),
                    usuarios.getString("email"),
                    usuarios.getString("tel")
                };
                tblModelo.addRow(linha);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarEmpresaActionPerformed

    private void txtSenhaCadastrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaCadastrar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaCadastrar2ActionPerformed

    private void txtTelCadastrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelCadastrar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelCadastrar2ActionPerformed

    private void txtAtribCadastrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAtribCadastrar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAtribCadastrar2ActionPerformed

    private void btnCancelarCadastroUsuario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroUsuario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarCadastroUsuario2ActionPerformed

    private void btnSalvarUsuario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarUsuario2ActionPerformed

    private void txtNicknameCadastrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknameCadastrar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknameCadastrar2ActionPerformed

    private void txtUsuarioCadastrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioCadastrar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioCadastrar2ActionPerformed

    private void txtTelAlterar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelAlterar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelAlterar3ActionPerformed

    private void txtNicknameAlterar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknameAlterar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknameAlterar3ActionPerformed

    private void txtAtribAlterar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAtribAlterar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAtribAlterar3ActionPerformed

    private void btnCancelarAlterarUsuario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlterarUsuario3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarAlterarUsuario3ActionPerformed

    private void txtUsuarioHidden3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioHidden3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioHidden3ActionPerformed

    private void txtUsuarioHidden3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioHidden3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioHidden3KeyPressed

    private void btnAlterarUsuario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarUsuario3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarUsuario3ActionPerformed

    private void txtSenhaAlterar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaAlterar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaAlterar3ActionPerformed

    private void txtUsuarioAlterar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioAlterar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioAlterar3ActionPerformed

    private void btnSalvarUsuario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuario3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarUsuario3ActionPerformed

    private void txtUsuarioCadastrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioCadastrar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioCadastrar3ActionPerformed

    private void btnSalvarUsuario5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuario5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarUsuario5ActionPerformed

    private void txtUsuarioCadastrar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioCadastrar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioCadastrar5ActionPerformed

    private void btnSalvarUsuario6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuario6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarUsuario6ActionPerformed

    private void btnSalvarUsuario7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuario7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarUsuario7ActionPerformed

    private void txtUsuarioCadastrar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioCadastrar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioCadastrar4ActionPerformed

    private void btnSalvarUsuario4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuario4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarUsuario4ActionPerformed

    private void btnSalvarUsuario8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuario8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarUsuario8ActionPerformed

    private void txtUsuarioCadastrar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioCadastrar6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioCadastrar6ActionPerformed

    private void btnSalvarUsuario9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuario9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarUsuario9ActionPerformed

    private void btnSalvarUsuario10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuario10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarUsuario10ActionPerformed

    private void txtProdutoCadastrarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoCadastrarMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoCadastrarMarcaActionPerformed

    private void txtProdutoCadastrarQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoCadastrarQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoCadastrarQtdActionPerformed

    private void btnProdutoCadastrarCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoCadastrarCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProdutoCadastrarCancelarActionPerformed

    private void txtProdutoCadastrarHiddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoCadastrarHiddenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoCadastrarHiddenActionPerformed

    private void txtProdutoCadastrarHiddenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdutoCadastrarHiddenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoCadastrarHiddenKeyPressed

    private void btnProdutoCadastrarSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoCadastrarSalvarActionPerformed
        String nome, tipo, descricao, qtd, marca, id;
        nome = txtProdutoCadastrarNome.getText();
        tipo = txtProdutoCadastrarTipo.getText();
        marca = txtProdutoCadastrarMarca.getText();
        qtd = txtProdutoCadastrarQtd.getText();
        descricao = txtProdutoCadastrarDescricao.getText();
        id = txtProdutoCadastrarHidden.getText();
        try {
            new EmpresaDao().salvarProduto(nome, descricao, qtd, marca, tipo, id);
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            String erro = ex.getMessage();
            if (erro.contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Produto já cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contatio com o suporte e informe o erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnProdutoCadastrarSalvarActionPerformed

    private void txtProdutoCadastrarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoCadastrarTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoCadastrarTipoActionPerformed

    private void txtProdutoCadastrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoCadastrarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoCadastrarNomeActionPerformed

    private void txtEmpresaHiddenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaHiddenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaHiddenKeyPressed

    private void txtEmpresaHiddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaHiddenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaHiddenActionPerformed

    private void btnEmpresaAtualizarImportarHiddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaAtualizarImportarHiddenActionPerformed
        String idinfoEmpresa = txtEmpresaAtualizarNome.getText();
        try {
            ResultSet idInfo = new EmpresaDao().idInfoEmpresa(idinfoEmpresa);
            idInfo.next();
            txtEmpresaAtualizarCNPJ.setText(idInfo.getString("cnpj"));
            txtEmpresaAtualizarNome.setText(idInfo.getString("nomefantasia"));
            txtEmpresaAtualizarCEP.setText(idInfo.getString("cep"));
            txtEmpresaAtualizarRua.setText(idInfo.getString("rua"));
            txtEmpresaAtualizarN.setText(idInfo.getString("numero"));
            txtEmpresaAtualizarBairro.setText(idInfo.getString("bairro"));
            txtEmpresaAtualizarEstado.setText(idInfo.getString("estado"));
            txtEmpresaAtualizarEmail.setText(idInfo.getString("email"));
            txtEmpresaAtualizarRamo.setText(idInfo.getString("ramo"));
            txtEmpresaAtualizarTel.setText(idInfo.getString("tel"));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEmpresaAtualizarImportarHiddenActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnDeslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeslogarActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDeslogarActionPerformed

    private void txtProdutoAlterarHiddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoAlterarHiddenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoAlterarHiddenActionPerformed

    private void txtProdutoAlterarHiddenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdutoAlterarHiddenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoAlterarHiddenKeyPressed

    private void txtProdutoAlterarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoAlterarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoAlterarNomeActionPerformed

    private void txtProdutoAlterarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoAlterarTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoAlterarTipoActionPerformed

    private void txtProdutoAlterarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoAlterarMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoAlterarMarcaActionPerformed

    private void txtProdutoAlterarQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoAlterarQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoAlterarQtdActionPerformed

    private void btnProdutoAlterarSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoAlterarSalvarActionPerformed
        String nome, tipo, descricao, qtd, marca, id;
        nome = txtProdutoAlterarNome.getText();
        tipo = txtProdutoAlterarTipo.getText();
        marca = txtProdutoAlterarMarca.getText();
        qtd = txtProdutoAlterarQtd.getText();
        descricao = txtProdutoAlterarDescricao.getText();
        id = txtProdutoAlterarHidden.getText();
        try {
            new EmpresaDao().alterarProduto(nome, descricao, qtd, marca, tipo, id);
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            String erro = ex.getMessage();
            if (erro.contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Produto já cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contatio com o suporte e informe o erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnProdutoAlterarSalvarActionPerformed

    private void btnProdutoAlterarCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoAlterarCancelarActionPerformed

        txtProdutoAlterarNome.setText("");
        txtProdutoAlterarTipo.setText("");
        txtProdutoAlterarMarca.setText("");
        txtProdutoAlterarQtd.setText("");
        txtProdutoAlterarDescricao.setText("");
    }//GEN-LAST:event_btnProdutoAlterarCancelarActionPerformed

    private void txtProdutoBuscarHiddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoBuscarHiddenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoBuscarHiddenActionPerformed

    private void txtProdutoBuscarHiddenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdutoBuscarHiddenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoBuscarHiddenKeyPressed

    private void btnProdutoAlterarBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoAlterarBuscarActionPerformed
        String id = txtProdutoAlterarHidden.getText();
        String nome = txtProdutoAlterarNome.getText();

        try {
            ResultSet produtoDados = new EmpresaDao().importarProduto(nome, id);
            produtoDados.next();
            txtProdutoAlterarNome.setText(produtoDados.getString("Nome"));
            txtProdutoAlterarTipo.setText(produtoDados.getString("Tipificacao"));
            txtProdutoAlterarMarca.setText(produtoDados.getString("Marca"));
            txtProdutoAlterarQtd.setText(produtoDados.getString("Quantidade"));
            txtProdutoAlterarDescricao.setText(produtoDados.getString("Descricao"));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com o suporte e informe o erro : " + ex.getMessage());
        } catch (SQLException ex) {
            String erro = ex.getMessage();
            if (erro.contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Produto já cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contatio com o suporte e informe o erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnProdutoAlterarBuscarActionPerformed

    private void txtProdutoExcluirHiddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoExcluirHiddenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoExcluirHiddenActionPerformed

    private void txtProdutoExcluirHiddenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdutoExcluirHiddenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoExcluirHiddenKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SubTabPanProdutoCadastrarMaquinario;
    private javax.swing.JPanel SubTabPanProdutoCadastrarMaterial;
    private javax.swing.JPanel SubTabPanProdutoCadastrarProcesso;
    private javax.swing.JPanel SubTabPanProdutoCadastrarSubProduto;
    private javax.swing.JPanel SubTabPanProdutoCadastrarTeste;
    private javax.swing.JTabbedPane TabPanProdutosCadastrarSubTabPan;
    private javax.swing.JTabbedPane TabPanProdutosCadastrarSubTabPan1;
    private javax.swing.JButton btnAlterarUsuario;
    private javax.swing.JButton btnAlterarUsuario1;
    private javax.swing.JButton btnAlterarUsuario3;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarEmpresa;
    private javax.swing.JButton btnCancelarAlterarUsuario;
    private javax.swing.JButton btnCancelarAlterarUsuario1;
    private javax.swing.JButton btnCancelarAlterarUsuario3;
    private javax.swing.JButton btnCancelarCadastroUsuario;
    private javax.swing.JButton btnCancelarCadastroUsuario2;
    private javax.swing.JButton btnDeslogar;
    private javax.swing.JButton btnEmpresa;
    private javax.swing.JButton btnEmpresaAtualizarCancelar;
    private javax.swing.JButton btnEmpresaAtualizarImportarHidden;
    private javax.swing.JButton btnEmpresaAtualizarSalvar;
    private javax.swing.JButton btnEmpresaCadastrarCancelar;
    private javax.swing.JButton btnEmpresaCadastrarSalvar;
    private javax.swing.JButton btnEstoque;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JButton btnExcluirEmpresa;
    private javax.swing.JButton btnForum;
    private javax.swing.JButton btnFuncionarios;
    private javax.swing.JButton btnMaquinario;
    private javax.swing.JButton btnProcessos;
    private javax.swing.JButton btnProdutoAlterarBuscar;
    private javax.swing.JButton btnProdutoAlterarCancelar;
    private javax.swing.JButton btnProdutoAlterarSalvar;
    private javax.swing.JButton btnProdutoBuscar;
    private javax.swing.JButton btnProdutoCadastrarCancelar;
    private javax.swing.JButton btnProdutoCadastrarSalvar;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvarUsuario;
    private javax.swing.JButton btnSalvarUsuario1;
    private javax.swing.JButton btnSalvarUsuario10;
    private javax.swing.JButton btnSalvarUsuario2;
    private javax.swing.JButton btnSalvarUsuario3;
    private javax.swing.JButton btnSalvarUsuario4;
    private javax.swing.JButton btnSalvarUsuario5;
    private javax.swing.JButton btnSalvarUsuario6;
    private javax.swing.JButton btnSalvarUsuario7;
    private javax.swing.JButton btnSalvarUsuario8;
    private javax.swing.JButton btnSalvarUsuario9;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JLabel lblEmpresaHidden;
    private javax.swing.JLabel lblProdutoAlterarHidden;
    private javax.swing.JLabel lblProdutoBuscarHidden;
    private javax.swing.JLabel lblProdutoCadastrarHidden;
    private javax.swing.JLabel lblProdutoExcluirHidden;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuarioHidden;
    private javax.swing.JLabel lblUsuarioHidden1;
    private javax.swing.JLabel lblUsuarioHidden2;
    private javax.swing.JLabel lblUsuarioHidden4;
    private javax.swing.JLabel lblUsuarioHidden5;
    private javax.swing.JLabel lblUsuarioHidden6;
    private javax.swing.JLabel menu;
    private javax.swing.JPanel panelEmpresa;
    private javax.swing.JPanel panelEstoque;
    private javax.swing.JPanel panelForum;
    private javax.swing.JPanel panelFuncionarios;
    private javax.swing.JPanel panelMaquinario;
    private javax.swing.JPanel panelProcessos;
    private javax.swing.JPanel panelProdutos;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JTabbedPane tabPanEmpresa;
    private javax.swing.JPanel tabPanEmpresaApresentacao;
    private javax.swing.JPanel tabPanEmpresaAtualizar;
    private javax.swing.JPanel tabPanEmpresaBuscar;
    private javax.swing.JPanel tabPanEmpresaCadastrar;
    private javax.swing.JPanel tabPanEmpresaExcluir;
    private javax.swing.JPanel tabPanEmpresaInfo;
    private javax.swing.JPanel tabPanEmpresaMO;
    private javax.swing.JPanel tabPanEmpresaMVV;
    private javax.swing.JPanel tabPanProdutoGuia;
    private javax.swing.JTabbedPane tabPanProdutos;
    private javax.swing.JPanel tabPanProdutosAlterar;
    private javax.swing.JPanel tabPanProdutosAlterar1;
    private javax.swing.JPanel tabPanProdutosBuscar;
    private javax.swing.JPanel tabPanProdutosCadastrar;
    private javax.swing.JPanel tabPanProdutosCadastrar1;
    private javax.swing.JPanel tabPanProdutosCadastrarTeste;
    private javax.swing.JPanel tabPanProdutosExcluir;
    private javax.swing.JTabbedPane tabPanUsuario;
    private javax.swing.JPanel tabPanUsuarioAlterar;
    private javax.swing.JPanel tabPanUsuarioBuscar;
    private javax.swing.JPanel tabPanUsuarioCadastrar;
    private javax.swing.JPanel tabPanUsuarioExcluir;
    private javax.swing.JPanel tabPanUsuarioInfo;
    private javax.swing.JTable tblEmpresa;
    private javax.swing.JTable tblMaquinarioCadastroProduto;
    private javax.swing.JTable tblMaterialCadastroProduto;
    private javax.swing.JTable tblProcessoCadastroProduto;
    private javax.swing.JTable tblProdutosBuscar;
    private javax.swing.JTable tblSubProdutoCadastroProduto;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtAfiliaAlterar;
    private javax.swing.JTextField txtAfiliaAlterar1;
    private javax.swing.JTextField txtAfiliaAlterar3;
    private javax.swing.JTextField txtAfiliaCadastrar;
    private javax.swing.JTextField txtAfiliaCadastrar2;
    private javax.swing.JTextField txtAtribAlterar;
    private javax.swing.JTextField txtAtribAlterar1;
    private javax.swing.JTextField txtAtribAlterar3;
    private javax.swing.JTextField txtAtribCadastrar;
    private javax.swing.JTextField txtAtribCadastrar2;
    private javax.swing.JTextField txtEmailAlterar;
    private javax.swing.JTextField txtEmailAlterar1;
    private javax.swing.JTextField txtEmailAlterar3;
    private javax.swing.JTextField txtEmailCadastrar;
    private javax.swing.JTextField txtEmailCadastrar2;
    private javax.swing.JTextField txtEmpresaAtualizarBairro;
    private javax.swing.JTextField txtEmpresaAtualizarCEP;
    private javax.swing.JTextField txtEmpresaAtualizarCNPJ;
    private javax.swing.JTextField txtEmpresaAtualizarEmail;
    private javax.swing.JTextField txtEmpresaAtualizarEstado;
    private javax.swing.JTextField txtEmpresaAtualizarN;
    private javax.swing.JTextField txtEmpresaAtualizarNome;
    private javax.swing.JTextField txtEmpresaAtualizarRamo;
    private javax.swing.JTextField txtEmpresaAtualizarRua;
    private javax.swing.JTextField txtEmpresaAtualizarTel;
    private javax.swing.JTextField txtEmpresaBuscar;
    private javax.swing.JTextField txtEmpresaCadastrarBairro;
    private javax.swing.JTextField txtEmpresaCadastrarCEP;
    private javax.swing.JTextField txtEmpresaCadastrarCNPJ;
    private javax.swing.JTextField txtEmpresaCadastrarEmail;
    private javax.swing.JTextField txtEmpresaCadastrarEstado;
    private javax.swing.JTextField txtEmpresaCadastrarN;
    private javax.swing.JTextField txtEmpresaCadastrarNome;
    private javax.swing.JTextField txtEmpresaCadastrarRamo;
    private javax.swing.JTextField txtEmpresaCadastrarRua;
    private javax.swing.JTextField txtEmpresaCadastrarTel;
    private javax.swing.JTextField txtEmpresaHidden;
    private javax.swing.JTextField txtIDEmpresaExcluir;
    private javax.swing.JTextField txtIDUsuarioExcluir;
    private javax.swing.JTextField txtNicknameAlterar;
    private javax.swing.JTextField txtNicknameAlterar1;
    private javax.swing.JTextField txtNicknameAlterar3;
    private javax.swing.JTextField txtNicknameCadastrar;
    private javax.swing.JTextField txtNicknameCadastrar1;
    private javax.swing.JTextField txtNicknameCadastrar2;
    private javax.swing.JTextField txtProdutoAlterarDescricao;
    private javax.swing.JTextField txtProdutoAlterarHidden;
    private javax.swing.JTextField txtProdutoAlterarMarca;
    private javax.swing.JTextField txtProdutoAlterarNome;
    private javax.swing.JTextField txtProdutoAlterarQtd;
    private javax.swing.JTextField txtProdutoAlterarTipo;
    private javax.swing.JTextField txtProdutoBuscar;
    private javax.swing.JTextField txtProdutoBuscarHidden;
    private javax.swing.JTextField txtProdutoCadastrarDescricao;
    private javax.swing.JTextField txtProdutoCadastrarHidden;
    private javax.swing.JTextField txtProdutoCadastrarMarca;
    private javax.swing.JTextField txtProdutoCadastrarNome;
    private javax.swing.JTextField txtProdutoCadastrarQtd;
    private javax.swing.JTextField txtProdutoCadastrarTipo;
    private javax.swing.JTextField txtProdutoExcluir;
    private javax.swing.JTextField txtProdutoExcluirHidden;
    private javax.swing.JTextField txtSenhaAlterar;
    private javax.swing.JTextField txtSenhaAlterar1;
    private javax.swing.JTextField txtSenhaAlterar3;
    private javax.swing.JTextField txtSenhaCadastrar;
    private javax.swing.JTextField txtSenhaCadastrar1;
    private javax.swing.JTextField txtSenhaCadastrar2;
    private javax.swing.JTextField txtSenhaCadastrar3;
    private javax.swing.JTextField txtTelAlterar;
    private javax.swing.JTextField txtTelAlterar1;
    private javax.swing.JTextField txtTelAlterar3;
    private javax.swing.JTextField txtTelCadastrar;
    private javax.swing.JTextField txtTelCadastrar2;
    private javax.swing.JTextField txtUsuarioAlterar;
    private javax.swing.JTextField txtUsuarioAlterar1;
    private javax.swing.JTextField txtUsuarioAlterar3;
    private javax.swing.JTextField txtUsuarioBuscar;
    private javax.swing.JTextField txtUsuarioCadastrar;
    private javax.swing.JTextField txtUsuarioCadastrar1;
    private javax.swing.JTextField txtUsuarioCadastrar2;
    private javax.swing.JTextField txtUsuarioCadastrar3;
    private javax.swing.JTextField txtUsuarioCadastrar4;
    private javax.swing.JTextField txtUsuarioCadastrar5;
    private javax.swing.JTextField txtUsuarioCadastrar6;
    private javax.swing.JTextField txtUsuarioHidden;
    private javax.swing.JTextField txtUsuarioHidden1;
    private javax.swing.JTextField txtUsuarioHidden3;
    // End of variables declaration//GEN-END:variables
}
