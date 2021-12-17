

import java.util.Objects;

public class Apparaat {

    String ApName;
    String SNR;
    String EEC; //energy efficieny class
    int KWH;
    int apID;
    int roomid;


    public Apparaat(String ApName, String EEC, int KWH, int roomID){
        this.ApName = ApName;
        this.EEC = EEC;
        this.KWH = KWH;
        this.roomid = roomID;
    }

    public int getRoomid() {
        return roomid;
    }

    public String getApName() {
        return ApName;
    }

    public String getSNR() {
        return SNR;
    }

    public void setApName(String apName) {
        ApName = apName;
    }

    public void setEEC(String EEC) {
        this.EEC = EEC;
    }

    public void setKWH(int KWH) {
        this.KWH = KWH;
    }

    public void setSNR(String SNR) {
        this.SNR = SNR;
    }

    public int getKWH() {
        return KWH;
    }

    public String getEEC() {
        return EEC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apparaat apparaat = (Apparaat) o;
        return KWH == apparaat.KWH &&
                roomid == apparaat.roomid &&
                this.ApName.equals(apparaat.getApName()) &&
                this.EEC.equals(apparaat.getEEC());

    }

    @Override
    public int hashCode() {
        return Objects.hash(ApName, SNR, EEC, KWH, apID, roomid);
    }



    @Override
    public String toString() {
        return ApName  + " "+ EEC + " "  + KWH + " " +roomid;
    }
}
