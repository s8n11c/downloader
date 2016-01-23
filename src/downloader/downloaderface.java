package downloader;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JProgressBar;
import javax.swing.JSlider;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.annotation.Generated;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import com.sun.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
public class downloaderface {
    public boolean flag=false;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private File filename;
    public static Boolean isdownloading=false;
	public JLabel label;
	public JLabel label_1;
	JLabel lblNewLabel_3;
	JLabel label_3;
	JProgressBar progressBar;
	JScrollPane jsp;

    /**
	 * Launch the application
	 */
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					downloaderface window = new downloaderface();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public downloaderface() throws MalformedURLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Dimension dim;
	JTextArea textField_2;
	private void initialize() throws MalformedURLException {
		frame = new JFrame();
		frame.setBounds(700, 800, 700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setBackground(new Color (0,0,0,0));
        frame.setLocationRelativeTo(null);
     	frame.setTitle("GUI_DOWNLOADER");
	Modified_panel panel = new Modified_panel();
	     
		panel.setBounds(216, 25, 478, 269);
		frame.getContentPane().add(panel);
		
		 progressBar = new JProgressBar();
		 progressBar.setBounds(15, 197, 421, 35);
		frame.setResizable(false);
		panel.setLayout(null);
		panel.add(progressBar);
		downloaderface now = this;
		JFileChooser JFC = new JFileChooser("/");
		textField = new JTextField();
		textField.setBounds(61, 85, 301, 27);
		panel.add(textField);
		
		textField.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL: ");
		lblUrl.setBounds(15, 62, 31, 15);
		panel.add(lblUrl);
		
		textField_1 = new JTextField();
		textField_1.setBounds(58, 56, 304, 27);
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				
			}
		});
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTo = new JLabel("Save to :");
		lblTo.setBounds(6, 91, 59, 15);
		panel.add(lblTo);
		
		JLabel lblFilename = new JLabel("FileName:");
		lblFilename.setBounds(15, 124, 61, 15);
		panel.add(lblFilename);
		
		JLabel lblFileSizeb = new JLabel("transSpeed:");
		lblFileSizeb.setBounds(93, 151, 96, 15);
		panel.add(lblFileSizeb);
		JButton btnShowMore = new JButton("show more");
		btnShowMore.setBounds(190, 237, 96, 27);
		panel.add(btnShowMore);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 478, 27);
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("min.png")));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			  frame.setState(Frame.ICONIFIED);
			}
		});
		lblNewLabel.setBackground(SystemColor.inactiveCaptionBorder);
		//lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(431, 6, 18, 15);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(getClass().getResource("close.png")));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			System.exit(0);
			}
		});
		lblNewLabel_1.setBackground(SystemColor.inactiveCaptionBorder);
	//	lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(454, 6, 18, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblGuidownloader = new JLabel("GUI_DOWNLOADER");
		lblGuidownloader.setBounds(187, 6, 160, 15);
		panel_1.add(lblGuidownloader);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(getClass().getResource("download_button.png")));
		lblNewLabel_2.setBounds(364, 56, 111, 27);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("download_button2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("download_button.png")));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO download button
				if(isdownloading){
					JOptionPane.showMessageDialog(null, "wait there is a file is being downloading");
					return;
				}
				
					if(textField.getText().equals("")){
						textField.setText(JOptionPane.showInputDialog("Choose where to save your file"));
				return ;
			}
			if(textField_1.getText().equals("")){
			textField_1.setText(JOptionPane.showInputDialog("your URL"));
			return;
			}
			maddamn nnn = new maddamn(textField_1.getText(), textField.getText(), now);
			Thread T = new Thread(nnn);
			T.start();
			}
		});
		panel.add(lblNewLabel_2);
		
		 lblNewLabel_3 = new JLabel(new ImageIcon(getClass().getResource("browse_button.png")));
		 lblNewLabel_3.setBounds(374, 85, 85, 27);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("browse_button2.png")));			
			}
			@Override
			public void mouseExited(MouseEvent e) {
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("browse_button.png")));			
								
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO choose file
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("select A directory to save to :");
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int retrnval = jfc.showOpenDialog(null);
				if(retrnval == JFileChooser.APPROVE_OPTION){
					filename=jfc.getSelectedFile();
					textField.setText(filename.getAbsolutePath());
				}
			}
		});
		panel.add(lblNewLabel_3);
		
		label = new JLabel("");
		label.setBounds(88, 124, 371, 15);
		panel.add(label);
		
	     label_1 = new JLabel("");
	     label_1.setBounds(173, 151, 185, 15);
		panel.add(label_1);
		
		 label_3 = new JLabel("0%");
		 label_3.setBounds(435, 197, 37, 35);
		label_3.setToolTipText("0%");
		panel.add(label_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 276, 443, 87);
		panel.add(scrollPane_1);
		
		textField_2 = new JTextArea();
		scrollPane_1.setViewportView(textField_2);
		 scrollPane_1.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		 DefaultCaret caret = (DefaultCaret)textField_2.getCaret();
		 caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		textField_2.setColumns(10);
		//------------------------------------------------------------------------
		


		//--------------------------------------------------------------------------
		JLabel label_2 = new JLabel(new ImageIcon(getClass().getResource("Render 4.png")));
		label_2.setBounds(6, -77, 215, 401);
		frame.getContentPane().add(label_2);
		
		btnShowMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//layeredPane.setVisible(true);
				if(flag==false){
		//	frame.setBounds(100, 100, 500, 270);
			btnShowMore.setText("show less ");
		   panel.setBounds(216, 0, 478,  368);
			flag=true;

		    frame.setSize(700, 400);
			frame.setLocationRelativeTo(null);
			}else {
		
				btnShowMore.setText("show more");
	
				panel.setBounds(216, 0, 478,  269);
			
				flag=false;
				frame.setSize(700, 275);
				frame.setLocationRelativeTo(null);
				}
			}
		});
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frame.getContentPane()}));
	}
}
 // modifing the jpanel class for shape 
class Modified_panel extends JPanel{
	@Override
	protected void paintComponent(Graphics g ){
		super.paintComponent(g);
		 BufferedImage img;
		try {
			img = ImageIO.read(new File(getClass().getResource("gray_background.png").toURI()));
			g.drawImage(img, 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
class maddamn implements Runnable {
	private String url, dirname;
	public  maddamn(String url,String dirname,downloaderface now){
		this.url=url; this.dirname=dirname; this.now=now;
	}
	int bufferSize=1024;	
    long call =0;
	downloaderface now=null;
	public void run() {
		DownloaderInfo down = new DownloaderInfo(now);
		try {
			down.downloadfile(this.url);
			//System.out.println("the name :"+down.getFileName()+"the size :"+down.getContentLength());
			now.label.setText(down.getFileName()+", SIZE= "+(down.getContentLength())/(1024*1024) +". MBytes");
			
			String savefilepath=this.dirname+File.separator+down.getFileName();
			InputStream inputstream = down.getInputStream();
			
			FileOutputStream outputstream = new FileOutputStream(savefilepath);
			
			byte buffer [] = new byte[bufferSize];
			int bytesread=-1;
			long totalBytesRead = 0;
            int percentCompleted = 0;
            long fileSize = down.getContentLength();
            downloaderface.isdownloading=true;
            int scroll;
            DefaultCaret caret = (DefaultCaret)now.textField_2.getCaret();
            long starttime=System.nanoTime();
            long estimate;
           while ((bytesread = inputstream.read(buffer)) != -1) {
        	   estimate=System.nanoTime()-starttime;
                outputstream.write(buffer, 0, bytesread);
                totalBytesRead += bytesread;
                percentCompleted = (int) (totalBytesRead * 100 / fileSize);
                now.label_3.setText(percentCompleted+"%");
                now.progressBar.setValue(percentCompleted);
                Date dnow = new Date(); 
                now.label_1.setText((estimate*10)/1024+"KBps");
                if(call==50){
                	
                	now.textField_2.selectAll();
                    scroll=now.textField_2.getSelectionEnd();
                    now.textField_2.select(scroll,scroll); 
                	now.textField_2.setText(now.textField_2.getText()+"\n"+"["+dnow.toString()+"]"+percentCompleted+"%");	
                	caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
             		
                	call=0;}
                call++;
                starttime=System.nanoTime();
            }
            downloaderface.isdownloading=false;
              now.progressBar.setValue(percentCompleted);   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			now.textField_2.setText(e.getMessage());
		}
	}
	}	

