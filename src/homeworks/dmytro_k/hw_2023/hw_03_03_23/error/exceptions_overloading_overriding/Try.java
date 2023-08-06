package homeworks.dmytro_k.hw_2023.hw_03_03_23.error.exceptions_overloading_overriding;


/*public class Try {


    public void print() {


        if (1 == 1) {
            throw new IllegalArgumentException();
        }
        throw new NullPointerException();
          catch(Exception e){
            System.out.println(e.getMessage());
        } catch(NullPointerException e){
            System.out.println(e.getMessage());
        }

    }

    public void printMessage() {
        try {
            if (1 == 1) {
                throw new IllegalArgumentException();
            }
            throw new NullPointerException();
        }
        finalize() {
            throw new IOException();
        }

    }

    public void getPatient() {
        throw new IOException();
        throw new NullPointerException();
    }

    protected void getClient() throws FileNotFoundException {
        try {
            throw new FileNotFoundException();
        } finally {
            throw new IOException();
        }
        throw new NullPointerException();
    }


    public int getMessage() {
        try {
            return 1;
        } catch (IllegalArgumentException | NullPointerException e) {

        } finally {
            return 2;
        }

    }

    public int getNumberOfFiles() throws FileNotFoundException {
        try {
            return 1;
        } catch (IllegalArgumentException | NullPointerException e) {
            e = new NullPointerException();

        } finally {
            throw new NullPointerException();
        }

    }

    public static void main(String[] args) {
        Try aTry = new Try();
        System.out.println(aTry.getMessage());// what will be print in console

        try {
            aTry.getClient();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}*/
