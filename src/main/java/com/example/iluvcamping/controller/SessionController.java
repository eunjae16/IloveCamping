package com.example.iluvcamping.controller;


@Controller
@RequiredArgsConstructor
@SessionAttributes("loggedInClient")
public class SessionController {
    private final ClientRepository clientRepository;

    @GetMapping("/sessionInfo")
    public String sessionInfo(Model model, HttpSession session){
        Client loggedInClient = (Client) session.getAttribute("loggedInClient");
        model.addAttribute("client", loggedInClient);
        return "sessionInfo";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login"; // 로그아웃 시 다시 로그인 페이지로 리디렉션
    }
}
