package main.ru.mephi.java.part5.handleExceptions;

public class Suppressed {

    public static void function1() {
        RuntimeException th = null;
        BadResource resource = new BadResource();
        try {
            resource.accessResource();
        } catch (RuntimeException e) {
            th = e;
        } finally {
            try {
                resource.close();
            } catch (RuntimeException e) {
                RuntimeException e1 = e;

                if (th != null) {
                    th.addSuppressed(e); //Add to main exception
                    throw th;
                }
            }
        }
    }


    public static void function2() {
        try (BadResource resource = new BadResource()) {
            resource.accessResource();
        }
    }

    public static void main(String[] arguments) throws Exception {
        try {
            function1();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

        function2();

    }
}

