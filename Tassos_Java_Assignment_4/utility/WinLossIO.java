package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WinLossIO {

    private String fileName = "winLoss.txt";

    public WinLossIO() {
        // Do nothing
    }

    public void saveWinLoss(int win, int loss) {
        // Write win and loss to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(win + "," + loss);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public int[] loadWinLoss() {
        int[] winLoss = new int[2];

        // Read win and loss from file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            String[] parts = line.split(",");
            winLoss[0] = Integer.parseInt(parts[0]); // Wins
            winLoss[1] = Integer.parseInt(parts[1]); // Losses
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        return winLoss;
    }
}//class