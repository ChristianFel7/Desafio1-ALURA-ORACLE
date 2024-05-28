import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.net.http.HttpRequest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        int operacao = 0;
        double valor = 0;
        double coin = 0;
        double conversao = 0;
        Scanner leitura = new Scanner(System.in);

        String pesoArgentino = "ARS";
        String realBrasil = "BRL";
        String pesoColombiano = "COP";
        String dolar = "USD";


        while (operacao != 7) {
            System.out.println(String.format("""
                    ****************************************************
                    Seja bem-vindo/a ao Conversor de Moeda:
                            
                    1) Dólar =>> Peso Argentino
                    2) Peso Argentino =>> Dólar
                    3) Dólar =>> Real Brasileiro
                    4) Real Brasileiro =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Sair
                    Escolha uma opção válida: 
                    ****************************************************
                    """));

            operacao = leitura.nextInt();

            if (operacao < 7){
                System.out.println("Digite o valor a ser convertido:");
                valor = leitura.nextDouble();
            }
            switch (operacao){
                case 1:
                    coin = ConsultaExchange.buscaExchange(dolar, pesoArgentino);
                    conversao = Conversao.multiplicador(valor, coin);

                    System.out.println("A conversão de " + valor + dolar + " é: " + conversao + pesoArgentino);
                    break;

                case 2:

                    coin = ConsultaExchange.buscaExchange(pesoArgentino, dolar);
                    conversao = Conversao.multiplicador(valor, coin);

                    System.out.println("A conversão de " + valor + pesoArgentino + " é: " + conversao + dolar);
                    break;
                case 3:
                    coin = ConsultaExchange.buscaExchange(dolar, realBrasil);
                    conversao = Conversao.multiplicador(valor, coin);

                    System.out.println("A conversão de " + valor + dolar + " é: " + conversao + realBrasil);
                    break;

                case 4:
                    coin = ConsultaExchange.buscaExchange(realBrasil, dolar);
                    conversao = Conversao.multiplicador(valor, coin);

                    System.out.println("A conversão de " + valor + realBrasil + " é: " + conversao + dolar);
                    break;

                case 5:
                    coin = ConsultaExchange.buscaExchange(dolar, pesoColombiano);
                    conversao = Conversao.multiplicador(valor, coin);

                    System.out.println("A conversão de " + valor + dolar + " é: " + conversao + pesoColombiano);
                    break;

                case 6:
                    coin = ConsultaExchange.buscaExchange(pesoColombiano, dolar);
                    conversao = Conversao.multiplicador(valor, coin);

                    System.out.println("A conversão de " + valor + pesoColombiano + " é: " + conversao + dolar);
                    break;

                case 7:
                    break;

                default:
                    System.out.println("Entrada inválida. Digite novamente.");


            }



        }

    }

}
