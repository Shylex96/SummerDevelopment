import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, MouseListener {

    private static final long serialVersionUID = 1L;

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 2;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'D';
    boolean running = false;
    boolean paused = false;
    boolean gameOver = false;
    Timer timer;
    Random random;
    private int initialX;
    private int initialY;
    private boolean initialPositionSaved = false;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.addMouseListener(this);
        
        startGame();
    }

    public void startGame() {
        if (!initialPositionSaved) {
            initialX = x[0];
            initialY = y[0];
            initialPositionSaved = true;
        }

        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        if (running) {
            // To make it easier to see the size of the board

            /*
             * for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
             * 
             * g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT); g.drawLine(0,
             * i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE); }
             */

            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

            g.setColor(Color.RED);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
                    g.getFont().getSize());
        }

        // Pause String
        if (paused) {
            g.setColor(Color.RED);
            g.setFont(new Font("Ink Free", Font.BOLD, 50));
            FontMetrics metricsP = getFontMetrics(g.getFont());
            g.drawString("PAUSED", (SCREEN_WIDTH - metricsP.stringWidth("PAUSED")) / 2, SCREEN_HEIGHT / 2);
        } else if (!running) {
            gameOver(g);
        }
    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'W':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                x[0] = x[0] + UNIT_SIZE;
                break;
            case 'A':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'S':
                y[0] = y[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        if (x[0] < 0) {
            running = false;
        }
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }
        if (y[0] < 0) {
            running = false;
        }
        if (y[0] > SCREEN_HEIGHT - UNIT_SIZE) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        gameOver = true;

        // Game Over
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics1.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2 - 75);

        // Score
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics2.stringWidth("Score: " + applesEaten)) / 2,
                g.getFont().getSize() + 275);

        // Retry
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics3 = getFontMetrics(g.getFont());
        g.drawRect(225, 460, 150, 60);
        g.drawString("Retry", (SCREEN_WIDTH - metrics3.stringWidth("Retry")) / 2, SCREEN_HEIGHT / 2 + 200);
    }

    public void restartGame() {
        // Reset all variables to their initial values
        bodyParts = 2;
        applesEaten = 0;
        direction = 'D';
        running = false;
        paused = false;
        gameOver = false;

        // Reset snake position to the initial positions
        x[0] = initialX;
        y[0] = initialY;
        for (int i = 1; i < bodyParts; i++) {
            x[i] = x[0] - i * UNIT_SIZE;
            y[i] = y[0];
        }

        // Start a new game
        newApple();
        running = true;
        timer.start();

        // Repaint the panel to update the game state
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!paused) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            if (gameOver == false) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE:
                        paused = !paused;
                        if (paused) {
                            timer.stop();
                            repaint();
                        } else {
                            timer.start();
                        }
                        break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        if (direction != 'D') {
                            direction = 'A';
                        }
                        break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        if (direction != 'A') {
                            direction = 'D';
                        }
                        break;
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        if (direction != 'S') {
                            direction = 'W';
                        }
                        break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        if (direction != 'W') {
                            direction = 'S';
                        }
                        break;
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	
    	// If GameOver Screen is active
        int mouseX = e.getX();
        int mouseY = e.getY();

        // Check if the click is inside the "Retry" button area
        if (mouseX >= 225 && mouseX <= 375 && mouseY >= 460 && mouseY <= 520) {
            restartGame();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
