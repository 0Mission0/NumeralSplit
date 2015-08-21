public class NumeralSplit {

    public static void main(String[] args) {

        //int num = Integer.parseInt(args[0]);
        int num = 40;

        SplitMachine machine = new SplitMachine();

        long startTime = System.currentTimeMillis();
        machine.work(num);
        long endTime = System.currentTimeMillis();

        System.out.print("\nEnd  ");
        System.out.println("共有：" + machine.times + "種展開方式。");
        System.out.println("共花費：" + (endTime - startTime) + "ms");

    }

}

class SplitMachine {

    public static int times = 1;

    public void work(int num) {

        System.out.print(num + "\t = " + num);

        for(int count1 = 2; count1 <= num; count1++) {

            int[] intArray = new int[count1];

            intArray[0] = num - count1 + 1;

            for(int count2 = 1; count2 < intArray.length; count2++) {
                intArray[count2] = 1;
            }

            extend(intArray, 1);

        }


    }

    public void extend(int[] intArray, int val) {

        times++;
        print(intArray);

        for(int now = val; now < intArray.length; now++) {

            if( intArray[0] == intArray[1] ) {
                break;
            }
            else if( intArray[now] == intArray[now - 1] ) {
                continue;
            }

            int parent = intArray[0];
            int oldBro = intArray[1];
            int brother = intArray[now - 1];
            int self = intArray[now];

            if( self + 1 <= parent - 1 && parent - 1 >= oldBro ) {
                int size = intArray.length;
                int[] tempArray = new int[size];
                System.arraycopy(intArray, 0, tempArray, 0, size);
                tempArray[0]--;
                tempArray[now]++;
                extend(tempArray, now);
            }


        }

    }

    public void print(int[] intArray) {

        if( intArray == null ) {
            System.out.println("Error: this array is null.");
            System.exit(1);
        }
        else if( intArray.length < 1 ) {
            System.out.println("Error: this array contains nothing!");
            System.exit(1);
        }

        System.out.print("\n\t = ");
        System.out.print(intArray[0]);

        for(int count1 = 1; count1 < intArray.length; count1++) {
            System.out.print( "+" + intArray[count1] );
        }

    }

}

