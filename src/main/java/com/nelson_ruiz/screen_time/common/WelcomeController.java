package com.nelson_ruiz.screen_time.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return  "<div style='display:flex; justify-content:center; align-items:center; height:10vh; flex-direction:column; padding-top:20vh;'>"
                + "<h1 style='color:#007bff; text-align:center;'>⏳ ¡Bienvenido a Screen Time! 🚀</h1>"
                + "<p style='text-align:center;'>Tu tiempo es oro... ¡pero a veces lo gastas en reels y memes! 😆</p>"
                + "<p style='text-align:center;'>Monitorea tu tiempo de pantalla, establece objetivos y mejora tu bienestar digital. \uD83D\uDCF1✨</p>"
                + "<p style='text-align:center;'>Aquí estamos para ayudarte a equilibrar el scroll infinito con la productividad. 📊✨</p>"
                + "<p style='font-weight:bold; text-align:center;'>¡Hora de tomar el control! 🔥</p>"
                + "</div>";
    }
}
