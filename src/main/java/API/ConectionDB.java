/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package API;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ivan2
 */
public class ConectionDB {

    public ConectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    String sql;

    PasswordAuthentication pass = new PasswordAuthentication();
    public String conecte = "jdbc:mysql://localhost/bd_mshelf?user=root&password=123456";

    public String verificarLogin(String nome, String passe) {
        boolean a;
        sql = ("SELECT senha, Tipo_Func FROM funcionarios where Login = '" + nome + "'");
        try {
            Connection c;
            c = java.sql.DriverManager.getConnection(conecte);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                a = pass.authenticate(passe.toCharArray(), rs.getString(1));
                if (a) {
                    System.out.println("sucesso");
                    return rs.getString("Tipo_Func");
                } else {
                    System.out.println("erro");
                    return "";
                }
            }
            // FIM SELECT
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public boolean newCompra( String Cnpj_Lab, String FormaPag_L, String DataEntega_L, String DataCompra_L, String TotalNota_L,
    String Cod_Med, int Qntd_Med, Double Valor_Unit, Double Valor_Total) {
        String NumNotaFiscal_L = null;
        try {
            Connection c;
            c = java.sql.DriverManager.getConnection(conecte);
            Statement s = c.createStatement();
            s.execute("INSERT INTO Pedidos_Compra (Cnpj_Lab , FormaPag_L, DataEntega_L, DataCompra_L, TotalNota_L)"
                    + "VALUES ('" + Cnpj_Lab + "','" + FormaPag_L + "','" + DataEntega_L + "','" + DataCompra_L + "','" + TotalNota_L + "')");
            ResultSet rs = s.executeQuery("SELECT NumNotaFiscal_L FROM Pedidos_Compra where Cnpj_Lab='"+Cnpj_Lab+"'");
            while(rs.next()){
                         NumNotaFiscal_L = (rs.getString("NumNotaFiscal_L"));
            }
            s.execute("INSERT INTO Itens_Compra (NumNotaFiscal_L, Cod_Med , Qntd_Med, Valor_Unit, Valor_Total)"
                    + "VALUES ('" + NumNotaFiscal_L + "','" + Cod_Med + "','" + Qntd_Med + "','" + Valor_Unit + "','" + Valor_Total + "')");
            // FIM SELECT
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
    }
    }
    

    public boolean newUsuario(String nome, String senha, String dataNasc, String email, String tipoFunc, String login) {
        try {
            Connection c;
            c = java.sql.DriverManager.getConnection(conecte);
            Statement s = c.createStatement();
            senha = pass.hash(senha.toCharArray());
            s.execute("INSERT INTO funcionarios (Email, Senha, nome_Func, Data_Nasc, Tipo_Func, Login)"
                    + "VALUES ('" + nome + "','" + senha + "','" + email + "','" + dataNasc + "','" + tipoFunc + "','" + login + "')");
            return true;
            // FIM SELECT
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void newDrogaria(String nome, String CNPJ, String CEP, String cidade, String bairro, String rua, String complemnto, String numero, String estado) {
        sql = ("INSERT INTO drogarias (Nome_Droga, Cnpj_Droga, Cidade_Droga, CEP_Droga, Bairro_Droga, Rua_Droga, Comple_Droga, Numero_Droga, Estado_Droga)"
                + "VALUES ('" + nome + "','" + CNPJ + "','" + cidade + "','" + CEP + "','" + bairro + "','" + rua + "','" + complemnto + "','" + numero + "','" + estado + "')");
        try {
            Connection c;
            c = java.sql.DriverManager.getConnection(conecte);
            Statement s = c.createStatement();
            s.execute(sql);
            // FIM SELECT
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean novoLaboratorio(String nome, String CNPJ, String CEP, String cidade, String bairro, String rua, String complemento, String numero, String estado, String insc) {
        try {
            Connection c;
            c = java.sql.DriverManager.getConnection(conecte);
            Statement s = c.createStatement();
            s.execute("INSERT INTO laboratorios (Nome_Lab, Cnpj_Lab, Cidade_Lab, CEP_Lab, Bairro_Lab, Rua_Lab, Comple_Lab, Num_Lab, Estado_Lab, Insc_Estadual) "
                    + "VALUES ('" + nome + "','" + CNPJ + "','" + cidade + "','" + CEP + "','" + bairro + "','" + rua + "','" + complemento + "','" + numero + "','" + estado + "','" + insc + "')");
            // FIM SELECT
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean novoMedicamento(String descricao, String dataUltimaCompra, String valorVenda, String valorCusto, String nomeMed, String tipo, String quantidadeMed) {
        System.out.println("\n" + valorCusto);
        try {
            Connection c;
            c = java.sql.DriverManager.getConnection(conecte);
            Statement s = c.createStatement();
            s.execute("INSERT INTO medicamentos (Nome_Med, Tipo, Descricao, Valor_Venda, Valor_Custo, Qntd_Med, Data_UltCompra) "
                    + "VALUES ('" + nomeMed + "','" + tipo + "','" + descricao + "','" + valorVenda + "','" + valorCusto + "','" + quantidadeMed + "','" + dataUltimaCompra + "')");
            return true;
            // FIM SELECT
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deletarMed(String id) {
        try {
            Connection c;
            c = java.sql.DriverManager.getConnection(conecte);

            Statement s = c.createStatement();
            s.execute("DELETE FROM medicamentos WHERE Cod_Med=" + id);
            // FIM SELECT
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deletarCompras(String id, String id2) {
        try {
            Connection c;
            c = java.sql.DriverManager.getConnection(conecte);

            Statement s = c.createStatement();
            s.execute("DELETE FROM Pedidos_Compra WHERE NumNotaFiscal_L=" + id);
            s.execute("DELETE FROM Itens_Compra WHERE NumNotaFiscal_L=" + id +" && Cod_Med="+ id2);
            // FIM SELECT
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deletarVendas(String id, String id2) {
        try {
            Connection c;
            c = java.sql.DriverManager.getConnection(conecte);

            Statement s = c.createStatement();
            s.execute("DELETE FROM Pedidos_Venda WHERE NumNotaFiscal_L=" + id);
            s.execute("DELETE FROM Itens_Venda WHERE NumNotaFiscal_L=" + id +" && Cod_Med="+ id2);
            // FIM SELECT
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deletarUser(String id) {
        try {
            Connection c;
            c = java.sql.DriverManager.getConnection(conecte);
            Statement s = c.createStatement();
            s.execute("Delete FROM funcionarios WHERE login = '" + id + "'");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    public boolean update(String Nome, String tipo, String desc, String valV, String valCusto, String quantidade, String date, String id){
                try {
            Connection c;
            c = java.sql.DriverManager.getConnection(conecte);
            Statement s = c.createStatement(); 
           boolean a = s.execute("UPDATE medicamentos SET Nome_Med='"+Nome+"', Tipo='"+tipo+"', Descricao ='"+desc+"', Valor_Venda = '"+valV+"', Valor_Custo='"+valCusto+"', Qntd_Med='"+quantidade+"', Data_UltCompra ='"+date+"' WHERE Cod_Med="+id);
            if (a) {
                System.out.println("true");
                            return true
;
            }else{
                System.out.println("false");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
