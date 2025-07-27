import java.util.Random;

public class ticket {
    private int numero;
    private boolean apto;

    public ticket() {
        Random random = new Random();
        this.numero = random.nextInt(15000) + 1;
    }

    public void validarAptitud() {
        Random random = new Random();
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        this.apto = numero >= min && numero <= max;
    }

    public boolean isApto() {
        return apto;
    }

    public int getNumero() {
        return numero;
    }
}
