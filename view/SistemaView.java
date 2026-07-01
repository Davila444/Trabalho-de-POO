package view;

import controller.LojaOnline;
import model.Administrador;
import model.Cliente;
import java.util.Scanner;

public class SistemaView {
    
    private LojaOnline loja;
    private Scanner scanner;

    public SistemaView() {
        this.loja = new LojaOnline();
        this.loja.setNome("Super Loja Tech");
        this.scanner = new Scanner(System.in);
    }

    // Aquele loop gigante do menu principal vem para cá!
    public void iniciarSistema() {
        int opcao = 0;
        System.out.println("BEM-VINDO AO SISTEMA: " + loja.getNome());
        // ... while (opcao != 3) { switch, case 1, case 2... }
    }

    // Os métodos menuCliente() e menuAdministrador() também ficam aqui dentro!
} // feito por IA.