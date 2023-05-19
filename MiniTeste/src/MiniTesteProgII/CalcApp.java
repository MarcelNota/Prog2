package MiniTesteProgII;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalcApp {

	private JFrame frmCalculadora;
	private JTextField textFieldVisor;
	private JButton btnMINUS;
	private JButton btnDIVISION;
	private JButton btnINTEIRO;
	private JButton btnMODULUS;
	private JButton btnFACTO;
	private JButton btnEXECUTAR;
	private JButton btnCLEAR;
	private JTextField textVISOR1;
	private JTextField textVISOR2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
    private String operacao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcApp window = new CalcApp();
					window.frmCalculadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalcApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.setResizable(false);
		frmCalculadora.setBounds(100, 100, 502, 487);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadora.getContentPane().setLayout(null);
		
		textFieldVisor = new JTextField();
		textFieldVisor.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldVisor.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textFieldVisor.setBounds(10, 11, 466, 60);
		frmCalculadora.getContentPane().add(textFieldVisor);
		textFieldVisor.setColumns(10);
		
		JButton btnPLUS = new JButton("+");
		btnPLUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacao="+";
					textVISOR2.setEnabled(true);

			}
		});
		btnPLUS.setBounds(10, 143, 89, 23);
		frmCalculadora.getContentPane().add(btnPLUS);
		
		JButton btnMULTIPLY = new JButton("X");
		btnMULTIPLY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacao="X";
				textVISOR2.setEnabled(true);
			}
		});
		btnMULTIPLY.setBounds(116, 143, 89, 23);
		frmCalculadora.getContentPane().add(btnMULTIPLY);
		
		btnMINUS = new JButton("-");
		btnMINUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacao="-";
				textVISOR2.setEnabled(true);
			}
		});
		btnMINUS.setBounds(233, 143, 89, 23);
		frmCalculadora.getContentPane().add(btnMINUS);
		
		btnDIVISION = new JButton("/");
		btnDIVISION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacao="/";
				textVISOR2.setEnabled(true);
			}
		});
		btnDIVISION.setBounds(363, 143, 89, 23);
		frmCalculadora.getContentPane().add(btnDIVISION);
		
		btnINTEIRO = new JButton("|");
		btnINTEIRO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacao="|";
				
			}
		});
		btnINTEIRO.setBounds(74, 194, 89, 23);
		frmCalculadora.getContentPane().add(btnINTEIRO);
		
		btnMODULUS = new JButton("%");
		btnMODULUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacao="%";
				textVISOR2.setEnabled(true);
			}
		});
		btnMODULUS.setBounds(215, 194, 89, 23);
		frmCalculadora.getContentPane().add(btnMODULUS);
		
		btnFACTO = new JButton("!");
		btnFACTO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacao="!";
				if(operacao.equals("!")) {
					textVISOR2.setEnabled(false);
				}else {
					textVISOR1.setEnabled(true);
				}
				
			//
			}
		});
		btnFACTO.setBounds(363, 194, 89, 23);
		frmCalculadora.getContentPane().add(btnFACTO);
		
		
		btnEXECUTAR = new JButton("EXECUTAR");
		btnEXECUTAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double contentor=0;

				
				try {
					
					double visor1= Double.parseDouble(textVISOR1.getText());
					double visor2= Double.parseDouble(textVISOR2.getText());

					switch(operacao) {
					case "+":contentor=visor1+visor2; break;
					case "-":contentor=visor1-visor2; break;
					case "X":contentor=visor1*visor2; break;
					case "%":contentor=visor1%visor2; break;
					case "!": double factorial=visor1;
							contentor=visor1;
								while(factorial>1) {
									contentor=contentor-(factorial-1);
									factorial--;
								}
								break;
					case "|": if(visor2==0) {
						JOptionPane.showMessageDialog(btnMULTIPLY,"ERRO");
					}else {
						contentor=(int)(visor1/visor2);
					}
					break;
					case "/": if(visor2==0) {
						JOptionPane.showMessageDialog(btnMULTIPLY,"ERRO");
					}else {
						contentor=visor1/visor2;
					}
					break;
						
					}
					
					
				} catch (NumberFormatException e2) {
					double visor1= Double.parseDouble(textVISOR1.getText());
					
					double factorial=visor1;
					contentor=visor1;
						while(factorial>1) {
							contentor=contentor-(factorial-1);
							factorial--;
						}
				}catch (Exception e2) {
					// TODO: handle exception
				}
				
				textFieldVisor.setText(contentor+"");
				
			}
		});
		btnEXECUTAR.setBounds(55, 295, 89, 23);
		frmCalculadora.getContentPane().add(btnEXECUTAR);
		
		btnCLEAR = new JButton("CLEAR");
		btnCLEAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVISOR1.setText("");
				textVISOR2.setText("");
				textFieldVisor.setText("");
			}
		});
		btnCLEAR.setBounds(302, 295, 89, 23);
		frmCalculadora.getContentPane().add(btnCLEAR);
		
		textVISOR1 = new JTextField();
		textVISOR1.setBounds(10, 93, 122, 33);
		frmCalculadora.getContentPane().add(textVISOR1);
		textVISOR1.setColumns(10);
		
		textVISOR2 = new JTextField();
		textVISOR2.setBounds(282, 99, 122, 33);
		frmCalculadora.getContentPane().add(textVISOR2);
		textVISOR2.setColumns(10);
		
		lblNewLabel = new JLabel("Variave1");
		lblNewLabel.setBounds(10, 82, 46, 14);
		frmCalculadora.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Variavel2");
		lblNewLabel_1.setBounds(282, 82, 46, 14);
		frmCalculadora.getContentPane().add(lblNewLabel_1);
		
	}
	
	
}
