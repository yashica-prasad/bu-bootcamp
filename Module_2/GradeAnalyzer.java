import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");
        
        // Step 2: calculate statistics
        double classAvg = calculateAverage(scores);
        int minScore = Integer.MAX_VALUE;
        int maxScore = Integer.MIN_VALUE;
        for (int score : scores){
            if(minScore > score){
                minScore = score;
            } if (maxScore < score){
                maxScore = score;
            }
        }
        int countA, countB, countC, countD, countF;
        countA = countB = countC = countD = countF = 0;
        for (int score : scores){
            if(score < 60){
                countF += 1;
            } else if (score < 70){
                countD++;
            } else if (score < 80){
                countC++;
            } else if (score < 90){
                countB++;
            } else {
                countA++;
            }
        }
        // Step 3: write and print report
        writeReport(scores, classAvg, maxScore, minScore,
                    countA, countB, countC, countD, countF, "report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine()) != null){
                line = line.trim();
                if(line.isEmpty()){
                    continue;
                }
                try {
                    scores.add(Integer.parseInt(line));
                    //System.out.println("Added score " + Integer.parseInt(line));
                } catch(NumberFormatException e) {
                    System.out.println("Warning: skipping invalid score: " + line);
                }
            }
        } catch(IOException e) {
            System.out.println("Failed to read file :(");
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        int scoreCount = scores.size();
        double avgScore = 0.0;
        for(int score : scores){
            avgScore += score;
        }
        //System.out.println("Avg Score = " + (avgScore / scoreCount));
        return scoreCount == 0 ? 0.0 : avgScore / scoreCount;
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   int countA, int countB, int countC,
                                   int countD, int countF,
                                   String outputFile) {
        String report = String.format(
                "=== Grade Analysis Report ===%n"
                + "Total scores processed:  %d%n"
                + "Average score: %.2f%n"
                + "Highest score: %d%n"
                + "Lowest score: %d%n"
                + "%nGrade distribution:%n"
                + "A (90-100):   %d%n"
                + "B (80-89):   %d%n"
                + "C (70-79):   %d%n"
                + "D (60-69):   %d%n"
                + "F (below 60):   %d%n",
                scores.size(), avg, high, low,
                countA, countB, countC, countD, countF);
        System.out.print(report);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            writer.write(report);
        }catch(IOException e){
            System.out.println("Error in writing to report");
        }
    }
} 