/*
 * Copyright (C) 2015 hydrocat
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package gyouzafoot.Paineis;

import gyouzafoot.Objetos.Jogador;

/**
 *
 * @author hydrocat
 */
public class PainelJogador extends javax.swing.JPanel {
    private Jogador j= new Jogador(-1, "JogadorSemNome", -1);
    /**
     * Creates new form Jogador
     */
    public PainelJogador(Jogador j) {        
        initComponents();
        this.j = j;
        this.jCheckBox1.setText(j.getNome());
    }
    
    public boolean isSelected()
    {
        return this.jCheckBox1.isSelected();
    }
    
    public Jogador getJogador()
    {
        return this.j;
    }
    
    public int getGolValido()
    {
        return Integer.parseInt((String)this.jComboBox1.getSelectedItem());
    }
    
    public int getGolContra()
    {
        return Integer.parseInt((String)this.jComboBox2.getSelectedItem());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

        jCheckBox1.setText("jCheckBox1");
        add(jCheckBox1);

        jComboBox1.setForeground(new java.awt.Color(0, 0, 204));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        add(jComboBox1);

        jComboBox2.setForeground(new java.awt.Color(255, 0, 0));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        add(jComboBox2);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    // End of variables declaration//GEN-END:variables
}