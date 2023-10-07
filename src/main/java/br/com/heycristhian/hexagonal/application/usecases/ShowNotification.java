package br.com.heycristhian.hexagonal.application.usecases;

public class ShowNotification {

    public void execute(String message) {
        System.out.println("Consuming: " + message);
    }
}
