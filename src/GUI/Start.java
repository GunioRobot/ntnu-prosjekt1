package GUI;

import java.awt.EventQueue;

import localData.Config;
import localData.JSONException;
import logic.*;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;


import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;


import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;


import logic.Address;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JList;

import Map.Map;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

/**
 * Hovedklassen som kjører programmet
 */
public class Start extends Thread{
	
	public static boolean DEBUG = true;
	
	/**
	 * @uml.property  name="frame"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JFrame frame;
	/**
	 * @uml.property  name="nummer"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField nummer;
	/**
	 * @uml.property  name="navn"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField navn;
	/**
	 * @uml.property  name="gatenavn"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField gatenavn;
	/**
	 * @uml.property  name="postnummer"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField postnummer;
	/**
	 * @uml.property  name="poststed"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField poststed;
	/**
	 * @uml.property  name="kommentar"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextPane kommentar;
	/**
	 * @uml.property  name="buttonGroup"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * @uml.property  name="label"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel label;
	/**
	 * @uml.property  name="bestilling"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel bestilling;
	/**
	 * @uml.property  name="reciept"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel reciept;
	/**
	 * @uml.property  name="panel"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JPanel panel;
	/**
	 * @uml.property  name="bestillingsInfo"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel bestillingsInfo;
	/**
	 * @uml.property  name="rediger"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel Rediger;
	/**
	 * @uml.property  name="tabbedPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTabbedPane tabbedPane;
	/**
	 * @uml.property  name="rdbtnKort"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JRadioButton rdbtnKort;
	/**
	 * @uml.property  name="rdbtnKontant"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JRadioButton rdbtnKontant;
	/**
	 * @uml.property  name="toggleButton"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton toggleButton;
	/**
	 * @uml.property  name="toggleButton_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton toggleButton_1;
	/**
	 * @uml.property  name="toggleButton_2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton toggleButton_2;
	/**
	 * @uml.property  name="toggleButton_3"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton toggleButton_3;
	/**
	 * @uml.property  name="toggleButton_4"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton toggleButton_4;
	/**
	 * @uml.property  name="toggleButton_5"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton toggleButton_5;
	/**
	 * @uml.property  name="toggleButton_6"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton toggleButton_6;
	/**
	 * @uml.property  name="toggleButton_7"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton toggleButton_7;
	/**
	 * @uml.property  name="toggleButton_8"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton toggleButton_8;
	/**
	 * @uml.property  name="tglbtnCola"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton tglbtnCola;
	/**
	 * @uml.property  name="tglbtnFanta"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton tglbtnFanta;
	/**
	 * @uml.property  name="tglbtnUrge"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton tglbtnUrge;
	/**
	 * @uml.property  name="tglbtnSprite"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton tglbtnSprite;
	/**
	 * @uml.property  name="tglbtnFarris"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton tglbtnFarris;
	/**
	 * @uml.property  name="tglbtnLol"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton tglbtnLol;
	/**
	 * @uml.property  name="button"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton button;
	/**
	 * @uml.property  name="button_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton button_1;
	/**
	 * @uml.property  name="button_2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton button_2;
	/**
	 * @uml.property  name="button_3"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton button_3;
	/**
	 * @uml.property  name="button_4"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton button_4;
	/**
	 * @uml.property  name="button_5"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton button_5;
	/**
	 * @uml.property  name="button_6"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton button_6;
	/**
	 * @uml.property  name="btnNewButton_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnNewButton_1;
	/**
	 * @uml.property  name="btnNewButton"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnNewButton;
	/**
	 * @uml.property  name="btnNeste"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnNeste;
	/**
	 * @uml.property  name="btnIncall"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnIncall;
	/**
	 * @uml.property  name="chckbxLevering"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JCheckBox chckbxLevering; 
	/**
	 * @uml.property  name="list_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	@SuppressWarnings("rawtypes")
	private JList list_1;
	/**
	 * @uml.property  name="image"
	 */
	@SuppressWarnings("unused")
	private BufferedImage image;

	/**
	 * @uml.property  name="label_2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel label_2;
	/**
	 * @uml.property  name="textArea"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextArea textArea;
	/**
	 * @uml.property  name="isBrus"
	 */
	private boolean isBrus = false;
	/**
	 * @uml.property  name="kvittering"
	 */
	private ArrayList<String> kvittering = new ArrayList<String>();
	/**
	 * @uml.property  name="list"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	@SuppressWarnings("rawtypes")
	private JList list;
	/**
	 * @uml.property  name="model"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	private DefaultListModel model = new DefaultListModel();
	/**
	 * @uml.property  name="list_2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private DefaultListModel list_2 = new DefaultListModel();
	/**
	 * @uml.property  name="listModelFinished"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	private DefaultListModel listModelFinished = new DefaultListModel();
	/**
	 * @uml.property  name="m1"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="logic.User"
	 */
	private DefaultListModel m1 = new DefaultListModel();
	/**
	 * @uml.property  name="m2"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="logic.Product"
	 */
	private DefaultListModel m2 = new DefaultListModel();
	/**
	 * @uml.property  name="m3"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="logic.Order"
	 */
	private DefaultListModel m3 = new DefaultListModel();
	/**
	 * @uml.property  name="m4"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="logic.Order"
	 */
	private DefaultListModel m4 = new DefaultListModel();

	/**
	 * @uml.property  name="button_9"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton button_9;
	/**
	 * @uml.property  name="hvorMange"
	 */
	private String hvorMange = "";
	/**
	 * @uml.property  name="husnummer"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField husnummer;
	/**
	 * @uml.property  name="lblPostnummer"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblPostnummer;
	/**
	 * @uml.property  name="lblPoststed"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblPoststed;
	/**
	 * @uml.property  name="lblKommentar"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblKommentar;
	/**
	 * @uml.property  name="lblRingendeNummer"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblRingendeNummer;
	/**
	 * @uml.property  name="btnFjernElement"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnFjernElement;
	/**
	 * @uml.property  name="utgaende"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel Utgaende;
	/**
	 * @uml.property  name="list_3"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JList list_3;
	/**
	 * @uml.property  name="list_4"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JList list_4;
	/**
	 * @uml.property  name="btnDel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnDel;
	/**
	 * @uml.property  name="button_8"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton button_8;
	/**
	 * @uml.property  name="sisteTrykteKnapp"
	 */
	
	private String sisteTrykteKnapp;
	/**
	 * @uml.property  name="map"
	 * @uml.associationEnd  
	 */
	private Map map = new Map();
	/**
	 * @uml.property  name="btnRedigerAdresse"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnRedigerAdresse;
	/**
	 * @uml.property  name="users"
	 */
	private ArrayList<User> users = new ArrayList<User>();

	/**
	 * @uml.property  name="q"
	 */
	private int q;
	/**
	 * @uml.property  name="w"
	 */
	private int w;
	/**
	 * @uml.property  name="panel_4"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel panel_4;
	/**
	 * @uml.property  name="kvitering"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextPane kvitering;
	/**
	 * @uml.property  name="lblAddressNotFound"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblAddressNotFound;
	/**
	 * @uml.property  name="con"
	 * @uml.associationEnd  
	 */
	private DatabaseConnector con = new DatabaseConnector();
	/**
	 * @uml.property  name="kunder"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel kunder;
	/**
	 * @uml.property  name="kunder_list"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JList kunder_list;
	/**
	 * @uml.property  name="retter_list"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JList retter_list;
	/**
	 * @uml.property  name="showProductList"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JList showProductList;
	/**
	 * @uml.property  name="leggTil"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton leggTil;
	/**
	 * @uml.property  name="slett"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton Slett;
	/**
	 * @uml.property  name="rediger_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton Rediger_1;
	/**
	 * @uml.property  name="rediger_retter"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton rediger_retter;
	/**
	 * @uml.property  name="leggTil_retter"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton leggTil_retter;
	/**
	 * @uml.property  name="leggTil_retter_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton leggTil_retter_1;
	/**
	 * @uml.property  name="redigerNavn"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField redigerNavn;
	/**
	 * @uml.property  name="redigerNummer"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField redigerNummer;
	/**
	 * @uml.property  name="redigerAdresse"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField redigerAdresse;
	/**
	 * @uml.property  name="redigerHusNr"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField redigerHusNr;
	/**
	 * @uml.property  name="redigerPostNummer"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField redigerPostNummer;
	/**
	 * @uml.property  name="redigerPostSted"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField redigerPostSted;
	/**
	 * @uml.property  name="retterNavn"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField retterNavn;
	/**
	 * @uml.property  name="retterPris"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField retterPris;
	/**
	 * @uml.property  name="retterKommentar"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextPane retterKommentar;
	/**
	 * @uml.property  name="lblProduktnavn"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblProduktnavn;
	/**
	 * @uml.property  name="lblPris"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblPris;
	/**
	 * @uml.property  name="lblBeskrivelse"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblBeskrivelse;
	/**
	 * @uml.property  name="retter"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JPanel Retter;
	/**
	 * @uml.property  name="listmodelUsers"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private DefaultListModel listmodelUsers = new DefaultListModel();
	/**
	 * @uml.property  name="listModelProducts"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private DefaultListModel listModelProducts = new DefaultListModel();
	/**
	 * @uml.property  name="listModelOrders"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	private DefaultListModel listModelOrders = new DefaultListModel();
	/**
	 * @uml.property  name="showProductModel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private DefaultListModel showProductModel = new DefaultListModel();

	/**
	 * @uml.property  name="alleUsers"
	 */
	private ArrayList<String> alleUsers = new ArrayList<String>();
	/**
	 * @uml.property  name="panel_2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel panel_2;
	/**
	 * @uml.property  name="btnLevert"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnLevert;
	/**
	 * @uml.property  name="panel_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel panel_1;
	/**
	 * @uml.property  name="pizzaInfo"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel pizzaInfo = new JLabel();
	/**
	 * @uml.property  name="button_7"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton button_7;
	/**
	 * @uml.property  name="focusOnFinishedOrders"
	 */
	private boolean focusOnFinishedOrders = false;

	/**
	 * @uml.property  name="temp" multiplicity="(0 -1)" dimension="1"
	 */
	private String[] temp;
	/**
	 * @uml.property  name="menuBar"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuBar menuBar;
	/**
	 * @uml.property  name="label_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel label_1;
	/**
	 * @uml.property  name="scrollPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane;
	/**
	 * @uml.property  name="scrollPane_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane_1;
	/**
	 * @uml.property  name="scrollPane_2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane_2;
	/**
	 * @uml.property  name="scrollPane_3"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane_3;
	/**
	 * @uml.property  name="scrollPane_4"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane_4;
	/**
	 * @uml.property  name="scrollPane_5"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane_5;
	/**
	 * @uml.property  name="scrollPane_6"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane_6;
	/**
	 * @uml.property  name="scrollPane_7"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane_7;
	/**
	 * @uml.property  name="scrollPane_8"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane_8;
	/**
	 * @uml.property  name="scrollPane_9"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane_9;
	/**
	 * @uml.property  name="panel_5"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel panel_5;
	/**
	 * @uml.property  name="scrollPane_10"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane_10;
	/**
	 * @uml.property  name="panel_6"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel panel_6;
	private JTextField pizzanr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {}
			}
		});
	}

	/**
	 * Created and initialize the application.
	 */
	public Start() {
		initialize();
		try {
			Config.init();
		} catch(JSONException hehe){
			exit("Klarte ikke parse config.json");
		} catch(IOException to){
			exit("Klarte ikke lese config.json");						
		}catch (Exception e1) {
			exit("En ukjent feil med config.json");
		}
		try{
			DatabaseConnector.initialize();			
		}catch(Exception e){
			exit("Klarte ikke å koble til databasen, vennligst kontroller config.json");
			if(DEBUG){
				e.printStackTrace();
			}
		}
		getUsers();
		getProducts();
		getOrders();
		lagListe();
		frame.repaint();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setTitle("Pizza Pie In The Sky");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int width = 1000, height = 720;

		frame.setBounds((dim.width-width)/2, (dim.height-height)/2, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tabbedPane.getSelectedComponent() == Rediger) {
					JPasswordField pwd = new JPasswordField(10);
					JOptionPane.showConfirmDialog(null, pwd, "Skriv inn passord", JOptionPane.OK_CANCEL_OPTION);
					char[] c = pwd.getPassword();
					if(isPasswordCorrect(c)){
						tabbedPane.setSelectedComponent(Rediger);
					}
					
					else{
						JOptionPane.showMessageDialog(null, "Feil passord!", "Error", JOptionPane.ERROR_MESSAGE);
						tabbedPane.setSelectedComponent(bestilling);
					}
				}
			}
		});
		tabbedPane.setBounds(1, 1, 998, 695);
		frame.getContentPane().add(tabbedPane);

		//---------------------Ny bestilling--------------------------------------

		bestilling = new JPanel();
		bestilling.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Ny bestilling", null, bestilling, null);
		bestilling.setLayout(null);


		///////////////////meny knapper////////////////////////////

		toggleButton = new JButton("Nr.1");
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.1";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.1";
					menyKnappTrykk("Pizza nr.1");		
				}
			}
		});
		toggleButton.setBounds(16, 45, 75, 45);
		bestilling.add(toggleButton);

		toggleButton_1 = new JButton("Nr.2");
		toggleButton_1.setBounds(101, 45, 75, 45);
		bestilling.add(toggleButton_1);
		toggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.2";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.2";
					menyKnappTrykk("Pizza nr.2");
				}
			}
		});

		toggleButton_2 = new JButton("Nr.3");
		toggleButton_2.setBounds(183, 45, 75, 45);
		bestilling.add(toggleButton_2);
		toggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.3";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.3";
					menyKnappTrykk("Pizza nr.3");
				}
			}
		});


		toggleButton_3 = new JButton("Nr.4");
		toggleButton_3.setBounds(16, 101, 75, 45);
		bestilling.add(toggleButton_3);
		toggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				sisteTrykteKnapp = "Pizza nr.4";
				if(hvorMange != ""){
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.4";
					menyKnappTrykk("Pizza nr.4");
				}
			}
		});

		toggleButton_4 = new JButton("Nr.5");
		toggleButton_4.setBounds(101, 101, 75, 45);
		bestilling.add(toggleButton_4);
		toggleButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.5";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.5";
					menyKnappTrykk("Pizza nr.5");
				}
			}
		});

		toggleButton_5 = new JButton("Nr.6");
		toggleButton_5.setBounds(183, 101, 75, 45);
		bestilling.add(toggleButton_5);
		toggleButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.6";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.6";
					menyKnappTrykk("Pizza nr.6");
				}
			}
		});
		toggleButton_6 = new JButton("Nr.7");
		toggleButton_6.setBounds(16, 157, 75, 45);
		bestilling.add(toggleButton_6);
		toggleButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.7";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.7";
					menyKnappTrykk("Pizza nr.7");
				}
			}
		});

		toggleButton_7 = new JButton("Nr.8");
		toggleButton_7.setBounds(101, 157, 75, 45);
		bestilling.add(toggleButton_7);
		toggleButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.8";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.8";
					menyKnappTrykk("Pizza nr.8");
				}
			}
		});

		toggleButton_8 = new JButton("Nr.9");
		toggleButton_8.setBounds(183, 157, 75, 45);
		bestilling.add(toggleButton_8);
		toggleButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Pizza nr.9";
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Pizza nr.9";
					menyKnappTrykk("Pizza nr.9");
				}
			}
		});

		reciept = new JPanel();
		reciept.setBackground(Color.GRAY);
		reciept.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Bestilling", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 250, 250)));
		reciept.setBounds(300, 20, 352, 603);
		bestilling.add(reciept);
		reciept.setLayout(null);

		JButton btnFjernAlt = new JButton("Fjern alt");
		btnFjernAlt.setForeground(new Color(47, 79, 79));
		btnFjernAlt.setFont(new Font("Verdana", Font.BOLD, 11));
		btnFjernAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kvittering.clear();
				model.removeAllElements();

			}
		});

		btnFjernElement = new JButton("Fjern");
		btnFjernElement.setForeground(new Color(47, 79, 79));
		btnFjernElement.setFont(new Font("Verdana", Font.BOLD, 11));
		btnFjernElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model.getSize()>0)
					try{
						model.remove(list.getSelectedIndex());
					}catch(Exception t){
						JOptionPane.showMessageDialog(null, "Du må velge ett element først", "Fjern-Error",  JOptionPane.ERROR_MESSAGE);

					}
			}
		});
		btnFjernElement.setBounds(132, 0, 100, 23);
		reciept.add(btnFjernElement);
		btnFjernAlt.setBounds(242, 0, 100, 23);
		reciept.add(btnFjernAlt);

		scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(10, 25, 332, 567);
		reciept.add(scrollPane_7);

		list = new JList(model);
//		list.setFont(new Font("Verdana", Font.BOLD, 18));
//		list.setFixedCellHeight(50);
		scrollPane_7.setViewportView(list);


		///////////////////////Drikkeknapper/////////////////////////

		tglbtnCola = new JButton("Cola");
		tglbtnCola.setBounds(16, 235, 75, 45);
		bestilling.add(tglbtnCola);
		tglbtnCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Cola";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					isBrus = true;
					sisteTrykteKnapp = "Cola";
					menyKnappTrykk("Cola");
				}
			}
		});
		tglbtnFanta = new JButton("Fanta");
		tglbtnFanta.setBounds(101, 235, 75, 45);
		bestilling.add(tglbtnFanta);
		tglbtnFanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Fanta";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Fanta";
					isBrus = true;
					menyKnappTrykk("Fanta");
				}
			}
		});
		tglbtnSprite = new JButton("Sprite");
		tglbtnSprite.setBounds(183, 235, 75, 45);
		bestilling.add(tglbtnSprite);
		tglbtnSprite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Sprite";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Sprite";
					isBrus = true;
					menyKnappTrykk("Sprite");
				}
			}
		});
		tglbtnUrge = new JButton("Cola-Zero");
		tglbtnUrge.setBounds(16, 291, 75, 45);
		bestilling.add(tglbtnUrge);
		tglbtnUrge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Cola-Zero";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Cola-Zero";
					isBrus = true;
					menyKnappTrykk("Cola-Zero");
				}
			}
		});
		tglbtnFarris = new JButton("BonAqua");
		tglbtnFarris.setBounds(101, 291, 75, 45);
		bestilling.add(tglbtnFarris);
		tglbtnFarris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "BonAqua";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "BonAqua";
					isBrus = true;
					menyKnappTrykk("BonAqua");
				}
			}
		});
		tglbtnLol = new JButton("Vann");
		tglbtnLol.setBounds(183, 291, 75, 45);
		bestilling.add(tglbtnLol);
		tglbtnLol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("x ");
				if(hvorMange != ""){
					sisteTrykteKnapp = "Vann";
					isBrus = true;
					nummerKnappTrykk(hvorMange);
					hvorMange = "";
				}
				else{
					sisteTrykteKnapp = "Vann";
					isBrus = true;
					menyKnappTrykk("Vann");
				}
			}
		});



		//////////////////////"antall" kanpper///////////////////

		button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "1";
				label_2.setText("x " + hvorMange);
			}
		});
		button.setBounds(16, 403, 75, 45);
		bestilling.add(button);

		button_1 = new JButton("2");
		button_1.setBounds(101, 403, 75, 45);
		bestilling.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "2";
				label_2.setText("x " + hvorMange);
			}
		});

		btnNewButton = new JButton("3");
		btnNewButton.setActionCommand("2");
		btnNewButton.setBounds(183, 403, 75, 45);
		bestilling.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "3";
				label_2.setText("x " + hvorMange);
			}
		});

		button_2 = new JButton("4");
		button_2.setBounds(16, 459, 75, 45);
		bestilling.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "4";
				label_2.setText("x " + hvorMange);
			}
		});


		button_4 = new JButton("5");
		button_4.setBounds(101, 459, 75, 45);
		bestilling.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "5";
				label_2.setText("x " + hvorMange);
			}
		});

		button_5 = new JButton("6");
		button_5.setBounds(183, 459, 75, 45);
		bestilling.add(button_5);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "6";
				label_2.setText("x " + hvorMange);
			}
		});

		button_3 = new JButton("7");
		button_3.setBounds(16, 515, 75, 45);
		bestilling.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "7";
				label_2.setText("x " + hvorMange);
			}
		});

		button_6 = new JButton("8");
		button_6.setBounds(101, 515, 75, 45);
		bestilling.add(button_6);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "8";
				label_2.setText("x " + hvorMange);
			}
		});

		btnNewButton_1 = new JButton("9");
		btnNewButton_1.setBounds(183, 515, 75, 45);
		bestilling.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange += "9";
				label_2.setText("x " + hvorMange);
			}
		});

		button_8 = new JButton("0");
		button_8.setBounds(101, 567, 75, 45);
		bestilling.add(button_8);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hvorMange += "0";
				label_2.setText("x " + hvorMange);
			}
		});

		btnDel = new JButton("C");
		btnDel.setBounds(16, 567, 75, 45);
		bestilling.add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvorMange = "";
				label_2.setText("x " + hvorMange);
			}
		});



		btnNeste = new JButton("Neste");
		btnNeste.setForeground(new Color(47, 79, 79));
		btnNeste.setFont(new Font("Verdana", Font.BOLD, 16));
		//		btnNeste.setBackground(new Color(204, 255, 204));
		btnNeste.setBounds(831, 567, 138, 68);
		bestilling.add(btnNeste);
		btnNeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedComponent(bestillingsInfo);
				temp = new String[model.size()];
				for(int i = 0; i<model.size(); i++){
					temp[i] = (String)model.getElementAt(i);
				}
				frame.repaint();
			}
		});

		//---------------------------info---------------------------------

		bestillingsInfo = new JPanel();
		bestillingsInfo.setPreferredSize(new Dimension(500, 550));
		bestillingsInfo.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Informasjon", null, bestillingsInfo, null);
		bestillingsInfo.setLayout(null);

		navn = new JTextField();
		navn.setBounds(16, 30, 278, 28);
		bestillingsInfo.add(navn);
		navn.setColumns(10);

		nummer = new JTextField();
		nummer.setFont(new Font("Verdana", Font.BOLD, 20));
		nummer.setBounds(835, 30, 134, 28);
		bestillingsInfo.add(nummer);
		nummer.setColumns(10);
		nummer.setEditable(false);

		gatenavn = new JTextField();
		gatenavn.setBounds(16, 83, 190, 28);
		bestillingsInfo.add(gatenavn);
		gatenavn.setColumns(10);

		postnummer = new JTextField();
		postnummer.setBounds(16, 135, 133, 28);
		bestillingsInfo.add(postnummer);
		postnummer.setColumns(10);

		poststed = new JTextField();
		poststed.setBounds(160, 135, 134, 28);
		bestillingsInfo.add(poststed);
		poststed.setColumns(10);

		scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(16, 190, 190, 93);
		bestillingsInfo.add(scrollPane_9);

		kommentar = new JTextPane();
		scrollPane_9.setViewportView(kommentar);

		chckbxLevering = new JCheckBox("Levering");
		chckbxLevering.setSelected(true);
		chckbxLevering.setBounds(212, 190, 85, 23);
		bestillingsInfo.add(chckbxLevering);

		rdbtnKort = new JRadioButton("Kort");
		rdbtnKort.setSelected(true);
		buttonGroup.add(rdbtnKort);
		rdbtnKort.setBounds(213, 233, 58, 23);
		bestillingsInfo.add(rdbtnKort);

		rdbtnKontant = new JRadioButton("Kontant");
		buttonGroup.add(rdbtnKontant);
		rdbtnKontant.setBounds(212, 259, 81, 23);
		bestillingsInfo.add(rdbtnKontant);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Bestilling", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 250, 250)));
		panel_1.setBounds(335, 30, 277, 407);
		bestillingsInfo.add(panel_1);
		panel_1.setLayout(null);

		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(6, 22, 265, 379);
		panel_1.add(scrollPane_8);

		list_1 = new JList(model);
		scrollPane_8.setViewportView(list_1);

		JButton btnRediger_1 = new JButton("Rediger");
		btnRediger_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnRediger_1.setForeground(new Color(47, 79, 79));
		btnRediger_1.setBounds(182, 0, 89, 23);
		panel_1.add(btnRediger_1);
		btnRediger_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedComponent(bestilling);
			}
		});

		JLabel lblFulltNavn = new JLabel("Fullt navn");
		lblFulltNavn.setBounds(16, 12, 133, 14);
		bestillingsInfo.add(lblFulltNavn);

		JLabel lblGatenavn = new JLabel("Gatenavn");
		lblGatenavn.setBounds(16, 69, 111, 14);
		bestillingsInfo.add(lblGatenavn);

		husnummer = new JTextField();
		husnummer.setBounds(216, 83, 55, 28);
		bestillingsInfo.add(husnummer);
		husnummer.setColumns(10);

		JLabel lblHusnr = new JLabel("Husnummer");
		lblHusnr.setBounds(218, 70, 90, 14);
		bestillingsInfo.add(lblHusnr);

		lblPostnummer = new JLabel("Postnummer");
		lblPostnummer.setBounds(16, 122, 133, 14);
		bestillingsInfo.add(lblPostnummer);

		lblPoststed = new JLabel("Poststed");
		lblPoststed.setBounds(159, 122, 135, 14);
		bestillingsInfo.add(lblPoststed);

		lblKommentar = new JLabel("Kommentar");
		lblKommentar.setBounds(16, 174, 190, 14);
		bestillingsInfo.add(lblKommentar);

		lblRingendeNummer = new JLabel("Ringende nummer");
		lblRingendeNummer.setBounds(835, 12, 134, 14);
		bestillingsInfo.add(lblRingendeNummer);


		JButton btnNeste_1 = new JButton("Send");
		btnNeste_1.setForeground(new Color(47, 79, 79));
		btnNeste_1.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNeste_1.setBackground(new Color(204, 255, 204));
		btnNeste_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				tabbedPane.setSelectedComponent(bestilling);
				String tmp = "";
				try{
					User u = DatabaseConnector.getUser(nummer.getText());
					
					u.getAddress().setStreet(gatenavn.getText());
					u.getAddress().setHouseNumber(Integer.parseInt(husnummer.getText()));
					u.getAddress().setZipcode(postnummer.getText());
					u.getAddress().setCity(poststed.getText());
					u.getAddress().save();
					getUsers();
					getOrders();
					if (!u.getAddress().save()) {
						JOptionPane.showMessageDialog(null, "Klarte ikke lagre adresse i databasen", "Database-error",  JOptionPane.ERROR_MESSAGE);

					}
					frame.repaint();

					Order order = new Order(DatabaseConnector.getUser(nummer.getText()).getId());
					order.setProducts(temp);
					order.setKommentar(kommentar.getText());
					if(chckbxLevering.isSelected())
						q = 1;
					else
						q = 0;
					order.setLevering(q);
					if(rdbtnKort.isSelected())
						w = 1;
					else
						w = 0;
					order.setKort(w);
					temp=null;
					navn.setText("");
					nummer.setText("");
					gatenavn.setText("");
					postnummer.setText("");
					poststed.setText("");
					kommentar.setText("");
					husnummer.setText("");
					model.clear();
					DatabaseConnector.newOrder(order);
					getOrders();

				}catch(Exception e){
					if(DEBUG){
						e.printStackTrace();						
					}
					try{
						Address a = new Address(gatenavn.getText(), Integer.parseInt(husnummer.getText()), postnummer.getText(), poststed.getText());
						User u = new User(navn.getText(), nummer.getText(), a);
						DatabaseConnector.newUser(u);
						getUsers();
						//This time the user have been created and is in the database
						Order order = new Order(DatabaseConnector.getUser(nummer.getText()).getId());
						order.setProducts(temp);
						order.setKommentar(kommentar.getText());
						temp=null;
						DatabaseConnector.newOrder(order);
						getOrders();
						navn.setText("");
						nummer.setText("");
						gatenavn.setText("");
						postnummer.setText("");
						poststed.setText("");
						kommentar.setText("");
						husnummer.setText("");
						model.clear();
						chckbxLevering.setSelected(false);
						rdbtnKort.setSelected(false);
						rdbtnKontant.setSelected(false);
						frame.repaint();
					}catch(Exception j){
						JOptionPane.showMessageDialog(null, "Klarte ikke lage ny bruker", "Send-Error",  JOptionPane.ERROR_MESSAGE);
						if(DEBUG){
							j.printStackTrace();
						}
					}
				}

			}
		});
		btnNeste_1.setBounds(831, 555, 138, 68);
		bestillingsInfo.add(btnNeste_1);
		bestillingsInfo.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{navn, nummer, gatenavn, postnummer, poststed, kommentar, husnummer}));

		//--------------------------Utgaaende/chef-----------------------------------------


		Utgaende = new JPanel();
		Utgaende.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Utg\u00E5ende", null, Utgaende, null);
		Utgaende.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ikke ferdig", TitledBorder.LEADING, TitledBorder.TOP, null, Color.ORANGE));
		panel_2.setBounds(4, 35, 241, 515);
		Utgaende.add(panel_2);
		panel_2.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 22, 229, 487);
		panel_2.add(scrollPane);
		list_3 = new JList(listModelOrders);
//		list_3.setFont(new Font("Verdana", Font.BOLD, 18));
//		list_3.setFixedCellHeight(50);
		scrollPane.setViewportView(list_3);
		list_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				focusOnFinishedOrders = false;
			}
		});
		list_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(arg0.getClickCount() == 1){
					try{
						int selected = list_3.getSelectedIndex();
						Order o = DatabaseConnector.getOrder((String)list_3.getSelectedValue());							
						showProductModel = o.getProductsStringAsDefaultListModel();
						showProductList.setModel(showProductModel);
						kvitering.setText(o.getProductsString());
						getOrders();
						if(listModelOrders.size() > 0){
							list_3.setSelectedIndex(selected);							
						}
						textArea.setText(o.getKommentar());
					}catch(Exception e){
//						JOptionPane.showMessageDialog(null, "Fant ingen produkcter i bestillingen", "Bestillings-Error",  JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(arg0.getClickCount() == 2){
					try{
						Order o = DatabaseConnector.getOrder((String)list_3.getSelectedValue());							
						DatabaseConnector.edit(o.getIdAsString());
						getOrders();
						textArea.setText("");
						showProductModel.clear();
						kvitering.setText("");
					}catch(Exception e){
//						e.printStackTrace();
					}
				}
			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ferdig", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		panel_3.setBounds(423, 35, 241, 515);
		Utgaende.add(panel_3);
		panel_3.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 22, 229, 487);
		panel_3.add(scrollPane_1);

		list_4 = new JList(listModelFinished);
//		list_4.setFont(new Font("Verdana", Font.BOLD, 18));
//		list_4.setFixedCellHeight(50);
		scrollPane_1.setViewportView(list_4);
		list_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				focusOnFinishedOrders = true;
			}
		});
		list_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(arg0.getClickCount() == 1){
					try{
						int selected = list_4.getSelectedIndex();
						Order o = DatabaseConnector.getOrder((String)list_4.getSelectedValue());							
						showProductModel = o.getProductsStringAsDefaultListModel();
						showProductList.setModel(showProductModel);
						kvitering.setText(o.getProductsString());
						getOrders();
						if(listModelFinished.size() > 0){
							list_4.setSelectedIndex(selected);							
						}
						textArea.setText(o.getKommentar());
					}catch(Exception e){
					}
				}
				else if(arg0.getClickCount() == 2){
					try{
						Order o = DatabaseConnector.getOrder((String)list_4.getSelectedValue());							
						DatabaseConnector.notFinished(o.getIdAsString());
						getOrders();
						textArea.setText("");
						showProductModel.clear();
						kvitering.setText("");
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Kunne ikke sette bestillingen til 'ikke ferdig'", "Error",  JOptionPane.ERROR_MESSAGE);

					}
				}
			}
		});

		btnLevert = new JButton("Levert");
		btnLevert.setFont(new Font("Verdana", Font.BOLD, 11));
		btnLevert.setForeground(new Color(47, 79, 79));
		btnLevert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listModelFinished.getSize()>0){
					try{
						Order o = DatabaseConnector.getOrder((String)list_4.getSelectedValue());							
						DatabaseConnector.delivered(o);
						getOrders();
						textArea.setText("");
						showProductModel.clear();
						kvitering.setText("");
					}catch(Exception ett){
						JOptionPane.showMessageDialog(null, "Velge en bestilling først", "Error",  JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnLevert.setBounds(135, 0, 100, 23);
		panel_3.add(btnLevert);

		lblAddressNotFound = new JLabel("Kunne ikke finne adresse");
		lblAddressNotFound.setForeground(new Color(255, 0, 0));
		lblAddressNotFound.setBounds(265, 72, 159, 14);
		Utgaende.add(lblAddressNotFound);
		lblAddressNotFound.setVisible(false);

		btnRedigerAdresse = new JButton("Rediger adresse");
		btnRedigerAdresse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order o = null;
				try{
					if(focusOnFinishedOrders){
						o = DatabaseConnector.getOrder((String)list_4.getSelectedValue());								
					}
					else{
						o = DatabaseConnector.getOrder((String)list_3.getSelectedValue());
					}
				}catch(Exception et){
					JOptionPane.showMessageDialog(null, "Velg en bestilling først", "Error",  JOptionPane.ERROR_MESSAGE);

				}
				try{
					Address a = DatabaseConnector.getAddressFromUser(Integer.parseInt(o.getUserId()));
					a = ChangeAddress.input(a);
					getUsers();
					kunder_list.repaint();
				}catch(Exception ed){
//					JOptionPane.showMessageDialog(null, "Fant ikke brukeren i databasen", "Error",  JOptionPane.ERROR_MESSAGE);

				}
				lblAddressNotFound.setVisible(false);
			}
		});
		btnRedigerAdresse.setBounds(255, 97, 158, 23);
		Utgaende.add(btnRedigerAdresse);

		JButton btnVisKart = new JButton("Vis kart");
		btnVisKart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Order o;
					if(focusOnFinishedOrders){
						o = DatabaseConnector.getOrder((String)list_4.getSelectedValue());
					}
					else{	
						o = DatabaseConnector.getOrder((String)list_3.getSelectedValue());
					}
					String telefonNummer = DatabaseConnector.getPhoneByUserId(Integer.parseInt(o.getUserId()));
					User u = DatabaseConnector.getUser(telefonNummer);

					String tmp = u.getAddress().getStreet();
					String tmp2 = u.getAddress().getCity();
					if (u.getAddress().getStreet().contains(" ") ||
							u.getAddress().getStreet().contains("æ") ||
							u.getAddress().getStreet().contains("Æ") ||
							u.getAddress().getStreet().contains("ø") ||
							u.getAddress().getStreet().contains("Ø") ||
							u.getAddress().getStreet().contains("å") ||
							u.getAddress().getStreet().contains("Å")
							) {
						tmp = tmp.replace(' ' , '+');
						tmp = tmp.replace('æ' , 'e');
						tmp = tmp.replace('ø' , 'o');
						tmp = tmp.replace('å' , 'a');
						tmp = tmp.replace('Æ' , 'e');
						tmp = tmp.replace('Ø' , 'o');
						tmp = tmp.replace('Å' , 'a');
					}
					if (u.getAddress().getCity().contains(" ") ||
							u.getAddress().getCity().contains("æ") ||
							u.getAddress().getCity().contains("Æ") ||
							u.getAddress().getCity().contains("ø") ||
							u.getAddress().getCity().contains("Ø") ||
							u.getAddress().getCity().contains("å") ||
							u.getAddress().getCity().contains("Å")
							) {
						tmp2 = tmp.replace(' ' , '+');
						tmp2 = tmp.replace('æ' , 'e');
						tmp2 = tmp.replace('ø' , 'o');
						tmp2 = tmp.replace('å' , 'a');
						tmp2 = tmp.replace('Æ' , 'e');
						tmp2 = tmp.replace('Ø' , 'o');
						tmp2 = tmp.replace('Å' , 'a');
					}
					String constant = "http://maps.google.com/maps/api/staticmap?zoom=15&size=400x400&sensor=false&markers=";
					String url = tmp + "&" + String.valueOf(u.getAddress().getHouseNumber()) + "&" + u.getAddress().getZipcode() + "&" + tmp2 + ",norway";
					String tittle = u.getAddress().getStreet() + " " + String.valueOf(u.getAddress().getHouseNumber()) + ", " + u.getAddress().getCity();
					map.call(constant + url, tittle);	
					lblAddressNotFound.setVisible(false);
				}catch(Exception e){
//					JOptionPane.showMessageDialog(null, "Velg en bestilling først", "Kart",  JOptionPane.ERROR_MESSAGE);
					lblAddressNotFound.setVisible(true);
					btnRedigerAdresse.setVisible(true);
				}
			}
		});
		btnVisKart.setForeground(new Color(47, 79, 79));
		btnVisKart.setFont(new Font("Verdana", Font.BOLD, 16));
		btnVisKart.setBounds(255, 18, 158, 50);
		Utgaende.add(btnVisKart);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(257, 151, 153, 195);
		Utgaende.add(scrollPane_2);


		showProductList = new JList(showProductModel);
		scrollPane_2.setViewportView(showProductList);

		panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Kvitering", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 250, 250)));
		panel_4.setBounds(676, 35, 297, 515);
		Utgaende.add(panel_4);
		panel_4.setLayout(null);

		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(6, 22, 285, 487);
		panel_4.add(scrollPane_4);

		kvitering = new JTextPane();
		scrollPane_4.setViewportView(kvitering);
		kvitering.setContentType("text/html");
		kvitering.setEditable(false);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(255, 399, 158, 151);
		Utgaende.add(scrollPane_3);

		textArea = new JTextArea();
		scrollPane_3.setViewportView(textArea);
		textArea.setEditable(false);

		JButton btnNewButton_2 = new JButton("Slett");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Order o;
				try {
					o = DatabaseConnector.getOrder((String)list_3.getSelectedValue());
					DatabaseConnector.deleteOrder(o);
					getOrders();
					textArea.setText("");
					showProductModel.clear();
					kvitering.setText("");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Velg en bestilling først", "Error",  JOptionPane.ERROR_MESSAGE);
				}							
			}
		});
		btnNewButton_2.setBounds(257, 358, 154, 29);
		Utgaende.add(btnNewButton_2);




		//------------------------Rediger-------------------------------------------------

		Rediger = new JPanel();
		Rediger.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Rediger", null, Rediger, null);
		Rediger.setLayout(null);

		btnIncall = new JButton("Incall");

		btnIncall.setBackground(new Color(238, 238, 238));
		btnIncall.setForeground(new Color(47, 79, 79));
		btnIncall.setFont(new Font("Verdana", Font.BOLD, 16));
		btnIncall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nr = JOptionPane.showInputDialog(null, "Hvilket nummer som skal ringe", "Skriv inn tlf", 3);
				nummer.setText(nr);
				try{
					User user = (User)DatabaseConnector.getUser(nr);
					navn.setText(user.getName());
					gatenavn.setText(user.getAddress().getStreet());
					husnummer.setText(String.valueOf(user.getAddress().getHouseNumber()));
					postnummer.setText(user.getAddress().getZipcode());
					poststed.setText(user.getAddress().getCity());
				}catch(Exception ee){
					JOptionPane.showMessageDialog(null, "Ny kunde", "Melding", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnIncall.setBounds(848, 11, 121, 45);
		bestilling.add(btnIncall);


		//REDIGER TABBEN
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 11, 962, 612);
		Rediger.add(tabbedPane_1);

		kunder = new JPanel();
		kunder.setBackground(new Color(255, 250, 250));
		tabbedPane_1.addTab("Kunder", null, kunder, null);
		kunder.setLayout(null);

		panel_5 = new JPanel();
		panel_5.setForeground(Color.BLACK);
		panel_5.setBackground(Color.GRAY);
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Kunder", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 250, 250)));
		panel_5.setBounds(710, 64, 225, 496);
		kunder.add(panel_5);
		panel_5.setLayout(null);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(6, 22, 213, 468);
		panel_5.add(scrollPane_5);

		kunder_list = new JList(listmodelUsers);
//		kunder_list.setFont(new Font("Verdana", Font.BOLD, 18));
//		kunder_list.setFixedCellHeight(50);
		scrollPane_5.setViewportView(kunder_list);
		kunder_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() == 1){
					int selectedIndex = kunder_list.getSelectedIndex();
					User user = (User)m1.getElementAt(selectedIndex);
					redigerNavn.setText(user.getName());
					redigerNummer.setText(user.getPhone());
					redigerAdresse.setText(user.getAddress().getStreet());
					redigerHusNr.setText(String.valueOf(user.getAddress().getHouseNumber()));
					redigerPostNummer.setText(user.getAddress().getZipcode());
					redigerPostSted.setText(user.getAddress().getCity());
//					Rediger_1.setVisible(true);
//					leggTil.setVisible(false);
				}
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(arg0.getClickCount() == 1){
					int selectedIndex = kunder_list.getSelectedIndex();
					User user = (User)m1.getElementAt(selectedIndex);
					redigerNavn.setText(user.getName());
					redigerNummer.setText(user.getPhone());
					redigerAdresse.setText(user.getAddress().getStreet());
					redigerHusNr.setText(String.valueOf(user.getAddress().getHouseNumber()));
					redigerPostNummer.setText(user.getAddress().getZipcode());
					redigerPostSted.setText(user.getAddress().getCity());
				}
			}
		});

		leggTil = new JButton("Ny kunde");
		leggTil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Address address = new Address(redigerAdresse.getText(), Integer.parseInt(redigerHusNr.getText()), redigerPostNummer.getText(), redigerPostSted.getText());
				try{
					DatabaseConnector.newUser(new User(redigerNavn.getText(), redigerNummer.getText(), address));					
					getUsers();
					redigerNummer.setText("");
					redigerNavn.setText("");
					redigerHusNr.setText("");
					redigerAdresse.setText("");
					redigerPostNummer.setText("");
					redigerPostSted.setText("");
				}catch(Exception et){
					JOptionPane.showMessageDialog(null, "Kunne ikke legge til kunde i databasen", "Database-error",  JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		leggTil.setBounds(10, 420, 100, 41);
		kunder.add(leggTil);
		

		Slett = new JButton("Slett");
		Slett.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = kunder_list.getSelectedIndex();
				User user = (User)m1.getElementAt(id);
				try{
					DatabaseConnector.getOrder(user.getId()).getUserId();
					DatabaseConnector.deleteUser(user);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Kunden har bestillinger, kan ikke slettes");
				}
				getUsers();
			}
		});
		Slett.setBounds(835, 20, 100, 41);
		kunder.add(Slett);
		Slett.setVisible(false);

		Rediger_1 = new JButton("Oppdater");
		Rediger_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Address address = new Address(redigerAdresse.getText(), Integer.parseInt(redigerHusNr.getText()), redigerPostNummer.getText(), redigerPostSted.getText());
				User newUser = new User(redigerNavn.getText(), redigerNummer.getText(), address);
				User oldUser = (User)m1.getElementAt(kunder_list.getSelectedIndex());
				DatabaseConnector.edit(oldUser, newUser);
				getUsers();
				redigerNummer.setText("");
				redigerNavn.setText("");
				redigerHusNr.setText("");
				redigerAdresse.setText("");
				redigerPostNummer.setText("");
				redigerPostSted.setText("");
//				Rediger_1.setVisible(false);
//				leggTil.setVisible(true);
			}
		});
		Rediger_1.setBounds(122, 420, 100, 41);
		kunder.add(Rediger_1);
//		Rediger_1.setVisible(false);

		redigerNavn = new JTextField();
		redigerNavn.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerNavn.setBounds(10, 64, 408, 60);
		kunder.add(redigerNavn);
		redigerNavn.setColumns(10);

		redigerNummer = new JTextField();
		redigerNummer.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerNummer.setBounds(453, 64, 230, 60);
		kunder.add(redigerNummer);
		redigerNummer.setColumns(10);

		redigerAdresse = new JTextField();
		redigerAdresse.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerAdresse.setBounds(10, 199, 480, 60);
		kunder.add(redigerAdresse);
		redigerAdresse.setColumns(10);

		redigerHusNr = new JTextField();
		redigerHusNr.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerHusNr.setBounds(530, 199, 86, 60);
		kunder.add(redigerHusNr);
		redigerHusNr.setColumns(10);

		redigerPostNummer = new JTextField();
		redigerPostNummer.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerPostNummer.setBounds(10, 326, 130, 60);
		kunder.add(redigerPostNummer);
		redigerPostNummer.setColumns(10);

		redigerPostSted = new JTextField();
		redigerPostSted.setFont(new Font("Verdana", Font.PLAIN, 16));
		redigerPostSted.setBounds(175, 326, 445, 60);
		kunder.add(redigerPostSted);
		redigerPostSted.setColumns(10);

		redigerPostSted.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent arg) {
				if (arg.getKeyCode() != arg.VK_ENTER) {
					return;
				}

				Address address = new Address(redigerAdresse.getText(), Integer.parseInt(redigerHusNr.getText()), redigerPostNummer.getText(), redigerPostSted.getText());
				User newUser = new User(redigerNavn.getText(), redigerNummer.getText(), address);
				User oldUser = (User)m1.getElementAt(kunder_list.getSelectedIndex());
				DatabaseConnector.edit(oldUser, newUser);
				getUsers();
			}
		});



		JLabel lblFulltNavn_1 = new JLabel("Fullt Navn");
		lblFulltNavn_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFulltNavn_1.setBounds(10, 24, 408, 28);
		kunder.add(lblFulltNavn_1);

		JLabel lblTelefonNummer = new JLabel("Telefonnummer");
		lblTelefonNummer.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTelefonNummer.setBounds(453, 24, 230, 28);
		kunder.add(lblTelefonNummer);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAdresse.setBounds(10, 156, 480, 32);
		kunder.add(lblAdresse);

		JLabel lblNr = new JLabel("Nr");
		lblNr.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNr.setBounds(530, 156, 86, 32);
		kunder.add(lblNr);

		JLabel redigerPostNummerlbl = new JLabel("Postnummer");
		redigerPostNummerlbl.setFont(new Font("Verdana", Font.BOLD, 14));
		redigerPostNummerlbl.setBounds(10, 283, 130, 32);
		kunder.add(redigerPostNummerlbl);

		JLabel lblPoststed_1 = new JLabel("Poststed");
		lblPoststed_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPoststed_1.setBounds(175, 283, 441, 32);
		kunder.add(lblPoststed_1);

		button_7 = new JButton("T\u00F8m felter");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				redigerNummer.setText("");
				redigerNavn.setText("");
				redigerHusNr.setText("");
				redigerAdresse.setText("");
				redigerPostNummer.setText("");
				redigerPostSted.setText("");
//				Rediger_1.setVisible(false);
//				leggTil.setVisible(true);
			}
		});
		button_7.setBounds(510, 420, 110, 41);
		kunder.add(button_7);
		kunder.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{redigerNavn, redigerNummer, redigerAdresse, redigerHusNr, redigerPostNummer, redigerPostSted}));

		JPanel retter = new JPanel();
		retter.setBackground(new Color(255, 250, 250));
		tabbedPane_1.addTab("Retter", null, retter, null);
		retter.setLayout(null);

		panel_6 = new JPanel();
		panel_6.setBackground(Color.GRAY);
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Produkter", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 250, 250)));
		panel_6.setBounds(710, 64, 225, 496);
		retter.add(panel_6);
		panel_6.setLayout(null);

		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(6, 22, 213, 468);
		panel_6.add(scrollPane_6);

		retter_list = new JList(listModelProducts);
//		retter_list.setFont(new Font("Verdana", Font.BOLD, 18));
//		list.setFixedCellHeight(50);
		scrollPane_6.setViewportView(retter_list);
		retter_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					Product product = (Product)m2.getElementAt(retter_list.getSelectedIndex());
					retterNavn.setText(product.getName());
					retterPris.setText(String.valueOf(product.getPrice()));
					retterKommentar.setText(product.getDescription());
					pizzanr.setText(String.valueOf(product.getNr()));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getClickCount() == 1){
					Product product = (Product)m2.getElementAt(retter_list.getSelectedIndex());
					retterNavn.setText(product.getName());
					retterPris.setText(String.valueOf(product.getPrice()));
					retterKommentar.setText(product.getDescription());
					pizzanr.setText(String.valueOf(product.getNr()));
				}
			}
		});

		rediger_retter = new JButton("Oppdater");
		rediger_retter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Product oldProduct = (Product)m2.getElementAt(retter_list.getSelectedIndex());
					Product newProduct = new Product(retterNavn.getText(), retterKommentar.getText(), Double.parseDouble(retterPris.getText()), Integer.parseInt(pizzanr.getText()));
					DatabaseConnector.edit(oldProduct, newProduct);
					getProducts();
					retterNavn.setText("");
					retterKommentar.setText("");
					retterPris.setText("");
					pizzanr.setText("");
				}catch(Exception ee){
//					ee.printStackTrace();
				}
			}
		});
		rediger_retter.setBounds(122, 420, 100, 41);
		retter.add(rediger_retter);

		leggTil_retter = new JButton("Ny rett");
		leggTil_retter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Product product = new Product(retterNavn.getText(), retterKommentar.getText(), Double.parseDouble(retterPris.getText()), Integer.parseInt(pizzanr.getText()));
					DatabaseConnector.newProduct(product);
					getProducts();
					retterNavn.setText("");
					retterKommentar.setText("");
					retterPris.setText("");
					pizzanr.setText("");
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Klarte ikke legge til kunde i databasen", "Database-Error",  JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		leggTil_retter.setBounds(10, 420, 100, 41);
		retter.add(leggTil_retter);

		leggTil_retter_1 = new JButton("Slett");
		leggTil_retter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean bool = true;
				try{
					DatabaseConnector.deleteProduct((Product)m2.getElementAt(retter_list.getSelectedIndex()));
					getProducts();	
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Produktet ligger i en bestilling, kan ikke slettes");
				}
			}
		});
		leggTil_retter_1.setBounds(835, 20, 100, 41);
		retter.add(leggTil_retter_1);

		retterNavn = new JTextField();
		retterNavn.setFont(new Font("Verdana", Font.PLAIN, 16));
		retterNavn.setColumns(10);
		retterNavn.setBounds(10, 64, 408, 60);
		retter.add(retterNavn);

		retterPris = new JTextField();
		retterPris.setFont(new Font("Verdana", Font.PLAIN, 16));
		retterPris.setColumns(10);
		retterPris.setBounds(453, 64, 156, 60);
		retter.add(retterPris);

		scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(10, 199, 408, 202);
		retter.add(scrollPane_10);

		retterKommentar = new JTextPane();
		scrollPane_10.setViewportView(retterKommentar);
		retterKommentar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == arg0.VK_ENTER){
					try{
						Product product = new Product(retterNavn.getText(), retterKommentar.getText(), Double.parseDouble(retterPris.getText()), Integer.parseInt(pizzanr.getText()));
						DatabaseConnector.newProduct(product);
						getProducts();
						retterNavn.setText("");
						retterKommentar.setText("");
						retterPris.setText("");
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Klarte ikke legge til produkt i databasen", "Database-error",  JOptionPane.ERROR_MESSAGE);

					}					
				}
			}
		});
		retterKommentar.setFont(new Font("Verdana", Font.PLAIN, 16));

		lblProduktnavn = new JLabel("Produktnavn");
		lblProduktnavn.setFont(new Font("Verdana", Font.BOLD, 14));
		lblProduktnavn.setBounds(10, 24, 408, 28);
		retter.add(lblProduktnavn);

		lblPris = new JLabel("Pris");
		lblPris.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPris.setBounds(453, 24, 156, 28);
		retter.add(lblPris);

		lblBeskrivelse = new JLabel("Kommentar");
		lblBeskrivelse.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBeskrivelse.setBounds(10, 158, 408, 30);
		retter.add(lblBeskrivelse);

		JButton btnTmFelter = new JButton("T\u00F8m felter");
		btnTmFelter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				retterKommentar.setText("");
				retterNavn.setText("");
				retterPris.setText("");
				pizzanr.setText("");
			}
		});
		btnTmFelter.setBounds(510, 420, 110, 41);
		retter.add(btnTmFelter);
		
		pizzanr = new JTextField();
		pizzanr.setBounds(453, 199, 156, 60);
		retter.add(pizzanr);
		pizzanr.setColumns(10);
		
		JLabel lblPizzanummer = new JLabel("Pizzanummer");
		lblPizzanummer.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPizzanummer.setBounds(450, 168, 159, 14);
		retter.add(lblPizzanummer);
		retter.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{retterNavn, retterPris, retterKommentar, pizzanr}));


		//____COMBOBOX FOR ASSOSIATING DISHES TO BUTTONS
		String[] boxComponents = {"Nr.1", "Nr.2", "Nr.3", "Nr.4", "Nr.5", "Nr.6", "Nr.7", "Nr.8", "Nr.9"};
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		buttons.add(toggleButton);buttons.add(toggleButton_1);buttons.add(toggleButton_2);
		buttons.add(toggleButton_3);buttons.add(toggleButton_4);buttons.add(toggleButton_5);
		buttons.add(toggleButton_6);buttons.add(toggleButton_7);buttons.add(toggleButton_8);
		pizzaInfo.setForeground(Color.DARK_GRAY);


		pizzaInfo.setBounds(700, 68, 269, 492);
		bestilling.add(pizzaInfo);

		label_2 = new JLabel("x ");
		label_2.setBounds(16, 375, 219, 16);
		bestilling.add(label_2);


		menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(new Color(0, 0, 0));
		frame.setJMenuBar(menuBar);

//		label_1 = new JLabel(new ImageIcon("src/Bilder/exit.gif"));
//		label_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				System.exit(0);
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				label_1.setIcon(new ImageIcon("src/Bilder/exit_on.gif"));
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				label_1.setIcon(new ImageIcon("src/Bilder/exit.gif"));
//			}
//		});
//		menuBar.add(label_1);
//		label_1.setToolTipText("Avslutter Programmet");

		JMenu mnHjelp = new JMenu("Hjelp");
		mnHjelp.setBackground(Color.BLACK);
		mnHjelp.setForeground(Color.DARK_GRAY);
		menuBar.add(mnHjelp);

		JMenuItem mntmInstruksjoner = new JMenuItem("Instruksjoner");
		mntmInstruksjoner.setBackground(new Color(255, 250, 250));
		mntmInstruksjoner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					Instruksjoner.run();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Klarte ikke åpne instruksjoner", "Error",  JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnHjelp.add(mntmInstruksjoner);

		JMenuItem mntmOm = new JMenuItem("Om");
		mntmOm.setBackground(new Color(255, 250, 250));
		mntmOm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Om.run();
			}
		});
		
		JMenu mnInstillinger = new JMenu("Instillinger");
		mnHjelp.add(mnInstillinger);
		
		JMenuItem mntmLeveringspris = new JMenuItem("Leveringspris");
		mntmLeveringspris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPasswordField pwd = new JPasswordField(10);
				JOptionPane.showConfirmDialog(null, pwd, "Skriv inn passord", JOptionPane.OK_CANCEL_OPTION);
				char[] c = pwd.getPassword();
				if(isPasswordCorrect(c)){
					String s = JOptionPane.showInputDialog(null, "Skriv inn ny leveringspris");
					DatabaseConnector.setDeliveryPrice(s);
				}
				else
					JOptionPane.showMessageDialog(null, "Feil passord!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		mnInstillinger.add(mntmLeveringspris);
		
		JMenuItem mntmPrisgrenseGratisLevering = new JMenuItem("Prisgrense gratis levering");
		mntmPrisgrenseGratisLevering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPasswordField pwd = new JPasswordField(10);
				JOptionPane.showConfirmDialog(null, pwd, "Skriv inn passord", JOptionPane.OK_CANCEL_OPTION);
				char[] c = pwd.getPassword();
				if(isPasswordCorrect(c)){
					String s = JOptionPane.showInputDialog(null, "Skriv inn ny prisgrense for gratis levering");
					DatabaseConnector.setPriceLimit(s);
				}
				
				else
					JOptionPane.showMessageDialog(null, "Feil passord!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		mnInstillinger.add(mntmPrisgrenseGratisLevering);
		mnHjelp.add(mntmOm);

		JMenu mnHistorie = new JMenu("Historikk");
		mnHistorie.setBackground(Color.BLACK);
		mnHistorie.setForeground(Color.DARK_GRAY);
		menuBar.add(mnHistorie);

		JMenuItem mntmOrdrehistorikk = new JMenuItem("Ordrehistorikk");
		mntmOrdrehistorikk.setBackground(new Color(255, 250, 250));
		mntmOrdrehistorikk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				History.run();				
			}
		});
		mnHistorie.add(mntmOrdrehistorikk);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{navn, gatenavn, husnummer, postnummer, poststed, kommentar, redigerNavn, redigerNummer, redigerAdresse, redigerHusNr, redigerPostNummer, redigerPostSted, retterNavn, retterPris, retterKommentar}));
//		frame.setUndecorated(true);
	}
	/**
	 * Henter produkter fra databasen og lager en liste over rettene.
	 */
	public void lagListe(){
		try{
			getProducts();
			String pizzaListe = "<html>";
			for (int j = 0; j < m2.size(); j++) {
				Product p = (Product)m2.getElementAt(j);
				if(p.getNr() != 0){
					pizzaListe += "#" + p.getNr() + " " + p.toString() + "<br>" + p.getDescription() + "<br><br>";					
				}
			}
			pizzaInfo.setText(pizzaListe + "</html>");
		}catch(Exception eee){
			//			eee.printStackTrace();
			System.out.println("Finnes ingen produkter i database");
			JOptionPane.showMessageDialog(null, "Finnes ingen produkter i databasen\nGå til Rediger > Retter og legg inn retter");
		}
	}
	/**
	 * 
	 * @param String a, navnet på pizzaen eller brusen som ble sist trykt på
	 * @return String a;
	 */
	private String menyKnappTrykk(String a) {
		if (isBrus) {
			for (int i = 0; i < model.getSize(); i++) {
				if (model.get(i).toString().charAt(model.get(i).toString().length()-3) == a.charAt(a.length()-3)) {
					nummerKnappTrykk("1");
					return a;
				}
			}
			isBrus = false;
			model.addElement("1" +" x "+a);
			return a;
		}
		for (int i = 0; i < model.getSize(); i++) {
			if (model.get(i).toString().charAt(model.get(i).toString().length()-1) == a.charAt(a.length()-1)) {
				nummerKnappTrykk("1");
				return a;
			}
		}
		model.addElement("1" +" x "+a); 
		return a;
	}
	/**
	 * Tar inn et antall og skriver dette antall pizza inn i en bestilling.
	 * @param nr, antallet som er blitt valgt.
	 * @return null
	 */
	private String nummerKnappTrykk(String nr){
		if (isBrus) {
			isBrus = false;
			if(model.isEmpty()){
				model.addElement(hvorMange + " x " + sisteTrykteKnapp);
				hvorMange = "";
				isBrus = false;
				return null;
			}
			for (int i = 0; i < model.getSize(); i++) {
				if(model.get(i).toString().charAt(model.get(i).toString().length()-3) == sisteTrykteKnapp.charAt(sisteTrykteKnapp.length()-3)){
					int teller = 0, temp = 0;
					String tmp = "";
					while(model.get(i).toString().charAt(teller) != ' '){
						tmp += model.get(i).toString().charAt(teller);
						teller++;
					}
					temp = Integer.parseInt(tmp) + Integer.parseInt(nr);
					Object o = model.remove(i);
					o = (temp + " x " + sisteTrykteKnapp);
					model.add(i, o);
					hvorMange = "";
					isBrus = false;
					return null;
				}
			}
			model.addElement(hvorMange + " x " + sisteTrykteKnapp);
			hvorMange = "";
			return null;
		}
		if(model.isEmpty()){
			model.addElement(hvorMange + " x " + sisteTrykteKnapp);
			hvorMange = "";
			return null;
		}

		for (int i = 0; i < model.getSize(); i++) {
			if(model.get(i).toString().charAt(model.get(i).toString().length()-1) == sisteTrykteKnapp.charAt(sisteTrykteKnapp.length()-1)){
				int teller = 0, temp = 0;
				String tmp = "";
				while(model.get(i).toString().charAt(teller) != ' '){
					tmp += model.get(i).toString().charAt(teller);
					teller++;
				}
				temp = Integer.parseInt(tmp) + Integer.parseInt(nr);
				Object o = model.remove(i);
				o = (temp + " x " + sisteTrykteKnapp);
				model.add(i, o);
				hvorMange = "";
				return null;
			}
		}
		model.addElement(hvorMange + " x " + sisteTrykteKnapp);
		hvorMange = "";
		return null;
	}
	/**
	 * Get or refresh all products
	 */
	public void getProducts(){
		try{
			//m2 inneholder Product objektene, mens listModelProducts inneholder Product.toString();
			m2 = DatabaseConnector.getProducts();
			listModelProducts.clear();
			for(int i = 0; i<m2.size(); i++){
				Product pr = (Product)m2.getElementAt(i);
				listModelProducts.addElement(m2.getElementAt(i).toString());
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Fant ingen produkter i databasen", "Database",  JOptionPane.INFORMATION_MESSAGE);
		}
	}
	/**
	 * Get or refresh all users
	 * @uml.property  name="users"
	 */
	public void getUsers(){
		try{
			m1 = DatabaseConnector.getUsers();		
			listmodelUsers.clear();
			//m1 inneholder objektene USERS, listmodelUsers inneholder user.toString();
			for(int i = 0; i<m1.size(); i++){
				User user = (User)m1.getElementAt(i);
				listmodelUsers.addElement(m1.getElementAt(i).toString());
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Fant ingen kunder i databasen", "Database",  JOptionPane.INFORMATION_MESSAGE);
		}
	}
	/**
	 * Get or refresh all orders
	 */
	public void getOrders(){
		try{
			listModelOrders.clear();
			listModelFinished.clear();
			//ordre som ikke er påbegynt
			m3 = DatabaseConnector.getOrders("due");
			if(m3 != null){
				for(int i = 0; i<m3.size(); i++){
					Order o = (Order)m3.getElementAt(i);
					listModelOrders.addElement(o.toString());
				}				
				list_3.setModel(listModelOrders);
			}
			//ordre som er påbegynt men enda ikke levert
			m4 = DatabaseConnector.getOrders("deliver");
			if(m3 != null){
				for(int i = 0; i<m4.size(); i++){
					Order o = (Order)m4.getElementAt(i);
					listModelFinished.addElement(o.toString());					
				}				
				list_4.setModel(listModelFinished);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Fant ingen bestillinger i databasen", "Database",  JOptionPane.INFORMATION_MESSAGE);

		}
	}
	/**
	 * sjekker om passord er riktig
	 * @param input
	 * @return
	 */
	private static boolean isPasswordCorrect(char[] input) {
		boolean isCorrect = true;
		char[] correctPassword = Config.PASSWORD.toCharArray();
		
		if (input.length != correctPassword.length) {
		isCorrect = false;
		} else {
		isCorrect = Arrays.equals (input, correctPassword);
		}

		//Zero out the password.
		Arrays.fill(correctPassword,'0');

		return isCorrect;
		}
	
	public static void exit(String s){
		JOptionPane.showMessageDialog(null,  s, "Feil", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
}
