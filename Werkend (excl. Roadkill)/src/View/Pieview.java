package src.View;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import org.jfree.chart.plot.PiePlot;
import src.Model.*;
import org.jfree.chart.*;
import org.jfree.data.general.*;



public class Pieview extends AbstractView{
	private JFreeChart chart;
 	private PiePlot plot;
 	private ChartPanel chartPanel;
	
 	public Pieview(){
		chartPanel = new ChartPanel(createChart(createDataset(2)));
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		
	}
 	
	public PieDataset createDataset(int x) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Vossen", x);
		dataset.setValue("Konijnen", x);
		dataset.setValue("Gras", x);
		dataset.setValue("Black mamba", x);
		return dataset;
	}
	
	private JFreeChart createChart(PieDataset dataset) {
		chart = ChartFactory.createPieChart(
		"Population", // chart title
		dataset, // data
		true, // include legend
		true, // tooltips
		false	// urls
		);
		plot = (PiePlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setInteriorGap(0.02);
		plot.setOutlineVisible(false);
		plot.setSectionPaint("Vossen", Color.blue);
		plot.setSectionPaint("Konijnen", Color.yellow);
		plot.setSectionPaint("Gras", Color.green);
		plot.setSectionPaint("Black mamba", Color.black);
		return chart;
	}
 	
 	public PieDataset createDataset() {
 		DefaultPieDataset dataset = new DefaultPieDataset();
 		dataset.setValue("Vossen", 1);
 		dataset.setValue("Konijnen", 1);
 		dataset.setValue("Gras", 1);
 		dataset.setValue("Black mamba", 1);
 		return dataset;
	}
 	
	
 	public ChartPanel getPanel() {
 		return chartPanel;
 	}
 	
 	@Override
 	public void updateView(){
 		plot.setDataset(createDataset());
 		repaint();
 	}
}