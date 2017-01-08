package Patterns.Mediator;

//Mediator interface
public interface ChatMediator {
    public void sendMessage(String msg, User user);
    void addUser(User user);
}
