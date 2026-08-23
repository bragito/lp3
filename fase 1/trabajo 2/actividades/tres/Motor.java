package actividades.tres;

public class Motor {
    private int NumMotor;
    private int revPorMin;

    public Motor(int NumMotor, int revPorMin) {
        this.NumMotor = NumMotor;
        this.revPorMin = revPorMin;
    }

    // Getter y Setter de NumMotor
    public int getNumMotor() {
        return NumMotor;
    }

    public void setNumMotor(int NumMotor) {
        this.NumMotor = NumMotor;
    }

    // Getter y Setter de revPorMin
    public int getRevPorMin() {
        return revPorMin;
    }

    public void setRevPorMin(int revPorMin) {
        this.revPorMin = revPorMin;
    }

    public String toString() {
        return "Motor{" +
                "NumMotor=" + NumMotor +
                ", revPorMin=" + revPorMin +
                '}';
    }
}
