package labs.excercises.gobackn;

import java.util.Scanner;

public class GoBackN {

    public int calculateTotalTransmissions(int lost, int windowSize, int totalPackets) {
        int counter = windowSize;
        int transmissions = 0;
        int base = 1;

        while (base <= totalPackets) {
            while (windowSize > totalPackets - base) {
                windowSize--;
            }
            base++;
            transmissions++;
            if(counter == transmissions){
                lost = counter;
            }
            if (base == lost) {
                transmissions += windowSize;
            }
        }

        return transmissions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lost = scanner.nextInt();
        int windowSize = scanner.nextInt();
        int totalPackets = scanner.nextInt();
        GoBackN goBackN = new GoBackN();
        System.out.println(goBackN.calculateTotalTransmissions(lost, windowSize, totalPackets));
    }
}
