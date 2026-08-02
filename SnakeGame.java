import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SnakeGame extends JFrame {

    public SnakeGame() {
        this.add(new GamePanel());
        this.setTitle("Java Swing Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnakeGame::new);
    }
}

class GamePanel extends JPanel implements ActionListener {

    // Board Configuration
    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int TILE_SIZE = 25;
    private static final int TOTAL_TILES = (SCREEN_WIDTH * SCREEN_HEIGHT) / (TILE_SIZE * TILE_SIZE);
    private static final int DELAY = 140; // Game speed (ms)

    // Snake Body Coordinates & State
    private final int[] x = new int[TOTAL_TILES];
    private final int[] y = new int[TOTAL_TILES];
    private int bodyParts = 3;
    private int applesEaten = 0;
    private int appleX;
    private int appleY;

    // Movement Direction
    private char direction = 'R'; // 'U', 'D', 'L', 'R'
    private boolean running = false;
    private Timer timer;
    private final Random random = new Random();

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    private void startGame() {
        spawnApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        if (running) {
            // Draw Apple
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, TILE_SIZE, TILE_SIZE);

            // Draw Snake
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN); // Head
                } else {
                    g.setColor(new Color(45, 180, 0)); // Body
                }
                g.fillRect(x[i], y[i], TILE_SIZE, TILE_SIZE);
            }

            // Draw Scoreboard
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.BOLD, 18));
            g.drawString("Score: " + applesEaten, 15, 30);
        } else {
            gameOver(g);
        }
    }

    private void spawnApple() {
        appleX = random.nextInt(SCREEN_WIDTH / TILE_SIZE) * TILE_SIZE;
        appleY = random.nextInt(SCREEN_HEIGHT / TILE_SIZE) * TILE_SIZE;
    }

    private void move() {
        // Shift body coordinates backward
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        // Move head based on active direction
        switch (direction) {
            case 'U' -> y[0] -= TILE_SIZE;
            case 'D' -> y[0] += TILE_SIZE;
            case 'L' -> x[0] -= TILE_SIZE;
            case 'R' -> x[0] += TILE_SIZE;
        }
    }

    private void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            spawnApple();
        }
    }

    private void checkCollisions() {
        // Check if head hits body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }
        }

        // Check if head hits walls
        if (x[0] < 0 || x[0] >= SCREEN_WIDTH || y[0] < 0 || y[0] >= SCREEN_HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    private void gameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("SansSerif", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2 - 20);

        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.PLAIN, 20));
        FontMetrics scoreMetrics = getFontMetrics(g.getFont());
        g.drawString("Final Score: " + applesEaten, (SCREEN_WIDTH - scoreMetrics.stringWidth("Final Score: " + applesEaten)) / 2, SCREEN_HEIGHT / 2 + 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> {
                    if (direction != 'R') direction = 'L';
                }
                case KeyEvent.VK_RIGHT -> {
                    if (direction != 'L') direction = 'R';
                }
                case KeyEvent.VK_UP -> {
                    if (direction != 'D') direction = 'U';
                }
                case KeyEvent.VK_DOWN -> {
                    if (direction != 'U') direction = 'D';
                }
            }
        }
    }
}