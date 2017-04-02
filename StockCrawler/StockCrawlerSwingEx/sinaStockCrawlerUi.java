
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class sinaStockCrawlerUi  implements ActionListener {
	JFrame f;
	JTextField jtf;
	JTextArea jta;
	JButton jb;
	JPanel jp;
	DefaultTableModel atm = null;
	Vector vDate = new Vector();
	Vector vName = new Vector();
	JTable table = null;
	JScrollPane sPane = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sinaStockCrawlerUi ui = new sinaStockCrawlerUi();
	}
	
	public sinaStockCrawlerUi() {
		// 元素属性
		f = new JFrame("股票离线分析系统");
		f.setLayout(new BorderLayout());
		jp=new JPanel();
		jp.setLayout(new FlowLayout());
		jtf = new JTextField(40);
		jtf.addActionListener(this);
    
    
		vName.add("股票名字");
		vName.add("今日开盘价");
		vName.add("昨日收盘价");
		vName.add("当前价格");
		vName.add("今日最高价");
		vName.add("今日最低价");
		vName.add("竞买价");
		vName.add("竞卖价");
		vName.add("成交的股票数/100");
		vName.add("成交金额/万");
		atm = new DefaultTableModel(vDate, vName);
    
		Object[][] data = {};
		table = new JTable(atm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//????
		table.setPreferredScrollableViewportSize(new Dimension(600, 80));
		Font x = new Font("seril", 0, 12);
		table.setFont(x);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.updateUI();
		jb = new JButton("提交"); 
		jb.addActionListener(this);
		// 添加元素
		f.getContentPane().add(scrollPane, BorderLayout.CENTER);
		jp.add(jtf);
		jp.add(jb);
		f.add(jp,BorderLayout.NORTH);
		// 框架设置
		f.setSize(1000, 600);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((int) screenSize.getWidth() / 2 - 500,
				(int) screenSize.getHeight() / 2 - 300);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
  
  
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("提交")) {
			System.out.println(jtf.getText());
			crawlerData downdata=new crawlerData(jtf.getText());
			addDate(downdata.data);
		}
	}
  
  
	public void addDate(String data) {
		Vector vTmp = new Vector();
		String split[]=data.split(",");
		for(int a=0;a<=9;a++)
		{
			System.out.println(split[a]);
			vTmp.add(split[a]);
		}
		vDate.add(vTmp);
		table.updateUI();
	}
}

