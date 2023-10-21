import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityNonPreemptive extends CPUScheduler {
    @Override
    public void process() {
        Collections.sort(this.getRows(), (o1, o2) -> {
            Row row1 = (Row) o1;
            Row row2 = (Row) o2;
            if (row1.getArrivalTime() == row2.getArrivalTime()) {
                return 0;
            } else if (row1.getArrivalTime() < row2.getArrivalTime()) {
                return -1;
            } else {
                return 1;
            }
        });

        List<Row> rows = Utility.deepCopy(this.getRows());
        int time = rows.get(0).getArrivalTime();

        while (!rows.isEmpty()) {
            List<Row> availableRows = new ArrayList<>();

            for (Row row : rows) {
                if (row.getArrivalTime() <= time) {
                    availableRows.add(row);
                }
            }

            Collections.sort(availableRows, (o1, o2) -> {
                Row row1 = (Row) o1;
                Row row2 = (Row) o2;
                if (row1.getPriorityLevel() < row2.getPriorityLevel()) {
                    return -1;
                } else if (row1.getPriorityLevel() > row2.getPriorityLevel()) {
                    return 1;
                } else {
                    // If priority levels are equal, break the tie using arrival time
                    if (row1.getArrivalTime() < row2.getArrivalTime()) {
                        return -1;
                    } else if (row1.getArrivalTime() > row2.getArrivalTime()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });

            Row row = availableRows.get(0);
            this.getTimeline().add(new Event(row.getProcessName(), time, time + row.getBurstTime()));
            time += row.getBurstTime();

            rows.remove(row);
        }

        for (Row row : this.getRows()) {
            row.setWaitingTime(this.getEvent(row).getStartTime() - row.getArrivalTime());
            row.setTurnaroundTime(row.getWaitingTime() + row.getBurstTime());
        }
    }
}
