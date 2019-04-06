import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.io.*;

/**
 * @author Marin
 * @since rujan,2018 
 */

public class App {
	
	
	/*
	 * inicijalizacija JFrame,jPanel,JLabel,JTextField,JButton,JTable
	 */
	JFrame f;
	JPanel p,p1;
	JLabel tIme,tAdresa,tTel,tEmail;
	JTextField uIme,uAdresa,uTel,uEmail;
	JButton dSnimi,dIzbrisi,dOcisti,dUcitaj,dPromjeni,dUpdate;
	JTable t;
	
	
	/**
	 * konstruktor za App
	 */
	public App() {
		
		gui();
	}
	
	/**
	 * metoda za GUI ,korisnièko suèelje
	 * 
	 * pozicije za botune, polja za unos podataka 
	 * i tablica za pregledavalje imenika
	 *
	 */
	public void gui() {
		
		
		f =new JFrame("Imenik by Marin Mariniæ");
		t=new JTable();
		
		/**
		 *Postavljanje kolumni koje prestavljaju stupce za tablicu 
		 **/
		Object[] kolumne= {"Ime","Adresa","Telefon","Email"};
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(kolumne);
		
		
		/*
		 * postavljanje izgleda tablice
		 * */
		t.setModel(model);
		t.setBackground(Color.LIGHT_GRAY);
		t.setForeground(Color.black);
		Font font=new Font("",1,11);
		t.setFont(font);
		t.setRowHeight(15);
		
		/*
		 * inicijalizacija panela
		 * */
		p=new JPanel(new GridBagLayout());
		
		
		/*
		 * postavljanje teksta u panelu
		 * */
		tIme = new JLabel("Ime:");
		tAdresa = new JLabel("Adresa:");		
		tTel = new JLabel("Telefon:");
		tEmail = new JLabel("Email:");
		
		/*
		 * postavljanje polja za unos podataka
		 * */
		
		uIme=new JTextField(20);
		uAdresa=new JTextField(20);
		uTel=new JTextField(20);
		uEmail=new JTextField(20);
		
		
		/*
		 *postavljanje botuna za obradu unesenih podataka
		 * */
		dSnimi = new JButton("Snimi");
		dIzbrisi = new JButton("Izbrisi kontakt");
		dOcisti = new JButton("Ocisti");
		dUcitaj = new JButton("Ucitaj Imenik");
		dPromjeni=new JButton("Promjeni Imenik");
		dUpdate =new JButton("Ubaci u tablicu");
		
		
		/*
		 * postavljanje objekata i metoda za botune
		 * */
		Snimac snimi = new Snimac();
		dSnimi.addActionListener(snimi);
		Brisac brisi = new Brisac();
		dIzbrisi.addActionListener(brisi);
		Cistac cisti = new Cistac();
		dOcisti.addActionListener(cisti);
		Ucitaj ucita=new Ucitaj();
		dUcitaj.addActionListener(ucita);
		Promjeni promjena=new Promjeni();
		dPromjeni.addActionListener(promjena);
		Update update=new Update();
		dUpdate.addActionListener(update);
		
		JScrollPane pane=new JScrollPane(t);
		
		/*
		 * dodavanje panela u frame
		 * */
		f.add(p,BorderLayout.WEST);
		f.add(pane,BorderLayout.EAST);
		
		
		/*
		 * postavljanje pozicija botuna,teksta i polja za unos teksta
		 * */
		GridBagConstraints mtIme =new GridBagConstraints();
		mtIme.gridx=0;
		mtIme.gridy=0;
		mtIme.insets=new Insets(5,5,5,5);
		p.add(tIme,mtIme);

		GridBagConstraints muIme =new GridBagConstraints();
		muIme.gridx=1;
		muIme.gridy=0;
		muIme.insets=new Insets(5,5,5,5);
		muIme.gridwidth=2;
		muIme.fill=GridBagConstraints.BOTH;
		p.add(uIme,muIme);
		
		GridBagConstraints mtAdresa =new GridBagConstraints();
		mtAdresa.gridx=0;
		mtAdresa.gridy=1;
		mtAdresa.insets=new Insets(5,5,5,5);
		p.add(tAdresa,mtAdresa);
		GridBagConstraints muAdresa =new GridBagConstraints();
		muAdresa.gridx=1;
		muAdresa.gridy=1;
		muAdresa.insets=new Insets(5,5,5,5);
		muAdresa.gridwidth=2;
		muAdresa.fill=GridBagConstraints.BOTH;
		p.add(uAdresa,muAdresa);
			
		GridBagConstraints mtTel =new GridBagConstraints();
		mtTel.gridx=0;
		mtTel.gridy=2;
		mtTel.insets=new Insets(5,5,5,5);
		p.add(tTel,mtTel);
		GridBagConstraints muTel =new GridBagConstraints();
		muTel.gridx=1;
		muTel.gridy=2;
		muTel.insets=new Insets(5,5,5,5);
		muTel.gridwidth=2;
		muTel.fill=GridBagConstraints.BOTH;
		p.add(uTel,muTel);
		
		GridBagConstraints mtEmail =new GridBagConstraints();
		mtEmail.gridx=0;
		mtEmail.gridy=3;
		mtEmail.insets=new Insets(5,5,5,5);
		p.add(tEmail,mtEmail);
		GridBagConstraints muEmail =new GridBagConstraints();
		muEmail.gridx=1;
		muEmail.gridy=3;
		muEmail.insets=new Insets(5,5,5,5);
		muEmail.gridwidth=2;
		muEmail.fill=GridBagConstraints.BOTH;
		p.add(uEmail,muEmail);
		
		GridBagConstraints mdSnimi =new GridBagConstraints();
		mdSnimi.gridx=0;
		mdSnimi.gridy=4;
		mdSnimi.insets=new Insets(5,5,5,5);
		p.add(dSnimi,mdSnimi);
		
		GridBagConstraints mdIzbrisi =new GridBagConstraints();
		mdIzbrisi.gridx=6;
		mdIzbrisi.gridy=4;
		mdIzbrisi.insets=new Insets(5,5,5,5);
		p.add(dIzbrisi,mdIzbrisi);
		
		GridBagConstraints mdOcisti =new GridBagConstraints();
		mdOcisti.gridx=1;
		mdOcisti.gridy=4;
		mdOcisti.insets=new Insets(5,5,5,5);
		p.add(dOcisti,mdOcisti);
		
		GridBagConstraints mdUcitaj =new GridBagConstraints();
		mdUcitaj.gridx=0;
		mdUcitaj.gridy=5;
		mdUcitaj.insets=new Insets(5,5,5,5);
		p.add(dUcitaj,mdUcitaj);
		
		GridBagConstraints mdPromjeni =new GridBagConstraints();
		mdPromjeni.gridx=0;
		mdPromjeni.gridy=6;
		mdPromjeni.insets=new Insets(5,5,5,5);
		p.add(dPromjeni,mdPromjeni);
		
		GridBagConstraints mdUpadte =new GridBagConstraints();
		mdUpadte.gridx=2;
		mdUpadte.gridy=5;
		mdUpadte.insets=new Insets(5,5,5,5);
		p.add(dUpdate,mdUpadte);
		
		f.setSize(1050, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		
		/*
		 * postavljanje actionListenera za miš kada se stisne na red
		 * u tablici da se uèitaju podaci u polja za unos podataka
		 * */
		t.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i=t.getSelectedRow();
				uIme.setText(model.getValueAt(i, 0).toString());
				uAdresa.setText(model.getValueAt(i, 1).toString());
				uTel.setText(model.getValueAt(i, 2).toString());
				uEmail.setText(model.getValueAt(i, 3).toString());
			}
		});
	}
	
	
	/*
	 * main klasa koja poziva App
	 * */
	public static void main(String[] args) {
		new App();
	}
	
		
		
		/**
		 * privatna klasa sa metodom za snimanje podataka
		 *
		 */
		private class Snimac implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				String ime=uIme.getText().toString();
				String adresa = uAdresa.getText().toString();
				String telefon = uTel.getText().toString();
				String email= uEmail.getText().toString();
				
				try {
					FileWriter writer= new FileWriter("C:\\Users\\Public\\Documents\\Kontakti.txt",true);
					writer.write(ime+"/");
					writer.write(adresa+"/");
					writer.write(telefon+"/");
					writer.write(email);
					writer.write(System.getProperty("line.separator"));
					writer.close();
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
		}
		
		
		/**
		 * privatna klasa sa metodom za brisanje kontakta iz tablice
		 *
		 */
		private class Brisac implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				DefaultTableModel model=(DefaultTableModel)t.getModel();
				int i =t.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
				}else {
					System.out.println("Greška brisanja");
				}
			}
		}
		
		
		/**
		 * privatna klasa sa metodom za brisanje podataka iz polja za unos podataka
		 *
		 */
		
		private class Cistac implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				uIme.setText("");
				uAdresa.setText("");
				uTel.setText("");
				uEmail.setText("");
			}
		}
		
		/**
		 * privatna klasa sa metodom za spremanje promjena u tablici
		 *
		 */
		
		private class Promjeni implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				try {
					File file =new File("C:\\\\Users\\\\Public\\\\Documents\\\\Kontakti.txt");
					if(!file.exists()) {
						file.createNewFile();
					}
					
					FileWriter fw=new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw =new BufferedWriter(fw);
					
					for(int i= 0;i<t.getRowCount();i++) {
						for(int j= 0;j<t.getColumnCount();j++) {
							bw.write(t.getModel().getValueAt(i,j)+"/");
						}
						bw.write("\n");
					}
					bw.close();
					fw.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				
			}
		}
		
		
		/**
		 * privatna klasa sa metodom za uèitavanje imenika
		 *
		 */
		
		private class Ucitaj implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				
				
				String filePath="C:\\\\Users\\\\Public\\\\Documents\\\\Kontakti.txt";
				File fajl=new File(filePath);
				
				
				try {
					BufferedReader br=new BufferedReader(new FileReader(fajl));
					DefaultTableModel model=(DefaultTableModel)t.getModel();
					Object[] tableLines=br.lines().toArray();
					model.setRowCount(0);
					for(int i=0; i<tableLines.length;i++) {
						String line=tableLines[i].toString().trim();
						String[] red=line.split("/");
						model.addRow(red);
						
					}
					br.close();
					
				}catch(Exception ex){
					
				}
				
			}
		}
		
		/**
		 * privatna klasa sa metodom za spremanje izmjene pojedinog kontakta
		 *
		 */
		
		private class Update implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				DefaultTableModel model=(DefaultTableModel)t.getModel();
				int i=t.getSelectedRow();
				if(i>=0) {
				model.setValueAt(uIme.getText(), i, 0);
				model.setValueAt(uAdresa.getText(),i, 1);
				model.setValueAt(uTel.getText(), i, 2);
				model.setValueAt(uEmail.getText(),i, 3);
				}else {
					System.out.println("Greška sa uèitavanjem");
				}
				}
		}
			}