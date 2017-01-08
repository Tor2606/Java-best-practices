package Patterns.Mediator;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = newArrayList();
    }

    @Override
    public void sendMessage(String msg, User user) {
        this.users.stream().filter(u -> u != user).forEach(u -> {
            u.receive(msg);
        });
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}
