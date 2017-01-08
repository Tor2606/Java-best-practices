package Patterns.Mediator;

public class ChatClient {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        User user1 = new UserImpl(mediator, "Igor");
        User user2 = new UserImpl(mediator, "Lisa");
        User user3 = new UserImpl(mediator, "David");
        User user4 = new UserImpl(mediator, "Inna");
        User user5 = new UserImpl(mediator, "Katya");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);
        mediator.addUser(user5);

        user1.send("Hi motherfuckers!!!");
    }
}
