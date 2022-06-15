package Model;

public class MillingProduct {
    private int id;
    private int palmOilDrum;
    private int palmOilCan;
    private int fibreOilCan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPalmOilDrum() {
        return palmOilDrum;
    }

    public void setPalmOilDrum(int palmOilDrum) {
        this.palmOilDrum = palmOilDrum;
    }

    public int getPalmOilCan() {
        return palmOilCan;
    }

    public void setPalmOilCan(int palmOilCan) {
        this.palmOilCan = palmOilCan;
    }

    public int getFibreOilCan() {
        return fibreOilCan;
    }

    public void setFibreOilCan(int fibreOilCan) {
        this.fibreOilCan = fibreOilCan;
    }

    public MillingProduct() {
    }

    @Override
    public String toString() {
        return "MillingProduct{" +
                "id=" + id +
                ", palmOilDrum=" + palmOilDrum +
                ", palmOilCan=" + palmOilCan +
                ", fibreOilCan=" + fibreOilCan +
                '}';
    }
}
