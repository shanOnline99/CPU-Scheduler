import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundRobin extends CPUScheduler {
    @Override
    public void process() {

        List<Row> rows = new ArrayList<>(this.getRows());
        int timeQuantum = this.getTimeQuantum();
        int currentTime = findStartTime(rows);
        int remainingProcesses = rows.size();

        while (remainingProcesses > 0) {
            int completedProcesses = 0;

            for (int i = 0; i < rows.size(); i++) {
                Row row = rows.get(i);
                int remainingTime = row.getBurstTime();
                int arrivalTime = row.getArrivalTime();

                if (currentTime >= arrivalTime) {
                    if (remainingTime <= timeQuantum) {
                        this.getTimeline().add(new Event(row.getProcessName(), currentTime, currentTime + remainingTime));
                        currentTime += remainingTime;
                        rows.remove(i);
                        i--;
                        completedProcesses++;
                    } else {
                        this.getTimeline().add(new Event(row.getProcessName(), currentTime, currentTime + timeQuantum));
                        currentTime += timeQuantum;
                        row.setBurstTime(remainingTime - timeQuantum);
                        completedProcesses++;
                    }
                }
            }

            if (completedProcesses == 0) {
                currentTime++;
            }

            remainingProcesses = rows.size();
        }

        //int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        for (Row row : this.getRows()) {
            // int waitingTime = 0;
            int completionTime = 0;
            boolean completed = false;

            for (Event event : this.getTimeline()) {
                if (event.getProcessName().equals(row.getProcessName())) {
                    if (!completed) {
                        // waitingTime += event.getStartTime() - row.getArrivalTime();
                        completed = true;
                    }
                    completionTime = event.getStartTime() + row.getBurstTime();
                }
            }

            //row.setWaitingTime(row.getWaitingTime()+waitingTime);
            row.setTurnaroundTime(completionTime - row.getArrivalTime());

            //totalWaitingTime += waitingTime;
            totalTurnaroundTime += row.getTurnaroundTime();
        }

        //double averageWaitingTime = (double) totalWaitingTime / this.getRows().size();
        double averageTurnaroundTime = (double) totalTurnaroundTime / this.getRows().size();
        //System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);

        Map map = new HashMap();

        for (Row row : this.getRows())
        {
            map.clear();

            for (Event event : this.getTimeline())
            {
                if (event.getProcessName().equals(row.getProcessName()))
                {
                    if (map.containsKey(event.getProcessName()))
                    {
                        int w = event.getStartTime() - (int) map.get(event.getProcessName());
                        row.setWaitingTime(row.getWaitingTime() + w);
                    }
                    else
                    {
                        row.setWaitingTime(event.getStartTime() - row.getArrivalTime());
                    }

                    map.put(event.getProcessName(), event.getFinishTime());
                }
            }

            //row.setTurnaroundTime(row.getWaitingTime() + row.getBurstTime());
        }
    }
    private int findStartTime(List<Row> rows) {
        int minArrivalTime = Integer.MAX_VALUE;
        for (Row row : rows) {
            minArrivalTime = Math.min(minArrivalTime, row.getArrivalTime());
        }
        return minArrivalTime;
    }
}
