import java.util.Scanner;

public class JogoAdivinhaPalavra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Palavra oculta
        String palavraOculta = "lucas"; // Pode substituir por outra palavra de 5 letras

        // Número máximo de tentativas
        int maxTentativas = 5;
        int tentativas = 0;

        System.out.println("Bem-vindo ao jogo de adivinhar a palavra!");
        System.out.println("Você tem " + maxTentativas + " tentativas para adivinhar a palavra.");

        while (tentativas < maxTentativas) {
            System.out.print("Digite uma palavra de 5 letras: ");
            String tentativa = scanner.nextLine().toLowerCase();

            // Verifica se a tentativa tem exatamente 5 letras
            if (tentativa.length() != 5) {
                System.out.println("A palavra deve ter exatamente 5 letras. Tente novamente.");
                continue;
            }

            // Checa se a tentativa é correta
            if (tentativa.equals(palavraOculta)) {
                System.out.println("Parabéns! Você adivinhou a palavra.");
                break;
            }

            // Exibe feedback
            String feedback = gerarFeedback(palavraOculta, tentativa);
            System.out.println(feedback);

            tentativas++;
            System.out.println("Tentativas restantes: " + (maxTentativas - tentativas));
        }

        if (tentativas == maxTentativas) {
            System.out.println("Você esgotou suas tentativas. A palavra era: " + palavraOculta);
        }

        scanner.close();
    }

    // Função de feedback sobre a palavra digitada
    public static String gerarFeedback(String palavraOculta, String tentativa) {
        StringBuilder feedback = new StringBuilder("Feedback: ");
        for (int i = 0; i < palavraOculta.length(); i++) {
            char letraOculta = palavraOculta.charAt(i);
            char letraTentativa = tentativa.charAt(i);
            if (letraTentativa == letraOculta) {
                feedback.append(letraTentativa); // Letra correta e na posição certa
            } else if (palavraOculta.indexOf(letraTentativa) >= 0) {
                feedback.append('?'); // Letra correta, mas na posição errada
            } else {
                feedback.append('_'); // não tem essa letra
            }
        }
        return feedback.toString();
    }
}
