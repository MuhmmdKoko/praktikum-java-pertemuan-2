package frame;

import db.Koneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Penerbit;

    public class PenerbitTambahFrame extends JFrame {
        int status;
        
        private final int SEDANG_TAMBAH = 101;
        private final int SEDANG_UBAH = 102;
        
        JLabel jLabel1 = new JLabel("Id");
        JLabel jLabel2 = new JLabel("Penerbit");
        
        JTextField eId = new JTextField();
        JTextField ePenerbit = new JTextField();
        
        JButton bSimpan = new JButton("Simpan");
        JButton bBatal = new JButton("Refresh");

    
    public void setKomponen(){
        getContentPane().setLayout (null);
        getContentPane().add(jLabel1);
        getContentPane().add(jLabel2);
        getContentPane().add(eId);
        getContentPane().add(ePenerbit);
        getContentPane().add(bSimpan); 
        getContentPane().add(bBatal); 

        jLabel1.setBounds (70,10,50,25); 
        jLabel2.setBounds (30,40,50,25);
        
        eId.setBounds (100,10,50,25); 
        ePenerbit.setBounds (100,40,270,25); 
                
        bSimpan.setBounds (160,70,100,25); 
        bBatal.setBounds (270,10,100,25); 

        eId.setEditable(false);
        setVisible(true);
        ePenerbit.requestFocus();
        setListener();
    
    }
    
    public PenerbitTambahFrame(){
        status = SEDANG_TAMBAH;
        setSize(420,180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setKomponen();
    }
    
    public PenerbitTambahFrame(Penerbit penerbit){
        status = SEDANG_UBAH;
        setSize(420,180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        eId.setText(String.valueOf(penerbit.getId()));
        ePenerbit.setText(penerbit.getPenerbit());
        setKomponen();
    }
    
    public void setListener(){
        bBatal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        bSimpan.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Koneksi koneksi = new Koneksi();
                    Connection con = koneksi.getConnection();
                    PreparedStatement ps;
                    if(status==SEDANG_TAMBAH){
                        String executeQuery = "insert into penerbit (penerbit) values (?)";
                        ps = con.prepareStatement(executeQuery);
                        ps.setString(1, ePenerbit.getText());
                    }else{
                        String executeQuery = "update penerbit set penerbit=? where id=?";
                        ps = con.prepareStatement(executeQuery);
                        ps.setString(1, ePenerbit.getText());
                        ps.setString(2, eId.getText());
                    }
                    ps.executeUpdate();
                }   catch (SQLException ex) {
                        System.err.println(ex);
                }
                dispose();
            }
        });
    }
    }