package Patterns.Prototype;

public class CookieMachine {
    private Cookie cookie;

    public CookieMachine(Cookie cookie) {
        this.cookie = cookie;
    }

    public Cookie makeCookie() throws CloneNotSupportedException {
        return (Cookie) this.cookie.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Cookie prototype1 = new ChocolateCookie();
        Cookie prototype2 = new CoconutCookie();
        CookieMachine cookieMachineChocolateCookies = new CookieMachine(prototype1);
        CookieMachine cookieMachineCoconut = new CookieMachine(prototype2);

        for (int i = 0; i < 10; i++) {
            System.out.println(cookieMachineChocolateCookies.makeCookie());
            System.out.println(cookieMachineCoconut.makeCookie());
        }
    }
}
