package study.springsecurity.springsession.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    private final String HOME_VIEW_COUNT = "HOME_VIEW_COUNT";
    @GetMapping("/")
    public String home(Principal principal, HttpSession session){
        incrementCount(session);
        return "Hello-World, " + principal.getName();
    }

    @GetMapping("/count")
    public String count(HttpSession session){
        return "HOME_VIEW_COUNT: " + session.getAttribute(HOME_VIEW_COUNT);
    }

    private void incrementCount(HttpSession session) {

        var homeViewCount = session.getAttribute("HOME_VIEW_COUNT") == null ? 0 : session.getAttribute("HOME_VIEW_COUNT");

        session.setAttribute("HOME_VIEW_COUNT", homeViewCount);
    }
}
