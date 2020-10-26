import java.util.Random;
import java.lang.Math;
import java.util.Scanner;

public class main {

    /** ZADANIE 1 */
    public static short[] jedenwymiar(){
        short[] tablica = new short[100]; //deklaracja i inicjalizacja bez przypisania wartosci
        for(short i=0; i<100; i++) {
            tablica[i] = i;
        }
        return tablica;
    }
    public static void wyswietlanie(short[] tablica){
        for(int i=0; i<tablica.length; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i+j <= 9) System.out.print("0" + tablica[i+j] + ", ");
                else System.out.print(tablica[i+j] + ", ");
            }
            i+=9;
            System.out.print("\n");
        }
        //srednia
        short srednia;
        for(int i=0; i<(tablica.length/10); i++) {
            srednia = 0;
            for (int j = 0; j <= 9; j++) {
                srednia += i + (j * 10);
            }
            System.out.print(srednia / 10 + ", ");
        }
    }
    public static void zadanie1(){
        wyswietlanie(jedenwymiar());
    }

    /** ZADANIE 2 */
    public static short[][] drugiwymiar(){
        Random random = new Random();
        short wymiar = (short)(random.nextInt(10)+10);
        short[][] tablica = new short[wymiar][wymiar];
        for(int i=0; i<wymiar; i++){
            for(int j=0; j<wymiar; j++){
                if(i==j){
                    tablica[i][j] = (short)(random.nextInt(2-(-1))-1);
                    while(tablica[i][j]==0) tablica[i][j] = (short)(random.nextInt(2-(-1))-1);
                }
                else tablica[i][j] = (short)(random.nextInt(40)-20);
            }
        }
        return tablica;
    }
    public static void wyswietl(short[][] tablica){
        System.out.println("Tablica length: "+tablica.length);
        for(int i=0; i<tablica.length; i++){
            for(int j=0; j<tablica.length; j++){
                System.out.printf("%4.3s", tablica[i][j]);
            }
            System.out.print("\n");
        }
    }
    public static void parzysteNieparzyste(short[][] tablica){
        double parzysteIndeksyWierszy = 0;
        double nieparzysteIndeksyKolumn = 0;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(j%2==0) parzysteIndeksyWierszy+=tablica[i][j];
                else if(i%2==1) nieparzysteIndeksyKolumn+=tablica[i][j];
            }
        }
        System.out.println("Parzyste indeksy wierszy: "+parzysteIndeksyWierszy+ "\nNieparzyste indeksy kolumn: "+nieparzysteIndeksyKolumn);
        double stosunekLiczb = parzysteIndeksyWierszy/nieparzysteIndeksyKolumn;
        if(stosunekLiczb==0) System.out.println("Stosunek liczb jest nieskonczony.");
        else System.out.println("Stosunek liczb wynosi: "+stosunekLiczb);
    }
    public static void zadanie2(){
        wyswietl(drugiwymiar());
        parzysteNieparzyste(drugiwymiar());
    }

    /** ZADANIE 3 */
    public static Okrag[] tablicaobiektow(){
        System.out.println("Podaj rozmiar tablicy: ");
        Scanner scan = new Scanner(System.in);
        short rozmiar = scan.nextShort();
        Okrag[] tablica = new Okrag[rozmiar];
        for(int i=0; i<rozmiar; i++){
            tablica[i] = new Okrag();
        }
        return tablica;
    }
    public static void sprawdzaniePunktow(Okrag o1, Okrag o2){
        double dlugoscMiedzyOkregami = Math.sqrt(Math.pow((o1.x-o2.x),2)+Math.pow((o1.y-o2.y),2));

        //Jeżeli odległość między środkami okręgów jest równa sumie promieni lub różnicy promieni to są styczne
        if(o1.promien + o2.promien == dlugoscMiedzyOkregami|| Math.abs(o1.promien - o2.promien) == dlugoscMiedzyOkregami)
            System.out.println("Okręgi są styczne.");

        //Jeżeli odległośc między środkami okręgów jest mniejsza niż róźnica/suma promieni to są rozłączne
        else if(o1.promien + o2.promien < dlugoscMiedzyOkregami || Math.abs(o1.promien - o2.promien) > dlugoscMiedzyOkregami)
            System.out.println("Okręgi są rozłączne.");

        //Jeżeli odległość między środkami okręgów jest mniejsza od sumy, ale większa od różnicy to się przecinają
        else if(Math.abs(o1.promien - o2.promien) < dlugoscMiedzyOkregami && dlugoscMiedzyOkregami < o1.promien + o2.promien)
            System.out.println("Okręgi się przecinają.");

        //Jeżeli odległość między środkami okręgów jest równa zero, a róźnica promieni również jest równa zero, to okręgi nakładają się na siebie
        else if(Math.abs(o1.promien - o2.promien) == 0 && dlugoscMiedzyOkregami == 0)
            System.out.println("Okręgi się nakładają na siebie.");

        else System.out.println("Błąd sprawdzania założeń.");
    }
    public static void wyswietlanie(Okrag[] tablica){
        for (Okrag o: tablica) {
            System.out.println("Okrag ma wspolrzedne: x=["+o.x+"], y=["+o.y+"] i ma promien rowny "+o.promien+".");
        }
    }
    public static void zadanie3(){
        Okrag o1 = new Okrag();
        Okrag o2 = new Okrag();
        System.out.println("Zadanie 3.2 - położenie okregów.");
        o1.wyswietl(); o2.wyswietl();
        sprawdzaniePunktow(o1, o2);
        System.out.println("Zadanie 3.3 - Pola danych z tablicy.");
        wyswietlanie(tablicaobiektow());
    }

    /** MAIN */
    public static void main(String[] args) {
        // ZADANIE 1
        //zadanie1();

        // ZADANIE 2
        //zadanie2();

        // ZADANIE 3
        //zadanie3();


    }
}
