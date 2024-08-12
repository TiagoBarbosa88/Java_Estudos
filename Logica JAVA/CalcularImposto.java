/*
Crie uma classe que calcule uma determinada porcentagem de um dado salário
 - Aceitar um valor de entrada para o salario
 - Validar se recebe vale transporte se receber descontar 6% do salário
 - De acordo com o valor do salário calcular a porcentagem o IRRF
 - Porcentagem do inss 9%
 - Calcular total de impostos pagos
 - Calcular valor do salário após os impostos
* */
import java.util.Scanner;

public class CalcularImposto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Capturar o valor do salário
        System.out.print("Digite o valor do salário: ");
        float salario = scanner.nextFloat();

        // Captura a informação se recebe vale-transporte
        System.out.print("Recebe vale-transporte? (sim/não): ");
        String recebeValeTransporte = scanner.next();

        // Deduz o valor do vale-transporte se o usuário recebe
        float valorValeTransporte = 0.0F;
        if (recebeValeTransporte.equalsIgnoreCase("sim")) {
            valorValeTransporte = salario * 0.06F; // Dedução de 6% do salário
        }

        // Calcula o imposto de renda com base na tabela progressiva
        float valorIrrf = 0.0F;
        float parcelaDeduzir = 0.0F;

        if (salario <= 2259.20) {
            // Isento
            valorIrrf = 0.0F;
        } else if (salario <= 2826.65) {
            valorIrrf = salario * 0.075F - 169.44F; // Alíquota de 7,5% com dedução de R$ 169,44
        } else if (salario <= 3751.05) {
            valorIrrf = salario * 0.15F - 381.44F; // Alíquota de 15% com dedução de R$ 381,44
        } else if (salario <= 4664.68) {
            valorIrrf = salario * 0.225F - 662.77F; // Alíquota de 22,5% com dedução de R$ 662,77
        } else {
            valorIrrf = salario * 0.275F - 896.00F; // Alíquota de 27,5% com dedução de R$ 896,00
        }

        //float valorIrrf = salario * (irrf / 100);
        float inss  = 9;
        float valorInss = salario * (inss / 100);

        float totalDeImpostos = valorIrrf + valorInss + valorValeTransporte;
        float resultadoDoSalario = salario - valorIrrf - valorInss - valorValeTransporte;

        // Exibe os resultados
        System.out.println(String.format("\nMeu salário é: R$%.2f\nPorcentagem imposto de renda %.1f%%\nPorcentagem do INSS %.1f%%\nO valor do imposto de renda: R$%.2f\nO valor do INSS: R$%.2f\nValor do vale-transporte: R$%.2f\nValor de impostos pagos: R$%.2f\nSalário após impostos: R$%.2f",
                salario, valorIrrf / salario * 100, inss, valorIrrf, valorInss, valorValeTransporte, totalDeImpostos, resultadoDoSalario));

        scanner.close();
    }
}
