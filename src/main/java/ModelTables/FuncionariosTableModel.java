/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelTables;

import Objs.ObjsCadastros;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivan.grodrigues
 */
public class FuncionariosTableModel extends AbstractTableModel{
    private List<ObjsCadastros> cad = new ArrayList<>();
    private String[] colunas = {"ID", "Nome", "Login", "E-mail", "Função", "Data de nascimento", "Telefone Celular", "Telefone residencial", "Telefone adicional"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return cad.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0 -> {return cad.get(linha).getId();}
            case 1 -> {return cad.get(linha).getNome();}
            case 2 -> {return cad.get(linha).getUser();}
            case 3 -> {return cad.get(linha).getEmail();}
            case 4 -> {return cad.get(linha).getTipoFunc();}
            case 5 -> {return cad.get(linha).getDataNasc();}
            case 6 -> {return cad.get(linha).getFoneCel();}
            case 7 -> {return cad.get(linha).getFoneRes();}
            case 8 -> {return cad.get(linha).getFoneAlt();}
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0 -> cad.get(linha).setId((String) valor);
            case 1 -> cad.get(linha).setNome((String) valor);
            case 2 -> cad.get(linha).setUser(((String) valor));
            case 3 -> cad.get(linha).setEmail(((String) valor));
            case 4 -> cad.get(linha).setTipoFunc(((String) valor));
            case 5 -> cad.get(linha).setDataNasc(((String) valor));
            case 6 -> cad.get(linha).setFoneCel(((String) valor));
            case 7 -> cad.get(linha).setFoneRes(((String) valor));
            case 8 -> cad.get(linha).setFoneAlt(((String) valor));
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void addLinha(ObjsCadastros c) {
        this.cad.clear();
        this.cad.add(c);
        this.fireTableDataChanged();
    }

    public void removeLinha() {
        this.cad.clear();
        this.fireTableDataChanged();
    }

}
