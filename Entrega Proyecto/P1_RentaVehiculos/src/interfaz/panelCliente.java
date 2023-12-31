package interfaz;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modelo.RentaVehiculos;

public class panelCliente extends JPanel {
	
	private static RentaVehiculos rentaVehiculos;
	
	public panelCliente(RentaVehiculos rentaVehiculos) {
		this.rentaVehiculos = rentaVehiculos;
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        JLabel tituloLabel = new JLabel("DGA Rental");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        gbc.insets = new Insets(20, 20, 20, 20);
        add(tituloLabel, gbc);
        JButton alquilerButton = new JButton("Realizar Alquiler");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10); 
        add(alquilerButton, gbc);

        alquilerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelAlquiler panelAlquiler = new PanelAlquiler(rentaVehiculos);
                JFrame alquilerFrame = new JFrame("Alquiler");
                alquilerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                alquilerFrame.getContentPane().add(panelAlquiler);
                alquilerFrame.pack();
                alquilerFrame.setLocationRelativeTo(null);
                alquilerFrame.setVisible(true);
            }
        });
        
        JButton reservaButton = new JButton("Realizar Reserva");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10); 
        add(reservaButton, gbc);

        reservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	PanelReserva panelReserva = new PanelReserva(rentaVehiculos);
                JFrame reservaFrame = new JFrame("Reserva");
                reservaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                reservaFrame.getContentPane().add(panelReserva);
                reservaFrame.pack();
                reservaFrame.setLocationRelativeTo(null);
                reservaFrame.setVisible(true);
            }
        });

        JButton salirButton = new JButton("Salir");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; 
        gbc.insets = new Insets(10, 10, 10, 10); 
        add(salirButton, gbc);
        
        
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelCliente.this);
                frame.dispose();
            }
        });
	}
	
}
