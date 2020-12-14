import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Notepad extends JFrame implements ActionListener
{
	JScrollPane scroll;                                                                                                                                                             
	Font f=new Font("",Font.PLAIN,20);		// font size  10  >> default font in text area
	Font ff=new Font("",Font.BOLD,22);						// menubar font
	Font f1;
	Font f2;
	Font f3;
	Font f4;
	
	Font f_areal;		// font style
	Font f_calibri;
	Font f_comic;		// 
	Font f_eras;		//
	Font f_mt;
	
	Font ff_areal= new Font("Arial Black",Font.PLAIN,20);
	Font ff_calibri=new Font("Calibri",Font.PLAIN,20);
	Font ff_comic= new Font("Comic Sans MS",Font.PLAIN,20);
	Font ff_eras= new Font("Eras Medium ITC",Font.PLAIN,20);
	Font ff_mt= new Font("Engravers MT",Font.PLAIN,20);
	
	JFileChooser fc=new JFileChooser();
	JTextArea ta1;
	
	String s[]={"10","11","12","13","14"};
	JComboBox cmb1;
	
	JMenuBar menubar;
	JMenu file,edit,font,font_size,font_style,view,help,about;
	JMenuItem file_new,file_open,file_save,file_saveas,file_print,file_exit,edit_undo,edit_redo;
	JMenuItem edit_cut,edit_copy,edit_paste,ten,elvn,twlv,thertn,frtn,about_me;
	JMenuItem areal,calibri,comic,eras,mt;
	Notepad()
	{
		setVisible(true);
		setTitle(" NOTEPAD @SOUNAK");
		setBounds(500,100,1030,790);
	//	Container c=getContentPane();
	//	c.setBackground(Color.yellow);
	//	setFont(f4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void function()
	{
	//	setLayout(null);
		
		BorderLayout brd=new BorderLayout();
		setLayout(brd);
		
		ta1=new JTextArea();		
		ta1.setFont(f);	
		
		scroll=new JScrollPane(ta1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	//	scroll=new JScrollPane(ta1);		
		scroll.setBounds(5,5,1000,700);
		add(scroll);
		
    // 	add(scroll);
	//	add(ta1);
		
		file_new=new JMenuItem("New",KeyEvent.VK_N);
		file_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));  //shortcut key 
		file_new.setFont(f);
		
		file_open=new JMenuItem("Open",KeyEvent.VK_O);
		file_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));  //shortcut key 
		file_open.setFont(f);
		
		file_save=new JMenuItem("Save",KeyEvent.VK_S);
		file_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));  //shortcut key 
		file_save.setFont(f);
		
		file_saveas=new JMenuItem("Save As");
	//	file_saveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK,InputEvent.ALT_DOWN_MASK));  //shortcut key 
		file_saveas.setFont(f);
		
		file_print=new JMenuItem("Print",KeyEvent.VK_P);
		file_print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_DOWN_MASK));   //shortcut key
		file_print.setFont(f);
		
		file_exit=new JMenuItem("Exit",KeyEvent.VK_F4);
		file_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_DOWN_MASK));
		Color c_exit=new Color(230,40,20);
		file_exit.setBackground(c_exit);
		file_exit.setForeground(Color.white);
		file_exit.setFont(f);
		
		file=new JMenu("File ");
		file.setForeground(Color.white);
		file.setFont(ff);
		
		file.add(file_new);
		file.add(file_open);
		file.addSeparator();		// for a seperate line
		file.add(file_save);
		file.add(file_saveas);
	//	file_saveas.setEnabled(false);
		file.addSeparator();		// for a seperate line
		file.add(file_print);
		file.addSeparator();		// for a seperate line
		file.add(file_exit);
		
		edit_undo=new JMenuItem("Undo");
		edit_undo.setFont(f);
		edit_redo=new JMenuItem("Redo");
		edit_redo.setFont(f);
		edit_cut=new JMenuItem("Cut",KeyEvent.VK_X);
		edit_cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_DOWN_MASK));  //shortcut key 
		edit_cut.setFont(f);
		edit_copy=new JMenuItem("Copy",KeyEvent.VK_C);
		edit_copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_DOWN_MASK));  //shortcut key 
		edit_copy.setFont(f);
		edit_paste=new JMenuItem("Paste",KeyEvent.VK_V);
		edit_paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_DOWN_MASK));  //shortcut key 
		edit_paste.setFont(f);
		
		edit=new JMenu("Edit ");
		edit.setForeground(Color.white);
		edit.setFont(ff);
		
		edit.add(edit_undo);
		edit.add(edit_redo);
		edit.addSeparator();
		edit.add(edit_cut);
		edit.add(edit_copy);
		edit.add(edit_paste);
		
		ten=new JMenuItem("10");
		ten.setFont(f);
		elvn=new JMenuItem("11");
		elvn.setFont(f);
		twlv=new JMenuItem("12");
		twlv.setFont(f);
		thertn=new JMenuItem("13");
		thertn.setFont(f);
		frtn=new JMenuItem("14");
		frtn.setFont(f);
		
		font_size=new JMenu("Font-size");
		font_size.setFont(f);
		
		font_size.add(ten);
		font_size.add(elvn);
		font_size.add(twlv);
		font_size.add(thertn);
		font_size.add(frtn);
		
		
		areal=new JMenuItem("Arial Black");				// adding font style
		areal.setFont(ff_areal);
		calibri=new JMenuItem("Calibri");
		calibri.setFont(ff_calibri);
		comic=new JMenuItem("Comic Sans MS");			
		comic.setFont(ff_comic);		
		eras=new JMenuItem("Eras Medium ITC");
		eras.setFont(ff_eras);
		mt=new JMenuItem("Engravers MT");
		mt.setFont(ff_mt);
		
		font_style=new JMenu("Font-style");
		font_style.setFont(f);
		
		font_style.add(areal);
		font_style.add(calibri);
		font_style.add(comic);
		font_style.add(eras);
		font_style.add(mt);
		
		font=new JMenu("Font ");
		font.setForeground(Color.white);
		font.setFont(ff);
		font.add(font_size);
		font.add(font_style);
		
		view=new JMenu("View ");
		view.setForeground(Color.white);
		view.setFont(ff);
		
		help=new JMenu("Help ");
		help.setForeground(Color.white);
		help.setFont(ff);
		
		about_me=new JMenuItem("THIS NOTEPAD IS CREATED BY SOUNAK  it is fully made by JAVA SWING");		
		
		about=new JMenu("About ");
		about.setForeground(Color.white);
		about.setFont(ff);
		
		about.add(about_me);
		
		menubar=new JMenuBar();
		menubar.add(file);
		menubar.add(edit);
		menubar.add(font);
		menubar.add(view);
		menubar.add(help);
		menubar.add(about);
		
		Color c_menubar=new Color(0,170,90);
		menubar.setBackground(c_menubar);
		setJMenuBar(menubar);
		
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		file_saveas.addActionListener(this);
		file_print.addActionListener(this);
		file_exit.addActionListener(this);
		
		edit_cut.addActionListener(this);
		edit_copy.addActionListener(this);
		edit_paste.addActionListener(this);
		
		ten.addActionListener(this);
		elvn.addActionListener(this);
		twlv.addActionListener(this);
		thertn.addActionListener(this);
		frtn.addActionListener(this);
		
		areal.addActionListener(this);
		calibri.addActionListener(this);
		comic.addActionListener(this);
		eras.addActionListener(this);
		mt.addActionListener(this);
		
		addWindowListener(new WindowAdapter()		// do you want to save changes
		{
			public void windowClosing(WindowEvent ev)
			{
				int n;
				n=JOptionPane.showOptionDialog(null,"Do you want to save your changes?","Notepad",JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,null,null,null);
				
				if(n==JOptionPane.NO_OPTION)
				{
					System.exit(0);
				}
				else if(n==JOptionPane.CLOSED_OPTION)
				{
					setVisible(true);
				}
				else //if(n==JOptionPane.YES_OPTION);
				{
					try(FileWriter fw=new FileWriter(fc.getSelectedFile()))
					{
						BufferedWriter bw=new BufferedWriter(fw);
						Scanner sc1=new Scanner(ta1.getText());
						while(sc1.hasNext())
						{
							bw.write(sc1.nextLine());
							bw.newLine();
						}
						bw.close();
					}
					catch(IOException exp)
					{
						System.out.println(exp);
					}
				}
			}
		});
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==file_new)			// new file
		{
			ta1.setText(null);
		}
		if(e.getSource()==file_open)		// open filechooser
		{
			ta1.setText(null);
			
		/*	FileNameExtensionFilter filter=new FileNameExtensionFilter("txt","java");
			fc.setFileFilter(filter);	*/
			
			int n=fc.showOpenDialog(this);
			if(n==JFileChooser.APPROVE_OPTION)
			{
				try
				{
					Scanner sc=new Scanner(fc.getSelectedFile());
					while(sc.hasNext())
					{
						String str=sc.nextLine();
						ta1.setText(str+ta1.getText()+"\n");
					}  
				}  
				catch(FileNotFoundException exp)
				{
					exp.getMessage();
				}
			}
		}
		if(e.getSource()==file_save)		// save the file
		{
			int p=fc.showSaveDialog(this);		// showing the save-dialog box
			if(p==JFileChooser.APPROVE_OPTION)
			try(FileWriter fw=new FileWriter(fc.getSelectedFile()))
			{
				BufferedWriter bw=new BufferedWriter(fw);
				Scanner sc1=new Scanner(ta1.getText());
				while(sc1.hasNext())
				{
					bw.write(sc1.nextLine());
					bw.newLine();
				}
				bw.close();
			}
			catch(IOException exp)
			{
				System.out.println(exp);
			}
		}
		if(e.getSource()==file_saveas)			// save as 
		{
			fc.setDialogTitle("save as");
			int k=fc.showSaveDialog(this);		// same as the save method
			
			if(k==JFileChooser.APPROVE_OPTION)
			try(FileWriter fw1=new FileWriter(fc.getSelectedFile()))
			{
				BufferedWriter bw1=new BufferedWriter(fw1);
				Scanner sc2=new Scanner(ta1.getText());
				while(sc2.hasNext())
				{
					bw1.write(sc2.nextLine());
					bw1.newLine();
				}
				bw1.close();
			}
			catch(IOException exp)
			{
				System.out.println(exp);
			}
		
			
		}
		if(e.getSource()==file_print)
		{
			try{
				ta1.print();
			}
			catch(Exception exp)
			{
				System.out.println(exp);
			}
		}
		if(e.getSource()==file_exit){		// close the programe
			System.exit(0);
		}
		if(e.getSource()==edit_cut)			// cut method
		{
			ta1.cut();
		}
		if(e.getSource()==edit_copy)		// copy method
		{
			ta1.copy();
		}
		if(e.getSource()==edit_paste)		// paste method
		{
			ta1.paste();
		}
		if(e.getSource()==ten){				// font size
			ta1.setFont(f);
		}
		if(e.getSource()==elvn){
			
			String f_name = ta1.getFont().getName();
			f1=new Font(f_name,Font.PLAIN,24);		// font size  11
			ta1.setFont(f1);
		}
		if(e.getSource()==twlv){
			String ff_name = ta1.getFont().getName();
			f2=new Font(ff_name,Font.PLAIN,28);		// font size  12
			ta1.setFont(f2);
		}
		if(e.getSource()==thertn){
			String fff_name=ta1.getFont().getName();
			f3=new Font(fff_name,Font.PLAIN,32);		// font size  13
			ta1.setFont(f3);
		}
		if(e.getSource()==frtn){
			String ffff_name=ta1.getFont().getName();
			f4=new Font(ffff_name,Font.PLAIN,36);		// font size  14
			ta1.setFont(f4);
		}
		
		if(e.getSource()==areal)
		{
			int x1 = ta1.getFont().getSize();
			f_areal = new Font("Arial Black",Font.PLAIN,x1);
			ta1.setFont(f_areal);
		}
		if(e.getSource()==calibri)
		{
			int x2 = ta1.getFont().getSize();
			f_calibri = new Font("Calibri",Font.PLAIN,x2);
			ta1.setFont(f_calibri);
		}
		if(e.getSource()==comic)
		{
			int x3 = ta1.getFont().getSize();
			f_comic=new Font("Comic Sans MS",Font.PLAIN,x3);
			ta1.setFont(f_comic);
		}		
		if(e.getSource()==eras)
		{
			int x4 = ta1.getFont().getSize();
			f_eras = new Font("Eras Medium ITC",Font.PLAIN,x4);
			ta1.setFont(f_eras);
		}
		if(e.getSource()==mt)
		{
			int x5 = ta1.getFont().getSize();
			f_mt = new Font("Engravers MT",Font.PLAIN,x5);
			ta1.setFont(f_mt);
		}
	}
	public static void main(String args[])
	{
		Notepad obj=new Notepad();
		obj.function();
	}
}	