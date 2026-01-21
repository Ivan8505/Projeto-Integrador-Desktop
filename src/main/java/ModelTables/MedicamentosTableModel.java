package ModelTables;

import Objs.ObjsMedicamentos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivan2
 */
public class MedicamentosTableModel extends AbstractTableModel {

    private List<ObjsMedicamentos> Meds = new ArrayList<>();
    private String[] colunas = {"Código do medicamento", "Descrição", "Data da ultima compra", "valor custo", "valor venda", "Nome", "Quantidade", "Tipo"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return Meds.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0 -> {return Meds.get(linha).getCodMed();}
            case 1 -> {return Meds.get(linha).getNomeMed();}
            case 2 -> {return Meds.get(linha).getTipo();}
            case 3 -> {return Meds.get(linha).getDescrição();}
            case 4 -> {return Meds.get(linha).getValorVenda();}
            case 5 -> {return Meds.get(linha).getValorCusto();}
            case 6 -> {return Meds.get(linha).getQuantidade();}
            case 7 -> {return Meds.get(linha).getDataUltimaCompra();}
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0 -> Meds.get(linha).setCodMed((String) valor);
            case 1 -> Meds.get(linha).setNomeMed((String) valor);
            case 2 -> Meds.get(linha).setTipo(((String) valor));
            case 3 -> Meds.get(linha).setDescrição((String) valor);
            case 4 -> Meds.get(linha).setValorVenda(((String) valor));
            case 5 -> Meds.get(linha).setValorCusto(((String) valor));
            case 6 -> Meds.get(linha).setQuantidade(((String) valor));
            case 7 -> Meds.get(linha).setDataUltimaCompra(((String) valor));

        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void addLinha(ObjsMedicamentos o) {
        this.Meds.clear();
        this.Meds.add(o);
        this.fireTableDataChanged();
    }
    
    public void addLinhaConsultar(ObjsMedicamentos o){
                        this.Meds.clear();
this.Meds.add(o);
this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.Meds.remove(linha);
        this.fireTableDataChanged();    

    }
    
    public void removeLin(){
                this.Meds.clear();
                        this.fireTableDataChanged();    


    }

}
