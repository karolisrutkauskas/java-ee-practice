package lt.vu.services;

import javax.enterprise.inject.Specializes;

@Specializes
public class VeryLongCalculationsService extends LongCalculationsService {

    @Override
    public void calculate() {
        System.out.println("Calculating for a long time...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
