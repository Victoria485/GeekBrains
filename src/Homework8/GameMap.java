package Homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Scanner;

public class GameMap extends JPanel {
    public static final int MODE_VS_AI = 0;
    public static final int MODE_VS_HUMAN = 1;
    public static final Random RANDOM = new Random();
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;
    private static final int DOT_EMPTY = 0;
    private static final int DOT_PADDING = 7;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private int stateGameOver;
    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private boolean isGameOver;
    private boolean isInitialized;
    private int gameMode;
    private int playerNumTurn;

    private int scoreHuman;
    private int scoreAI;

    public GameMap() {
        isInitialized = false;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) return;
        int dot = gameMode == MODE_VS_AI ? DOT_HUMAN : playerNumTurn == 1 ? DOT_HUMAN : DOT_AI;
        if (!playerTurn(e, dot)) return;
        if (gameCheck(dot, STATE_WIN_HUMAN)) return;
        if (gameMode == MODE_VS_AI) {
            aiTurn();
            repaint();
            if (gameCheck(DOT_AI, STATE_WIN_AI)) return;
        }
    }

    private boolean playerTurn(MouseEvent event, int dot) {
        int cellX = event.getX() / cellWidth;
        int cellY = event.getY() / cellHeight;
        if (!isCellValid(cellY, cellX) || !isCellEmpty(cellY, cellX)) return false;
        field[cellY][cellX] = dot;
        repaint();
        playerNumTurn = playerNumTurn == 1 ? 2 : 1;
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) return;
        int width = getWidth();
        int height = getHeight();
        cellHeight = height / fieldSizeY;
        cellWidth = width / fieldSizeX;
        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) continue;
                if (field[y][x] == DOT_HUMAN) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == DOT_AI) {
                    g.setColor(Color.RED);
                    g.fillRect(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                }
            }
        }

        if (isGameOver) {
            showGameOverMessage(g);
        }
    }

    private void showGameOverMessage(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, getHeight() / 2 - 60, getWidth(), 120);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 58));
        switch (stateGameOver) {
            case STATE_DRAW:
                g.drawString("DRAW!!!", getWidth() / 4, getHeight() / 2);
                break;
            case STATE_WIN_HUMAN:
                g.drawString("HUMAN Wins!", getWidth() / 4, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString("AI Wins", getWidth() / 4, getHeight() / 2);
                break;
        }
    }

    private  boolean gameCheck(int dot, int stateGameOver) {
        if (checkWin(dot, winLength)) {
            this.stateGameOver = stateGameOver;
            isGameOver = true;
            repaint();
            return true;
        }
        if (checkDraw()) {
            this.stateGameOver = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) return false;
            }
        }
        return true;
    }

    private void aiTurn()
    {
        int x, y;

        do
        {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(y, x));

        field[y][x] = DOT_AI;
    }

    private boolean checkWin(int dot, int winLength)
    {
        for (int y = 0; y < fieldSizeY; y++) {
            int sumHor = 0;
            int sumVer = 0;
            int sumDiag1 = 0;
            int sumDiag2 = 0;
            for (int x = 0; x < fieldSizeX; x++)
            {
                if (field[y][x] == dot) sumHor += 1;
                else sumHor = 0;
                if (sumHor == winLength) return true;
                if (field[x][y] == dot) sumVer += 1;
                else sumVer = 0;
                if (sumVer == winLength) return true;
                if (field[x][x] == dot) sumDiag1 += 1;
                else sumDiag1 = 0;
                if (sumDiag1 == winLength) return true;
                if (field[x][fieldSizeX - x - 1] == dot) sumDiag2 += 1;
                else sumDiag2 = 0;
                if (sumDiag2 == winLength) return true;
            }
        }
        return false;
    }

    private boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private boolean isCellEmpty(int y, int x) {
        return field[y][x] == DOT_EMPTY;
    }

    public void startNewGame(int gameMode, int fieldSize, int winLength) {
        this.gameMode = gameMode;
        this.fieldSizeX = this.fieldSizeY = fieldSize;
        this.winLength = winLength;
        this.playerNumTurn = 1;
        field = new int[fieldSizeY][fieldSizeX];
        isInitialized = true;
        isGameOver = false;
        repaint();
    }
}