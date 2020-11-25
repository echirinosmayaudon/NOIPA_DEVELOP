package it.gov.mef.shared.utility.bi;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.StreamSupport;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// TODO: Auto-generated Javadoc
/**
 * Classe di utilità per la gestione delle colori 
 * da mostrare nei grafici e legende.
 *
 * @author d.brandi
 */
public class UtilityColori {
	
	/** The Constant PRIMARY_COLOR_DELTA. */
	private static final int PRIMARY_COLOR_DELTA = -30;


	/** The Constant DEFAULT_INPUT_TYPE_COLOR. */
	public static final String DEFAULT_INPUT_TYPE_COLOR = "#000000";


	/** The Constant DEFAULT_ACTIVATION_COLOR. */
	public static final String DEFAULT_ACTIVATION_COLOR = "#00B414";
	
	/** The Constant DEFAULT_SUSPENSION_COLOR. */
	public static final String DEFAULT_SUSPENSION_COLOR = "#D20014";	

	/** The Constant DEFAULT_ENTI_BASE_COLOR. */
	public static final List<String> DEFAULT_ENTI_BASE_COLOR;

	static {
		List<String> temp = new ArrayList<>();
		temp.add("#FF0000");
		temp.add("#00FF00");
		temp.add("#0000FF");
		temp.add("#FFFF00");	// giallo
		temp.add("#FF7814");	// arancio
		DEFAULT_ENTI_BASE_COLOR = Collections.unmodifiableList(temp);
	}
	
	/** The Constant DEFAULT_ENTE_ALTRO_COLOR. */
	public static final String DEFAULT_ENTE_ALTRO_COLOR = "#000000";

	/** The Constant DEFAULT_DETT_IMPOSTE_COLOR. */
	public static final List<String> DEFAULT_DETT_IMPOSTE_COLOR;

	static {
		List<String> temp = new ArrayList<>();
		temp.add("#FF0000");
		temp.add("#00FF00");
		temp.add("#0000FF");
		temp.add("#FFFF00");
		temp.add("#FF7814");
		temp.add("#148200");
		temp.add("#FFC0CB");
		temp.add("#00FFFF");
		temp.add("#3C3278");
		temp.add("#646464");
		temp.add("#646464");
		DEFAULT_DETT_IMPOSTE_COLOR = Collections.unmodifiableList(temp);
	}
	
	/**
	 * Gets the list colori.
	 *
	 * @param baseColor the base color
	 * @param colorNumber the color number
	 * @param excludeBaseColor the exclude base color
	 * @return lista di n colori (n= colorNumber) in formato esadecimale
	 * che sfumano a partire dal colore baseColor e contengono o no 
	 * il colore passato come paratero di ingresso tramite il flag excludeBaseColor
	 */
	private static List<String> getListColori(Color baseColor, int colorNumber,boolean excludeBaseColor) {
		int sizeColor = colorNumber;
		if(excludeBaseColor) {
			sizeColor++;
		}
		String[] arrayColori = new String[sizeColor];
		int i = 0;
		List<Color> calculateShades = calculateShades(baseColor, sizeColor);
		for(Color color : calculateShades) {
			if(!excludeBaseColor || !baseColor.equals(color)) {
				String hexColour = Integer.toHexString(color.getRGB() & 0xffffff);
				if (hexColour.length() < 6) {
					hexColour = "000000".substring(0, 6 - hexColour.length()) + hexColour;
				}
				arrayColori[i++] = "#" + hexColour;
			}
		}
		return Arrays.asList(arrayColori);
	}
	
	/**
	 * Gets the map colori.
	 *
	 * @param baseColor the base color
	 * @param listObject the list object
	 * @return the map colori
	 */
	public static Map<String,String> getMapColori(Color baseColor, Set<String> listObject) {
		return getMapColori(baseColor, listObject, false);
	}
	
	/**
	 * Gets the map colori escludi base color.
	 *
	 * @param baseColor the base color
	 * @param listObject the list object
	 * @return the map colori escludi base color
	 */
	public static Map<String,String> getMapColoriEscludiBaseColor(Color baseColor, Set<String> listObject) {
		return getMapColori(baseColor, listObject, true);
	}
	
	/**
	 * Gets the map colori.
	 *
	 * @param baseColor the base color
	 * @param listObject the list object
	 * @param excludeBaseColor the exclude base color
	 * @return restituisce una mappa dove viene associato ad ogni oggetto
	 * dell'insieme di ingresso listObject una sfumatura creata
	 * a partire dal colore baseColor, ed escludendo o no 
	 * il colore passato come input in base al flag excludeBaseColor
	 */
	private static Map<String,String> getMapColori(Color baseColor, Set<String> listObject,boolean excludeBaseColor) {
		HashMap<String,String> mapResult = new HashMap<>();
		List<String> listColori = getListColori(baseColor, listObject.size(),excludeBaseColor);

		Iterator<String> itColori = listColori.iterator();

		StreamSupport.stream(listObject.spliterator(),false).forEach(object -> mapResult.put(object, itColori.next()));

		return mapResult;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new UtilityColori();
	}
	
	/**
	 * Calculate shades.
	 *
	 * @param baseColor the base color
	 * @param numberShades the number shades
	 * @return lista di n colori (n= numberShades) che sfumano
	 * a partire dal colore baseColor
	 */
	public static List<Color> calculateShades(Color baseColor, int numberShades)
	{
		//decompose color into RGB
		int redMax  = baseColor.getRed();
		int greenMax  = baseColor.getGreen();
		int blueMax  = baseColor.getBlue();


		//Max color component in RGB
		final int MAX_COMPONENT = 255;

		//bin sizes for each color component
		int redDelta = redMax!=MAX_COMPONENT?((MAX_COMPONENT - redMax) / numberShades):PRIMARY_COLOR_DELTA/numberShades;
		int greenDelta = greenMax!=MAX_COMPONENT?((MAX_COMPONENT - greenMax) / numberShades):PRIMARY_COLOR_DELTA/numberShades;
		int blueDelta = blueMax!=MAX_COMPONENT?((MAX_COMPONENT - blueMax) / numberShades):PRIMARY_COLOR_DELTA/numberShades;
		//		int redDelta = (MAX_COMPONENT - redMax) / numberShades;
		//		int greenDelta = (MAX_COMPONENT - greenMax) / numberShades;
		//		int blueDelta = (MAX_COMPONENT - blueMax) / numberShades;

		List<Color> colors = new ArrayList<Color>();

		int redCurrent = redMax;
		int greenCurrent = greenMax;
		int blueCurrent = blueMax;

		//now step through each shade, and decrease darkness by adding color to it
		for(int i = 0; i < numberShades; i++)
		{
			if(i!=0) {
				//step up by the bin size, but stop at the max color component (255)
				redCurrent = (redCurrent+redDelta) < MAX_COMPONENT ? (redCurrent + redDelta ) : MAX_COMPONENT;
				greenCurrent = (greenCurrent+greenDelta) < MAX_COMPONENT ? (greenCurrent + greenDelta ) : MAX_COMPONENT;
				blueCurrent = (blueCurrent+blueDelta) < MAX_COMPONENT ? (blueCurrent + blueDelta ) : MAX_COMPONENT;
			}
			Color nextShade = new Color(redCurrent, greenCurrent, blueCurrent);
			colors.add(nextShade);
		}

		return colors;
	}
	
	/**
	 *  classi e metodi per TEST.
	 */
	public UtilityColori() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				}

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				frame.add(new TestPane());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	/**
	 * The Class TestPane.
	 */
	public class TestPane extends JPanel {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/** The bands pane. */
		private JPanel bandsPane;
		
		/** The slider. */
		private JSlider slider;
		
		/** The change timer. */
		private Timer changeTimer;

		/**
		 * Instantiates a new test pane.
		 */
		public TestPane() {
			bandsPane = new JPanel(new GridBagLayout());
			slider = new JSlider(1, 100);
			setLayout(new BorderLayout());
			add(new JScrollPane(bandsPane));
			add(slider, BorderLayout.SOUTH);
			slider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					changeTimer.restart();
				}
			});

			changeTimer = new Timer(250, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int bands = slider.getValue();
					List<Color> bandsList = calculateShades(Color.RED, bands);
					bandsPane.removeAll();
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridwidth = GridBagConstraints.REMAINDER;
					gbc.insets = new Insets(1, 1, 1, 1);
					for (Color color : bandsList) {
						bandsPane.add(new ColorBand(color), gbc);
					}
					gbc.weighty = 1;
					bandsPane.add(new JPanel(), gbc);
					revalidate();
					repaint();
				}
			});
			changeTimer.setRepeats(false);
			slider.setValue(1);
		}

		/* (non-Javadoc)
		 * @see javax.swing.JComponent#getPreferredSize()
		 */
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(200, 200);
		}
	}

	/**
	 * The Class ColorBand.
	 */
	public class ColorBand extends JPanel {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/**
		 * Instantiates a new color band.
		 *
		 * @param color the color
		 */
		public ColorBand(Color color) {
			setBackground(color);
		}

		/* (non-Javadoc)
		 * @see javax.swing.JComponent#getPreferredSize()
		 */
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(100, 20);
		}

	}
}
