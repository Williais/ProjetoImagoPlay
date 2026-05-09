package com.imagoPlay.ProjetoImagoPlay.config;

public class DocumentValidator {
    public void validarCPF(String cpf){
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

    public void validarCNPJ(String cnpj){
        if (cnpj.length() != 14) {
            throw new RuntimeException("O CNPJ precisa ter 14 dígitos.");
        }

        if (cnpj.matches("(\\d)\\1{13}")) {
            throw new RuntimeException("CNPJ Inválido: Não são permitidos dígitos repetidos.");
        }

        int result = 0;
        int peso1 = 10;
        int peso2 = 6;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                result += (cnpj.charAt(j) - '0') * peso2;
                peso2--;
            }
            result += (cnpj.charAt(i) - '0') * peso1;
            peso1--;
        }

        int resto = 11 - (result % 11);
        int penultimoDigito = (resto > 10) ? 0 : resto;

        result = 0;
        peso1 = 10;
        peso2 = 7;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 6; j++) {
                result += (cnpj.charAt(j) - '0') * peso2;
                peso2--;
            }
            result += (cnpj.charAt(i) - '0') * peso1;
            peso1--;
        }

        resto = 13 - (result % 13);
        int ultimoDigito = (resto > 10) ? 0 : resto;

        int cnpjPenultimo = cnpj.charAt(12);
        int cnpjUltimo = cnpj.charAt(13);

        if(cnpjPenultimo != penultimoDigito || cnpjUltimo != ultimoDigito){
            throw new RuntimeException("CNPJ Invalido");
        }

    }
}
