
package unidades.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuario
 */
public class PanelDatosMuestra extends JPanel implements ActionListener{
    
    private final static String AYUNAS="En ayunas";
    private final static String CALCULAR_HEMATOCRITO="CALCULAR HEMATOCRITO";
    private final static String CALCULAR_LEUCOCITOS="CALCULAR LEUCOCITOS";
    
    private InterfazSistemaPacientes principal;
    // se inicializa las Muestras
    private JLabel labFTomaMuestra;
    private JTextField txtFTomaMuestra;
    // se inicializa wl volumen de muestras
    private JLabel labVolumenMuestra;
    private JTextField txtVolumenMuestra;
    // se inicializa wl volumen de los leucocitos
    private JLabel labVolumenEritrocitos;
    private JTextField txtVolumenEritrocitos;
    // se inicializa el conteo 
    private JLabel labConteoLeucocitos;
    private JTextField txtConteoLeucocitos;
    // se inicializa el conteo de las plaquetas 
    private JLabel labConteoPlaquetas;
    private JTextField txtConteoPlaquetas;
    // se inicializa el paciente si esta en ayunas
    private JCheckBox cbAyunas;
    // se inicializa wl volumen de hematocitos 
    private JButton butHematocrito;
    private JTextField txtHematocrito;
    // se inicializa wl volumen de leucocitos
    private JButton butLeucocitos;
    private JTextField txtLeucocitos;
    
    public PanelDatosMuestra(InterfazSistemaPacientes v){
        
        principal=v;
        
        setLayout(new GridLayout(6,4));
        TitledBorder border = BorderFactory.createTitledBorder("Información muestra");
        border.setTitleColor(Color.BLUE);
        setBorder(border);
        
        
        labFTomaMuestra=new JLabel("Fecha Toma Muestra: ");
        labVolumenMuestra=new JLabel("Volumen Muestra: ");
        labVolumenEritrocitos=new JLabel("Volumen Eritrocitos: ");
        labConteoLeucocitos=new JLabel("Conteo Leucocitos: ");
        labConteoPlaquetas=new JLabel("Conteo Plaquetas: ");
        
        txtFTomaMuestra=new JTextField();
        txtFTomaMuestra.setEditable(false);
        txtFTomaMuestra.setBackground(Color.LIGHT_GRAY);
        
        txtVolumenMuestra=new JTextField();
        txtVolumenMuestra.setEditable(true);
        
        txtVolumenEritrocitos=new JTextField();
        txtVolumenEritrocitos.setEditable(true);
        
        txtConteoLeucocitos=new JTextField();
        txtConteoLeucocitos.setEditable(true);
        
        txtConteoPlaquetas=new JTextField();
        txtConteoPlaquetas.setEditable(true);
        
        butHematocrito=new JButton("Calcular Hematocrito");
        butHematocrito.setActionCommand(CALCULAR_HEMATOCRITO);
        txtHematocrito=new JTextField();
        txtHematocrito.setEditable(false);
        
        butLeucocitos=new JButton("Calcular Leucocitos");
        butLeucocitos.setActionCommand(CALCULAR_LEUCOCITOS);
        txtLeucocitos=new JTextField();
        txtLeucocitos.setEditable(false);
        
        cbAyunas=new JCheckBox("Ayunas");
        cbAyunas.setActionCommand(AYUNAS);
        
        add(labFTomaMuestra);
        add(txtFTomaMuestra);
        add(new JLabel(""));
        add(cbAyunas);
        add(labVolumenMuestra);
        add(txtVolumenMuestra);
        add(new JLabel(""));
        add(new JLabel(""));
        add(labVolumenEritrocitos);
        add(txtVolumenEritrocitos);
        add(butHematocrito);
        add(txtHematocrito);
        add(labConteoLeucocitos);
        add(txtConteoLeucocitos);
        add(butLeucocitos);
        add(txtLeucocitos);
        add(labConteoPlaquetas);
        add(txtConteoPlaquetas);
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));   
        
        butHematocrito.addActionListener(this);
        butLeucocitos.addActionListener(this);
        cbAyunas.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando=e.getActionCommand();
        if (comando.equals(CALCULAR_HEMATOCRITO)) {
            principal.calcularHematocrito();
        }else if (comando.equals(CALCULAR_LEUCOCITOS)) {
            principal.calcularLeucocito();
        }else if (comando.equals(AYUNAS)) {
            principal.cambiarEnAyunas();
        }
    }

    public void mostrarHematocrito(String pHematocrito) {
        txtHematocrito.setText(pHematocrito+"");
    }
    
    public void mostrarLeucocito(String pLeucocito) {
        txtLeucocitos.setText(pLeucocito+"");
    }
    
    public void mostrarAyunas(boolean pEnAyunas) {
        cbAyunas.setSelected(pEnAyunas);
    }

    public String darVolumenMuestra(){
        String rta=txtVolumenMuestra.getText();
        return rta;
    }
    
    public String darVolumenEritrocitos(){
        String rta=txtVolumenEritrocitos.getText();
        return rta;
    }
    
    public String darConteoLeucocitos(){
        String rta=txtConteoLeucocitos.getText();
        return rta;
    }
    
    public String darConteoPlaquetas(){
        String rta=txtConteoPlaquetas.getText();
        return rta;
    }
    
    public boolean estaEnAyunas(){
        return cbAyunas.isSelected();
    }
    
    public void limpiarCampos(){
        txtHematocrito.setText("");
        txtLeucocitos.setText("");
    }
    
    public void actualizarCampos(String pFechaMuestra, boolean pEnAyunas, double pVolumenMuestra, double pVolumenEritrocitos, int pConteoLeucocitos, int pConteoPlaquetas){
        txtFTomaMuestra.setText(pFechaMuestra+"");
        txtVolumenMuestra.setText(pVolumenMuestra+"");
        txtVolumenEritrocitos.setText(pVolumenEritrocitos+"");
        txtConteoLeucocitos.setText(pConteoLeucocitos+"");
        txtConteoPlaquetas.setText(pConteoPlaquetas+"");
        cbAyunas.setSelected(pEnAyunas);
    }
    
    
}
