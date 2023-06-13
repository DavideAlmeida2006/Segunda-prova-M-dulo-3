package programa;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.InputMismatchException;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import classes.Produto;
import classes.Venda;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Venda> listaVenda = new ArrayList<>();
        List<Produto> listaProduto = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int o2 = 10;
        int o1 = 10;
        int o3 = 10;
        int o4 = 10;
        int o5 = 10;
        Boolean erro;
        
            do {
                do {
                    erro = false;    

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("************************");
                    System.out.println("*****MENU PRINCIPAL*****");
                    System.out.println("************************");
                    System.out.println("1 - Cadastro de produto. ");
                    System.out.println("2 - Relatórios. ");
                    System.out.println("3 - Registrar venda.");
                    System.out.println("0 - Sair. \n");
                    System.out.print("Opção: ");

                    try {
                        o1 = sc.nextInt();
                        erro = true;


                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("O usuário deve digitar apenas o numéro referente à opção desejada.");
                        System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                        sc.next();

                    }

                    } while (erro == false);
    
            
            if (o1 == 1){
                do {
                    do {                    
                    erro = false;

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("******************************");
                    System.out.println("*****CADASTRO DE PRODUTOS*****");
                    System.out.println("******************************");
                    System.out.println("1 - Consultar. ");
                    System.out.println("2 - Incluir");
                    System.out.println("0 - Voltar \n");
                    System.out.print("Opção: ");
       
                    try {
                        o2 = sc.nextInt();
                        erro = true;
                        
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("O usuário deve digitar apenas o numéro referente à opção desejada.");
                        System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                        sc.next();

                    }
                } while (erro == false);
                


                if(o2 == 1){

                    if(listaProduto.isEmpty()){
                        System.out.println("Não há produtos cadastrados");
                        System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                        sc.next();

                    }

                    else{
                        do {
                            do {
                            erro = false;

                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("******************************");
                            System.out.println("*****CONSULTA DE PRODUTOS*****");
                            System.out.println("******************************");
                            System.out.println("1 - Consultar todos. ");
                            System.out.println("2 - Pesquisa por código.");
                            System.out.println("0 - Voltar \n");
                            System.out.print("Opção: ");
       
                    try {
                        o3 = sc.nextInt();
                        erro = true;
                        
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("O usuário deve digitar apenas o numéro referente à opção desejada.");
                        System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                        sc.next();

                    }
                } while (erro == false);
                        if (o3 == 1) {
                            if(listaProduto.isEmpty()) {
                                System.out.println("Nenhum produto encontrado.");
                                System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                sc.next();
                            }
                            else {
                                System.out.println("\nPRODUTOS\n*********");
                                    for (Produto produto : listaProduto) {
                                        System.out.println(produto);                            
                                    }
                                DoubleSummaryStatistics resumo =

                                    listaProduto.stream().collect(Collectors.summarizingDouble(Produto::getValor));
                                    System.out.printf("\nProduto mais caro: R$%.2f. - Produto mais barato: R$%.2f. - Média de preço dos produtos: R$%.2f.\n", 
                                    resumo.getMax(), resumo.getMin(), resumo.getAverage());

                                System.out.println("\nAperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                sc.next();
                            }
                            
                        }
                        else if (o3 == 2) {
                            System.out.println("Digite o código do produto que deseja buscar: ");
                            String codigo = sc.next();

                            List<Produto> novaLista = listaProduto.stream()
                            .filter(p -> p.getCodigo().equals(codigo)).collect(Collectors.toList());;

                            if(novaLista.isEmpty()) {
                                System.out.println("Nenhum produto encontrado.");
                                System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                sc.next();
                            }

                            else {
                                System.out.println("\nPRODUTOS\n*********");
                                    for (Produto produto : novaLista) {
                                        System.out.println(produto);
                                
                                }
                                System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                sc.next();
                            }
                        }
                        else  if(o3 > 2 || o3 < 0) {
                            System.out.println("Digite o número referente a opção desejada.");
                            System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                            sc.next();
                            }
                         
                        } while (o3 != 0);
                        
                    }
                }

                else if (o2 == 2) {
                    do {
                        erro = false;
                        System.out.println("Qual o código do produto?");
                        String codigo = sc.next();
                            
                        System.out.println("Digite o produto que deseja:");
                        String nome = sc.next();

                        System.out.print("Qual é o valor do produto?\nR$");
                        try {
                            double valor = sc.nextDouble();

                            System.out.println("Qual a quantidade em estoque?");
                            int qtd = sc.nextInt();

                            listaProduto.add(new Produto(codigo, nome, valor, qtd));

                            System.out.println("Produto cadastrado com sucesso, aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                            sc.next();
                            
                            erro = true;
                        } catch (InputMismatchException e) {
                            sc.next();
                            System.out.println("Algum valor foi digitado de maneira inválida, tente novamente. ");
                            System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                            sc.next();
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                        }
                        
                        
                    } while (erro == false);
                    
                }

                else  if(o2 > 2 || o2 < 0) {
                    System.out.println("Digite o número referente a opção desejada.");
                    System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                    sc.next();
                }
                    
                } while (o2 != 0);
                    
                }
                
            
            else if(o1 == 2){
                do {
                    do {
                    erro = false;

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("********************");
                    System.out.println("*****RELATÓRIOS*****");
                    System.out.println("********************");
                    System.out.println("1 - Produtos. ");
                    System.out.println("2 - Vendas.");
                    System.out.println("0 - Voltar \n");
                    System.out.print("Opção: ");
       
                    try {
                        o4 = sc.nextInt();
                        erro = true;
                        
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("O usuário deve digitar apenas o numéro referente à opção desejada.");
                        System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                        sc.next();

                    }
                } while (erro == false);
                    if (o4 == 1) {
                            if(listaProduto.isEmpty()) {
                                System.out.println("Nenhum produto encontrado.");
                                System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                sc.next();
                            }
                            else {
                                System.out.println("\nPRODUTOS\n*********");
                                for (Produto produto : listaProduto) {
                                    System.out.println(produto);
                                }
                                DoubleSummaryStatistics resumo =

                                    listaProduto.stream().collect(Collectors.summarizingDouble(Produto::getValor));
                                    System.out.printf("\nProduto mais caro: R$%.2f. - Produto mais barato: R$%.2f. - Média de preço produtos: R$%.2f.\n", 
                                    resumo.getMax(), resumo.getMin(), resumo.getAverage());

                                System.out.println("\nAperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                sc.next();
                            }
                            
                        }
                    else if (o4 == 2) {
                        do {
                            do {
                                erro = false;

                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("****************");
                                System.out.println("*****VENDAS*****");
                                System.out.println("****************");
                                System.out.println("1 - Todas as vendas. ");
                                System.out.println("2 - Vendas por data.");
                                System.out.println("0 - Voltar \n");
                                System.out.print("Opção: ");
       
                                try {
                                    o5 = sc.nextInt();
                                    erro = true;
                            
                                } catch (InputMismatchException e) {
                                    sc.next();
                                    System.out.println("O usuário deve digitar apenas o numéro referente à opção desejada.");
                                    System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                    sc.next();

                                }
                            } while (erro == false);
                            if (o5 == 1) {
                                if(listaVenda.isEmpty()){
                                    System.out.println("Nenhuma venda foi realizada.");
                                    System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                    sc.next();
                                }
                                else {
                                System.out.println("\nVENDAS\n*******");
                                    for (Venda venda : listaVenda) {
                                        System.out.println(venda);                 
                                    }
                                
                                DoubleSummaryStatistics media =

                                    listaVenda.stream().collect(Collectors.summarizingDouble(Venda::getValorVendido));
                                    System.out.printf("\nValor médio das vendas: R$%.2f.\n", 
                                    media.getAverage());

                                System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                sc.next();                                    
                                }
                            }
                            else if(o5 == 2){
                                do {
                                    if(listaVenda.isEmpty()){
                                        System.out.println("Nenhuma venda foi realizada.");
                                        System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                        sc.next(); 
                                    }
                                    else{
                                        erro = false;

                                        System.out.println("Primeira data (dd/MM/yyyy) para o FILTRO: ");
                                        String data1 = sc.next();
                                        System.out.println("Segunda data (dd/MM/yyyy) para o FILTRO: ");
                                        String data2 = sc.next();
                                        try {
                                            
                                            LocalDate d1 = LocalDate.parse(data1, df);
                                            LocalDate d2 = LocalDate.parse(data2, df);
                                            erro = true;

                                            List<Venda> novalista = listaVenda.stream()
                                            .filter(p -> p.getData().isAfter(d1) && p.getData().isBefore(d2)|| p.getData().equals(d1) && p.getData().isBefore(d2) || p.getData()
                                            .equals(d2) && p.getData().isAfter(d1)) .collect(Collectors.toList());;
                                    
                                            if(novalista.isEmpty()) {
                                                System.out.println("Nenhuma venda no período.");
                                                System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER voltar: ");
                                                sc.next();                            
                                            }                                                                     

                                            else {
                                                System.out.println("\nVENDAS\n*******");
                                                for (Venda venda : novalista) {
                                                    System.out.println(venda);
                                                }
                                            DoubleSummaryStatistics media =

                                                novalista.stream().collect(Collectors.summarizingDouble(Venda::getValorVendido));
                                                System.out.printf("\nValor médio das vendas: R$%.2f.\n", media.getAverage());

                                            System.out.println("\nAperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                            sc.next();
                                            }

                                        } catch (DateTimeParseException e) {
                                            sc.next();
                                            System.out.println("Alguma data digitada foi inválida, tente novamente");
                                            System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                            sc.next();
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                        } 
                                    }
                                         
                                } while (erro == false);
                                                  
                            }
                            else  if(o5 > 2 || o5 < 0) {
                                System.out.println("Digite o número referente a opção desejada.");
                                System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                sc.next();
                            }
                        } while (o5 != 0);

                    }
                    else  if(o4 > 2 || o4 < 0) {
                        System.out.println("Digite o número referente a opção desejada.");
                        System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                        sc.next();
                    }
                } while (o4 != 0);
                
            }
            
            else if (o1 == 3) {
                if(listaProduto.isEmpty()) {
                    System.out.println("Nenhum produto disponível.");
                    System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER voltar: ");
                    sc.next();
                }

                else{
                    System.out.println("Informe o código do produto.");
                    String codigo = sc.next();

                    List<Produto> novaLista = listaProduto.stream()
                    .filter(v -> v .getCodigo().equals(codigo)).collect(Collectors.toList());
                
                    if (novaLista.isEmpty()) {
                        System.out.println("Nenhum produto encontrado.");
                        System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                        sc.next();
                    } else {

                        Produto produto = novaLista.get(0);

                        System.out.printf("Quantos %s(s) deseja?\n", produto.getNome());
                        int qtdVendida = sc.nextInt();
                        do {
                                erro = false;

                                System.out.println("Qual é a data da venda (dd/MM/yyyy)?");
       
                                try {
                                    String data = sc.next();
                        
                                if (qtdVendida > produto.getQtd()){
                                    System.out.printf("A venda não é possível, pois a quantidade em estoque no momento é %d.\n" , produto.getQtd());
                                    System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                    sc.next();
                                }
                                else{
                                    double valorVendido = produto.getValor() * qtdVendida;
                                    Venda venda = new Venda ( LocalDate.parse(data, df), produto, qtdVendida, valorVendido);
                                    listaVenda.add(venda);
                                    produto.setQtd(produto.getQtd() - qtdVendida);
                                    System.out.println("A venda foi realizada com sucesso.");
                                    System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                    sc.next();
                                }
                                erro = true;

                                } catch (DateTimeParseException e) {
                                    sc.next();
                                    System.out.println("Data inválida, tente novamente");
                                    System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                                    sc.next();
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                }
                            } while (erro == false);

                    }
                }    
            }
            else  if(o1 > 3 || o1 < 0) {
                System.out.println("Digite o número referente a opção desejada.");
                System.out.println("Aperte QUALQUER CARACTERE e pressione ENTER para voltar: ");
                sc.next();
            } 
        }while(0 != o1);
        sc.close();
    }
  }


    
