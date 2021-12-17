package Application;

public class EEL {

    private QR qr;
    private double kwhAnnum;
    private char energyClass;

    public EEL(QR qr, double kwhAnnum, char energyClass) {
        this.qr = qr;
        this.energyClass = energyClass;
        if (kwhAnnum > 0)
            this.kwhAnnum = kwhAnnum;
        else{
            System.out.println("Verbruik moet positief zijn!");
        }
    }

    public QR getQr() {
        return qr;
    }

    public double getKwhAnnum() {
        return kwhAnnum;
    }

    public char getEnergyClass() {
        return energyClass;
    }
}