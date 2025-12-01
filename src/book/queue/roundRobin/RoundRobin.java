package book.queue.roundRobin;

import java.util.Scanner;

class Process implements Comparable<Process>{
    private String name;
    private int arrivalTime, executionTime;

    public Process(String name, int arrivalTime, int executionTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
    }
    public void updateTime(int quantum){
        if(this.executionTime < quantum)
            this.executionTime = 0;
        else
            this.executionTime -= quantum;
    }

    public String getName() {
        return name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public int compareTo(Process o) {
        if(this.arrivalTime > o.getArrivalTime())
            return 1;
        else if (this.arrivalTime == o.getArrivalTime()){
            if(this.executionTime > o.getExecutionTime())
                return-1;
            else
                return 1;
        }
        else
            return-1;
    }
}
public class RoundRobin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
