package exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class RandomNumberConsumer implements Runnable {

    ArrayBlockingQueue<Integer> numbersProduced;

    public RandomNumberConsumer(ArrayBlockingQueue<Integer> numbersProduced) {
        this.numbersProduced = numbersProduced;
    }
    //Should eventually hold the sum of all random number consumed
    int sumTotal = 0;
    List<Integer> below50 = new ArrayList();
    List<Integer> aboveOr50 = new ArrayList();

    @Override
    public void run() {
        //In this exercise, we start four threads, each producing 100 numbers, so we know how much to consume
        for (int i = 0; i < 400; i++) {
            //Todo: Fetch numbers from numbersProduced and do what you have to do
            int element = 0;
            try {
                element = numbersProduced.take();
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException occurred! Rewrite run() method in RandomNumberConsumer class!");
            }
            sumTotal += element;
            if (element < 50) {
                below50.add(element);
            } else {
                aboveOr50.add(element);
            }
        }
    }

    public int getSumTotal() {
        return sumTotal;
    }

    public List<Integer> getBelow50() {
        return below50;
    }

    public List<Integer> getAboveOr50() {
        return aboveOr50;
    }

}
