package projetofinal.flow.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @GetMapping
    public String viewTask(){
        return """
    <html>
    <head>
        <meta charset='UTF-8'>
        <title>FLOW MATRIX MODE</title>

        <style>
            * { margin: 0; padding: 0; box-sizing: border-box; }

            body {
                background: black;
                font-family: monospace;
                color: #00ff41;
                overflow: hidden;
            }

            /* ====================================================
               1 - SCANLINES
            ==================================================== */
            .scanlines {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background: repeating-linear-gradient(
                    to bottom,
                    rgba(0, 0, 0, 0.1),
                    rgba(0, 0, 0, 0.1) 1px,
                    rgba(0, 0, 0, 0.15) 2px
                );
                z-index: 15;
                pointer-events: none;
            }

            /* ====================================================
               2 - VHS NOISE (AVANÇADO)
            ==================================================== */
            .vhs {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background: url('https://media.giphy.com/media/oEI9uBYSzLpBK/giphy.gif');
                mix-blend-mode: screen;
                opacity: 0.1;
                z-index: 14;
                pointer-events: none;
            }

            /* ====================================================
               3 - SCREEN DISTORTION (CRT WARP)
            ==================================================== */
            .crt-warp {
                position: fixed;
                inset: 0;
                z-index: 16;
                pointer-events: none;
                background: transparent;
                animation: crtCurve 6s ease-in-out infinite;
            }

            @keyframes crtCurve {
                0%, 100% { transform: scale(1); }
                50% { transform: scale(1.01, 1.03); }
            }

            /* ====================================================
               4 - DIGITAL TEAR (GLITCH HORIZONTAL)
            ==================================================== */
            .digital-tear {
                position: fixed;
                width: 100%;
                height: 100%;
                z-index: 17;
                pointer-events: none;
                background: repeating-linear-gradient(
                    transparent,
                    transparent 3px,
                    rgba(0,255,65,0.1) 4px
                );
                animation: tear 5s infinite;
            }

            @keyframes tear {
                0% { transform: translateX(0); }
                45% { transform: translateX(0); }
                46% { transform: translateX(-20px); }
                47% { transform: translateX(20px); }
                48% { transform: translateX(0); }
                100% { transform: translateX(0); }
            }

            /* ====================================================
               5 - SCREEN SHAKE ON LOAD
            ==================================================== */
            body.shake {
                animation: shake 0.5s linear;
            }

            @keyframes shake {
                0% { transform: translate(0, 0); }
                25% { transform: translate(5px, -5px); }
                50% { transform: translate(-5px, 5px); }
                75% { transform: translate(5px, 5px); }
                100% { transform: translate(0, 0); }
            }

            /* ====================================================
               6 - MATRIX RAIN (BACKGROUND)
            ==================================================== */
            canvas#matrixCanvas {
                position: fixed;
                top: 0;
                left: 0;
                width: 100vw;
                height: 100vh;
                z-index: 1;
            }

            /* ====================================================
               7 - LOGO FLOW COM GLITCH 3D
            ==================================================== */
            .logo {
                position: absolute;
                top: 10%;
                width: 100%;
                text-align: center;
                font-size: 72px;
                font-weight: bold;
                color: #00ff41;
                text-shadow:
                    0 0 10px #00ff41,
                    0 0 20px #00ff41,
                    0 0 40px #00ff41,
                    0 0 80px #00ff41;
                z-index: 10;
                animation: glitchExplode 1s ease-out;
            }

            @keyframes glitchExplode {
                0% { opacity: 0; transform: scale(2); filter: blur(10px); }
                60% { opacity: 1; transform: scale(0.9); }
                100% { transform: scale(1); }
            }

            /* ====================================================
               8 - TERMINAL COM TYPING EFFECT
            ==================================================== */
            .terminal {
                position: absolute;
                bottom: 5%;
                left: 5%;
                font-size: 24px;
                z-index: 10;
                white-space: pre;
            }

            .cursor {
                display: inline-block;
                width: 12px;
                background: #00ff41;
                animation: blink 0.8s infinite;
            }

            @keyframes blink {
                0%, 50% { opacity: 1; }
                51%, 100% { opacity: 0; }
            }
        </style>
    </head>

    <body class="shake">

        <!-- MATRIX FULL CANVAS -->
        <canvas id="matrixCanvas"></canvas>

        <!-- LOGO FLOW -->
        <div class="logo">FLOW — MATRIX SYSTEM</div>

        <!-- TERMINAL -->
        <div class="terminal" id="terminalText">
            <span id="text"></span><span class="cursor"></span>
        </div>

        <!-- FX -->
        <div class="vhs"></div>
        <div class="scanlines"></div>
        <div class="digital-tear"></div>
        <div class="crt-warp"></div>

        <script>
            /* ====================================================
               MATRIX CODE STREAM (CANVAS)
            ==================================================== */
            const canvas = document.getElementById('matrixCanvas');
            const ctx = canvas.getContext('2d');

            canvas.width = window.innerWidth;
            canvas.height = window.innerHeight;

            const letters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
            const fontSize = 16;
            const columns = canvas.width / fontSize;

            let drops = [];
            for (let i = 0; i < columns; i++) drops[i] = 1;

            function matrix() {
                ctx.fillStyle = 'rgba(0, 0, 0, 0.05)';
                ctx.fillRect(0, 0, canvas.width, canvas.height);

                ctx.fillStyle = '#00ff41';
                ctx.font = fontSize + 'px monospace';

                for (let i = 0; i < drops.length; i++) {
                    const text = letters.charAt(Math.floor(Math.random() * letters.length));
                    ctx.fillText(text, i * fontSize, drops[i] * fontSize);

                    if (drops[i] * fontSize > canvas.height && Math.random() > 0.95) drops[i] = 0;

                    drops[i]++;
                }
            }

            setInterval(matrix, 50);

            /* ====================================================
               TERMINAL AUTO-TYPING
            ==================================================== */
            const terminalLines = [
                "Iniciando modo MATRIX...",
                "Carregando sistema Flow...",
                "Estabelecendo conexão neural...",
                "Renderizando código digital...",
                "Ambiente carregado com sucesso."
            ];

            let lineIndex = 0, charIndex = 0;
            const textBox = document.getElementById("text");

            function type() {
                if (lineIndex < terminalLines.length) {
                    if (charIndex < terminalLines[lineIndex].length) {
                        textBox.textContent += terminalLines[lineIndex].charAt(charIndex);
                        charIndex++;
                        setTimeout(type, 40);
                    } else {
                        textBox.textContent += "\\n";
                        charIndex = 0;
                        lineIndex++;
                        setTimeout(type, 800);
                    }
                }
            }

            setTimeout(type, 1200);
        </script>

    </body>
    </html>
    """;
    }

    /* Gera caracteres aleatórios da chuva Matrix */
    private String generateMatrixRain() {
        StringBuilder sb = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        for (int i = 0; i < 180; i++) {
            int left = (int)(Math.random() * 100);
            char c = chars.charAt((int)(Math.random() * chars.length()));
            int delay = (int)(Math.random() * 5);

            sb.append("<span style='left:")
                    .append(left)
                    .append("%; animation-delay:")
                    .append(delay)
                    .append("s;'>")
                    .append(c)
                    .append("</span>");
        }

        return sb.toString();
    }

    @PostMapping
    public void registerTask(@RequestBody String json) {
        System.out.println(json);
    }

    @PostMapping TaskController(){

    }
}

