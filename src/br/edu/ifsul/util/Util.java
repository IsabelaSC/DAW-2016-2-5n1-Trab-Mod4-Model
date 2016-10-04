/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

/**
 *
 * @author Isabela
 */
public class Util {

    public static String getMensagemErro(Exception e) {
        while (e.getCause() != null) {
            e = (Exception) e.getCause();
        }
        String retorno = e.getMessage();
        if (retorno.contains("violates foreign key constraint")) {
            retorno = "Registro não pode ser excluido por possuir referência "
                    + "em outros objetos";
        }
        return retorno;
    }
}
