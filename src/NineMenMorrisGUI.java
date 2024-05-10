import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class NineMenMorrisGUI extends JPanel {
  private NineMenMorrisBoard board;

  public NineMenMorrisGUI() {

    board = new NineMenMorrisBoard();

    // To create user interface
    setLayout(new BorderLayout());
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    leftPanel.setPreferredSize(new Dimension(200, 700)); // Adjust the width as needed
    leftPanel.setBackground(Color.LIGHT_GRAY);

    // Player 1 information
    JLabel player1Label = new JLabel("Player 1 (White)");
    leftPanel.add(player1Label, gbc);
    Font newFont = new Font(player1Label.getFont().getName(), Font.BOLD, 20);
    player1Label.setFont(newFont);
    JLabel player1PiecesLabel = new JLabel("Number Of Pieces Remaining :");
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.CENTER;
    leftPanel.add(player1PiecesLabel, gbc);
    Font newFont2 = new Font(player1PiecesLabel.getFont().getName(), Font.BOLD, 12);
    player1PiecesLabel.setFont(newFont2);
    JLabel player1PiecesCount = new JLabel("" + board.getWhitePieces());
    gbc.gridy = 2;
    leftPanel.add(player1PiecesCount, gbc);
    Font newFont1 = new Font(player1PiecesCount.getFont().getName(), Font.BOLD, 42); // Adjust the
                                                                                     // font size as
                                                                                     // needed
    player1PiecesCount.setFont(newFont1);
    JLabel player1TurnLabel = new JLabel("Player 1 Turn");
    gbc.gridy = 3;
    leftPanel.add(player1TurnLabel, gbc);
    player1TurnLabel.setFont(newFont);
    JPanel rightPanel = new JPanel();
    rightPanel.setPreferredSize(new Dimension(200, 700));
    rightPanel.setBackground(Color.LIGHT_GRAY);
    rightPanel.setLayout(new GridBagLayout());


    // Player 2 information
    JLabel player2Label = new JLabel("Player 2 (Black)");
    GridBagConstraints gbc1 = new GridBagConstraints();
    rightPanel.add(player2Label, gbc1);
    player2Label.setFont(newFont);
    JLabel player2PiecesLabel = new JLabel("Number Of Pieces Remaining :");
    gbc1.gridy = 1;
    rightPanel.add(player2PiecesLabel, gbc1);
    player2PiecesLabel.setFont(newFont2);
    JLabel player2PiecesCount = new JLabel("" + board.getBlackPieces());
    gbc1.gridy = 2;
    rightPanel.add(player2PiecesCount, gbc1);
    player2PiecesCount.setFont(newFont1);
    JLabel player2TurnLabel = new JLabel("Player 2 Turn");
    player2TurnLabel.setVisible(false);
    player2TurnLabel.setFont(newFont);
    gbc1.gridy = 3;
    rightPanel.add(player2TurnLabel, gbc1);


    // Board Panel
    JPanel boardPanel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4)); // Adjust the width (4 in this example)

        int cellWidth = getWidth() / 7;
        int cellHeight = getHeight() / 7;
        int ovalSize = Math.min(cellWidth, cellHeight) - 50; // Adjust size as needed

        setBackground(Color.LIGHT_GRAY);
        g2d.setColor(Color.black);
        g2d.drawLine(3 * cellWidth + cellWidth / 2, cellWidth / 2, 3 * cellWidth + cellWidth / 2,
            2 * cellHeight + cellHeight / 2);
        g2d.drawLine(3 * cellWidth + cellWidth / 2, 4 * cellHeight + cellHeight / 2,
            3 * cellWidth + cellWidth / 2, 6 * cellHeight + cellHeight / 2);
        g2d.drawLine(cellHeight / 2, 3 * cellHeight + cellHeight / 2, 2 * cellWidth + cellWidth / 2,
            3 * cellHeight + cellHeight / 2);
        g2d.drawLine(4 * cellWidth + cellWidth / 2, 3 * cellHeight + cellHeight / 2,
            6 * cellWidth + cellWidth / 2, 3 * cellHeight + cellHeight / 2);
        g2d.drawLine(cellHeight / 2, 6 * cellHeight + cellHeight / 2, 6 * cellWidth + cellWidth / 2,
            6 * cellHeight + cellHeight / 2);
        g2d.drawLine(cellHeight / 2, cellHeight / 2, 6 * cellWidth + cellWidth / 2, cellHeight / 2);
        g2d.drawLine(cellHeight + cellHeight / 2, cellHeight + cellHeight / 2,
            5 * cellWidth + cellWidth / 2, cellHeight + cellHeight / 2);
        g2d.drawLine(cellHeight + cellHeight / 2, 5 * cellHeight + cellHeight / 2,
            5 * cellWidth + cellWidth / 2, 5 * cellHeight + cellHeight / 2);
        g2d.drawLine(1 * cellWidth + cellWidth / 2, cellHeight + cellHeight / 2,
            cellWidth + cellWidth / 2, 5 * cellHeight + cellHeight / 2);
        g2d.drawLine(5 * cellWidth + cellWidth / 2, cellHeight + cellHeight / 2,
            5 * cellWidth + cellWidth / 2, 5 * cellHeight + cellHeight / 2);
        g2d.drawLine(2 * cellWidth + cellWidth / 2, 2 * cellHeight + cellHeight / 2,
            2 * cellWidth + cellWidth / 2, 4 * cellHeight + cellHeight / 2);
        g2d.drawLine(4 * cellWidth + cellWidth / 2, 2 * cellHeight + cellHeight / 2,
            4 * cellWidth + cellWidth / 2, 4 * cellHeight + cellHeight / 2);
        g2d.drawLine(cellHeight / 2, 6 * cellHeight + cellHeight / 2, cellHeight / 2,
            cellHeight / 2);
        g2d.drawLine(6 * cellWidth + cellWidth / 2, cellHeight / 2, 6 * cellWidth + cellWidth / 2,
            6 * cellHeight + cellHeight / 2);
        g2d.drawLine(2 * cellWidth + cellWidth / 2, 2 * cellHeight + cellHeight / 2,
            4 * cellWidth + cellWidth / 2, 2 * cellHeight + cellHeight / 2);
        g2d.drawLine(4 * cellWidth + cellWidth / 2, 4 * cellHeight + cellHeight / 2,
            2 * cellWidth + cellWidth / 2, 4 * cellHeight + cellHeight / 2);

        g2d.setColor(Color.black);

        // Draw pieces on the board based on boardState
        for (int row = 0; row < 7; row++) {
          for (int col = 0; col < 7; col++) {

            int player = board.getBoardState()[row][col];
            if (player == 1) {
              ovalSize = Math.min(cellWidth, cellHeight) - 40; // Adjust size as needed
              g.setColor(Color.WHITE);
              g.fillOval(col * cellWidth + (cellWidth - ovalSize) / 2,
                  row * cellHeight + (cellHeight - ovalSize) / 2, ovalSize, ovalSize);
            } else if (player == 2) {
              ovalSize = Math.min(cellWidth, cellHeight) - 40; // Adjust size as needed
              g.setColor(Color.BLACK);
              g.fillOval(col * cellWidth + (cellWidth - ovalSize) / 2,
                  row * cellHeight + (cellHeight - ovalSize) / 2, ovalSize, ovalSize);
            } else {
              ovalSize = Math.min(cellWidth, cellHeight) - 50; // Adjust size as needed
              if (board.isValidIntersecction(row, col)) {
                g.setColor(Color.GRAY); // Change color as needed
                g.fillOval(col * cellWidth + (cellWidth - ovalSize) / 2,
                    row * cellHeight + (cellHeight - ovalSize) / 2, ovalSize, ovalSize);
              }
            }
          }
        }

      }
    };

    boardPanel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked at row " + e);

        int mouseX = e.getX();
        int mouseY = e.getY();

        int cellWidth = boardPanel.getWidth() / 7;
        int cellHeight = boardPanel.getHeight() / 7;

        int clickedRow = mouseY / cellHeight;
        int clickedCol = mouseX / cellWidth;

        int row = clickedRow;
        int col = clickedCol;

        boolean successstatus = board.placePiece(row, col);
        if (successstatus) {
          boardPanel.repaint();
        }

        if (board.getBlackPieces() > 0 || board.getWhitePieces() > 0) {


          player1PiecesCount.setText("" + board.getWhitePieces());
          player2PiecesCount.setText("" + board.getBlackPieces());
          if (board.getCurrentPlayer() == 2) {
            player1TurnLabel.setVisible(false);
            player2TurnLabel.setVisible(true);

          } else {
            player1TurnLabel.setVisible(true);
            player2TurnLabel.setVisible(false);

          }


        } else {
          player1TurnLabel.setVisible(false);
          player2TurnLabel.setVisible(false);
          player2PiecesCount.setVisible(false);
          player1PiecesCount.setVisible(false);
          player1PiecesLabel.setVisible(false);
          player2PiecesLabel.setVisible(false);

        }



      }

    });

    setLayout(new BorderLayout());
    add(leftPanel, BorderLayout.WEST);
    add(rightPanel, BorderLayout.EAST);
    add(boardPanel, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Nine Men's Morris");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1000, 700);
      frame.add(new NineMenMorrisGUI());
      frame.setVisible(true);
    });
  }
}
