package ui.cui;

/**public class FrankieGui{ extends JFrame {

    private Bibliothek bib;

    public FrankieGui() {
        super("EShopManager");

        try {
            bib = new EShopManager("BIB");
        } catch (IOException e) {
            e.printStackTrace();
        }

        layoutAddSearchBar();
        layoutHinzufuegenleisteHinzu();
        layoutFuegeErgebnislisteHinzu();

        // Zusätzliches Verhalten
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocation(0, 500);
        setVisible(true);
    }

    private void layoutFuegeSuchleisteHinzu() {
        // Suchleiste
        // Umsetzung mit FlowLayout
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        northPanel.add(new JLabel("Suchbegriff:"));
        JTextField suchTextFeld = new JTextField();
        suchTextFeld.setPreferredSize(new Dimension(200, 30)); // Wichtig, wird sonst zusammengedrückt
        northPanel.add(suchTextFeld);
        northPanel.add(new JButton("Suche"));
        add(northPanel, BorderLayout.NORTH);
    }

    private void layoutHinzufuegenleisteHinzu() {
        // Hinzufügenleiste
        // Umsetzung mit GridbagLayout
        // Details siehe: https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/GridBagConstraints
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());
        Dimension eingabeFeldGroesse = new Dimension(140,30);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH; // Komponenten nördlich orientieren, klappt nur in Kombination mit weighty (siehe unten)

        JLabel labelNummer = new JLabel("Nummer:");
        c.gridx = 0;
        c.gridy = 0; // Spalte 1, Zeile 1
        westPanel.add(labelNummer, c);

        JTextField textfieldNummer = new JTextField();
        textfieldNummer.setPreferredSize(eingabeFeldGroesse);
        c.gridx = 0;
        c.gridy = 1; // Spalte 1, Zeile 2 usw.
        westPanel.add(textfieldNummer, c);

        JLabel labelTitel = new JLabel("Titel:");
        c.gridx = 0;
        c.gridy = 2;
        westPanel.add(labelTitel, c);

        JTextField textfieldTitel = new JTextField();
        textfieldTitel.setPreferredSize(eingabeFeldGroesse);
        c.gridx = 0;
        c.gridy = 3;
        westPanel.add(textfieldTitel, c);

        JButton hinzufuegenButton = new JButton("Hinzufügen");
        hinzufuegenButton.setPreferredSize(eingabeFeldGroesse);
        // Die noch freie Fläche des GridbagLayouts wird um den Button platziert
        // Dadurch rutschen alle Komponenten in die nördliche Orientierung (siehe oben GridBagConstraints.NORTH)
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 4;
        westPanel.add(hinzufuegenButton, c);

        add(westPanel, BorderLayout.WEST);
    }

    private void layoutFuegeErgebnislisteHinzu() {
        // Ergebnisliste (ohne Panel!)
        add(new JList(bib.gibAlleBuecher().toArray()), BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        BibClientGUI gui = new BibClientGUI();

    }
}*/