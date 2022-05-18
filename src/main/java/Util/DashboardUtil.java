package Util;

public class DashboardUtil {
    private int unmilledBatches;
    
    private int milledBatches;

    private String month;

    public int getUnmilledBatches() {
        return unmilledBatches;
    }


    public int getMilledBatches() {
        return milledBatches;
    }

    public void setMilledBatches(int milledBatches) {
        this.milledBatches = milledBatches;
    }

    @Override
    public String toString() {
        return "DashboardUtil{" +
                "unmilledBatches=" + unmilledBatches +
                ", milledBatches=" + milledBatches +
                '}';
    }

    public void setUnmilledBatches(int unmilledBatches) {
        this.unmilledBatches = unmilledBatches;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setUnMilledBatches(int unmilledBatches) {
        this.unmilledBatches = unmilledBatches;
    }
}