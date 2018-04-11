import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
 
/*
 * This is a simple Fractal tree.
 * This is drawing the lines recursively 
 * */
public class FractalTree extends JFrame {
 
    public FractalTree() {
        super("Fractal Tree");
        setBounds(300, 300, 800, 800);
        // x, y width, height for screen position and the frame size.
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth)
    {
    	double branch_height =10;
    	double branch_width =10;
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * branch_width);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * branch_height);
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - 35, depth - 1);
        // draw left branches
        drawTree(g, x2, y2, angle + 20, depth - 1);
        // draw right branches
    }
 
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        drawTree(g, 400, 600, -90, 10);
        // graph, x1, y1, angle, depth
    }
 
    public static void main(String[] args) {
        new FractalTree().setVisible(true);
    }
}