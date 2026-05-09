package com.imagoPlay.ProjetoImagoPlay.config;

public class DocumentValidator {
    public static void validarCPF(String cpf){
        if (cpf.length() != 11) {
            throw new RuntimeException("O CPF precisa ter 11 dígitos.");
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            throw new RuntimeException("CPF Inválido: Não são permitidos dígitos repetidos.");
        }

        if(cpf.length() == 11){
            int result = 0;
            int peso = 10;

            for (int i = 0; i < 9; i++) {
                result += (cpf.charAt(i) - '0') * peso;
                peso --;
            }

            int resto = 11 - (result % 11);
            int primeiroDigito = (resto > 9) ? 0 : resto;

            result = 0;
            peso = 11;

            for (int i = 0; i < 10; i++) {
                result += (cpf.charAt(i) - '0') * peso;
                peso--;
            }

            resto = 11 - (result % 11);
            int segundoDigito = (resto > 9) ? 0 : resto;

            int digito1Validacao = cpf.charAt(9) - '0';
            int digito2Validacao = cpf.charAt(10) - '0';

            if(primeiroDigito != digito1Validacao || segundoDigito != digito2Validacao){
                throw new RuntimeException("CPF Inválido");
            }

        }
    }

    public static void validarCNPJ(String cnpj){
        if (cnpj.length() != 14) {
            throw new RuntimeException("O CNPJ precisa ter 14 dígitos.");
        }

        if (cnpj.matches("(\\d)\\1{13}")) {
            throw new RuntimeException("CNPJ Inválido: Não são permitidos dígitos repetidos.");
        }

        int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int primeiroDigito = calcularDigito(cnpj.substring(0, 12), pesos1);

        int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int segundoDigito = calcularDigito(cnpj.substring(0, 13), pesos2);

        int d1 = cnpj.charAt(12) - '0';
        int d2 = cnpj.charAt(13) - '0';

        if (primeiroDigito != d1 || segundoDigito != d2) {
            throw new RuntimeException("CNPJ Inválido");
        }
    }

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            soma += (str.charAt(i) - '0') * peso[peso.length - str.length() + i];
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
}
