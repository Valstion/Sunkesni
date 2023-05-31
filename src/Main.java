import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        atspausdintiSuBrackets("labas");
        System.out.println("_________________2_______________________________");
        String simboliai = generuotiAtsitiktiniStringa(10);
        atspausdintiSimboliusStulpeliu(simboliai);
        System.out.println("_________________3_______________________________");
        int dalijasiBeLiekanos = skaiciuotiDalijasiBeLiekanos(24);
        System.out.println("Skaičius 24 dalijasi be liekanos su " + dalijasiBeLiekanos + " sveikais skaičiais.");
        System.out.println("_________________4_______________________________");
        //   int[] skaiciai = generuotiAtsitiktiniusSkaicius(100, 33, 77);
        //    System.out.println("Pradinis masyvas3: " + Arrays.toString(skaiciai));
        //    rikiuotiPagalDalijasiBeLiekanosKieki(skaiciai);
        //    System.out.println("Surūšiuotas masyvas3 pagal daliklių be liekanos kiekį: " + Arrays.toString(skaiciai));
        System.out.println("_________________5_______________________________");
        int[] masyvas = new int[100];
        Random random = new Random();
        for (int i = 0; i < masyvas.length; i++) {
            masyvas[i] = random.nextInt(777 - 333 + 1) + 333;
        }
        // Skaičiuojame pirminių skaičių kiekį
        int pirminiai = 0;
        for (int sk : masyvas) {
            if (arPirminis(sk)) {
                pirminiai++;
            }
        }
        System.out.println("Pirminių skaičių kiekis: " + pirminiai);
        System.out.println("_________________6_______________________________");
        List<List<Integer>> result = generateArrays();
        System.out.println(result);
        System.out.println("_________________7_______________________________");
        List<List<Integer>> arrays = generateArrays1();
        int sum = calculateSum(result);
        System.out.println(sum);
        System.out.println("_________________8_______________________________");
        List<Integer> masyvas3 = new ArrayList<>();
        Random random3 = new Random();
        while (true) {
            int elementsToAdd = 3 - masyvas3.size();
            for (int i = 0; i < elementsToAdd; i++) {
                int skaicius = random3.nextInt(33) + 1;
                masyvas3.add(skaicius);
            }
            boolean hasNonPrime = false;
            for (int i = masyvas3.size() - 3; i < masyvas3.size(); i++) {
                if (!isPrime(masyvas3.get(i))) {
                    hasNonPrime = true;
                    break;
                }
            }
            if (hasNonPrime) {
                int skaicius = random.nextInt(33) + 1;
                masyvas3.add(skaicius);
            } else {
                break;
            }
        }
        System.out.println(masyvas3);
        System.out.println("_________________9 _____________________________");
        int[][] array = generateRandomArray23(10);
        while (calculatePrimeAverage23(array) < 70) {
            int minNumber = findMinimum(array);
            array[minNumber / 10][minNumber % 10] += 3;
        }
        System.out.println("Pirminių skaičių vidurkis >= 70");
        System.out.println("_____________________________________________");
    }

    public static void atspausdintiSuBrackets(String tekstas) {
        String isvedimas = "---" + tekstas + "---";
        System.out.println(isvedimas);
    }

    public static String generuotiAtsitiktiniStringa(int ilgis) {
        String leidziamosRaidzesSkaitmenys = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(ilgis);
        for (int i = 0; i < ilgis; i++) {
            int indeksas = random.nextInt(leidziamosRaidzesSkaitmenys.length());
            sb.append(leidziamosRaidzesSkaitmenys.charAt(indeksas));
        }
        return sb.toString();
    }

    public static void atspausdintiSimboliusStulpeliu(String tekstas) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tekstas.length(); i++) {
            char simbolis = tekstas.charAt(i);
            if (Character.isDigit(simbolis)) {
                sb.append(" [ ").append(simbolis);
                // Tikriname, ar sekantis simbolis taip pat yra skaičius
                while (i + 1 < tekstas.length() && Character.isDigit(tekstas.charAt(i + 1))) {
                    sb.append(tekstas.charAt(i + 1));
                    i++;
                }
                sb.append(" ]");
            } else {
                sb.append(" ").append(simbolis);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int skaiciuotiDalijasiBeLiekanos(int skaicius) {
        int dalijasiBeLiekanos = 0;
        for (int i = 2; i < skaicius / 2; i++) { // optimizacija. nes pvz jei skaicius 100, šimtą dalinant iš 75 visada bus liekana. šita optimizacija duoda kad ciklas suka 2x mažiau kartu. bet gerai kodas.
            if (skaicius % i == 0) {
                dalijasiBeLiekanos++;
            }
        }
        return dalijasiBeLiekanos;
    }




    public static boolean arPirminis(int sk) {
        if (sk < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(sk); i++) {
            if (sk % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[][] generateArray(int rows, int cols) {
        int[][] array = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextInt(100) + 1;
            }
        }
        return array;
    }



    public static double calculatePrimeAverage(int[][] array) {
        int count = 0;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isPrime(array[i][j])) {
                    count++;
                    sum += array[i][j];
                }
            }
        }
        return (double) sum / count;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }



    public static List<List<Integer>> generateArrays() {
        Random random = new Random();
        int numIterations = random.nextInt(21) + 10;
        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < numIterations; i++) {
            List<Integer> array = generateArray(random);
            arrays.add(array);
        }
        return arrays;
    }

    public static List<Integer> generateArray(Random random) {
        int length = random.nextInt(11) + 10;
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < length - 1; i++) {
            array.add(random.nextInt(11));
        }
        array.add(generateLastElement(random));
        return array;
    }

    public static int generateLastElement(Random random) {
        if (random.nextInt(2) == 0) {
            return 0;
        } else {
            List<Integer> lastArray = generateArray(random);
            return lastArray.get(lastArray.size() - 1);
        }
    }


    //-----------------------------------------------------------------------------------------------------
    public static List<List<Integer>> generateArrays1() {
        Random random = new Random();
        int numIterations = random.nextInt(21) + 10;
        List<List<Integer>> arrays = new ArrayList<>();

        for (int i = 0; i < numIterations; i++) {
            List<Integer> array = generateArray(random);
            arrays.add(array);
        }

        return arrays;
    }

    public static List<Integer> generateArray1(Random random) {
        int length = random.nextInt(11) + 10;
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < length - 1; i++) {
            array.add(random.nextInt(11));
        }

        array.add(generateLastElement1(random));
        return array;
    }

    public static int generateLastElement1(Random random) {
        if (random.nextInt(2) == 0) {
            return 0;
        } else {
            List<Integer> lastArray = generateArray1(random);
            return lastArray.get(lastArray.size() - 1);
        }
    }

    public static int calculateSum(List<List<Integer>> arrays) {
        int sum = 0;

        for (List<Integer> arr:arrays   ){
            for (Integer element : arr) {
                sum += element;
            }
        }
        return sum;
    }


    //-----------------------------------------------------------------------------------------------------
    public static int[][] generateRandomArray23(int size) {
        int[][] array = new int[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = random.nextInt(100) + 1;
            }
        }

        return array;
    }

    public static boolean isPrime23(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static double calculatePrimeAverage23(int[][] array) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isPrime23(array[i][j])) {
                    sum += array[i][j];
                    count++;
                }
            }
        }

        return (double) sum / count;
    }

    public static int findMinimum(int[][] array) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                    minIndex = i * 10 + j;
                }
            }
        }

        return minIndex;
    }}

