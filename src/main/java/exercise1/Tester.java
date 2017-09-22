package exercise1;

public class Tester {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
 
        TagCounter tc1 = new TagCounter("http://www.fck.dk");
        TagCounter tc2 = new TagCounter("http://www.google.com");
        TagCounter tc3 = new TagCounter("http://politiken.dk/");

        long sequentialStart = System.nanoTime();
        tc1.run();
        tc2.run();
        tc3.run();
        System.out.println("=========================");
        System.out.println("=  Sequentual execution =");
        System.out.println("=========================");
        System.out.println("Title: " + tc1.getTitle());
        System.out.println("Div's: " + tc1.getDivCount());
        System.out.println("Body's: " + tc1.getBodyCount());
        System.out.println("-----------------------------");
        System.out.println("Title: " + tc2.getTitle());
        System.out.println("Div's: " + tc2.getDivCount());
        System.out.println("Body's: " + tc2.getBodyCount());
        System.out.println("-----------------------------");
        System.out.println("Title: " + tc3.getTitle());
        System.out.println("Div's: " + tc3.getDivCount());
        System.out.println("Body's: " + tc3.getBodyCount());
        System.out.println("-----------------------------");
        long sequentialEnd = System.nanoTime();
        long sequentialNano = sequentialEnd - sequentialStart;
        System.out.println("Time Sequential: " + sequentialNano);
        System.out.println("In seconds: "+ sequentialNano/1000000000d);
        System.out.println("=======##########=========");

        long parallelStart = System.nanoTime();
        tc1.start();
        tc2.start();
        tc3.start();
        System.out.println("=========================");
        System.out.println("=   Parallel execution  =");
        System.out.println("=========================");
        System.out.println("Title: " + tc1.getTitle());
        System.out.println("Div's: " + tc1.getDivCount());
        System.out.println("Body's: " + tc1.getBodyCount());
        System.out.println("-----------------------------");
        System.out.println("Title: " + tc2.getTitle());
        System.out.println("Div's: " + tc2.getDivCount());
        System.out.println("Body's: " + tc2.getBodyCount());
        System.out.println("-----------------------------");
        System.out.println("Title: " + tc3.getTitle());
        System.out.println("Div's: " + tc3.getDivCount());
        System.out.println("Body's: " + tc3.getBodyCount());
        System.out.println("-----------------------------");
        tc1.join();
        tc2.join();
        tc3.join();
        long parallelEnd = System.nanoTime();
        long parallelNano = parallelEnd - parallelStart;
        System.out.println("Time Parallel: " + parallelNano);
        System.out.println("In seconds: "+ parallelNano/1000000000d);
        System.out.println("=======##########=========");
        
        System.out.println("Difference between Sequential and Parallel:");
        System.out.println("Nanoseconds: "+(sequentialNano-parallelNano));
        System.out.println("Seconds: "+((sequentialNano-parallelNano)/1000000000d));

    }
}
