package cryptotools;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import utility.ciphers.*;
import utility.ciphers.Constants;


/**
 *
 * @author Lester
 */
public class CryptoTools extends JFrame {
    
        private JPanel contentPane;
	private JLabel l1,l2,l3,l4;
	private JTextField t1,t2,t3;
	private JMenuBar menuBar;
	private Font font;
    
    public static void main(String args[]) throws Exception{
        try {
			CryptoTools f = new CryptoTools();
			f.setVisible(true);
			f.setResizable(false);
                        f.setSize(600,400);
                        f.setLayout(null); 
		} 
		catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public CryptoTools() {
            setTitle("CryptoTool ");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(150, 150, 395, 434);
            
            
            menuBar = createMenuBar();
		setJMenuBar(menuBar);		
		
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//style/layout of the JFrame "Nimbus"
		try {
			setFrameStyle("Nimbus");
		} catch (ClassNotFoundException e2) {
			JOptionPane.showMessageDialog(null, Constants.ERROR_LOADING_LAYOUT);
		} catch (InstantiationException e2) {
			JOptionPane.showMessageDialog(null, Constants.ERROR_LOADING_LAYOUT);
		} catch (IllegalAccessException e2) {
			JOptionPane.showMessageDialog(null, Constants.ERROR_LOADING_LAYOUT);
		} catch (UnsupportedLookAndFeelException e2) {
			JOptionPane.showMessageDialog(null, Constants.ERROR_LOADING_LAYOUT);
		}
                
            Font font;
            font = new Font("Tahoma", Font.PLAIN, 16);
            
           
	    l1=new JLabel("INPUT TEXT: ");
            l1.setFont(font);
	    l1.setBounds(50,50, 120,30);
            contentPane.add(l1);
	    l2=new JLabel("KEY : ");  
	    l2.setFont(font);
            l2.setBounds(50,100, 120,30);
	    contentPane.add(l2);
            l3=new JLabel("CIPHER TEXT: ");
	    l3.setFont(font);
            l3.setBounds(50,250, 120,30);
            contentPane.add(l3);
	    l4=new JLabel("ALGORITHM : ");
	    l4.setFont(font);
            l4.setBounds(50,150, 120,30);
            contentPane.add(l4); 
	    	    
	    t1=new JTextField();  
            t1.setFont (font);
	    t1.setBounds(200,50, 200,30);
            contentPane.add(t1);
	    t2=new JTextField();  
            t2.setFont (font);
	    t2.setBounds(200,100, 200,30);
            contentPane.add(t2);
	    t3=new JTextField();
            t3.setFont (font);
	    t3.setBounds(200,250, 200,30);
            contentPane.add(t3);
	    
	    final Choice c=new Choice();  
                c.setBounds(200,150, 200,30);
                c.setFont(font);
                c.add("Ceasar Cipher");  
                c.add("RailFence Cipher");  
                c.add("Vigenere Cipher");
                c.add("Dynamic Encryption");
            contentPane.add(c);
        
            JButton b1,b2,b3,b4,b5; 
                b1= new JButton("Encrypt");
                b1.setFont(font);
                b1.setBackground(Color.GRAY);
                b2= new JButton("Decrypt");
                b2.setFont(font);
                b2.setBackground(Color.GRAY);
                b1.setBounds(300, 300, 100, 30);
                b2.setBounds(450, 300, 100, 30);
                
        final CaesarCipher cc = new CaesarCipher();
        final RailFence rfc = new RailFence();
        final VigenereCipher vc = new VigenereCipher();
        Dynamic d = new Dynamic();
        
        b1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		StringBuffer result = new StringBuffer();
        		int choice = c.getSelectedIndex();
        		//try {
                            if(!isError()){
                                switch(choice){
                                            case 0:
                                            int CCkey = 0;
                                            CCkey = Integer.parseInt(t2.getText());
                                                    t3.setText(cc.encrypt(t1.getText(), CCkey));
                                                    break;

                                            case 1:
                                                    int rfckey;
                                                    rfckey = Integer.parseInt(t2.getText());
                                                    try {
                                                            result = new StringBuffer(rfc.encrypt(t1.getText(), rfckey));
                                                    } catch (Exception e1) {
                                                            // TODO Auto-generated catch block
                                                            e1.printStackTrace();
                                                    }
                                                    t3.setText(result.toString());
                                                    break;

                                            case 2:
                                                    result =new StringBuffer(vc.encrypt(t1.getText(), t2.getText()));
                                                    t3.setText(result.toString());
                                                    break;

                                            case 3:
                                                    t3.setText(d.dynamicEncryptionOrDecryption(1, t1.getText(), t2.getText()));
                                                    break;
                                                }
                                            }
                            		 
				/*} catch (InvalidKeyException e1) {
					labelMessage.setForeground(Color.RED);
					labelMessage.setText("Invalid Key");
				} catch (IllegalBlockSizeException e1) {
					labelMessage.setForeground(Color.RED);
					labelMessage.setText("Password size invalid");
				} catch (BadPaddingException e1) {
					labelMessage.setForeground(Color.RED);
					labelMessage.setText(Constants.PASSWORD_ERROR);
				}*/
                        }       
        });
        
        b2.addActionListener(new ActionListener(){
                @Override
        	public void actionPerformed(ActionEvent e){
        		int choice = c.getSelectedIndex();
        		choice = c.getSelectedIndex();
        		StringBuffer result = new StringBuffer();
        		if(!isError()){
        		switch(choice){
        		
        		case 0:
        			int CCkey = Integer.parseInt(t2.getText());
                                t3.setText(cc.encrypt(t1.getText(), 26-CCkey));
        			break;
                                
        		case 1:
        			int rfckey;
        			rfckey = Integer.parseInt(t2.getText());
				try {
					result = new StringBuffer(rfc.decrypt(t1.getText(), rfckey));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                                t3.setText(result.toString());
        			break; 
                                
        		case 2:
        			result = new StringBuffer(vc.decrypt(t1.getText(), t2.getText()));
                                t3.setText(result.toString());
        			break;
                                
                        case 3: 
                                t3.setText(d.dynamicEncryptionOrDecryption(2, t1.getText(), t2.getText()));
                                break;
        			
        		}
        		
                    }
        	}
        });
        contentPane.add(b1);
        contentPane.add(b2);
        
        b3=new JButton("Clear");
        b3.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
            	t1.setText("");
            }  
            });  
        b3.setBounds(450, 50, 100, 30);
        b3.setFont(font);
        contentPane.add(b3);
        
        
        b4=new JButton("Clear");
        b4.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){
                t2.setText("");
            }  
            });  
        b4.setBounds(450, 100, 100, 30);
        b4.setFont(font);
        contentPane.add(b4);
        
        b5=new JButton("Clear");
        b5.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                t3.setText("");
            }  
            });  
        b5.setBounds(450, 250, 100, 30);
        b5.setFont(font);
        contentPane.add(b5);
        
	}
    
        
    
    private boolean isError() {
        boolean bool = false;
        
        if(t1.getText().equals("")){
        	JOptionPane.showMessageDialog(null, Constants.ERROR_TEXT , Constants.WARNING , JOptionPane.ERROR_MESSAGE);
            return bool=true;
        }
        if (t2.getText().equals("")) {
        	JOptionPane.showMessageDialog(null, Constants.PASSWORD_ERROR_NULL , Constants.WARNING , JOptionPane.ERROR_MESSAGE);
            return bool=true;
        }
        else if(t2.getText().length() > 8) {
        	JOptionPane.showMessageDialog(null, Constants.PASSWORD_ERROR_LENGTH , Constants.WARNING , JOptionPane.ERROR_MESSAGE);
            return bool=true;
		}        
        
        return bool;
    }

    public void setFrameStyle(String style) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	    UIManager.LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
	    for (UIManager.LookAndFeelInfo info : plafs) {
	        if (info.getName().contains(style)) {
	        	UIManager.setLookAndFeel(info.getClassName());	        	
	        }
	    }
	}
	

	/**
	 * Create the JMenubar 
	 * 
	 * @return JMenuBar JFrame's menu
	 */
    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        JMenu menuFile = new JMenu(Constants.HELP);
        JMenuItem guida = new JMenuItem(Constants.GUIDE);
        guida.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {        		
        		JOptionPane.showMessageDialog(null, Constants.MAIN_PROGRAM_HELP , "Help" , JOptionPane.INFORMATION_MESSAGE);
			}
		});  
        
        JMenuItem caeser = new JMenuItem(Constants.CAESER);
        caeser.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {        		
        		JOptionPane.showMessageDialog(null, Constants.CAESER_HELP , "Help" , JOptionPane.INFORMATION_MESSAGE);
			}
		});
        
        JMenuItem rail = new JMenuItem(Constants.RAIL);
        rail.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {        		
        		JOptionPane.showMessageDialog(null, Constants.RAIL_HELP, "Help" , JOptionPane.INFORMATION_MESSAGE);
			}
		});
        
        JMenuItem vig = new JMenuItem(Constants.VIG);
        rail.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {        		
        		JOptionPane.showMessageDialog(null, Constants.VIG_HELP , "Help" , JOptionPane.INFORMATION_MESSAGE);
			}
		});
        
        JMenuItem dyan = new JMenuItem(Constants.DYAN);
        dyan.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {        		
        		JOptionPane.showMessageDialog(null, Constants.DYAN_HELP , "Help" , JOptionPane.INFORMATION_MESSAGE);
			}
		});
                       
        menuFile.add(guida);
        menuFile.add(caeser);
        menuFile.add(rail);
        menuFile.add(vig);
        menuFile.add(dyan);
        menuBar.add(menuFile);        
        return menuBar;
    }
}
