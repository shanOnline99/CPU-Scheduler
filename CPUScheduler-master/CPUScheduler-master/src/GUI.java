
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;




import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class GUI
{
    private JFrame frame;
    private JPanel mainPanel;
    private CustomPanel chartPanel;
    private CustomPanel chartPanel1;
    private CustomPanel chartPanel2;
    private CustomPanel chartPanel3;
    private CustomPanel chartPanel4;
    private CustomPanel chartPanel5;
    private JScrollPane tablePane;
    private JScrollPane tablePane1;
    private JScrollPane chartPane;
    private JScrollPane chartPane1;
    private JScrollPane chartPane2;
    private JScrollPane chartPane3;
    private JScrollPane chartPane4;
    private JScrollPane chartPane5;

    private JTable table;
    private JTable table1;
    private JButton addBtn;
    private JButton removeBtn;
    private JButton computeBtn;
    private JButton resetBtn;

    private JLabel Topic;
    private JLabel icon;

    private JLabel wtLabel;
    private JLabel wtLabel1;
    private JLabel wtLabel2;

    private JLabel wtLabel3;
    private JLabel wtLabel4;
    private JLabel wtLabel0;

    private JLabel wtResultLabel;
    private JLabel wtResultLabel1;
    private JLabel wtResultLabel2;
    private JLabel wtResultLabel3;
    private JLabel wtResultLabel4;
    private JLabel wtResultLabel0;
    private JLabel tatLabel;
    private JLabel tatLabel1;
    private JLabel tatLabel2;
    private JLabel tatLabel3;
    private JLabel tatLabel4;
    private JLabel tatLabel0;
    private JLabel tatResultLabel;
    private JLabel tatResultLabel1;
    private JLabel tatResultLabel2;
    private JLabel tatResultLabel3;
    private JLabel tatResultLabel4;
    private JLabel tatResultLabel0;
    private JLabel option;
    private JLabel option1;
    private JLabel option2;
    private JLabel option3;
    private JLabel option4;
    private JRadioButton rad1;
    private JRadioButton rad2;
    private JRadioButton rad3;
    private JRadioButton rad4;
    private JRadioButton rad5;

    private JLabel img;
    private JLabel img1;
    private ImageIcon image1;
    private ImageIcon image2;

    private DefaultTableModel model;
    private DefaultTableModel model1;
    private JLabel l1;

    private ChartPanel createBarChartPanel(DefaultCategoryDataset dataset, String chartTitle, String xLabel, String yLabel) {
        JFreeChart chart = ChartFactory.createBarChart(chartTitle, xLabel, yLabel, dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(.05);
        // Reduce the width between columns by adjusting the item margin
        domainAxis.setCategoryMargin(0.05);
        renderer.setItemMargin(0.0);
        renderer.setSeriesPaint(0, Color.ORANGE);
        renderer.setSeriesPaint(1, Color.BLUE);
        return new ChartPanel(chart);

    }
    public GUI()
    {
        model = new DefaultTableModel(new String[]{"Process ID", "Arrival Time", "Burst Time", "Priority", "WT", "TAT"}, 0);
        //frame.setBackground(Color.black);
        table = new JTable(model);
        table.setFillsViewportHeight(true);
        tablePane = new JScrollPane(table);
        tablePane.setBounds(125, 75, 450, 250);
        //tablePane.setForeground(new Color(250, 212, 0));

        ///////////////////////////////////////////////////////////////////


        /////////////////////////////////////////////////////////////////////

        Topic = new JLabel("*** CPU SCHEDULERS ***", JLabel.CENTER);
        Topic.setBounds(25, 25, 600, 36);
        Topic.setFont(new Font("SERIF", Font.BOLD, 36));
        Topic.setForeground(new Color(250, 212, 0));

        addBtn = new JButton("Add");
        addBtn.setBounds(25, 140, 93, 35);
        addBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new String[]{"", "", "", "", "", ""});
            }
        });

        removeBtn = new JButton("Remove");
        removeBtn.setBounds(25, 240, 93, 35);
        removeBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        removeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if (row > -1) {
                    model.removeRow(row);
                }
            }
        });


        resetBtn = new JButton("Reset");
        resetBtn.setBounds(25, 290, 93, 35);
        resetBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        // Add ActionListener to the "Reset" button
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset the components
                model.setRowCount(0);
                wtResultLabel.setText("");
                tatResultLabel.setText("");
                wtResultLabel1.setText("");
                tatResultLabel1.setText("");
                wtResultLabel2.setText("");
                tatResultLabel2.setText("");
                wtResultLabel3.setText("");
                tatResultLabel3.setText("");
                wtResultLabel4.setText("");
                tatResultLabel4.setText("");
                wtResultLabel0.setText("");
                tatResultLabel0.setText("");
            }
        });

        image1 = new ImageIcon(getClass().getResource("0.png"));
        //image1 = new ImageIcon(new ImageIcon("4.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
        img = new JLabel(image1);
        img.setBounds(20, 40, 100, 100);


        image2 = new ImageIcon(getClass().getResource("0000.png"));
        //image1 = new ImageIcon(new ImageIcon("4.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
        img1 = new JLabel(image2);
        img1.setBounds(1000, 750, 75, 75);

        l1 = new JLabel("Process scheduling....");
        l1.setBounds(1100, 777, 400, 37);
        l1.setForeground(new Color(250, 212, 0));
        l1.setFont(new Font("Verdana", Font.BOLD,30));




/////////////////////////////(   1   )///////////////////////////////////////////////////////////////////////
        chartPanel = new CustomPanel();
//        chartPanel.setPreferredSize(new Dimension(700, 10));
        chartPanel.setBackground(new Color(247, 244, 224));
        //chartPanel.setBackground(Color.lightGray);
        chartPane = new JScrollPane(chartPanel);
        chartPane.setBounds(600, 330, 900, 100);

        wtLabel = new JLabel("AWT:");
        wtLabel.setBounds(600, 428, 100, 25);
        wtLabel.setForeground(new Color(250, 197, 170));
        wtLabel.setFont(new Font("Verdana", Font.BOLD,16));

        tatLabel = new JLabel("ATAT:");
        tatLabel.setBounds(600, 450, 100, 25);
        tatLabel.setForeground(new Color(250, 197, 170));
        tatLabel.setFont(new Font("Verdana", Font.BOLD,16));

        wtResultLabel = new JLabel();
        wtResultLabel.setBounds(660, 425, 180, 25);
        wtResultLabel.setFont(new Font("Verdana", Font.BOLD,16));
        wtResultLabel.setForeground(new Color(247, 243, 210));

        tatResultLabel = new JLabel();
        tatResultLabel.setBounds(660, 450, 180, 25);
        tatResultLabel.setFont(new Font("Verdana", Font.BOLD,16));
        tatResultLabel.setForeground(new Color(238, 233, 247));

        option = new JLabel("--- FCFS ---");
        option.setFont(new Font("Verdana", Font.BOLD, 19));
        option.setBounds(1400, 430, 200, 20);
        option.setForeground(new Color(227, 247, 7));
        //option.setForeground(Color.RED);

        computeBtn = new JButton("Compute");
        computeBtn.setBounds(25, 190, 93, 35);
        computeBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));



///////////////////////////////(   2   )/////////////////////////////////////////////
        chartPanel1 = new CustomPanel();
//        chartPanel.setPreferredSize(new Dimension(700, 10));
        chartPanel1.setBackground(Color.lightGray);
        chartPane1 = new JScrollPane(chartPanel1);
        chartPane1.setBounds(600, 475, 900, 100);
        //chartPanel1.setBackground(new Color(5, 185, 250));
        chartPanel1.setBackground(new Color(247, 244, 224));


        wtLabel1 = new JLabel("AWT:");
        wtLabel1.setBounds(600, 573, 300, 25);
        wtLabel1.setForeground(new Color(250, 197, 170));
        wtLabel1.setFont(new Font("Verdana", Font.BOLD,16));

        tatLabel1 = new JLabel("ATAT:");
        tatLabel1.setBounds(600, 595, 300, 25);
        tatLabel1.setForeground(new Color(250, 197, 170));
        tatLabel1.setFont(new Font("Verdana", Font.BOLD,16));

        wtResultLabel1 = new JLabel();
        wtResultLabel1.setBounds(660, 570, 180, 25);
        wtResultLabel1.setFont(new Font("Verdana", Font.BOLD,16));
        wtResultLabel1.setForeground(new Color(247, 243, 210));

        tatResultLabel1 = new JLabel();
        tatResultLabel1.setBounds(660, 595, 180, 25);
        tatResultLabel1.setFont(new Font("Verdana", Font.BOLD,16));
        tatResultLabel1.setForeground(new Color(247, 243, 210));

        option1 = new JLabel("--- SJF ---");
        option1.setBounds(1400, 575, 200, 20);
        option1.setFont(new Font("Verdana", Font.BOLD, 19));
        //option1.setForeground(Color.RED);
        option1.setForeground(new Color(227, 247, 7));



//////////////////////////////////(   3   )/////////////////////////////////////////////////
        chartPanel2 = new CustomPanel();
//        chartPanel.setPreferredSize(new Dimension(700, 10));
        chartPanel2.setBackground(Color.lightGray);
        chartPane2 = new JScrollPane(chartPanel2);
        chartPane2.setBounds(600, 625, 900, 100);
        chartPanel2.setBackground(new Color(247, 244, 224));

        wtLabel2 = new JLabel("AWT:");
        wtLabel2.setBounds(600, 725, 300, 25);
        wtLabel2.setForeground(new Color(250, 197, 170));
        wtLabel2.setFont(new Font("Verdana", Font.BOLD,16));

        tatLabel2 = new JLabel("ATAT:");
        tatLabel2.setBounds(600, 750, 300, 25);
        tatLabel2.setForeground(new Color(250, 197, 170));
        tatLabel2.setFont(new Font("Verdana", Font.BOLD,16));

        wtResultLabel2 = new JLabel();
        wtResultLabel2.setBounds(660, 725, 180, 25);
        wtResultLabel2.setFont(new Font("Verdana", Font.BOLD,16));
        wtResultLabel2.setForeground(new Color(247, 243, 210));

        tatResultLabel2 = new JLabel();
        tatResultLabel2.setBounds(660, 750, 180, 25);
        tatResultLabel2.setFont(new Font("Verdana", Font.BOLD,16));
        tatResultLabel2.setForeground(new Color(247, 243, 210));

        option2 = new JLabel("--- SRTN ---");
        option2.setBounds(1400, 725, 200, 20);
        option2.setFont(new Font("Verdana", Font.BOLD, 19));
        //option2.setForeground(Color.RED);
        option2.setForeground(new Color(227, 247, 7));


//////////////////////////////////(   4   )/////////////////////////////////////////////////
        chartPanel3 = new CustomPanel();
//        chartPanel.setPreferredSize(new Dimension(700, 10));
        chartPanel3.setBackground(Color.lightGray);
        chartPane3 = new JScrollPane(chartPanel3);
        chartPane3.setBounds(600, 25, 900, 100);
        chartPanel3.setBackground(new Color(247, 244, 224));

        wtLabel3 = new JLabel("AWT:");
        wtLabel3.setBounds(600, 125, 300, 25);
        wtLabel3.setForeground(new Color(250, 197, 170));
        wtLabel3.setFont(new Font("Verdana", Font.BOLD,16));

        tatLabel3 = new JLabel("ATAT:");
        tatLabel3.setBounds(600, 150, 300, 25);
        tatLabel3.setForeground(new Color(250, 197, 170));
        tatLabel3.setFont(new Font("Verdana", Font.BOLD,16));

        wtResultLabel3 = new JLabel();
        wtResultLabel3.setBounds(660, 125, 180, 25);
        wtResultLabel3.setFont(new Font("Verdana", Font.BOLD,16));
        wtResultLabel3.setForeground(new Color(247, 243, 210));

        tatResultLabel3 = new JLabel();
        tatResultLabel3.setBounds(660, 150, 180, 25);
        tatResultLabel3.setFont(new Font("Verdana", Font.BOLD,16));
        tatResultLabel3.setForeground(new Color(247, 243, 210));

        option3 = new JLabel("--- RR ---");
        option3.setBounds(1400, 125, 200, 20);
        option3.setFont(new Font("Verdana", Font.BOLD, 19));
        //option3.setForeground(Color.RED);
        option3.setForeground(new Color(227, 247, 7));

//////////////////////////////////(   5   )/////////////////////////////////////////////////
        chartPanel4 = new CustomPanel();
//        chartPanel.setPreferredSize(new Dimension(700, 10));
        chartPanel4.setBackground(Color.lightGray);
        chartPane4 = new JScrollPane(chartPanel4);
        chartPane4.setBounds(600, 175, 900, 100);
        chartPanel4.setBackground(new Color(247, 246, 237));

        /////graph///
        chartPanel5 = new CustomPanel();
        //chartPanel5.setPreferredSize(new Dimension(500, 300));
        chartPanel5.setBackground(Color.lightGray);
        chartPane5 = new JScrollPane(chartPanel5);
        chartPane5.setBounds(25, 400, 550, 300);


        wtLabel4 = new JLabel("AWT:");
        wtLabel4.setBounds(600, 275, 300, 25);
        wtLabel4.setForeground(new Color(250, 197, 170));
        wtLabel4.setFont(new Font("Verdana", Font.BOLD,16));

        tatLabel4 = new JLabel("ATAT:");
        tatLabel4.setBounds(600, 300, 300, 25);
        tatLabel4.setForeground(new Color(250, 197, 170));
        tatLabel4.setFont(new Font("Verdana", Font.BOLD,16));

        wtResultLabel4 = new JLabel();
        wtResultLabel4.setBounds(660, 275, 180, 25);
        wtResultLabel4.setFont(new Font("Verdana", Font.BOLD,16));
        wtResultLabel4.setForeground(new Color(247, 243, 210));

        tatResultLabel4 = new JLabel();
        tatResultLabel4.setBounds(660, 300, 180, 25);
        tatResultLabel4.setFont(new Font("Verdana", Font.BOLD,16));
        tatResultLabel4.setForeground(new Color(247, 243, 210));

        option4 = new JLabel("--- PRIORITY ---");
        option4.setBounds(1350, 275, 300, 20);
        option4.setFont(new Font("Verdana", Font.BOLD, 19));
        //option4.setForeground(Color.RED);
        option4.setForeground(new Color(227, 247, 7));

        ////////////////////////////////////////////////////////////////////////
        wtLabel0 = new JLabel("BEST WAITING TIME:");
        wtLabel0.setBounds(25, 730, 400, 25);
        wtLabel0.setFont(new Font("Verdana", Font.BOLD, 24));
        wtLabel0.setForeground(new Color(243, 247, 7));
        tatLabel0 = new JLabel("BEST ALGORITHM:");
        tatLabel0.setBounds(25, 780, 400, 25);
        tatLabel0.setFont(new Font("Verdana", Font.BOLD, 24));
        tatLabel0.setForeground(new Color(243, 247, 7));
        //tatLabel0.setForeground(Color.RED);

        wtResultLabel0 = new JLabel();
        wtResultLabel0.setBounds(330, 730, 180, 25);
        wtResultLabel0.setFont(new Font("Verdana", Font.BOLD, 24));
        wtResultLabel0.setForeground(new Color(247, 171, 7));
        tatResultLabel0 = new JLabel();
        tatResultLabel0.setBounds(300, 780, 180, 25);
        tatResultLabel0.setFont(new Font("Verdana", Font.BOLD, 24));
        tatResultLabel0.setForeground(new Color(247, 171, 7));

//////////////////////////////////////////////////////////////

        rad1 = new JRadioButton("FCFS");
        rad2 = new JRadioButton("SJF");
        rad3 = new JRadioButton("SRTN");
        rad4 = new JRadioButton("RR");
        rad5 = new JRadioButton("PRIORITY");
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(rad1);
        bg1.add(rad2);
        bg1.add(rad3);
        bg1.add(rad4);
        bg1.add(rad5);
        rad1.setBounds(50,360,80,25);
        rad2.setBounds(150,360,80,25);
        rad3.setBounds(250,360,80,25);
        rad4.setBounds(350,360,80,25);
        rad5.setBounds(450,360,80,25);
        rad1.setBackground(new Color(174, 200, 246));
        rad2.setBackground(new Color(174, 200, 246));
        rad3.setBackground(new Color(174, 200, 246));
        rad4.setBackground(new Color(174, 200, 246));
        rad5.setBackground(new Color(174, 200, 246));


///////////////////////////// compute ////////////////////////////////////////

        computeBtn.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {

                 /////////////////////////// FCFS //////////////////////////////////
                     //String selected = (String) option.getSelectedItem();
                     CPUScheduler scheduler;
                     scheduler = new FirstComeFirstServe();
                     for (int i = 0; i < model.getRowCount(); i++) {
                         String process = (String) model.getValueAt(i, 0);
                         int at = Integer.parseInt((String) model.getValueAt(i, 1));
                         int bt = Integer.parseInt((String) model.getValueAt(i, 2));
                         int pl=1;
                         scheduler.add(new Row(process, at, bt, pl));
                     }
                     scheduler.process();
                     /*for (int i = 0; i < model.getRowCount(); i++) {
                         String process = (String) model.getValueAt(i, 0);
                         Row row = scheduler.getRow(process);
                         model.setValueAt(row.getWaitingTime(), i, 4);
                         model.setValueAt(row.getTurnaroundTime(), i, 5);
                     }*/
                     wtResultLabel.setText(Double.toString(scheduler.getAverageWaitingTime()));
                     tatResultLabel.setText(Double.toString(scheduler.getAverageTurnAroundTime()));
                     chartPanel.setTimeline(scheduler.getTimeline());

                //////////////////////////////////////////// SJF //////////////////////////////////////////////////////
                     //String selected = (String) option.getSelectedItem();
                     CPUScheduler scheduler1;
                     scheduler1 = new ShortestJobFirst();
                     for (int i = 0; i < model.getRowCount(); i++) {
                         String process = (String) model.getValueAt(i, 0);
                         int at = Integer.parseInt((String) model.getValueAt(i, 1));
                         int bt = Integer.parseInt((String) model.getValueAt(i, 2));
                         int pl=1;
                         scheduler1.add(new Row(process, at, bt, pl));
                     }
                     scheduler1.process();
                     /*for (int i = 0; i < model.getRowCount(); i++) {
                         String process = (String) model.getValueAt(i, 0);
                         Row row = scheduler1.getRow(process);
                         model.setValueAt(row.getWaitingTime(), i, 4);
                         model.setValueAt(row.getTurnaroundTime(), i, 5);
                     }*/
                     wtResultLabel1.setText(Double.toString(scheduler1.getAverageWaitingTime()));
                     tatResultLabel1.setText(Double.toString(scheduler1.getAverageTurnAroundTime()));
                     chartPanel1.setTimeline(scheduler1.getTimeline());
                     //wtResultLabel1.setForeground(Color.BLUE);
                     //tatResultLabel1.setForeground(new Color(0,0,255));


                     /////////////////////////  SRTN  /////////////////////////////////
                     //String selected = (String) option.getSelectedItem();
                     CPUScheduler scheduler2;
                     scheduler2 = new ShortestRemainingTime();
                     for (int i = 0; i < model.getRowCount(); i++) {
                         String process = (String) model.getValueAt(i, 0);
                         int at = Integer.parseInt((String) model.getValueAt(i, 1));
                         int bt = Integer.parseInt((String) model.getValueAt(i, 2));
                         int pl=1;
                         scheduler2.add(new Row(process, at, bt, pl));
                     }
                     scheduler2.process();
                     /*for (int i = 0; i < model.getRowCount(); i++) {
                         String process = (String) model.getValueAt(i, 0);
                         Row row = scheduler2.getRow(process);
                         model.setValueAt(row.getWaitingTime(), i, 4);
                         model.setValueAt(row.getTurnaroundTime(), i, 5);
                     }*/
                     wtResultLabel2.setText(Double.toString(scheduler2.getAverageWaitingTime()));
                     tatResultLabel2.setText(Double.toString(scheduler2.getAverageTurnAroundTime()));
                     chartPanel2.setTimeline(scheduler2.getTimeline());


                     /////////////////////////   RR  /////////////////////////////////
                     //String selected = (String) option.getSelectedItem();
                     CPUScheduler scheduler3;
                     String tq = JOptionPane.showInputDialog("Time Quantum");
                     if (tq == null) {
                         return;
                     }
                     scheduler3 = new RoundRobin();
                     scheduler3.setTimeQuantum(Integer.parseInt(tq));
                     for (int i = 0; i < model.getRowCount(); i++) {
                         String process = (String) model.getValueAt(i, 0);
                         int at = Integer.parseInt((String) model.getValueAt(i, 1));
                         int bt = Integer.parseInt((String) model.getValueAt(i, 2));
                         int pl=1;
                         scheduler3.add(new Row(process, at, bt, pl));
                     }
                     scheduler3.process();
                     /*for (int i = 0; i < model.getRowCount(); i++) {
                         String process = (String) model.getValueAt(i, 0);
                         Row row = scheduler3.getRow(process);
                         model.setValueAt(row.getWaitingTime(), i, 4);
                         model.setValueAt(row.getTurnaroundTime(), i, 5);
                     }*/

                     wtResultLabel3.setText(Double.toString(scheduler3.getAverageWaitingTime()));
                     tatResultLabel3.setText(Double.toString(scheduler3.getAverageTurnAroundTime()));
                     chartPanel3.setTimeline(scheduler3.getTimeline());


                     /////////////////////////   Priority   /////////////////////////////////
                     //String selected = (String) option.getSelectedItem();
                     CPUScheduler scheduler4;

                     scheduler4 = new PriorityNonPreemptive();
                     scheduler4.setTimeQuantum(Integer.parseInt(tq));
                     for (int i = 0; i < model.getRowCount(); i++) {
                         String process = (String) model.getValueAt(i, 0);
                         int at = Integer.parseInt((String) model.getValueAt(i, 1));
                         int bt = Integer.parseInt((String) model.getValueAt(i, 2));
                         int pl;
                         if (true)
                         {
                             if (!model.getValueAt(i, 3).equals(""))
                             {
                                 pl = Integer.parseInt((String) model.getValueAt(i, 3));
                             }
                             else
                             {
                                 pl = 1;
                             }
                         }
                         else
                         {
                             pl = 1;
                         }
                         scheduler4.add(new Row(process, at, bt, pl));
                     }

                     scheduler4.process();
                     /*for (int i = 0; i < model.getRowCount(); i++) {
                         String process = (String) model.getValueAt(i, 0);
                         Row row = scheduler4.getRow(process);
                         model.setValueAt(row.getWaitingTime(), i, 4);
                         model.setValueAt(row.getTurnaroundTime(), i, 5);
                     }*/

                     wtResultLabel4.setText(Double.toString(scheduler4.getAverageWaitingTime()));
                     tatResultLabel4.setText(Double.toString(scheduler4.getAverageTurnAroundTime()));
                     chartPanel4.setTimeline(scheduler4.getTimeline());






///////////////////////////////////////////////////////////////////////////////////////////////////

                     double[] label=new double[5];

                     double label0=scheduler.getAverageWaitingTime();
                     double label1=scheduler1.getAverageWaitingTime();
                     double label2=scheduler2.getAverageWaitingTime();
                     double label3=scheduler3.getAverageWaitingTime();
                     double label4=scheduler4.getAverageWaitingTime();


                     label[0]=label0;
                     label[1]=label1;
                     label[2]=label2;
                     label[3]=label3;
                     label[4]=label4;

                     double min=10000;
                     for (int i = 0; i<5; i++) {
                         if (label[i] < min) {
                             min = label[i];
                         }
                     }



                     wtResultLabel0.setText(Double.toString(min));

                     String[] algo=new String[5];
                     algo[0]="FCFS";
                     algo[1]="SJF";
                     algo[2]="SRTN";
                     algo[3]="RR";
                     algo[4]="PRIORITY";

                     for (int i = 0; i<5; i++) {
                         if (label[i] == min) {
                             tatResultLabel0.setText(algo[i]);
                         }
                     }

                     chartPanel5.removeAll();

                     // Create the dataset
                     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                     dataset.addValue(label[0], "AVGWT", "FCFS");
                     dataset.addValue(scheduler.getAverageTurnAroundTime(), "AVGTAT", "FCFS");
                     dataset.addValue(label[1], "AVGWT", "SJF");
                     dataset.addValue(scheduler1.getAverageTurnAroundTime(), "AVGTAT", "SJF");
                     dataset.addValue(label[2], "AVGWT", "SRTN");
                     dataset.addValue(scheduler2.getAverageTurnAroundTime(), "AVGTAT", "SRTN");
                     dataset.addValue(label[3], "AVGWT", "RR");
                     dataset.addValue(scheduler3.getAverageTurnAroundTime(), "AVGTAT", "RR");
                     dataset.addValue(label[4], "AVGWT", "PRIORITY");
                     dataset.addValue(scheduler4.getAverageTurnAroundTime(), "AVGTAT", "PRIORITY");

// Create the bar chart panel
                     ChartPanel barChartPanel = createBarChartPanel(dataset, "Comparison Table", "Schedulers", "Time");
                     barChartPanel.setPreferredSize(new Dimension(525,285));

// Add the bar chart panel to your existing chartPanel
                     chartPanel5.add(barChartPanel);


                     ////////////////////////////////////////////////////////

                     rad1.addItemListener(new ItemListener() {
                         @Override
                         public void itemStateChanged(ItemEvent e) {
                             if (rad1.isSelected())
                             {
                                 for (int i = 0; i < model.getRowCount(); i++) {
                                     String process = (String) model.getValueAt(i, 0);
                                     Row row = scheduler.getRow(process);
                                     model.setValueAt(row.getWaitingTime(), i, 4);
                                     model.setValueAt(row.getTurnaroundTime(), i, 5);
                                 }
                             }
                         }
                     });
                     rad2.addItemListener(new ItemListener() {
                         @Override
                         public void itemStateChanged(ItemEvent e) {
                             if (rad2.isSelected())
                             {
                                 for (int i = 0; i < model.getRowCount(); i++) {
                                     String process = (String) model.getValueAt(i, 0);
                                     Row row = scheduler1.getRow(process);
                                     model.setValueAt(row.getWaitingTime(), i, 4);
                                     model.setValueAt(row.getTurnaroundTime(), i, 5);
                                 }
                             }
                         }
                     });
                     rad3.addItemListener(new ItemListener() {
                         @Override
                         public void itemStateChanged(ItemEvent e) {
                             if (rad3.isSelected())
                             {
                                 for (int i = 0; i < model.getRowCount(); i++) {
                                     String process = (String) model.getValueAt(i, 0);
                                     Row row = scheduler2.getRow(process);
                                     model.setValueAt(row.getWaitingTime(), i, 4);
                                     model.setValueAt(row.getTurnaroundTime(), i, 5);
                                 }
                             }
                         }
                     });
                     rad4.addItemListener(new ItemListener() {
                         @Override
                         public void itemStateChanged(ItemEvent e) {
                             if (rad4.isSelected())
                             {
                                 for (int i = 0; i < model.getRowCount(); i++) {
                                     String process = (String) model.getValueAt(i, 0);
                                     Row row = scheduler3.getRow(process);
                                     model.setValueAt(row.getWaitingTime(), i, 4);
                                     model.setValueAt(row.getTurnaroundTime(), i, 5);
                                 }
                             }
                         }
                     });
                     rad5.addItemListener(new ItemListener() {
                         @Override
                         public void itemStateChanged(ItemEvent e) {
                             if (rad5.isSelected())
                             {
                                 for (int i = 0; i < model.getRowCount(); i++) {
                                     String process = (String) model.getValueAt(i, 0);
                                     Row row = scheduler4.getRow(process);
                                     model.setValueAt(row.getWaitingTime(), i, 4);
                                     model.setValueAt(row.getTurnaroundTime(), i, 5);
                                 }
                             }
                         }
                     });


                 }
        });



        mainPanel = new JPanel(null);
        //mainPanel.setBackground(new Color(3, 62, 156));
        //mainPanel.setBackground(new Color(5, 217, 250));
        mainPanel.setBackground(new Color(0, 0, 0));

        mainPanel.setPreferredSize(new Dimension(2000, 1000));
        //mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.add(tablePane);
        //mainPanel.add(tablePane1);
        mainPanel.add(addBtn);
        mainPanel.add(removeBtn);
        mainPanel.add(chartPane);
        mainPanel.add(chartPane1);
        mainPanel.add(chartPane2);
        mainPanel.add(chartPane3);
        mainPanel.add(chartPane4);
        mainPanel.add(chartPane5);
        mainPanel.add(wtLabel);
        mainPanel.add(wtLabel1);
        mainPanel.add(wtLabel2);
        mainPanel.add(wtLabel3);
        mainPanel.add(wtLabel4);
        mainPanel.add(wtLabel0);
        mainPanel.add(tatLabel);
        mainPanel.add(tatLabel1);
        mainPanel.add(tatLabel2);
        mainPanel.add(tatLabel3);
        mainPanel.add(tatLabel4);
        mainPanel.add(tatLabel0);
        mainPanel.add(wtResultLabel);
        mainPanel.add(wtResultLabel1);
        mainPanel.add(wtResultLabel2);
        mainPanel.add(wtResultLabel3);
        mainPanel.add(wtResultLabel4);
        mainPanel.add(wtResultLabel0);
        mainPanel.add(tatResultLabel);
        mainPanel.add(tatResultLabel1);
        mainPanel.add(tatResultLabel2);
        mainPanel.add(tatResultLabel3);
        mainPanel.add(tatResultLabel4);
        mainPanel.add(tatResultLabel0);
        mainPanel.add(option);
        mainPanel.add(computeBtn);
        mainPanel.add(resetBtn);
        mainPanel.add(option1);
        mainPanel.add(option2);
        mainPanel.add(option3);
        mainPanel.add(option4);
        mainPanel.add(Topic);
        mainPanel.add(rad1);
        mainPanel.add(rad2);
        mainPanel.add(rad3);
        mainPanel.add(rad4);
        mainPanel.add(rad5);
        mainPanel.add(img);
        mainPanel.add(img1);
        mainPanel.add(l1);



        frame = new JFrame("CPU Scheduler Algorithms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(mainPanel);
        frame.pack();
    }

/////////////////////////////////////////////////////////////////////////////////






















        public static void main(String[] args)
    {
        new GUI();
    }

    class CustomPanel extends JPanel
    {
        private List<Event> timeline;

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            if (timeline != null)
            {
//                int width = 30;

                for (int i = 0; i < timeline.size(); i++)
                {
                    Event event = timeline.get(i);
                    int x = 30 * (i + 1);
                    int y = 20;

                    g.drawRect(x, y, 30, 30);
                    g.setFont(new Font("Segoe UI", Font.BOLD, 13));
                    g.drawString(event.getProcessName(), x + 10, y + 20);
                    g.setFont(new Font("Segoe UI", Font.PLAIN, 11));
                    g.drawString(Integer.toString(event.getStartTime()), x - 5, y + 45);

                    if (i == timeline.size() - 1)
                    {
                        g.drawString(Integer.toString(event.getFinishTime()), x + 27, y + 45);
                    }

//                    width += 30;
                }

//                this.setPreferredSize(new Dimension(width, 75));
            }
        }

        public void setTimeline(List<Event> timeline)
        {
            this.timeline = timeline;
            repaint();
        }
    }
}