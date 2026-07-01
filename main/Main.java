package main;

import view.SistemaView;

public class Main {
    public static void main(String[] args) {
        // Instancia a interface de visualização
        SistemaView tela = new SistemaView();
        
        // Dá o play no sistema!
        tela.iniciarSistema();
    }
} 