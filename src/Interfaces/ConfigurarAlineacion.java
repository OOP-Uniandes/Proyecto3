package src.Interfaces;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import src.Modelo.Jugadores.Jugador;
import src.Vista.App;

/**
 *
 * @author K K K
 */
public class ConfigurarAlineacion extends javax.swing.JFrame {

    /**
     * Creates new form Alineacion
     */
    public ConfigurarAlineacion() {

        initComponents();

        ArrayList<Jugador> arqueros = App.participanteActual.getEquipo().getArqueros();
        ArrayList<Jugador> defensas = App.participanteActual.getEquipo().getDefensas();
        ArrayList<Jugador> mediocampistas = App.participanteActual.getEquipo().getMediocampistas();
        ArrayList<Jugador> delanteros = App.participanteActual.getEquipo().getDelanteros();

        String[] stringsArquerosCombo1 = new String[arqueros.size()];

        for (int i = 0; i < arqueros.size(); i++) {
            stringsArquerosCombo1[i] = arqueros.get(i).getNombre();
        }

        String[] stringsDefensaCombo1 = new String[defensas.size()];
        String[] stringsDefensaCombo2 = new String[defensas.size()];
        String[] stringsDefensaCombo3 = new String[defensas.size()];
        String[] stringsDefensaCombo4 = new String[defensas.size()];

        for (int i = 0; i < defensas.size(); i++) {
            stringsDefensaCombo1[i] = defensas.get(i).getNombre();
            stringsDefensaCombo2[i] = defensas.get(i).getNombre();
            stringsDefensaCombo3[i] = defensas.get(i).getNombre();
            stringsDefensaCombo4[i] = defensas.get(i).getNombre();
        }

        String[] stringsMediocamoistasCombo1 = new String[mediocampistas.size()];
        String[] stringsMediocamoistasCombo3 = new String[mediocampistas.size()];
        String[] stringsMediocamoistasCombo2 = new String[mediocampistas.size()];
        String[] stringsMediocamoistasCombo4 = new String[mediocampistas.size()];

        for (int i = 0; i < mediocampistas.size(); i++) {
            stringsMediocamoistasCombo1[i] = mediocampistas.get(i).getNombre();
            stringsMediocamoistasCombo2[i] = mediocampistas.get(i).getNombre();
            stringsMediocamoistasCombo3[i] = mediocampistas.get(i).getNombre();
            stringsMediocamoistasCombo4[i] = mediocampistas.get(i).getNombre();
        }

        String[] stringsDelanterosCombo1 = new String[delanteros.size()];
        String[] stringsDelanterosCombo2 = new String[delanteros.size()];

        for (int i = 0; i < delanteros.size(); i++) {
            stringsDelanterosCombo1[i] = delanteros.get(i).getNombre();
            stringsDelanterosCombo2[i] = delanteros.get(i).getNombre();
        }

        defensa1Combo.setModel(
                new javax.swing.DefaultComboBoxModel<>(stringsDefensaCombo1));
        defensa2Combo.setModel(
                new javax.swing.DefaultComboBoxModel<>(stringsDefensaCombo2));
        defensa3Combo.setModel(
                new javax.swing.DefaultComboBoxModel<>(stringsDefensaCombo3));
        defensa4Combo.setModel(
                new javax.swing.DefaultComboBoxModel<>(stringsDefensaCombo4));

        medio1Combo.setModel(
                new javax.swing.DefaultComboBoxModel<>(stringsMediocamoistasCombo1));
        medio2Combo.setModel(
                new javax.swing.DefaultComboBoxModel<>(stringsMediocamoistasCombo2));
        medio3Combo.setModel(
                new javax.swing.DefaultComboBoxModel<>(stringsMediocamoistasCombo3));
        medio4Combo.setModel(
                new javax.swing.DefaultComboBoxModel<>(stringsMediocamoistasCombo4));

        delantero1Combo.setModel(
                new javax.swing.DefaultComboBoxModel<>(stringsDelanterosCombo1));
        delantero2Combo.setModel(
                new javax.swing.DefaultComboBoxModel<>(stringsDelanterosCombo2));
        
        arqueroCombo.setModel(
                new javax.swing.DefaultComboBoxModel<>(stringsArquerosCombo1));
        
        
        this.setVisible(true);

        
    }

    private void guardarYsalirBtnActionPerformed(java.awt.event.ActionEvent evt) {

            // TODO: guardar Alineacion y verificar que no hayan jugadores repetidos :)

            ArrayList<Jugador> alineacion = new ArrayList<Jugador>();

            Jugador arquero = App.getJugadorPorNombre(arqueroCombo.getSelectedItem().toString());
            alineacion.add(arquero);

            Jugador defensa1 = App.getJugadorPorNombre(defensa1Combo.getSelectedItem().toString());
            alineacion.add(defensa1);

            Jugador defensa2 = App.getJugadorPorNombre(defensa2Combo.getSelectedItem().toString());
            alineacion.add(defensa2);

            Jugador defensa3 = App.getJugadorPorNombre(defensa3Combo.getSelectedItem().toString());
            alineacion.add(defensa3);

            Jugador defensa4 = App.getJugadorPorNombre(defensa4Combo.getSelectedItem().toString());
            alineacion.add(defensa4);

            Jugador mediocampo1 = App.getJugadorPorNombre(medio1Combo.getSelectedItem().toString());
            alineacion.add(mediocampo1);

            Jugador mediocampo2 = App.getJugadorPorNombre(medio2Combo.getSelectedItem().toString());
            alineacion.add(mediocampo2);

            Jugador mediocampo3 = App.getJugadorPorNombre(medio3Combo.getSelectedItem().toString());
            alineacion.add(mediocampo3);

            Jugador mediocampo4 = App.getJugadorPorNombre(medio4Combo.getSelectedItem().toString());
            alineacion.add(mediocampo4);

            Jugador delantero1 = App.getJugadorPorNombre(delantero1Combo.getSelectedItem().toString());
            alineacion.add(delantero1);

            Jugador delantero2 = App.getJugadorPorNombre(delantero2Combo.getSelectedItem().toString());
            alineacion.add(delantero2);

            boolean duplicatesPresent = false;
            Set<String> names = new HashSet<>();

            for (int i = 0; i < alineacion.size(); i++) {

                    if (names.add(alineacion.get(i).getNombre()) == false) {

                            duplicatesPresent = true;
                    }

            }

            if (duplicatesPresent) {
                    JOptionPane.showMessageDialog(null, "Haz seleccionado el mismo jugador mas de una vez");
            } else {
                    App.participanteActual.getEquipo().setAlineacion(alineacion);
                    JOptionPane.showMessageDialog(null, "Alineacion actualizada");
                    this.dispose();
                    new UserFrame();
            }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            defensa1Combo = new javax.swing.JComboBox<>();
            jPanel2 = new javax.swing.JPanel();
            jLabel2 = new javax.swing.JLabel();
            defensa2Combo = new javax.swing.JComboBox<>();
            jPanel3 = new javax.swing.JPanel();
            jLabel3 = new javax.swing.JLabel();
            defensa3Combo = new javax.swing.JComboBox<>();
            jPanel4 = new javax.swing.JPanel();
            jLabel4 = new javax.swing.JLabel();
            defensa4Combo = new javax.swing.JComboBox<>();
            jPanel5 = new javax.swing.JPanel();
            jLabel5 = new javax.swing.JLabel();
            medio1Combo = new javax.swing.JComboBox<>();
            jPanel6 = new javax.swing.JPanel();
            jLabel6 = new javax.swing.JLabel();
            medio2Combo = new javax.swing.JComboBox<>();
            jPanel7 = new javax.swing.JPanel();
            jLabel7 = new javax.swing.JLabel();
            medio3Combo = new javax.swing.JComboBox<>();
            jPanel8 = new javax.swing.JPanel();
            jLabel8 = new javax.swing.JLabel();
            medio4Combo = new javax.swing.JComboBox<>();
            jPanel9 = new javax.swing.JPanel();
            jLabel9 = new javax.swing.JLabel();
            delantero1Combo = new javax.swing.JComboBox<>();
            jPanel10 = new javax.swing.JPanel();
            jLabel10 = new javax.swing.JLabel();
            delantero2Combo = new javax.swing.JComboBox<>();
            jPanel11 = new javax.swing.JPanel();
            jLabel11 = new javax.swing.JLabel();
            arqueroCombo = new javax.swing.JComboBox<>();
            guardarYsalirBtn = new javax.swing.JButton();
            jLabel12 = new javax.swing.JLabel();
            jLabel13 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setPreferredSize(new java.awt.Dimension(1334, 806));
            setSize(new java.awt.Dimension(1334, 806));
            getContentPane().setLayout(null);

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));

            jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            jLabel1.setText("Defensa1");

            defensa1Combo.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
            defensa1Combo.setModel(new javax.swing.DefaultComboBoxModel<>(
                            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            defensa1Combo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            defensa1ComboActionPerformed(evt);
                    }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(jPanel1Layout.createParallelGroup(
                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel1)
                                                                            .addComponent(defensa1Combo,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));
            jPanel1Layout.setVerticalGroup(
                            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel1)
                                                            .addPreferredGap(
                                                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(defensa1Combo,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));

            getContentPane().add(jPanel1);
            jPanel1.setBounds(6, 6, 161, 122);

            jPanel2.setBackground(new java.awt.Color(255, 255, 255));

            jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            jLabel2.setText("Defensa2");

            defensa2Combo.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
            defensa2Combo.setModel(new javax.swing.DefaultComboBoxModel<>(
                            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            defensa2Combo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            defensa2ComboActionPerformed(evt);
                    }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(jPanel2Layout.createParallelGroup(
                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel2)
                                                                            .addComponent(defensa2Combo,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(40, Short.MAX_VALUE)));
            jPanel2Layout.setVerticalGroup(
                            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel2)
                                                            .addPreferredGap(
                                                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(defensa2Combo,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));

            getContentPane().add(jPanel2);
            jPanel2.setBounds(173, 6, 161, 122);

            jPanel3.setBackground(new java.awt.Color(255, 255, 255));

            jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            jLabel3.setText("Defensa3");

            defensa3Combo.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
            defensa3Combo.setModel(new javax.swing.DefaultComboBoxModel<>(
                            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            defensa3Combo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            defensa3ComboActionPerformed(evt);
                    }
            });

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(jPanel3Layout.createParallelGroup(
                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel3)
                                                                            .addComponent(defensa3Combo,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(40, Short.MAX_VALUE)));
            jPanel3Layout.setVerticalGroup(
                            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel3)
                                                            .addPreferredGap(
                                                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(defensa3Combo,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));

            getContentPane().add(jPanel3);
            jPanel3.setBounds(346, 6, 161, 122);

            jPanel4.setBackground(new java.awt.Color(255, 255, 255));

            jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            jLabel4.setText("Defensa4");

            defensa4Combo.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
            defensa4Combo.setModel(new javax.swing.DefaultComboBoxModel<>(
                            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            defensa4Combo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            defensa4ComboActionPerformed(evt);
                    }
            });

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(jPanel4Layout.createParallelGroup(
                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel4)
                                                                            .addComponent(defensa4Combo,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(40, Short.MAX_VALUE)));
            jPanel4Layout.setVerticalGroup(
                            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel4)
                                                            .addPreferredGap(
                                                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(defensa4Combo,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));

            getContentPane().add(jPanel4);
            jPanel4.setBounds(513, 6, 161, 122);

            jPanel5.setBackground(new java.awt.Color(255, 255, 255));

            jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            jLabel5.setText("Medio1");

            medio1Combo.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
            medio1Combo.setModel(new javax.swing.DefaultComboBoxModel<>(
                            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            medio1Combo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            medio1ComboActionPerformed(evt);
                    }
            });

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(jPanel5Layout.createParallelGroup(
                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel5)
                                                                            .addComponent(medio1Combo,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(40, Short.MAX_VALUE)));
            jPanel5Layout.setVerticalGroup(
                            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel5)
                                                            .addPreferredGap(
                                                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(medio1Combo,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(43, Short.MAX_VALUE)));

            getContentPane().add(jPanel5);
            jPanel5.setBounds(680, 6, 161, 122);

            jPanel6.setBackground(new java.awt.Color(255, 255, 255));

            jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            jLabel6.setText("Medio2");

            medio2Combo.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
            medio2Combo.setModel(new javax.swing.DefaultComboBoxModel<>(
                            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            medio2Combo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            medio2ComboActionPerformed(evt);
                    }
            });

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(jPanel6Layout.createParallelGroup(
                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel6)
                                                                            .addComponent(medio2Combo,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(40, Short.MAX_VALUE)));
            jPanel6Layout.setVerticalGroup(
                            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel6)
                                                            .addPreferredGap(
                                                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(medio2Combo,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));

            getContentPane().add(jPanel6);
            jPanel6.setBounds(6, 152, 161, 116);

            jPanel7.setBackground(new java.awt.Color(255, 255, 255));

            jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            jLabel7.setText("Medio3");

            medio3Combo.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
            medio3Combo.setModel(new javax.swing.DefaultComboBoxModel<>(
                            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            medio3Combo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            medio3ComboActionPerformed(evt);
                    }
            });

            javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
            jPanel7.setLayout(jPanel7Layout);
            jPanel7Layout.setHorizontalGroup(
                            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(jPanel7Layout.createParallelGroup(
                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel7)
                                                                            .addComponent(medio3Combo,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(40, Short.MAX_VALUE)));
            jPanel7Layout.setVerticalGroup(
                            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel7)
                                                            .addPreferredGap(
                                                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(medio3Combo,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(37, Short.MAX_VALUE)));

            getContentPane().add(jPanel7);
            jPanel7.setBounds(173, 152, 161, 116);

            jPanel8.setBackground(new java.awt.Color(255, 255, 255));

            jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            jLabel8.setText("Medio4");

            medio4Combo.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
            medio4Combo.setModel(new javax.swing.DefaultComboBoxModel<>(
                            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            medio4Combo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            medio4ComboActionPerformed(evt);
                    }
            });

            javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
            jPanel8.setLayout(jPanel8Layout);
            jPanel8Layout.setHorizontalGroup(
                            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(jPanel8Layout.createParallelGroup(
                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel8)
                                                                            .addComponent(medio4Combo,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));
            jPanel8Layout.setVerticalGroup(
                            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel8)
                                                            .addPreferredGap(
                                                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(medio4Combo,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));

            getContentPane().add(jPanel8);
            jPanel8.setBounds(346, 152, 161, 116);

            jPanel9.setBackground(new java.awt.Color(255, 255, 255));

            jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            jLabel9.setText("Delantero1");

            delantero1Combo.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
            delantero1Combo.setModel(new javax.swing.DefaultComboBoxModel<>(
                            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            delantero1Combo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            delantero1ComboActionPerformed(evt);
                    }
            });

            javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
            jPanel9.setLayout(jPanel9Layout);
            jPanel9Layout.setHorizontalGroup(
                            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(jPanel9Layout.createParallelGroup(
                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel9)
                                                                            .addComponent(delantero1Combo,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));
            jPanel9Layout.setVerticalGroup(
                            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel9)
                                                            .addPreferredGap(
                                                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(delantero1Combo,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));

            getContentPane().add(jPanel9);
            jPanel9.setBounds(513, 152, 161, 116);

            jPanel10.setBackground(new java.awt.Color(255, 255, 255));

            jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            jLabel10.setText("Delantero2");

            delantero2Combo.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
            delantero2Combo.setModel(new javax.swing.DefaultComboBoxModel<>(
                            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            delantero2Combo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            delantero2ComboActionPerformed(evt);
                    }
            });

            javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
            jPanel10.setLayout(jPanel10Layout);
            jPanel10Layout.setHorizontalGroup(
                            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(jPanel10Layout.createParallelGroup(
                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel10)
                                                                            .addComponent(delantero2Combo,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));
            jPanel10Layout.setVerticalGroup(
                            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel10)
                                                            .addPreferredGap(
                                                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(delantero2Combo,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));

            getContentPane().add(jPanel10);
            jPanel10.setBounds(680, 152, 161, 116);

            jPanel11.setBackground(new java.awt.Color(255, 255, 255));

            jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            jLabel11.setText("Arquero");

            arqueroCombo.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
            arqueroCombo.setModel(new javax.swing.DefaultComboBoxModel<>(
                            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            arqueroCombo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            arqueroComboActionPerformed(evt);
                    }
            });

            javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
            jPanel11.setLayout(jPanel11Layout);
            jPanel11Layout.setHorizontalGroup(
                            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel11Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(jPanel11Layout.createParallelGroup(
                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel11)
                                                                            .addComponent(arqueroCombo,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(40, Short.MAX_VALUE)));
            jPanel11Layout.setVerticalGroup(
                            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel11Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel11)
                                                            .addPreferredGap(
                                                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(arqueroCombo,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(33, Short.MAX_VALUE)));

            getContentPane().add(jPanel11);
            jPanel11.setBounds(346, 286, 161, 112);

            guardarYsalirBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            guardarYsalirBtn.setText("Guardar y Salir");
            guardarYsalirBtn.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            guardarYsalirBtnActionPerformed(evt);
                    }
            });
            getContentPane().add(guardarYsalirBtn);
            guardarYsalirBtn.setBounds(670, 390, 160, 120);

            jLabel12.setFont(new java.awt.Font("Poiret One", 1, 48)); // NOI18N
            jLabel12.setText("Configurar alineacion");
            getContentPane().add(jLabel12);
            jLabel12.setBounds(80, 440, 472, 57);

            jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            jLabel13.setText("Salir sin guardar !");
            jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                            jLabel13MouseClicked(evt);
                    }
            });
            getContentPane().add(jLabel13);
            jLabel13.setBounds(250, 500, 180, 25);

            pack();
    }// </editor-fold>

    private void defensa1ComboActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
    }

    private void defensa2ComboActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
    }

    private void defensa3ComboActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
    }

    private void defensa4ComboActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
    }

    private void medio1ComboActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
    }

    private void medio2ComboActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
    }

    private void medio3ComboActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
    }

    private void medio4ComboActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
    }

    private void delantero1ComboActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
    }

    private void delantero2ComboActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
    }

    private void arqueroComboActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
    }

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {
            this.dispose();
            new UserFrame();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
            // (optional) ">
            /*
             * If Nimbus (introduced in Java SE 6) is not available, stay with the default
             * look and feel.
             * For details see
             * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                    .getInstalledLookAndFeels()) {
                            if ("Nimbus".equals(info.getName())) {
                                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                    break;
                            }
                    }
            } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(ConfigurarAlineacion.class.getName()).log(java.util.logging.Level.SEVERE,
                                    null, ex);
            } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(ConfigurarAlineacion.class.getName()).log(java.util.logging.Level.SEVERE,
                                    null, ex);
            } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(
                                    ConfigurarAlineacion.class.getName()).log(java.util.logging.Level.SEVERE,
                                    null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(
                                    ConfigurarAlineacion.class.getName()).log(java.util.logging.Level.SEVERE,
                                    null, ex);
            }
            // </editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            new ConfigurarAlineacion().setVisible(true);
                    }
            });
    }

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> arqueroCombo;
    private javax.swing.JComboBox<String> defensa1Combo;
    private javax.swing.JComboBox<String> defensa2Combo;
    private javax.swing.JComboBox<String> defensa3Combo;
    private javax.swing.JComboBox<String> defensa4Combo;
    private javax.swing.JComboBox<String> delantero1Combo;
    private javax.swing.JComboBox<String> delantero2Combo;
    private javax.swing.JButton guardarYsalirBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JComboBox<String> medio1Combo;
    private javax.swing.JComboBox<String> medio2Combo;
    private javax.swing.JComboBox<String> medio3Combo;
    private javax.swing.JComboBox<String> medio4Combo;
    // End of variables declaration
}
