/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.ArrayList;
import java.io.File;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BookController;
import controller.SingletonManager;
import model.Book;
import model.User;
import model.Enum.SearchType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GUIHomeUser implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JPanel panelAction;
    private JPanel panelRomance;
    private JPanel panelSol;
    private JPanel panelFantasy;
    private JPanel panelScifi;
    private JPanel panelHorror;
    private JPanel panelKomedi;
    private JLabel title;
    private JTextField fieldBrowse;
    private JButton browsebtn;
    private JButton userProfile;
    private JLabel imgicon1;
    private JLabel imgicon2;
    private JLabel imgicon3;
    private JLabel labelCollection1;
    private JMenuBar menubar;
    private JMenu genre;
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuItem item3;
    private JMenuItem item4;
    private JMenuItem item5;
    private JMenuItem item6;
    private JMenuItem item7;
    private String isbn;
    private String imagePath;
    BookController bc = new BookController();

    public GUIHomeUser() {
              
        frame = new JFrame("Home");
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 7 panel
        panelAction = new JPanel();
        panelRomance = new JPanel();
        panelSol = new JPanel();
        panelFantasy = new JPanel();
        panelScifi = new JPanel();
        panelHorror = new JPanel();
        panelKomedi = new JPanel();

        panelAction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRomance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelSol.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelFantasy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelScifi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelHorror.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelKomedi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAction.setVisible(false);
        panelRomance.setVisible(false);
        panelSol.setVisible(false);
        panelFantasy.setVisible(false);
        panelScifi.setVisible(false);
        panelHorror.setVisible(false);
        panelKomedi.setVisible(false);

        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title = new JLabel("WELCOME");
        title.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        fieldBrowse = new JTextField();
        panel.add(fieldBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 400, 20));

        browsebtn = new JButton("Browse");
        browsebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String searchQuery = fieldBrowse.getText();

                User loggedInUser = (User) SingletonManager.getInstance().getPerson();
                ArrayList<Book> searchResults = bc.searchBook(SearchType.GENRE, searchQuery, loggedInUser);
                new GUIBookListUser(searchResults);
            }
        });
        panel.add(browsebtn,new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));

        labelCollection1 = new JLabel("Popular Now");
        labelCollection1.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(labelCollection1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 400, 20));

        imgicon1 = new JLabel(new ImageIcon(new ImageIcon("src\\gambar\\action\\The Spirit Glass.jpg").getImage()
                .getScaledInstance(200, 300, Image.SCALE_DEFAULT)));
        imgicon1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                isbn = "978-0-123-45678-9";
                imagePath = getImagePathFromDatabase(isbn);
                new GUIDetailBuku(isbn, imagePath);
            }
        });
        panel.add(imgicon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 300, 300));

        imgicon2 = new JLabel(new ImageIcon(new ImageIcon("src\\gambar\\comedy\\Spy×Family 12.jpg").getImage()
                .getScaledInstance(200, 300, Image.SCALE_DEFAULT)));
        imgicon2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                isbn = "978-0-444-56789-0";
                imagePath = getImagePathFromDatabase(isbn);
                new GUIDetailBuku(isbn, imagePath);
            }
        });
        panel.add(imgicon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 300, 300));

        imgicon3 = new JLabel(new ImageIcon(new ImageIcon("src\\gambar\\fantasy\\Sword Catcher.jpg").getImage()
                .getScaledInstance(200, 300, Image.SCALE_DEFAULT)));
        imgicon3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                isbn = "978-0-555-12345-6";
                imagePath = getImagePathFromDatabase(isbn);
                new GUIDetailBuku(isbn, imagePath);
            }
        });
        panel.add(imgicon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 300, 300));

        menubar = new JMenuBar();
        genre = new JMenu("Genre");
        item1 = new JMenuItem("Action");
        item2 = new JMenuItem("Romance");
        item3 = new JMenuItem("Slice Of Life");
        item4 = new JMenuItem("Fantasy");
        item5 = new JMenuItem("SCI-FI");
        item6 = new JMenuItem("Horror");
        item7 = new JMenuItem("Comedy");
        genre.add(item1);
        genre.add(item2);
        genre.add(item3);
        genre.add(item4);
        // genre.add(item5);
        genre.add(item6);
        genre.add(item7);
        menubar.add(genre);

        // action listener menu bar
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        item5.addActionListener(this);
        item6.addActionListener(this);
        item7.addActionListener(this);

        userProfile = new JButton("Profile");
        userProfile.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        userProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUIUserProfile();
            }
        });
        panel.add(userProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 520, 200, 100));

        frame.add(panel);
        frame.setJMenuBar(menubar);
        frame.setVisible(true);
    }

    private String getImagePathFromDatabase(String isbn) {
        String picPath = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubespbo", "root", "")) {
            String query = "SELECT pic_path FROM book WHERE isbn=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, isbn);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        picPath = resultSet.getString("pic_path");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return picPath;
    }

    // action listener genre
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item1) {
            panel.setVisible(false);
            panelAction.setVisible(true);
            panelRomance.setVisible(false);
            panelKomedi.setVisible(false);
            panelFantasy.setVisible(false);
            panelScifi.setVisible(false);
            panelHorror.setVisible(false);
            panelSol.setVisible(false);

            frame.add(panelAction);
            ArrayList<String> pathAction = getImagePathsFromDatabase("ACTION");
            ArrayList<String> isbnAction = getISBNFromDatabase("ACTION");            
            addImageToPanel(pathAction, isbnAction, panelAction, "Action");
        } else if (e.getSource() == item2) {
            panel.setVisible(false);
            panelAction.setVisible(false);
            panelRomance.setVisible(true);
            panelKomedi.setVisible(false);
            panelFantasy.setVisible(false);
            panelScifi.setVisible(false);
            panelHorror.setVisible(false);
            panelSol.setVisible(false);

            frame.add(panelRomance);
            ArrayList<String> pathRomance = getImagePathsFromDatabase("ROMANCE");
            ArrayList<String> isbnRomance = getISBNFromDatabase("ROMANCE");
            addImageToPanel(pathRomance, isbnRomance, panelRomance, "Romance");
        } else if (e.getSource() == item3) {
            panel.setVisible(false);
            panelAction.setVisible(false);
            panelRomance.setVisible(false);
            panelKomedi.setVisible(false);
            panelFantasy.setVisible(false);
            panelScifi.setVisible(false);
            panelHorror.setVisible(false);
            panelSol.setVisible(true);

            frame.add(panelSol);
            ArrayList<String> pathSol = getImagePathsFromDatabase("SLICE OF LIFE");
            ArrayList<String> isbnSol = getISBNFromDatabase("SLICE OF LIFE");
            addImageToPanel(pathSol, isbnSol, panelSol, "Slice of Life");
        } else if (e.getSource() == item4) {
            panel.setVisible(false);
            panelAction.setVisible(false);
            panelRomance.setVisible(false);
            panelKomedi.setVisible(false);
            panelFantasy.setVisible(true);
            panelScifi.setVisible(false);
            panelHorror.setVisible(false);
            panelSol.setVisible(false);

            frame.add(panelFantasy);
            ArrayList<String> pathFantasy = getImagePathsFromDatabase("FANTASY");
            ArrayList<String> isbnFantasy = getISBNFromDatabase("FANTASY");
            addImageToPanel(pathFantasy, isbnFantasy, panelFantasy, "Fantasy");
        } else if (e.getSource() == item5) {
            panel.setVisible(false);
            panelAction.setVisible(false);
            panelRomance.setVisible(false);
            panelKomedi.setVisible(false);
            panelFantasy.setVisible(false);
            panelScifi.setVisible(false);
            panelHorror.setVisible(false);
            panelSol.setVisible(false);
            
            frame.add(panelScifi);
            ArrayList<String> pathScifi = getImagePathsFromDatabase("SCI FI");
            ArrayList<String> isbnScifi = getISBNFromDatabase("SCI FI");
            addImageToPanel(pathScifi, isbnScifi, panelScifi, "Sci fi");
        } else if (e.getSource() == item6) {
            panel.setVisible(false);
            panelAction.setVisible(false);
            panelRomance.setVisible(false);
            panelKomedi.setVisible(false);
            panelFantasy.setVisible(false);
            panelScifi.setVisible(false);
            panelHorror.setVisible(true);
            panelSol.setVisible(false);

            frame.add(panelHorror);
            ArrayList<String> pathHorror = getImagePathsFromDatabase("HORROR");
            ArrayList<String> isbnHorror = getISBNFromDatabase("HORROR");
            addImageToPanel(pathHorror, isbnHorror, panelHorror, "Horror");
        } else if (e.getSource() == item7) {
            panel.setVisible(false);
            panelAction.setVisible(false);
            panelRomance.setVisible(false);
            panelKomedi.setVisible(true);
            panelFantasy.setVisible(false);
            panelScifi.setVisible(false);
            panelHorror.setVisible(false);
            panelSol.setVisible(false);

            frame.add(panelKomedi);            
            ArrayList<String> pathKomedi = getImagePathsFromDatabase("COMEDY");
            ArrayList<String> isbnKomedi = getISBNFromDatabase("COMEDY");
            addImageToPanel(pathKomedi, isbnKomedi, panelKomedi, "Komedi");
        }
    }

    private void addImageToPanel(ArrayList<String> paths, ArrayList<String> isbns, JPanel panelBaru, String genre) {
        JLabel title = new JLabel("WELCOME");
        title.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panelBaru.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        JTextField fieldBrowse = new JTextField();
        panelBaru.add(fieldBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 400, 20));

        JButton browsebtn = new JButton("Browse");
        browsebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String searchQuery = fieldBrowse.getText();

                User loggedInUser = (User) SingletonManager.getInstance().getPerson();
                ArrayList<Book> searchResults = bc.searchBook(SearchType.GENRE, searchQuery, loggedInUser);
                new GUIBookListUser(searchResults);
            }
        });
        panelBaru.add(browsebtn,new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));

        JLabel labelCollection1 = new JLabel("Popular " + genre);
        labelCollection1.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panelBaru.add(labelCollection1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 400, 20));

        JLabel imgicon1 = new JLabel(new ImageIcon(new ImageIcon(paths.get(0)).getImage()
                .getScaledInstance(200, 300, Image.SCALE_DEFAULT)));
        imgicon1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                isbn = isbns.get(0);
                imagePath = getImagePathFromDatabase(isbn);
                new GUIDetailBuku(isbn, imagePath);
            }
        });
        panelBaru.add(imgicon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 300, 300));

        imgicon2 = new JLabel(new ImageIcon(new ImageIcon(paths.get(1)).getImage()
                .getScaledInstance(200, 300, Image.SCALE_DEFAULT)));
        imgicon2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                isbn = isbns.get(1);
                imagePath = getImagePathFromDatabase(isbn);
                new GUIDetailBuku(isbn, imagePath);
            }
        });
        panelBaru.add(imgicon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 300, 300));

        imgicon3 = new JLabel(new ImageIcon(new ImageIcon(paths.get(2)).getImage()
                .getScaledInstance(200, 300, Image.SCALE_DEFAULT)));
        imgicon3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                isbn = isbns.get(2);
                imagePath = getImagePathFromDatabase(isbn);
                new GUIDetailBuku(isbn, imagePath);
            }
        });
        panelBaru.add(imgicon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 300, 300));

        userProfile = new JButton("Profile");
        userProfile.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        userProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUIUserProfile();
            }
        });
        panelBaru.add(userProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 520, 200, 100));
    }

    private ArrayList<String> getImagePathsFromDatabase(String genre) {
        ArrayList<String> paths = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubespbo", "root", "")) {
            String query = "SELECT pic_path FROM book WHERE genre=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, genre);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String path = resultSet.getString("pic_path");
                        paths.add(path);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return paths;
    }

    private ArrayList<String> getISBNFromDatabase(String genre) {
        ArrayList<String> isbns = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubespbo", "root", "")) {
            String query = "SELECT isbn FROM book WHERE genre=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, genre);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String isbn = resultSet.getString("isbn");
                        isbns.add(isbn);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return isbns;
    }

    public static void main(String[] args) {
        new GUIHomeUser();
    }
}