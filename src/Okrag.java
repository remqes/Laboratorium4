import java.util.Random;
import java.lang.Math;


public class Okrag {
    int x;
    int y;
    float promien;

    Random random = new Random();
    Okrag() {
        this.x = random.nextInt(90)+5;
        this.y = random.nextInt(90)+5;
        this.promien = random.nextInt(5)+1;
    }

    public void wyswietl() {
        System.out.println("Okrag ma wspolrzedne: x=["+x+"], y=["+y+"] i ma promien rowny "+promien+".");
    }
}
