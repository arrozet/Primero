package gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRank extends JPanel implements ViewRank, ActionListener {
    // me quita un warning
	private static final long serialVersionUID = 1L;
	//
	private JTextArea jtaOutput;
    private JButton jbMake;
    private JTextField jtfName;
    private JButton jbClick;
    private JButton jbBName;
    private JButton jbBRank;
    private JButton jbSimulate;
    private JButton jbInvalidate;
    private JTextField jtfFileName;
    private JButton jbBrowse;
    private JFileChooser fcFileName;

    public PanelRank() {
        setLayout(new BorderLayout());
        jtaOutput = new JTextArea(30,50);
        jtaOutput.setLineWrap(true);
        jtfName = new JTextField(20);
        jtaOutput.setBorder(BorderFactory.createTitledBorder("Output"));
        jtaOutput.setEditable(false);
        jtfName.setBorder(BorderFactory.createTitledBorder(("Site Name")));
        add(new JScrollPane(jtaOutput), BorderLayout.CENTER);
        JPanel jpEast = new JPanel();
        jpEast.setLayout(new GridLayout(10,1));
        jbMake = new JButton("Create Web");
        jpEast.add(jbMake);
        jbInvalidate = new JButton("Switch Site");
        jpEast.add(jbInvalidate);
        jbClick = new JButton("Click");
        jpEast.add(jbClick);
        jbBName = new JButton("Sites By Name");
        jpEast.add(jbBName);
        jbBRank = new JButton("Sites By Rank");
        jpEast.add(jbBRank);
        jbSimulate = new JButton("Simulate");
        jpEast.add(jbSimulate);
        add(jpEast, BorderLayout.EAST);
        JPanel panelN = new JPanel();
        panelN.setLayout(new BorderLayout());
        panelN.add(jtfName, BorderLayout.SOUTH);
        jtfFileName = new JTextField(20);
        jtfFileName.setBorder(BorderFactory.createTitledBorder("File Name"));
        panelN.add(jtfFileName, BorderLayout.CENTER);
        jbBrowse = new JButton("Browse...");
        panelN.add(jbBrowse, BorderLayout.EAST);
        add(panelN, BorderLayout.NORTH);
        jbBrowse.addActionListener(this);
        fcFileName = new JFileChooser();
    }

    public void controler(ActionListener ctr) {
        jbMake.addActionListener(ctr);
        jbMake.setActionCommand(Command.CREATE.name());
        jbClick.addActionListener(ctr);
        jbClick.setActionCommand(Command.CLICK.name());
        jbBName.addActionListener(ctr);
        jbBName.setActionCommand(Command.BYNAME.name());
        jbBRank.addActionListener(ctr);
        jbBRank.setActionCommand(Command.BYRANK.name());
        jbSimulate.addActionListener(ctr);
        jbSimulate.setActionCommand(Command.SIMULATE.name());
        jbInvalidate.addActionListener(ctr);
        jbInvalidate.setActionCommand(Command.SWITCH.name());
    }

    public String getFileName() {
        return jtfFileName.getText();
    }

    public void addOutputLine(String line) {
        jtaOutput.append(line+"\n");
    }

    public void setError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error" , JOptionPane.ERROR_MESSAGE) ;
    }

    public String getSiteName() {
        return jtfName.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Fichero con enlaces", "txt");
        fcFileName.setFileFilter(filter);
        int returnVal = fcFileName.showOpenDialog((JComponent)this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String nombreFicheroE  = fcFileName.getSelectedFile().getPath();
            jtfFileName.setText(nombreFicheroE);
        }
    }
}
