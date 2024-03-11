package pl.piomin.services.kafka.producer.api;

public class InputParameters {

    private int numberOfMessages;

    public int getNumberOfMessages() {
        return numberOfMessages;
    }

    public void setNumberOfMessages(int numberOfMessages) {
        this.numberOfMessages = numberOfMessages;
    }
}
