import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione método de pagamento:");
        System.out.println("1: Pix");
        System.out.println("2: Cartão de crédito");
        System.out.println("3: Boleto");

        int choice = scanner.nextInt();
        System.out.print("Digite o valor: ");
        double valor = scanner.nextDouble();

        try {
            PaymentStrategy paymentStrategy = PaymentFactory.createPaymentStrategy(choice);
            PaymentProcessor processor = new PaymentProcessor(paymentStrategy);
            processor.process(valor);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}